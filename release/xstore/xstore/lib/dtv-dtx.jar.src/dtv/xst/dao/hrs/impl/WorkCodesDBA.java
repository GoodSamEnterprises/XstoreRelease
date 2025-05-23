/*     */ package dtv.xst.dao.hrs.impl;
/*     */ 
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.impl.jdbc.IFiller;
/*     */ import dtv.data2.access.impl.jdbc.IJDBCTableAdapter;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.util.ObjectUtils;
/*     */ import dtv.xst.dao.hrs.WorkCodesId;
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
/*     */ public class WorkCodesDBA
/*     */   implements IJDBCTableAdapter
/*     */ {
/*     */   private static final long serialVersionUID = -1226491019L;
/*     */   private Long _organizationId;
/*     */   private String _workCode;
/*     */   private String _orgCode;
/*     */   private String _orgValue;
/*     */   private Date _createDate;
/*     */   private String _createUserId;
/*     */   private Date _updateDate;
/*     */   private String _updateUserId;
/*     */   private String _description;
/*     */   private Integer _sortOrder;
/*     */   private Boolean _selling;
/*     */   private String _privilege;
/*     */   private String _payrollCategoryString;
/*     */   private Integer _minimumClockInDuration;
/*     */   private Integer _minimumClockOutDuration;
/*     */   private Boolean _hidden;
/*     */   private static final String SELECT_OBJECT = "SELECT t.organization_id, t.work_code, t.org_code, t.org_value, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.description, t.sort_order, t.selling_flag, t.privilege, t.payroll_category, t.min_clock_in_duration, t.min_clock_out_duration, t.hidden_flag FROM hrs_work_codes t";
/*     */   private static final String SELECT_WHERE_OBJECT = " WHERE organization_id = ?  AND work_code = ?  ";
/*     */   
/*     */   public String getSelect() {
/*  45 */     return getSelectImpl();
/*     */   }
/*     */   
/*     */   private String getSelectImpl() {
/*  49 */     return "SELECT t.organization_id, t.work_code, t.org_code, t.org_value, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.description, t.sort_order, t.selling_flag, t.privilege, t.payroll_category, t.min_clock_in_duration, t.min_clock_out_duration, t.hidden_flag FROM hrs_work_codes t";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectWhere() {
/*  55 */     return " WHERE organization_id = ?  AND work_code = ?  ";
/*     */   }
/*     */   
/*  58 */   private static final String[] INSERT_OBJECT = new String[] { "INSERT INTO hrs_work_codes(organization_id, work_code, org_code, org_value, create_date, create_user_id, update_date, update_user_id, description, sort_order, selling_flag, privilege, payroll_category, min_clock_in_duration, min_clock_out_duration, hidden_flag) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" };
/*     */   
/*     */   public String[] getInsert() {
/*  61 */     return INSERT_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getInsertParameters() {
/*  65 */     Object[][] insertParameterObject = { { this._organizationId, this._workCode, ObjectUtils.coalesce((Object[])new String[] { this._orgCode, "*" }), ObjectUtils.coalesce((Object[])new String[] { this._orgValue, "*" }), this._createDate, this._createUserId, this._updateDate, this._updateUserId, this._description, this._sortOrder, this._selling, this._privilege, this._payrollCategoryString, this._minimumClockInDuration, this._minimumClockOutDuration, this._hidden } };
/*  66 */     return insertParameterObject;
/*     */   }
/*     */   
/*  69 */   private static final int[][] INSERT_PARAMETER_TYPES_OBJECT = new int[][] { { -5, 12, 12, 12, 91, 12, 91, 12, 12, 4, -7, 12, 12, 4, 4, -7 } };
/*     */   
/*     */   public int[][] getInsertParameterTypes() {
/*  72 */     return INSERT_PARAMETER_TYPES_OBJECT;
/*     */   }
/*     */   
/*  75 */   private static final String[] UPDATE_OBJECT = new String[] { "UPDATE hrs_work_codes SET org_code = ?, org_value = ?, update_date = ?, update_user_id = ?, description = ?, sort_order = ?, selling_flag = ?, privilege = ?, payroll_category = ?, min_clock_in_duration = ?, min_clock_out_duration = ?, hidden_flag = ?" };
/*     */   
/*     */   public String[] getUpdate() {
/*  78 */     return UPDATE_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getUpdateParameters() {
/*  82 */     Object[][] updateParameterObject = { { this._orgCode, this._orgValue, this._updateDate, this._updateUserId, this._description, this._sortOrder, this._selling, this._privilege, this._payrollCategoryString, this._minimumClockInDuration, this._minimumClockOutDuration, this._hidden } };
/*  83 */     return updateParameterObject;
/*     */   }
/*     */   
/*  86 */   private static final int[][] UPDATE_PARAMETER_TYPE_OBJECT = new int[][] { { 12, 12, 91, 12, 12, 4, -7, 12, 12, 4, 4, -7 } };
/*     */   public int[][] getUpdateParameterTypes() {
/*  88 */     return UPDATE_PARAMETER_TYPE_OBJECT;
/*     */   }
/*     */   
/*  91 */   private static final String[] DELETE_OBJECT = new String[] { "DELETE FROM hrs_work_codes" }; private static final String WHERE_OBJECT = " WHERE organization_id = ?  AND work_code = ?  ";
/*     */   
/*     */   public String[] getDelete() {
/*  94 */     return DELETE_OBJECT;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWhere() {
/* 100 */     return " WHERE organization_id = ?  AND work_code = ?  ";
/*     */   }
/*     */   public Object[] getWhereParameters() {
/* 103 */     return new Object[] { this._organizationId, this._workCode };
/*     */   }
/*     */   
/* 106 */   private static final int[] WHERE_PARAMETER_OBJECT = new int[] { -5, 12 };
/*     */   
/*     */   public int[] getWhereParameterTypes() {
/* 109 */     return WHERE_PARAMETER_OBJECT;
/*     */   }
/*     */   public String getTableName() {
/* 112 */     return "hrs_work_codes";
/*     */   }
/*     */   
/*     */   public IFiller getFiller() {
/* 116 */     return getFillerImpl();
/*     */   }
/*     */   
/*     */   private IFiller getFillerImpl() {
/* 120 */     return new WorkCodesFiller(this);
/*     */   }
/*     */   
/*     */   private static class WorkCodesFiller
/*     */     implements IFiller {
/*     */     private WorkCodesDBA _parent;
/*     */     
/*     */     public WorkCodesFiller(WorkCodesDBA argParent) {
/* 128 */       this._parent = argParent;
/*     */     }
/*     */ 
/*     */     
/*     */     public void fill(ResultSet argResultSet) throws SQLException {
/* 133 */       long primitiveResult = argResultSet.getLong(1);
/* 134 */       if (primitiveResult != 0L || argResultSet.getObject(1) != null) {
/* 135 */         this._parent._organizationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */       
/* 139 */       this._parent._workCode = argResultSet.getString(2);
/* 140 */       this._parent._orgCode = argResultSet.getString(3);
/* 141 */       this._parent._orgValue = argResultSet.getString(4);
/*     */       
/* 143 */       Timestamp t5 = argResultSet.getTimestamp(5);
/* 144 */       if (t5 != null) {
/* 145 */         this._parent._createDate = (Date)new DtvDate(t5.getTime());
/*     */       } else {
/*     */         
/* 148 */         this._parent._createDate = null;
/*     */       } 
/*     */       
/* 151 */       this._parent._createUserId = argResultSet.getString(6);
/*     */       
/* 153 */       Timestamp t7 = argResultSet.getTimestamp(7);
/* 154 */       if (t7 != null) {
/* 155 */         this._parent._updateDate = (Date)new DtvDate(t7.getTime());
/*     */       } else {
/*     */         
/* 158 */         this._parent._updateDate = null;
/*     */       } 
/*     */       
/* 161 */       this._parent._updateUserId = argResultSet.getString(8);
/* 162 */       this._parent._description = argResultSet.getString(9);
/*     */ 
/*     */       
/* 165 */       int i = argResultSet.getInt(10);
/* 166 */       if (i != 0 || argResultSet.getObject(10) != null) {
/* 167 */         this._parent._sortOrder = Integer.valueOf(i);
/*     */       }
/*     */ 
/*     */       
/* 171 */       this._parent._selling = Boolean.valueOf(argResultSet.getBoolean(11));
/* 172 */       this._parent._privilege = argResultSet.getString(12);
/* 173 */       this._parent._payrollCategoryString = argResultSet.getString(13);
/*     */ 
/*     */       
/* 176 */       i = argResultSet.getInt(14);
/* 177 */       if (i != 0 || argResultSet.getObject(14) != null) {
/* 178 */         this._parent._minimumClockInDuration = Integer.valueOf(i);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 184 */       i = argResultSet.getInt(15);
/* 185 */       if (i != 0 || argResultSet.getObject(15) != null) {
/* 186 */         this._parent._minimumClockOutDuration = Integer.valueOf(i);
/*     */       }
/*     */ 
/*     */       
/* 190 */       this._parent._hidden = Boolean.valueOf(argResultSet.getBoolean(16));
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDAO(IDataAccessObject argDAO) {
/* 195 */     argDAO.suppressStateChanges(true);
/* 196 */     WorkCodesDAO dao = (WorkCodesDAO)argDAO;
/* 197 */     dao.setOrganizationId(this._organizationId);
/* 198 */     dao.setWorkCode(this._workCode);
/* 199 */     dao.setOrgCode(this._orgCode);
/* 200 */     dao.setOrgValue(this._orgValue);
/* 201 */     dao.setCreateDate(this._createDate);
/* 202 */     dao.setCreateUserId(this._createUserId);
/* 203 */     dao.setUpdateDate(this._updateDate);
/* 204 */     dao.setUpdateUserId(this._updateUserId);
/* 205 */     dao.setDescription(this._description);
/* 206 */     dao.setSortOrder(this._sortOrder);
/* 207 */     dao.setSelling(this._selling);
/* 208 */     dao.setPrivilege(this._privilege);
/* 209 */     dao.setPayrollCategoryString(this._payrollCategoryString);
/* 210 */     dao.setMinimumClockInDuration(this._minimumClockInDuration);
/* 211 */     dao.setMinimumClockOutDuration(this._minimumClockOutDuration);
/* 212 */     dao.setHidden(this._hidden);
/* 213 */     argDAO.suppressStateChanges(false);
/* 214 */     return (IDataAccessObject)dao;
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDefaultDAO() {
/* 218 */     return loadDAO((IDataAccessObject)new WorkCodesDAO());
/*     */   }
/*     */   
/*     */   public void fill(IDataAccessObject argDAO) {
/* 222 */     WorkCodesDAO dao = (WorkCodesDAO)argDAO;
/* 223 */     this._organizationId = dao.getOrganizationId();
/* 224 */     this._workCode = dao.getWorkCode();
/* 225 */     this._orgCode = dao.getOrgCode();
/* 226 */     this._orgValue = dao.getOrgValue();
/* 227 */     this._createDate = dao.getCreateDate();
/* 228 */     this._createUserId = dao.getCreateUserId();
/* 229 */     this._updateDate = dao.getUpdateDate();
/* 230 */     this._updateUserId = dao.getUpdateUserId();
/* 231 */     this._description = dao.getDescription();
/* 232 */     this._sortOrder = dao.getSortOrder();
/* 233 */     this._selling = (dao.getSelling() != null) ? dao.getSelling() : Boolean.valueOf(false);
/* 234 */     this._privilege = dao.getPrivilege();
/* 235 */     this._payrollCategoryString = dao.getPayrollCategoryString();
/* 236 */     this._minimumClockInDuration = dao.getMinimumClockInDuration();
/* 237 */     this._minimumClockOutDuration = dao.getMinimumClockOutDuration();
/* 238 */     this._hidden = (dao.getHidden() != null) ? dao.getHidden() : Boolean.valueOf(false);
/*     */   }
/*     */   
/*     */   public PreparedStatement writeObjectId(IObjectId argId, PreparedStatement argStatement) throws SQLException {
/* 242 */     WorkCodesId id = (WorkCodesId)argId;
/* 243 */     argStatement.setLong(1, id.getOrganizationId().longValue());
/* 244 */     argStatement.setString(2, id.getWorkCode());
/* 245 */     return argStatement;
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 249 */     WorkCodesId id = new WorkCodesId();
/* 250 */     id.setOrganizationId(this._organizationId);
/* 251 */     id.setWorkCode(this._workCode);
/* 252 */     return (IObjectId)id;
/*     */   }
/*     */ 
/*     */   
/*     */   public void fill(IJDBCTableAdapter argAdapter) {}
/*     */ 
/*     */   
/*     */   public boolean isExtensible() {
/* 260 */     return false;
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 264 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\hrs\impl\WorkCodesDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */