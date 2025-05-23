/*     */ package dtv.xst.dao._test.impl;
/*     */ 
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.impl.jdbc.IFiller;
/*     */ import dtv.data2.access.impl.jdbc.IJDBCTableAdapter;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao._test.XunitResultItemId;
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
/*     */ public class XunitResultItemDBA
/*     */   implements IJDBCTableAdapter
/*     */ {
/*     */   private static final long serialVersionUID = -1907652660L;
/*     */   private Long _organizationId;
/*     */   private String _hostname;
/*     */   private Long _resultTimestamp;
/*     */   private Long _resultItemSequence;
/*     */   private Date _createDate;
/*     */   private String _createUserId;
/*     */   private Date _updateDate;
/*     */   private String _updateUserId;
/*     */   private String _testCaseName;
/*     */   private Long _testNumber;
/*     */   private Long _testIteration;
/*     */   private String _resultItemStatus;
/*     */   private Date _resultItemDatetimestamp;
/*     */   private String _failureReason;
/*     */   private String _logData;
/*     */   private static final String SELECT_OBJECT = "SELECT t.organization_id, t.hostname, t.result_timestamp, t.result_item_seq, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.test_case_name, t.test_nbr, t.test_iteration, t.result_item_status, t.result_item_datetime, t.failure_reason, t.log_data FROM xunit_result_item t";
/*     */   private static final String SELECT_WHERE_OBJECT = " WHERE organization_id = ?  AND hostname = ?  AND result_timestamp = ?  AND result_item_seq = ?  ";
/*     */   
/*     */   public String getSelect() {
/*  44 */     return getSelectImpl();
/*     */   }
/*     */   
/*     */   private String getSelectImpl() {
/*  48 */     return "SELECT t.organization_id, t.hostname, t.result_timestamp, t.result_item_seq, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.test_case_name, t.test_nbr, t.test_iteration, t.result_item_status, t.result_item_datetime, t.failure_reason, t.log_data FROM xunit_result_item t";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectWhere() {
/*  54 */     return " WHERE organization_id = ?  AND hostname = ?  AND result_timestamp = ?  AND result_item_seq = ?  ";
/*     */   }
/*     */   
/*  57 */   private static final String[] INSERT_OBJECT = new String[] { "INSERT INTO xunit_result_item(organization_id, hostname, result_timestamp, result_item_seq, create_date, create_user_id, update_date, update_user_id, test_case_name, test_nbr, test_iteration, result_item_status, result_item_datetime, failure_reason, log_data) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" };
/*     */   
/*     */   public String[] getInsert() {
/*  60 */     return INSERT_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getInsertParameters() {
/*  64 */     Object[][] insertParameterObject = { { this._organizationId, this._hostname, this._resultTimestamp, this._resultItemSequence, this._createDate, this._createUserId, this._updateDate, this._updateUserId, this._testCaseName, this._testNumber, this._testIteration, this._resultItemStatus, this._resultItemDatetimestamp, this._failureReason, this._logData } };
/*  65 */     return insertParameterObject;
/*     */   }
/*     */   
/*  68 */   private static final int[][] INSERT_PARAMETER_TYPES_OBJECT = new int[][] { { -5, 12, -5, -5, 91, 12, 91, 12, 12, -5, -5, 12, 91, 12, 12 } };
/*     */   
/*     */   public int[][] getInsertParameterTypes() {
/*  71 */     return INSERT_PARAMETER_TYPES_OBJECT;
/*     */   }
/*     */   
/*  74 */   private static final String[] UPDATE_OBJECT = new String[] { "UPDATE xunit_result_item SET update_date = ?, update_user_id = ?, test_case_name = ?, test_nbr = ?, test_iteration = ?, result_item_status = ?, result_item_datetime = ?, failure_reason = ?, log_data = ?" };
/*     */   
/*     */   public String[] getUpdate() {
/*  77 */     return UPDATE_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getUpdateParameters() {
/*  81 */     Object[][] updateParameterObject = { { this._updateDate, this._updateUserId, this._testCaseName, this._testNumber, this._testIteration, this._resultItemStatus, this._resultItemDatetimestamp, this._failureReason, this._logData } };
/*  82 */     return updateParameterObject;
/*     */   }
/*     */   
/*  85 */   private static final int[][] UPDATE_PARAMETER_TYPE_OBJECT = new int[][] { { 91, 12, 12, -5, -5, 12, 91, 12, 12 } };
/*     */   public int[][] getUpdateParameterTypes() {
/*  87 */     return UPDATE_PARAMETER_TYPE_OBJECT;
/*     */   }
/*     */   
/*  90 */   private static final String[] DELETE_OBJECT = new String[] { "DELETE FROM xunit_result_item" }; private static final String WHERE_OBJECT = " WHERE organization_id = ?  AND hostname = ?  AND result_timestamp = ?  AND result_item_seq = ?  ";
/*     */   
/*     */   public String[] getDelete() {
/*  93 */     return DELETE_OBJECT;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWhere() {
/*  99 */     return " WHERE organization_id = ?  AND hostname = ?  AND result_timestamp = ?  AND result_item_seq = ?  ";
/*     */   }
/*     */   public Object[] getWhereParameters() {
/* 102 */     return new Object[] { this._organizationId, this._hostname, this._resultTimestamp, this._resultItemSequence };
/*     */   }
/*     */   
/* 105 */   private static final int[] WHERE_PARAMETER_OBJECT = new int[] { -5, 12, -5, -5 };
/*     */   
/*     */   public int[] getWhereParameterTypes() {
/* 108 */     return WHERE_PARAMETER_OBJECT;
/*     */   }
/*     */   public String getTableName() {
/* 111 */     return "xunit_result_item";
/*     */   }
/*     */   
/*     */   public IFiller getFiller() {
/* 115 */     return getFillerImpl();
/*     */   }
/*     */   
/*     */   private IFiller getFillerImpl() {
/* 119 */     return new XunitResultItemFiller(this);
/*     */   }
/*     */   
/*     */   private static class XunitResultItemFiller
/*     */     implements IFiller {
/*     */     private XunitResultItemDBA _parent;
/*     */     
/*     */     public XunitResultItemFiller(XunitResultItemDBA argParent) {
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
/* 138 */       this._parent._hostname = argResultSet.getString(2);
/*     */ 
/*     */       
/* 141 */       primitiveResult = argResultSet.getLong(3);
/* 142 */       if (primitiveResult != 0L || argResultSet.getObject(3) != null) {
/* 143 */         this._parent._resultTimestamp = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 149 */       primitiveResult = argResultSet.getLong(4);
/* 150 */       if (primitiveResult != 0L || argResultSet.getObject(4) != null) {
/* 151 */         this._parent._resultItemSequence = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 156 */       Timestamp t5 = argResultSet.getTimestamp(5);
/* 157 */       if (t5 != null) {
/* 158 */         this._parent._createDate = (Date)new DtvDate(t5.getTime());
/*     */       } else {
/*     */         
/* 161 */         this._parent._createDate = null;
/*     */       } 
/*     */       
/* 164 */       this._parent._createUserId = argResultSet.getString(6);
/*     */       
/* 166 */       Timestamp t7 = argResultSet.getTimestamp(7);
/* 167 */       if (t7 != null) {
/* 168 */         this._parent._updateDate = (Date)new DtvDate(t7.getTime());
/*     */       } else {
/*     */         
/* 171 */         this._parent._updateDate = null;
/*     */       } 
/*     */       
/* 174 */       this._parent._updateUserId = argResultSet.getString(8);
/* 175 */       this._parent._testCaseName = argResultSet.getString(9);
/*     */ 
/*     */       
/* 178 */       long l1 = argResultSet.getLong(10);
/* 179 */       if (l1 != 0L || argResultSet.getObject(10) != null) {
/* 180 */         this._parent._testNumber = Long.valueOf(l1);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 186 */       l1 = argResultSet.getLong(11);
/* 187 */       if (l1 != 0L || argResultSet.getObject(11) != null) {
/* 188 */         this._parent._testIteration = Long.valueOf(l1);
/*     */       }
/*     */ 
/*     */       
/* 192 */       this._parent._resultItemStatus = argResultSet.getString(12);
/*     */       
/* 194 */       Timestamp t13 = argResultSet.getTimestamp(13);
/* 195 */       if (t13 != null) {
/* 196 */         this._parent._resultItemDatetimestamp = (Date)new DtvDate(t13.getTime());
/*     */       } else {
/*     */         
/* 199 */         this._parent._resultItemDatetimestamp = null;
/*     */       } 
/*     */       
/* 202 */       this._parent._failureReason = argResultSet.getString(14);
/* 203 */       this._parent._logData = argResultSet.getString(15);
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDAO(IDataAccessObject argDAO) {
/* 208 */     argDAO.suppressStateChanges(true);
/* 209 */     XunitResultItemDAO dao = (XunitResultItemDAO)argDAO;
/* 210 */     dao.setOrganizationId(this._organizationId);
/* 211 */     dao.setHostname(this._hostname);
/* 212 */     dao.setResultTimestamp(this._resultTimestamp);
/* 213 */     dao.setResultItemSequence(this._resultItemSequence);
/* 214 */     dao.setCreateDate(this._createDate);
/* 215 */     dao.setCreateUserId(this._createUserId);
/* 216 */     dao.setUpdateDate(this._updateDate);
/* 217 */     dao.setUpdateUserId(this._updateUserId);
/* 218 */     dao.setTestCaseName(this._testCaseName);
/* 219 */     dao.setTestNumber(this._testNumber);
/* 220 */     dao.setTestIteration(this._testIteration);
/* 221 */     dao.setResultItemStatus(this._resultItemStatus);
/* 222 */     dao.setResultItemDatetimestamp(this._resultItemDatetimestamp);
/* 223 */     dao.setFailureReason(this._failureReason);
/* 224 */     dao.setLogData(this._logData);
/* 225 */     argDAO.suppressStateChanges(false);
/* 226 */     return (IDataAccessObject)dao;
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDefaultDAO() {
/* 230 */     return loadDAO((IDataAccessObject)new XunitResultItemDAO());
/*     */   }
/*     */   
/*     */   public void fill(IDataAccessObject argDAO) {
/* 234 */     XunitResultItemDAO dao = (XunitResultItemDAO)argDAO;
/* 235 */     this._organizationId = dao.getOrganizationId();
/* 236 */     this._hostname = dao.getHostname();
/* 237 */     this._resultTimestamp = dao.getResultTimestamp();
/* 238 */     this._resultItemSequence = dao.getResultItemSequence();
/* 239 */     this._createDate = dao.getCreateDate();
/* 240 */     this._createUserId = dao.getCreateUserId();
/* 241 */     this._updateDate = dao.getUpdateDate();
/* 242 */     this._updateUserId = dao.getUpdateUserId();
/* 243 */     this._testCaseName = dao.getTestCaseName();
/* 244 */     this._testNumber = dao.getTestNumber();
/* 245 */     this._testIteration = dao.getTestIteration();
/* 246 */     this._resultItemStatus = dao.getResultItemStatus();
/* 247 */     this._resultItemDatetimestamp = dao.getResultItemDatetimestamp();
/* 248 */     this._failureReason = dao.getFailureReason();
/* 249 */     this._logData = dao.getLogData();
/*     */   }
/*     */   
/*     */   public PreparedStatement writeObjectId(IObjectId argId, PreparedStatement argStatement) throws SQLException {
/* 253 */     XunitResultItemId id = (XunitResultItemId)argId;
/* 254 */     argStatement.setLong(1, id.getOrganizationId().longValue());
/* 255 */     argStatement.setString(2, id.getHostname());
/* 256 */     argStatement.setLong(3, id.getResultTimestamp().longValue());
/* 257 */     argStatement.setLong(4, id.getResultItemSequence().longValue());
/* 258 */     return argStatement;
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 262 */     XunitResultItemId id = new XunitResultItemId();
/* 263 */     id.setOrganizationId(this._organizationId);
/* 264 */     id.setHostname(this._hostname);
/* 265 */     id.setResultTimestamp(this._resultTimestamp);
/* 266 */     id.setResultItemSequence(this._resultItemSequence);
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


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\_test\impl\XunitResultItemDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */