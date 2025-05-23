/*     */ package dtv.xst.dao.thr.impl;
/*     */ 
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.impl.jdbc.IExtendedJDBCAdapter;
/*     */ import dtv.data2.access.impl.jdbc.IFiller;
/*     */ import dtv.util.ArrayUtils;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.trn.PosTransactionId;
/*     */ import dtv.xst.dao.trn.impl.PosTransactionDBA;
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
/*     */ public class TimeclockTransactionDBA
/*     */   extends PosTransactionDBA
/*     */   implements IExtendedJDBCAdapter
/*     */ {
/*     */   private static final long serialVersionUID = 1261991645L;
/*     */   private Long _organizationId;
/*     */   private Long _retailLocationId;
/*     */   private Date _businessDate;
/*     */   private Long _workstationId;
/*     */   private Long _transactionSequence;
/*     */   private Date _createDate;
/*     */   private String _createUserId;
/*     */   private Date _updateDate;
/*     */   private String _updateUserId;
/*     */   private String _timeclockEntryCodes;
/*     */   private Long _partyId;
/*     */   private Long _timecardEntryId;
/*     */   private Long _timecardEntrySeq;
/*     */   private Date _timecardEntryBusinessDate;
/*     */   private Long _timecardEntryWorkstationId;
/*     */   private String _workCodeString;
/*     */   private static final String SELECT_OBJECT = "SELECT t.organization_id, t.rtl_loc_id, t.business_date, t.wkstn_id, t.trans_seq, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.timeclk_entry_code, t.party_id, t.timecard_entry_id, t.timecard_entry_seq, t.timecard_entry_business_date, t.timecard_entry_wkstn_id, t.work_code FROM thr_timeclk_trans t";
/*     */   private static final String SELECT_WHERE_OBJECT = " WHERE organization_id = ?  AND rtl_loc_id = ?  AND business_date = ?  AND wkstn_id = ?  AND trans_seq = ?  ";
/*     */   
/*     */   public String getSelect() {
/*  46 */     return getSelectImpl();
/*     */   }
/*     */   
/*     */   private String getSelectImpl() {
/*  50 */     return "SELECT t.organization_id, t.rtl_loc_id, t.business_date, t.wkstn_id, t.trans_seq, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.timeclk_entry_code, t.party_id, t.timecard_entry_id, t.timecard_entry_seq, t.timecard_entry_business_date, t.timecard_entry_wkstn_id, t.work_code FROM thr_timeclk_trans t";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectWhere() {
/*  57 */     return " WHERE organization_id = ?  AND rtl_loc_id = ?  AND business_date = ?  AND wkstn_id = ?  AND trans_seq = ?  ";
/*     */   }
/*     */   
/*  60 */   private static final String[] INSERT_OBJECT = new String[] { "INSERT INTO thr_timeclk_trans(organization_id, rtl_loc_id, business_date, wkstn_id, trans_seq, create_date, create_user_id, update_date, update_user_id, timeclk_entry_code, party_id, timecard_entry_id, timecard_entry_seq, timecard_entry_business_date, timecard_entry_wkstn_id, work_code) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" };
/*     */ 
/*     */   
/*     */   public String[] getInsert() {
/*  64 */     return (String[])ArrayUtils.combine((Object[])super.getInsert(), (Object[])INSERT_OBJECT);
/*     */   }
/*     */ 
/*     */   
/*     */   public Object[][] getInsertParameters() {
/*  69 */     Object[][] insertParameterObject = { { this._organizationId, this._retailLocationId, this._businessDate, this._workstationId, this._transactionSequence, this._createDate, this._createUserId, this._updateDate, this._updateUserId, this._timeclockEntryCodes, this._partyId, this._timecardEntryId, this._timecardEntrySeq, this._timecardEntryBusinessDate, this._timecardEntryWorkstationId, this._workCodeString } };
/*  70 */     return (Object[][])ArrayUtils.combine((Object[])super.getInsertParameters(), (Object[])insertParameterObject);
/*     */   }
/*     */   
/*  73 */   private static final int[][] INSERT_PARAMETER_TYPES_OBJECT = new int[][] { { -5, -5, 91, -5, -5, 91, 12, 91, 12, 12, -5, -5, -5, 91, -5, 12 } };
/*     */ 
/*     */   
/*     */   public int[][] getInsertParameterTypes() {
/*  77 */     return (int[][])ArrayUtils.combine((Object[])super.getInsertParameterTypes(), (Object[])INSERT_PARAMETER_TYPES_OBJECT);
/*     */   }
/*     */   
/*  80 */   private static final String[] UPDATE_OBJECT = new String[] { "UPDATE thr_timeclk_trans SET update_date = ?, update_user_id = ?, timeclk_entry_code = ?, party_id = ?, timecard_entry_id = ?, timecard_entry_seq = ?, timecard_entry_business_date = ?, timecard_entry_wkstn_id = ?, work_code = ?" };
/*     */ 
/*     */   
/*     */   public String[] getUpdate() {
/*  84 */     return (String[])ArrayUtils.combine((Object[])super.getUpdate(), (Object[])UPDATE_OBJECT);
/*     */   }
/*     */ 
/*     */   
/*     */   public Object[][] getUpdateParameters() {
/*  89 */     Object[][] updateParameterObject = { { this._updateDate, this._updateUserId, this._timeclockEntryCodes, this._partyId, this._timecardEntryId, this._timecardEntrySeq, this._timecardEntryBusinessDate, this._timecardEntryWorkstationId, this._workCodeString } };
/*  90 */     return (Object[][])ArrayUtils.combine((Object[])super.getUpdateParameters(), (Object[])updateParameterObject);
/*     */   }
/*     */   
/*  93 */   private static final int[][] UPDATE_PARAMETER_TYPE_OBJECT = new int[][] { { 91, 12, 12, -5, -5, -5, 91, -5, 12 } };
/*     */   
/*     */   public int[][] getUpdateParameterTypes() {
/*  96 */     return (int[][])ArrayUtils.combine((Object[])super.getUpdateParameterTypes(), (Object[])UPDATE_PARAMETER_TYPE_OBJECT);
/*     */   }
/*     */   
/*  99 */   private static final String[] DELETE_OBJECT = new String[] { "DELETE FROM thr_timeclk_trans" };
/*     */   private static final String WHERE_OBJECT = " WHERE organization_id = ?  AND rtl_loc_id = ?  AND business_date = ?  AND wkstn_id = ?  AND trans_seq = ?  ";
/*     */   
/*     */   public String[] getDelete() {
/* 103 */     return (String[])ArrayUtils.combine((Object[])super.getDelete(), (Object[])DELETE_OBJECT);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWhere() {
/* 110 */     return " WHERE organization_id = ?  AND rtl_loc_id = ?  AND business_date = ?  AND wkstn_id = ?  AND trans_seq = ?  ";
/*     */   }
/*     */   
/*     */   public Object[] getWhereParameters() {
/* 114 */     return new Object[] { this._organizationId, this._retailLocationId, this._businessDate, this._workstationId, this._transactionSequence };
/*     */   }
/*     */   
/* 117 */   private static final int[] WHERE_PARAMETER_OBJECT = new int[] { -5, -5, 91, -5, -5 };
/*     */ 
/*     */   
/*     */   public int[] getWhereParameterTypes() {
/* 121 */     return WHERE_PARAMETER_OBJECT;
/*     */   }
/*     */   
/*     */   public String getTableName() {
/* 125 */     return "thr_timeclk_trans";
/*     */   }
/*     */ 
/*     */   
/*     */   public IFiller getFiller() {
/* 130 */     return getFillerImpl();
/*     */   }
/*     */   
/*     */   private IFiller getFillerImpl() {
/* 134 */     return new TimeclockTransactionFiller(this);
/*     */   }
/*     */   
/*     */   private static class TimeclockTransactionFiller
/*     */     implements IFiller {
/*     */     private TimeclockTransactionDBA _parent;
/*     */     
/*     */     public TimeclockTransactionFiller(TimeclockTransactionDBA argParent) {
/* 142 */       this._parent = argParent;
/*     */     }
/*     */ 
/*     */     
/*     */     public void fill(ResultSet argResultSet) throws SQLException {
/* 147 */       long primitiveResult = argResultSet.getLong(1);
/* 148 */       if (primitiveResult != 0L || argResultSet.getObject(1) != null) {
/* 149 */         this._parent._organizationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 155 */       primitiveResult = argResultSet.getLong(2);
/* 156 */       if (primitiveResult != 0L || argResultSet.getObject(2) != null) {
/* 157 */         this._parent._retailLocationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 162 */       Timestamp t3 = argResultSet.getTimestamp(3);
/* 163 */       if (t3 != null) {
/* 164 */         this._parent._businessDate = (Date)new DtvDate(t3.getTime());
/*     */       } else {
/*     */         
/* 167 */         this._parent._businessDate = null;
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/* 172 */       long l1 = argResultSet.getLong(4);
/* 173 */       if (l1 != 0L || argResultSet.getObject(4) != null) {
/* 174 */         this._parent._workstationId = Long.valueOf(l1);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 180 */       l1 = argResultSet.getLong(5);
/* 181 */       if (l1 != 0L || argResultSet.getObject(5) != null) {
/* 182 */         this._parent._transactionSequence = Long.valueOf(l1);
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 187 */       Timestamp t6 = argResultSet.getTimestamp(6);
/* 188 */       if (t6 != null) {
/* 189 */         this._parent._createDate = (Date)new DtvDate(t6.getTime());
/*     */       } else {
/*     */         
/* 192 */         this._parent._createDate = null;
/*     */       } 
/*     */       
/* 195 */       this._parent._createUserId = argResultSet.getString(7);
/*     */       
/* 197 */       Timestamp t8 = argResultSet.getTimestamp(8);
/* 198 */       if (t8 != null) {
/* 199 */         this._parent._updateDate = (Date)new DtvDate(t8.getTime());
/*     */       } else {
/*     */         
/* 202 */         this._parent._updateDate = null;
/*     */       } 
/*     */       
/* 205 */       this._parent._updateUserId = argResultSet.getString(9);
/* 206 */       this._parent._timeclockEntryCodes = argResultSet.getString(10);
/*     */ 
/*     */       
/* 209 */       long l2 = argResultSet.getLong(11);
/* 210 */       if (l2 != 0L || argResultSet.getObject(11) != null) {
/* 211 */         this._parent._partyId = Long.valueOf(l2);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 217 */       l2 = argResultSet.getLong(12);
/* 218 */       if (l2 != 0L || argResultSet.getObject(12) != null) {
/* 219 */         this._parent._timecardEntryId = Long.valueOf(l2);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 225 */       l2 = argResultSet.getLong(13);
/* 226 */       if (l2 != 0L || argResultSet.getObject(13) != null) {
/* 227 */         this._parent._timecardEntrySeq = Long.valueOf(l2);
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 232 */       Timestamp t14 = argResultSet.getTimestamp(14);
/* 233 */       if (t14 != null) {
/* 234 */         this._parent._timecardEntryBusinessDate = (Date)new DtvDate(t14.getTime());
/*     */       } else {
/*     */         
/* 237 */         this._parent._timecardEntryBusinessDate = null;
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/* 242 */       long l3 = argResultSet.getLong(15);
/* 243 */       if (l3 != 0L || argResultSet.getObject(15) != null) {
/* 244 */         this._parent._timecardEntryWorkstationId = Long.valueOf(l3);
/*     */       }
/*     */ 
/*     */       
/* 248 */       this._parent._workCodeString = argResultSet.getString(16);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public IDataAccessObject loadDAO(IDataAccessObject argDAO) {
/* 254 */     super.loadDAO(argDAO);
/* 255 */     argDAO.suppressStateChanges(true);
/* 256 */     TimeclockTransactionDAO dao = (TimeclockTransactionDAO)argDAO;
/* 257 */     dao.setOrganizationId(this._organizationId);
/* 258 */     dao.setRetailLocationId(this._retailLocationId);
/* 259 */     dao.setBusinessDate(this._businessDate);
/* 260 */     dao.setWorkstationId(this._workstationId);
/* 261 */     dao.setTransactionSequence(this._transactionSequence);
/* 262 */     dao.setCreateDate(this._createDate);
/* 263 */     dao.setCreateUserId(this._createUserId);
/* 264 */     dao.setUpdateDate(this._updateDate);
/* 265 */     dao.setUpdateUserId(this._updateUserId);
/* 266 */     dao.setTimeclockEntryCodes(this._timeclockEntryCodes);
/* 267 */     dao.setPartyId(this._partyId);
/* 268 */     dao.setTimecardEntryId(this._timecardEntryId);
/* 269 */     dao.setTimecardEntrySeq(this._timecardEntrySeq);
/* 270 */     dao.setTimecardEntryBusinessDate(this._timecardEntryBusinessDate);
/* 271 */     dao.setTimecardEntryWorkstationId(this._timecardEntryWorkstationId);
/* 272 */     dao.setWorkCodeString(this._workCodeString);
/* 273 */     argDAO.suppressStateChanges(false);
/* 274 */     return (IDataAccessObject)dao;
/*     */   }
/*     */ 
/*     */   
/*     */   public IDataAccessObject loadDefaultDAO() {
/* 279 */     return loadDAO((IDataAccessObject)new TimeclockTransactionDAO());
/*     */   }
/*     */ 
/*     */   
/*     */   public void fill(IDataAccessObject argDAO) {
/* 284 */     TimeclockTransactionDAO dao = (TimeclockTransactionDAO)argDAO;
/* 285 */     super.fill((IDataAccessObject)dao);
/* 286 */     this._organizationId = dao.getOrganizationId();
/* 287 */     this._retailLocationId = dao.getRetailLocationId();
/* 288 */     this._businessDate = dao.getBusinessDate();
/* 289 */     this._workstationId = dao.getWorkstationId();
/* 290 */     this._transactionSequence = dao.getTransactionSequence();
/* 291 */     this._createDate = dao.getCreateDate();
/* 292 */     this._createUserId = dao.getCreateUserId();
/* 293 */     this._updateDate = dao.getUpdateDate();
/* 294 */     this._updateUserId = dao.getUpdateUserId();
/* 295 */     this._timeclockEntryCodes = dao.getTimeclockEntryCodes();
/* 296 */     this._partyId = dao.getPartyId();
/* 297 */     this._timecardEntryId = dao.getTimecardEntryId();
/* 298 */     this._timecardEntrySeq = dao.getTimecardEntrySeq();
/* 299 */     this._timecardEntryBusinessDate = dao.getTimecardEntryBusinessDate();
/* 300 */     this._timecardEntryWorkstationId = dao.getTimecardEntryWorkstationId();
/* 301 */     this._workCodeString = dao.getWorkCodeString();
/*     */   }
/*     */ 
/*     */   
/*     */   public PreparedStatement writeObjectId(IObjectId argId, PreparedStatement argStatement) throws SQLException {
/* 306 */     PosTransactionId id = (PosTransactionId)argId;
/* 307 */     argStatement.setLong(1, id.getOrganizationId().longValue());
/* 308 */     argStatement.setLong(2, id.getRetailLocationId().longValue());
/* 309 */     argStatement.setTimestamp(3, new Timestamp(id.getBusinessDate().getTime()));
/* 310 */     argStatement.setLong(4, id.getWorkstationId().longValue());
/* 311 */     argStatement.setLong(5, id.getTransactionSequence().longValue());
/* 312 */     return argStatement;
/*     */   }
/*     */   
/*     */   public String[] getAllSelects() {
/* 316 */     return new String[] { getSelectImpl() };
/*     */   }
/*     */   
/*     */   public IFiller[] getAllFillers() {
/* 320 */     return new IFiller[] { getFillerImpl() };
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\thr\impl\TimeclockTransactionDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */