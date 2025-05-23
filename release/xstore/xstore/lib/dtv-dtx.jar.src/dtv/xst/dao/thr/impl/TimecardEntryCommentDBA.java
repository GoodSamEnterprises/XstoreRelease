/*     */ package dtv.xst.dao.thr.impl;
/*     */ 
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.impl.jdbc.IFiller;
/*     */ import dtv.data2.access.impl.jdbc.IJDBCTableAdapter;
/*     */ import dtv.data2.access.impl.jdbc.JDBCHelper;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.thr.TimecardEntryCommentId;
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
/*     */ public class TimecardEntryCommentDBA
/*     */   implements IJDBCTableAdapter
/*     */ {
/*     */   private static final long serialVersionUID = 1657830826L;
/*     */   private Long _organizationId;
/*     */   private Date _weekEndingDate;
/*     */   private Long _retailLocationId;
/*     */   private Long _workstationId;
/*     */   private Long _partyId;
/*     */   private Long _commentSeq;
/*     */   private Date _createDate;
/*     */   private String _createUserId;
/*     */   private Date _updateDate;
/*     */   private String _updateUserId;
/*     */   private Date _commentDateTime;
/*     */   private String _commentText;
/*     */   private String _creatorId;
/*     */   private Date _businessDate;
/*     */   private Long _timecardEntryId;
/*     */   private static final String SELECT_OBJECT = "SELECT t.organization_id, t.week_ending_date, t.rtl_loc_id, t.wkstn_id, t.party_id, t.comment_seq, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.comment_timestamp, t.comment_text, t.creator_id, t.business_date, t.timecard_entry_id FROM thr_timecard_entry_comment t";
/*     */   private static final String SELECT_WHERE_OBJECT = " WHERE organization_id = ?  AND week_ending_date = ?  AND rtl_loc_id = ?  AND wkstn_id = ?  AND party_id = ?  AND comment_seq = ?  ";
/*     */   
/*     */   public String getSelect() {
/*  44 */     return getSelectImpl();
/*     */   }
/*     */   
/*     */   private String getSelectImpl() {
/*  48 */     return "SELECT t.organization_id, t.week_ending_date, t.rtl_loc_id, t.wkstn_id, t.party_id, t.comment_seq, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.comment_timestamp, t.comment_text, t.creator_id, t.business_date, t.timecard_entry_id FROM thr_timecard_entry_comment t";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectWhere() {
/*  54 */     return " WHERE organization_id = ?  AND week_ending_date = ?  AND rtl_loc_id = ?  AND wkstn_id = ?  AND party_id = ?  AND comment_seq = ?  ";
/*     */   }
/*     */   
/*  57 */   private static final String[] INSERT_OBJECT = new String[] { "INSERT INTO thr_timecard_entry_comment(organization_id, week_ending_date, rtl_loc_id, wkstn_id, party_id, comment_seq, create_date, create_user_id, update_date, update_user_id, comment_timestamp, comment_text, creator_id, business_date, timecard_entry_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" };
/*     */   
/*     */   public String[] getInsert() {
/*  60 */     return INSERT_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getInsertParameters() {
/*  64 */     Object[][] insertParameterObject = { { this._organizationId, this._weekEndingDate, this._retailLocationId, this._workstationId, this._partyId, this._commentSeq, this._createDate, this._createUserId, this._updateDate, this._updateUserId, this._commentDateTime, this._commentText, this._creatorId, this._businessDate, this._timecardEntryId } };
/*  65 */     return insertParameterObject;
/*     */   }
/*     */   
/*  68 */   private static final int[][] INSERT_PARAMETER_TYPES_OBJECT = new int[][] { { -5, 91, -5, -5, -5, -5, 91, 12, 91, 12, 91, 2005, 12, 91, -5 } };
/*     */   
/*     */   public int[][] getInsertParameterTypes() {
/*  71 */     return INSERT_PARAMETER_TYPES_OBJECT;
/*     */   }
/*     */   
/*  74 */   private static final String[] UPDATE_OBJECT = new String[] { "UPDATE thr_timecard_entry_comment SET update_date = ?, update_user_id = ?, comment_timestamp = ?, comment_text = ?, creator_id = ?, business_date = ?, timecard_entry_id = ?" };
/*     */   
/*     */   public String[] getUpdate() {
/*  77 */     return UPDATE_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getUpdateParameters() {
/*  81 */     Object[][] updateParameterObject = { { this._updateDate, this._updateUserId, this._commentDateTime, this._commentText, this._creatorId, this._businessDate, this._timecardEntryId } };
/*  82 */     return updateParameterObject;
/*     */   }
/*     */   
/*  85 */   private static final int[][] UPDATE_PARAMETER_TYPE_OBJECT = new int[][] { { 91, 12, 91, 2005, 12, 91, -5 } };
/*     */   public int[][] getUpdateParameterTypes() {
/*  87 */     return UPDATE_PARAMETER_TYPE_OBJECT;
/*     */   }
/*     */   
/*  90 */   private static final String[] DELETE_OBJECT = new String[] { "DELETE FROM thr_timecard_entry_comment" }; private static final String WHERE_OBJECT = " WHERE organization_id = ?  AND week_ending_date = ?  AND rtl_loc_id = ?  AND wkstn_id = ?  AND party_id = ?  AND comment_seq = ?  ";
/*     */   
/*     */   public String[] getDelete() {
/*  93 */     return DELETE_OBJECT;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWhere() {
/*  99 */     return " WHERE organization_id = ?  AND week_ending_date = ?  AND rtl_loc_id = ?  AND wkstn_id = ?  AND party_id = ?  AND comment_seq = ?  ";
/*     */   }
/*     */   public Object[] getWhereParameters() {
/* 102 */     return new Object[] { this._organizationId, this._weekEndingDate, this._retailLocationId, this._workstationId, this._partyId, this._commentSeq };
/*     */   }
/*     */   
/* 105 */   private static final int[] WHERE_PARAMETER_OBJECT = new int[] { -5, 91, -5, -5, -5, -5 };
/*     */   
/*     */   public int[] getWhereParameterTypes() {
/* 108 */     return WHERE_PARAMETER_OBJECT;
/*     */   }
/*     */   public String getTableName() {
/* 111 */     return "thr_timecard_entry_comment";
/*     */   }
/*     */   
/*     */   public IFiller getFiller() {
/* 115 */     return getFillerImpl();
/*     */   }
/*     */   
/*     */   private IFiller getFillerImpl() {
/* 119 */     return new TimecardEntryCommentFiller(this);
/*     */   }
/*     */   
/*     */   private static class TimecardEntryCommentFiller
/*     */     implements IFiller {
/*     */     private TimecardEntryCommentDBA _parent;
/*     */     
/*     */     public TimecardEntryCommentFiller(TimecardEntryCommentDBA argParent) {
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
/* 141 */         this._parent._weekEndingDate = (Date)new DtvDate(t2.getTime());
/*     */       } else {
/*     */         
/* 144 */         this._parent._weekEndingDate = null;
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
/* 159 */         this._parent._workstationId = Long.valueOf(l1);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 165 */       l1 = argResultSet.getLong(5);
/* 166 */       if (l1 != 0L || argResultSet.getObject(5) != null) {
/* 167 */         this._parent._partyId = Long.valueOf(l1);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 173 */       l1 = argResultSet.getLong(6);
/* 174 */       if (l1 != 0L || argResultSet.getObject(6) != null) {
/* 175 */         this._parent._commentSeq = Long.valueOf(l1);
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 180 */       Timestamp t7 = argResultSet.getTimestamp(7);
/* 181 */       if (t7 != null) {
/* 182 */         this._parent._createDate = (Date)new DtvDate(t7.getTime());
/*     */       } else {
/*     */         
/* 185 */         this._parent._createDate = null;
/*     */       } 
/*     */       
/* 188 */       this._parent._createUserId = argResultSet.getString(8);
/*     */       
/* 190 */       Timestamp t9 = argResultSet.getTimestamp(9);
/* 191 */       if (t9 != null) {
/* 192 */         this._parent._updateDate = (Date)new DtvDate(t9.getTime());
/*     */       } else {
/*     */         
/* 195 */         this._parent._updateDate = null;
/*     */       } 
/*     */       
/* 198 */       this._parent._updateUserId = argResultSet.getString(10);
/*     */       
/* 200 */       Timestamp t11 = argResultSet.getTimestamp(11);
/* 201 */       if (t11 != null) {
/* 202 */         this._parent._commentDateTime = (Date)new DtvDate(t11.getTime());
/*     */       } else {
/*     */         
/* 205 */         this._parent._commentDateTime = null;
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/* 210 */       this._parent._commentText = JDBCHelper.clobToString(argResultSet, 12);
/*     */       
/* 212 */       this._parent._creatorId = argResultSet.getString(13);
/*     */       
/* 214 */       Timestamp t14 = argResultSet.getTimestamp(14);
/* 215 */       if (t14 != null) {
/* 216 */         this._parent._businessDate = (Date)new DtvDate(t14.getTime());
/*     */       } else {
/*     */         
/* 219 */         this._parent._businessDate = null;
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/* 224 */       long l2 = argResultSet.getLong(15);
/* 225 */       if (l2 != 0L || argResultSet.getObject(15) != null) {
/* 226 */         this._parent._timecardEntryId = Long.valueOf(l2);
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IDataAccessObject loadDAO(IDataAccessObject argDAO) {
/* 234 */     argDAO.suppressStateChanges(true);
/* 235 */     TimecardEntryCommentDAO dao = (TimecardEntryCommentDAO)argDAO;
/* 236 */     dao.setOrganizationId(this._organizationId);
/* 237 */     dao.setWeekEndingDate(this._weekEndingDate);
/* 238 */     dao.setRetailLocationId(this._retailLocationId);
/* 239 */     dao.setWorkstationId(this._workstationId);
/* 240 */     dao.setPartyId(this._partyId);
/* 241 */     dao.setCommentSeq(this._commentSeq);
/* 242 */     dao.setCreateDate(this._createDate);
/* 243 */     dao.setCreateUserId(this._createUserId);
/* 244 */     dao.setUpdateDate(this._updateDate);
/* 245 */     dao.setUpdateUserId(this._updateUserId);
/* 246 */     dao.setCommentDateTime(this._commentDateTime);
/* 247 */     dao.setCommentText(this._commentText);
/* 248 */     dao.setCreatorId(this._creatorId);
/* 249 */     dao.setBusinessDate(this._businessDate);
/* 250 */     dao.setTimecardEntryId(this._timecardEntryId);
/* 251 */     argDAO.suppressStateChanges(false);
/* 252 */     return (IDataAccessObject)dao;
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDefaultDAO() {
/* 256 */     return loadDAO((IDataAccessObject)new TimecardEntryCommentDAO());
/*     */   }
/*     */   
/*     */   public void fill(IDataAccessObject argDAO) {
/* 260 */     TimecardEntryCommentDAO dao = (TimecardEntryCommentDAO)argDAO;
/* 261 */     this._organizationId = dao.getOrganizationId();
/* 262 */     this._weekEndingDate = dao.getWeekEndingDate();
/* 263 */     this._retailLocationId = dao.getRetailLocationId();
/* 264 */     this._workstationId = dao.getWorkstationId();
/* 265 */     this._partyId = dao.getPartyId();
/* 266 */     this._commentSeq = dao.getCommentSeq();
/* 267 */     this._createDate = dao.getCreateDate();
/* 268 */     this._createUserId = dao.getCreateUserId();
/* 269 */     this._updateDate = dao.getUpdateDate();
/* 270 */     this._updateUserId = dao.getUpdateUserId();
/* 271 */     this._commentDateTime = dao.getCommentDateTime();
/* 272 */     this._commentText = dao.getCommentText();
/* 273 */     this._creatorId = dao.getCreatorId();
/* 274 */     this._businessDate = dao.getBusinessDate();
/* 275 */     this._timecardEntryId = dao.getTimecardEntryId();
/*     */   }
/*     */   
/*     */   public PreparedStatement writeObjectId(IObjectId argId, PreparedStatement argStatement) throws SQLException {
/* 279 */     TimecardEntryCommentId id = (TimecardEntryCommentId)argId;
/* 280 */     argStatement.setLong(1, id.getOrganizationId().longValue());
/* 281 */     argStatement.setTimestamp(2, new Timestamp(id.getWeekEndingDate().getTime()));
/* 282 */     argStatement.setLong(3, id.getRetailLocationId().longValue());
/* 283 */     argStatement.setLong(4, id.getWorkstationId().longValue());
/* 284 */     argStatement.setLong(5, id.getPartyId().longValue());
/* 285 */     argStatement.setLong(6, id.getCommentSeq().longValue());
/* 286 */     return argStatement;
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 290 */     TimecardEntryCommentId id = new TimecardEntryCommentId();
/* 291 */     id.setOrganizationId(this._organizationId);
/* 292 */     id.setWeekEndingDate(this._weekEndingDate);
/* 293 */     id.setRetailLocationId(this._retailLocationId);
/* 294 */     id.setWorkstationId(this._workstationId);
/* 295 */     id.setPartyId(this._partyId);
/* 296 */     id.setCommentSeq(this._commentSeq);
/* 297 */     return (IObjectId)id;
/*     */   }
/*     */ 
/*     */   
/*     */   public void fill(IJDBCTableAdapter argAdapter) {}
/*     */ 
/*     */   
/*     */   public boolean isExtensible() {
/* 305 */     return false;
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 309 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\thr\impl\TimecardEntryCommentDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */