/*     */ package dtv.xst.dao.tsn.impl;
/*     */ 
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.impl.jdbc.IFiller;
/*     */ import dtv.data2.access.impl.jdbc.IJDBCTableAdapter;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.tsn.TenderSerializedCountPropertyId;
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
/*     */ public class TenderSerializedCountPropertyDBA
/*     */   implements IJDBCTableAdapter
/*     */ {
/*     */   private static final long serialVersionUID = -452179124L;
/*     */   private Date _businessDayDate;
/*     */   private Long _organizationId;
/*     */   private Long _retailLocationId;
/*     */   private Integer _serializedCountSequence;
/*     */   private String _tenderTypeCode;
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
/*     */   private static final String SELECT_OBJECT = "SELECT t.business_date, t.organization_id, t.rtl_loc_id, t.serialized_tndr_count_seq, t.tndr_typcode, t.trans_seq, t.wkstn_id, t.property_code, t.type, t.string_value, t.date_value, t.decimal_value, t.create_date, t.create_user_id, t.update_date, t.update_user_id FROM tsn_serialized_tndr_count_p t";
/*     */   private static final String SELECT_WHERE_OBJECT = " WHERE business_date = ?  AND organization_id = ?  AND rtl_loc_id = ?  AND serialized_tndr_count_seq = ?  AND tndr_typcode = ?  AND trans_seq = ?  AND wkstn_id = ?  AND property_code = ?  ";
/*     */   
/*     */   public String getSelect() {
/*  45 */     return getSelectImpl();
/*     */   }
/*     */   
/*     */   private String getSelectImpl() {
/*  49 */     return "SELECT t.business_date, t.organization_id, t.rtl_loc_id, t.serialized_tndr_count_seq, t.tndr_typcode, t.trans_seq, t.wkstn_id, t.property_code, t.type, t.string_value, t.date_value, t.decimal_value, t.create_date, t.create_user_id, t.update_date, t.update_user_id FROM tsn_serialized_tndr_count_p t";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectWhere() {
/*  55 */     return " WHERE business_date = ?  AND organization_id = ?  AND rtl_loc_id = ?  AND serialized_tndr_count_seq = ?  AND tndr_typcode = ?  AND trans_seq = ?  AND wkstn_id = ?  AND property_code = ?  ";
/*     */   }
/*     */   
/*  58 */   private static final String[] INSERT_OBJECT = new String[] { "INSERT INTO tsn_serialized_tndr_count_p(business_date, organization_id, rtl_loc_id, serialized_tndr_count_seq, tndr_typcode, trans_seq, wkstn_id, property_code, type, string_value, date_value, decimal_value, create_date, create_user_id, update_date, update_user_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" };
/*     */   
/*     */   public String[] getInsert() {
/*  61 */     return INSERT_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getInsertParameters() {
/*  65 */     Object[][] insertParameterObject = { { this._businessDayDate, this._organizationId, this._retailLocationId, this._serializedCountSequence, this._tenderTypeCode, this._transactionSequence, this._workstationId, this._propertyCode, this._type, this._stringValue, this._dateValue, this._decimalValue, this._createDate, this._createUserId, this._updateDate, this._updateUserId } };
/*  66 */     return insertParameterObject;
/*     */   }
/*     */   
/*  69 */   private static final int[][] INSERT_PARAMETER_TYPES_OBJECT = new int[][] { { 91, -5, -5, 4, 12, -5, -5, 12, 12, 12, 91, 3, 91, 12, 91, 12 } };
/*     */   
/*     */   public int[][] getInsertParameterTypes() {
/*  72 */     return INSERT_PARAMETER_TYPES_OBJECT;
/*     */   }
/*     */   
/*  75 */   private static final String[] UPDATE_OBJECT = new String[] { "UPDATE tsn_serialized_tndr_count_p SET type = ?, string_value = ?, date_value = ?, decimal_value = ?, update_date = ?, update_user_id = ?" };
/*     */   
/*     */   public String[] getUpdate() {
/*  78 */     return UPDATE_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getUpdateParameters() {
/*  82 */     Object[][] updateParameterObject = { { this._type, this._stringValue, this._dateValue, this._decimalValue, this._updateDate, this._updateUserId } };
/*  83 */     return updateParameterObject;
/*     */   }
/*     */   
/*  86 */   private static final int[][] UPDATE_PARAMETER_TYPE_OBJECT = new int[][] { { 12, 12, 91, 3, 91, 12 } };
/*     */   public int[][] getUpdateParameterTypes() {
/*  88 */     return UPDATE_PARAMETER_TYPE_OBJECT;
/*     */   }
/*     */   
/*  91 */   private static final String[] DELETE_OBJECT = new String[] { "DELETE FROM tsn_serialized_tndr_count_p" }; private static final String WHERE_OBJECT = " WHERE business_date = ?  AND organization_id = ?  AND rtl_loc_id = ?  AND serialized_tndr_count_seq = ?  AND tndr_typcode = ?  AND trans_seq = ?  AND wkstn_id = ?  AND property_code = ?  ";
/*     */   
/*     */   public String[] getDelete() {
/*  94 */     return DELETE_OBJECT;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWhere() {
/* 100 */     return " WHERE business_date = ?  AND organization_id = ?  AND rtl_loc_id = ?  AND serialized_tndr_count_seq = ?  AND tndr_typcode = ?  AND trans_seq = ?  AND wkstn_id = ?  AND property_code = ?  ";
/*     */   }
/*     */   public Object[] getWhereParameters() {
/* 103 */     return new Object[] { this._businessDayDate, this._organizationId, this._retailLocationId, this._serializedCountSequence, this._tenderTypeCode, this._transactionSequence, this._workstationId, this._propertyCode };
/*     */   }
/*     */   
/* 106 */   private static final int[] WHERE_PARAMETER_OBJECT = new int[] { 91, -5, -5, 4, 12, -5, -5, 12 };
/*     */   
/*     */   public int[] getWhereParameterTypes() {
/* 109 */     return WHERE_PARAMETER_OBJECT;
/*     */   }
/*     */   public String getTableName() {
/* 112 */     return "tsn_serialized_tndr_count_p";
/*     */   }
/*     */   
/*     */   public IFiller getFiller() {
/* 116 */     return getFillerImpl();
/*     */   }
/*     */   
/*     */   private IFiller getFillerImpl() {
/* 120 */     return new TenderSerializedCountPropertyFiller(this);
/*     */   }
/*     */   
/*     */   private static class TenderSerializedCountPropertyFiller
/*     */     implements IFiller {
/*     */     private TenderSerializedCountPropertyDBA _parent;
/*     */     
/*     */     public TenderSerializedCountPropertyFiller(TenderSerializedCountPropertyDBA argParent) {
/* 128 */       this._parent = argParent;
/*     */     }
/*     */     
/*     */     public void fill(ResultSet argResultSet) throws SQLException {
/* 132 */       Timestamp t1 = argResultSet.getTimestamp(1);
/* 133 */       if (t1 != null) {
/* 134 */         this._parent._businessDayDate = (Date)new DtvDate(t1.getTime());
/*     */       } else {
/*     */         
/* 137 */         this._parent._businessDayDate = null;
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/* 142 */       long l1 = argResultSet.getLong(2);
/* 143 */       if (l1 != 0L || argResultSet.getObject(2) != null) {
/* 144 */         this._parent._organizationId = Long.valueOf(l1);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 150 */       l1 = argResultSet.getLong(3);
/* 151 */       if (l1 != 0L || argResultSet.getObject(3) != null) {
/* 152 */         this._parent._retailLocationId = Long.valueOf(l1);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 158 */       int i = argResultSet.getInt(4);
/* 159 */       if (i != 0 || argResultSet.getObject(4) != null) {
/* 160 */         this._parent._serializedCountSequence = Integer.valueOf(i);
/*     */       }
/*     */ 
/*     */       
/* 164 */       this._parent._tenderTypeCode = argResultSet.getString(5);
/*     */ 
/*     */       
/* 167 */       long primitiveResult = argResultSet.getLong(6);
/* 168 */       if (primitiveResult != 0L || argResultSet.getObject(6) != null) {
/* 169 */         this._parent._transactionSequence = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 175 */       primitiveResult = argResultSet.getLong(7);
/* 176 */       if (primitiveResult != 0L || argResultSet.getObject(7) != null) {
/* 177 */         this._parent._workstationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */       
/* 181 */       this._parent._propertyCode = argResultSet.getString(8);
/* 182 */       this._parent._type = argResultSet.getString(9);
/* 183 */       this._parent._stringValue = argResultSet.getString(10);
/*     */       
/* 185 */       Timestamp t11 = argResultSet.getTimestamp(11);
/* 186 */       if (t11 != null) {
/* 187 */         this._parent._dateValue = (Date)new DtvDate(t11.getTime());
/*     */       } else {
/*     */         
/* 190 */         this._parent._dateValue = null;
/*     */       } 
/*     */       
/* 193 */       this._parent._decimalValue = argResultSet.getBigDecimal(12);
/*     */       
/* 195 */       Timestamp t13 = argResultSet.getTimestamp(13);
/* 196 */       if (t13 != null) {
/* 197 */         this._parent._createDate = (Date)new DtvDate(t13.getTime());
/*     */       } else {
/*     */         
/* 200 */         this._parent._createDate = null;
/*     */       } 
/*     */       
/* 203 */       this._parent._createUserId = argResultSet.getString(14);
/*     */       
/* 205 */       Timestamp t15 = argResultSet.getTimestamp(15);
/* 206 */       if (t15 != null) {
/* 207 */         this._parent._updateDate = (Date)new DtvDate(t15.getTime());
/*     */       } else {
/*     */         
/* 210 */         this._parent._updateDate = null;
/*     */       } 
/*     */       
/* 213 */       this._parent._updateUserId = argResultSet.getString(16);
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDAO(IDataAccessObject argDAO) {
/* 218 */     argDAO.suppressStateChanges(true);
/* 219 */     TenderSerializedCountPropertyDAO dao = (TenderSerializedCountPropertyDAO)argDAO;
/* 220 */     dao.setBusinessDayDate(this._businessDayDate);
/* 221 */     dao.setOrganizationId(this._organizationId);
/* 222 */     dao.setRetailLocationId(this._retailLocationId);
/* 223 */     dao.setSerializedCountSequence(this._serializedCountSequence);
/* 224 */     dao.setTenderTypeCode(this._tenderTypeCode);
/* 225 */     dao.setTransactionSequence(this._transactionSequence);
/* 226 */     dao.setWorkstationId(this._workstationId);
/* 227 */     dao.setPropertyCode(this._propertyCode);
/* 228 */     dao.setType(this._type);
/* 229 */     dao.setStringValue(this._stringValue);
/* 230 */     dao.setDateValue(this._dateValue);
/* 231 */     dao.setDecimalValue(this._decimalValue);
/* 232 */     dao.setCreateDate(this._createDate);
/* 233 */     dao.setCreateUserId(this._createUserId);
/* 234 */     dao.setUpdateDate(this._updateDate);
/* 235 */     dao.setUpdateUserId(this._updateUserId);
/* 236 */     argDAO.suppressStateChanges(false);
/* 237 */     return (IDataAccessObject)dao;
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDefaultDAO() {
/* 241 */     return loadDAO((IDataAccessObject)new TenderSerializedCountPropertyDAO());
/*     */   }
/*     */   
/*     */   public void fill(IDataAccessObject argDAO) {
/* 245 */     TenderSerializedCountPropertyDAO dao = (TenderSerializedCountPropertyDAO)argDAO;
/* 246 */     this._businessDayDate = dao.getBusinessDayDate();
/* 247 */     this._organizationId = dao.getOrganizationId();
/* 248 */     this._retailLocationId = dao.getRetailLocationId();
/* 249 */     this._serializedCountSequence = dao.getSerializedCountSequence();
/* 250 */     this._tenderTypeCode = dao.getTenderTypeCode();
/* 251 */     this._transactionSequence = dao.getTransactionSequence();
/* 252 */     this._workstationId = dao.getWorkstationId();
/* 253 */     this._propertyCode = dao.getPropertyCode();
/* 254 */     this._type = dao.getType();
/* 255 */     this._stringValue = dao.getStringValue();
/* 256 */     this._dateValue = dao.getDateValue();
/* 257 */     this._decimalValue = dao.getDecimalValue();
/* 258 */     this._createDate = dao.getCreateDate();
/* 259 */     this._createUserId = dao.getCreateUserId();
/* 260 */     this._updateDate = dao.getUpdateDate();
/* 261 */     this._updateUserId = dao.getUpdateUserId();
/*     */   }
/*     */   
/*     */   public PreparedStatement writeObjectId(IObjectId argId, PreparedStatement argStatement) throws SQLException {
/* 265 */     TenderSerializedCountPropertyId id = (TenderSerializedCountPropertyId)argId;
/* 266 */     argStatement.setTimestamp(1, new Timestamp(id.getBusinessDayDate().getTime()));
/* 267 */     argStatement.setLong(2, id.getOrganizationId().longValue());
/* 268 */     argStatement.setLong(3, id.getRetailLocationId().longValue());
/* 269 */     argStatement.setInt(4, id.getSerializedCountSequence().intValue());
/* 270 */     argStatement.setString(5, id.getTenderTypeCode());
/* 271 */     argStatement.setLong(6, id.getTransactionSequence().longValue());
/* 272 */     argStatement.setLong(7, id.getWorkstationId().longValue());
/* 273 */     argStatement.setString(8, id.getPropertyCode());
/* 274 */     return argStatement;
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 278 */     TenderSerializedCountPropertyId id = new TenderSerializedCountPropertyId();
/* 279 */     id.setBusinessDayDate(this._businessDayDate);
/* 280 */     id.setOrganizationId(this._organizationId);
/* 281 */     id.setRetailLocationId(this._retailLocationId);
/* 282 */     id.setSerializedCountSequence(this._serializedCountSequence);
/* 283 */     id.setTenderTypeCode(this._tenderTypeCode);
/* 284 */     id.setTransactionSequence(this._transactionSequence);
/* 285 */     id.setWorkstationId(this._workstationId);
/* 286 */     id.setPropertyCode(this._propertyCode);
/* 287 */     return (IObjectId)id;
/*     */   }
/*     */ 
/*     */   
/*     */   public void fill(IJDBCTableAdapter argAdapter) {}
/*     */ 
/*     */   
/*     */   public boolean isExtensible() {
/* 295 */     return false;
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 299 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\tsn\impl\TenderSerializedCountPropertyDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */