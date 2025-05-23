/*     */ package dtv.xst.dao._test.impl;
/*     */ 
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.impl.jdbc.IFiller;
/*     */ import dtv.data2.access.impl.jdbc.IJDBCTableAdapter;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao._test.XunitResultId;
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
/*     */ public class XunitResultDBA
/*     */   implements IJDBCTableAdapter
/*     */ {
/*     */   private static final long serialVersionUID = -1359557351L;
/*     */   private Long _organizationId;
/*     */   private String _hostname;
/*     */   private Long _resultTimestamp;
/*     */   private Date _createDate;
/*     */   private String _createUserId;
/*     */   private Date _updateDate;
/*     */   private String _updateUserId;
/*     */   private String _ipAddress;
/*     */   private Long _retailLocationId;
/*     */   private Date _businessDate;
/*     */   private Long _workstationId;
/*     */   private String _xstoreVersion;
/*     */   private String _status;
/*     */   private Date _beginDatetimestamp;
/*     */   private Date _endDatetimestamp;
/*     */   private Long _totalCount;
/*     */   private Long _completedCount;
/*     */   private Long _failedCount;
/*     */   private static final String SELECT_OBJECT = "SELECT t.organization_id, t.hostname, t.result_timestamp, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.ip_address, t.rtl_loc_id, t.business_date, t.wkstn_id, t.xstore_version, t.status, t.begin_datetime, t.end_datetime, t.total_count, t.completed_count, t.failed_count FROM xunit_result t";
/*     */   private static final String SELECT_WHERE_OBJECT = " WHERE organization_id = ?  AND hostname = ?  AND result_timestamp = ?  ";
/*     */   
/*     */   public String getSelect() {
/*  47 */     return getSelectImpl();
/*     */   }
/*     */   
/*     */   private String getSelectImpl() {
/*  51 */     return "SELECT t.organization_id, t.hostname, t.result_timestamp, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.ip_address, t.rtl_loc_id, t.business_date, t.wkstn_id, t.xstore_version, t.status, t.begin_datetime, t.end_datetime, t.total_count, t.completed_count, t.failed_count FROM xunit_result t";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectWhere() {
/*  57 */     return " WHERE organization_id = ?  AND hostname = ?  AND result_timestamp = ?  ";
/*     */   }
/*     */   
/*  60 */   private static final String[] INSERT_OBJECT = new String[] { "INSERT INTO xunit_result(organization_id, hostname, result_timestamp, create_date, create_user_id, update_date, update_user_id, ip_address, rtl_loc_id, business_date, wkstn_id, xstore_version, status, begin_datetime, end_datetime, total_count, completed_count, failed_count) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" };
/*     */   
/*     */   public String[] getInsert() {
/*  63 */     return INSERT_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getInsertParameters() {
/*  67 */     Object[][] insertParameterObject = { { this._organizationId, this._hostname, this._resultTimestamp, this._createDate, this._createUserId, this._updateDate, this._updateUserId, this._ipAddress, this._retailLocationId, this._businessDate, this._workstationId, this._xstoreVersion, this._status, this._beginDatetimestamp, this._endDatetimestamp, this._totalCount, this._completedCount, this._failedCount } };
/*  68 */     return insertParameterObject;
/*     */   }
/*     */   
/*  71 */   private static final int[][] INSERT_PARAMETER_TYPES_OBJECT = new int[][] { { -5, 12, -5, 91, 12, 91, 12, 12, -5, 91, -5, 12, 12, 91, 91, -5, -5, -5 } };
/*     */   
/*     */   public int[][] getInsertParameterTypes() {
/*  74 */     return INSERT_PARAMETER_TYPES_OBJECT;
/*     */   }
/*     */   
/*  77 */   private static final String[] UPDATE_OBJECT = new String[] { "UPDATE xunit_result SET update_date = ?, update_user_id = ?, ip_address = ?, rtl_loc_id = ?, business_date = ?, wkstn_id = ?, xstore_version = ?, status = ?, begin_datetime = ?, end_datetime = ?, total_count = ?, completed_count = ?, failed_count = ?" };
/*     */   
/*     */   public String[] getUpdate() {
/*  80 */     return UPDATE_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getUpdateParameters() {
/*  84 */     Object[][] updateParameterObject = { { this._updateDate, this._updateUserId, this._ipAddress, this._retailLocationId, this._businessDate, this._workstationId, this._xstoreVersion, this._status, this._beginDatetimestamp, this._endDatetimestamp, this._totalCount, this._completedCount, this._failedCount } };
/*  85 */     return updateParameterObject;
/*     */   }
/*     */   
/*  88 */   private static final int[][] UPDATE_PARAMETER_TYPE_OBJECT = new int[][] { { 91, 12, 12, -5, 91, -5, 12, 12, 91, 91, -5, -5, -5 } };
/*     */   public int[][] getUpdateParameterTypes() {
/*  90 */     return UPDATE_PARAMETER_TYPE_OBJECT;
/*     */   }
/*     */   
/*  93 */   private static final String[] DELETE_OBJECT = new String[] { "DELETE FROM xunit_result" }; private static final String WHERE_OBJECT = " WHERE organization_id = ?  AND hostname = ?  AND result_timestamp = ?  ";
/*     */   
/*     */   public String[] getDelete() {
/*  96 */     return DELETE_OBJECT;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWhere() {
/* 102 */     return " WHERE organization_id = ?  AND hostname = ?  AND result_timestamp = ?  ";
/*     */   }
/*     */   public Object[] getWhereParameters() {
/* 105 */     return new Object[] { this._organizationId, this._hostname, this._resultTimestamp };
/*     */   }
/*     */   
/* 108 */   private static final int[] WHERE_PARAMETER_OBJECT = new int[] { -5, 12, -5 };
/*     */   
/*     */   public int[] getWhereParameterTypes() {
/* 111 */     return WHERE_PARAMETER_OBJECT;
/*     */   }
/*     */   public String getTableName() {
/* 114 */     return "xunit_result";
/*     */   }
/*     */   
/*     */   public IFiller getFiller() {
/* 118 */     return getFillerImpl();
/*     */   }
/*     */   
/*     */   private IFiller getFillerImpl() {
/* 122 */     return new XunitResultFiller(this);
/*     */   }
/*     */   
/*     */   private static class XunitResultFiller
/*     */     implements IFiller {
/*     */     private XunitResultDBA _parent;
/*     */     
/*     */     public XunitResultFiller(XunitResultDBA argParent) {
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
/* 141 */       this._parent._hostname = argResultSet.getString(2);
/*     */ 
/*     */       
/* 144 */       primitiveResult = argResultSet.getLong(3);
/* 145 */       if (primitiveResult != 0L || argResultSet.getObject(3) != null) {
/* 146 */         this._parent._resultTimestamp = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 151 */       Timestamp t4 = argResultSet.getTimestamp(4);
/* 152 */       if (t4 != null) {
/* 153 */         this._parent._createDate = (Date)new DtvDate(t4.getTime());
/*     */       } else {
/*     */         
/* 156 */         this._parent._createDate = null;
/*     */       } 
/*     */       
/* 159 */       this._parent._createUserId = argResultSet.getString(5);
/*     */       
/* 161 */       Timestamp t6 = argResultSet.getTimestamp(6);
/* 162 */       if (t6 != null) {
/* 163 */         this._parent._updateDate = (Date)new DtvDate(t6.getTime());
/*     */       } else {
/*     */         
/* 166 */         this._parent._updateDate = null;
/*     */       } 
/*     */       
/* 169 */       this._parent._updateUserId = argResultSet.getString(7);
/* 170 */       this._parent._ipAddress = argResultSet.getString(8);
/*     */ 
/*     */       
/* 173 */       long l1 = argResultSet.getLong(9);
/* 174 */       if (l1 != 0L || argResultSet.getObject(9) != null) {
/* 175 */         this._parent._retailLocationId = Long.valueOf(l1);
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 180 */       Timestamp t10 = argResultSet.getTimestamp(10);
/* 181 */       if (t10 != null) {
/* 182 */         this._parent._businessDate = (Date)new DtvDate(t10.getTime());
/*     */       } else {
/*     */         
/* 185 */         this._parent._businessDate = null;
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/* 190 */       long l2 = argResultSet.getLong(11);
/* 191 */       if (l2 != 0L || argResultSet.getObject(11) != null) {
/* 192 */         this._parent._workstationId = Long.valueOf(l2);
/*     */       }
/*     */ 
/*     */       
/* 196 */       this._parent._xstoreVersion = argResultSet.getString(12);
/* 197 */       this._parent._status = argResultSet.getString(13);
/*     */       
/* 199 */       Timestamp t14 = argResultSet.getTimestamp(14);
/* 200 */       if (t14 != null) {
/* 201 */         this._parent._beginDatetimestamp = (Date)new DtvDate(t14.getTime());
/*     */       } else {
/*     */         
/* 204 */         this._parent._beginDatetimestamp = null;
/*     */       } 
/*     */ 
/*     */       
/* 208 */       Timestamp t15 = argResultSet.getTimestamp(15);
/* 209 */       if (t15 != null) {
/* 210 */         this._parent._endDatetimestamp = (Date)new DtvDate(t15.getTime());
/*     */       } else {
/*     */         
/* 213 */         this._parent._endDatetimestamp = null;
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/* 218 */       long l3 = argResultSet.getLong(16);
/* 219 */       if (l3 != 0L || argResultSet.getObject(16) != null) {
/* 220 */         this._parent._totalCount = Long.valueOf(l3);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 226 */       l3 = argResultSet.getLong(17);
/* 227 */       if (l3 != 0L || argResultSet.getObject(17) != null) {
/* 228 */         this._parent._completedCount = Long.valueOf(l3);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 234 */       l3 = argResultSet.getLong(18);
/* 235 */       if (l3 != 0L || argResultSet.getObject(18) != null) {
/* 236 */         this._parent._failedCount = Long.valueOf(l3);
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IDataAccessObject loadDAO(IDataAccessObject argDAO) {
/* 244 */     argDAO.suppressStateChanges(true);
/* 245 */     XunitResultDAO dao = (XunitResultDAO)argDAO;
/* 246 */     dao.setOrganizationId(this._organizationId);
/* 247 */     dao.setHostname(this._hostname);
/* 248 */     dao.setResultTimestamp(this._resultTimestamp);
/* 249 */     dao.setCreateDate(this._createDate);
/* 250 */     dao.setCreateUserId(this._createUserId);
/* 251 */     dao.setUpdateDate(this._updateDate);
/* 252 */     dao.setUpdateUserId(this._updateUserId);
/* 253 */     dao.setIpAddress(this._ipAddress);
/* 254 */     dao.setRetailLocationId(this._retailLocationId);
/* 255 */     dao.setBusinessDate(this._businessDate);
/* 256 */     dao.setWorkstationId(this._workstationId);
/* 257 */     dao.setXstoreVersion(this._xstoreVersion);
/* 258 */     dao.setStatus(this._status);
/* 259 */     dao.setBeginDatetimestamp(this._beginDatetimestamp);
/* 260 */     dao.setEndDatetimestamp(this._endDatetimestamp);
/* 261 */     dao.setTotalCount(this._totalCount);
/* 262 */     dao.setCompletedCount(this._completedCount);
/* 263 */     dao.setFailedCount(this._failedCount);
/* 264 */     argDAO.suppressStateChanges(false);
/* 265 */     return (IDataAccessObject)dao;
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDefaultDAO() {
/* 269 */     return loadDAO((IDataAccessObject)new XunitResultDAO());
/*     */   }
/*     */   
/*     */   public void fill(IDataAccessObject argDAO) {
/* 273 */     XunitResultDAO dao = (XunitResultDAO)argDAO;
/* 274 */     this._organizationId = dao.getOrganizationId();
/* 275 */     this._hostname = dao.getHostname();
/* 276 */     this._resultTimestamp = dao.getResultTimestamp();
/* 277 */     this._createDate = dao.getCreateDate();
/* 278 */     this._createUserId = dao.getCreateUserId();
/* 279 */     this._updateDate = dao.getUpdateDate();
/* 280 */     this._updateUserId = dao.getUpdateUserId();
/* 281 */     this._ipAddress = dao.getIpAddress();
/* 282 */     this._retailLocationId = dao.getRetailLocationId();
/* 283 */     this._businessDate = dao.getBusinessDate();
/* 284 */     this._workstationId = dao.getWorkstationId();
/* 285 */     this._xstoreVersion = dao.getXstoreVersion();
/* 286 */     this._status = dao.getStatus();
/* 287 */     this._beginDatetimestamp = dao.getBeginDatetimestamp();
/* 288 */     this._endDatetimestamp = dao.getEndDatetimestamp();
/* 289 */     this._totalCount = dao.getTotalCount();
/* 290 */     this._completedCount = dao.getCompletedCount();
/* 291 */     this._failedCount = dao.getFailedCount();
/*     */   }
/*     */   
/*     */   public PreparedStatement writeObjectId(IObjectId argId, PreparedStatement argStatement) throws SQLException {
/* 295 */     XunitResultId id = (XunitResultId)argId;
/* 296 */     argStatement.setLong(1, id.getOrganizationId().longValue());
/* 297 */     argStatement.setString(2, id.getHostname());
/* 298 */     argStatement.setLong(3, id.getResultTimestamp().longValue());
/* 299 */     return argStatement;
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 303 */     XunitResultId id = new XunitResultId();
/* 304 */     id.setOrganizationId(this._organizationId);
/* 305 */     id.setHostname(this._hostname);
/* 306 */     id.setResultTimestamp(this._resultTimestamp);
/* 307 */     return (IObjectId)id;
/*     */   }
/*     */ 
/*     */   
/*     */   public void fill(IJDBCTableAdapter argAdapter) {}
/*     */ 
/*     */   
/*     */   public boolean isExtensible() {
/* 315 */     return false;
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 319 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\_test\impl\XunitResultDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */