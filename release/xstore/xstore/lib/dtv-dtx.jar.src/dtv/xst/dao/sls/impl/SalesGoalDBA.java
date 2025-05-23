/*     */ package dtv.xst.dao.sls.impl;
/*     */ 
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.impl.jdbc.IFiller;
/*     */ import dtv.data2.access.impl.jdbc.IJDBCTableAdapter;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.util.ObjectUtils;
/*     */ import dtv.xst.dao.sls.SalesGoalId;
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
/*     */ public class SalesGoalDBA
/*     */   implements IJDBCTableAdapter
/*     */ {
/*     */   private static final long serialVersionUID = 1920136735L;
/*     */   private Long _organizationId;
/*     */   private String _salesGoalId;
/*     */   private String _orgCode;
/*     */   private String _orgValue;
/*     */   private BigDecimal _salesGoalValue;
/*     */   private Date _effectiveDate;
/*     */   private Date _endDate;
/*     */   private String _description;
/*     */   private Date _createDate;
/*     */   private String _createUserId;
/*     */   private Date _updateDate;
/*     */   private String _updateUserId;
/*     */   private static final String SELECT_OBJECT = "SELECT t.organization_id, t.sales_goal_id, t.org_code, t.org_value, t.sales_goal_value, t.effective_date, t.end_date, t.description, t.create_date, t.create_user_id, t.update_date, t.update_user_id FROM sls_sales_goal t";
/*     */   private static final String SELECT_WHERE_OBJECT = " WHERE organization_id = ?  AND sales_goal_id = ?  ";
/*     */   
/*     */   public String getSelect() {
/*  41 */     return getSelectImpl();
/*     */   }
/*     */   
/*     */   private String getSelectImpl() {
/*  45 */     return "SELECT t.organization_id, t.sales_goal_id, t.org_code, t.org_value, t.sales_goal_value, t.effective_date, t.end_date, t.description, t.create_date, t.create_user_id, t.update_date, t.update_user_id FROM sls_sales_goal t";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectWhere() {
/*  51 */     return " WHERE organization_id = ?  AND sales_goal_id = ?  ";
/*     */   }
/*     */   
/*  54 */   private static final String[] INSERT_OBJECT = new String[] { "INSERT INTO sls_sales_goal(organization_id, sales_goal_id, org_code, org_value, sales_goal_value, effective_date, end_date, description, create_date, create_user_id, update_date, update_user_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" };
/*     */   
/*     */   public String[] getInsert() {
/*  57 */     return INSERT_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getInsertParameters() {
/*  61 */     Object[][] insertParameterObject = { { this._organizationId, this._salesGoalId, ObjectUtils.coalesce((Object[])new String[] { this._orgCode, "*" }), ObjectUtils.coalesce((Object[])new String[] { this._orgValue, "*" }), this._salesGoalValue, this._effectiveDate, this._endDate, this._description, this._createDate, this._createUserId, this._updateDate, this._updateUserId } };
/*  62 */     return insertParameterObject;
/*     */   }
/*     */   
/*  65 */   private static final int[][] INSERT_PARAMETER_TYPES_OBJECT = new int[][] { { -5, 12, 12, 12, 3, 91, 91, 12, 91, 12, 91, 12 } };
/*     */   
/*     */   public int[][] getInsertParameterTypes() {
/*  68 */     return INSERT_PARAMETER_TYPES_OBJECT;
/*     */   }
/*     */   
/*  71 */   private static final String[] UPDATE_OBJECT = new String[] { "UPDATE sls_sales_goal SET org_code = ?, org_value = ?, sales_goal_value = ?, effective_date = ?, end_date = ?, description = ?, update_date = ?, update_user_id = ?" };
/*     */   
/*     */   public String[] getUpdate() {
/*  74 */     return UPDATE_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getUpdateParameters() {
/*  78 */     Object[][] updateParameterObject = { { this._orgCode, this._orgValue, this._salesGoalValue, this._effectiveDate, this._endDate, this._description, this._updateDate, this._updateUserId } };
/*  79 */     return updateParameterObject;
/*     */   }
/*     */   
/*  82 */   private static final int[][] UPDATE_PARAMETER_TYPE_OBJECT = new int[][] { { 12, 12, 3, 91, 91, 12, 91, 12 } };
/*     */   public int[][] getUpdateParameterTypes() {
/*  84 */     return UPDATE_PARAMETER_TYPE_OBJECT;
/*     */   }
/*     */   
/*  87 */   private static final String[] DELETE_OBJECT = new String[] { "DELETE FROM sls_sales_goal" }; private static final String WHERE_OBJECT = " WHERE organization_id = ?  AND sales_goal_id = ?  ";
/*     */   
/*     */   public String[] getDelete() {
/*  90 */     return DELETE_OBJECT;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWhere() {
/*  96 */     return " WHERE organization_id = ?  AND sales_goal_id = ?  ";
/*     */   }
/*     */   public Object[] getWhereParameters() {
/*  99 */     return new Object[] { this._organizationId, this._salesGoalId };
/*     */   }
/*     */   
/* 102 */   private static final int[] WHERE_PARAMETER_OBJECT = new int[] { -5, 12 };
/*     */   
/*     */   public int[] getWhereParameterTypes() {
/* 105 */     return WHERE_PARAMETER_OBJECT;
/*     */   }
/*     */   public String getTableName() {
/* 108 */     return "sls_sales_goal";
/*     */   }
/*     */   
/*     */   public IFiller getFiller() {
/* 112 */     return getFillerImpl();
/*     */   }
/*     */   
/*     */   private IFiller getFillerImpl() {
/* 116 */     return new SalesGoalFiller(this);
/*     */   }
/*     */   
/*     */   private static class SalesGoalFiller
/*     */     implements IFiller {
/*     */     private SalesGoalDBA _parent;
/*     */     
/*     */     public SalesGoalFiller(SalesGoalDBA argParent) {
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
/* 135 */       this._parent._salesGoalId = argResultSet.getString(2);
/* 136 */       this._parent._orgCode = argResultSet.getString(3);
/* 137 */       this._parent._orgValue = argResultSet.getString(4);
/* 138 */       this._parent._salesGoalValue = argResultSet.getBigDecimal(5);
/*     */       
/* 140 */       Timestamp t6 = argResultSet.getTimestamp(6);
/* 141 */       if (t6 != null) {
/* 142 */         this._parent._effectiveDate = (Date)new DtvDate(t6.getTime());
/*     */       } else {
/*     */         
/* 145 */         this._parent._effectiveDate = null;
/*     */       } 
/*     */ 
/*     */       
/* 149 */       Timestamp t7 = argResultSet.getTimestamp(7);
/* 150 */       if (t7 != null) {
/* 151 */         this._parent._endDate = (Date)new DtvDate(t7.getTime());
/*     */       } else {
/*     */         
/* 154 */         this._parent._endDate = null;
/*     */       } 
/*     */       
/* 157 */       this._parent._description = argResultSet.getString(8);
/*     */       
/* 159 */       Timestamp t9 = argResultSet.getTimestamp(9);
/* 160 */       if (t9 != null) {
/* 161 */         this._parent._createDate = (Date)new DtvDate(t9.getTime());
/*     */       } else {
/*     */         
/* 164 */         this._parent._createDate = null;
/*     */       } 
/*     */       
/* 167 */       this._parent._createUserId = argResultSet.getString(10);
/*     */       
/* 169 */       Timestamp t11 = argResultSet.getTimestamp(11);
/* 170 */       if (t11 != null) {
/* 171 */         this._parent._updateDate = (Date)new DtvDate(t11.getTime());
/*     */       } else {
/*     */         
/* 174 */         this._parent._updateDate = null;
/*     */       } 
/*     */       
/* 177 */       this._parent._updateUserId = argResultSet.getString(12);
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDAO(IDataAccessObject argDAO) {
/* 182 */     argDAO.suppressStateChanges(true);
/* 183 */     SalesGoalDAO dao = (SalesGoalDAO)argDAO;
/* 184 */     dao.setOrganizationId(this._organizationId);
/* 185 */     dao.setSalesGoalId(this._salesGoalId);
/* 186 */     dao.setOrgCode(this._orgCode);
/* 187 */     dao.setOrgValue(this._orgValue);
/* 188 */     dao.setSalesGoalValue(this._salesGoalValue);
/* 189 */     dao.setEffectiveDate(this._effectiveDate);
/* 190 */     dao.setEndDate(this._endDate);
/* 191 */     dao.setDescription(this._description);
/* 192 */     dao.setCreateDate(this._createDate);
/* 193 */     dao.setCreateUserId(this._createUserId);
/* 194 */     dao.setUpdateDate(this._updateDate);
/* 195 */     dao.setUpdateUserId(this._updateUserId);
/* 196 */     argDAO.suppressStateChanges(false);
/* 197 */     return (IDataAccessObject)dao;
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDefaultDAO() {
/* 201 */     return loadDAO((IDataAccessObject)new SalesGoalDAO());
/*     */   }
/*     */   
/*     */   public void fill(IDataAccessObject argDAO) {
/* 205 */     SalesGoalDAO dao = (SalesGoalDAO)argDAO;
/* 206 */     this._organizationId = dao.getOrganizationId();
/* 207 */     this._salesGoalId = dao.getSalesGoalId();
/* 208 */     this._orgCode = dao.getOrgCode();
/* 209 */     this._orgValue = dao.getOrgValue();
/* 210 */     this._salesGoalValue = dao.getSalesGoalValue();
/* 211 */     this._effectiveDate = dao.getEffectiveDate();
/* 212 */     this._endDate = dao.getEndDate();
/* 213 */     this._description = dao.getDescription();
/* 214 */     this._createDate = dao.getCreateDate();
/* 215 */     this._createUserId = dao.getCreateUserId();
/* 216 */     this._updateDate = dao.getUpdateDate();
/* 217 */     this._updateUserId = dao.getUpdateUserId();
/*     */   }
/*     */   
/*     */   public PreparedStatement writeObjectId(IObjectId argId, PreparedStatement argStatement) throws SQLException {
/* 221 */     SalesGoalId id = (SalesGoalId)argId;
/* 222 */     argStatement.setLong(1, id.getOrganizationId().longValue());
/* 223 */     argStatement.setString(2, id.getSalesGoalId());
/* 224 */     return argStatement;
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 228 */     SalesGoalId id = new SalesGoalId();
/* 229 */     id.setOrganizationId(this._organizationId);
/* 230 */     id.setSalesGoalId(this._salesGoalId);
/* 231 */     return (IObjectId)id;
/*     */   }
/*     */ 
/*     */   
/*     */   public void fill(IJDBCTableAdapter argAdapter) {}
/*     */ 
/*     */   
/*     */   public boolean isExtensible() {
/* 239 */     return false;
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 243 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\sls\impl\SalesGoalDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */