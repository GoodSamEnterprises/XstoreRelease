/*     */ package dtv.xst.dao.thr.impl;
/*     */ 
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.impl.jdbc.IFiller;
/*     */ import dtv.data2.access.impl.jdbc.IJDBCTableAdapter;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.thr.TimecardJournalId;
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
/*     */ public class TimecardJournalDBA
/*     */   implements IJDBCTableAdapter
/*     */ {
/*     */   private static final long serialVersionUID = -2077766406L;
/*     */   private Long _organizationId;
/*     */   private Date _businessDate;
/*     */   private Long _retailLocationId;
/*     */   private Long _partyId;
/*     */   private Long _timecardEntryId;
/*     */   private Long _workstationId;
/*     */   private Long _timecardEntrySeq;
/*     */   private Date _createDate;
/*     */   private String _createUserId;
/*     */   private Date _updateDate;
/*     */   private String _updateUserId;
/*     */   private Date _clockInDateTime;
/*     */   private Date _clockOutDateTime;
/*     */   private String _entryType;
/*     */   private Boolean _delete;
/*     */   private String _workCodeString;
/*     */   private static final String SELECT_OBJECT = "SELECT t.organization_id, t.business_date, t.rtl_loc_id, t.party_id, t.timecard_entry_id, t.wkstn_id, t.timecard_entry_seq, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.clock_in_timestamp, t.clock_out_timestamp, t.entry_type_enum, t.delete_flag, t.work_code FROM thr_timecard_journal t";
/*     */   private static final String SELECT_WHERE_OBJECT = " WHERE organization_id = ?  AND business_date = ?  AND rtl_loc_id = ?  AND party_id = ?  AND timecard_entry_id = ?  AND wkstn_id = ?  AND timecard_entry_seq = ?  ";
/*     */   
/*     */   public String getSelect() {
/*  45 */     return getSelectImpl();
/*     */   }
/*     */   
/*     */   private String getSelectImpl() {
/*  49 */     return "SELECT t.organization_id, t.business_date, t.rtl_loc_id, t.party_id, t.timecard_entry_id, t.wkstn_id, t.timecard_entry_seq, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.clock_in_timestamp, t.clock_out_timestamp, t.entry_type_enum, t.delete_flag, t.work_code FROM thr_timecard_journal t";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectWhere() {
/*  55 */     return " WHERE organization_id = ?  AND business_date = ?  AND rtl_loc_id = ?  AND party_id = ?  AND timecard_entry_id = ?  AND wkstn_id = ?  AND timecard_entry_seq = ?  ";
/*     */   }
/*     */   
/*  58 */   private static final String[] INSERT_OBJECT = new String[] { "INSERT INTO thr_timecard_journal(organization_id, business_date, rtl_loc_id, party_id, timecard_entry_id, wkstn_id, timecard_entry_seq, create_date, create_user_id, update_date, update_user_id, clock_in_timestamp, clock_out_timestamp, entry_type_enum, delete_flag, work_code) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" };
/*     */   
/*     */   public String[] getInsert() {
/*  61 */     return INSERT_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getInsertParameters() {
/*  65 */     Object[][] insertParameterObject = { { this._organizationId, this._businessDate, this._retailLocationId, this._partyId, this._timecardEntryId, this._workstationId, this._timecardEntrySeq, this._createDate, this._createUserId, this._updateDate, this._updateUserId, this._clockInDateTime, this._clockOutDateTime, this._entryType, this._delete, this._workCodeString } };
/*  66 */     return insertParameterObject;
/*     */   }
/*     */   
/*  69 */   private static final int[][] INSERT_PARAMETER_TYPES_OBJECT = new int[][] { { -5, 91, -5, -5, -5, -5, -5, 91, 12, 91, 12, 91, 91, 12, -7, 12 } };
/*     */   
/*     */   public int[][] getInsertParameterTypes() {
/*  72 */     return INSERT_PARAMETER_TYPES_OBJECT;
/*     */   }
/*     */   
/*  75 */   private static final String[] UPDATE_OBJECT = new String[] { "UPDATE thr_timecard_journal SET update_date = ?, update_user_id = ?, clock_in_timestamp = ?, clock_out_timestamp = ?, entry_type_enum = ?, delete_flag = ?, work_code = ?" };
/*     */   
/*     */   public String[] getUpdate() {
/*  78 */     return UPDATE_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getUpdateParameters() {
/*  82 */     Object[][] updateParameterObject = { { this._updateDate, this._updateUserId, this._clockInDateTime, this._clockOutDateTime, this._entryType, this._delete, this._workCodeString } };
/*  83 */     return updateParameterObject;
/*     */   }
/*     */   
/*  86 */   private static final int[][] UPDATE_PARAMETER_TYPE_OBJECT = new int[][] { { 91, 12, 91, 91, 12, -7, 12 } };
/*     */   public int[][] getUpdateParameterTypes() {
/*  88 */     return UPDATE_PARAMETER_TYPE_OBJECT;
/*     */   }
/*     */   
/*  91 */   private static final String[] DELETE_OBJECT = new String[] { "DELETE FROM thr_timecard_journal" }; private static final String WHERE_OBJECT = " WHERE organization_id = ?  AND business_date = ?  AND rtl_loc_id = ?  AND party_id = ?  AND timecard_entry_id = ?  AND wkstn_id = ?  AND timecard_entry_seq = ?  ";
/*     */   
/*     */   public String[] getDelete() {
/*  94 */     return DELETE_OBJECT;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWhere() {
/* 100 */     return " WHERE organization_id = ?  AND business_date = ?  AND rtl_loc_id = ?  AND party_id = ?  AND timecard_entry_id = ?  AND wkstn_id = ?  AND timecard_entry_seq = ?  ";
/*     */   }
/*     */   public Object[] getWhereParameters() {
/* 103 */     return new Object[] { this._organizationId, this._businessDate, this._retailLocationId, this._partyId, this._timecardEntryId, this._workstationId, this._timecardEntrySeq };
/*     */   }
/*     */   
/* 106 */   private static final int[] WHERE_PARAMETER_OBJECT = new int[] { -5, 91, -5, -5, -5, -5, -5 };
/*     */   
/*     */   public int[] getWhereParameterTypes() {
/* 109 */     return WHERE_PARAMETER_OBJECT;
/*     */   }
/*     */   public String getTableName() {
/* 112 */     return "thr_timecard_journal";
/*     */   }
/*     */   
/*     */   public IFiller getFiller() {
/* 116 */     return getFillerImpl();
/*     */   }
/*     */   
/*     */   private IFiller getFillerImpl() {
/* 120 */     return new TimecardJournalFiller(this);
/*     */   }
/*     */   
/*     */   private static class TimecardJournalFiller
/*     */     implements IFiller {
/*     */     private TimecardJournalDBA _parent;
/*     */     
/*     */     public TimecardJournalFiller(TimecardJournalDBA argParent) {
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
/*     */       
/* 189 */       Timestamp t8 = argResultSet.getTimestamp(8);
/* 190 */       if (t8 != null) {
/* 191 */         this._parent._createDate = (Date)new DtvDate(t8.getTime());
/*     */       } else {
/*     */         
/* 194 */         this._parent._createDate = null;
/*     */       } 
/*     */       
/* 197 */       this._parent._createUserId = argResultSet.getString(9);
/*     */       
/* 199 */       Timestamp t10 = argResultSet.getTimestamp(10);
/* 200 */       if (t10 != null) {
/* 201 */         this._parent._updateDate = (Date)new DtvDate(t10.getTime());
/*     */       } else {
/*     */         
/* 204 */         this._parent._updateDate = null;
/*     */       } 
/*     */       
/* 207 */       this._parent._updateUserId = argResultSet.getString(11);
/*     */       
/* 209 */       Timestamp t12 = argResultSet.getTimestamp(12);
/* 210 */       if (t12 != null) {
/* 211 */         this._parent._clockInDateTime = (Date)new DtvDate(t12.getTime());
/*     */       } else {
/*     */         
/* 214 */         this._parent._clockInDateTime = null;
/*     */       } 
/*     */ 
/*     */       
/* 218 */       Timestamp t13 = argResultSet.getTimestamp(13);
/* 219 */       if (t13 != null) {
/* 220 */         this._parent._clockOutDateTime = (Date)new DtvDate(t13.getTime());
/*     */       } else {
/*     */         
/* 223 */         this._parent._clockOutDateTime = null;
/*     */       } 
/*     */       
/* 226 */       this._parent._entryType = argResultSet.getString(14);
/* 227 */       this._parent._delete = Boolean.valueOf(argResultSet.getBoolean(15));
/* 228 */       this._parent._workCodeString = argResultSet.getString(16);
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDAO(IDataAccessObject argDAO) {
/* 233 */     argDAO.suppressStateChanges(true);
/* 234 */     TimecardJournalDAO dao = (TimecardJournalDAO)argDAO;
/* 235 */     dao.setOrganizationId(this._organizationId);
/* 236 */     dao.setBusinessDate(this._businessDate);
/* 237 */     dao.setRetailLocationId(this._retailLocationId);
/* 238 */     dao.setPartyId(this._partyId);
/* 239 */     dao.setTimecardEntryId(this._timecardEntryId);
/* 240 */     dao.setWorkstationId(this._workstationId);
/* 241 */     dao.setTimecardEntrySeq(this._timecardEntrySeq);
/* 242 */     dao.setCreateDate(this._createDate);
/* 243 */     dao.setCreateUserId(this._createUserId);
/* 244 */     dao.setUpdateDate(this._updateDate);
/* 245 */     dao.setUpdateUserId(this._updateUserId);
/* 246 */     dao.setClockInDateTime(this._clockInDateTime);
/* 247 */     dao.setClockOutDateTime(this._clockOutDateTime);
/* 248 */     dao.setEntryType(this._entryType);
/* 249 */     dao.setDelete(this._delete);
/* 250 */     dao.setWorkCodeString(this._workCodeString);
/* 251 */     argDAO.suppressStateChanges(false);
/* 252 */     return (IDataAccessObject)dao;
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDefaultDAO() {
/* 256 */     return loadDAO((IDataAccessObject)new TimecardJournalDAO());
/*     */   }
/*     */   
/*     */   public void fill(IDataAccessObject argDAO) {
/* 260 */     TimecardJournalDAO dao = (TimecardJournalDAO)argDAO;
/* 261 */     this._organizationId = dao.getOrganizationId();
/* 262 */     this._businessDate = dao.getBusinessDate();
/* 263 */     this._retailLocationId = dao.getRetailLocationId();
/* 264 */     this._partyId = dao.getPartyId();
/* 265 */     this._timecardEntryId = dao.getTimecardEntryId();
/* 266 */     this._workstationId = dao.getWorkstationId();
/* 267 */     this._timecardEntrySeq = dao.getTimecardEntrySeq();
/* 268 */     this._createDate = dao.getCreateDate();
/* 269 */     this._createUserId = dao.getCreateUserId();
/* 270 */     this._updateDate = dao.getUpdateDate();
/* 271 */     this._updateUserId = dao.getUpdateUserId();
/* 272 */     this._clockInDateTime = dao.getClockInDateTime();
/* 273 */     this._clockOutDateTime = dao.getClockOutDateTime();
/* 274 */     this._entryType = dao.getEntryType();
/* 275 */     this._delete = (dao.getDelete() != null) ? dao.getDelete() : Boolean.valueOf(false);
/* 276 */     this._workCodeString = dao.getWorkCodeString();
/*     */   }
/*     */   
/*     */   public PreparedStatement writeObjectId(IObjectId argId, PreparedStatement argStatement) throws SQLException {
/* 280 */     TimecardJournalId id = (TimecardJournalId)argId;
/* 281 */     argStatement.setLong(1, id.getOrganizationId().longValue());
/* 282 */     argStatement.setTimestamp(2, new Timestamp(id.getBusinessDate().getTime()));
/* 283 */     argStatement.setLong(3, id.getRetailLocationId().longValue());
/* 284 */     argStatement.setLong(4, id.getPartyId().longValue());
/* 285 */     argStatement.setLong(5, id.getTimecardEntryId().longValue());
/* 286 */     argStatement.setLong(6, id.getWorkstationId().longValue());
/* 287 */     argStatement.setLong(7, id.getTimecardEntrySeq().longValue());
/* 288 */     return argStatement;
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 292 */     TimecardJournalId id = new TimecardJournalId();
/* 293 */     id.setOrganizationId(this._organizationId);
/* 294 */     id.setBusinessDate(this._businessDate);
/* 295 */     id.setRetailLocationId(this._retailLocationId);
/* 296 */     id.setPartyId(this._partyId);
/* 297 */     id.setTimecardEntryId(this._timecardEntryId);
/* 298 */     id.setWorkstationId(this._workstationId);
/* 299 */     id.setTimecardEntrySeq(this._timecardEntrySeq);
/* 300 */     return (IObjectId)id;
/*     */   }
/*     */ 
/*     */   
/*     */   public void fill(IJDBCTableAdapter argAdapter) {}
/*     */ 
/*     */   
/*     */   public boolean isExtensible() {
/* 308 */     return false;
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 312 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\thr\impl\TimecardJournalDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */