/*     */ package dtv.xst.dao.tsn.impl;
/*     */ 
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.impl.jdbc.IFiller;
/*     */ import dtv.data2.access.impl.jdbc.IJDBCTableAdapter;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.tsn.SessionId;
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
/*     */ public class SessionDBA
/*     */   implements IJDBCTableAdapter
/*     */ {
/*     */   private static final long serialVersionUID = -645326218L;
/*     */   private Long _organizationId;
/*     */   private Long _retailLocationId;
/*     */   private Long _sessionId;
/*     */   private Date _createDate;
/*     */   private String _createUserId;
/*     */   private Date _updateDate;
/*     */   private String _updateUserId;
/*     */   private Date _beginDatetimestamp;
/*     */   private Date _businessDate;
/*     */   private Date _endDatetimestamp;
/*     */   private String _statusCode;
/*     */   private Long _employeePartyId;
/*     */   private String _tenderRepositoryId;
/*     */   private String _cashDrawerId;
/*     */   private static final String SELECT_OBJECT = "SELECT t.organization_id, t.rtl_loc_id, t.session_id, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.begin_datetime, t.business_date, t.end_datetime, t.statcode, t.employee_party_id, t.tndr_repository_id, t.cash_drawer_id FROM tsn_session t";
/*     */   private static final String SELECT_WHERE_OBJECT = " WHERE organization_id = ?  AND rtl_loc_id = ?  AND session_id = ?  ";
/*     */   
/*     */   public String getSelect() {
/*  43 */     return getSelectImpl();
/*     */   }
/*     */   
/*     */   private String getSelectImpl() {
/*  47 */     return "SELECT t.organization_id, t.rtl_loc_id, t.session_id, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.begin_datetime, t.business_date, t.end_datetime, t.statcode, t.employee_party_id, t.tndr_repository_id, t.cash_drawer_id FROM tsn_session t";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectWhere() {
/*  53 */     return " WHERE organization_id = ?  AND rtl_loc_id = ?  AND session_id = ?  ";
/*     */   }
/*     */   
/*  56 */   private static final String[] INSERT_OBJECT = new String[] { "INSERT INTO tsn_session(organization_id, rtl_loc_id, session_id, create_date, create_user_id, update_date, update_user_id, begin_datetime, business_date, end_datetime, statcode, employee_party_id, tndr_repository_id, cash_drawer_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" };
/*     */   
/*     */   public String[] getInsert() {
/*  59 */     return INSERT_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getInsertParameters() {
/*  63 */     Object[][] insertParameterObject = { { this._organizationId, this._retailLocationId, this._sessionId, this._createDate, this._createUserId, this._updateDate, this._updateUserId, this._beginDatetimestamp, this._businessDate, this._endDatetimestamp, this._statusCode, this._employeePartyId, this._tenderRepositoryId, this._cashDrawerId } };
/*  64 */     return insertParameterObject;
/*     */   }
/*     */   
/*  67 */   private static final int[][] INSERT_PARAMETER_TYPES_OBJECT = new int[][] { { -5, -5, -5, 91, 12, 91, 12, 91, 91, 91, 12, -5, 12, 12 } };
/*     */   
/*     */   public int[][] getInsertParameterTypes() {
/*  70 */     return INSERT_PARAMETER_TYPES_OBJECT;
/*     */   }
/*     */   
/*  73 */   private static final String[] UPDATE_OBJECT = new String[] { "UPDATE tsn_session SET update_date = ?, update_user_id = ?, begin_datetime = ?, business_date = ?, end_datetime = ?, statcode = ?, employee_party_id = ?, tndr_repository_id = ?, cash_drawer_id = ?" };
/*     */   
/*     */   public String[] getUpdate() {
/*  76 */     return UPDATE_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getUpdateParameters() {
/*  80 */     Object[][] updateParameterObject = { { this._updateDate, this._updateUserId, this._beginDatetimestamp, this._businessDate, this._endDatetimestamp, this._statusCode, this._employeePartyId, this._tenderRepositoryId, this._cashDrawerId } };
/*  81 */     return updateParameterObject;
/*     */   }
/*     */   
/*  84 */   private static final int[][] UPDATE_PARAMETER_TYPE_OBJECT = new int[][] { { 91, 12, 91, 91, 91, 12, -5, 12, 12 } };
/*     */   public int[][] getUpdateParameterTypes() {
/*  86 */     return UPDATE_PARAMETER_TYPE_OBJECT;
/*     */   }
/*     */   
/*  89 */   private static final String[] DELETE_OBJECT = new String[] { "DELETE FROM tsn_session" }; private static final String WHERE_OBJECT = " WHERE organization_id = ?  AND rtl_loc_id = ?  AND session_id = ?  ";
/*     */   
/*     */   public String[] getDelete() {
/*  92 */     return DELETE_OBJECT;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWhere() {
/*  98 */     return " WHERE organization_id = ?  AND rtl_loc_id = ?  AND session_id = ?  ";
/*     */   }
/*     */   public Object[] getWhereParameters() {
/* 101 */     return new Object[] { this._organizationId, this._retailLocationId, this._sessionId };
/*     */   }
/*     */   
/* 104 */   private static final int[] WHERE_PARAMETER_OBJECT = new int[] { -5, -5, -5 };
/*     */   
/*     */   public int[] getWhereParameterTypes() {
/* 107 */     return WHERE_PARAMETER_OBJECT;
/*     */   }
/*     */   public String getTableName() {
/* 110 */     return "tsn_session";
/*     */   }
/*     */   
/*     */   public IFiller getFiller() {
/* 114 */     return getFillerImpl();
/*     */   }
/*     */   
/*     */   private IFiller getFillerImpl() {
/* 118 */     return new SessionFiller(this);
/*     */   }
/*     */   
/*     */   private static class SessionFiller
/*     */     implements IFiller {
/*     */     private SessionDBA _parent;
/*     */     
/*     */     public SessionFiller(SessionDBA argParent) {
/* 126 */       this._parent = argParent;
/*     */     }
/*     */ 
/*     */     
/*     */     public void fill(ResultSet argResultSet) throws SQLException {
/* 131 */       long primitiveResult = argResultSet.getLong(1);
/* 132 */       if (primitiveResult != 0L || argResultSet.getObject(1) != null) {
/* 133 */         this._parent._organizationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 139 */       primitiveResult = argResultSet.getLong(2);
/* 140 */       if (primitiveResult != 0L || argResultSet.getObject(2) != null) {
/* 141 */         this._parent._retailLocationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 147 */       primitiveResult = argResultSet.getLong(3);
/* 148 */       if (primitiveResult != 0L || argResultSet.getObject(3) != null) {
/* 149 */         this._parent._sessionId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 154 */       Timestamp t4 = argResultSet.getTimestamp(4);
/* 155 */       if (t4 != null) {
/* 156 */         this._parent._createDate = (Date)new DtvDate(t4.getTime());
/*     */       } else {
/*     */         
/* 159 */         this._parent._createDate = null;
/*     */       } 
/*     */       
/* 162 */       this._parent._createUserId = argResultSet.getString(5);
/*     */       
/* 164 */       Timestamp t6 = argResultSet.getTimestamp(6);
/* 165 */       if (t6 != null) {
/* 166 */         this._parent._updateDate = (Date)new DtvDate(t6.getTime());
/*     */       } else {
/*     */         
/* 169 */         this._parent._updateDate = null;
/*     */       } 
/*     */       
/* 172 */       this._parent._updateUserId = argResultSet.getString(7);
/*     */       
/* 174 */       Timestamp t8 = argResultSet.getTimestamp(8);
/* 175 */       if (t8 != null) {
/* 176 */         this._parent._beginDatetimestamp = (Date)new DtvDate(t8.getTime());
/*     */       } else {
/*     */         
/* 179 */         this._parent._beginDatetimestamp = null;
/*     */       } 
/*     */ 
/*     */       
/* 183 */       Timestamp t9 = argResultSet.getTimestamp(9);
/* 184 */       if (t9 != null) {
/* 185 */         this._parent._businessDate = (Date)new DtvDate(t9.getTime());
/*     */       } else {
/*     */         
/* 188 */         this._parent._businessDate = null;
/*     */       } 
/*     */ 
/*     */       
/* 192 */       Timestamp t10 = argResultSet.getTimestamp(10);
/* 193 */       if (t10 != null) {
/* 194 */         this._parent._endDatetimestamp = (Date)new DtvDate(t10.getTime());
/*     */       } else {
/*     */         
/* 197 */         this._parent._endDatetimestamp = null;
/*     */       } 
/*     */       
/* 200 */       this._parent._statusCode = argResultSet.getString(11);
/*     */ 
/*     */       
/* 203 */       long l1 = argResultSet.getLong(12);
/* 204 */       if (l1 != 0L || argResultSet.getObject(12) != null) {
/* 205 */         this._parent._employeePartyId = Long.valueOf(l1);
/*     */       }
/*     */ 
/*     */       
/* 209 */       this._parent._tenderRepositoryId = argResultSet.getString(13);
/* 210 */       this._parent._cashDrawerId = argResultSet.getString(14);
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDAO(IDataAccessObject argDAO) {
/* 215 */     argDAO.suppressStateChanges(true);
/* 216 */     SessionDAO dao = (SessionDAO)argDAO;
/* 217 */     dao.setOrganizationId(this._organizationId);
/* 218 */     dao.setRetailLocationId(this._retailLocationId);
/* 219 */     dao.setSessionId(this._sessionId);
/* 220 */     dao.setCreateDate(this._createDate);
/* 221 */     dao.setCreateUserId(this._createUserId);
/* 222 */     dao.setUpdateDate(this._updateDate);
/* 223 */     dao.setUpdateUserId(this._updateUserId);
/* 224 */     dao.setBeginDatetimestamp(this._beginDatetimestamp);
/* 225 */     dao.setBusinessDate(this._businessDate);
/* 226 */     dao.setEndDatetimestamp(this._endDatetimestamp);
/* 227 */     dao.setStatusCode(this._statusCode);
/* 228 */     dao.setEmployeePartyId(this._employeePartyId);
/* 229 */     dao.setTenderRepositoryId(this._tenderRepositoryId);
/* 230 */     dao.setCashDrawerId(this._cashDrawerId);
/* 231 */     argDAO.suppressStateChanges(false);
/* 232 */     return (IDataAccessObject)dao;
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDefaultDAO() {
/* 236 */     return loadDAO((IDataAccessObject)new SessionDAO());
/*     */   }
/*     */   
/*     */   public void fill(IDataAccessObject argDAO) {
/* 240 */     SessionDAO dao = (SessionDAO)argDAO;
/* 241 */     this._organizationId = dao.getOrganizationId();
/* 242 */     this._retailLocationId = dao.getRetailLocationId();
/* 243 */     this._sessionId = dao.getSessionId();
/* 244 */     this._createDate = dao.getCreateDate();
/* 245 */     this._createUserId = dao.getCreateUserId();
/* 246 */     this._updateDate = dao.getUpdateDate();
/* 247 */     this._updateUserId = dao.getUpdateUserId();
/* 248 */     this._beginDatetimestamp = dao.getBeginDatetimestamp();
/* 249 */     this._businessDate = dao.getBusinessDate();
/* 250 */     this._endDatetimestamp = dao.getEndDatetimestamp();
/* 251 */     this._statusCode = dao.getStatusCode();
/* 252 */     this._employeePartyId = dao.getEmployeePartyId();
/* 253 */     this._tenderRepositoryId = dao.getTenderRepositoryId();
/* 254 */     this._cashDrawerId = dao.getCashDrawerId();
/*     */   }
/*     */   
/*     */   public PreparedStatement writeObjectId(IObjectId argId, PreparedStatement argStatement) throws SQLException {
/* 258 */     SessionId id = (SessionId)argId;
/* 259 */     argStatement.setLong(1, id.getOrganizationId().longValue());
/* 260 */     argStatement.setLong(2, id.getRetailLocationId().longValue());
/* 261 */     argStatement.setLong(3, id.getSessionId().longValue());
/* 262 */     return argStatement;
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 266 */     SessionId id = new SessionId();
/* 267 */     id.setOrganizationId(this._organizationId);
/* 268 */     id.setRetailLocationId(this._retailLocationId);
/* 269 */     id.setSessionId(this._sessionId);
/* 270 */     return (IObjectId)id;
/*     */   }
/*     */ 
/*     */   
/*     */   public void fill(IJDBCTableAdapter argAdapter) {}
/*     */ 
/*     */   
/*     */   public boolean isExtensible() {
/* 278 */     return false;
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 282 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\tsn\impl\SessionDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */