/*     */ package dtv.xst.dao.tsn.impl;
/*     */ 
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.impl.jdbc.IFiller;
/*     */ import dtv.data2.access.impl.jdbc.IJDBCTableAdapter;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.tsn.SessionWorkstationId;
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
/*     */ public class SessionWorkstationDBA
/*     */   implements IJDBCTableAdapter
/*     */ {
/*     */   private static final long serialVersionUID = 597220525L;
/*     */   private Long _organizationId;
/*     */   private Long _retailLocationId;
/*     */   private Long _sessionId;
/*     */   private Integer _sessionWorkstationSequenceNbr;
/*     */   private Date _createDate;
/*     */   private String _createUserId;
/*     */   private Date _updateDate;
/*     */   private String _updateUserId;
/*     */   private Date _beginDatetimestamp;
/*     */   private String _cashDrawerId;
/*     */   private Date _endDatetimestamp;
/*     */   private Boolean _attached;
/*     */   private Long _workstationId;
/*     */   private static final String SELECT_OBJECT = "SELECT t.organization_id, t.rtl_loc_id, t.session_id, t.session_wkstn_seq, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.begin_datetime, t.cash_drawer_id, t.end_datetime, t.attached_flag, t.wkstn_id FROM tsn_session_wkstn t";
/*     */   private static final String SELECT_WHERE_OBJECT = " WHERE organization_id = ?  AND rtl_loc_id = ?  AND session_id = ?  AND session_wkstn_seq = ?  ";
/*     */   
/*     */   public String getSelect() {
/*  42 */     return getSelectImpl();
/*     */   }
/*     */   
/*     */   private String getSelectImpl() {
/*  46 */     return "SELECT t.organization_id, t.rtl_loc_id, t.session_id, t.session_wkstn_seq, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.begin_datetime, t.cash_drawer_id, t.end_datetime, t.attached_flag, t.wkstn_id FROM tsn_session_wkstn t";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectWhere() {
/*  52 */     return " WHERE organization_id = ?  AND rtl_loc_id = ?  AND session_id = ?  AND session_wkstn_seq = ?  ";
/*     */   }
/*     */   
/*  55 */   private static final String[] INSERT_OBJECT = new String[] { "INSERT INTO tsn_session_wkstn(organization_id, rtl_loc_id, session_id, session_wkstn_seq, create_date, create_user_id, update_date, update_user_id, begin_datetime, cash_drawer_id, end_datetime, attached_flag, wkstn_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" };
/*     */   
/*     */   public String[] getInsert() {
/*  58 */     return INSERT_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getInsertParameters() {
/*  62 */     Object[][] insertParameterObject = { { this._organizationId, this._retailLocationId, this._sessionId, this._sessionWorkstationSequenceNbr, this._createDate, this._createUserId, this._updateDate, this._updateUserId, this._beginDatetimestamp, this._cashDrawerId, this._endDatetimestamp, this._attached, this._workstationId } };
/*  63 */     return insertParameterObject;
/*     */   }
/*     */   
/*  66 */   private static final int[][] INSERT_PARAMETER_TYPES_OBJECT = new int[][] { { -5, -5, -5, 4, 91, 12, 91, 12, 91, 12, 91, -7, -5 } };
/*     */   
/*     */   public int[][] getInsertParameterTypes() {
/*  69 */     return INSERT_PARAMETER_TYPES_OBJECT;
/*     */   }
/*     */   
/*  72 */   private static final String[] UPDATE_OBJECT = new String[] { "UPDATE tsn_session_wkstn SET update_date = ?, update_user_id = ?, begin_datetime = ?, cash_drawer_id = ?, end_datetime = ?, attached_flag = ?, wkstn_id = ?" };
/*     */   
/*     */   public String[] getUpdate() {
/*  75 */     return UPDATE_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getUpdateParameters() {
/*  79 */     Object[][] updateParameterObject = { { this._updateDate, this._updateUserId, this._beginDatetimestamp, this._cashDrawerId, this._endDatetimestamp, this._attached, this._workstationId } };
/*  80 */     return updateParameterObject;
/*     */   }
/*     */   
/*  83 */   private static final int[][] UPDATE_PARAMETER_TYPE_OBJECT = new int[][] { { 91, 12, 91, 12, 91, -7, -5 } };
/*     */   public int[][] getUpdateParameterTypes() {
/*  85 */     return UPDATE_PARAMETER_TYPE_OBJECT;
/*     */   }
/*     */   
/*  88 */   private static final String[] DELETE_OBJECT = new String[] { "DELETE FROM tsn_session_wkstn" }; private static final String WHERE_OBJECT = " WHERE organization_id = ?  AND rtl_loc_id = ?  AND session_id = ?  AND session_wkstn_seq = ?  ";
/*     */   
/*     */   public String[] getDelete() {
/*  91 */     return DELETE_OBJECT;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWhere() {
/*  97 */     return " WHERE organization_id = ?  AND rtl_loc_id = ?  AND session_id = ?  AND session_wkstn_seq = ?  ";
/*     */   }
/*     */   public Object[] getWhereParameters() {
/* 100 */     return new Object[] { this._organizationId, this._retailLocationId, this._sessionId, this._sessionWorkstationSequenceNbr };
/*     */   }
/*     */   
/* 103 */   private static final int[] WHERE_PARAMETER_OBJECT = new int[] { -5, -5, -5, 4 };
/*     */   
/*     */   public int[] getWhereParameterTypes() {
/* 106 */     return WHERE_PARAMETER_OBJECT;
/*     */   }
/*     */   public String getTableName() {
/* 109 */     return "tsn_session_wkstn";
/*     */   }
/*     */   
/*     */   public IFiller getFiller() {
/* 113 */     return getFillerImpl();
/*     */   }
/*     */   
/*     */   private IFiller getFillerImpl() {
/* 117 */     return new SessionWorkstationFiller(this);
/*     */   }
/*     */   
/*     */   private static class SessionWorkstationFiller
/*     */     implements IFiller {
/*     */     private SessionWorkstationDBA _parent;
/*     */     
/*     */     public SessionWorkstationFiller(SessionWorkstationDBA argParent) {
/* 125 */       this._parent = argParent;
/*     */     }
/*     */ 
/*     */     
/*     */     public void fill(ResultSet argResultSet) throws SQLException {
/* 130 */       long l1 = argResultSet.getLong(1);
/* 131 */       if (l1 != 0L || argResultSet.getObject(1) != null) {
/* 132 */         this._parent._organizationId = Long.valueOf(l1);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 138 */       l1 = argResultSet.getLong(2);
/* 139 */       if (l1 != 0L || argResultSet.getObject(2) != null) {
/* 140 */         this._parent._retailLocationId = Long.valueOf(l1);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 146 */       l1 = argResultSet.getLong(3);
/* 147 */       if (l1 != 0L || argResultSet.getObject(3) != null) {
/* 148 */         this._parent._sessionId = Long.valueOf(l1);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 154 */       int primitiveResult = argResultSet.getInt(4);
/* 155 */       if (primitiveResult != 0 || argResultSet.getObject(4) != null) {
/* 156 */         this._parent._sessionWorkstationSequenceNbr = Integer.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 161 */       Timestamp t5 = argResultSet.getTimestamp(5);
/* 162 */       if (t5 != null) {
/* 163 */         this._parent._createDate = (Date)new DtvDate(t5.getTime());
/*     */       } else {
/*     */         
/* 166 */         this._parent._createDate = null;
/*     */       } 
/*     */       
/* 169 */       this._parent._createUserId = argResultSet.getString(6);
/*     */       
/* 171 */       Timestamp t7 = argResultSet.getTimestamp(7);
/* 172 */       if (t7 != null) {
/* 173 */         this._parent._updateDate = (Date)new DtvDate(t7.getTime());
/*     */       } else {
/*     */         
/* 176 */         this._parent._updateDate = null;
/*     */       } 
/*     */       
/* 179 */       this._parent._updateUserId = argResultSet.getString(8);
/*     */       
/* 181 */       Timestamp t9 = argResultSet.getTimestamp(9);
/* 182 */       if (t9 != null) {
/* 183 */         this._parent._beginDatetimestamp = (Date)new DtvDate(t9.getTime());
/*     */       } else {
/*     */         
/* 186 */         this._parent._beginDatetimestamp = null;
/*     */       } 
/*     */       
/* 189 */       this._parent._cashDrawerId = argResultSet.getString(10);
/*     */       
/* 191 */       Timestamp t11 = argResultSet.getTimestamp(11);
/* 192 */       if (t11 != null) {
/* 193 */         this._parent._endDatetimestamp = (Date)new DtvDate(t11.getTime());
/*     */       } else {
/*     */         
/* 196 */         this._parent._endDatetimestamp = null;
/*     */       } 
/*     */       
/* 199 */       this._parent._attached = Boolean.valueOf(argResultSet.getBoolean(12));
/*     */ 
/*     */       
/* 202 */       long l2 = argResultSet.getLong(13);
/* 203 */       if (l2 != 0L || argResultSet.getObject(13) != null) {
/* 204 */         this._parent._workstationId = Long.valueOf(l2);
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IDataAccessObject loadDAO(IDataAccessObject argDAO) {
/* 212 */     argDAO.suppressStateChanges(true);
/* 213 */     SessionWorkstationDAO dao = (SessionWorkstationDAO)argDAO;
/* 214 */     dao.setOrganizationId(this._organizationId);
/* 215 */     dao.setRetailLocationId(this._retailLocationId);
/* 216 */     dao.setSessionId(this._sessionId);
/* 217 */     dao.setSessionWorkstationSequenceNbr(this._sessionWorkstationSequenceNbr);
/* 218 */     dao.setCreateDate(this._createDate);
/* 219 */     dao.setCreateUserId(this._createUserId);
/* 220 */     dao.setUpdateDate(this._updateDate);
/* 221 */     dao.setUpdateUserId(this._updateUserId);
/* 222 */     dao.setBeginDatetimestamp(this._beginDatetimestamp);
/* 223 */     dao.setCashDrawerId(this._cashDrawerId);
/* 224 */     dao.setEndDatetimestamp(this._endDatetimestamp);
/* 225 */     dao.setAttached(this._attached);
/* 226 */     dao.setWorkstationId(this._workstationId);
/* 227 */     argDAO.suppressStateChanges(false);
/* 228 */     return (IDataAccessObject)dao;
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDefaultDAO() {
/* 232 */     return loadDAO((IDataAccessObject)new SessionWorkstationDAO());
/*     */   }
/*     */   
/*     */   public void fill(IDataAccessObject argDAO) {
/* 236 */     SessionWorkstationDAO dao = (SessionWorkstationDAO)argDAO;
/* 237 */     this._organizationId = dao.getOrganizationId();
/* 238 */     this._retailLocationId = dao.getRetailLocationId();
/* 239 */     this._sessionId = dao.getSessionId();
/* 240 */     this._sessionWorkstationSequenceNbr = dao.getSessionWorkstationSequenceNbr();
/* 241 */     this._createDate = dao.getCreateDate();
/* 242 */     this._createUserId = dao.getCreateUserId();
/* 243 */     this._updateDate = dao.getUpdateDate();
/* 244 */     this._updateUserId = dao.getUpdateUserId();
/* 245 */     this._beginDatetimestamp = dao.getBeginDatetimestamp();
/* 246 */     this._cashDrawerId = dao.getCashDrawerId();
/* 247 */     this._endDatetimestamp = dao.getEndDatetimestamp();
/* 248 */     this._attached = (dao.getAttached() != null) ? dao.getAttached() : Boolean.valueOf(false);
/* 249 */     this._workstationId = dao.getWorkstationId();
/*     */   }
/*     */   
/*     */   public PreparedStatement writeObjectId(IObjectId argId, PreparedStatement argStatement) throws SQLException {
/* 253 */     SessionWorkstationId id = (SessionWorkstationId)argId;
/* 254 */     argStatement.setLong(1, id.getOrganizationId().longValue());
/* 255 */     argStatement.setLong(2, id.getRetailLocationId().longValue());
/* 256 */     argStatement.setLong(3, id.getSessionId().longValue());
/* 257 */     argStatement.setInt(4, id.getSessionWorkstationSequenceNbr().intValue());
/* 258 */     return argStatement;
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 262 */     SessionWorkstationId id = new SessionWorkstationId();
/* 263 */     id.setOrganizationId(this._organizationId);
/* 264 */     id.setRetailLocationId(this._retailLocationId);
/* 265 */     id.setSessionId(this._sessionId);
/* 266 */     id.setSessionWorkstationSequenceNbr(this._sessionWorkstationSequenceNbr);
/* 267 */     return (IObjectId)id;
/*     */   }
/*     */ 
/*     */   
/*     */   public void fill(IJDBCTableAdapter argAdapter) {}
/*     */ 
/*     */   
/*     */   public boolean isExtensible() {
/* 275 */     return false;
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 279 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\tsn\impl\SessionWorkstationDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */