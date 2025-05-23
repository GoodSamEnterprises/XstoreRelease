/*     */ package dtv.xst.dao.loc.impl;
/*     */ 
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.impl.jdbc.IFiller;
/*     */ import dtv.data2.access.impl.jdbc.IJDBCTableAdapter;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.loc.StateJournalId;
/*     */ import java.math.BigDecimal;
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
/*     */ public class StateJournalDBA
/*     */   implements IJDBCTableAdapter
/*     */ {
/*     */   private static final long serialVersionUID = -1081884282L;
/*     */   private Long _organizationId;
/*     */   private Long _retailLocationId;
/*     */   private Long _workstationId;
/*     */   private String _statusTypcode;
/*     */   private String _stateJournalId;
/*     */   private Date _createDate;
/*     */   private String _createUserId;
/*     */   private Date _updateDate;
/*     */   private String _updateUserId;
/*     */   private Date _dateValue;
/*     */   private String _stringValue;
/*     */   private BigDecimal _decimalValue;
/*     */   private Date _timeStamp;
/*     */   private static final String SELECT_OBJECT = "SELECT t.organization_id, t.rtl_loc_id, t.wkstn_id, t.status_typcode, t.state_journal_id, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.date_value, t.string_value, t.decimal_value, t.time_stamp FROM loc_state_journal t";
/*     */   private static final String SELECT_WHERE_OBJECT = " WHERE organization_id = ?  AND rtl_loc_id = ?  AND wkstn_id = ?  AND status_typcode = ?  AND state_journal_id = ?  ";
/*     */   
/*     */   public String getSelect() {
/*  42 */     return getSelectImpl();
/*     */   }
/*     */   
/*     */   private String getSelectImpl() {
/*  46 */     return "SELECT t.organization_id, t.rtl_loc_id, t.wkstn_id, t.status_typcode, t.state_journal_id, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.date_value, t.string_value, t.decimal_value, t.time_stamp FROM loc_state_journal t";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectWhere() {
/*  52 */     return " WHERE organization_id = ?  AND rtl_loc_id = ?  AND wkstn_id = ?  AND status_typcode = ?  AND state_journal_id = ?  ";
/*     */   }
/*     */   
/*  55 */   private static final String[] INSERT_OBJECT = new String[] { "INSERT INTO loc_state_journal(organization_id, rtl_loc_id, wkstn_id, status_typcode, state_journal_id, create_date, create_user_id, update_date, update_user_id, date_value, string_value, decimal_value, time_stamp) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" };
/*     */   
/*     */   public String[] getInsert() {
/*  58 */     return INSERT_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getInsertParameters() {
/*  62 */     Object[][] insertParameterObject = { { this._organizationId, this._retailLocationId, this._workstationId, this._statusTypcode, this._stateJournalId, this._createDate, this._createUserId, this._updateDate, this._updateUserId, this._dateValue, this._stringValue, this._decimalValue, this._timeStamp } };
/*  63 */     return insertParameterObject;
/*     */   }
/*     */   
/*  66 */   private static final int[][] INSERT_PARAMETER_TYPES_OBJECT = new int[][] { { -5, -5, -5, 12, 12, 91, 12, 91, 12, 91, 12, 3, 91 } };
/*     */   
/*     */   public int[][] getInsertParameterTypes() {
/*  69 */     return INSERT_PARAMETER_TYPES_OBJECT;
/*     */   }
/*     */   
/*  72 */   private static final String[] UPDATE_OBJECT = new String[] { "UPDATE loc_state_journal SET update_date = ?, update_user_id = ?, date_value = ?, string_value = ?, decimal_value = ?, time_stamp = ?" };
/*     */   
/*     */   public String[] getUpdate() {
/*  75 */     return UPDATE_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getUpdateParameters() {
/*  79 */     Object[][] updateParameterObject = { { this._updateDate, this._updateUserId, this._dateValue, this._stringValue, this._decimalValue, this._timeStamp } };
/*  80 */     return updateParameterObject;
/*     */   }
/*     */   
/*  83 */   private static final int[][] UPDATE_PARAMETER_TYPE_OBJECT = new int[][] { { 91, 12, 91, 12, 3, 91 } };
/*     */   public int[][] getUpdateParameterTypes() {
/*  85 */     return UPDATE_PARAMETER_TYPE_OBJECT;
/*     */   }
/*     */   
/*  88 */   private static final String[] DELETE_OBJECT = new String[] { "DELETE FROM loc_state_journal" }; private static final String WHERE_OBJECT = " WHERE organization_id = ?  AND rtl_loc_id = ?  AND wkstn_id = ?  AND status_typcode = ?  AND state_journal_id = ?  ";
/*     */   
/*     */   public String[] getDelete() {
/*  91 */     return DELETE_OBJECT;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWhere() {
/*  97 */     return " WHERE organization_id = ?  AND rtl_loc_id = ?  AND wkstn_id = ?  AND status_typcode = ?  AND state_journal_id = ?  ";
/*     */   }
/*     */   public Object[] getWhereParameters() {
/* 100 */     return new Object[] { this._organizationId, this._retailLocationId, this._workstationId, this._statusTypcode, this._stateJournalId };
/*     */   }
/*     */   
/* 103 */   private static final int[] WHERE_PARAMETER_OBJECT = new int[] { -5, -5, -5, 12, 12 };
/*     */   
/*     */   public int[] getWhereParameterTypes() {
/* 106 */     return WHERE_PARAMETER_OBJECT;
/*     */   }
/*     */   public String getTableName() {
/* 109 */     return "loc_state_journal";
/*     */   }
/*     */   
/*     */   public IFiller getFiller() {
/* 113 */     return getFillerImpl();
/*     */   }
/*     */   
/*     */   private IFiller getFillerImpl() {
/* 117 */     return new StateJournalFiller(this);
/*     */   }
/*     */   
/*     */   private static class StateJournalFiller
/*     */     implements IFiller {
/*     */     private StateJournalDBA _parent;
/*     */     
/*     */     public StateJournalFiller(StateJournalDBA argParent) {
/* 125 */       this._parent = argParent;
/*     */     }
/*     */ 
/*     */     
/*     */     public void fill(ResultSet argResultSet) throws SQLException {
/* 130 */       long primitiveResult = argResultSet.getLong(1);
/* 131 */       if (primitiveResult != 0L || argResultSet.getObject(1) != null) {
/* 132 */         this._parent._organizationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 138 */       primitiveResult = argResultSet.getLong(2);
/* 139 */       if (primitiveResult != 0L || argResultSet.getObject(2) != null) {
/* 140 */         this._parent._retailLocationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 146 */       primitiveResult = argResultSet.getLong(3);
/* 147 */       if (primitiveResult != 0L || argResultSet.getObject(3) != null) {
/* 148 */         this._parent._workstationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */       
/* 152 */       this._parent._statusTypcode = argResultSet.getString(4);
/* 153 */       this._parent._stateJournalId = argResultSet.getString(5);
/*     */       
/* 155 */       Timestamp t6 = argResultSet.getTimestamp(6);
/* 156 */       if (t6 != null) {
/* 157 */         this._parent._createDate = (Date)new DtvDate(t6.getTime());
/*     */       } else {
/*     */         
/* 160 */         this._parent._createDate = null;
/*     */       } 
/*     */       
/* 163 */       this._parent._createUserId = argResultSet.getString(7);
/*     */       
/* 165 */       Timestamp t8 = argResultSet.getTimestamp(8);
/* 166 */       if (t8 != null) {
/* 167 */         this._parent._updateDate = (Date)new DtvDate(t8.getTime());
/*     */       } else {
/*     */         
/* 170 */         this._parent._updateDate = null;
/*     */       } 
/*     */       
/* 173 */       this._parent._updateUserId = argResultSet.getString(9);
/*     */       
/* 175 */       Timestamp t10 = argResultSet.getTimestamp(10);
/* 176 */       if (t10 != null) {
/* 177 */         this._parent._dateValue = (Date)new DtvDate(t10.getTime());
/*     */       } else {
/*     */         
/* 180 */         this._parent._dateValue = null;
/*     */       } 
/*     */       
/* 183 */       this._parent._stringValue = argResultSet.getString(11);
/* 184 */       this._parent._decimalValue = argResultSet.getBigDecimal(12);
/*     */       
/* 186 */       Timestamp t13 = argResultSet.getTimestamp(13);
/* 187 */       if (t13 != null) {
/* 188 */         this._parent._timeStamp = (Date)new DtvDate(t13.getTime());
/*     */       } else {
/*     */         
/* 191 */         this._parent._timeStamp = null;
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public IDataAccessObject loadDAO(IDataAccessObject argDAO) {
/* 198 */     argDAO.suppressStateChanges(true);
/* 199 */     StateJournalDAO dao = (StateJournalDAO)argDAO;
/* 200 */     dao.setOrganizationId(this._organizationId);
/* 201 */     dao.setRetailLocationId(this._retailLocationId);
/* 202 */     dao.setWorkstationId(this._workstationId);
/* 203 */     dao.setStatusTypcode(this._statusTypcode);
/* 204 */     dao.setStateJournalId(this._stateJournalId);
/* 205 */     dao.setCreateDate(this._createDate);
/* 206 */     dao.setCreateUserId(this._createUserId);
/* 207 */     dao.setUpdateDate(this._updateDate);
/* 208 */     dao.setUpdateUserId(this._updateUserId);
/* 209 */     dao.setDateValue(this._dateValue);
/* 210 */     dao.setStringValue(this._stringValue);
/* 211 */     dao.setDecimalValue(this._decimalValue);
/* 212 */     dao.setTimeStamp(this._timeStamp);
/* 213 */     argDAO.suppressStateChanges(false);
/* 214 */     return (IDataAccessObject)dao;
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDefaultDAO() {
/* 218 */     return loadDAO((IDataAccessObject)new StateJournalDAO());
/*     */   }
/*     */   
/*     */   public void fill(IDataAccessObject argDAO) {
/* 222 */     StateJournalDAO dao = (StateJournalDAO)argDAO;
/* 223 */     this._organizationId = dao.getOrganizationId();
/* 224 */     this._retailLocationId = dao.getRetailLocationId();
/* 225 */     this._workstationId = dao.getWorkstationId();
/* 226 */     this._statusTypcode = dao.getStatusTypcode();
/* 227 */     this._stateJournalId = dao.getStateJournalId();
/* 228 */     this._createDate = dao.getCreateDate();
/* 229 */     this._createUserId = dao.getCreateUserId();
/* 230 */     this._updateDate = dao.getUpdateDate();
/* 231 */     this._updateUserId = dao.getUpdateUserId();
/* 232 */     this._dateValue = dao.getDateValue();
/* 233 */     this._stringValue = dao.getStringValue();
/* 234 */     this._decimalValue = dao.getDecimalValue();
/* 235 */     this._timeStamp = dao.getTimeStamp();
/*     */   }
/*     */   
/*     */   public PreparedStatement writeObjectId(IObjectId argId, PreparedStatement argStatement) throws SQLException {
/* 239 */     StateJournalId id = (StateJournalId)argId;
/* 240 */     argStatement.setLong(1, id.getOrganizationId().longValue());
/* 241 */     argStatement.setLong(2, id.getRetailLocationId().longValue());
/* 242 */     argStatement.setLong(3, id.getWorkstationId().longValue());
/* 243 */     argStatement.setString(4, id.getStatusTypcode());
/* 244 */     argStatement.setString(5, id.getStateJournalId());
/* 245 */     return argStatement;
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 249 */     StateJournalId id = new StateJournalId();
/* 250 */     id.setOrganizationId(this._organizationId);
/* 251 */     id.setRetailLocationId(this._retailLocationId);
/* 252 */     id.setWorkstationId(this._workstationId);
/* 253 */     id.setStatusTypcode(this._statusTypcode);
/* 254 */     id.setStateJournalId(this._stateJournalId);
/* 255 */     return (IObjectId)id;
/*     */   }
/*     */ 
/*     */   
/*     */   public void fill(IJDBCTableAdapter argAdapter) {}
/*     */ 
/*     */   
/*     */   public boolean isExtensible() {
/* 263 */     return false;
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 267 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\loc\impl\StateJournalDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */