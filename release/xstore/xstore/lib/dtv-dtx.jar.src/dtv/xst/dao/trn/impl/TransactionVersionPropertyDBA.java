/*     */ package dtv.xst.dao.trn.impl;
/*     */ 
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.impl.jdbc.IFiller;
/*     */ import dtv.data2.access.impl.jdbc.IJDBCTableAdapter;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.trn.TransactionVersionPropertyId;
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
/*     */ public class TransactionVersionPropertyDBA
/*     */   implements IJDBCTableAdapter
/*     */ {
/*     */   private static final long serialVersionUID = -926502865L;
/*     */   private Long _organizationId;
/*     */   private Long _retailLocationId;
/*     */   private Date _businessDate;
/*     */   private Long _workstationId;
/*     */   private Long _transactionSequence;
/*     */   private String _propertyCode;
/*     */   private String _type;
/*     */   private String _stringValue;
/*     */   private Date _dateValue;
/*     */   private BigDecimal _decimalValue;
/*     */   private Date _createDate;
/*     */   private String _createUserId;
/*     */   private Date _updateDate;
/*     */   private String _updateUserId;
/*     */   private static final String SELECT_OBJECT = "SELECT t.organization_id, t.rtl_loc_id, t.business_date, t.wkstn_id, t.trans_seq, t.property_code, t.type, t.string_value, t.date_value, t.decimal_value, t.create_date, t.create_user_id, t.update_date, t.update_user_id FROM trn_trans_version_p t";
/*     */   private static final String SELECT_WHERE_OBJECT = " WHERE organization_id = ?  AND rtl_loc_id = ?  AND business_date = ?  AND wkstn_id = ?  AND trans_seq = ?  AND property_code = ?  ";
/*     */   
/*     */   public String getSelect() {
/*  43 */     return getSelectImpl();
/*     */   }
/*     */   
/*     */   private String getSelectImpl() {
/*  47 */     return "SELECT t.organization_id, t.rtl_loc_id, t.business_date, t.wkstn_id, t.trans_seq, t.property_code, t.type, t.string_value, t.date_value, t.decimal_value, t.create_date, t.create_user_id, t.update_date, t.update_user_id FROM trn_trans_version_p t";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectWhere() {
/*  53 */     return " WHERE organization_id = ?  AND rtl_loc_id = ?  AND business_date = ?  AND wkstn_id = ?  AND trans_seq = ?  AND property_code = ?  ";
/*     */   }
/*     */   
/*  56 */   private static final String[] INSERT_OBJECT = new String[] { "INSERT INTO trn_trans_version_p(organization_id, rtl_loc_id, business_date, wkstn_id, trans_seq, property_code, type, string_value, date_value, decimal_value, create_date, create_user_id, update_date, update_user_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" };
/*     */   
/*     */   public String[] getInsert() {
/*  59 */     return INSERT_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getInsertParameters() {
/*  63 */     Object[][] insertParameterObject = { { this._organizationId, this._retailLocationId, this._businessDate, this._workstationId, this._transactionSequence, this._propertyCode, this._type, this._stringValue, this._dateValue, this._decimalValue, this._createDate, this._createUserId, this._updateDate, this._updateUserId } };
/*  64 */     return insertParameterObject;
/*     */   }
/*     */   
/*  67 */   private static final int[][] INSERT_PARAMETER_TYPES_OBJECT = new int[][] { { -5, -5, 91, -5, -5, 12, 12, 12, 91, 3, 91, 12, 91, 12 } };
/*     */   
/*     */   public int[][] getInsertParameterTypes() {
/*  70 */     return INSERT_PARAMETER_TYPES_OBJECT;
/*     */   }
/*     */   
/*  73 */   private static final String[] UPDATE_OBJECT = new String[] { "UPDATE trn_trans_version_p SET type = ?, string_value = ?, date_value = ?, decimal_value = ?, update_date = ?, update_user_id = ?" };
/*     */   
/*     */   public String[] getUpdate() {
/*  76 */     return UPDATE_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getUpdateParameters() {
/*  80 */     Object[][] updateParameterObject = { { this._type, this._stringValue, this._dateValue, this._decimalValue, this._updateDate, this._updateUserId } };
/*  81 */     return updateParameterObject;
/*     */   }
/*     */   
/*  84 */   private static final int[][] UPDATE_PARAMETER_TYPE_OBJECT = new int[][] { { 12, 12, 91, 3, 91, 12 } };
/*     */   public int[][] getUpdateParameterTypes() {
/*  86 */     return UPDATE_PARAMETER_TYPE_OBJECT;
/*     */   }
/*     */   
/*  89 */   private static final String[] DELETE_OBJECT = new String[] { "DELETE FROM trn_trans_version_p" }; private static final String WHERE_OBJECT = " WHERE organization_id = ?  AND rtl_loc_id = ?  AND business_date = ?  AND wkstn_id = ?  AND trans_seq = ?  AND property_code = ?  ";
/*     */   
/*     */   public String[] getDelete() {
/*  92 */     return DELETE_OBJECT;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWhere() {
/*  98 */     return " WHERE organization_id = ?  AND rtl_loc_id = ?  AND business_date = ?  AND wkstn_id = ?  AND trans_seq = ?  AND property_code = ?  ";
/*     */   }
/*     */   public Object[] getWhereParameters() {
/* 101 */     return new Object[] { this._organizationId, this._retailLocationId, this._businessDate, this._workstationId, this._transactionSequence, this._propertyCode };
/*     */   }
/*     */   
/* 104 */   private static final int[] WHERE_PARAMETER_OBJECT = new int[] { -5, -5, 91, -5, -5, 12 };
/*     */   
/*     */   public int[] getWhereParameterTypes() {
/* 107 */     return WHERE_PARAMETER_OBJECT;
/*     */   }
/*     */   public String getTableName() {
/* 110 */     return "trn_trans_version_p";
/*     */   }
/*     */   
/*     */   public IFiller getFiller() {
/* 114 */     return getFillerImpl();
/*     */   }
/*     */   
/*     */   private IFiller getFillerImpl() {
/* 118 */     return new TransactionVersionPropertyFiller(this);
/*     */   }
/*     */   
/*     */   private static class TransactionVersionPropertyFiller
/*     */     implements IFiller {
/*     */     private TransactionVersionPropertyDBA _parent;
/*     */     
/*     */     public TransactionVersionPropertyFiller(TransactionVersionPropertyDBA argParent) {
/* 126 */       this._parent = argParent;
/*     */     }
/*     */ 
/*     */     
/*     */     public void fill(ResultSet argResultSet) throws SQLException {
/* 131 */       long primitiveResult = argResultSet.getLong(1);
/* 132 */       if (primitiveResult != 0L || argResultSet.getObject(1) != null) {
/* 133 */         this._parent._organizationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 139 */       primitiveResult = argResultSet.getLong(2);
/* 140 */       if (primitiveResult != 0L || argResultSet.getObject(2) != null) {
/* 141 */         this._parent._retailLocationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 146 */       Timestamp t3 = argResultSet.getTimestamp(3);
/* 147 */       if (t3 != null) {
/* 148 */         this._parent._businessDate = (Date)new DtvDate(t3.getTime());
/*     */       } else {
/*     */         
/* 151 */         this._parent._businessDate = null;
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/* 156 */       long l1 = argResultSet.getLong(4);
/* 157 */       if (l1 != 0L || argResultSet.getObject(4) != null) {
/* 158 */         this._parent._workstationId = Long.valueOf(l1);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 164 */       l1 = argResultSet.getLong(5);
/* 165 */       if (l1 != 0L || argResultSet.getObject(5) != null) {
/* 166 */         this._parent._transactionSequence = Long.valueOf(l1);
/*     */       }
/*     */ 
/*     */       
/* 170 */       this._parent._propertyCode = argResultSet.getString(6);
/* 171 */       this._parent._type = argResultSet.getString(7);
/* 172 */       this._parent._stringValue = argResultSet.getString(8);
/*     */       
/* 174 */       Timestamp t9 = argResultSet.getTimestamp(9);
/* 175 */       if (t9 != null) {
/* 176 */         this._parent._dateValue = (Date)new DtvDate(t9.getTime());
/*     */       } else {
/*     */         
/* 179 */         this._parent._dateValue = null;
/*     */       } 
/*     */       
/* 182 */       this._parent._decimalValue = argResultSet.getBigDecimal(10);
/*     */       
/* 184 */       Timestamp t11 = argResultSet.getTimestamp(11);
/* 185 */       if (t11 != null) {
/* 186 */         this._parent._createDate = (Date)new DtvDate(t11.getTime());
/*     */       } else {
/*     */         
/* 189 */         this._parent._createDate = null;
/*     */       } 
/*     */       
/* 192 */       this._parent._createUserId = argResultSet.getString(12);
/*     */       
/* 194 */       Timestamp t13 = argResultSet.getTimestamp(13);
/* 195 */       if (t13 != null) {
/* 196 */         this._parent._updateDate = (Date)new DtvDate(t13.getTime());
/*     */       } else {
/*     */         
/* 199 */         this._parent._updateDate = null;
/*     */       } 
/*     */       
/* 202 */       this._parent._updateUserId = argResultSet.getString(14);
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDAO(IDataAccessObject argDAO) {
/* 207 */     argDAO.suppressStateChanges(true);
/* 208 */     TransactionVersionPropertyDAO dao = (TransactionVersionPropertyDAO)argDAO;
/* 209 */     dao.setOrganizationId(this._organizationId);
/* 210 */     dao.setRetailLocationId(this._retailLocationId);
/* 211 */     dao.setBusinessDate(this._businessDate);
/* 212 */     dao.setWorkstationId(this._workstationId);
/* 213 */     dao.setTransactionSequence(this._transactionSequence);
/* 214 */     dao.setPropertyCode(this._propertyCode);
/* 215 */     dao.setType(this._type);
/* 216 */     dao.setStringValue(this._stringValue);
/* 217 */     dao.setDateValue(this._dateValue);
/* 218 */     dao.setDecimalValue(this._decimalValue);
/* 219 */     dao.setCreateDate(this._createDate);
/* 220 */     dao.setCreateUserId(this._createUserId);
/* 221 */     dao.setUpdateDate(this._updateDate);
/* 222 */     dao.setUpdateUserId(this._updateUserId);
/* 223 */     argDAO.suppressStateChanges(false);
/* 224 */     return (IDataAccessObject)dao;
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDefaultDAO() {
/* 228 */     return loadDAO((IDataAccessObject)new TransactionVersionPropertyDAO());
/*     */   }
/*     */   
/*     */   public void fill(IDataAccessObject argDAO) {
/* 232 */     TransactionVersionPropertyDAO dao = (TransactionVersionPropertyDAO)argDAO;
/* 233 */     this._organizationId = dao.getOrganizationId();
/* 234 */     this._retailLocationId = dao.getRetailLocationId();
/* 235 */     this._businessDate = dao.getBusinessDate();
/* 236 */     this._workstationId = dao.getWorkstationId();
/* 237 */     this._transactionSequence = dao.getTransactionSequence();
/* 238 */     this._propertyCode = dao.getPropertyCode();
/* 239 */     this._type = dao.getType();
/* 240 */     this._stringValue = dao.getStringValue();
/* 241 */     this._dateValue = dao.getDateValue();
/* 242 */     this._decimalValue = dao.getDecimalValue();
/* 243 */     this._createDate = dao.getCreateDate();
/* 244 */     this._createUserId = dao.getCreateUserId();
/* 245 */     this._updateDate = dao.getUpdateDate();
/* 246 */     this._updateUserId = dao.getUpdateUserId();
/*     */   }
/*     */   
/*     */   public PreparedStatement writeObjectId(IObjectId argId, PreparedStatement argStatement) throws SQLException {
/* 250 */     TransactionVersionPropertyId id = (TransactionVersionPropertyId)argId;
/* 251 */     argStatement.setLong(1, id.getOrganizationId().longValue());
/* 252 */     argStatement.setLong(2, id.getRetailLocationId().longValue());
/* 253 */     argStatement.setTimestamp(3, new Timestamp(id.getBusinessDate().getTime()));
/* 254 */     argStatement.setLong(4, id.getWorkstationId().longValue());
/* 255 */     argStatement.setLong(5, id.getTransactionSequence().longValue());
/* 256 */     argStatement.setString(6, id.getPropertyCode());
/* 257 */     return argStatement;
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 261 */     TransactionVersionPropertyId id = new TransactionVersionPropertyId();
/* 262 */     id.setOrganizationId(this._organizationId);
/* 263 */     id.setRetailLocationId(this._retailLocationId);
/* 264 */     id.setBusinessDate(this._businessDate);
/* 265 */     id.setWorkstationId(this._workstationId);
/* 266 */     id.setTransactionSequence(this._transactionSequence);
/* 267 */     id.setPropertyCode(this._propertyCode);
/* 268 */     return (IObjectId)id;
/*     */   }
/*     */ 
/*     */   
/*     */   public void fill(IJDBCTableAdapter argAdapter) {}
/*     */ 
/*     */   
/*     */   public boolean isExtensible() {
/* 276 */     return false;
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 280 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\trn\impl\TransactionVersionPropertyDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */