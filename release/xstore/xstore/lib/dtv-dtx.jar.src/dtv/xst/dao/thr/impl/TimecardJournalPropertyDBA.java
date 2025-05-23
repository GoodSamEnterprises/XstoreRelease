/*     */ package dtv.xst.dao.thr.impl;
/*     */ 
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.impl.jdbc.IFiller;
/*     */ import dtv.data2.access.impl.jdbc.IJDBCTableAdapter;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.thr.TimecardJournalPropertyId;
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
/*     */ public class TimecardJournalPropertyDBA
/*     */   implements IJDBCTableAdapter
/*     */ {
/*     */   private static final long serialVersionUID = -1994885905L;
/*     */   private Long _organizationId;
/*     */   private Date _businessDate;
/*     */   private Long _retailLocationId;
/*     */   private Long _partyId;
/*     */   private Long _timecardEntryId;
/*     */   private Long _workstationId;
/*     */   private Long _timecardEntrySeq;
/*     */   private String _propertyCode;
/*     */   private String _type;
/*     */   private String _stringValue;
/*     */   private Date _dateValue;
/*     */   private BigDecimal _decimalValue;
/*     */   private Date _createDate;
/*     */   private String _createUserId;
/*     */   private Date _updateDate;
/*     */   private String _updateUserId;
/*     */   private static final String SELECT_OBJECT = "SELECT t.organization_id, t.business_date, t.rtl_loc_id, t.party_id, t.timecard_entry_id, t.wkstn_id, t.timecard_entry_seq, t.property_code, t.type, t.string_value, t.date_value, t.decimal_value, t.create_date, t.create_user_id, t.update_date, t.update_user_id FROM thr_timecard_journal_p t";
/*     */   private static final String SELECT_WHERE_OBJECT = " WHERE organization_id = ?  AND business_date = ?  AND rtl_loc_id = ?  AND party_id = ?  AND timecard_entry_id = ?  AND wkstn_id = ?  AND timecard_entry_seq = ?  AND property_code = ?  ";
/*     */   
/*     */   public String getSelect() {
/*  45 */     return getSelectImpl();
/*     */   }
/*     */   
/*     */   private String getSelectImpl() {
/*  49 */     return "SELECT t.organization_id, t.business_date, t.rtl_loc_id, t.party_id, t.timecard_entry_id, t.wkstn_id, t.timecard_entry_seq, t.property_code, t.type, t.string_value, t.date_value, t.decimal_value, t.create_date, t.create_user_id, t.update_date, t.update_user_id FROM thr_timecard_journal_p t";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectWhere() {
/*  55 */     return " WHERE organization_id = ?  AND business_date = ?  AND rtl_loc_id = ?  AND party_id = ?  AND timecard_entry_id = ?  AND wkstn_id = ?  AND timecard_entry_seq = ?  AND property_code = ?  ";
/*     */   }
/*     */   
/*  58 */   private static final String[] INSERT_OBJECT = new String[] { "INSERT INTO thr_timecard_journal_p(organization_id, business_date, rtl_loc_id, party_id, timecard_entry_id, wkstn_id, timecard_entry_seq, property_code, type, string_value, date_value, decimal_value, create_date, create_user_id, update_date, update_user_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" };
/*     */   
/*     */   public String[] getInsert() {
/*  61 */     return INSERT_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getInsertParameters() {
/*  65 */     Object[][] insertParameterObject = { { this._organizationId, this._businessDate, this._retailLocationId, this._partyId, this._timecardEntryId, this._workstationId, this._timecardEntrySeq, this._propertyCode, this._type, this._stringValue, this._dateValue, this._decimalValue, this._createDate, this._createUserId, this._updateDate, this._updateUserId } };
/*  66 */     return insertParameterObject;
/*     */   }
/*     */   
/*  69 */   private static final int[][] INSERT_PARAMETER_TYPES_OBJECT = new int[][] { { -5, 91, -5, -5, -5, -5, -5, 12, 12, 12, 91, 3, 91, 12, 91, 12 } };
/*     */   
/*     */   public int[][] getInsertParameterTypes() {
/*  72 */     return INSERT_PARAMETER_TYPES_OBJECT;
/*     */   }
/*     */   
/*  75 */   private static final String[] UPDATE_OBJECT = new String[] { "UPDATE thr_timecard_journal_p SET type = ?, string_value = ?, date_value = ?, decimal_value = ?, update_date = ?, update_user_id = ?" };
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
/*  91 */   private static final String[] DELETE_OBJECT = new String[] { "DELETE FROM thr_timecard_journal_p" }; private static final String WHERE_OBJECT = " WHERE organization_id = ?  AND business_date = ?  AND rtl_loc_id = ?  AND party_id = ?  AND timecard_entry_id = ?  AND wkstn_id = ?  AND timecard_entry_seq = ?  AND property_code = ?  ";
/*     */   
/*     */   public String[] getDelete() {
/*  94 */     return DELETE_OBJECT;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWhere() {
/* 100 */     return " WHERE organization_id = ?  AND business_date = ?  AND rtl_loc_id = ?  AND party_id = ?  AND timecard_entry_id = ?  AND wkstn_id = ?  AND timecard_entry_seq = ?  AND property_code = ?  ";
/*     */   }
/*     */   public Object[] getWhereParameters() {
/* 103 */     return new Object[] { this._organizationId, this._businessDate, this._retailLocationId, this._partyId, this._timecardEntryId, this._workstationId, this._timecardEntrySeq, this._propertyCode };
/*     */   }
/*     */   
/* 106 */   private static final int[] WHERE_PARAMETER_OBJECT = new int[] { -5, 91, -5, -5, -5, -5, -5, 12 };
/*     */   
/*     */   public int[] getWhereParameterTypes() {
/* 109 */     return WHERE_PARAMETER_OBJECT;
/*     */   }
/*     */   public String getTableName() {
/* 112 */     return "thr_timecard_journal_p";
/*     */   }
/*     */   
/*     */   public IFiller getFiller() {
/* 116 */     return getFillerImpl();
/*     */   }
/*     */   
/*     */   private IFiller getFillerImpl() {
/* 120 */     return new TimecardJournalPropertyFiller(this);
/*     */   }
/*     */   
/*     */   private static class TimecardJournalPropertyFiller
/*     */     implements IFiller {
/*     */     private TimecardJournalPropertyDBA _parent;
/*     */     
/*     */     public TimecardJournalPropertyFiller(TimecardJournalPropertyDBA argParent) {
/* 128 */       this._parent = argParent;
/*     */     }
/*     */ 
/*     */     
/*     */     public void fill(ResultSet argResultSet) throws SQLException {
/* 133 */       long primitiveResult = argResultSet.getLong(1);
/* 134 */       if (primitiveResult != 0L || argResultSet.getObject(1) != null) {
/* 135 */         this._parent._organizationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 140 */       Timestamp t2 = argResultSet.getTimestamp(2);
/* 141 */       if (t2 != null) {
/* 142 */         this._parent._businessDate = (Date)new DtvDate(t2.getTime());
/*     */       } else {
/*     */         
/* 145 */         this._parent._businessDate = null;
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/* 150 */       long l1 = argResultSet.getLong(3);
/* 151 */       if (l1 != 0L || argResultSet.getObject(3) != null) {
/* 152 */         this._parent._retailLocationId = Long.valueOf(l1);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 158 */       l1 = argResultSet.getLong(4);
/* 159 */       if (l1 != 0L || argResultSet.getObject(4) != null) {
/* 160 */         this._parent._partyId = Long.valueOf(l1);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 166 */       l1 = argResultSet.getLong(5);
/* 167 */       if (l1 != 0L || argResultSet.getObject(5) != null) {
/* 168 */         this._parent._timecardEntryId = Long.valueOf(l1);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 174 */       l1 = argResultSet.getLong(6);
/* 175 */       if (l1 != 0L || argResultSet.getObject(6) != null) {
/* 176 */         this._parent._workstationId = Long.valueOf(l1);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 182 */       l1 = argResultSet.getLong(7);
/* 183 */       if (l1 != 0L || argResultSet.getObject(7) != null) {
/* 184 */         this._parent._timecardEntrySeq = Long.valueOf(l1);
/*     */       }
/*     */ 
/*     */       
/* 188 */       this._parent._propertyCode = argResultSet.getString(8);
/* 189 */       this._parent._type = argResultSet.getString(9);
/* 190 */       this._parent._stringValue = argResultSet.getString(10);
/*     */       
/* 192 */       Timestamp t11 = argResultSet.getTimestamp(11);
/* 193 */       if (t11 != null) {
/* 194 */         this._parent._dateValue = (Date)new DtvDate(t11.getTime());
/*     */       } else {
/*     */         
/* 197 */         this._parent._dateValue = null;
/*     */       } 
/*     */       
/* 200 */       this._parent._decimalValue = argResultSet.getBigDecimal(12);
/*     */       
/* 202 */       Timestamp t13 = argResultSet.getTimestamp(13);
/* 203 */       if (t13 != null) {
/* 204 */         this._parent._createDate = (Date)new DtvDate(t13.getTime());
/*     */       } else {
/*     */         
/* 207 */         this._parent._createDate = null;
/*     */       } 
/*     */       
/* 210 */       this._parent._createUserId = argResultSet.getString(14);
/*     */       
/* 212 */       Timestamp t15 = argResultSet.getTimestamp(15);
/* 213 */       if (t15 != null) {
/* 214 */         this._parent._updateDate = (Date)new DtvDate(t15.getTime());
/*     */       } else {
/*     */         
/* 217 */         this._parent._updateDate = null;
/*     */       } 
/*     */       
/* 220 */       this._parent._updateUserId = argResultSet.getString(16);
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDAO(IDataAccessObject argDAO) {
/* 225 */     argDAO.suppressStateChanges(true);
/* 226 */     TimecardJournalPropertyDAO dao = (TimecardJournalPropertyDAO)argDAO;
/* 227 */     dao.setOrganizationId(this._organizationId);
/* 228 */     dao.setBusinessDate(this._businessDate);
/* 229 */     dao.setRetailLocationId(this._retailLocationId);
/* 230 */     dao.setPartyId(this._partyId);
/* 231 */     dao.setTimecardEntryId(this._timecardEntryId);
/* 232 */     dao.setWorkstationId(this._workstationId);
/* 233 */     dao.setTimecardEntrySeq(this._timecardEntrySeq);
/* 234 */     dao.setPropertyCode(this._propertyCode);
/* 235 */     dao.setType(this._type);
/* 236 */     dao.setStringValue(this._stringValue);
/* 237 */     dao.setDateValue(this._dateValue);
/* 238 */     dao.setDecimalValue(this._decimalValue);
/* 239 */     dao.setCreateDate(this._createDate);
/* 240 */     dao.setCreateUserId(this._createUserId);
/* 241 */     dao.setUpdateDate(this._updateDate);
/* 242 */     dao.setUpdateUserId(this._updateUserId);
/* 243 */     argDAO.suppressStateChanges(false);
/* 244 */     return (IDataAccessObject)dao;
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDefaultDAO() {
/* 248 */     return loadDAO((IDataAccessObject)new TimecardJournalPropertyDAO());
/*     */   }
/*     */   
/*     */   public void fill(IDataAccessObject argDAO) {
/* 252 */     TimecardJournalPropertyDAO dao = (TimecardJournalPropertyDAO)argDAO;
/* 253 */     this._organizationId = dao.getOrganizationId();
/* 254 */     this._businessDate = dao.getBusinessDate();
/* 255 */     this._retailLocationId = dao.getRetailLocationId();
/* 256 */     this._partyId = dao.getPartyId();
/* 257 */     this._timecardEntryId = dao.getTimecardEntryId();
/* 258 */     this._workstationId = dao.getWorkstationId();
/* 259 */     this._timecardEntrySeq = dao.getTimecardEntrySeq();
/* 260 */     this._propertyCode = dao.getPropertyCode();
/* 261 */     this._type = dao.getType();
/* 262 */     this._stringValue = dao.getStringValue();
/* 263 */     this._dateValue = dao.getDateValue();
/* 264 */     this._decimalValue = dao.getDecimalValue();
/* 265 */     this._createDate = dao.getCreateDate();
/* 266 */     this._createUserId = dao.getCreateUserId();
/* 267 */     this._updateDate = dao.getUpdateDate();
/* 268 */     this._updateUserId = dao.getUpdateUserId();
/*     */   }
/*     */   
/*     */   public PreparedStatement writeObjectId(IObjectId argId, PreparedStatement argStatement) throws SQLException {
/* 272 */     TimecardJournalPropertyId id = (TimecardJournalPropertyId)argId;
/* 273 */     argStatement.setLong(1, id.getOrganizationId().longValue());
/* 274 */     argStatement.setTimestamp(2, new Timestamp(id.getBusinessDate().getTime()));
/* 275 */     argStatement.setLong(3, id.getRetailLocationId().longValue());
/* 276 */     argStatement.setLong(4, id.getPartyId().longValue());
/* 277 */     argStatement.setLong(5, id.getTimecardEntryId().longValue());
/* 278 */     argStatement.setLong(6, id.getWorkstationId().longValue());
/* 279 */     argStatement.setLong(7, id.getTimecardEntrySeq().longValue());
/* 280 */     argStatement.setString(8, id.getPropertyCode());
/* 281 */     return argStatement;
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 285 */     TimecardJournalPropertyId id = new TimecardJournalPropertyId();
/* 286 */     id.setOrganizationId(this._organizationId);
/* 287 */     id.setBusinessDate(this._businessDate);
/* 288 */     id.setRetailLocationId(this._retailLocationId);
/* 289 */     id.setPartyId(this._partyId);
/* 290 */     id.setTimecardEntryId(this._timecardEntryId);
/* 291 */     id.setWorkstationId(this._workstationId);
/* 292 */     id.setTimecardEntrySeq(this._timecardEntrySeq);
/* 293 */     id.setPropertyCode(this._propertyCode);
/* 294 */     return (IObjectId)id;
/*     */   }
/*     */ 
/*     */   
/*     */   public void fill(IJDBCTableAdapter argAdapter) {}
/*     */ 
/*     */   
/*     */   public boolean isExtensible() {
/* 302 */     return false;
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 306 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\thr\impl\TimecardJournalPropertyDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */