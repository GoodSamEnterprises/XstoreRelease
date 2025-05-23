/*     */ package dtv.xst.dao.xom.impl;
/*     */ 
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.impl.jdbc.IFiller;
/*     */ import dtv.data2.access.impl.jdbc.IJDBCTableAdapter;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.xom.OrderPaymentId;
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
/*     */ public class OrderPaymentDBA
/*     */   implements IJDBCTableAdapter
/*     */ {
/*     */   private static final long serialVersionUID = 267674360L;
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
/*     */   private Boolean _void;
/*     */   private static final String SELECT_OBJECT = "SELECT t.organization_id, t.order_id, t.sequence, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.typcode, t.item_id, t.amount, t.void_flag FROM xom_order_payment t";
/*     */   private static final String SELECT_WHERE_OBJECT = " WHERE organization_id = ?  AND order_id = ?  AND sequence = ?  ";
/*     */   
/*     */   public String getSelect() {
/*  40 */     return getSelectImpl();
/*     */   }
/*     */   
/*     */   private String getSelectImpl() {
/*  44 */     return "SELECT t.organization_id, t.order_id, t.sequence, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.typcode, t.item_id, t.amount, t.void_flag FROM xom_order_payment t";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectWhere() {
/*  50 */     return " WHERE organization_id = ?  AND order_id = ?  AND sequence = ?  ";
/*     */   }
/*     */   
/*  53 */   private static final String[] INSERT_OBJECT = new String[] { "INSERT INTO xom_order_payment(organization_id, order_id, sequence, create_date, create_user_id, update_date, update_user_id, typcode, item_id, amount, void_flag) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" };
/*     */   
/*     */   public String[] getInsert() {
/*  56 */     return INSERT_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getInsertParameters() {
/*  60 */     Object[][] insertParameterObject = { { this._organizationId, this._orderId, this._sequence, this._createDate, this._createUserId, this._updateDate, this._updateUserId, this._typeCode, this._itemId, this._amount, this._void } };
/*  61 */     return insertParameterObject;
/*     */   }
/*     */   
/*  64 */   private static final int[][] INSERT_PARAMETER_TYPES_OBJECT = new int[][] { { -5, 12, 4, 91, 12, 91, 12, 12, 12, 3, -7 } };
/*     */   
/*     */   public int[][] getInsertParameterTypes() {
/*  67 */     return INSERT_PARAMETER_TYPES_OBJECT;
/*     */   }
/*     */   
/*  70 */   private static final String[] UPDATE_OBJECT = new String[] { "UPDATE xom_order_payment SET update_date = ?, update_user_id = ?, typcode = ?, item_id = ?, amount = ?, void_flag = ?" };
/*     */   
/*     */   public String[] getUpdate() {
/*  73 */     return UPDATE_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getUpdateParameters() {
/*  77 */     Object[][] updateParameterObject = { { this._updateDate, this._updateUserId, this._typeCode, this._itemId, this._amount, this._void } };
/*  78 */     return updateParameterObject;
/*     */   }
/*     */   
/*  81 */   private static final int[][] UPDATE_PARAMETER_TYPE_OBJECT = new int[][] { { 91, 12, 12, 12, 3, -7 } };
/*     */   public int[][] getUpdateParameterTypes() {
/*  83 */     return UPDATE_PARAMETER_TYPE_OBJECT;
/*     */   }
/*     */   
/*  86 */   private static final String[] DELETE_OBJECT = new String[] { "DELETE FROM xom_order_payment" }; private static final String WHERE_OBJECT = " WHERE organization_id = ?  AND order_id = ?  AND sequence = ?  ";
/*     */   
/*     */   public String[] getDelete() {
/*  89 */     return DELETE_OBJECT;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWhere() {
/*  95 */     return " WHERE organization_id = ?  AND order_id = ?  AND sequence = ?  ";
/*     */   }
/*     */   public Object[] getWhereParameters() {
/*  98 */     return new Object[] { this._organizationId, this._orderId, this._sequence };
/*     */   }
/*     */   
/* 101 */   private static final int[] WHERE_PARAMETER_OBJECT = new int[] { -5, 12, 4 };
/*     */   
/*     */   public int[] getWhereParameterTypes() {
/* 104 */     return WHERE_PARAMETER_OBJECT;
/*     */   }
/*     */   public String getTableName() {
/* 107 */     return "xom_order_payment";
/*     */   }
/*     */   
/*     */   public IFiller getFiller() {
/* 111 */     return getFillerImpl();
/*     */   }
/*     */   
/*     */   private IFiller getFillerImpl() {
/* 115 */     return new OrderPaymentFiller(this);
/*     */   }
/*     */   
/*     */   private static class OrderPaymentFiller
/*     */     implements IFiller {
/*     */     private OrderPaymentDBA _parent;
/*     */     
/*     */     public OrderPaymentFiller(OrderPaymentDBA argParent) {
/* 123 */       this._parent = argParent;
/*     */     }
/*     */ 
/*     */     
/*     */     public void fill(ResultSet argResultSet) throws SQLException {
/* 128 */       long l = argResultSet.getLong(1);
/* 129 */       if (l != 0L || argResultSet.getObject(1) != null) {
/* 130 */         this._parent._organizationId = Long.valueOf(l);
/*     */       }
/*     */ 
/*     */       
/* 134 */       this._parent._orderId = argResultSet.getString(2);
/*     */ 
/*     */       
/* 137 */       int primitiveResult = argResultSet.getInt(3);
/* 138 */       if (primitiveResult != 0 || argResultSet.getObject(3) != null) {
/* 139 */         this._parent._sequence = Integer.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 144 */       Timestamp t4 = argResultSet.getTimestamp(4);
/* 145 */       if (t4 != null) {
/* 146 */         this._parent._createDate = (Date)new DtvDate(t4.getTime());
/*     */       } else {
/*     */         
/* 149 */         this._parent._createDate = null;
/*     */       } 
/*     */       
/* 152 */       this._parent._createUserId = argResultSet.getString(5);
/*     */       
/* 154 */       Timestamp t6 = argResultSet.getTimestamp(6);
/* 155 */       if (t6 != null) {
/* 156 */         this._parent._updateDate = (Date)new DtvDate(t6.getTime());
/*     */       } else {
/*     */         
/* 159 */         this._parent._updateDate = null;
/*     */       } 
/*     */       
/* 162 */       this._parent._updateUserId = argResultSet.getString(7);
/* 163 */       this._parent._typeCode = argResultSet.getString(8);
/* 164 */       this._parent._itemId = argResultSet.getString(9);
/* 165 */       this._parent._amount = argResultSet.getBigDecimal(10);
/* 166 */       this._parent._void = Boolean.valueOf(argResultSet.getBoolean(11));
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDAO(IDataAccessObject argDAO) {
/* 171 */     argDAO.suppressStateChanges(true);
/* 172 */     OrderPaymentDAO dao = (OrderPaymentDAO)argDAO;
/* 173 */     dao.setOrganizationId(this._organizationId);
/* 174 */     dao.setOrderId(this._orderId);
/* 175 */     dao.setSequence(this._sequence);
/* 176 */     dao.setCreateDate(this._createDate);
/* 177 */     dao.setCreateUserId(this._createUserId);
/* 178 */     dao.setUpdateDate(this._updateDate);
/* 179 */     dao.setUpdateUserId(this._updateUserId);
/* 180 */     dao.setTypeCode(this._typeCode);
/* 181 */     dao.setItemId(this._itemId);
/* 182 */     dao.setAmount(this._amount);
/* 183 */     dao.setVoid(this._void);
/* 184 */     argDAO.suppressStateChanges(false);
/* 185 */     return (IDataAccessObject)dao;
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDefaultDAO() {
/* 189 */     return loadDAO((IDataAccessObject)new OrderPaymentDAO());
/*     */   }
/*     */   
/*     */   public void fill(IDataAccessObject argDAO) {
/* 193 */     OrderPaymentDAO dao = (OrderPaymentDAO)argDAO;
/* 194 */     this._organizationId = dao.getOrganizationId();
/* 195 */     this._orderId = dao.getOrderId();
/* 196 */     this._sequence = dao.getSequence();
/* 197 */     this._createDate = dao.getCreateDate();
/* 198 */     this._createUserId = dao.getCreateUserId();
/* 199 */     this._updateDate = dao.getUpdateDate();
/* 200 */     this._updateUserId = dao.getUpdateUserId();
/* 201 */     this._typeCode = dao.getTypeCode();
/* 202 */     this._itemId = dao.getItemId();
/* 203 */     this._amount = dao.getAmount();
/* 204 */     this._void = (dao.getVoid() != null) ? dao.getVoid() : Boolean.valueOf(false);
/*     */   }
/*     */   
/*     */   public PreparedStatement writeObjectId(IObjectId argId, PreparedStatement argStatement) throws SQLException {
/* 208 */     OrderPaymentId id = (OrderPaymentId)argId;
/* 209 */     argStatement.setLong(1, id.getOrganizationId().longValue());
/* 210 */     argStatement.setString(2, id.getOrderId());
/* 211 */     argStatement.setInt(3, id.getSequence().intValue());
/* 212 */     return argStatement;
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 216 */     OrderPaymentId id = new OrderPaymentId();
/* 217 */     id.setOrganizationId(this._organizationId);
/* 218 */     id.setOrderId(this._orderId);
/* 219 */     id.setSequence(this._sequence);
/* 220 */     return (IObjectId)id;
/*     */   }
/*     */ 
/*     */   
/*     */   public void fill(IJDBCTableAdapter argAdapter) {}
/*     */ 
/*     */   
/*     */   public boolean isExtensible() {
/* 228 */     return false;
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 232 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\xom\impl\OrderPaymentDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */