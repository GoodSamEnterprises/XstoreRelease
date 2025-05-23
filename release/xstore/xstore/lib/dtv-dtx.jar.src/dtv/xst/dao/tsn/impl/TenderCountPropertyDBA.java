/*     */ package dtv.xst.dao.tsn.impl;
/*     */ 
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.impl.jdbc.IFiller;
/*     */ import dtv.data2.access.impl.jdbc.IJDBCTableAdapter;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.tsn.TenderCountPropertyId;
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
/*     */ public class TenderCountPropertyDBA
/*     */   implements IJDBCTableAdapter
/*     */ {
/*     */   private static final long serialVersionUID = -1781313168L;
/*     */   private Date _businessDayDate;
/*     */   private Long _organizationId;
/*     */   private Long _retailLocationId;
/*     */   private String _tenderId;
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
/*     */   private static final String SELECT_OBJECT = "SELECT t.business_date, t.organization_id, t.rtl_loc_id, t.tndr_id, t.tndr_typcode, t.trans_seq, t.wkstn_id, t.property_code, t.type, t.string_value, t.date_value, t.decimal_value, t.create_date, t.create_user_id, t.update_date, t.update_user_id FROM tsn_tndr_tndr_count_p t";
/*     */   private static final String SELECT_WHERE_OBJECT = " WHERE business_date = ?  AND organization_id = ?  AND rtl_loc_id = ?  AND tndr_id = ?  AND tndr_typcode = ?  AND trans_seq = ?  AND wkstn_id = ?  AND property_code = ?  ";
/*     */   
/*     */   public String getSelect() {
/*  45 */     return getSelectImpl();
/*     */   }
/*     */   
/*     */   private String getSelectImpl() {
/*  49 */     return "SELECT t.business_date, t.organization_id, t.rtl_loc_id, t.tndr_id, t.tndr_typcode, t.trans_seq, t.wkstn_id, t.property_code, t.type, t.string_value, t.date_value, t.decimal_value, t.create_date, t.create_user_id, t.update_date, t.update_user_id FROM tsn_tndr_tndr_count_p t";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectWhere() {
/*  55 */     return " WHERE business_date = ?  AND organization_id = ?  AND rtl_loc_id = ?  AND tndr_id = ?  AND tndr_typcode = ?  AND trans_seq = ?  AND wkstn_id = ?  AND property_code = ?  ";
/*     */   }
/*     */   
/*  58 */   private static final String[] INSERT_OBJECT = new String[] { "INSERT INTO tsn_tndr_tndr_count_p(business_date, organization_id, rtl_loc_id, tndr_id, tndr_typcode, trans_seq, wkstn_id, property_code, type, string_value, date_value, decimal_value, create_date, create_user_id, update_date, update_user_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" };
/*     */   
/*     */   public String[] getInsert() {
/*  61 */     return INSERT_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getInsertParameters() {
/*  65 */     Object[][] insertParameterObject = { { this._businessDayDate, this._organizationId, this._retailLocationId, this._tenderId, this._tenderTypeCode, this._transactionSequence, this._workstationId, this._propertyCode, this._type, this._stringValue, this._dateValue, this._decimalValue, this._createDate, this._createUserId, this._updateDate, this._updateUserId } };
/*  66 */     return insertParameterObject;
/*     */   }
/*     */   
/*  69 */   private static final int[][] INSERT_PARAMETER_TYPES_OBJECT = new int[][] { { 91, -5, -5, 12, 12, -5, -5, 12, 12, 12, 91, 3, 91, 12, 91, 12 } };
/*     */   
/*     */   public int[][] getInsertParameterTypes() {
/*  72 */     return INSERT_PARAMETER_TYPES_OBJECT;
/*     */   }
/*     */   
/*  75 */   private static final String[] UPDATE_OBJECT = new String[] { "UPDATE tsn_tndr_tndr_count_p SET type = ?, string_value = ?, date_value = ?, decimal_value = ?, update_date = ?, update_user_id = ?" };
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
/*  91 */   private static final String[] DELETE_OBJECT = new String[] { "DELETE FROM tsn_tndr_tndr_count_p" }; private static final String WHERE_OBJECT = " WHERE business_date = ?  AND organization_id = ?  AND rtl_loc_id = ?  AND tndr_id = ?  AND tndr_typcode = ?  AND trans_seq = ?  AND wkstn_id = ?  AND property_code = ?  ";
/*     */   
/*     */   public String[] getDelete() {
/*  94 */     return DELETE_OBJECT;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWhere() {
/* 100 */     return " WHERE business_date = ?  AND organization_id = ?  AND rtl_loc_id = ?  AND tndr_id = ?  AND tndr_typcode = ?  AND trans_seq = ?  AND wkstn_id = ?  AND property_code = ?  ";
/*     */   }
/*     */   public Object[] getWhereParameters() {
/* 103 */     return new Object[] { this._businessDayDate, this._organizationId, this._retailLocationId, this._tenderId, this._tenderTypeCode, this._transactionSequence, this._workstationId, this._propertyCode };
/*     */   }
/*     */   
/* 106 */   private static final int[] WHERE_PARAMETER_OBJECT = new int[] { 91, -5, -5, 12, 12, -5, -5, 12 };
/*     */   
/*     */   public int[] getWhereParameterTypes() {
/* 109 */     return WHERE_PARAMETER_OBJECT;
/*     */   }
/*     */   public String getTableName() {
/* 112 */     return "tsn_tndr_tndr_count_p";
/*     */   }
/*     */   
/*     */   public IFiller getFiller() {
/* 116 */     return getFillerImpl();
/*     */   }
/*     */   
/*     */   private IFiller getFillerImpl() {
/* 120 */     return new TenderCountPropertyFiller(this);
/*     */   }
/*     */   
/*     */   private static class TenderCountPropertyFiller
/*     */     implements IFiller {
/*     */     private TenderCountPropertyDBA _parent;
/*     */     
/*     */     public TenderCountPropertyFiller(TenderCountPropertyDBA argParent) {
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
/* 142 */       long primitiveResult = argResultSet.getLong(2);
/* 143 */       if (primitiveResult != 0L || argResultSet.getObject(2) != null) {
/* 144 */         this._parent._organizationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 150 */       primitiveResult = argResultSet.getLong(3);
/* 151 */       if (primitiveResult != 0L || argResultSet.getObject(3) != null) {
/* 152 */         this._parent._retailLocationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */       
/* 156 */       this._parent._tenderId = argResultSet.getString(4);
/* 157 */       this._parent._tenderTypeCode = argResultSet.getString(5);
/*     */ 
/*     */       
/* 160 */       primitiveResult = argResultSet.getLong(6);
/* 161 */       if (primitiveResult != 0L || argResultSet.getObject(6) != null) {
/* 162 */         this._parent._transactionSequence = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 168 */       primitiveResult = argResultSet.getLong(7);
/* 169 */       if (primitiveResult != 0L || argResultSet.getObject(7) != null) {
/* 170 */         this._parent._workstationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */       
/* 174 */       this._parent._propertyCode = argResultSet.getString(8);
/* 175 */       this._parent._type = argResultSet.getString(9);
/* 176 */       this._parent._stringValue = argResultSet.getString(10);
/*     */       
/* 178 */       Timestamp t11 = argResultSet.getTimestamp(11);
/* 179 */       if (t11 != null) {
/* 180 */         this._parent._dateValue = (Date)new DtvDate(t11.getTime());
/*     */       } else {
/*     */         
/* 183 */         this._parent._dateValue = null;
/*     */       } 
/*     */       
/* 186 */       this._parent._decimalValue = argResultSet.getBigDecimal(12);
/*     */       
/* 188 */       Timestamp t13 = argResultSet.getTimestamp(13);
/* 189 */       if (t13 != null) {
/* 190 */         this._parent._createDate = (Date)new DtvDate(t13.getTime());
/*     */       } else {
/*     */         
/* 193 */         this._parent._createDate = null;
/*     */       } 
/*     */       
/* 196 */       this._parent._createUserId = argResultSet.getString(14);
/*     */       
/* 198 */       Timestamp t15 = argResultSet.getTimestamp(15);
/* 199 */       if (t15 != null) {
/* 200 */         this._parent._updateDate = (Date)new DtvDate(t15.getTime());
/*     */       } else {
/*     */         
/* 203 */         this._parent._updateDate = null;
/*     */       } 
/*     */       
/* 206 */       this._parent._updateUserId = argResultSet.getString(16);
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDAO(IDataAccessObject argDAO) {
/* 211 */     argDAO.suppressStateChanges(true);
/* 212 */     TenderCountPropertyDAO dao = (TenderCountPropertyDAO)argDAO;
/* 213 */     dao.setBusinessDayDate(this._businessDayDate);
/* 214 */     dao.setOrganizationId(this._organizationId);
/* 215 */     dao.setRetailLocationId(this._retailLocationId);
/* 216 */     dao.setTenderId(this._tenderId);
/* 217 */     dao.setTenderTypeCode(this._tenderTypeCode);
/* 218 */     dao.setTransactionSequence(this._transactionSequence);
/* 219 */     dao.setWorkstationId(this._workstationId);
/* 220 */     dao.setPropertyCode(this._propertyCode);
/* 221 */     dao.setType(this._type);
/* 222 */     dao.setStringValue(this._stringValue);
/* 223 */     dao.setDateValue(this._dateValue);
/* 224 */     dao.setDecimalValue(this._decimalValue);
/* 225 */     dao.setCreateDate(this._createDate);
/* 226 */     dao.setCreateUserId(this._createUserId);
/* 227 */     dao.setUpdateDate(this._updateDate);
/* 228 */     dao.setUpdateUserId(this._updateUserId);
/* 229 */     argDAO.suppressStateChanges(false);
/* 230 */     return (IDataAccessObject)dao;
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDefaultDAO() {
/* 234 */     return loadDAO((IDataAccessObject)new TenderCountPropertyDAO());
/*     */   }
/*     */   
/*     */   public void fill(IDataAccessObject argDAO) {
/* 238 */     TenderCountPropertyDAO dao = (TenderCountPropertyDAO)argDAO;
/* 239 */     this._businessDayDate = dao.getBusinessDayDate();
/* 240 */     this._organizationId = dao.getOrganizationId();
/* 241 */     this._retailLocationId = dao.getRetailLocationId();
/* 242 */     this._tenderId = dao.getTenderId();
/* 243 */     this._tenderTypeCode = dao.getTenderTypeCode();
/* 244 */     this._transactionSequence = dao.getTransactionSequence();
/* 245 */     this._workstationId = dao.getWorkstationId();
/* 246 */     this._propertyCode = dao.getPropertyCode();
/* 247 */     this._type = dao.getType();
/* 248 */     this._stringValue = dao.getStringValue();
/* 249 */     this._dateValue = dao.getDateValue();
/* 250 */     this._decimalValue = dao.getDecimalValue();
/* 251 */     this._createDate = dao.getCreateDate();
/* 252 */     this._createUserId = dao.getCreateUserId();
/* 253 */     this._updateDate = dao.getUpdateDate();
/* 254 */     this._updateUserId = dao.getUpdateUserId();
/*     */   }
/*     */   
/*     */   public PreparedStatement writeObjectId(IObjectId argId, PreparedStatement argStatement) throws SQLException {
/* 258 */     TenderCountPropertyId id = (TenderCountPropertyId)argId;
/* 259 */     argStatement.setTimestamp(1, new Timestamp(id.getBusinessDayDate().getTime()));
/* 260 */     argStatement.setLong(2, id.getOrganizationId().longValue());
/* 261 */     argStatement.setLong(3, id.getRetailLocationId().longValue());
/* 262 */     argStatement.setString(4, id.getTenderId());
/* 263 */     argStatement.setString(5, id.getTenderTypeCode());
/* 264 */     argStatement.setLong(6, id.getTransactionSequence().longValue());
/* 265 */     argStatement.setLong(7, id.getWorkstationId().longValue());
/* 266 */     argStatement.setString(8, id.getPropertyCode());
/* 267 */     return argStatement;
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 271 */     TenderCountPropertyId id = new TenderCountPropertyId();
/* 272 */     id.setBusinessDayDate(this._businessDayDate);
/* 273 */     id.setOrganizationId(this._organizationId);
/* 274 */     id.setRetailLocationId(this._retailLocationId);
/* 275 */     id.setTenderId(this._tenderId);
/* 276 */     id.setTenderTypeCode(this._tenderTypeCode);
/* 277 */     id.setTransactionSequence(this._transactionSequence);
/* 278 */     id.setWorkstationId(this._workstationId);
/* 279 */     id.setPropertyCode(this._propertyCode);
/* 280 */     return (IObjectId)id;
/*     */   }
/*     */ 
/*     */   
/*     */   public void fill(IJDBCTableAdapter argAdapter) {}
/*     */ 
/*     */   
/*     */   public boolean isExtensible() {
/* 288 */     return false;
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 292 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\tsn\impl\TenderCountPropertyDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */