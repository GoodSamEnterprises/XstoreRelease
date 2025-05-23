/*     */ package dtv.xst.dao.tsn.impl;
/*     */ 
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.impl.jdbc.IFiller;
/*     */ import dtv.data2.access.impl.jdbc.IJDBCTableAdapter;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.tsn.TenderDenominationCountPropertyId;
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
/*     */ public class TenderDenominationCountPropertyDBA
/*     */   implements IJDBCTableAdapter
/*     */ {
/*     */   private static final long serialVersionUID = 759654283L;
/*     */   private Date _businessDayDate;
/*     */   private String _denominationId;
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
/*     */   private static final String SELECT_OBJECT = "SELECT t.business_date, t.denomination_id, t.organization_id, t.rtl_loc_id, t.tndr_id, t.tndr_typcode, t.trans_seq, t.wkstn_id, t.property_code, t.type, t.string_value, t.date_value, t.decimal_value, t.create_date, t.create_user_id, t.update_date, t.update_user_id FROM tsn_tndr_denomination_count_p t";
/*     */   private static final String SELECT_WHERE_OBJECT = " WHERE business_date = ?  AND denomination_id = ?  AND organization_id = ?  AND rtl_loc_id = ?  AND tndr_id = ?  AND tndr_typcode = ?  AND trans_seq = ?  AND wkstn_id = ?  AND property_code = ?  ";
/*     */   
/*     */   public String getSelect() {
/*  46 */     return getSelectImpl();
/*     */   }
/*     */   
/*     */   private String getSelectImpl() {
/*  50 */     return "SELECT t.business_date, t.denomination_id, t.organization_id, t.rtl_loc_id, t.tndr_id, t.tndr_typcode, t.trans_seq, t.wkstn_id, t.property_code, t.type, t.string_value, t.date_value, t.decimal_value, t.create_date, t.create_user_id, t.update_date, t.update_user_id FROM tsn_tndr_denomination_count_p t";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectWhere() {
/*  56 */     return " WHERE business_date = ?  AND denomination_id = ?  AND organization_id = ?  AND rtl_loc_id = ?  AND tndr_id = ?  AND tndr_typcode = ?  AND trans_seq = ?  AND wkstn_id = ?  AND property_code = ?  ";
/*     */   }
/*     */   
/*  59 */   private static final String[] INSERT_OBJECT = new String[] { "INSERT INTO tsn_tndr_denomination_count_p(business_date, denomination_id, organization_id, rtl_loc_id, tndr_id, tndr_typcode, trans_seq, wkstn_id, property_code, type, string_value, date_value, decimal_value, create_date, create_user_id, update_date, update_user_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" };
/*     */   
/*     */   public String[] getInsert() {
/*  62 */     return INSERT_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getInsertParameters() {
/*  66 */     Object[][] insertParameterObject = { { this._businessDayDate, this._denominationId, this._organizationId, this._retailLocationId, this._tenderId, this._tenderTypeCode, this._transactionSequence, this._workstationId, this._propertyCode, this._type, this._stringValue, this._dateValue, this._decimalValue, this._createDate, this._createUserId, this._updateDate, this._updateUserId } };
/*  67 */     return insertParameterObject;
/*     */   }
/*     */   
/*  70 */   private static final int[][] INSERT_PARAMETER_TYPES_OBJECT = new int[][] { { 91, 12, -5, -5, 12, 12, -5, -5, 12, 12, 12, 91, 3, 91, 12, 91, 12 } };
/*     */   
/*     */   public int[][] getInsertParameterTypes() {
/*  73 */     return INSERT_PARAMETER_TYPES_OBJECT;
/*     */   }
/*     */   
/*  76 */   private static final String[] UPDATE_OBJECT = new String[] { "UPDATE tsn_tndr_denomination_count_p SET type = ?, string_value = ?, date_value = ?, decimal_value = ?, update_date = ?, update_user_id = ?" };
/*     */   
/*     */   public String[] getUpdate() {
/*  79 */     return UPDATE_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getUpdateParameters() {
/*  83 */     Object[][] updateParameterObject = { { this._type, this._stringValue, this._dateValue, this._decimalValue, this._updateDate, this._updateUserId } };
/*  84 */     return updateParameterObject;
/*     */   }
/*     */   
/*  87 */   private static final int[][] UPDATE_PARAMETER_TYPE_OBJECT = new int[][] { { 12, 12, 91, 3, 91, 12 } };
/*     */   public int[][] getUpdateParameterTypes() {
/*  89 */     return UPDATE_PARAMETER_TYPE_OBJECT;
/*     */   }
/*     */   
/*  92 */   private static final String[] DELETE_OBJECT = new String[] { "DELETE FROM tsn_tndr_denomination_count_p" }; private static final String WHERE_OBJECT = " WHERE business_date = ?  AND denomination_id = ?  AND organization_id = ?  AND rtl_loc_id = ?  AND tndr_id = ?  AND tndr_typcode = ?  AND trans_seq = ?  AND wkstn_id = ?  AND property_code = ?  ";
/*     */   
/*     */   public String[] getDelete() {
/*  95 */     return DELETE_OBJECT;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWhere() {
/* 101 */     return " WHERE business_date = ?  AND denomination_id = ?  AND organization_id = ?  AND rtl_loc_id = ?  AND tndr_id = ?  AND tndr_typcode = ?  AND trans_seq = ?  AND wkstn_id = ?  AND property_code = ?  ";
/*     */   }
/*     */   public Object[] getWhereParameters() {
/* 104 */     return new Object[] { this._businessDayDate, this._denominationId, this._organizationId, this._retailLocationId, this._tenderId, this._tenderTypeCode, this._transactionSequence, this._workstationId, this._propertyCode };
/*     */   }
/*     */   
/* 107 */   private static final int[] WHERE_PARAMETER_OBJECT = new int[] { 91, 12, -5, -5, 12, 12, -5, -5, 12 };
/*     */   
/*     */   public int[] getWhereParameterTypes() {
/* 110 */     return WHERE_PARAMETER_OBJECT;
/*     */   }
/*     */   public String getTableName() {
/* 113 */     return "tsn_tndr_denomination_count_p";
/*     */   }
/*     */   
/*     */   public IFiller getFiller() {
/* 117 */     return getFillerImpl();
/*     */   }
/*     */   
/*     */   private IFiller getFillerImpl() {
/* 121 */     return new TenderDenominationCountPropertyFiller(this);
/*     */   }
/*     */   
/*     */   private static class TenderDenominationCountPropertyFiller
/*     */     implements IFiller {
/*     */     private TenderDenominationCountPropertyDBA _parent;
/*     */     
/*     */     public TenderDenominationCountPropertyFiller(TenderDenominationCountPropertyDBA argParent) {
/* 129 */       this._parent = argParent;
/*     */     }
/*     */     
/*     */     public void fill(ResultSet argResultSet) throws SQLException {
/* 133 */       Timestamp t1 = argResultSet.getTimestamp(1);
/* 134 */       if (t1 != null) {
/* 135 */         this._parent._businessDayDate = (Date)new DtvDate(t1.getTime());
/*     */       } else {
/*     */         
/* 138 */         this._parent._businessDayDate = null;
/*     */       } 
/*     */       
/* 141 */       this._parent._denominationId = argResultSet.getString(2);
/*     */ 
/*     */       
/* 144 */       long primitiveResult = argResultSet.getLong(3);
/* 145 */       if (primitiveResult != 0L || argResultSet.getObject(3) != null) {
/* 146 */         this._parent._organizationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 152 */       primitiveResult = argResultSet.getLong(4);
/* 153 */       if (primitiveResult != 0L || argResultSet.getObject(4) != null) {
/* 154 */         this._parent._retailLocationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */       
/* 158 */       this._parent._tenderId = argResultSet.getString(5);
/* 159 */       this._parent._tenderTypeCode = argResultSet.getString(6);
/*     */ 
/*     */       
/* 162 */       primitiveResult = argResultSet.getLong(7);
/* 163 */       if (primitiveResult != 0L || argResultSet.getObject(7) != null) {
/* 164 */         this._parent._transactionSequence = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 170 */       primitiveResult = argResultSet.getLong(8);
/* 171 */       if (primitiveResult != 0L || argResultSet.getObject(8) != null) {
/* 172 */         this._parent._workstationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */       
/* 176 */       this._parent._propertyCode = argResultSet.getString(9);
/* 177 */       this._parent._type = argResultSet.getString(10);
/* 178 */       this._parent._stringValue = argResultSet.getString(11);
/*     */       
/* 180 */       Timestamp t12 = argResultSet.getTimestamp(12);
/* 181 */       if (t12 != null) {
/* 182 */         this._parent._dateValue = (Date)new DtvDate(t12.getTime());
/*     */       } else {
/*     */         
/* 185 */         this._parent._dateValue = null;
/*     */       } 
/*     */       
/* 188 */       this._parent._decimalValue = argResultSet.getBigDecimal(13);
/*     */       
/* 190 */       Timestamp t14 = argResultSet.getTimestamp(14);
/* 191 */       if (t14 != null) {
/* 192 */         this._parent._createDate = (Date)new DtvDate(t14.getTime());
/*     */       } else {
/*     */         
/* 195 */         this._parent._createDate = null;
/*     */       } 
/*     */       
/* 198 */       this._parent._createUserId = argResultSet.getString(15);
/*     */       
/* 200 */       Timestamp t16 = argResultSet.getTimestamp(16);
/* 201 */       if (t16 != null) {
/* 202 */         this._parent._updateDate = (Date)new DtvDate(t16.getTime());
/*     */       } else {
/*     */         
/* 205 */         this._parent._updateDate = null;
/*     */       } 
/*     */       
/* 208 */       this._parent._updateUserId = argResultSet.getString(17);
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDAO(IDataAccessObject argDAO) {
/* 213 */     argDAO.suppressStateChanges(true);
/* 214 */     TenderDenominationCountPropertyDAO dao = (TenderDenominationCountPropertyDAO)argDAO;
/* 215 */     dao.setBusinessDayDate(this._businessDayDate);
/* 216 */     dao.setDenominationId(this._denominationId);
/* 217 */     dao.setOrganizationId(this._organizationId);
/* 218 */     dao.setRetailLocationId(this._retailLocationId);
/* 219 */     dao.setTenderId(this._tenderId);
/* 220 */     dao.setTenderTypeCode(this._tenderTypeCode);
/* 221 */     dao.setTransactionSequence(this._transactionSequence);
/* 222 */     dao.setWorkstationId(this._workstationId);
/* 223 */     dao.setPropertyCode(this._propertyCode);
/* 224 */     dao.setType(this._type);
/* 225 */     dao.setStringValue(this._stringValue);
/* 226 */     dao.setDateValue(this._dateValue);
/* 227 */     dao.setDecimalValue(this._decimalValue);
/* 228 */     dao.setCreateDate(this._createDate);
/* 229 */     dao.setCreateUserId(this._createUserId);
/* 230 */     dao.setUpdateDate(this._updateDate);
/* 231 */     dao.setUpdateUserId(this._updateUserId);
/* 232 */     argDAO.suppressStateChanges(false);
/* 233 */     return (IDataAccessObject)dao;
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDefaultDAO() {
/* 237 */     return loadDAO((IDataAccessObject)new TenderDenominationCountPropertyDAO());
/*     */   }
/*     */   
/*     */   public void fill(IDataAccessObject argDAO) {
/* 241 */     TenderDenominationCountPropertyDAO dao = (TenderDenominationCountPropertyDAO)argDAO;
/* 242 */     this._businessDayDate = dao.getBusinessDayDate();
/* 243 */     this._denominationId = dao.getDenominationId();
/* 244 */     this._organizationId = dao.getOrganizationId();
/* 245 */     this._retailLocationId = dao.getRetailLocationId();
/* 246 */     this._tenderId = dao.getTenderId();
/* 247 */     this._tenderTypeCode = dao.getTenderTypeCode();
/* 248 */     this._transactionSequence = dao.getTransactionSequence();
/* 249 */     this._workstationId = dao.getWorkstationId();
/* 250 */     this._propertyCode = dao.getPropertyCode();
/* 251 */     this._type = dao.getType();
/* 252 */     this._stringValue = dao.getStringValue();
/* 253 */     this._dateValue = dao.getDateValue();
/* 254 */     this._decimalValue = dao.getDecimalValue();
/* 255 */     this._createDate = dao.getCreateDate();
/* 256 */     this._createUserId = dao.getCreateUserId();
/* 257 */     this._updateDate = dao.getUpdateDate();
/* 258 */     this._updateUserId = dao.getUpdateUserId();
/*     */   }
/*     */   
/*     */   public PreparedStatement writeObjectId(IObjectId argId, PreparedStatement argStatement) throws SQLException {
/* 262 */     TenderDenominationCountPropertyId id = (TenderDenominationCountPropertyId)argId;
/* 263 */     argStatement.setTimestamp(1, new Timestamp(id.getBusinessDayDate().getTime()));
/* 264 */     argStatement.setString(2, id.getDenominationId());
/* 265 */     argStatement.setLong(3, id.getOrganizationId().longValue());
/* 266 */     argStatement.setLong(4, id.getRetailLocationId().longValue());
/* 267 */     argStatement.setString(5, id.getTenderId());
/* 268 */     argStatement.setString(6, id.getTenderTypeCode());
/* 269 */     argStatement.setLong(7, id.getTransactionSequence().longValue());
/* 270 */     argStatement.setLong(8, id.getWorkstationId().longValue());
/* 271 */     argStatement.setString(9, id.getPropertyCode());
/* 272 */     return argStatement;
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 276 */     TenderDenominationCountPropertyId id = new TenderDenominationCountPropertyId();
/* 277 */     id.setBusinessDayDate(this._businessDayDate);
/* 278 */     id.setDenominationId(this._denominationId);
/* 279 */     id.setOrganizationId(this._organizationId);
/* 280 */     id.setRetailLocationId(this._retailLocationId);
/* 281 */     id.setTenderId(this._tenderId);
/* 282 */     id.setTenderTypeCode(this._tenderTypeCode);
/* 283 */     id.setTransactionSequence(this._transactionSequence);
/* 284 */     id.setWorkstationId(this._workstationId);
/* 285 */     id.setPropertyCode(this._propertyCode);
/* 286 */     return (IObjectId)id;
/*     */   }
/*     */ 
/*     */   
/*     */   public void fill(IJDBCTableAdapter argAdapter) {}
/*     */ 
/*     */   
/*     */   public boolean isExtensible() {
/* 294 */     return false;
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 298 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\tsn\impl\TenderDenominationCountPropertyDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */