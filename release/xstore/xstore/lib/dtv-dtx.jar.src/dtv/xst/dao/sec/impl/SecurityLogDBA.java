/*     */ package dtv.xst.dao.sec.impl;
/*     */ 
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.impl.jdbc.IFiller;
/*     */ import dtv.data2.access.impl.jdbc.IJDBCTableAdapter;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.sec.SecurityLogId;
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
/*     */ public class SecurityLogDBA
/*     */   implements IJDBCTableAdapter
/*     */ {
/*     */   private static final long serialVersionUID = -1077013564L;
/*     */   private Date _createDate;
/*     */   private String _createUserId;
/*     */   private Date _updateDate;
/*     */   private String _updateUserId;
/*     */   private Long _organizationId;
/*     */   private Long _retailLocationId;
/*     */   private Long _workstationId;
/*     */   private Date _businessDate;
/*     */   private Long _transactionSequence;
/*     */   private String _activityType;
/*     */   private Boolean _success;
/*     */   private String _employeeId;
/*     */   private String _overridingEmployeeId;
/*     */   private String _privilegeType;
/*     */   private Date _systemDateTime;
/*     */   private static final String SELECT_OBJECT = "SELECT t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.organization_id, t.rtl_loc_id, t.wkstn_id, t.business_date, t.trans_seq, t.activity_typcode, t.success_flag, t.employee_id, t.overriding_employee_id, t.privilege_type, t.system_datetime FROM sec_activity_log t";
/*     */   private static final String SELECT_WHERE_OBJECT = " ";
/*     */   
/*     */   public String getSelect() {
/*  44 */     return getSelectImpl();
/*     */   }
/*     */   
/*     */   private String getSelectImpl() {
/*  48 */     return "SELECT t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.organization_id, t.rtl_loc_id, t.wkstn_id, t.business_date, t.trans_seq, t.activity_typcode, t.success_flag, t.employee_id, t.overriding_employee_id, t.privilege_type, t.system_datetime FROM sec_activity_log t";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectWhere() {
/*  54 */     return " ";
/*     */   }
/*     */   
/*  57 */   private static final String[] INSERT_OBJECT = new String[] { "INSERT INTO sec_activity_log(create_date, create_user_id, update_date, update_user_id, organization_id, rtl_loc_id, wkstn_id, business_date, trans_seq, activity_typcode, success_flag, employee_id, overriding_employee_id, privilege_type, system_datetime) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" };
/*     */   
/*     */   public String[] getInsert() {
/*  60 */     return INSERT_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getInsertParameters() {
/*  64 */     Object[][] insertParameterObject = { { this._createDate, this._createUserId, this._updateDate, this._updateUserId, this._organizationId, this._retailLocationId, this._workstationId, this._businessDate, this._transactionSequence, this._activityType, this._success, this._employeeId, this._overridingEmployeeId, this._privilegeType, this._systemDateTime } };
/*  65 */     return insertParameterObject;
/*     */   }
/*     */   
/*  68 */   private static final int[][] INSERT_PARAMETER_TYPES_OBJECT = new int[][] { { 91, 12, 91, 12, -5, -5, -5, 91, -5, 12, -7, 12, 12, 12, 91 } };
/*     */   
/*     */   public int[][] getInsertParameterTypes() {
/*  71 */     return INSERT_PARAMETER_TYPES_OBJECT;
/*     */   }
/*     */   
/*  74 */   private static final String[] UPDATE_OBJECT = new String[] { "UPDATE sec_activity_log SET update_date = ?, update_user_id = ?, organization_id = ?, rtl_loc_id = ?, wkstn_id = ?, business_date = ?, trans_seq = ?, activity_typcode = ?, success_flag = ?, employee_id = ?, overriding_employee_id = ?, privilege_type = ?, system_datetime = ?" };
/*     */   
/*     */   public String[] getUpdate() {
/*  77 */     return UPDATE_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getUpdateParameters() {
/*  81 */     Object[][] updateParameterObject = { { this._updateDate, this._updateUserId, this._organizationId, this._retailLocationId, this._workstationId, this._businessDate, this._transactionSequence, this._activityType, this._success, this._employeeId, this._overridingEmployeeId, this._privilegeType, this._systemDateTime } };
/*  82 */     return updateParameterObject;
/*     */   }
/*     */   
/*  85 */   private static final int[][] UPDATE_PARAMETER_TYPE_OBJECT = new int[][] { { 91, 12, -5, -5, -5, 91, -5, 12, -7, 12, 12, 12, 91 } };
/*     */   public int[][] getUpdateParameterTypes() {
/*  87 */     return UPDATE_PARAMETER_TYPE_OBJECT;
/*     */   }
/*     */   
/*  90 */   private static final String[] DELETE_OBJECT = new String[] { "DELETE FROM sec_activity_log" }; private static final String WHERE_OBJECT = " ";
/*     */   
/*     */   public String[] getDelete() {
/*  93 */     return DELETE_OBJECT;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWhere() {
/*  99 */     return " ";
/*     */   }
/*     */   public Object[] getWhereParameters() {
/* 102 */     return new Object[0];
/*     */   }
/*     */   
/* 105 */   private static final int[] WHERE_PARAMETER_OBJECT = new int[0];
/*     */   
/*     */   public int[] getWhereParameterTypes() {
/* 108 */     return WHERE_PARAMETER_OBJECT;
/*     */   }
/*     */   public String getTableName() {
/* 111 */     return "sec_activity_log";
/*     */   }
/*     */   
/*     */   public IFiller getFiller() {
/* 115 */     return getFillerImpl();
/*     */   }
/*     */   
/*     */   private IFiller getFillerImpl() {
/* 119 */     return new SecurityLogFiller(this);
/*     */   }
/*     */   
/*     */   private static class SecurityLogFiller
/*     */     implements IFiller {
/*     */     private SecurityLogDBA _parent;
/*     */     
/*     */     public SecurityLogFiller(SecurityLogDBA argParent) {
/* 127 */       this._parent = argParent;
/*     */     }
/*     */     
/*     */     public void fill(ResultSet argResultSet) throws SQLException {
/* 131 */       Timestamp t1 = argResultSet.getTimestamp(1);
/* 132 */       if (t1 != null) {
/* 133 */         this._parent._createDate = (Date)new DtvDate(t1.getTime());
/*     */       } else {
/*     */         
/* 136 */         this._parent._createDate = null;
/*     */       } 
/*     */       
/* 139 */       this._parent._createUserId = argResultSet.getString(2);
/*     */       
/* 141 */       Timestamp t3 = argResultSet.getTimestamp(3);
/* 142 */       if (t3 != null) {
/* 143 */         this._parent._updateDate = (Date)new DtvDate(t3.getTime());
/*     */       } else {
/*     */         
/* 146 */         this._parent._updateDate = null;
/*     */       } 
/*     */       
/* 149 */       this._parent._updateUserId = argResultSet.getString(4);
/*     */ 
/*     */       
/* 152 */       long primitiveResult = argResultSet.getLong(5);
/* 153 */       if (primitiveResult != 0L || argResultSet.getObject(5) != null) {
/* 154 */         this._parent._organizationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 160 */       primitiveResult = argResultSet.getLong(6);
/* 161 */       if (primitiveResult != 0L || argResultSet.getObject(6) != null) {
/* 162 */         this._parent._retailLocationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 168 */       primitiveResult = argResultSet.getLong(7);
/* 169 */       if (primitiveResult != 0L || argResultSet.getObject(7) != null) {
/* 170 */         this._parent._workstationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 175 */       Timestamp t8 = argResultSet.getTimestamp(8);
/* 176 */       if (t8 != null) {
/* 177 */         this._parent._businessDate = (Date)new DtvDate(t8.getTime());
/*     */       } else {
/*     */         
/* 180 */         this._parent._businessDate = null;
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/* 185 */       long l1 = argResultSet.getLong(9);
/* 186 */       if (l1 != 0L || argResultSet.getObject(9) != null) {
/* 187 */         this._parent._transactionSequence = Long.valueOf(l1);
/*     */       }
/*     */ 
/*     */       
/* 191 */       this._parent._activityType = argResultSet.getString(10);
/* 192 */       this._parent._success = Boolean.valueOf(argResultSet.getBoolean(11));
/* 193 */       this._parent._employeeId = argResultSet.getString(12);
/* 194 */       this._parent._overridingEmployeeId = argResultSet.getString(13);
/* 195 */       this._parent._privilegeType = argResultSet.getString(14);
/*     */       
/* 197 */       Timestamp t15 = argResultSet.getTimestamp(15);
/* 198 */       if (t15 != null) {
/* 199 */         this._parent._systemDateTime = (Date)new DtvDate(t15.getTime());
/*     */       } else {
/*     */         
/* 202 */         this._parent._systemDateTime = null;
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public IDataAccessObject loadDAO(IDataAccessObject argDAO) {
/* 209 */     argDAO.suppressStateChanges(true);
/* 210 */     SecurityLogDAO dao = (SecurityLogDAO)argDAO;
/* 211 */     dao.setCreateDate(this._createDate);
/* 212 */     dao.setCreateUserId(this._createUserId);
/* 213 */     dao.setUpdateDate(this._updateDate);
/* 214 */     dao.setUpdateUserId(this._updateUserId);
/* 215 */     dao.setOrganizationId(this._organizationId);
/* 216 */     dao.setRetailLocationId(this._retailLocationId);
/* 217 */     dao.setWorkstationId(this._workstationId);
/* 218 */     dao.setBusinessDate(this._businessDate);
/* 219 */     dao.setTransactionSequence(this._transactionSequence);
/* 220 */     dao.setActivityType(this._activityType);
/* 221 */     dao.setSuccess(this._success);
/* 222 */     dao.setEmployeeId(this._employeeId);
/* 223 */     dao.setOverridingEmployeeId(this._overridingEmployeeId);
/* 224 */     dao.setPrivilegeType(this._privilegeType);
/* 225 */     dao.setSystemDateTime(this._systemDateTime);
/* 226 */     argDAO.suppressStateChanges(false);
/* 227 */     return (IDataAccessObject)dao;
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDefaultDAO() {
/* 231 */     return loadDAO((IDataAccessObject)new SecurityLogDAO());
/*     */   }
/*     */   
/*     */   public void fill(IDataAccessObject argDAO) {
/* 235 */     SecurityLogDAO dao = (SecurityLogDAO)argDAO;
/* 236 */     this._createDate = dao.getCreateDate();
/* 237 */     this._createUserId = dao.getCreateUserId();
/* 238 */     this._updateDate = dao.getUpdateDate();
/* 239 */     this._updateUserId = dao.getUpdateUserId();
/* 240 */     this._organizationId = dao.getOrganizationId();
/* 241 */     this._retailLocationId = dao.getRetailLocationId();
/* 242 */     this._workstationId = dao.getWorkstationId();
/* 243 */     this._businessDate = dao.getBusinessDate();
/* 244 */     this._transactionSequence = dao.getTransactionSequence();
/* 245 */     this._activityType = dao.getActivityType();
/* 246 */     this._success = (dao.getSuccess() != null) ? dao.getSuccess() : Boolean.valueOf(false);
/* 247 */     this._employeeId = dao.getEmployeeId();
/* 248 */     this._overridingEmployeeId = dao.getOverridingEmployeeId();
/* 249 */     this._privilegeType = dao.getPrivilegeType();
/* 250 */     this._systemDateTime = dao.getSystemDateTime();
/*     */   }
/*     */   
/*     */   public PreparedStatement writeObjectId(IObjectId argId, PreparedStatement argStatement) {
/* 254 */     return argStatement;
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 258 */     SecurityLogId id = new SecurityLogId();
/* 259 */     return (IObjectId)id;
/*     */   }
/*     */ 
/*     */   
/*     */   public void fill(IJDBCTableAdapter argAdapter) {}
/*     */ 
/*     */   
/*     */   public boolean isExtensible() {
/* 267 */     return false;
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 271 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\sec\impl\SecurityLogDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */