/*     */ package dtv.xst.dao.trn.impl;
/*     */ 
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.impl.jdbc.IFiller;
/*     */ import dtv.data2.access.impl.jdbc.IJDBCTableAdapter;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.trn.ReceiptDataPropertyId;
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
/*     */ public class ReceiptDataPropertyDBA
/*     */   implements IJDBCTableAdapter
/*     */ {
/*     */   private static final long serialVersionUID = 2071585239L;
/*     */   private Long _organizationId;
/*     */   private Long _retailLocationId;
/*     */   private Long _workstationId;
/*     */   private Date _businessDate;
/*     */   private Long _transactionSequence;
/*     */   private String _receiptId;
/*     */   private String _propertyCode;
/*     */   private String _type;
/*     */   private String _stringValue;
/*     */   private Date _dateValue;
/*     */   private BigDecimal _decimalValue;
/*     */   private Date _createDate;
/*     */   private String _createUserId;
/*     */   private Date _updateDate;
/*     */   private String _updateUserId;
/*     */   private static final String SELECT_OBJECT = "SELECT t.organization_id, t.rtl_loc_id, t.wkstn_id, t.business_date, t.trans_seq, t.receipt_id, t.property_code, t.type, t.string_value, t.date_value, t.decimal_value, t.create_date, t.create_user_id, t.update_date, t.update_user_id FROM trn_receipt_data_p t";
/*     */   private static final String SELECT_WHERE_OBJECT = " WHERE organization_id = ?  AND rtl_loc_id = ?  AND wkstn_id = ?  AND business_date = ?  AND trans_seq = ?  AND receipt_id = ?  AND property_code = ?  ";
/*     */   
/*     */   public String getSelect() {
/*  44 */     return getSelectImpl();
/*     */   }
/*     */   
/*     */   private String getSelectImpl() {
/*  48 */     return "SELECT t.organization_id, t.rtl_loc_id, t.wkstn_id, t.business_date, t.trans_seq, t.receipt_id, t.property_code, t.type, t.string_value, t.date_value, t.decimal_value, t.create_date, t.create_user_id, t.update_date, t.update_user_id FROM trn_receipt_data_p t";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectWhere() {
/*  54 */     return " WHERE organization_id = ?  AND rtl_loc_id = ?  AND wkstn_id = ?  AND business_date = ?  AND trans_seq = ?  AND receipt_id = ?  AND property_code = ?  ";
/*     */   }
/*     */   
/*  57 */   private static final String[] INSERT_OBJECT = new String[] { "INSERT INTO trn_receipt_data_p(organization_id, rtl_loc_id, wkstn_id, business_date, trans_seq, receipt_id, property_code, type, string_value, date_value, decimal_value, create_date, create_user_id, update_date, update_user_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" };
/*     */   
/*     */   public String[] getInsert() {
/*  60 */     return INSERT_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getInsertParameters() {
/*  64 */     Object[][] insertParameterObject = { { this._organizationId, this._retailLocationId, this._workstationId, this._businessDate, this._transactionSequence, this._receiptId, this._propertyCode, this._type, this._stringValue, this._dateValue, this._decimalValue, this._createDate, this._createUserId, this._updateDate, this._updateUserId } };
/*  65 */     return insertParameterObject;
/*     */   }
/*     */   
/*  68 */   private static final int[][] INSERT_PARAMETER_TYPES_OBJECT = new int[][] { { -5, -5, -5, 91, -5, 12, 12, 12, 12, 91, 3, 91, 12, 91, 12 } };
/*     */   
/*     */   public int[][] getInsertParameterTypes() {
/*  71 */     return INSERT_PARAMETER_TYPES_OBJECT;
/*     */   }
/*     */   
/*  74 */   private static final String[] UPDATE_OBJECT = new String[] { "UPDATE trn_receipt_data_p SET type = ?, string_value = ?, date_value = ?, decimal_value = ?, update_date = ?, update_user_id = ?" };
/*     */   
/*     */   public String[] getUpdate() {
/*  77 */     return UPDATE_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getUpdateParameters() {
/*  81 */     Object[][] updateParameterObject = { { this._type, this._stringValue, this._dateValue, this._decimalValue, this._updateDate, this._updateUserId } };
/*  82 */     return updateParameterObject;
/*     */   }
/*     */   
/*  85 */   private static final int[][] UPDATE_PARAMETER_TYPE_OBJECT = new int[][] { { 12, 12, 91, 3, 91, 12 } };
/*     */   public int[][] getUpdateParameterTypes() {
/*  87 */     return UPDATE_PARAMETER_TYPE_OBJECT;
/*     */   }
/*     */   
/*  90 */   private static final String[] DELETE_OBJECT = new String[] { "DELETE FROM trn_receipt_data_p" }; private static final String WHERE_OBJECT = " WHERE organization_id = ?  AND rtl_loc_id = ?  AND wkstn_id = ?  AND business_date = ?  AND trans_seq = ?  AND receipt_id = ?  AND property_code = ?  ";
/*     */   
/*     */   public String[] getDelete() {
/*  93 */     return DELETE_OBJECT;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWhere() {
/*  99 */     return " WHERE organization_id = ?  AND rtl_loc_id = ?  AND wkstn_id = ?  AND business_date = ?  AND trans_seq = ?  AND receipt_id = ?  AND property_code = ?  ";
/*     */   }
/*     */   public Object[] getWhereParameters() {
/* 102 */     return new Object[] { this._organizationId, this._retailLocationId, this._workstationId, this._businessDate, this._transactionSequence, this._receiptId, this._propertyCode };
/*     */   }
/*     */   
/* 105 */   private static final int[] WHERE_PARAMETER_OBJECT = new int[] { -5, -5, -5, 91, -5, 12, 12 };
/*     */   
/*     */   public int[] getWhereParameterTypes() {
/* 108 */     return WHERE_PARAMETER_OBJECT;
/*     */   }
/*     */   public String getTableName() {
/* 111 */     return "trn_receipt_data_p";
/*     */   }
/*     */   
/*     */   public IFiller getFiller() {
/* 115 */     return getFillerImpl();
/*     */   }
/*     */   
/*     */   private IFiller getFillerImpl() {
/* 119 */     return new ReceiptDataPropertyFiller(this);
/*     */   }
/*     */   
/*     */   private static class ReceiptDataPropertyFiller
/*     */     implements IFiller {
/*     */     private ReceiptDataPropertyDBA _parent;
/*     */     
/*     */     public ReceiptDataPropertyFiller(ReceiptDataPropertyDBA argParent) {
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
/*     */       
/* 148 */       primitiveResult = argResultSet.getLong(3);
/* 149 */       if (primitiveResult != 0L || argResultSet.getObject(3) != null) {
/* 150 */         this._parent._workstationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 155 */       Timestamp t4 = argResultSet.getTimestamp(4);
/* 156 */       if (t4 != null) {
/* 157 */         this._parent._businessDate = (Date)new DtvDate(t4.getTime());
/*     */       } else {
/*     */         
/* 160 */         this._parent._businessDate = null;
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/* 165 */       long l1 = argResultSet.getLong(5);
/* 166 */       if (l1 != 0L || argResultSet.getObject(5) != null) {
/* 167 */         this._parent._transactionSequence = Long.valueOf(l1);
/*     */       }
/*     */ 
/*     */       
/* 171 */       this._parent._receiptId = argResultSet.getString(6);
/* 172 */       this._parent._propertyCode = argResultSet.getString(7);
/* 173 */       this._parent._type = argResultSet.getString(8);
/* 174 */       this._parent._stringValue = argResultSet.getString(9);
/*     */       
/* 176 */       Timestamp t10 = argResultSet.getTimestamp(10);
/* 177 */       if (t10 != null) {
/* 178 */         this._parent._dateValue = (Date)new DtvDate(t10.getTime());
/*     */       } else {
/*     */         
/* 181 */         this._parent._dateValue = null;
/*     */       } 
/*     */       
/* 184 */       this._parent._decimalValue = argResultSet.getBigDecimal(11);
/*     */       
/* 186 */       Timestamp t12 = argResultSet.getTimestamp(12);
/* 187 */       if (t12 != null) {
/* 188 */         this._parent._createDate = (Date)new DtvDate(t12.getTime());
/*     */       } else {
/*     */         
/* 191 */         this._parent._createDate = null;
/*     */       } 
/*     */       
/* 194 */       this._parent._createUserId = argResultSet.getString(13);
/*     */       
/* 196 */       Timestamp t14 = argResultSet.getTimestamp(14);
/* 197 */       if (t14 != null) {
/* 198 */         this._parent._updateDate = (Date)new DtvDate(t14.getTime());
/*     */       } else {
/*     */         
/* 201 */         this._parent._updateDate = null;
/*     */       } 
/*     */       
/* 204 */       this._parent._updateUserId = argResultSet.getString(15);
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDAO(IDataAccessObject argDAO) {
/* 209 */     argDAO.suppressStateChanges(true);
/* 210 */     ReceiptDataPropertyDAO dao = (ReceiptDataPropertyDAO)argDAO;
/* 211 */     dao.setOrganizationId(this._organizationId);
/* 212 */     dao.setRetailLocationId(this._retailLocationId);
/* 213 */     dao.setWorkstationId(this._workstationId);
/* 214 */     dao.setBusinessDate(this._businessDate);
/* 215 */     dao.setTransactionSequence(this._transactionSequence);
/* 216 */     dao.setReceiptId(this._receiptId);
/* 217 */     dao.setPropertyCode(this._propertyCode);
/* 218 */     dao.setType(this._type);
/* 219 */     dao.setStringValue(this._stringValue);
/* 220 */     dao.setDateValue(this._dateValue);
/* 221 */     dao.setDecimalValue(this._decimalValue);
/* 222 */     dao.setCreateDate(this._createDate);
/* 223 */     dao.setCreateUserId(this._createUserId);
/* 224 */     dao.setUpdateDate(this._updateDate);
/* 225 */     dao.setUpdateUserId(this._updateUserId);
/* 226 */     argDAO.suppressStateChanges(false);
/* 227 */     return (IDataAccessObject)dao;
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDefaultDAO() {
/* 231 */     return loadDAO((IDataAccessObject)new ReceiptDataPropertyDAO());
/*     */   }
/*     */   
/*     */   public void fill(IDataAccessObject argDAO) {
/* 235 */     ReceiptDataPropertyDAO dao = (ReceiptDataPropertyDAO)argDAO;
/* 236 */     this._organizationId = dao.getOrganizationId();
/* 237 */     this._retailLocationId = dao.getRetailLocationId();
/* 238 */     this._workstationId = dao.getWorkstationId();
/* 239 */     this._businessDate = dao.getBusinessDate();
/* 240 */     this._transactionSequence = dao.getTransactionSequence();
/* 241 */     this._receiptId = dao.getReceiptId();
/* 242 */     this._propertyCode = dao.getPropertyCode();
/* 243 */     this._type = dao.getType();
/* 244 */     this._stringValue = dao.getStringValue();
/* 245 */     this._dateValue = dao.getDateValue();
/* 246 */     this._decimalValue = dao.getDecimalValue();
/* 247 */     this._createDate = dao.getCreateDate();
/* 248 */     this._createUserId = dao.getCreateUserId();
/* 249 */     this._updateDate = dao.getUpdateDate();
/* 250 */     this._updateUserId = dao.getUpdateUserId();
/*     */   }
/*     */   
/*     */   public PreparedStatement writeObjectId(IObjectId argId, PreparedStatement argStatement) throws SQLException {
/* 254 */     ReceiptDataPropertyId id = (ReceiptDataPropertyId)argId;
/* 255 */     argStatement.setLong(1, id.getOrganizationId().longValue());
/* 256 */     argStatement.setLong(2, id.getRetailLocationId().longValue());
/* 257 */     argStatement.setLong(3, id.getWorkstationId().longValue());
/* 258 */     argStatement.setTimestamp(4, new Timestamp(id.getBusinessDate().getTime()));
/* 259 */     argStatement.setLong(5, id.getTransactionSequence().longValue());
/* 260 */     argStatement.setString(6, id.getReceiptId());
/* 261 */     argStatement.setString(7, id.getPropertyCode());
/* 262 */     return argStatement;
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 266 */     ReceiptDataPropertyId id = new ReceiptDataPropertyId();
/* 267 */     id.setOrganizationId(this._organizationId);
/* 268 */     id.setRetailLocationId(this._retailLocationId);
/* 269 */     id.setWorkstationId(this._workstationId);
/* 270 */     id.setBusinessDate(this._businessDate);
/* 271 */     id.setTransactionSequence(this._transactionSequence);
/* 272 */     id.setReceiptId(this._receiptId);
/* 273 */     id.setPropertyCode(this._propertyCode);
/* 274 */     return (IObjectId)id;
/*     */   }
/*     */ 
/*     */   
/*     */   public void fill(IJDBCTableAdapter argAdapter) {}
/*     */ 
/*     */   
/*     */   public boolean isExtensible() {
/* 282 */     return false;
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 286 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\trn\impl\ReceiptDataPropertyDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */