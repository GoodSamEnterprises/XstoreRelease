/*     */ package dtv.xst.dao.xom.impl;
/*     */ 
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.impl.jdbc.IFiller;
/*     */ import dtv.data2.access.impl.jdbc.IJDBCTableAdapter;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.xom.OrderModifierId;
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
/*     */ public class OrderModifierDBA
/*     */   implements IJDBCTableAdapter
/*     */ {
/*     */   private static final long serialVersionUID = 2004742181L;
/*     */   private Long _organizationId;
/*     */   private Long _retailLocationId;
/*     */   private Date _businessDate;
/*     */   private Long _workstationId;
/*     */   private Long _transactionSequence;
/*     */   private Integer _retailTransactionLineItemSequence;
/*     */   private Date _createDate;
/*     */   private String _createUserId;
/*     */   private Date _updateDate;
/*     */   private String _updateUserId;
/*     */   private String _orderId;
/*     */   private String _externalOrderId;
/*     */   private String _orderType;
/*     */   private String _detailType;
/*     */   private Integer _detailSequence;
/*     */   private static final String SELECT_OBJECT = "SELECT t.organization_id, t.rtl_loc_id, t.business_date, t.wkstn_id, t.trans_seq, t.rtrans_lineitm_seq, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.order_id, t.external_order_id, t.order_type, t.detail_type, t.detail_seq FROM xom_order_mod t";
/*     */   private static final String SELECT_WHERE_OBJECT = " WHERE organization_id = ?  AND rtl_loc_id = ?  AND business_date = ?  AND wkstn_id = ?  AND trans_seq = ?  AND rtrans_lineitm_seq = ?  ";
/*     */   
/*     */   public String getSelect() {
/*  44 */     return getSelectImpl();
/*     */   }
/*     */   
/*     */   private String getSelectImpl() {
/*  48 */     return "SELECT t.organization_id, t.rtl_loc_id, t.business_date, t.wkstn_id, t.trans_seq, t.rtrans_lineitm_seq, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.order_id, t.external_order_id, t.order_type, t.detail_type, t.detail_seq FROM xom_order_mod t";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectWhere() {
/*  54 */     return " WHERE organization_id = ?  AND rtl_loc_id = ?  AND business_date = ?  AND wkstn_id = ?  AND trans_seq = ?  AND rtrans_lineitm_seq = ?  ";
/*     */   }
/*     */   
/*  57 */   private static final String[] INSERT_OBJECT = new String[] { "INSERT INTO xom_order_mod(organization_id, rtl_loc_id, business_date, wkstn_id, trans_seq, rtrans_lineitm_seq, create_date, create_user_id, update_date, update_user_id, order_id, external_order_id, order_type, detail_type, detail_seq) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" };
/*     */   
/*     */   public String[] getInsert() {
/*  60 */     return INSERT_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getInsertParameters() {
/*  64 */     Object[][] insertParameterObject = { { this._organizationId, this._retailLocationId, this._businessDate, this._workstationId, this._transactionSequence, this._retailTransactionLineItemSequence, this._createDate, this._createUserId, this._updateDate, this._updateUserId, this._orderId, this._externalOrderId, this._orderType, this._detailType, this._detailSequence } };
/*  65 */     return insertParameterObject;
/*     */   }
/*     */   
/*  68 */   private static final int[][] INSERT_PARAMETER_TYPES_OBJECT = new int[][] { { -5, -5, 91, -5, -5, 4, 91, 12, 91, 12, 12, 12, 12, 12, 4 } };
/*     */   
/*     */   public int[][] getInsertParameterTypes() {
/*  71 */     return INSERT_PARAMETER_TYPES_OBJECT;
/*     */   }
/*     */   
/*  74 */   private static final String[] UPDATE_OBJECT = new String[] { "UPDATE xom_order_mod SET update_date = ?, update_user_id = ?, order_id = ?, external_order_id = ?, order_type = ?, detail_type = ?, detail_seq = ?" };
/*     */   
/*     */   public String[] getUpdate() {
/*  77 */     return UPDATE_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getUpdateParameters() {
/*  81 */     Object[][] updateParameterObject = { { this._updateDate, this._updateUserId, this._orderId, this._externalOrderId, this._orderType, this._detailType, this._detailSequence } };
/*  82 */     return updateParameterObject;
/*     */   }
/*     */   
/*  85 */   private static final int[][] UPDATE_PARAMETER_TYPE_OBJECT = new int[][] { { 91, 12, 12, 12, 12, 12, 4 } };
/*     */   public int[][] getUpdateParameterTypes() {
/*  87 */     return UPDATE_PARAMETER_TYPE_OBJECT;
/*     */   }
/*     */   
/*  90 */   private static final String[] DELETE_OBJECT = new String[] { "DELETE FROM xom_order_mod" }; private static final String WHERE_OBJECT = " WHERE organization_id = ?  AND rtl_loc_id = ?  AND business_date = ?  AND wkstn_id = ?  AND trans_seq = ?  AND rtrans_lineitm_seq = ?  ";
/*     */   
/*     */   public String[] getDelete() {
/*  93 */     return DELETE_OBJECT;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWhere() {
/*  99 */     return " WHERE organization_id = ?  AND rtl_loc_id = ?  AND business_date = ?  AND wkstn_id = ?  AND trans_seq = ?  AND rtrans_lineitm_seq = ?  ";
/*     */   }
/*     */   public Object[] getWhereParameters() {
/* 102 */     return new Object[] { this._organizationId, this._retailLocationId, this._businessDate, this._workstationId, this._transactionSequence, this._retailTransactionLineItemSequence };
/*     */   }
/*     */   
/* 105 */   private static final int[] WHERE_PARAMETER_OBJECT = new int[] { -5, -5, 91, -5, -5, 4 };
/*     */   
/*     */   public int[] getWhereParameterTypes() {
/* 108 */     return WHERE_PARAMETER_OBJECT;
/*     */   }
/*     */   public String getTableName() {
/* 111 */     return "xom_order_mod";
/*     */   }
/*     */   
/*     */   public IFiller getFiller() {
/* 115 */     return getFillerImpl();
/*     */   }
/*     */   
/*     */   private IFiller getFillerImpl() {
/* 119 */     return new OrderModifierFiller(this);
/*     */   }
/*     */   
/*     */   private static class OrderModifierFiller
/*     */     implements IFiller {
/*     */     private OrderModifierDBA _parent;
/*     */     
/*     */     public OrderModifierFiller(OrderModifierDBA argParent) {
/* 127 */       this._parent = argParent;
/*     */     }
/*     */ 
/*     */     
/*     */     public void fill(ResultSet argResultSet) throws SQLException {
/* 132 */       long primitiveResult = argResultSet.getLong(1);
/* 133 */       if (primitiveResult != 0L || argResultSet.getObject(1) != null) {
/* 134 */         this._parent._organizationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 140 */       primitiveResult = argResultSet.getLong(2);
/* 141 */       if (primitiveResult != 0L || argResultSet.getObject(2) != null) {
/* 142 */         this._parent._retailLocationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 147 */       Timestamp t3 = argResultSet.getTimestamp(3);
/* 148 */       if (t3 != null) {
/* 149 */         this._parent._businessDate = (Date)new DtvDate(t3.getTime());
/*     */       } else {
/*     */         
/* 152 */         this._parent._businessDate = null;
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/* 157 */       long l1 = argResultSet.getLong(4);
/* 158 */       if (l1 != 0L || argResultSet.getObject(4) != null) {
/* 159 */         this._parent._workstationId = Long.valueOf(l1);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 165 */       l1 = argResultSet.getLong(5);
/* 166 */       if (l1 != 0L || argResultSet.getObject(5) != null) {
/* 167 */         this._parent._transactionSequence = Long.valueOf(l1);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 173 */       int i = argResultSet.getInt(6);
/* 174 */       if (i != 0 || argResultSet.getObject(6) != null) {
/* 175 */         this._parent._retailTransactionLineItemSequence = Integer.valueOf(i);
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 180 */       Timestamp t7 = argResultSet.getTimestamp(7);
/* 181 */       if (t7 != null) {
/* 182 */         this._parent._createDate = (Date)new DtvDate(t7.getTime());
/*     */       } else {
/*     */         
/* 185 */         this._parent._createDate = null;
/*     */       } 
/*     */       
/* 188 */       this._parent._createUserId = argResultSet.getString(8);
/*     */       
/* 190 */       Timestamp t9 = argResultSet.getTimestamp(9);
/* 191 */       if (t9 != null) {
/* 192 */         this._parent._updateDate = (Date)new DtvDate(t9.getTime());
/*     */       } else {
/*     */         
/* 195 */         this._parent._updateDate = null;
/*     */       } 
/*     */       
/* 198 */       this._parent._updateUserId = argResultSet.getString(10);
/* 199 */       this._parent._orderId = argResultSet.getString(11);
/* 200 */       this._parent._externalOrderId = argResultSet.getString(12);
/* 201 */       this._parent._orderType = argResultSet.getString(13);
/* 202 */       this._parent._detailType = argResultSet.getString(14);
/*     */ 
/*     */       
/* 205 */       int j = argResultSet.getInt(15);
/* 206 */       if (j != 0 || argResultSet.getObject(15) != null) {
/* 207 */         this._parent._detailSequence = Integer.valueOf(j);
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IDataAccessObject loadDAO(IDataAccessObject argDAO) {
/* 215 */     argDAO.suppressStateChanges(true);
/* 216 */     OrderModifierDAO dao = (OrderModifierDAO)argDAO;
/* 217 */     dao.setOrganizationId(this._organizationId);
/* 218 */     dao.setRetailLocationId(this._retailLocationId);
/* 219 */     dao.setBusinessDate(this._businessDate);
/* 220 */     dao.setWorkstationId(this._workstationId);
/* 221 */     dao.setTransactionSequence(this._transactionSequence);
/* 222 */     dao.setRetailTransactionLineItemSequence(this._retailTransactionLineItemSequence);
/* 223 */     dao.setCreateDate(this._createDate);
/* 224 */     dao.setCreateUserId(this._createUserId);
/* 225 */     dao.setUpdateDate(this._updateDate);
/* 226 */     dao.setUpdateUserId(this._updateUserId);
/* 227 */     dao.setOrderId(this._orderId);
/* 228 */     dao.setExternalOrderId(this._externalOrderId);
/* 229 */     dao.setOrderType(this._orderType);
/* 230 */     dao.setDetailType(this._detailType);
/* 231 */     dao.setDetailSequence(this._detailSequence);
/* 232 */     argDAO.suppressStateChanges(false);
/* 233 */     return (IDataAccessObject)dao;
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDefaultDAO() {
/* 237 */     return loadDAO((IDataAccessObject)new OrderModifierDAO());
/*     */   }
/*     */   
/*     */   public void fill(IDataAccessObject argDAO) {
/* 241 */     OrderModifierDAO dao = (OrderModifierDAO)argDAO;
/* 242 */     this._organizationId = dao.getOrganizationId();
/* 243 */     this._retailLocationId = dao.getRetailLocationId();
/* 244 */     this._businessDate = dao.getBusinessDate();
/* 245 */     this._workstationId = dao.getWorkstationId();
/* 246 */     this._transactionSequence = dao.getTransactionSequence();
/* 247 */     this._retailTransactionLineItemSequence = dao.getRetailTransactionLineItemSequence();
/* 248 */     this._createDate = dao.getCreateDate();
/* 249 */     this._createUserId = dao.getCreateUserId();
/* 250 */     this._updateDate = dao.getUpdateDate();
/* 251 */     this._updateUserId = dao.getUpdateUserId();
/* 252 */     this._orderId = dao.getOrderId();
/* 253 */     this._externalOrderId = dao.getExternalOrderId();
/* 254 */     this._orderType = dao.getOrderType();
/* 255 */     this._detailType = dao.getDetailType();
/* 256 */     this._detailSequence = dao.getDetailSequence();
/*     */   }
/*     */   
/*     */   public PreparedStatement writeObjectId(IObjectId argId, PreparedStatement argStatement) throws SQLException {
/* 260 */     OrderModifierId id = (OrderModifierId)argId;
/* 261 */     argStatement.setLong(1, id.getOrganizationId().longValue());
/* 262 */     argStatement.setLong(2, id.getRetailLocationId().longValue());
/* 263 */     argStatement.setTimestamp(3, new Timestamp(id.getBusinessDate().getTime()));
/* 264 */     argStatement.setLong(4, id.getWorkstationId().longValue());
/* 265 */     argStatement.setLong(5, id.getTransactionSequence().longValue());
/* 266 */     argStatement.setInt(6, id.getRetailTransactionLineItemSequence().intValue());
/* 267 */     return argStatement;
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 271 */     OrderModifierId id = new OrderModifierId();
/* 272 */     id.setOrganizationId(this._organizationId);
/* 273 */     id.setRetailLocationId(this._retailLocationId);
/* 274 */     id.setBusinessDate(this._businessDate);
/* 275 */     id.setWorkstationId(this._workstationId);
/* 276 */     id.setTransactionSequence(this._transactionSequence);
/* 277 */     id.setRetailTransactionLineItemSequence(this._retailTransactionLineItemSequence);
/* 278 */     return (IObjectId)id;
/*     */   }
/*     */ 
/*     */   
/*     */   public void fill(IJDBCTableAdapter argAdapter) {}
/*     */ 
/*     */   
/*     */   public boolean isExtensible() {
/* 286 */     return false;
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 290 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\xom\impl\OrderModifierDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */