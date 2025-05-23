/*     */ package dtv.xst.dao.xom.impl;
/*     */ 
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.impl.jdbc.IFiller;
/*     */ import dtv.data2.access.impl.jdbc.IJDBCTableAdapter;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.xom.BalanceModifierId;
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
/*     */ public class BalanceModifierDBA
/*     */   implements IJDBCTableAdapter
/*     */ {
/*     */   private static final long serialVersionUID = 436662707L;
/*     */   private Long _organizationId;
/*     */   private String _orderId;
/*     */   private Integer _sequence;
/*     */   private Integer _modSequence;
/*     */   private Date _createDate;
/*     */   private String _createUserId;
/*     */   private Date _updateDate;
/*     */   private String _updateUserId;
/*     */   private String _typeCode;
/*     */   private BigDecimal _amount;
/*     */   private Boolean _void;
/*     */   private static final String SELECT_OBJECT = "SELECT t.organization_id, t.order_id, t.detail_seq, t.mod_seq, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.typcode, t.amount, t.void_flag FROM xom_balance_mod t";
/*     */   private static final String SELECT_WHERE_OBJECT = " WHERE organization_id = ?  AND order_id = ?  AND detail_seq = ?  AND mod_seq = ?  ";
/*     */   
/*     */   public String getSelect() {
/*  40 */     return getSelectImpl();
/*     */   }
/*     */   
/*     */   private String getSelectImpl() {
/*  44 */     return "SELECT t.organization_id, t.order_id, t.detail_seq, t.mod_seq, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.typcode, t.amount, t.void_flag FROM xom_balance_mod t";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectWhere() {
/*  50 */     return " WHERE organization_id = ?  AND order_id = ?  AND detail_seq = ?  AND mod_seq = ?  ";
/*     */   }
/*     */   
/*  53 */   private static final String[] INSERT_OBJECT = new String[] { "INSERT INTO xom_balance_mod(organization_id, order_id, detail_seq, mod_seq, create_date, create_user_id, update_date, update_user_id, typcode, amount, void_flag) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" };
/*     */   
/*     */   public String[] getInsert() {
/*  56 */     return INSERT_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getInsertParameters() {
/*  60 */     Object[][] insertParameterObject = { { this._organizationId, this._orderId, this._sequence, this._modSequence, this._createDate, this._createUserId, this._updateDate, this._updateUserId, this._typeCode, this._amount, this._void } };
/*  61 */     return insertParameterObject;
/*     */   }
/*     */   
/*  64 */   private static final int[][] INSERT_PARAMETER_TYPES_OBJECT = new int[][] { { -5, 12, 4, 4, 91, 12, 91, 12, 12, 3, -7 } };
/*     */   
/*     */   public int[][] getInsertParameterTypes() {
/*  67 */     return INSERT_PARAMETER_TYPES_OBJECT;
/*     */   }
/*     */   
/*  70 */   private static final String[] UPDATE_OBJECT = new String[] { "UPDATE xom_balance_mod SET update_date = ?, update_user_id = ?, typcode = ?, amount = ?, void_flag = ?" };
/*     */   
/*     */   public String[] getUpdate() {
/*  73 */     return UPDATE_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getUpdateParameters() {
/*  77 */     Object[][] updateParameterObject = { { this._updateDate, this._updateUserId, this._typeCode, this._amount, this._void } };
/*  78 */     return updateParameterObject;
/*     */   }
/*     */   
/*  81 */   private static final int[][] UPDATE_PARAMETER_TYPE_OBJECT = new int[][] { { 91, 12, 12, 3, -7 } };
/*     */   public int[][] getUpdateParameterTypes() {
/*  83 */     return UPDATE_PARAMETER_TYPE_OBJECT;
/*     */   }
/*     */   
/*  86 */   private static final String[] DELETE_OBJECT = new String[] { "DELETE FROM xom_balance_mod" }; private static final String WHERE_OBJECT = " WHERE organization_id = ?  AND order_id = ?  AND detail_seq = ?  AND mod_seq = ?  ";
/*     */   
/*     */   public String[] getDelete() {
/*  89 */     return DELETE_OBJECT;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWhere() {
/*  95 */     return " WHERE organization_id = ?  AND order_id = ?  AND detail_seq = ?  AND mod_seq = ?  ";
/*     */   }
/*     */   public Object[] getWhereParameters() {
/*  98 */     return new Object[] { this._organizationId, this._orderId, this._sequence, this._modSequence };
/*     */   }
/*     */   
/* 101 */   private static final int[] WHERE_PARAMETER_OBJECT = new int[] { -5, 12, 4, 4 };
/*     */   
/*     */   public int[] getWhereParameterTypes() {
/* 104 */     return WHERE_PARAMETER_OBJECT;
/*     */   }
/*     */   public String getTableName() {
/* 107 */     return "xom_balance_mod";
/*     */   }
/*     */   
/*     */   public IFiller getFiller() {
/* 111 */     return getFillerImpl();
/*     */   }
/*     */   
/*     */   private IFiller getFillerImpl() {
/* 115 */     return new BalanceModifierFiller(this);
/*     */   }
/*     */   
/*     */   private static class BalanceModifierFiller
/*     */     implements IFiller {
/*     */     private BalanceModifierDBA _parent;
/*     */     
/*     */     public BalanceModifierFiller(BalanceModifierDBA argParent) {
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
/*     */       
/* 145 */       primitiveResult = argResultSet.getInt(4);
/* 146 */       if (primitiveResult != 0 || argResultSet.getObject(4) != null) {
/* 147 */         this._parent._modSequence = Integer.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 152 */       Timestamp t5 = argResultSet.getTimestamp(5);
/* 153 */       if (t5 != null) {
/* 154 */         this._parent._createDate = (Date)new DtvDate(t5.getTime());
/*     */       } else {
/*     */         
/* 157 */         this._parent._createDate = null;
/*     */       } 
/*     */       
/* 160 */       this._parent._createUserId = argResultSet.getString(6);
/*     */       
/* 162 */       Timestamp t7 = argResultSet.getTimestamp(7);
/* 163 */       if (t7 != null) {
/* 164 */         this._parent._updateDate = (Date)new DtvDate(t7.getTime());
/*     */       } else {
/*     */         
/* 167 */         this._parent._updateDate = null;
/*     */       } 
/*     */       
/* 170 */       this._parent._updateUserId = argResultSet.getString(8);
/* 171 */       this._parent._typeCode = argResultSet.getString(9);
/* 172 */       this._parent._amount = argResultSet.getBigDecimal(10);
/* 173 */       this._parent._void = Boolean.valueOf(argResultSet.getBoolean(11));
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDAO(IDataAccessObject argDAO) {
/* 178 */     argDAO.suppressStateChanges(true);
/* 179 */     BalanceModifierDAO dao = (BalanceModifierDAO)argDAO;
/* 180 */     dao.setOrganizationId(this._organizationId);
/* 181 */     dao.setOrderId(this._orderId);
/* 182 */     dao.setSequence(this._sequence);
/* 183 */     dao.setModSequence(this._modSequence);
/* 184 */     dao.setCreateDate(this._createDate);
/* 185 */     dao.setCreateUserId(this._createUserId);
/* 186 */     dao.setUpdateDate(this._updateDate);
/* 187 */     dao.setUpdateUserId(this._updateUserId);
/* 188 */     dao.setTypeCode(this._typeCode);
/* 189 */     dao.setAmount(this._amount);
/* 190 */     dao.setVoid(this._void);
/* 191 */     argDAO.suppressStateChanges(false);
/* 192 */     return (IDataAccessObject)dao;
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDefaultDAO() {
/* 196 */     return loadDAO((IDataAccessObject)new BalanceModifierDAO());
/*     */   }
/*     */   
/*     */   public void fill(IDataAccessObject argDAO) {
/* 200 */     BalanceModifierDAO dao = (BalanceModifierDAO)argDAO;
/* 201 */     this._organizationId = dao.getOrganizationId();
/* 202 */     this._orderId = dao.getOrderId();
/* 203 */     this._sequence = dao.getSequence();
/* 204 */     this._modSequence = dao.getModSequence();
/* 205 */     this._createDate = dao.getCreateDate();
/* 206 */     this._createUserId = dao.getCreateUserId();
/* 207 */     this._updateDate = dao.getUpdateDate();
/* 208 */     this._updateUserId = dao.getUpdateUserId();
/* 209 */     this._typeCode = dao.getTypeCode();
/* 210 */     this._amount = dao.getAmount();
/* 211 */     this._void = (dao.getVoid() != null) ? dao.getVoid() : Boolean.valueOf(false);
/*     */   }
/*     */   
/*     */   public PreparedStatement writeObjectId(IObjectId argId, PreparedStatement argStatement) throws SQLException {
/* 215 */     BalanceModifierId id = (BalanceModifierId)argId;
/* 216 */     argStatement.setLong(1, id.getOrganizationId().longValue());
/* 217 */     argStatement.setString(2, id.getOrderId());
/* 218 */     argStatement.setInt(3, id.getSequence().intValue());
/* 219 */     argStatement.setInt(4, id.getModSequence().intValue());
/* 220 */     return argStatement;
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 224 */     BalanceModifierId id = new BalanceModifierId();
/* 225 */     id.setOrganizationId(this._organizationId);
/* 226 */     id.setOrderId(this._orderId);
/* 227 */     id.setSequence(this._sequence);
/* 228 */     id.setModSequence(this._modSequence);
/* 229 */     return (IObjectId)id;
/*     */   }
/*     */ 
/*     */   
/*     */   public void fill(IJDBCTableAdapter argAdapter) {}
/*     */ 
/*     */   
/*     */   public boolean isExtensible() {
/* 237 */     return false;
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 241 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\xom\impl\BalanceModifierDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */