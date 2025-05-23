/*     */ package dtv.xst.dao.sch.impl;
/*     */ 
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.impl.jdbc.IFiller;
/*     */ import dtv.data2.access.impl.jdbc.IJDBCTableAdapter;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.sch.SchedulePropertyId;
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
/*     */ public class SchedulePropertyDBA
/*     */   implements IJDBCTableAdapter
/*     */ {
/*     */   private static final long serialVersionUID = 578720172L;
/*     */   private Long _organizationId;
/*     */   private String _employeeId;
/*     */   private Date _businessDate;
/*     */   private Long _scheduleSeq;
/*     */   private String _propertyCode;
/*     */   private String _type;
/*     */   private String _stringValue;
/*     */   private Date _dateValue;
/*     */   private BigDecimal _decimalValue;
/*     */   private Date _createDate;
/*     */   private String _createUserId;
/*     */   private Date _updateDate;
/*     */   private String _updateUserId;
/*     */   private static final String SELECT_OBJECT = "SELECT t.organization_id, t.employee_id, t.business_date, t.schedule_seq, t.property_code, t.type, t.string_value, t.date_value, t.decimal_value, t.create_date, t.create_user_id, t.update_date, t.update_user_id FROM sch_schedule_p t";
/*     */   private static final String SELECT_WHERE_OBJECT = " WHERE organization_id = ?  AND employee_id = ?  AND business_date = ?  AND schedule_seq = ?  AND property_code = ?  ";
/*     */   
/*     */   public String getSelect() {
/*  42 */     return getSelectImpl();
/*     */   }
/*     */   
/*     */   private String getSelectImpl() {
/*  46 */     return "SELECT t.organization_id, t.employee_id, t.business_date, t.schedule_seq, t.property_code, t.type, t.string_value, t.date_value, t.decimal_value, t.create_date, t.create_user_id, t.update_date, t.update_user_id FROM sch_schedule_p t";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectWhere() {
/*  52 */     return " WHERE organization_id = ?  AND employee_id = ?  AND business_date = ?  AND schedule_seq = ?  AND property_code = ?  ";
/*     */   }
/*     */   
/*  55 */   private static final String[] INSERT_OBJECT = new String[] { "INSERT INTO sch_schedule_p(organization_id, employee_id, business_date, schedule_seq, property_code, type, string_value, date_value, decimal_value, create_date, create_user_id, update_date, update_user_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" };
/*     */   
/*     */   public String[] getInsert() {
/*  58 */     return INSERT_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getInsertParameters() {
/*  62 */     Object[][] insertParameterObject = { { this._organizationId, this._employeeId, this._businessDate, this._scheduleSeq, this._propertyCode, this._type, this._stringValue, this._dateValue, this._decimalValue, this._createDate, this._createUserId, this._updateDate, this._updateUserId } };
/*  63 */     return insertParameterObject;
/*     */   }
/*     */   
/*  66 */   private static final int[][] INSERT_PARAMETER_TYPES_OBJECT = new int[][] { { -5, 12, 91, -5, 12, 12, 12, 91, 3, 91, 12, 91, 12 } };
/*     */   
/*     */   public int[][] getInsertParameterTypes() {
/*  69 */     return INSERT_PARAMETER_TYPES_OBJECT;
/*     */   }
/*     */   
/*  72 */   private static final String[] UPDATE_OBJECT = new String[] { "UPDATE sch_schedule_p SET type = ?, string_value = ?, date_value = ?, decimal_value = ?, update_date = ?, update_user_id = ?" };
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
/*  88 */   private static final String[] DELETE_OBJECT = new String[] { "DELETE FROM sch_schedule_p" }; private static final String WHERE_OBJECT = " WHERE organization_id = ?  AND employee_id = ?  AND business_date = ?  AND schedule_seq = ?  AND property_code = ?  ";
/*     */   
/*     */   public String[] getDelete() {
/*  91 */     return DELETE_OBJECT;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWhere() {
/*  97 */     return " WHERE organization_id = ?  AND employee_id = ?  AND business_date = ?  AND schedule_seq = ?  AND property_code = ?  ";
/*     */   }
/*     */   public Object[] getWhereParameters() {
/* 100 */     return new Object[] { this._organizationId, this._employeeId, this._businessDate, this._scheduleSeq, this._propertyCode };
/*     */   }
/*     */   
/* 103 */   private static final int[] WHERE_PARAMETER_OBJECT = new int[] { -5, 12, 91, -5, 12 };
/*     */   
/*     */   public int[] getWhereParameterTypes() {
/* 106 */     return WHERE_PARAMETER_OBJECT;
/*     */   }
/*     */   public String getTableName() {
/* 109 */     return "sch_schedule_p";
/*     */   }
/*     */   
/*     */   public IFiller getFiller() {
/* 113 */     return getFillerImpl();
/*     */   }
/*     */   
/*     */   private IFiller getFillerImpl() {
/* 117 */     return new SchedulePropertyFiller(this);
/*     */   }
/*     */   
/*     */   private static class SchedulePropertyFiller
/*     */     implements IFiller {
/*     */     private SchedulePropertyDBA _parent;
/*     */     
/*     */     public SchedulePropertyFiller(SchedulePropertyDBA argParent) {
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
/* 136 */       this._parent._employeeId = argResultSet.getString(2);
/*     */       
/* 138 */       Timestamp t3 = argResultSet.getTimestamp(3);
/* 139 */       if (t3 != null) {
/* 140 */         this._parent._businessDate = (Date)new DtvDate(t3.getTime());
/*     */       } else {
/*     */         
/* 143 */         this._parent._businessDate = null;
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/* 148 */       long l1 = argResultSet.getLong(4);
/* 149 */       if (l1 != 0L || argResultSet.getObject(4) != null) {
/* 150 */         this._parent._scheduleSeq = Long.valueOf(l1);
/*     */       }
/*     */ 
/*     */       
/* 154 */       this._parent._propertyCode = argResultSet.getString(5);
/* 155 */       this._parent._type = argResultSet.getString(6);
/* 156 */       this._parent._stringValue = argResultSet.getString(7);
/*     */       
/* 158 */       Timestamp t8 = argResultSet.getTimestamp(8);
/* 159 */       if (t8 != null) {
/* 160 */         this._parent._dateValue = (Date)new DtvDate(t8.getTime());
/*     */       } else {
/*     */         
/* 163 */         this._parent._dateValue = null;
/*     */       } 
/*     */       
/* 166 */       this._parent._decimalValue = argResultSet.getBigDecimal(9);
/*     */       
/* 168 */       Timestamp t10 = argResultSet.getTimestamp(10);
/* 169 */       if (t10 != null) {
/* 170 */         this._parent._createDate = (Date)new DtvDate(t10.getTime());
/*     */       } else {
/*     */         
/* 173 */         this._parent._createDate = null;
/*     */       } 
/*     */       
/* 176 */       this._parent._createUserId = argResultSet.getString(11);
/*     */       
/* 178 */       Timestamp t12 = argResultSet.getTimestamp(12);
/* 179 */       if (t12 != null) {
/* 180 */         this._parent._updateDate = (Date)new DtvDate(t12.getTime());
/*     */       } else {
/*     */         
/* 183 */         this._parent._updateDate = null;
/*     */       } 
/*     */       
/* 186 */       this._parent._updateUserId = argResultSet.getString(13);
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDAO(IDataAccessObject argDAO) {
/* 191 */     argDAO.suppressStateChanges(true);
/* 192 */     SchedulePropertyDAO dao = (SchedulePropertyDAO)argDAO;
/* 193 */     dao.setOrganizationId(this._organizationId);
/* 194 */     dao.setEmployeeId(this._employeeId);
/* 195 */     dao.setBusinessDate(this._businessDate);
/* 196 */     dao.setScheduleSeq(this._scheduleSeq);
/* 197 */     dao.setPropertyCode(this._propertyCode);
/* 198 */     dao.setType(this._type);
/* 199 */     dao.setStringValue(this._stringValue);
/* 200 */     dao.setDateValue(this._dateValue);
/* 201 */     dao.setDecimalValue(this._decimalValue);
/* 202 */     dao.setCreateDate(this._createDate);
/* 203 */     dao.setCreateUserId(this._createUserId);
/* 204 */     dao.setUpdateDate(this._updateDate);
/* 205 */     dao.setUpdateUserId(this._updateUserId);
/* 206 */     argDAO.suppressStateChanges(false);
/* 207 */     return (IDataAccessObject)dao;
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDefaultDAO() {
/* 211 */     return loadDAO((IDataAccessObject)new SchedulePropertyDAO());
/*     */   }
/*     */   
/*     */   public void fill(IDataAccessObject argDAO) {
/* 215 */     SchedulePropertyDAO dao = (SchedulePropertyDAO)argDAO;
/* 216 */     this._organizationId = dao.getOrganizationId();
/* 217 */     this._employeeId = dao.getEmployeeId();
/* 218 */     this._businessDate = dao.getBusinessDate();
/* 219 */     this._scheduleSeq = dao.getScheduleSeq();
/* 220 */     this._propertyCode = dao.getPropertyCode();
/* 221 */     this._type = dao.getType();
/* 222 */     this._stringValue = dao.getStringValue();
/* 223 */     this._dateValue = dao.getDateValue();
/* 224 */     this._decimalValue = dao.getDecimalValue();
/* 225 */     this._createDate = dao.getCreateDate();
/* 226 */     this._createUserId = dao.getCreateUserId();
/* 227 */     this._updateDate = dao.getUpdateDate();
/* 228 */     this._updateUserId = dao.getUpdateUserId();
/*     */   }
/*     */   
/*     */   public PreparedStatement writeObjectId(IObjectId argId, PreparedStatement argStatement) throws SQLException {
/* 232 */     SchedulePropertyId id = (SchedulePropertyId)argId;
/* 233 */     argStatement.setLong(1, id.getOrganizationId().longValue());
/* 234 */     argStatement.setString(2, id.getEmployeeId());
/* 235 */     argStatement.setTimestamp(3, new Timestamp(id.getBusinessDate().getTime()));
/* 236 */     argStatement.setLong(4, id.getScheduleSeq().longValue());
/* 237 */     argStatement.setString(5, id.getPropertyCode());
/* 238 */     return argStatement;
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 242 */     SchedulePropertyId id = new SchedulePropertyId();
/* 243 */     id.setOrganizationId(this._organizationId);
/* 244 */     id.setEmployeeId(this._employeeId);
/* 245 */     id.setBusinessDate(this._businessDate);
/* 246 */     id.setScheduleSeq(this._scheduleSeq);
/* 247 */     id.setPropertyCode(this._propertyCode);
/* 248 */     return (IObjectId)id;
/*     */   }
/*     */ 
/*     */   
/*     */   public void fill(IJDBCTableAdapter argAdapter) {}
/*     */ 
/*     */   
/*     */   public boolean isExtensible() {
/* 256 */     return false;
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 260 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\sch\impl\SchedulePropertyDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */