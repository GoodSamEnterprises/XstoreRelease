/*     */ package dtv.xst.dao.xom.impl;
/*     */ 
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.impl.jdbc.IFiller;
/*     */ import dtv.data2.access.impl.jdbc.IJDBCTableAdapter;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.xom.OrderFeeId;
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
/*     */ public class OrderFeeDBA
/*     */   implements IJDBCTableAdapter
/*     */ {
/*     */   private static final long serialVersionUID = 1298924920L;
/*     */   private Long _organizationId;
/*     */   private String _orderId;
/*     */   private Integer _sequence;
/*     */   private Date _createDate;
/*     */   private String _createUserId;
/*     */   private Date _updateDate;
/*     */   private String _updateUserId;
/*     */   private String _typeCode;
/*     */   private String _itemId;
/*     */   private BigDecimal _amount;
/*     */   private BigDecimal _taxAmount;
/*     */   private Boolean _void;
/*     */   private static final String SELECT_OBJECT = "SELECT t.organization_id, t.order_id, t.detail_seq, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.typcode, t.item_id, t.amount, t.tax_amount, t.void_flag FROM xom_order_fee t";
/*     */   private static final String SELECT_WHERE_OBJECT = " WHERE organization_id = ?  AND order_id = ?  AND detail_seq = ?  ";
/*     */   
/*     */   public String getSelect() {
/*  41 */     return getSelectImpl();
/*     */   }
/*     */   
/*     */   private String getSelectImpl() {
/*  45 */     return "SELECT t.organization_id, t.order_id, t.detail_seq, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.typcode, t.item_id, t.amount, t.tax_amount, t.void_flag FROM xom_order_fee t";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectWhere() {
/*  51 */     return " WHERE organization_id = ?  AND order_id = ?  AND detail_seq = ?  ";
/*     */   }
/*     */   
/*  54 */   private static final String[] INSERT_OBJECT = new String[] { "INSERT INTO xom_order_fee(organization_id, order_id, detail_seq, create_date, create_user_id, update_date, update_user_id, typcode, item_id, amount, tax_amount, void_flag) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" };
/*     */   
/*     */   public String[] getInsert() {
/*  57 */     return INSERT_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getInsertParameters() {
/*  61 */     Object[][] insertParameterObject = { { this._organizationId, this._orderId, this._sequence, this._createDate, this._createUserId, this._updateDate, this._updateUserId, this._typeCode, this._itemId, this._amount, this._taxAmount, this._void } };
/*  62 */     return insertParameterObject;
/*     */   }
/*     */   
/*  65 */   private static final int[][] INSERT_PARAMETER_TYPES_OBJECT = new int[][] { { -5, 12, 4, 91, 12, 91, 12, 12, 12, 3, 3, -7 } };
/*     */   
/*     */   public int[][] getInsertParameterTypes() {
/*  68 */     return INSERT_PARAMETER_TYPES_OBJECT;
/*     */   }
/*     */   
/*  71 */   private static final String[] UPDATE_OBJECT = new String[] { "UPDATE xom_order_fee SET update_date = ?, update_user_id = ?, typcode = ?, item_id = ?, amount = ?, tax_amount = ?, void_flag = ?" };
/*     */   
/*     */   public String[] getUpdate() {
/*  74 */     return UPDATE_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getUpdateParameters() {
/*  78 */     Object[][] updateParameterObject = { { this._updateDate, this._updateUserId, this._typeCode, this._itemId, this._amount, this._taxAmount, this._void } };
/*  79 */     return updateParameterObject;
/*     */   }
/*     */   
/*  82 */   private static final int[][] UPDATE_PARAMETER_TYPE_OBJECT = new int[][] { { 91, 12, 12, 12, 3, 3, -7 } };
/*     */   public int[][] getUpdateParameterTypes() {
/*  84 */     return UPDATE_PARAMETER_TYPE_OBJECT;
/*     */   }
/*     */   
/*  87 */   private static final String[] DELETE_OBJECT = new String[] { "DELETE FROM xom_order_fee" }; private static final String WHERE_OBJECT = " WHERE organization_id = ?  AND order_id = ?  AND detail_seq = ?  ";
/*     */   
/*     */   public String[] getDelete() {
/*  90 */     return DELETE_OBJECT;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWhere() {
/*  96 */     return " WHERE organization_id = ?  AND order_id = ?  AND detail_seq = ?  ";
/*     */   }
/*     */   public Object[] getWhereParameters() {
/*  99 */     return new Object[] { this._organizationId, this._orderId, this._sequence };
/*     */   }
/*     */   
/* 102 */   private static final int[] WHERE_PARAMETER_OBJECT = new int[] { -5, 12, 4 };
/*     */   
/*     */   public int[] getWhereParameterTypes() {
/* 105 */     return WHERE_PARAMETER_OBJECT;
/*     */   }
/*     */   public String getTableName() {
/* 108 */     return "xom_order_fee";
/*     */   }
/*     */   
/*     */   public IFiller getFiller() {
/* 112 */     return getFillerImpl();
/*     */   }
/*     */   
/*     */   private IFiller getFillerImpl() {
/* 116 */     return new OrderFeeFiller(this);
/*     */   }
/*     */   
/*     */   private static class OrderFeeFiller
/*     */     implements IFiller {
/*     */     private OrderFeeDBA _parent;
/*     */     
/*     */     public OrderFeeFiller(OrderFeeDBA argParent) {
/* 124 */       this._parent = argParent;
/*     */     }
/*     */ 
/*     */     
/*     */     public void fill(ResultSet argResultSet) throws SQLException {
/* 129 */       long l = argResultSet.getLong(1);
/* 130 */       if (l != 0L || argResultSet.getObject(1) != null) {
/* 131 */         this._parent._organizationId = Long.valueOf(l);
/*     */       }
/*     */ 
/*     */       
/* 135 */       this._parent._orderId = argResultSet.getString(2);
/*     */ 
/*     */       
/* 138 */       int primitiveResult = argResultSet.getInt(3);
/* 139 */       if (primitiveResult != 0 || argResultSet.getObject(3) != null) {
/* 140 */         this._parent._sequence = Integer.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 145 */       Timestamp t4 = argResultSet.getTimestamp(4);
/* 146 */       if (t4 != null) {
/* 147 */         this._parent._createDate = (Date)new DtvDate(t4.getTime());
/*     */       } else {
/*     */         
/* 150 */         this._parent._createDate = null;
/*     */       } 
/*     */       
/* 153 */       this._parent._createUserId = argResultSet.getString(5);
/*     */       
/* 155 */       Timestamp t6 = argResultSet.getTimestamp(6);
/* 156 */       if (t6 != null) {
/* 157 */         this._parent._updateDate = (Date)new DtvDate(t6.getTime());
/*     */       } else {
/*     */         
/* 160 */         this._parent._updateDate = null;
/*     */       } 
/*     */       
/* 163 */       this._parent._updateUserId = argResultSet.getString(7);
/* 164 */       this._parent._typeCode = argResultSet.getString(8);
/* 165 */       this._parent._itemId = argResultSet.getString(9);
/* 166 */       this._parent._amount = argResultSet.getBigDecimal(10);
/* 167 */       this._parent._taxAmount = argResultSet.getBigDecimal(11);
/* 168 */       this._parent._void = Boolean.valueOf(argResultSet.getBoolean(12));
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDAO(IDataAccessObject argDAO) {
/* 173 */     argDAO.suppressStateChanges(true);
/* 174 */     OrderFeeDAO dao = (OrderFeeDAO)argDAO;
/* 175 */     dao.setOrganizationId(this._organizationId);
/* 176 */     dao.setOrderId(this._orderId);
/* 177 */     dao.setSequence(this._sequence);
/* 178 */     dao.setCreateDate(this._createDate);
/* 179 */     dao.setCreateUserId(this._createUserId);
/* 180 */     dao.setUpdateDate(this._updateDate);
/* 181 */     dao.setUpdateUserId(this._updateUserId);
/* 182 */     dao.setTypeCode(this._typeCode);
/* 183 */     dao.setItemId(this._itemId);
/* 184 */     dao.setAmount(this._amount);
/* 185 */     dao.setTaxAmount(this._taxAmount);
/* 186 */     dao.setVoid(this._void);
/* 187 */     argDAO.suppressStateChanges(false);
/* 188 */     return (IDataAccessObject)dao;
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDefaultDAO() {
/* 192 */     return loadDAO((IDataAccessObject)new OrderFeeDAO());
/*     */   }
/*     */   
/*     */   public void fill(IDataAccessObject argDAO) {
/* 196 */     OrderFeeDAO dao = (OrderFeeDAO)argDAO;
/* 197 */     this._organizationId = dao.getOrganizationId();
/* 198 */     this._orderId = dao.getOrderId();
/* 199 */     this._sequence = dao.getSequence();
/* 200 */     this._createDate = dao.getCreateDate();
/* 201 */     this._createUserId = dao.getCreateUserId();
/* 202 */     this._updateDate = dao.getUpdateDate();
/* 203 */     this._updateUserId = dao.getUpdateUserId();
/* 204 */     this._typeCode = dao.getTypeCode();
/* 205 */     this._itemId = dao.getItemId();
/* 206 */     this._amount = dao.getAmount();
/* 207 */     this._taxAmount = dao.getTaxAmount();
/* 208 */     this._void = (dao.getVoid() != null) ? dao.getVoid() : Boolean.valueOf(false);
/*     */   }
/*     */   
/*     */   public PreparedStatement writeObjectId(IObjectId argId, PreparedStatement argStatement) throws SQLException {
/* 212 */     OrderFeeId id = (OrderFeeId)argId;
/* 213 */     argStatement.setLong(1, id.getOrganizationId().longValue());
/* 214 */     argStatement.setString(2, id.getOrderId());
/* 215 */     argStatement.setInt(3, id.getSequence().intValue());
/* 216 */     return argStatement;
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 220 */     OrderFeeId id = new OrderFeeId();
/* 221 */     id.setOrganizationId(this._organizationId);
/* 222 */     id.setOrderId(this._orderId);
/* 223 */     id.setSequence(this._sequence);
/* 224 */     return (IObjectId)id;
/*     */   }
/*     */ 
/*     */   
/*     */   public void fill(IJDBCTableAdapter argAdapter) {}
/*     */ 
/*     */   
/*     */   public boolean isExtensible() {
/* 232 */     return false;
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 236 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\xom\impl\OrderFeeDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */