/*     */ package dtv.xst.dao.hrs.impl;
/*     */ 
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.impl.jdbc.IFiller;
/*     */ import dtv.data2.access.impl.jdbc.IJDBCTableAdapter;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.hrs.EmployeeTaskNotePropertyId;
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
/*     */ public class EmployeeTaskNotePropertyDBA
/*     */   implements IJDBCTableAdapter
/*     */ {
/*     */   private static final long serialVersionUID = -881296134L;
/*     */   private Long _organizationId;
/*     */   private Long _retailLocationId;
/*     */   private Long _taskId;
/*     */   private Long _noteSequence;
/*     */   private String _propertyCode;
/*     */   private String _type;
/*     */   private String _stringValue;
/*     */   private Date _dateValue;
/*     */   private BigDecimal _decimalValue;
/*     */   private Date _createDate;
/*     */   private String _createUserId;
/*     */   private Date _updateDate;
/*     */   private String _updateUserId;
/*     */   private static final String SELECT_OBJECT = "SELECT t.organization_id, t.rtl_loc_id, t.task_id, t.note_seq, t.property_code, t.type, t.string_value, t.date_value, t.decimal_value, t.create_date, t.create_user_id, t.update_date, t.update_user_id FROM hrs_employee_task_notes_p t";
/*     */   private static final String SELECT_WHERE_OBJECT = " WHERE organization_id = ?  AND rtl_loc_id = ?  AND task_id = ?  AND note_seq = ?  AND property_code = ?  ";
/*     */   
/*     */   public String getSelect() {
/*  42 */     return getSelectImpl();
/*     */   }
/*     */   
/*     */   private String getSelectImpl() {
/*  46 */     return "SELECT t.organization_id, t.rtl_loc_id, t.task_id, t.note_seq, t.property_code, t.type, t.string_value, t.date_value, t.decimal_value, t.create_date, t.create_user_id, t.update_date, t.update_user_id FROM hrs_employee_task_notes_p t";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectWhere() {
/*  52 */     return " WHERE organization_id = ?  AND rtl_loc_id = ?  AND task_id = ?  AND note_seq = ?  AND property_code = ?  ";
/*     */   }
/*     */   
/*  55 */   private static final String[] INSERT_OBJECT = new String[] { "INSERT INTO hrs_employee_task_notes_p(organization_id, rtl_loc_id, task_id, note_seq, property_code, type, string_value, date_value, decimal_value, create_date, create_user_id, update_date, update_user_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" };
/*     */   
/*     */   public String[] getInsert() {
/*  58 */     return INSERT_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getInsertParameters() {
/*  62 */     Object[][] insertParameterObject = { { this._organizationId, this._retailLocationId, this._taskId, this._noteSequence, this._propertyCode, this._type, this._stringValue, this._dateValue, this._decimalValue, this._createDate, this._createUserId, this._updateDate, this._updateUserId } };
/*  63 */     return insertParameterObject;
/*     */   }
/*     */   
/*  66 */   private static final int[][] INSERT_PARAMETER_TYPES_OBJECT = new int[][] { { -5, -5, -5, -5, 12, 12, 12, 91, 3, 91, 12, 91, 12 } };
/*     */   
/*     */   public int[][] getInsertParameterTypes() {
/*  69 */     return INSERT_PARAMETER_TYPES_OBJECT;
/*     */   }
/*     */   
/*  72 */   private static final String[] UPDATE_OBJECT = new String[] { "UPDATE hrs_employee_task_notes_p SET type = ?, string_value = ?, date_value = ?, decimal_value = ?, update_date = ?, update_user_id = ?" };
/*     */   
/*     */   public String[] getUpdate() {
/*  75 */     return UPDATE_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getUpdateParameters() {
/*  79 */     Object[][] updateParameterObject = { { this._type, this._stringValue, this._dateValue, this._decimalValue, this._updateDate, this._updateUserId } };
/*  80 */     return updateParameterObject;
/*     */   }
/*     */   
/*  83 */   private static final int[][] UPDATE_PARAMETER_TYPE_OBJECT = new int[][] { { 12, 12, 91, 3, 91, 12 } };
/*     */   public int[][] getUpdateParameterTypes() {
/*  85 */     return UPDATE_PARAMETER_TYPE_OBJECT;
/*     */   }
/*     */   
/*  88 */   private static final String[] DELETE_OBJECT = new String[] { "DELETE FROM hrs_employee_task_notes_p" }; private static final String WHERE_OBJECT = " WHERE organization_id = ?  AND rtl_loc_id = ?  AND task_id = ?  AND note_seq = ?  AND property_code = ?  ";
/*     */   
/*     */   public String[] getDelete() {
/*  91 */     return DELETE_OBJECT;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWhere() {
/*  97 */     return " WHERE organization_id = ?  AND rtl_loc_id = ?  AND task_id = ?  AND note_seq = ?  AND property_code = ?  ";
/*     */   }
/*     */   public Object[] getWhereParameters() {
/* 100 */     return new Object[] { this._organizationId, this._retailLocationId, this._taskId, this._noteSequence, this._propertyCode };
/*     */   }
/*     */   
/* 103 */   private static final int[] WHERE_PARAMETER_OBJECT = new int[] { -5, -5, -5, -5, 12 };
/*     */   
/*     */   public int[] getWhereParameterTypes() {
/* 106 */     return WHERE_PARAMETER_OBJECT;
/*     */   }
/*     */   public String getTableName() {
/* 109 */     return "hrs_employee_task_notes_p";
/*     */   }
/*     */   
/*     */   public IFiller getFiller() {
/* 113 */     return getFillerImpl();
/*     */   }
/*     */   
/*     */   private IFiller getFillerImpl() {
/* 117 */     return new EmployeeTaskNotePropertyFiller(this);
/*     */   }
/*     */   
/*     */   private static class EmployeeTaskNotePropertyFiller
/*     */     implements IFiller {
/*     */     private EmployeeTaskNotePropertyDBA _parent;
/*     */     
/*     */     public EmployeeTaskNotePropertyFiller(EmployeeTaskNotePropertyDBA argParent) {
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
/* 148 */         this._parent._taskId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 154 */       primitiveResult = argResultSet.getLong(4);
/* 155 */       if (primitiveResult != 0L || argResultSet.getObject(4) != null) {
/* 156 */         this._parent._noteSequence = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */       
/* 160 */       this._parent._propertyCode = argResultSet.getString(5);
/* 161 */       this._parent._type = argResultSet.getString(6);
/* 162 */       this._parent._stringValue = argResultSet.getString(7);
/*     */       
/* 164 */       Timestamp t8 = argResultSet.getTimestamp(8);
/* 165 */       if (t8 != null) {
/* 166 */         this._parent._dateValue = (Date)new DtvDate(t8.getTime());
/*     */       } else {
/*     */         
/* 169 */         this._parent._dateValue = null;
/*     */       } 
/*     */       
/* 172 */       this._parent._decimalValue = argResultSet.getBigDecimal(9);
/*     */       
/* 174 */       Timestamp t10 = argResultSet.getTimestamp(10);
/* 175 */       if (t10 != null) {
/* 176 */         this._parent._createDate = (Date)new DtvDate(t10.getTime());
/*     */       } else {
/*     */         
/* 179 */         this._parent._createDate = null;
/*     */       } 
/*     */       
/* 182 */       this._parent._createUserId = argResultSet.getString(11);
/*     */       
/* 184 */       Timestamp t12 = argResultSet.getTimestamp(12);
/* 185 */       if (t12 != null) {
/* 186 */         this._parent._updateDate = (Date)new DtvDate(t12.getTime());
/*     */       } else {
/*     */         
/* 189 */         this._parent._updateDate = null;
/*     */       } 
/*     */       
/* 192 */       this._parent._updateUserId = argResultSet.getString(13);
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDAO(IDataAccessObject argDAO) {
/* 197 */     argDAO.suppressStateChanges(true);
/* 198 */     EmployeeTaskNotePropertyDAO dao = (EmployeeTaskNotePropertyDAO)argDAO;
/* 199 */     dao.setOrganizationId(this._organizationId);
/* 200 */     dao.setRetailLocationId(this._retailLocationId);
/* 201 */     dao.setTaskId(this._taskId);
/* 202 */     dao.setNoteSequence(this._noteSequence);
/* 203 */     dao.setPropertyCode(this._propertyCode);
/* 204 */     dao.setType(this._type);
/* 205 */     dao.setStringValue(this._stringValue);
/* 206 */     dao.setDateValue(this._dateValue);
/* 207 */     dao.setDecimalValue(this._decimalValue);
/* 208 */     dao.setCreateDate(this._createDate);
/* 209 */     dao.setCreateUserId(this._createUserId);
/* 210 */     dao.setUpdateDate(this._updateDate);
/* 211 */     dao.setUpdateUserId(this._updateUserId);
/* 212 */     argDAO.suppressStateChanges(false);
/* 213 */     return (IDataAccessObject)dao;
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDefaultDAO() {
/* 217 */     return loadDAO((IDataAccessObject)new EmployeeTaskNotePropertyDAO());
/*     */   }
/*     */   
/*     */   public void fill(IDataAccessObject argDAO) {
/* 221 */     EmployeeTaskNotePropertyDAO dao = (EmployeeTaskNotePropertyDAO)argDAO;
/* 222 */     this._organizationId = dao.getOrganizationId();
/* 223 */     this._retailLocationId = dao.getRetailLocationId();
/* 224 */     this._taskId = dao.getTaskId();
/* 225 */     this._noteSequence = dao.getNoteSequence();
/* 226 */     this._propertyCode = dao.getPropertyCode();
/* 227 */     this._type = dao.getType();
/* 228 */     this._stringValue = dao.getStringValue();
/* 229 */     this._dateValue = dao.getDateValue();
/* 230 */     this._decimalValue = dao.getDecimalValue();
/* 231 */     this._createDate = dao.getCreateDate();
/* 232 */     this._createUserId = dao.getCreateUserId();
/* 233 */     this._updateDate = dao.getUpdateDate();
/* 234 */     this._updateUserId = dao.getUpdateUserId();
/*     */   }
/*     */   
/*     */   public PreparedStatement writeObjectId(IObjectId argId, PreparedStatement argStatement) throws SQLException {
/* 238 */     EmployeeTaskNotePropertyId id = (EmployeeTaskNotePropertyId)argId;
/* 239 */     argStatement.setLong(1, id.getOrganizationId().longValue());
/* 240 */     argStatement.setLong(2, id.getRetailLocationId().longValue());
/* 241 */     argStatement.setLong(3, id.getTaskId().longValue());
/* 242 */     argStatement.setLong(4, id.getNoteSequence().longValue());
/* 243 */     argStatement.setString(5, id.getPropertyCode());
/* 244 */     return argStatement;
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 248 */     EmployeeTaskNotePropertyId id = new EmployeeTaskNotePropertyId();
/* 249 */     id.setOrganizationId(this._organizationId);
/* 250 */     id.setRetailLocationId(this._retailLocationId);
/* 251 */     id.setTaskId(this._taskId);
/* 252 */     id.setNoteSequence(this._noteSequence);
/* 253 */     id.setPropertyCode(this._propertyCode);
/* 254 */     return (IObjectId)id;
/*     */   }
/*     */ 
/*     */   
/*     */   public void fill(IJDBCTableAdapter argAdapter) {}
/*     */ 
/*     */   
/*     */   public boolean isExtensible() {
/* 262 */     return false;
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 266 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\hrs\impl\EmployeeTaskNotePropertyDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */