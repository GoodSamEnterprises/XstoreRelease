/*     */ package dtv.xst.dao.thr.impl;
/*     */ 
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.impl.jdbc.IFiller;
/*     */ import dtv.data2.access.impl.jdbc.IJDBCTableAdapter;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.thr.TimecardEntryPropertyId;
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
/*     */ public class TimecardEntryPropertyDBA
/*     */   implements IJDBCTableAdapter
/*     */ {
/*     */   private static final long serialVersionUID = -537577494L;
/*     */   private Long _organizationId;
/*     */   private Date _businessDate;
/*     */   private Long _retailLocationId;
/*     */   private Long _partyId;
/*     */   private Long _timecardEntryId;
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
/*     */   private static final String SELECT_OBJECT = "SELECT t.organization_id, t.business_date, t.rtl_loc_id, t.party_id, t.timecard_entry_id, t.wkstn_id, t.property_code, t.type, t.string_value, t.date_value, t.decimal_value, t.create_date, t.create_user_id, t.update_date, t.update_user_id FROM thr_timecard_entry_p t";
/*     */   private static final String SELECT_WHERE_OBJECT = " WHERE organization_id = ?  AND business_date = ?  AND rtl_loc_id = ?  AND party_id = ?  AND timecard_entry_id = ?  AND wkstn_id = ?  AND property_code = ?  ";
/*     */   
/*     */   public String getSelect() {
/*  44 */     return getSelectImpl();
/*     */   }
/*     */   
/*     */   private String getSelectImpl() {
/*  48 */     return "SELECT t.organization_id, t.business_date, t.rtl_loc_id, t.party_id, t.timecard_entry_id, t.wkstn_id, t.property_code, t.type, t.string_value, t.date_value, t.decimal_value, t.create_date, t.create_user_id, t.update_date, t.update_user_id FROM thr_timecard_entry_p t";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectWhere() {
/*  54 */     return " WHERE organization_id = ?  AND business_date = ?  AND rtl_loc_id = ?  AND party_id = ?  AND timecard_entry_id = ?  AND wkstn_id = ?  AND property_code = ?  ";
/*     */   }
/*     */   
/*  57 */   private static final String[] INSERT_OBJECT = new String[] { "INSERT INTO thr_timecard_entry_p(organization_id, business_date, rtl_loc_id, party_id, timecard_entry_id, wkstn_id, property_code, type, string_value, date_value, decimal_value, create_date, create_user_id, update_date, update_user_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" };
/*     */   
/*     */   public String[] getInsert() {
/*  60 */     return INSERT_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getInsertParameters() {
/*  64 */     Object[][] insertParameterObject = { { this._organizationId, this._businessDate, this._retailLocationId, this._partyId, this._timecardEntryId, this._workstationId, this._propertyCode, this._type, this._stringValue, this._dateValue, this._decimalValue, this._createDate, this._createUserId, this._updateDate, this._updateUserId } };
/*  65 */     return insertParameterObject;
/*     */   }
/*     */   
/*  68 */   private static final int[][] INSERT_PARAMETER_TYPES_OBJECT = new int[][] { { -5, 91, -5, -5, -5, -5, 12, 12, 12, 91, 3, 91, 12, 91, 12 } };
/*     */   
/*     */   public int[][] getInsertParameterTypes() {
/*  71 */     return INSERT_PARAMETER_TYPES_OBJECT;
/*     */   }
/*     */   
/*  74 */   private static final String[] UPDATE_OBJECT = new String[] { "UPDATE thr_timecard_entry_p SET type = ?, string_value = ?, date_value = ?, decimal_value = ?, update_date = ?, update_user_id = ?" };
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
/*  90 */   private static final String[] DELETE_OBJECT = new String[] { "DELETE FROM thr_timecard_entry_p" }; private static final String WHERE_OBJECT = " WHERE organization_id = ?  AND business_date = ?  AND rtl_loc_id = ?  AND party_id = ?  AND timecard_entry_id = ?  AND wkstn_id = ?  AND property_code = ?  ";
/*     */   
/*     */   public String[] getDelete() {
/*  93 */     return DELETE_OBJECT;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWhere() {
/*  99 */     return " WHERE organization_id = ?  AND business_date = ?  AND rtl_loc_id = ?  AND party_id = ?  AND timecard_entry_id = ?  AND wkstn_id = ?  AND property_code = ?  ";
/*     */   }
/*     */   public Object[] getWhereParameters() {
/* 102 */     return new Object[] { this._organizationId, this._businessDate, this._retailLocationId, this._partyId, this._timecardEntryId, this._workstationId, this._propertyCode };
/*     */   }
/*     */   
/* 105 */   private static final int[] WHERE_PARAMETER_OBJECT = new int[] { -5, 91, -5, -5, -5, -5, 12 };
/*     */   
/*     */   public int[] getWhereParameterTypes() {
/* 108 */     return WHERE_PARAMETER_OBJECT;
/*     */   }
/*     */   public String getTableName() {
/* 111 */     return "thr_timecard_entry_p";
/*     */   }
/*     */   
/*     */   public IFiller getFiller() {
/* 115 */     return getFillerImpl();
/*     */   }
/*     */   
/*     */   private IFiller getFillerImpl() {
/* 119 */     return new TimecardEntryPropertyFiller(this);
/*     */   }
/*     */   
/*     */   private static class TimecardEntryPropertyFiller
/*     */     implements IFiller {
/*     */     private TimecardEntryPropertyDBA _parent;
/*     */     
/*     */     public TimecardEntryPropertyFiller(TimecardEntryPropertyDBA argParent) {
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
/* 139 */       Timestamp t2 = argResultSet.getTimestamp(2);
/* 140 */       if (t2 != null) {
/* 141 */         this._parent._businessDate = (Date)new DtvDate(t2.getTime());
/*     */       } else {
/*     */         
/* 144 */         this._parent._businessDate = null;
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/* 149 */       long l1 = argResultSet.getLong(3);
/* 150 */       if (l1 != 0L || argResultSet.getObject(3) != null) {
/* 151 */         this._parent._retailLocationId = Long.valueOf(l1);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 157 */       l1 = argResultSet.getLong(4);
/* 158 */       if (l1 != 0L || argResultSet.getObject(4) != null) {
/* 159 */         this._parent._partyId = Long.valueOf(l1);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 165 */       l1 = argResultSet.getLong(5);
/* 166 */       if (l1 != 0L || argResultSet.getObject(5) != null) {
/* 167 */         this._parent._timecardEntryId = Long.valueOf(l1);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 173 */       l1 = argResultSet.getLong(6);
/* 174 */       if (l1 != 0L || argResultSet.getObject(6) != null) {
/* 175 */         this._parent._workstationId = Long.valueOf(l1);
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
/* 217 */     TimecardEntryPropertyDAO dao = (TimecardEntryPropertyDAO)argDAO;
/* 218 */     dao.setOrganizationId(this._organizationId);
/* 219 */     dao.setBusinessDate(this._businessDate);
/* 220 */     dao.setRetailLocationId(this._retailLocationId);
/* 221 */     dao.setPartyId(this._partyId);
/* 222 */     dao.setTimecardEntryId(this._timecardEntryId);
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
/* 238 */     return loadDAO((IDataAccessObject)new TimecardEntryPropertyDAO());
/*     */   }
/*     */   
/*     */   public void fill(IDataAccessObject argDAO) {
/* 242 */     TimecardEntryPropertyDAO dao = (TimecardEntryPropertyDAO)argDAO;
/* 243 */     this._organizationId = dao.getOrganizationId();
/* 244 */     this._businessDate = dao.getBusinessDate();
/* 245 */     this._retailLocationId = dao.getRetailLocationId();
/* 246 */     this._partyId = dao.getPartyId();
/* 247 */     this._timecardEntryId = dao.getTimecardEntryId();
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
/* 261 */     TimecardEntryPropertyId id = (TimecardEntryPropertyId)argId;
/* 262 */     argStatement.setLong(1, id.getOrganizationId().longValue());
/* 263 */     argStatement.setTimestamp(2, new Timestamp(id.getBusinessDate().getTime()));
/* 264 */     argStatement.setLong(3, id.getRetailLocationId().longValue());
/* 265 */     argStatement.setLong(4, id.getPartyId().longValue());
/* 266 */     argStatement.setLong(5, id.getTimecardEntryId().longValue());
/* 267 */     argStatement.setLong(6, id.getWorkstationId().longValue());
/* 268 */     argStatement.setString(7, id.getPropertyCode());
/* 269 */     return argStatement;
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 273 */     TimecardEntryPropertyId id = new TimecardEntryPropertyId();
/* 274 */     id.setOrganizationId(this._organizationId);
/* 275 */     id.setBusinessDate(this._businessDate);
/* 276 */     id.setRetailLocationId(this._retailLocationId);
/* 277 */     id.setPartyId(this._partyId);
/* 278 */     id.setTimecardEntryId(this._timecardEntryId);
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


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\thr\impl\TimecardEntryPropertyDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */