/*     */ package dtv.xst.dao.ctl.impl;
/*     */ 
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.impl.jdbc.IFiller;
/*     */ import dtv.data2.access.impl.jdbc.IJDBCTableAdapter;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.ctl.DataLoaderSummaryId;
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
/*     */ public class DataLoaderSummaryDBA
/*     */   implements IJDBCTableAdapter
/*     */ {
/*     */   private static final long serialVersionUID = -471652247L;
/*     */   private Long _organizationId;
/*     */   private String _fileName;
/*     */   private Long _runTime;
/*     */   private Date _createDate;
/*     */   private String _createUserId;
/*     */   private Date _updateDate;
/*     */   private String _updateUserId;
/*     */   private Boolean _success;
/*     */   private Integer _successfulRows;
/*     */   private Integer _failedRows;
/*     */   private static final String SELECT_OBJECT = "SELECT t.organization_id, t.file_name, t.run_timestamp, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.success_flag, t.successful_rows, t.failed_rows FROM ctl_dataloader_summary t";
/*     */   private static final String SELECT_WHERE_OBJECT = " WHERE organization_id = ?  AND file_name = ?  AND run_timestamp = ?  ";
/*     */   
/*     */   public String getSelect() {
/*  39 */     return getSelectImpl();
/*     */   }
/*     */   
/*     */   private String getSelectImpl() {
/*  43 */     return "SELECT t.organization_id, t.file_name, t.run_timestamp, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.success_flag, t.successful_rows, t.failed_rows FROM ctl_dataloader_summary t";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectWhere() {
/*  49 */     return " WHERE organization_id = ?  AND file_name = ?  AND run_timestamp = ?  ";
/*     */   }
/*     */   
/*  52 */   private static final String[] INSERT_OBJECT = new String[] { "INSERT INTO ctl_dataloader_summary(organization_id, file_name, run_timestamp, create_date, create_user_id, update_date, update_user_id, success_flag, successful_rows, failed_rows) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" };
/*     */   
/*     */   public String[] getInsert() {
/*  55 */     return INSERT_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getInsertParameters() {
/*  59 */     Object[][] insertParameterObject = { { this._organizationId, this._fileName, this._runTime, this._createDate, this._createUserId, this._updateDate, this._updateUserId, this._success, this._successfulRows, this._failedRows } };
/*  60 */     return insertParameterObject;
/*     */   }
/*     */   
/*  63 */   private static final int[][] INSERT_PARAMETER_TYPES_OBJECT = new int[][] { { -5, 12, -5, 91, 12, 91, 12, -7, 4, 4 } };
/*     */   
/*     */   public int[][] getInsertParameterTypes() {
/*  66 */     return INSERT_PARAMETER_TYPES_OBJECT;
/*     */   }
/*     */   
/*  69 */   private static final String[] UPDATE_OBJECT = new String[] { "UPDATE ctl_dataloader_summary SET update_date = ?, update_user_id = ?, success_flag = ?, successful_rows = ?, failed_rows = ?" };
/*     */   
/*     */   public String[] getUpdate() {
/*  72 */     return UPDATE_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getUpdateParameters() {
/*  76 */     Object[][] updateParameterObject = { { this._updateDate, this._updateUserId, this._success, this._successfulRows, this._failedRows } };
/*  77 */     return updateParameterObject;
/*     */   }
/*     */   
/*  80 */   private static final int[][] UPDATE_PARAMETER_TYPE_OBJECT = new int[][] { { 91, 12, -7, 4, 4 } };
/*     */   public int[][] getUpdateParameterTypes() {
/*  82 */     return UPDATE_PARAMETER_TYPE_OBJECT;
/*     */   }
/*     */   
/*  85 */   private static final String[] DELETE_OBJECT = new String[] { "DELETE FROM ctl_dataloader_summary" }; private static final String WHERE_OBJECT = " WHERE organization_id = ?  AND file_name = ?  AND run_timestamp = ?  ";
/*     */   
/*     */   public String[] getDelete() {
/*  88 */     return DELETE_OBJECT;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWhere() {
/*  94 */     return " WHERE organization_id = ?  AND file_name = ?  AND run_timestamp = ?  ";
/*     */   }
/*     */   public Object[] getWhereParameters() {
/*  97 */     return new Object[] { this._organizationId, this._fileName, this._runTime };
/*     */   }
/*     */   
/* 100 */   private static final int[] WHERE_PARAMETER_OBJECT = new int[] { -5, 12, -5 };
/*     */   
/*     */   public int[] getWhereParameterTypes() {
/* 103 */     return WHERE_PARAMETER_OBJECT;
/*     */   }
/*     */   public String getTableName() {
/* 106 */     return "ctl_dataloader_summary";
/*     */   }
/*     */   
/*     */   public IFiller getFiller() {
/* 110 */     return getFillerImpl();
/*     */   }
/*     */   
/*     */   private IFiller getFillerImpl() {
/* 114 */     return new DataLoaderSummaryFiller(this);
/*     */   }
/*     */   
/*     */   private static class DataLoaderSummaryFiller
/*     */     implements IFiller {
/*     */     private DataLoaderSummaryDBA _parent;
/*     */     
/*     */     public DataLoaderSummaryFiller(DataLoaderSummaryDBA argParent) {
/* 122 */       this._parent = argParent;
/*     */     }
/*     */ 
/*     */     
/*     */     public void fill(ResultSet argResultSet) throws SQLException {
/* 127 */       long primitiveResult = argResultSet.getLong(1);
/* 128 */       if (primitiveResult != 0L || argResultSet.getObject(1) != null) {
/* 129 */         this._parent._organizationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */       
/* 133 */       this._parent._fileName = argResultSet.getString(2);
/*     */ 
/*     */       
/* 136 */       primitiveResult = argResultSet.getLong(3);
/* 137 */       if (primitiveResult != 0L || argResultSet.getObject(3) != null) {
/* 138 */         this._parent._runTime = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 143 */       Timestamp t4 = argResultSet.getTimestamp(4);
/* 144 */       if (t4 != null) {
/* 145 */         this._parent._createDate = (Date)new DtvDate(t4.getTime());
/*     */       } else {
/*     */         
/* 148 */         this._parent._createDate = null;
/*     */       } 
/*     */       
/* 151 */       this._parent._createUserId = argResultSet.getString(5);
/*     */       
/* 153 */       Timestamp t6 = argResultSet.getTimestamp(6);
/* 154 */       if (t6 != null) {
/* 155 */         this._parent._updateDate = (Date)new DtvDate(t6.getTime());
/*     */       } else {
/*     */         
/* 158 */         this._parent._updateDate = null;
/*     */       } 
/*     */       
/* 161 */       this._parent._updateUserId = argResultSet.getString(7);
/* 162 */       this._parent._success = Boolean.valueOf(argResultSet.getBoolean(8));
/*     */ 
/*     */       
/* 165 */       int i = argResultSet.getInt(9);
/* 166 */       if (i != 0 || argResultSet.getObject(9) != null) {
/* 167 */         this._parent._successfulRows = Integer.valueOf(i);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 173 */       i = argResultSet.getInt(10);
/* 174 */       if (i != 0 || argResultSet.getObject(10) != null) {
/* 175 */         this._parent._failedRows = Integer.valueOf(i);
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IDataAccessObject loadDAO(IDataAccessObject argDAO) {
/* 183 */     argDAO.suppressStateChanges(true);
/* 184 */     DataLoaderSummaryDAO dao = (DataLoaderSummaryDAO)argDAO;
/* 185 */     dao.setOrganizationId(this._organizationId);
/* 186 */     dao.setFileName(this._fileName);
/* 187 */     dao.setRunTime(this._runTime);
/* 188 */     dao.setCreateDate(this._createDate);
/* 189 */     dao.setCreateUserId(this._createUserId);
/* 190 */     dao.setUpdateDate(this._updateDate);
/* 191 */     dao.setUpdateUserId(this._updateUserId);
/* 192 */     dao.setSuccess(this._success);
/* 193 */     dao.setSuccessfulRows(this._successfulRows);
/* 194 */     dao.setFailedRows(this._failedRows);
/* 195 */     argDAO.suppressStateChanges(false);
/* 196 */     return (IDataAccessObject)dao;
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDefaultDAO() {
/* 200 */     return loadDAO((IDataAccessObject)new DataLoaderSummaryDAO());
/*     */   }
/*     */   
/*     */   public void fill(IDataAccessObject argDAO) {
/* 204 */     DataLoaderSummaryDAO dao = (DataLoaderSummaryDAO)argDAO;
/* 205 */     this._organizationId = dao.getOrganizationId();
/* 206 */     this._fileName = dao.getFileName();
/* 207 */     this._runTime = dao.getRunTime();
/* 208 */     this._createDate = dao.getCreateDate();
/* 209 */     this._createUserId = dao.getCreateUserId();
/* 210 */     this._updateDate = dao.getUpdateDate();
/* 211 */     this._updateUserId = dao.getUpdateUserId();
/* 212 */     this._success = (dao.getSuccess() != null) ? dao.getSuccess() : Boolean.valueOf(false);
/* 213 */     this._successfulRows = dao.getSuccessfulRows();
/* 214 */     this._failedRows = dao.getFailedRows();
/*     */   }
/*     */   
/*     */   public PreparedStatement writeObjectId(IObjectId argId, PreparedStatement argStatement) throws SQLException {
/* 218 */     DataLoaderSummaryId id = (DataLoaderSummaryId)argId;
/* 219 */     argStatement.setLong(1, id.getOrganizationId().longValue());
/* 220 */     argStatement.setString(2, id.getFileName());
/* 221 */     argStatement.setLong(3, id.getRunTime().longValue());
/* 222 */     return argStatement;
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 226 */     DataLoaderSummaryId id = new DataLoaderSummaryId();
/* 227 */     id.setOrganizationId(this._organizationId);
/* 228 */     id.setFileName(this._fileName);
/* 229 */     id.setRunTime(this._runTime);
/* 230 */     return (IObjectId)id;
/*     */   }
/*     */ 
/*     */   
/*     */   public void fill(IJDBCTableAdapter argAdapter) {}
/*     */ 
/*     */   
/*     */   public boolean isExtensible() {
/* 238 */     return false;
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 242 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\ctl\impl\DataLoaderSummaryDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */