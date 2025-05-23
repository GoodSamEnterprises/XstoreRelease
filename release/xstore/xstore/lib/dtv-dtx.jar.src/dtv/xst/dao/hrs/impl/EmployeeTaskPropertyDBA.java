/*     */ package dtv.xst.dao.hrs.impl;
/*     */ 
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.impl.jdbc.IFiller;
/*     */ import dtv.data2.access.impl.jdbc.IJDBCTableAdapter;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.hrs.EmployeeTaskPropertyId;
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
/*     */ public class EmployeeTaskPropertyDBA
/*     */   implements IJDBCTableAdapter
/*     */ {
/*     */   private static final long serialVersionUID = -201327512L;
/*     */   private Long _organizationId;
/*     */   private Long _retailLocationId;
/*     */   private Long _taskId;
/*     */   private String _propertyCode;
/*     */   private String _type;
/*     */   private String _stringValue;
/*     */   private Date _dateValue;
/*     */   private BigDecimal _decimalValue;
/*     */   private Date _createDate;
/*     */   private String _createUserId;
/*     */   private Date _updateDate;
/*     */   private String _updateUserId;
/*     */   private static final String SELECT_OBJECT = "SELECT t.organization_id, t.rtl_loc_id, t.task_id, t.property_code, t.type, t.string_value, t.date_value, t.decimal_value, t.create_date, t.create_user_id, t.update_date, t.update_user_id FROM hrs_employee_task_p t";
/*     */   private static final String SELECT_WHERE_OBJECT = " WHERE organization_id = ?  AND rtl_loc_id = ?  AND task_id = ?  AND property_code = ?  ";
/*     */   
/*     */   public String getSelect() {
/*  41 */     return getSelectImpl();
/*     */   }
/*     */   
/*     */   private String getSelectImpl() {
/*  45 */     return "SELECT t.organization_id, t.rtl_loc_id, t.task_id, t.property_code, t.type, t.string_value, t.date_value, t.decimal_value, t.create_date, t.create_user_id, t.update_date, t.update_user_id FROM hrs_employee_task_p t";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectWhere() {
/*  51 */     return " WHERE organization_id = ?  AND rtl_loc_id = ?  AND task_id = ?  AND property_code = ?  ";
/*     */   }
/*     */   
/*  54 */   private static final String[] INSERT_OBJECT = new String[] { "INSERT INTO hrs_employee_task_p(organization_id, rtl_loc_id, task_id, property_code, type, string_value, date_value, decimal_value, create_date, create_user_id, update_date, update_user_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" };
/*     */   
/*     */   public String[] getInsert() {
/*  57 */     return INSERT_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getInsertParameters() {
/*  61 */     Object[][] insertParameterObject = { { this._organizationId, this._retailLocationId, this._taskId, this._propertyCode, this._type, this._stringValue, this._dateValue, this._decimalValue, this._createDate, this._createUserId, this._updateDate, this._updateUserId } };
/*  62 */     return insertParameterObject;
/*     */   }
/*     */   
/*  65 */   private static final int[][] INSERT_PARAMETER_TYPES_OBJECT = new int[][] { { -5, -5, -5, 12, 12, 12, 91, 3, 91, 12, 91, 12 } };
/*     */   
/*     */   public int[][] getInsertParameterTypes() {
/*  68 */     return INSERT_PARAMETER_TYPES_OBJECT;
/*     */   }
/*     */   
/*  71 */   private static final String[] UPDATE_OBJECT = new String[] { "UPDATE hrs_employee_task_p SET type = ?, string_value = ?, date_value = ?, decimal_value = ?, update_date = ?, update_user_id = ?" };
/*     */   
/*     */   public String[] getUpdate() {
/*  74 */     return UPDATE_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getUpdateParameters() {
/*  78 */     Object[][] updateParameterObject = { { this._type, this._stringValue, this._dateValue, this._decimalValue, this._updateDate, this._updateUserId } };
/*  79 */     return updateParameterObject;
/*     */   }
/*     */   
/*  82 */   private static final int[][] UPDATE_PARAMETER_TYPE_OBJECT = new int[][] { { 12, 12, 91, 3, 91, 12 } };
/*     */   public int[][] getUpdateParameterTypes() {
/*  84 */     return UPDATE_PARAMETER_TYPE_OBJECT;
/*     */   }
/*     */   
/*  87 */   private static final String[] DELETE_OBJECT = new String[] { "DELETE FROM hrs_employee_task_p" }; private static final String WHERE_OBJECT = " WHERE organization_id = ?  AND rtl_loc_id = ?  AND task_id = ?  AND property_code = ?  ";
/*     */   
/*     */   public String[] getDelete() {
/*  90 */     return DELETE_OBJECT;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWhere() {
/*  96 */     return " WHERE organization_id = ?  AND rtl_loc_id = ?  AND task_id = ?  AND property_code = ?  ";
/*     */   }
/*     */   public Object[] getWhereParameters() {
/*  99 */     return new Object[] { this._organizationId, this._retailLocationId, this._taskId, this._propertyCode };
/*     */   }
/*     */   
/* 102 */   private static final int[] WHERE_PARAMETER_OBJECT = new int[] { -5, -5, -5, 12 };
/*     */   
/*     */   public int[] getWhereParameterTypes() {
/* 105 */     return WHERE_PARAMETER_OBJECT;
/*     */   }
/*     */   public String getTableName() {
/* 108 */     return "hrs_employee_task_p";
/*     */   }
/*     */   
/*     */   public IFiller getFiller() {
/* 112 */     return getFillerImpl();
/*     */   }
/*     */   
/*     */   private IFiller getFillerImpl() {
/* 116 */     return new EmployeeTaskPropertyFiller(this);
/*     */   }
/*     */   
/*     */   private static class EmployeeTaskPropertyFiller
/*     */     implements IFiller {
/*     */     private EmployeeTaskPropertyDBA _parent;
/*     */     
/*     */     public EmployeeTaskPropertyFiller(EmployeeTaskPropertyDBA argParent) {
/* 124 */       this._parent = argParent;
/*     */     }
/*     */ 
/*     */     
/*     */     public void fill(ResultSet argResultSet) throws SQLException {
/* 129 */       long primitiveResult = argResultSet.getLong(1);
/* 130 */       if (primitiveResult != 0L || argResultSet.getObject(1) != null) {
/* 131 */         this._parent._organizationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 137 */       primitiveResult = argResultSet.getLong(2);
/* 138 */       if (primitiveResult != 0L || argResultSet.getObject(2) != null) {
/* 139 */         this._parent._retailLocationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 145 */       primitiveResult = argResultSet.getLong(3);
/* 146 */       if (primitiveResult != 0L || argResultSet.getObject(3) != null) {
/* 147 */         this._parent._taskId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */       
/* 151 */       this._parent._propertyCode = argResultSet.getString(4);
/* 152 */       this._parent._type = argResultSet.getString(5);
/* 153 */       this._parent._stringValue = argResultSet.getString(6);
/*     */       
/* 155 */       Timestamp t7 = argResultSet.getTimestamp(7);
/* 156 */       if (t7 != null) {
/* 157 */         this._parent._dateValue = (Date)new DtvDate(t7.getTime());
/*     */       } else {
/*     */         
/* 160 */         this._parent._dateValue = null;
/*     */       } 
/*     */       
/* 163 */       this._parent._decimalValue = argResultSet.getBigDecimal(8);
/*     */       
/* 165 */       Timestamp t9 = argResultSet.getTimestamp(9);
/* 166 */       if (t9 != null) {
/* 167 */         this._parent._createDate = (Date)new DtvDate(t9.getTime());
/*     */       } else {
/*     */         
/* 170 */         this._parent._createDate = null;
/*     */       } 
/*     */       
/* 173 */       this._parent._createUserId = argResultSet.getString(10);
/*     */       
/* 175 */       Timestamp t11 = argResultSet.getTimestamp(11);
/* 176 */       if (t11 != null) {
/* 177 */         this._parent._updateDate = (Date)new DtvDate(t11.getTime());
/*     */       } else {
/*     */         
/* 180 */         this._parent._updateDate = null;
/*     */       } 
/*     */       
/* 183 */       this._parent._updateUserId = argResultSet.getString(12);
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDAO(IDataAccessObject argDAO) {
/* 188 */     argDAO.suppressStateChanges(true);
/* 189 */     EmployeeTaskPropertyDAO dao = (EmployeeTaskPropertyDAO)argDAO;
/* 190 */     dao.setOrganizationId(this._organizationId);
/* 191 */     dao.setRetailLocationId(this._retailLocationId);
/* 192 */     dao.setTaskId(this._taskId);
/* 193 */     dao.setPropertyCode(this._propertyCode);
/* 194 */     dao.setType(this._type);
/* 195 */     dao.setStringValue(this._stringValue);
/* 196 */     dao.setDateValue(this._dateValue);
/* 197 */     dao.setDecimalValue(this._decimalValue);
/* 198 */     dao.setCreateDate(this._createDate);
/* 199 */     dao.setCreateUserId(this._createUserId);
/* 200 */     dao.setUpdateDate(this._updateDate);
/* 201 */     dao.setUpdateUserId(this._updateUserId);
/* 202 */     argDAO.suppressStateChanges(false);
/* 203 */     return (IDataAccessObject)dao;
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDefaultDAO() {
/* 207 */     return loadDAO((IDataAccessObject)new EmployeeTaskPropertyDAO());
/*     */   }
/*     */   
/*     */   public void fill(IDataAccessObject argDAO) {
/* 211 */     EmployeeTaskPropertyDAO dao = (EmployeeTaskPropertyDAO)argDAO;
/* 212 */     this._organizationId = dao.getOrganizationId();
/* 213 */     this._retailLocationId = dao.getRetailLocationId();
/* 214 */     this._taskId = dao.getTaskId();
/* 215 */     this._propertyCode = dao.getPropertyCode();
/* 216 */     this._type = dao.getType();
/* 217 */     this._stringValue = dao.getStringValue();
/* 218 */     this._dateValue = dao.getDateValue();
/* 219 */     this._decimalValue = dao.getDecimalValue();
/* 220 */     this._createDate = dao.getCreateDate();
/* 221 */     this._createUserId = dao.getCreateUserId();
/* 222 */     this._updateDate = dao.getUpdateDate();
/* 223 */     this._updateUserId = dao.getUpdateUserId();
/*     */   }
/*     */   
/*     */   public PreparedStatement writeObjectId(IObjectId argId, PreparedStatement argStatement) throws SQLException {
/* 227 */     EmployeeTaskPropertyId id = (EmployeeTaskPropertyId)argId;
/* 228 */     argStatement.setLong(1, id.getOrganizationId().longValue());
/* 229 */     argStatement.setLong(2, id.getRetailLocationId().longValue());
/* 230 */     argStatement.setLong(3, id.getTaskId().longValue());
/* 231 */     argStatement.setString(4, id.getPropertyCode());
/* 232 */     return argStatement;
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 236 */     EmployeeTaskPropertyId id = new EmployeeTaskPropertyId();
/* 237 */     id.setOrganizationId(this._organizationId);
/* 238 */     id.setRetailLocationId(this._retailLocationId);
/* 239 */     id.setTaskId(this._taskId);
/* 240 */     id.setPropertyCode(this._propertyCode);
/* 241 */     return (IObjectId)id;
/*     */   }
/*     */ 
/*     */   
/*     */   public void fill(IJDBCTableAdapter argAdapter) {}
/*     */ 
/*     */   
/*     */   public boolean isExtensible() {
/* 249 */     return false;
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 253 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\hrs\impl\EmployeeTaskPropertyDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */