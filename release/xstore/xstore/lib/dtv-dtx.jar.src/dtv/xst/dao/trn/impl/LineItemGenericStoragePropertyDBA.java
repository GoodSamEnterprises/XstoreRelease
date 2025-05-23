/*     */ package dtv.xst.dao.trn.impl;
/*     */ 
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.impl.jdbc.IFiller;
/*     */ import dtv.data2.access.impl.jdbc.IJDBCTableAdapter;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.trn.LineItemGenericStoragePropertyId;
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
/*     */ public class LineItemGenericStoragePropertyDBA
/*     */   implements IJDBCTableAdapter
/*     */ {
/*     */   private static final long serialVersionUID = -938208064L;
/*     */   private Date _businessDate;
/*     */   private Long _organizationId;
/*     */   private Long _retailLocationId;
/*     */   private Integer _lineItemSequence;
/*     */   private Long _transactionSequence;
/*     */   private Long _workstationId;
/*     */   private String _propertyCode;
/*     */   private String _type;
/*     */   private String _stringValue;
/*     */   private Date _dateValue;
/*     */   private BigDecimal _decimalValue;
/*     */   private Date _createDate;
/*     */   private String _createUserId;
/*     */   private Date _updateDate;
/*     */   private String _updateUserId;
/*     */   private static final String SELECT_OBJECT = "SELECT t.business_date, t.organization_id, t.rtl_loc_id, t.rtrans_lineitm_seq, t.trans_seq, t.wkstn_id, t.property_code, t.type, t.string_value, t.date_value, t.decimal_value, t.create_date, t.create_user_id, t.update_date, t.update_user_id FROM trn_generic_lineitm_storage_p t";
/*     */   private static final String SELECT_WHERE_OBJECT = " WHERE business_date = ?  AND organization_id = ?  AND rtl_loc_id = ?  AND rtrans_lineitm_seq = ?  AND trans_seq = ?  AND wkstn_id = ?  AND property_code = ?  ";
/*     */   
/*     */   public String getSelect() {
/*  44 */     return getSelectImpl();
/*     */   }
/*     */   
/*     */   private String getSelectImpl() {
/*  48 */     return "SELECT t.business_date, t.organization_id, t.rtl_loc_id, t.rtrans_lineitm_seq, t.trans_seq, t.wkstn_id, t.property_code, t.type, t.string_value, t.date_value, t.decimal_value, t.create_date, t.create_user_id, t.update_date, t.update_user_id FROM trn_generic_lineitm_storage_p t";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectWhere() {
/*  54 */     return " WHERE business_date = ?  AND organization_id = ?  AND rtl_loc_id = ?  AND rtrans_lineitm_seq = ?  AND trans_seq = ?  AND wkstn_id = ?  AND property_code = ?  ";
/*     */   }
/*     */   
/*  57 */   private static final String[] INSERT_OBJECT = new String[] { "INSERT INTO trn_generic_lineitm_storage_p(business_date, organization_id, rtl_loc_id, rtrans_lineitm_seq, trans_seq, wkstn_id, property_code, type, string_value, date_value, decimal_value, create_date, create_user_id, update_date, update_user_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" };
/*     */   
/*     */   public String[] getInsert() {
/*  60 */     return INSERT_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getInsertParameters() {
/*  64 */     Object[][] insertParameterObject = { { this._businessDate, this._organizationId, this._retailLocationId, this._lineItemSequence, this._transactionSequence, this._workstationId, this._propertyCode, this._type, this._stringValue, this._dateValue, this._decimalValue, this._createDate, this._createUserId, this._updateDate, this._updateUserId } };
/*  65 */     return insertParameterObject;
/*     */   }
/*     */   
/*  68 */   private static final int[][] INSERT_PARAMETER_TYPES_OBJECT = new int[][] { { 91, -5, -5, 4, -5, -5, 12, 12, 12, 91, 3, 91, 12, 91, 12 } };
/*     */   
/*     */   public int[][] getInsertParameterTypes() {
/*  71 */     return INSERT_PARAMETER_TYPES_OBJECT;
/*     */   }
/*     */   
/*  74 */   private static final String[] UPDATE_OBJECT = new String[] { "UPDATE trn_generic_lineitm_storage_p SET type = ?, string_value = ?, date_value = ?, decimal_value = ?, update_date = ?, update_user_id = ?" };
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
/*  90 */   private static final String[] DELETE_OBJECT = new String[] { "DELETE FROM trn_generic_lineitm_storage_p" }; private static final String WHERE_OBJECT = " WHERE business_date = ?  AND organization_id = ?  AND rtl_loc_id = ?  AND rtrans_lineitm_seq = ?  AND trans_seq = ?  AND wkstn_id = ?  AND property_code = ?  ";
/*     */   
/*     */   public String[] getDelete() {
/*  93 */     return DELETE_OBJECT;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWhere() {
/*  99 */     return " WHERE business_date = ?  AND organization_id = ?  AND rtl_loc_id = ?  AND rtrans_lineitm_seq = ?  AND trans_seq = ?  AND wkstn_id = ?  AND property_code = ?  ";
/*     */   }
/*     */   public Object[] getWhereParameters() {
/* 102 */     return new Object[] { this._businessDate, this._organizationId, this._retailLocationId, this._lineItemSequence, this._transactionSequence, this._workstationId, this._propertyCode };
/*     */   }
/*     */   
/* 105 */   private static final int[] WHERE_PARAMETER_OBJECT = new int[] { 91, -5, -5, 4, -5, -5, 12 };
/*     */   
/*     */   public int[] getWhereParameterTypes() {
/* 108 */     return WHERE_PARAMETER_OBJECT;
/*     */   }
/*     */   public String getTableName() {
/* 111 */     return "trn_generic_lineitm_storage_p";
/*     */   }
/*     */   
/*     */   public IFiller getFiller() {
/* 115 */     return getFillerImpl();
/*     */   }
/*     */   
/*     */   private IFiller getFillerImpl() {
/* 119 */     return new LineItemGenericStoragePropertyFiller(this);
/*     */   }
/*     */   
/*     */   private static class LineItemGenericStoragePropertyFiller
/*     */     implements IFiller {
/*     */     private LineItemGenericStoragePropertyDBA _parent;
/*     */     
/*     */     public LineItemGenericStoragePropertyFiller(LineItemGenericStoragePropertyDBA argParent) {
/* 127 */       this._parent = argParent;
/*     */     }
/*     */     
/*     */     public void fill(ResultSet argResultSet) throws SQLException {
/* 131 */       Timestamp t1 = argResultSet.getTimestamp(1);
/* 132 */       if (t1 != null) {
/* 133 */         this._parent._businessDate = (Date)new DtvDate(t1.getTime());
/*     */       } else {
/*     */         
/* 136 */         this._parent._businessDate = null;
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/* 141 */       long l1 = argResultSet.getLong(2);
/* 142 */       if (l1 != 0L || argResultSet.getObject(2) != null) {
/* 143 */         this._parent._organizationId = Long.valueOf(l1);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 149 */       l1 = argResultSet.getLong(3);
/* 150 */       if (l1 != 0L || argResultSet.getObject(3) != null) {
/* 151 */         this._parent._retailLocationId = Long.valueOf(l1);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 157 */       int i = argResultSet.getInt(4);
/* 158 */       if (i != 0 || argResultSet.getObject(4) != null) {
/* 159 */         this._parent._lineItemSequence = Integer.valueOf(i);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 165 */       long primitiveResult = argResultSet.getLong(5);
/* 166 */       if (primitiveResult != 0L || argResultSet.getObject(5) != null) {
/* 167 */         this._parent._transactionSequence = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 173 */       primitiveResult = argResultSet.getLong(6);
/* 174 */       if (primitiveResult != 0L || argResultSet.getObject(6) != null) {
/* 175 */         this._parent._workstationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */       
/* 179 */       this._parent._propertyCode = argResultSet.getString(7);
/* 180 */       this._parent._type = argResultSet.getString(8);
/* 181 */       this._parent._stringValue = argResultSet.getString(9);
/*     */       
/* 183 */       Timestamp t10 = argResultSet.getTimestamp(10);
/* 184 */       if (t10 != null) {
/* 185 */         this._parent._dateValue = (Date)new DtvDate(t10.getTime());
/*     */       } else {
/*     */         
/* 188 */         this._parent._dateValue = null;
/*     */       } 
/*     */       
/* 191 */       this._parent._decimalValue = argResultSet.getBigDecimal(11);
/*     */       
/* 193 */       Timestamp t12 = argResultSet.getTimestamp(12);
/* 194 */       if (t12 != null) {
/* 195 */         this._parent._createDate = (Date)new DtvDate(t12.getTime());
/*     */       } else {
/*     */         
/* 198 */         this._parent._createDate = null;
/*     */       } 
/*     */       
/* 201 */       this._parent._createUserId = argResultSet.getString(13);
/*     */       
/* 203 */       Timestamp t14 = argResultSet.getTimestamp(14);
/* 204 */       if (t14 != null) {
/* 205 */         this._parent._updateDate = (Date)new DtvDate(t14.getTime());
/*     */       } else {
/*     */         
/* 208 */         this._parent._updateDate = null;
/*     */       } 
/*     */       
/* 211 */       this._parent._updateUserId = argResultSet.getString(15);
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDAO(IDataAccessObject argDAO) {
/* 216 */     argDAO.suppressStateChanges(true);
/* 217 */     LineItemGenericStoragePropertyDAO dao = (LineItemGenericStoragePropertyDAO)argDAO;
/* 218 */     dao.setBusinessDate(this._businessDate);
/* 219 */     dao.setOrganizationId(this._organizationId);
/* 220 */     dao.setRetailLocationId(this._retailLocationId);
/* 221 */     dao.setLineItemSequence(this._lineItemSequence);
/* 222 */     dao.setTransactionSequence(this._transactionSequence);
/* 223 */     dao.setWorkstationId(this._workstationId);
/* 224 */     dao.setPropertyCode(this._propertyCode);
/* 225 */     dao.setType(this._type);
/* 226 */     dao.setStringValue(this._stringValue);
/* 227 */     dao.setDateValue(this._dateValue);
/* 228 */     dao.setDecimalValue(this._decimalValue);
/* 229 */     dao.setCreateDate(this._createDate);
/* 230 */     dao.setCreateUserId(this._createUserId);
/* 231 */     dao.setUpdateDate(this._updateDate);
/* 232 */     dao.setUpdateUserId(this._updateUserId);
/* 233 */     argDAO.suppressStateChanges(false);
/* 234 */     return (IDataAccessObject)dao;
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDefaultDAO() {
/* 238 */     return loadDAO((IDataAccessObject)new LineItemGenericStoragePropertyDAO());
/*     */   }
/*     */   
/*     */   public void fill(IDataAccessObject argDAO) {
/* 242 */     LineItemGenericStoragePropertyDAO dao = (LineItemGenericStoragePropertyDAO)argDAO;
/* 243 */     this._businessDate = dao.getBusinessDate();
/* 244 */     this._organizationId = dao.getOrganizationId();
/* 245 */     this._retailLocationId = dao.getRetailLocationId();
/* 246 */     this._lineItemSequence = dao.getLineItemSequence();
/* 247 */     this._transactionSequence = dao.getTransactionSequence();
/* 248 */     this._workstationId = dao.getWorkstationId();
/* 249 */     this._propertyCode = dao.getPropertyCode();
/* 250 */     this._type = dao.getType();
/* 251 */     this._stringValue = dao.getStringValue();
/* 252 */     this._dateValue = dao.getDateValue();
/* 253 */     this._decimalValue = dao.getDecimalValue();
/* 254 */     this._createDate = dao.getCreateDate();
/* 255 */     this._createUserId = dao.getCreateUserId();
/* 256 */     this._updateDate = dao.getUpdateDate();
/* 257 */     this._updateUserId = dao.getUpdateUserId();
/*     */   }
/*     */   
/*     */   public PreparedStatement writeObjectId(IObjectId argId, PreparedStatement argStatement) throws SQLException {
/* 261 */     LineItemGenericStoragePropertyId id = (LineItemGenericStoragePropertyId)argId;
/* 262 */     argStatement.setTimestamp(1, new Timestamp(id.getBusinessDate().getTime()));
/* 263 */     argStatement.setLong(2, id.getOrganizationId().longValue());
/* 264 */     argStatement.setLong(3, id.getRetailLocationId().longValue());
/* 265 */     argStatement.setInt(4, id.getLineItemSequence().intValue());
/* 266 */     argStatement.setLong(5, id.getTransactionSequence().longValue());
/* 267 */     argStatement.setLong(6, id.getWorkstationId().longValue());
/* 268 */     argStatement.setString(7, id.getPropertyCode());
/* 269 */     return argStatement;
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 273 */     LineItemGenericStoragePropertyId id = new LineItemGenericStoragePropertyId();
/* 274 */     id.setBusinessDate(this._businessDate);
/* 275 */     id.setOrganizationId(this._organizationId);
/* 276 */     id.setRetailLocationId(this._retailLocationId);
/* 277 */     id.setLineItemSequence(this._lineItemSequence);
/* 278 */     id.setTransactionSequence(this._transactionSequence);
/* 279 */     id.setWorkstationId(this._workstationId);
/* 280 */     id.setPropertyCode(this._propertyCode);
/* 281 */     return (IObjectId)id;
/*     */   }
/*     */ 
/*     */   
/*     */   public void fill(IJDBCTableAdapter argAdapter) {}
/*     */ 
/*     */   
/*     */   public boolean isExtensible() {
/* 289 */     return false;
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 293 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\trn\impl\LineItemGenericStoragePropertyDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */