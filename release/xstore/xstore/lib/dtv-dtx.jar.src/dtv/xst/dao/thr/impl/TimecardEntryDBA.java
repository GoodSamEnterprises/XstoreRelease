/*     */ package dtv.xst.dao.thr.impl;
/*     */ 
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.impl.jdbc.IFiller;
/*     */ import dtv.data2.access.impl.jdbc.IJDBCTableAdapter;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.thr.TimecardEntryId;
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
/*     */ 
/*     */ public class TimecardEntryDBA
/*     */   implements IJDBCTableAdapter
/*     */ {
/*     */   private static final long serialVersionUID = 556317429L;
/*     */   private Long _organizationId;
/*     */   private Date _businessDate;
/*     */   private Long _retailLocationId;
/*     */   private Long _partyId;
/*     */   private Long _timecardEntryId;
/*     */   private Long _workstationId;
/*     */   private Date _createDate;
/*     */   private String _createUserId;
/*     */   private Date _updateDate;
/*     */   private String _updateUserId;
/*     */   private Date _clockInDateTime;
/*     */   private Date _clockOutDateTime;
/*     */   private String _entryType;
/*     */   private Boolean _delete;
/*     */   private Boolean _openRecord;
/*     */   private Long _duration;
/*     */   private Boolean _payrollUpdateRequired;
/*     */   private String _workCodeString;
/*     */   private static final String SELECT_OBJECT = "SELECT t.organization_id, t.business_date, t.rtl_loc_id, t.party_id, t.timecard_entry_id, t.wkstn_id, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.clock_in_timestamp, t.clock_out_timestamp, t.entry_type_enum, t.delete_flag, t.open_record_flag, t.duration, t.payroll_update_required, t.work_code FROM thr_timecard_entry t";
/*     */   private static final String SELECT_WHERE_OBJECT = " WHERE organization_id = ?  AND business_date = ?  AND rtl_loc_id = ?  AND party_id = ?  AND timecard_entry_id = ?  AND wkstn_id = ?  ";
/*     */   
/*     */   public String getSelect() {
/*  47 */     return getSelectImpl();
/*     */   }
/*     */   
/*     */   private String getSelectImpl() {
/*  51 */     return "SELECT t.organization_id, t.business_date, t.rtl_loc_id, t.party_id, t.timecard_entry_id, t.wkstn_id, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.clock_in_timestamp, t.clock_out_timestamp, t.entry_type_enum, t.delete_flag, t.open_record_flag, t.duration, t.payroll_update_required, t.work_code FROM thr_timecard_entry t";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectWhere() {
/*  57 */     return " WHERE organization_id = ?  AND business_date = ?  AND rtl_loc_id = ?  AND party_id = ?  AND timecard_entry_id = ?  AND wkstn_id = ?  ";
/*     */   }
/*     */   
/*  60 */   private static final String[] INSERT_OBJECT = new String[] { "INSERT INTO thr_timecard_entry(organization_id, business_date, rtl_loc_id, party_id, timecard_entry_id, wkstn_id, create_date, create_user_id, update_date, update_user_id, clock_in_timestamp, clock_out_timestamp, entry_type_enum, delete_flag, open_record_flag, duration, payroll_update_required, work_code) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" };
/*     */   
/*     */   public String[] getInsert() {
/*  63 */     return INSERT_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getInsertParameters() {
/*  67 */     Object[][] insertParameterObject = { { this._organizationId, this._businessDate, this._retailLocationId, this._partyId, this._timecardEntryId, this._workstationId, this._createDate, this._createUserId, this._updateDate, this._updateUserId, this._clockInDateTime, this._clockOutDateTime, this._entryType, this._delete, this._openRecord, this._duration, this._payrollUpdateRequired, this._workCodeString } };
/*  68 */     return insertParameterObject;
/*     */   }
/*     */   
/*  71 */   private static final int[][] INSERT_PARAMETER_TYPES_OBJECT = new int[][] { { -5, 91, -5, -5, -5, -5, 91, 12, 91, 12, 91, 91, 12, -7, -7, -5, -7, 12 } };
/*     */   
/*     */   public int[][] getInsertParameterTypes() {
/*  74 */     return INSERT_PARAMETER_TYPES_OBJECT;
/*     */   }
/*     */   
/*  77 */   private static final String[] UPDATE_OBJECT = new String[] { "UPDATE thr_timecard_entry SET update_date = ?, update_user_id = ?, clock_in_timestamp = ?, clock_out_timestamp = ?, entry_type_enum = ?, delete_flag = ?, open_record_flag = ?, duration = ?, payroll_update_required = ?, work_code = ?" };
/*     */   
/*     */   public String[] getUpdate() {
/*  80 */     return UPDATE_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getUpdateParameters() {
/*  84 */     Object[][] updateParameterObject = { { this._updateDate, this._updateUserId, this._clockInDateTime, this._clockOutDateTime, this._entryType, this._delete, this._openRecord, this._duration, this._payrollUpdateRequired, this._workCodeString } };
/*  85 */     return updateParameterObject;
/*     */   }
/*     */   
/*  88 */   private static final int[][] UPDATE_PARAMETER_TYPE_OBJECT = new int[][] { { 91, 12, 91, 91, 12, -7, -7, -5, -7, 12 } };
/*     */   public int[][] getUpdateParameterTypes() {
/*  90 */     return UPDATE_PARAMETER_TYPE_OBJECT;
/*     */   }
/*     */   
/*  93 */   private static final String[] DELETE_OBJECT = new String[] { "DELETE FROM thr_timecard_entry" }; private static final String WHERE_OBJECT = " WHERE organization_id = ?  AND business_date = ?  AND rtl_loc_id = ?  AND party_id = ?  AND timecard_entry_id = ?  AND wkstn_id = ?  ";
/*     */   
/*     */   public String[] getDelete() {
/*  96 */     return DELETE_OBJECT;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWhere() {
/* 102 */     return " WHERE organization_id = ?  AND business_date = ?  AND rtl_loc_id = ?  AND party_id = ?  AND timecard_entry_id = ?  AND wkstn_id = ?  ";
/*     */   }
/*     */   public Object[] getWhereParameters() {
/* 105 */     return new Object[] { this._organizationId, this._businessDate, this._retailLocationId, this._partyId, this._timecardEntryId, this._workstationId };
/*     */   }
/*     */   
/* 108 */   private static final int[] WHERE_PARAMETER_OBJECT = new int[] { -5, 91, -5, -5, -5, -5 };
/*     */   
/*     */   public int[] getWhereParameterTypes() {
/* 111 */     return WHERE_PARAMETER_OBJECT;
/*     */   }
/*     */   public String getTableName() {
/* 114 */     return "thr_timecard_entry";
/*     */   }
/*     */   
/*     */   public IFiller getFiller() {
/* 118 */     return getFillerImpl();
/*     */   }
/*     */   
/*     */   private IFiller getFillerImpl() {
/* 122 */     return new TimecardEntryFiller(this);
/*     */   }
/*     */   
/*     */   private static class TimecardEntryFiller
/*     */     implements IFiller {
/*     */     private TimecardEntryDBA _parent;
/*     */     
/*     */     public TimecardEntryFiller(TimecardEntryDBA argParent) {
/* 130 */       this._parent = argParent;
/*     */     }
/*     */ 
/*     */     
/*     */     public void fill(ResultSet argResultSet) throws SQLException {
/* 135 */       long primitiveResult = argResultSet.getLong(1);
/* 136 */       if (primitiveResult != 0L || argResultSet.getObject(1) != null) {
/* 137 */         this._parent._organizationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 142 */       Timestamp t2 = argResultSet.getTimestamp(2);
/* 143 */       if (t2 != null) {
/* 144 */         this._parent._businessDate = (Date)new DtvDate(t2.getTime());
/*     */       } else {
/*     */         
/* 147 */         this._parent._businessDate = null;
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/* 152 */       long l1 = argResultSet.getLong(3);
/* 153 */       if (l1 != 0L || argResultSet.getObject(3) != null) {
/* 154 */         this._parent._retailLocationId = Long.valueOf(l1);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 160 */       l1 = argResultSet.getLong(4);
/* 161 */       if (l1 != 0L || argResultSet.getObject(4) != null) {
/* 162 */         this._parent._partyId = Long.valueOf(l1);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 168 */       l1 = argResultSet.getLong(5);
/* 169 */       if (l1 != 0L || argResultSet.getObject(5) != null) {
/* 170 */         this._parent._timecardEntryId = Long.valueOf(l1);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 176 */       l1 = argResultSet.getLong(6);
/* 177 */       if (l1 != 0L || argResultSet.getObject(6) != null) {
/* 178 */         this._parent._workstationId = Long.valueOf(l1);
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 183 */       Timestamp t7 = argResultSet.getTimestamp(7);
/* 184 */       if (t7 != null) {
/* 185 */         this._parent._createDate = (Date)new DtvDate(t7.getTime());
/*     */       } else {
/*     */         
/* 188 */         this._parent._createDate = null;
/*     */       } 
/*     */       
/* 191 */       this._parent._createUserId = argResultSet.getString(8);
/*     */       
/* 193 */       Timestamp t9 = argResultSet.getTimestamp(9);
/* 194 */       if (t9 != null) {
/* 195 */         this._parent._updateDate = (Date)new DtvDate(t9.getTime());
/*     */       } else {
/*     */         
/* 198 */         this._parent._updateDate = null;
/*     */       } 
/*     */       
/* 201 */       this._parent._updateUserId = argResultSet.getString(10);
/*     */       
/* 203 */       Timestamp t11 = argResultSet.getTimestamp(11);
/* 204 */       if (t11 != null) {
/* 205 */         this._parent._clockInDateTime = (Date)new DtvDate(t11.getTime());
/*     */       } else {
/*     */         
/* 208 */         this._parent._clockInDateTime = null;
/*     */       } 
/*     */ 
/*     */       
/* 212 */       Timestamp t12 = argResultSet.getTimestamp(12);
/* 213 */       if (t12 != null) {
/* 214 */         this._parent._clockOutDateTime = (Date)new DtvDate(t12.getTime());
/*     */       } else {
/*     */         
/* 217 */         this._parent._clockOutDateTime = null;
/*     */       } 
/*     */       
/* 220 */       this._parent._entryType = argResultSet.getString(13);
/* 221 */       this._parent._delete = Boolean.valueOf(argResultSet.getBoolean(14));
/* 222 */       this._parent._openRecord = Boolean.valueOf(argResultSet.getBoolean(15));
/*     */ 
/*     */       
/* 225 */       long l2 = argResultSet.getLong(16);
/* 226 */       if (l2 != 0L || argResultSet.getObject(16) != null) {
/* 227 */         this._parent._duration = Long.valueOf(l2);
/*     */       }
/*     */ 
/*     */       
/* 231 */       this._parent._payrollUpdateRequired = Boolean.valueOf(argResultSet.getBoolean(17));
/* 232 */       this._parent._workCodeString = argResultSet.getString(18);
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDAO(IDataAccessObject argDAO) {
/* 237 */     argDAO.suppressStateChanges(true);
/* 238 */     TimecardEntryDAO dao = (TimecardEntryDAO)argDAO;
/* 239 */     dao.setOrganizationId(this._organizationId);
/* 240 */     dao.setBusinessDate(this._businessDate);
/* 241 */     dao.setRetailLocationId(this._retailLocationId);
/* 242 */     dao.setPartyId(this._partyId);
/* 243 */     dao.setTimecardEntryId(this._timecardEntryId);
/* 244 */     dao.setWorkstationId(this._workstationId);
/* 245 */     dao.setCreateDate(this._createDate);
/* 246 */     dao.setCreateUserId(this._createUserId);
/* 247 */     dao.setUpdateDate(this._updateDate);
/* 248 */     dao.setUpdateUserId(this._updateUserId);
/* 249 */     dao.setClockInDateTime(this._clockInDateTime);
/* 250 */     dao.setClockOutDateTime(this._clockOutDateTime);
/* 251 */     dao.setEntryType(this._entryType);
/* 252 */     dao.setDelete(this._delete);
/* 253 */     dao.setOpenRecord(this._openRecord);
/* 254 */     dao.setDuration(this._duration);
/* 255 */     dao.setPayrollUpdateRequired(this._payrollUpdateRequired);
/* 256 */     dao.setWorkCodeString(this._workCodeString);
/* 257 */     argDAO.suppressStateChanges(false);
/* 258 */     return (IDataAccessObject)dao;
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDefaultDAO() {
/* 262 */     return loadDAO((IDataAccessObject)new TimecardEntryDAO());
/*     */   }
/*     */   
/*     */   public void fill(IDataAccessObject argDAO) {
/* 266 */     TimecardEntryDAO dao = (TimecardEntryDAO)argDAO;
/* 267 */     this._organizationId = dao.getOrganizationId();
/* 268 */     this._businessDate = dao.getBusinessDate();
/* 269 */     this._retailLocationId = dao.getRetailLocationId();
/* 270 */     this._partyId = dao.getPartyId();
/* 271 */     this._timecardEntryId = dao.getTimecardEntryId();
/* 272 */     this._workstationId = dao.getWorkstationId();
/* 273 */     this._createDate = dao.getCreateDate();
/* 274 */     this._createUserId = dao.getCreateUserId();
/* 275 */     this._updateDate = dao.getUpdateDate();
/* 276 */     this._updateUserId = dao.getUpdateUserId();
/* 277 */     this._clockInDateTime = dao.getClockInDateTime();
/* 278 */     this._clockOutDateTime = dao.getClockOutDateTime();
/* 279 */     this._entryType = dao.getEntryType();
/* 280 */     this._delete = (dao.getDelete() != null) ? dao.getDelete() : Boolean.valueOf(false);
/* 281 */     this._openRecord = (dao.getOpenRecord() != null) ? dao.getOpenRecord() : Boolean.valueOf(false);
/* 282 */     this._duration = dao.getDuration();
/* 283 */     this._payrollUpdateRequired = (dao.getPayrollUpdateRequired() != null) ? dao.getPayrollUpdateRequired() : Boolean.valueOf(false);
/* 284 */     this._workCodeString = dao.getWorkCodeString();
/*     */   }
/*     */   
/*     */   public PreparedStatement writeObjectId(IObjectId argId, PreparedStatement argStatement) throws SQLException {
/* 288 */     TimecardEntryId id = (TimecardEntryId)argId;
/* 289 */     argStatement.setLong(1, id.getOrganizationId().longValue());
/* 290 */     argStatement.setTimestamp(2, new Timestamp(id.getBusinessDate().getTime()));
/* 291 */     argStatement.setLong(3, id.getRetailLocationId().longValue());
/* 292 */     argStatement.setLong(4, id.getPartyId().longValue());
/* 293 */     argStatement.setLong(5, id.getTimecardEntryId().longValue());
/* 294 */     argStatement.setLong(6, id.getWorkstationId().longValue());
/* 295 */     return argStatement;
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 299 */     TimecardEntryId id = new TimecardEntryId();
/* 300 */     id.setOrganizationId(this._organizationId);
/* 301 */     id.setBusinessDate(this._businessDate);
/* 302 */     id.setRetailLocationId(this._retailLocationId);
/* 303 */     id.setPartyId(this._partyId);
/* 304 */     id.setTimecardEntryId(this._timecardEntryId);
/* 305 */     id.setWorkstationId(this._workstationId);
/* 306 */     return (IObjectId)id;
/*     */   }
/*     */ 
/*     */   
/*     */   public void fill(IJDBCTableAdapter argAdapter) {}
/*     */ 
/*     */   
/*     */   public boolean isExtensible() {
/* 314 */     return false;
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 318 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\thr\impl\TimecardEntryDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */