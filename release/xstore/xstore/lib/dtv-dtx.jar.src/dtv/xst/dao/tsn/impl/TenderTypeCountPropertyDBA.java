/*     */ package dtv.xst.dao.tsn.impl;
/*     */ 
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.impl.jdbc.IFiller;
/*     */ import dtv.data2.access.impl.jdbc.IJDBCTableAdapter;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.tsn.TenderTypeCountPropertyId;
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
/*     */ public class TenderTypeCountPropertyDBA
/*     */   implements IJDBCTableAdapter
/*     */ {
/*     */   private static final long serialVersionUID = 1030187606L;
/*     */   private Date _businessDayDate;
/*     */   private Long _organizationId;
/*     */   private Long _retailLocationId;
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
/*     */   private static final String SELECT_OBJECT = "SELECT t.business_date, t.organization_id, t.rtl_loc_id, t.tndr_typcode, t.trans_seq, t.wkstn_id, t.property_code, t.type, t.string_value, t.date_value, t.decimal_value, t.create_date, t.create_user_id, t.update_date, t.update_user_id FROM tsn_tndr_typcode_count_p t";
/*     */   private static final String SELECT_WHERE_OBJECT = " WHERE business_date = ?  AND organization_id = ?  AND rtl_loc_id = ?  AND tndr_typcode = ?  AND trans_seq = ?  AND wkstn_id = ?  AND property_code = ?  ";
/*     */   
/*     */   public String getSelect() {
/*  44 */     return getSelectImpl();
/*     */   }
/*     */   
/*     */   private String getSelectImpl() {
/*  48 */     return "SELECT t.business_date, t.organization_id, t.rtl_loc_id, t.tndr_typcode, t.trans_seq, t.wkstn_id, t.property_code, t.type, t.string_value, t.date_value, t.decimal_value, t.create_date, t.create_user_id, t.update_date, t.update_user_id FROM tsn_tndr_typcode_count_p t";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectWhere() {
/*  54 */     return " WHERE business_date = ?  AND organization_id = ?  AND rtl_loc_id = ?  AND tndr_typcode = ?  AND trans_seq = ?  AND wkstn_id = ?  AND property_code = ?  ";
/*     */   }
/*     */   
/*  57 */   private static final String[] INSERT_OBJECT = new String[] { "INSERT INTO tsn_tndr_typcode_count_p(business_date, organization_id, rtl_loc_id, tndr_typcode, trans_seq, wkstn_id, property_code, type, string_value, date_value, decimal_value, create_date, create_user_id, update_date, update_user_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" };
/*     */   
/*     */   public String[] getInsert() {
/*  60 */     return INSERT_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getInsertParameters() {
/*  64 */     Object[][] insertParameterObject = { { this._businessDayDate, this._organizationId, this._retailLocationId, this._tenderTypeCode, this._transactionSequence, this._workstationId, this._propertyCode, this._type, this._stringValue, this._dateValue, this._decimalValue, this._createDate, this._createUserId, this._updateDate, this._updateUserId } };
/*  65 */     return insertParameterObject;
/*     */   }
/*     */   
/*  68 */   private static final int[][] INSERT_PARAMETER_TYPES_OBJECT = new int[][] { { 91, -5, -5, 12, -5, -5, 12, 12, 12, 91, 3, 91, 12, 91, 12 } };
/*     */   
/*     */   public int[][] getInsertParameterTypes() {
/*  71 */     return INSERT_PARAMETER_TYPES_OBJECT;
/*     */   }
/*     */   
/*  74 */   private static final String[] UPDATE_OBJECT = new String[] { "UPDATE tsn_tndr_typcode_count_p SET type = ?, string_value = ?, date_value = ?, decimal_value = ?, update_date = ?, update_user_id = ?" };
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
/*  90 */   private static final String[] DELETE_OBJECT = new String[] { "DELETE FROM tsn_tndr_typcode_count_p" }; private static final String WHERE_OBJECT = " WHERE business_date = ?  AND organization_id = ?  AND rtl_loc_id = ?  AND tndr_typcode = ?  AND trans_seq = ?  AND wkstn_id = ?  AND property_code = ?  ";
/*     */   
/*     */   public String[] getDelete() {
/*  93 */     return DELETE_OBJECT;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWhere() {
/*  99 */     return " WHERE business_date = ?  AND organization_id = ?  AND rtl_loc_id = ?  AND tndr_typcode = ?  AND trans_seq = ?  AND wkstn_id = ?  AND property_code = ?  ";
/*     */   }
/*     */   public Object[] getWhereParameters() {
/* 102 */     return new Object[] { this._businessDayDate, this._organizationId, this._retailLocationId, this._tenderTypeCode, this._transactionSequence, this._workstationId, this._propertyCode };
/*     */   }
/*     */   
/* 105 */   private static final int[] WHERE_PARAMETER_OBJECT = new int[] { 91, -5, -5, 12, -5, -5, 12 };
/*     */   
/*     */   public int[] getWhereParameterTypes() {
/* 108 */     return WHERE_PARAMETER_OBJECT;
/*     */   }
/*     */   public String getTableName() {
/* 111 */     return "tsn_tndr_typcode_count_p";
/*     */   }
/*     */   
/*     */   public IFiller getFiller() {
/* 115 */     return getFillerImpl();
/*     */   }
/*     */   
/*     */   private IFiller getFillerImpl() {
/* 119 */     return new TenderTypeCountPropertyFiller(this);
/*     */   }
/*     */   
/*     */   private static class TenderTypeCountPropertyFiller
/*     */     implements IFiller {
/*     */     private TenderTypeCountPropertyDBA _parent;
/*     */     
/*     */     public TenderTypeCountPropertyFiller(TenderTypeCountPropertyDBA argParent) {
/* 127 */       this._parent = argParent;
/*     */     }
/*     */     
/*     */     public void fill(ResultSet argResultSet) throws SQLException {
/* 131 */       Timestamp t1 = argResultSet.getTimestamp(1);
/* 132 */       if (t1 != null) {
/* 133 */         this._parent._businessDayDate = (Date)new DtvDate(t1.getTime());
/*     */       } else {
/*     */         
/* 136 */         this._parent._businessDayDate = null;
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/* 141 */       long primitiveResult = argResultSet.getLong(2);
/* 142 */       if (primitiveResult != 0L || argResultSet.getObject(2) != null) {
/* 143 */         this._parent._organizationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 149 */       primitiveResult = argResultSet.getLong(3);
/* 150 */       if (primitiveResult != 0L || argResultSet.getObject(3) != null) {
/* 151 */         this._parent._retailLocationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */       
/* 155 */       this._parent._tenderTypeCode = argResultSet.getString(4);
/*     */ 
/*     */       
/* 158 */       primitiveResult = argResultSet.getLong(5);
/* 159 */       if (primitiveResult != 0L || argResultSet.getObject(5) != null) {
/* 160 */         this._parent._transactionSequence = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 166 */       primitiveResult = argResultSet.getLong(6);
/* 167 */       if (primitiveResult != 0L || argResultSet.getObject(6) != null) {
/* 168 */         this._parent._workstationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */       
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
/* 210 */     TenderTypeCountPropertyDAO dao = (TenderTypeCountPropertyDAO)argDAO;
/* 211 */     dao.setBusinessDayDate(this._businessDayDate);
/* 212 */     dao.setOrganizationId(this._organizationId);
/* 213 */     dao.setRetailLocationId(this._retailLocationId);
/* 214 */     dao.setTenderTypeCode(this._tenderTypeCode);
/* 215 */     dao.setTransactionSequence(this._transactionSequence);
/* 216 */     dao.setWorkstationId(this._workstationId);
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
/* 231 */     return loadDAO((IDataAccessObject)new TenderTypeCountPropertyDAO());
/*     */   }
/*     */   
/*     */   public void fill(IDataAccessObject argDAO) {
/* 235 */     TenderTypeCountPropertyDAO dao = (TenderTypeCountPropertyDAO)argDAO;
/* 236 */     this._businessDayDate = dao.getBusinessDayDate();
/* 237 */     this._organizationId = dao.getOrganizationId();
/* 238 */     this._retailLocationId = dao.getRetailLocationId();
/* 239 */     this._tenderTypeCode = dao.getTenderTypeCode();
/* 240 */     this._transactionSequence = dao.getTransactionSequence();
/* 241 */     this._workstationId = dao.getWorkstationId();
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
/* 254 */     TenderTypeCountPropertyId id = (TenderTypeCountPropertyId)argId;
/* 255 */     argStatement.setTimestamp(1, new Timestamp(id.getBusinessDayDate().getTime()));
/* 256 */     argStatement.setLong(2, id.getOrganizationId().longValue());
/* 257 */     argStatement.setLong(3, id.getRetailLocationId().longValue());
/* 258 */     argStatement.setString(4, id.getTenderTypeCode());
/* 259 */     argStatement.setLong(5, id.getTransactionSequence().longValue());
/* 260 */     argStatement.setLong(6, id.getWorkstationId().longValue());
/* 261 */     argStatement.setString(7, id.getPropertyCode());
/* 262 */     return argStatement;
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 266 */     TenderTypeCountPropertyId id = new TenderTypeCountPropertyId();
/* 267 */     id.setBusinessDayDate(this._businessDayDate);
/* 268 */     id.setOrganizationId(this._organizationId);
/* 269 */     id.setRetailLocationId(this._retailLocationId);
/* 270 */     id.setTenderTypeCode(this._tenderTypeCode);
/* 271 */     id.setTransactionSequence(this._transactionSequence);
/* 272 */     id.setWorkstationId(this._workstationId);
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


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\tsn\impl\TenderTypeCountPropertyDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */