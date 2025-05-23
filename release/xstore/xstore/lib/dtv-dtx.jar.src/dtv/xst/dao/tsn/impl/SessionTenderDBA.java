/*     */ package dtv.xst.dao.tsn.impl;
/*     */ 
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.impl.IHasIncrementalValues;
/*     */ import dtv.data2.access.impl.jdbc.IFiller;
/*     */ import dtv.data2.access.impl.jdbc.IJDBCTableAdapter;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.tsn.SessionTenderId;
/*     */ import java.math.BigDecimal;
/*     */ import java.sql.PreparedStatement;
/*     */ import java.sql.ResultSet;
/*     */ import java.sql.SQLException;
/*     */ import java.sql.Timestamp;
/*     */ import java.util.Date;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SessionTenderDBA
/*     */   implements IJDBCTableAdapter, IHasIncrementalValues
/*     */ {
/*     */   private static final long serialVersionUID = 671533290L;
/*     */   private Long _organizationId;
/*     */   private Long _retailLocationId;
/*     */   private Long _sessionId;
/*     */   private String _tenderId;
/*     */   private Date _createDate;
/*     */   private String _createUserId;
/*     */   private Date _updateDate;
/*     */   private String _updateUserId;
/*     */   private BigDecimal _mediaAmount;
/*     */   private BigDecimal _initMediaAmount;
/*     */   private Integer _mediaCount;
/*     */   private Integer _initMediaCount;
/*     */   protected boolean _incrementalActive = true;
/*     */   private static final String SELECT_OBJECT = "SELECT t.organization_id, t.rtl_loc_id, t.session_id, t.tndr_id, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.actual_media_amt, t.actual_media_count FROM tsn_session_tndr t";
/*     */   private static final String SELECT_WHERE_OBJECT = " WHERE organization_id = ?  AND rtl_loc_id = ?  AND session_id = ?  AND tndr_id = ?  ";
/*     */   
/*     */   public void setIncrementalActive(boolean argActive) {
/*  40 */     this._incrementalActive = argActive;
/*     */   }
/*     */   
/*     */   public boolean getIncrementalActive() {
/*  44 */     return this._incrementalActive;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelect() {
/*  50 */     return getSelectImpl();
/*     */   }
/*     */   
/*     */   private String getSelectImpl() {
/*  54 */     return "SELECT t.organization_id, t.rtl_loc_id, t.session_id, t.tndr_id, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.actual_media_amt, t.actual_media_count FROM tsn_session_tndr t";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectWhere() {
/*  60 */     return " WHERE organization_id = ?  AND rtl_loc_id = ?  AND session_id = ?  AND tndr_id = ?  ";
/*     */   }
/*     */   
/*  63 */   private static final String[] INSERT_OBJECT = new String[] { "INSERT INTO tsn_session_tndr(organization_id, rtl_loc_id, session_id, tndr_id, create_date, create_user_id, update_date, update_user_id, actual_media_amt, actual_media_count) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" };
/*     */   
/*     */   public String[] getInsert() {
/*  66 */     return INSERT_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getInsertParameters() {
/*  70 */     Object[][] insertParameterObject = { { this._organizationId, this._retailLocationId, this._sessionId, this._tenderId, this._createDate, this._createUserId, this._updateDate, this._updateUserId, this._mediaAmount, this._mediaCount } };
/*  71 */     return insertParameterObject;
/*     */   }
/*     */   
/*  74 */   private static final int[][] INSERT_PARAMETER_TYPES_OBJECT = new int[][] { { -5, -5, -5, 12, 91, 12, 91, 12, 3, 4 } };
/*     */   
/*     */   public int[][] getInsertParameterTypes() {
/*  77 */     return INSERT_PARAMETER_TYPES_OBJECT;
/*     */   }
/*     */   
/*     */   public String[] getUpdate() {
/*  81 */     if (this._incrementalActive) {
/*  82 */       return getIncrementalUpdate();
/*     */     }
/*     */     
/*  85 */     return getStandardUpdate();
/*     */   }
/*     */ 
/*     */   
/*  89 */   private static final String[] INCREMENTAL_UPDATE_OBJECT = new String[] { "UPDATE tsn_session_tndr SET update_date = ?, update_user_id = ?, actual_media_amt = COALESCE(actual_media_amt,0) + ?, actual_media_count = COALESCE(actual_media_count,0) + ?" };
/*     */   
/*     */   public String[] getIncrementalUpdate() {
/*  92 */     return INCREMENTAL_UPDATE_OBJECT;
/*     */   }
/*     */   
/*  95 */   private static final String[] STANDARD_UPDATE_OBJECT = new String[] { "UPDATE tsn_session_tndr SET update_date = ?, update_user_id = ?, actual_media_amt = ?, actual_media_count = ?" };
/*     */   
/*     */   public String[] getStandardUpdate() {
/*  98 */     return STANDARD_UPDATE_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getUpdateParameters() {
/* 102 */     Object[][] updateParameterObject = { { this._updateDate, this._updateUserId, getMediaAmountDiff(), getMediaCountDiff() } };
/* 103 */     return updateParameterObject;
/*     */   }
/*     */   
/* 106 */   private static final int[][] UPDATE_PARAMETER_TYPE_OBJECT = new int[][] { { 91, 12, 3, 4 } };
/*     */   public int[][] getUpdateParameterTypes() {
/* 108 */     return UPDATE_PARAMETER_TYPE_OBJECT;
/*     */   }
/*     */   
/* 111 */   private static final String[] DELETE_OBJECT = new String[] { "DELETE FROM tsn_session_tndr" }; private static final String WHERE_OBJECT = " WHERE organization_id = ?  AND rtl_loc_id = ?  AND session_id = ?  AND tndr_id = ?  ";
/*     */   
/*     */   public String[] getDelete() {
/* 114 */     return DELETE_OBJECT;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWhere() {
/* 120 */     return " WHERE organization_id = ?  AND rtl_loc_id = ?  AND session_id = ?  AND tndr_id = ?  ";
/*     */   }
/*     */   public Object[] getWhereParameters() {
/* 123 */     return new Object[] { this._organizationId, this._retailLocationId, this._sessionId, this._tenderId };
/*     */   }
/*     */   
/* 126 */   private static final int[] WHERE_PARAMETER_OBJECT = new int[] { -5, -5, -5, 12 };
/*     */   
/*     */   public int[] getWhereParameterTypes() {
/* 129 */     return WHERE_PARAMETER_OBJECT;
/*     */   }
/*     */ 
/*     */   
/*     */   private BigDecimal getMediaAmountDiff() {
/*     */     BigDecimal val1, val2;
/* 135 */     if (this._mediaAmount == null) {
/* 136 */       val1 = new BigDecimal(0);
/*     */     } else {
/*     */       
/* 139 */       val1 = this._mediaAmount;
/*     */     } 
/*     */     
/* 142 */     if (this._initMediaAmount == null) {
/* 143 */       val2 = new BigDecimal(0);
/*     */     } else {
/*     */       
/* 146 */       val2 = this._initMediaAmount;
/*     */     } 
/*     */     
/* 149 */     BigDecimal res = val1.subtract(val2);
/*     */     
/* 151 */     if (res.scale() < 8) {
/* 152 */       res = res.setScale(8);
/*     */     }
/*     */     
/* 155 */     return res;
/*     */   }
/*     */ 
/*     */   
/*     */   private Integer getMediaCountDiff() {
/*     */     Integer val1;
/*     */     Integer val2;
/* 162 */     if (this._mediaCount == null) {
/* 163 */       val1 = new Integer(0);
/*     */     } else {
/*     */       
/* 166 */       val1 = this._mediaCount;
/*     */     } 
/*     */     
/* 169 */     if (this._initMediaCount == null) {
/* 170 */       val2 = new Integer(0);
/*     */     } else {
/*     */       
/* 173 */       val2 = this._initMediaCount;
/*     */     } 
/*     */     
/* 176 */     return Integer.valueOf(val1.intValue() - val2.intValue());
/*     */   }
/*     */   
/*     */   public String getTableName() {
/* 180 */     return "tsn_session_tndr";
/*     */   }
/*     */   
/*     */   public IFiller getFiller() {
/* 184 */     return getFillerImpl();
/*     */   }
/*     */   
/*     */   private IFiller getFillerImpl() {
/* 188 */     return new SessionTenderFiller(this);
/*     */   }
/*     */   
/*     */   private static class SessionTenderFiller
/*     */     implements IFiller {
/*     */     private SessionTenderDBA _parent;
/*     */     
/*     */     public SessionTenderFiller(SessionTenderDBA argParent) {
/* 196 */       this._parent = argParent;
/*     */     }
/*     */ 
/*     */     
/*     */     public void fill(ResultSet argResultSet) throws SQLException {
/* 201 */       long primitiveResult = argResultSet.getLong(1);
/* 202 */       if (primitiveResult != 0L || argResultSet.getObject(1) != null) {
/* 203 */         this._parent._organizationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 209 */       primitiveResult = argResultSet.getLong(2);
/* 210 */       if (primitiveResult != 0L || argResultSet.getObject(2) != null) {
/* 211 */         this._parent._retailLocationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 217 */       primitiveResult = argResultSet.getLong(3);
/* 218 */       if (primitiveResult != 0L || argResultSet.getObject(3) != null) {
/* 219 */         this._parent._sessionId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */       
/* 223 */       this._parent._tenderId = argResultSet.getString(4);
/*     */       
/* 225 */       Timestamp t5 = argResultSet.getTimestamp(5);
/* 226 */       if (t5 != null) {
/* 227 */         this._parent._createDate = (Date)new DtvDate(t5.getTime());
/*     */       } else {
/*     */         
/* 230 */         this._parent._createDate = null;
/*     */       } 
/*     */       
/* 233 */       this._parent._createUserId = argResultSet.getString(6);
/*     */       
/* 235 */       Timestamp t7 = argResultSet.getTimestamp(7);
/* 236 */       if (t7 != null) {
/* 237 */         this._parent._updateDate = (Date)new DtvDate(t7.getTime());
/*     */       } else {
/*     */         
/* 240 */         this._parent._updateDate = null;
/*     */       } 
/*     */       
/* 243 */       this._parent._updateUserId = argResultSet.getString(8);
/* 244 */       this._parent._mediaAmount = argResultSet.getBigDecimal(9);
/* 245 */       this._parent._initMediaAmount = argResultSet.getBigDecimal(9);
/*     */ 
/*     */       
/* 248 */       int i = argResultSet.getInt(10);
/* 249 */       if (i != 0 || argResultSet.getObject(10) != null) {
/* 250 */         this._parent._mediaCount = Integer.valueOf(i);
/*     */       }
/*     */ 
/*     */       
/* 254 */       this._parent._initMediaCount = Integer.valueOf(argResultSet.getInt(10));
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDAO(IDataAccessObject argDAO) {
/* 259 */     argDAO.suppressStateChanges(true);
/* 260 */     SessionTenderDAO dao = (SessionTenderDAO)argDAO;
/* 261 */     dao.setOrganizationId(this._organizationId);
/* 262 */     dao.setRetailLocationId(this._retailLocationId);
/* 263 */     dao.setSessionId(this._sessionId);
/* 264 */     dao.setTenderId(this._tenderId);
/* 265 */     dao.setCreateDate(this._createDate);
/* 266 */     dao.setCreateUserId(this._createUserId);
/* 267 */     dao.setUpdateDate(this._updateDate);
/* 268 */     dao.setUpdateUserId(this._updateUserId);
/* 269 */     dao.setMediaAmount(this._mediaAmount);
/* 270 */     dao.setInitMediaAmount(this._mediaAmount);
/* 271 */     dao.setMediaCount(this._mediaCount);
/* 272 */     dao.setInitMediaCount(this._mediaCount);
/* 273 */     argDAO.suppressStateChanges(false);
/* 274 */     return (IDataAccessObject)dao;
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDefaultDAO() {
/* 278 */     return loadDAO((IDataAccessObject)new SessionTenderDAO());
/*     */   }
/*     */   
/*     */   public void fill(IDataAccessObject argDAO) {
/* 282 */     SessionTenderDAO dao = (SessionTenderDAO)argDAO;
/* 283 */     this._organizationId = dao.getOrganizationId();
/* 284 */     this._retailLocationId = dao.getRetailLocationId();
/* 285 */     this._sessionId = dao.getSessionId();
/* 286 */     this._tenderId = dao.getTenderId();
/* 287 */     this._createDate = dao.getCreateDate();
/* 288 */     this._createUserId = dao.getCreateUserId();
/* 289 */     this._updateDate = dao.getUpdateDate();
/* 290 */     this._updateUserId = dao.getUpdateUserId();
/* 291 */     this._mediaAmount = dao.getMediaAmount();
/* 292 */     this._initMediaAmount = dao.getInitMediaAmount();
/* 293 */     this._mediaCount = dao.getMediaCount();
/* 294 */     this._initMediaCount = dao.getInitMediaCount();
/*     */   }
/*     */   
/*     */   public PreparedStatement writeObjectId(IObjectId argId, PreparedStatement argStatement) throws SQLException {
/* 298 */     SessionTenderId id = (SessionTenderId)argId;
/* 299 */     argStatement.setLong(1, id.getOrganizationId().longValue());
/* 300 */     argStatement.setLong(2, id.getRetailLocationId().longValue());
/* 301 */     argStatement.setLong(3, id.getSessionId().longValue());
/* 302 */     argStatement.setString(4, id.getTenderId());
/* 303 */     return argStatement;
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 307 */     SessionTenderId id = new SessionTenderId();
/* 308 */     id.setOrganizationId(this._organizationId);
/* 309 */     id.setRetailLocationId(this._retailLocationId);
/* 310 */     id.setSessionId(this._sessionId);
/* 311 */     id.setTenderId(this._tenderId);
/* 312 */     return (IObjectId)id;
/*     */   }
/*     */ 
/*     */   
/*     */   public void fill(IJDBCTableAdapter argAdapter) {}
/*     */ 
/*     */   
/*     */   public boolean isExtensible() {
/* 320 */     return false;
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 324 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\tsn\impl\SessionTenderDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */