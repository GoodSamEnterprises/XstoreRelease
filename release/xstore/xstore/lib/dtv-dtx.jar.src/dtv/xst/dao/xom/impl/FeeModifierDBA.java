/*     */ package dtv.xst.dao.xom.impl;
/*     */ 
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.impl.jdbc.IFiller;
/*     */ import dtv.data2.access.impl.jdbc.IJDBCTableAdapter;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.xom.FeeModifierId;
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
/*     */ public class FeeModifierDBA
/*     */   implements IJDBCTableAdapter
/*     */ {
/*     */   private static final long serialVersionUID = 1974252637L;
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
/*     */   private BigDecimal _taxAmount;
/*     */   private Boolean _void;
/*     */   private static final String SELECT_OBJECT = "SELECT t.organization_id, t.order_id, t.detail_seq, t.mod_seq, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.typcode, t.amount, t.tax_amount, t.void_flag FROM xom_fee_mod t";
/*     */   private static final String SELECT_WHERE_OBJECT = " WHERE organization_id = ?  AND order_id = ?  AND detail_seq = ?  AND mod_seq = ?  ";
/*     */   
/*     */   public String getSelect() {
/*  41 */     return getSelectImpl();
/*     */   }
/*     */   
/*     */   private String getSelectImpl() {
/*  45 */     return "SELECT t.organization_id, t.order_id, t.detail_seq, t.mod_seq, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.typcode, t.amount, t.tax_amount, t.void_flag FROM xom_fee_mod t";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectWhere() {
/*  51 */     return " WHERE organization_id = ?  AND order_id = ?  AND detail_seq = ?  AND mod_seq = ?  ";
/*     */   }
/*     */   
/*  54 */   private static final String[] INSERT_OBJECT = new String[] { "INSERT INTO xom_fee_mod(organization_id, order_id, detail_seq, mod_seq, create_date, create_user_id, update_date, update_user_id, typcode, amount, tax_amount, void_flag) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" };
/*     */   
/*     */   public String[] getInsert() {
/*  57 */     return INSERT_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getInsertParameters() {
/*  61 */     Object[][] insertParameterObject = { { this._organizationId, this._orderId, this._sequence, this._modSequence, this._createDate, this._createUserId, this._updateDate, this._updateUserId, this._typeCode, this._amount, this._taxAmount, this._void } };
/*  62 */     return insertParameterObject;
/*     */   }
/*     */   
/*  65 */   private static final int[][] INSERT_PARAMETER_TYPES_OBJECT = new int[][] { { -5, 12, 4, 4, 91, 12, 91, 12, 12, 3, 3, -7 } };
/*     */   
/*     */   public int[][] getInsertParameterTypes() {
/*  68 */     return INSERT_PARAMETER_TYPES_OBJECT;
/*     */   }
/*     */   
/*  71 */   private static final String[] UPDATE_OBJECT = new String[] { "UPDATE xom_fee_mod SET update_date = ?, update_user_id = ?, typcode = ?, amount = ?, tax_amount = ?, void_flag = ?" };
/*     */   
/*     */   public String[] getUpdate() {
/*  74 */     return UPDATE_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getUpdateParameters() {
/*  78 */     Object[][] updateParameterObject = { { this._updateDate, this._updateUserId, this._typeCode, this._amount, this._taxAmount, this._void } };
/*  79 */     return updateParameterObject;
/*     */   }
/*     */   
/*  82 */   private static final int[][] UPDATE_PARAMETER_TYPE_OBJECT = new int[][] { { 91, 12, 12, 3, 3, -7 } };
/*     */   public int[][] getUpdateParameterTypes() {
/*  84 */     return UPDATE_PARAMETER_TYPE_OBJECT;
/*     */   }
/*     */   
/*  87 */   private static final String[] DELETE_OBJECT = new String[] { "DELETE FROM xom_fee_mod" }; private static final String WHERE_OBJECT = " WHERE organization_id = ?  AND order_id = ?  AND detail_seq = ?  AND mod_seq = ?  ";
/*     */   
/*     */   public String[] getDelete() {
/*  90 */     return DELETE_OBJECT;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWhere() {
/*  96 */     return " WHERE organization_id = ?  AND order_id = ?  AND detail_seq = ?  AND mod_seq = ?  ";
/*     */   }
/*     */   public Object[] getWhereParameters() {
/*  99 */     return new Object[] { this._organizationId, this._orderId, this._sequence, this._modSequence };
/*     */   }
/*     */   
/* 102 */   private static final int[] WHERE_PARAMETER_OBJECT = new int[] { -5, 12, 4, 4 };
/*     */   
/*     */   public int[] getWhereParameterTypes() {
/* 105 */     return WHERE_PARAMETER_OBJECT;
/*     */   }
/*     */   public String getTableName() {
/* 108 */     return "xom_fee_mod";
/*     */   }
/*     */   
/*     */   public IFiller getFiller() {
/* 112 */     return getFillerImpl();
/*     */   }
/*     */   
/*     */   private IFiller getFillerImpl() {
/* 116 */     return new FeeModifierFiller(this);
/*     */   }
/*     */   
/*     */   private static class FeeModifierFiller
/*     */     implements IFiller {
/*     */     private FeeModifierDBA _parent;
/*     */     
/*     */     public FeeModifierFiller(FeeModifierDBA argParent) {
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
/*     */       
/* 146 */       primitiveResult = argResultSet.getInt(4);
/* 147 */       if (primitiveResult != 0 || argResultSet.getObject(4) != null) {
/* 148 */         this._parent._modSequence = Integer.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 153 */       Timestamp t5 = argResultSet.getTimestamp(5);
/* 154 */       if (t5 != null) {
/* 155 */         this._parent._createDate = (Date)new DtvDate(t5.getTime());
/*     */       } else {
/*     */         
/* 158 */         this._parent._createDate = null;
/*     */       } 
/*     */       
/* 161 */       this._parent._createUserId = argResultSet.getString(6);
/*     */       
/* 163 */       Timestamp t7 = argResultSet.getTimestamp(7);
/* 164 */       if (t7 != null) {
/* 165 */         this._parent._updateDate = (Date)new DtvDate(t7.getTime());
/*     */       } else {
/*     */         
/* 168 */         this._parent._updateDate = null;
/*     */       } 
/*     */       
/* 171 */       this._parent._updateUserId = argResultSet.getString(8);
/* 172 */       this._parent._typeCode = argResultSet.getString(9);
/* 173 */       this._parent._amount = argResultSet.getBigDecimal(10);
/* 174 */       this._parent._taxAmount = argResultSet.getBigDecimal(11);
/* 175 */       this._parent._void = Boolean.valueOf(argResultSet.getBoolean(12));
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDAO(IDataAccessObject argDAO) {
/* 180 */     argDAO.suppressStateChanges(true);
/* 181 */     FeeModifierDAO dao = (FeeModifierDAO)argDAO;
/* 182 */     dao.setOrganizationId(this._organizationId);
/* 183 */     dao.setOrderId(this._orderId);
/* 184 */     dao.setSequence(this._sequence);
/* 185 */     dao.setModSequence(this._modSequence);
/* 186 */     dao.setCreateDate(this._createDate);
/* 187 */     dao.setCreateUserId(this._createUserId);
/* 188 */     dao.setUpdateDate(this._updateDate);
/* 189 */     dao.setUpdateUserId(this._updateUserId);
/* 190 */     dao.setTypeCode(this._typeCode);
/* 191 */     dao.setAmount(this._amount);
/* 192 */     dao.setTaxAmount(this._taxAmount);
/* 193 */     dao.setVoid(this._void);
/* 194 */     argDAO.suppressStateChanges(false);
/* 195 */     return (IDataAccessObject)dao;
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDefaultDAO() {
/* 199 */     return loadDAO((IDataAccessObject)new FeeModifierDAO());
/*     */   }
/*     */   
/*     */   public void fill(IDataAccessObject argDAO) {
/* 203 */     FeeModifierDAO dao = (FeeModifierDAO)argDAO;
/* 204 */     this._organizationId = dao.getOrganizationId();
/* 205 */     this._orderId = dao.getOrderId();
/* 206 */     this._sequence = dao.getSequence();
/* 207 */     this._modSequence = dao.getModSequence();
/* 208 */     this._createDate = dao.getCreateDate();
/* 209 */     this._createUserId = dao.getCreateUserId();
/* 210 */     this._updateDate = dao.getUpdateDate();
/* 211 */     this._updateUserId = dao.getUpdateUserId();
/* 212 */     this._typeCode = dao.getTypeCode();
/* 213 */     this._amount = dao.getAmount();
/* 214 */     this._taxAmount = dao.getTaxAmount();
/* 215 */     this._void = (dao.getVoid() != null) ? dao.getVoid() : Boolean.valueOf(false);
/*     */   }
/*     */   
/*     */   public PreparedStatement writeObjectId(IObjectId argId, PreparedStatement argStatement) throws SQLException {
/* 219 */     FeeModifierId id = (FeeModifierId)argId;
/* 220 */     argStatement.setLong(1, id.getOrganizationId().longValue());
/* 221 */     argStatement.setString(2, id.getOrderId());
/* 222 */     argStatement.setInt(3, id.getSequence().intValue());
/* 223 */     argStatement.setInt(4, id.getModSequence().intValue());
/* 224 */     return argStatement;
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 228 */     FeeModifierId id = new FeeModifierId();
/* 229 */     id.setOrganizationId(this._organizationId);
/* 230 */     id.setOrderId(this._orderId);
/* 231 */     id.setSequence(this._sequence);
/* 232 */     id.setModSequence(this._modSequence);
/* 233 */     return (IObjectId)id;
/*     */   }
/*     */ 
/*     */   
/*     */   public void fill(IJDBCTableAdapter argAdapter) {}
/*     */ 
/*     */   
/*     */   public boolean isExtensible() {
/* 241 */     return false;
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 245 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\xom\impl\FeeModifierDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */