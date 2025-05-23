/*     */ package dtv.xst.dao.hrs.impl;
/*     */ 
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.impl.jdbc.IFiller;
/*     */ import dtv.data2.access.impl.jdbc.IJDBCTableAdapter;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.util.ObjectUtils;
/*     */ import dtv.xst.dao.hrs.EmployeeMessageId;
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
/*     */ public class EmployeeMessageDBA
/*     */   implements IJDBCTableAdapter
/*     */ {
/*     */   private static final long serialVersionUID = 414263641L;
/*     */   private Long _organizationId;
/*     */   private Long _messageId;
/*     */   private String _orgCode;
/*     */   private String _orgValue;
/*     */   private Date _startDate;
/*     */   private Date _endDate;
/*     */   private String _priority;
/*     */   private Boolean _storeCreated;
/*     */   private Boolean _workstationSpecific;
/*     */   private Integer _workstationId;
/*     */   private String _description;
/*     */   private Boolean _void;
/*     */   private String _messageURL;
/*     */   private Date _createDate;
/*     */   private String _createUserId;
/*     */   private Date _updateDate;
/*     */   private String _updateUserId;
/*     */   private static final String SELECT_OBJECT = "SELECT t.organization_id, t.message_id, t.org_code, t.org_value, t.start_date, t.end_date, t.priority, t.store_created_flag, t.wkstn_specific_flag, t.wkstn_id, t.content, t.void_flag, t.message_url , t.create_date, t.create_user_id, t.update_date, t.update_user_id FROM hrs_employee_message t";
/*     */   private static final String SELECT_WHERE_OBJECT = " WHERE organization_id = ?  AND message_id = ?  ";
/*     */   
/*     */   public String getSelect() {
/*  46 */     return getSelectImpl();
/*     */   }
/*     */   
/*     */   private String getSelectImpl() {
/*  50 */     return "SELECT t.organization_id, t.message_id, t.org_code, t.org_value, t.start_date, t.end_date, t.priority, t.store_created_flag, t.wkstn_specific_flag, t.wkstn_id, t.content, t.void_flag, t.message_url , t.create_date, t.create_user_id, t.update_date, t.update_user_id FROM hrs_employee_message t";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectWhere() {
/*  56 */     return " WHERE organization_id = ?  AND message_id = ?  ";
/*     */   }
/*     */   
/*  59 */   private static final String[] INSERT_OBJECT = new String[] { "INSERT INTO hrs_employee_message(organization_id, message_id, org_code, org_value, start_date, end_date, priority, store_created_flag, wkstn_specific_flag, wkstn_id, content, void_flag, message_url , create_date, create_user_id, update_date, update_user_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" };
/*     */   
/*     */   public String[] getInsert() {
/*  62 */     return INSERT_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getInsertParameters() {
/*  66 */     Object[][] insertParameterObject = { { this._organizationId, this._messageId, ObjectUtils.coalesce((Object[])new String[] { this._orgCode, "*" }), ObjectUtils.coalesce((Object[])new String[] { this._orgValue, "*" }), this._startDate, this._endDate, this._priority, this._storeCreated, this._workstationSpecific, this._workstationId, this._description, this._void, this._messageURL, this._createDate, this._createUserId, this._updateDate, this._updateUserId } };
/*  67 */     return insertParameterObject;
/*     */   }
/*     */   
/*  70 */   private static final int[][] INSERT_PARAMETER_TYPES_OBJECT = new int[][] { { -5, -5, 12, 12, 91, 91, 12, -7, -7, 4, 12, -7, 12, 91, 12, 91, 12 } };
/*     */   
/*     */   public int[][] getInsertParameterTypes() {
/*  73 */     return INSERT_PARAMETER_TYPES_OBJECT;
/*     */   }
/*     */   
/*  76 */   private static final String[] UPDATE_OBJECT = new String[] { "UPDATE hrs_employee_message SET org_code = ?, org_value = ?, start_date = ?, end_date = ?, priority = ?, store_created_flag = ?, wkstn_specific_flag = ?, wkstn_id = ?, content = ?, void_flag = ?, message_url  = ?, update_date = ?, update_user_id = ?" };
/*     */   
/*     */   public String[] getUpdate() {
/*  79 */     return UPDATE_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getUpdateParameters() {
/*  83 */     Object[][] updateParameterObject = { { this._orgCode, this._orgValue, this._startDate, this._endDate, this._priority, this._storeCreated, this._workstationSpecific, this._workstationId, this._description, this._void, this._messageURL, this._updateDate, this._updateUserId } };
/*  84 */     return updateParameterObject;
/*     */   }
/*     */   
/*  87 */   private static final int[][] UPDATE_PARAMETER_TYPE_OBJECT = new int[][] { { 12, 12, 91, 91, 12, -7, -7, 4, 12, -7, 12, 91, 12 } };
/*     */   public int[][] getUpdateParameterTypes() {
/*  89 */     return UPDATE_PARAMETER_TYPE_OBJECT;
/*     */   }
/*     */   
/*  92 */   private static final String[] DELETE_OBJECT = new String[] { "DELETE FROM hrs_employee_message" }; private static final String WHERE_OBJECT = " WHERE organization_id = ?  AND message_id = ?  ";
/*     */   
/*     */   public String[] getDelete() {
/*  95 */     return DELETE_OBJECT;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWhere() {
/* 101 */     return " WHERE organization_id = ?  AND message_id = ?  ";
/*     */   }
/*     */   public Object[] getWhereParameters() {
/* 104 */     return new Object[] { this._organizationId, this._messageId };
/*     */   }
/*     */   
/* 107 */   private static final int[] WHERE_PARAMETER_OBJECT = new int[] { -5, -5 };
/*     */   
/*     */   public int[] getWhereParameterTypes() {
/* 110 */     return WHERE_PARAMETER_OBJECT;
/*     */   }
/*     */   public String getTableName() {
/* 113 */     return "hrs_employee_message";
/*     */   }
/*     */   
/*     */   public IFiller getFiller() {
/* 117 */     return getFillerImpl();
/*     */   }
/*     */   
/*     */   private IFiller getFillerImpl() {
/* 121 */     return new EmployeeMessageFiller(this);
/*     */   }
/*     */   
/*     */   private static class EmployeeMessageFiller
/*     */     implements IFiller {
/*     */     private EmployeeMessageDBA _parent;
/*     */     
/*     */     public EmployeeMessageFiller(EmployeeMessageDBA argParent) {
/* 129 */       this._parent = argParent;
/*     */     }
/*     */ 
/*     */     
/*     */     public void fill(ResultSet argResultSet) throws SQLException {
/* 134 */       long primitiveResult = argResultSet.getLong(1);
/* 135 */       if (primitiveResult != 0L || argResultSet.getObject(1) != null) {
/* 136 */         this._parent._organizationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 142 */       primitiveResult = argResultSet.getLong(2);
/* 143 */       if (primitiveResult != 0L || argResultSet.getObject(2) != null) {
/* 144 */         this._parent._messageId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */       
/* 148 */       this._parent._orgCode = argResultSet.getString(3);
/* 149 */       this._parent._orgValue = argResultSet.getString(4);
/*     */       
/* 151 */       Timestamp t5 = argResultSet.getTimestamp(5);
/* 152 */       if (t5 != null) {
/* 153 */         this._parent._startDate = (Date)new DtvDate(t5.getTime());
/*     */       } else {
/*     */         
/* 156 */         this._parent._startDate = null;
/*     */       } 
/*     */ 
/*     */       
/* 160 */       Timestamp t6 = argResultSet.getTimestamp(6);
/* 161 */       if (t6 != null) {
/* 162 */         this._parent._endDate = (Date)new DtvDate(t6.getTime());
/*     */       } else {
/*     */         
/* 165 */         this._parent._endDate = null;
/*     */       } 
/*     */       
/* 168 */       this._parent._priority = argResultSet.getString(7);
/* 169 */       this._parent._storeCreated = Boolean.valueOf(argResultSet.getBoolean(8));
/* 170 */       this._parent._workstationSpecific = Boolean.valueOf(argResultSet.getBoolean(9));
/*     */ 
/*     */       
/* 173 */       int i = argResultSet.getInt(10);
/* 174 */       if (i != 0 || argResultSet.getObject(10) != null) {
/* 175 */         this._parent._workstationId = Integer.valueOf(i);
/*     */       }
/*     */ 
/*     */       
/* 179 */       this._parent._description = argResultSet.getString(11);
/* 180 */       this._parent._void = Boolean.valueOf(argResultSet.getBoolean(12));
/* 181 */       this._parent._messageURL = argResultSet.getString(13);
/*     */       
/* 183 */       Timestamp t14 = argResultSet.getTimestamp(14);
/* 184 */       if (t14 != null) {
/* 185 */         this._parent._createDate = (Date)new DtvDate(t14.getTime());
/*     */       } else {
/*     */         
/* 188 */         this._parent._createDate = null;
/*     */       } 
/*     */       
/* 191 */       this._parent._createUserId = argResultSet.getString(15);
/*     */       
/* 193 */       Timestamp t16 = argResultSet.getTimestamp(16);
/* 194 */       if (t16 != null) {
/* 195 */         this._parent._updateDate = (Date)new DtvDate(t16.getTime());
/*     */       } else {
/*     */         
/* 198 */         this._parent._updateDate = null;
/*     */       } 
/*     */       
/* 201 */       this._parent._updateUserId = argResultSet.getString(17);
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDAO(IDataAccessObject argDAO) {
/* 206 */     argDAO.suppressStateChanges(true);
/* 207 */     EmployeeMessageDAO dao = (EmployeeMessageDAO)argDAO;
/* 208 */     dao.setOrganizationId(this._organizationId);
/* 209 */     dao.setMessageId(this._messageId);
/* 210 */     dao.setOrgCode(this._orgCode);
/* 211 */     dao.setOrgValue(this._orgValue);
/* 212 */     dao.setStartDate(this._startDate);
/* 213 */     dao.setEndDate(this._endDate);
/* 214 */     dao.setPriority(this._priority);
/* 215 */     dao.setStoreCreated(this._storeCreated);
/* 216 */     dao.setWorkstationSpecific(this._workstationSpecific);
/* 217 */     dao.setWorkstationId(this._workstationId);
/* 218 */     dao.setDescription(this._description);
/* 219 */     dao.setVoid(this._void);
/* 220 */     dao.setMessageURL(this._messageURL);
/* 221 */     dao.setCreateDate(this._createDate);
/* 222 */     dao.setCreateUserId(this._createUserId);
/* 223 */     dao.setUpdateDate(this._updateDate);
/* 224 */     dao.setUpdateUserId(this._updateUserId);
/* 225 */     argDAO.suppressStateChanges(false);
/* 226 */     return (IDataAccessObject)dao;
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDefaultDAO() {
/* 230 */     return loadDAO((IDataAccessObject)new EmployeeMessageDAO());
/*     */   }
/*     */   
/*     */   public void fill(IDataAccessObject argDAO) {
/* 234 */     EmployeeMessageDAO dao = (EmployeeMessageDAO)argDAO;
/* 235 */     this._organizationId = dao.getOrganizationId();
/* 236 */     this._messageId = dao.getMessageId();
/* 237 */     this._orgCode = dao.getOrgCode();
/* 238 */     this._orgValue = dao.getOrgValue();
/* 239 */     this._startDate = dao.getStartDate();
/* 240 */     this._endDate = dao.getEndDate();
/* 241 */     this._priority = dao.getPriority();
/* 242 */     this._storeCreated = (dao.getStoreCreated() != null) ? dao.getStoreCreated() : Boolean.valueOf(false);
/* 243 */     this._workstationSpecific = (dao.getWorkstationSpecific() != null) ? dao.getWorkstationSpecific() : Boolean.valueOf(false);
/* 244 */     this._workstationId = dao.getWorkstationId();
/* 245 */     this._description = dao.getDescription();
/* 246 */     this._void = (dao.getVoid() != null) ? dao.getVoid() : Boolean.valueOf(false);
/* 247 */     this._messageURL = dao.getMessageURL();
/* 248 */     this._createDate = dao.getCreateDate();
/* 249 */     this._createUserId = dao.getCreateUserId();
/* 250 */     this._updateDate = dao.getUpdateDate();
/* 251 */     this._updateUserId = dao.getUpdateUserId();
/*     */   }
/*     */   
/*     */   public PreparedStatement writeObjectId(IObjectId argId, PreparedStatement argStatement) throws SQLException {
/* 255 */     EmployeeMessageId id = (EmployeeMessageId)argId;
/* 256 */     argStatement.setLong(1, id.getOrganizationId().longValue());
/* 257 */     argStatement.setLong(2, id.getMessageId().longValue());
/* 258 */     return argStatement;
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 262 */     EmployeeMessageId id = new EmployeeMessageId();
/* 263 */     id.setOrganizationId(this._organizationId);
/* 264 */     id.setMessageId(this._messageId);
/* 265 */     return (IObjectId)id;
/*     */   }
/*     */ 
/*     */   
/*     */   public void fill(IJDBCTableAdapter argAdapter) {}
/*     */ 
/*     */   
/*     */   public boolean isExtensible() {
/* 273 */     return false;
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 277 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\hrs\impl\EmployeeMessageDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */