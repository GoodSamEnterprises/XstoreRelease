/*     */ package dtv.xst.dao.cat.impl;
/*     */ 
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.impl.jdbc.IFiller;
/*     */ import dtv.data2.access.impl.jdbc.IJDBCTableAdapter;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.util.ObjectUtils;
/*     */ import dtv.xst.dao.cat.CustomerAccountPlanId;
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
/*     */ public class CustomerAccountPlanDBA
/*     */   implements IJDBCTableAdapter
/*     */ {
/*     */   private static final long serialVersionUID = 1544725528L;
/*     */   private Long _organizationId;
/*     */   private String _custAccountCode;
/*     */   private String _planId;
/*     */   private Date _createDate;
/*     */   private String _createUserId;
/*     */   private Date _updateDate;
/*     */   private String _updateUserId;
/*     */   private String _orgCode;
/*     */   private String _orgValue;
/*     */   private String _planDescription;
/*     */   private Date _effectiveDate;
/*     */   private Date _expirationDate;
/*     */   private Integer _displayOrder;
/*     */   private static final String SELECT_OBJECT = "SELECT t.organization_id, t.cust_acct_code, t.plan_id, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.org_code, t.org_value, t.plan_description, t.effective_date, t.expiration_date, t.display_order FROM cat_cust_acct_plan t";
/*     */   private static final String SELECT_WHERE_OBJECT = " WHERE organization_id = ?  AND cust_acct_code = ?  AND plan_id = ?  ";
/*     */   
/*     */   public String getSelect() {
/*  42 */     return getSelectImpl();
/*     */   }
/*     */   
/*     */   private String getSelectImpl() {
/*  46 */     return "SELECT t.organization_id, t.cust_acct_code, t.plan_id, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.org_code, t.org_value, t.plan_description, t.effective_date, t.expiration_date, t.display_order FROM cat_cust_acct_plan t";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectWhere() {
/*  52 */     return " WHERE organization_id = ?  AND cust_acct_code = ?  AND plan_id = ?  ";
/*     */   }
/*     */   
/*  55 */   private static final String[] INSERT_OBJECT = new String[] { "INSERT INTO cat_cust_acct_plan(organization_id, cust_acct_code, plan_id, create_date, create_user_id, update_date, update_user_id, org_code, org_value, plan_description, effective_date, expiration_date, display_order) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" };
/*     */   
/*     */   public String[] getInsert() {
/*  58 */     return INSERT_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getInsertParameters() {
/*  62 */     Object[][] insertParameterObject = { { this._organizationId, this._custAccountCode, this._planId, this._createDate, this._createUserId, this._updateDate, this._updateUserId, ObjectUtils.coalesce((Object[])new String[] { this._orgCode, "*" }), ObjectUtils.coalesce((Object[])new String[] { this._orgValue, "*" }), this._planDescription, this._effectiveDate, this._expirationDate, this._displayOrder } };
/*  63 */     return insertParameterObject;
/*     */   }
/*     */   
/*  66 */   private static final int[][] INSERT_PARAMETER_TYPES_OBJECT = new int[][] { { -5, 12, 12, 91, 12, 91, 12, 12, 12, 12, 91, 91, 4 } };
/*     */   
/*     */   public int[][] getInsertParameterTypes() {
/*  69 */     return INSERT_PARAMETER_TYPES_OBJECT;
/*     */   }
/*     */   
/*  72 */   private static final String[] UPDATE_OBJECT = new String[] { "UPDATE cat_cust_acct_plan SET update_date = ?, update_user_id = ?, org_code = ?, org_value = ?, plan_description = ?, effective_date = ?, expiration_date = ?, display_order = ?" };
/*     */   
/*     */   public String[] getUpdate() {
/*  75 */     return UPDATE_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getUpdateParameters() {
/*  79 */     Object[][] updateParameterObject = { { this._updateDate, this._updateUserId, this._orgCode, this._orgValue, this._planDescription, this._effectiveDate, this._expirationDate, this._displayOrder } };
/*  80 */     return updateParameterObject;
/*     */   }
/*     */   
/*  83 */   private static final int[][] UPDATE_PARAMETER_TYPE_OBJECT = new int[][] { { 91, 12, 12, 12, 12, 91, 91, 4 } };
/*     */   public int[][] getUpdateParameterTypes() {
/*  85 */     return UPDATE_PARAMETER_TYPE_OBJECT;
/*     */   }
/*     */   
/*  88 */   private static final String[] DELETE_OBJECT = new String[] { "DELETE FROM cat_cust_acct_plan" }; private static final String WHERE_OBJECT = " WHERE organization_id = ?  AND cust_acct_code = ?  AND plan_id = ?  ";
/*     */   
/*     */   public String[] getDelete() {
/*  91 */     return DELETE_OBJECT;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWhere() {
/*  97 */     return " WHERE organization_id = ?  AND cust_acct_code = ?  AND plan_id = ?  ";
/*     */   }
/*     */   public Object[] getWhereParameters() {
/* 100 */     return new Object[] { this._organizationId, this._custAccountCode, this._planId };
/*     */   }
/*     */   
/* 103 */   private static final int[] WHERE_PARAMETER_OBJECT = new int[] { -5, 12, 12 };
/*     */   
/*     */   public int[] getWhereParameterTypes() {
/* 106 */     return WHERE_PARAMETER_OBJECT;
/*     */   }
/*     */   public String getTableName() {
/* 109 */     return "cat_cust_acct_plan";
/*     */   }
/*     */   
/*     */   public IFiller getFiller() {
/* 113 */     return getFillerImpl();
/*     */   }
/*     */   
/*     */   private IFiller getFillerImpl() {
/* 117 */     return new CustomerAccountPlanFiller(this);
/*     */   }
/*     */   
/*     */   private static class CustomerAccountPlanFiller
/*     */     implements IFiller {
/*     */     private CustomerAccountPlanDBA _parent;
/*     */     
/*     */     public CustomerAccountPlanFiller(CustomerAccountPlanDBA argParent) {
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
/* 136 */       this._parent._custAccountCode = argResultSet.getString(2);
/* 137 */       this._parent._planId = argResultSet.getString(3);
/*     */       
/* 139 */       Timestamp t4 = argResultSet.getTimestamp(4);
/* 140 */       if (t4 != null) {
/* 141 */         this._parent._createDate = (Date)new DtvDate(t4.getTime());
/*     */       } else {
/*     */         
/* 144 */         this._parent._createDate = null;
/*     */       } 
/*     */       
/* 147 */       this._parent._createUserId = argResultSet.getString(5);
/*     */       
/* 149 */       Timestamp t6 = argResultSet.getTimestamp(6);
/* 150 */       if (t6 != null) {
/* 151 */         this._parent._updateDate = (Date)new DtvDate(t6.getTime());
/*     */       } else {
/*     */         
/* 154 */         this._parent._updateDate = null;
/*     */       } 
/*     */       
/* 157 */       this._parent._updateUserId = argResultSet.getString(7);
/* 158 */       this._parent._orgCode = argResultSet.getString(8);
/* 159 */       this._parent._orgValue = argResultSet.getString(9);
/* 160 */       this._parent._planDescription = argResultSet.getString(10);
/*     */       
/* 162 */       Timestamp t11 = argResultSet.getTimestamp(11);
/* 163 */       if (t11 != null) {
/* 164 */         this._parent._effectiveDate = (Date)new DtvDate(t11.getTime());
/*     */       } else {
/*     */         
/* 167 */         this._parent._effectiveDate = null;
/*     */       } 
/*     */ 
/*     */       
/* 171 */       Timestamp t12 = argResultSet.getTimestamp(12);
/* 172 */       if (t12 != null) {
/* 173 */         this._parent._expirationDate = (Date)new DtvDate(t12.getTime());
/*     */       } else {
/*     */         
/* 176 */         this._parent._expirationDate = null;
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/* 181 */       int i = argResultSet.getInt(13);
/* 182 */       if (i != 0 || argResultSet.getObject(13) != null) {
/* 183 */         this._parent._displayOrder = Integer.valueOf(i);
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IDataAccessObject loadDAO(IDataAccessObject argDAO) {
/* 191 */     argDAO.suppressStateChanges(true);
/* 192 */     CustomerAccountPlanDAO dao = (CustomerAccountPlanDAO)argDAO;
/* 193 */     dao.setOrganizationId(this._organizationId);
/* 194 */     dao.setCustAccountCode(this._custAccountCode);
/* 195 */     dao.setPlanId(this._planId);
/* 196 */     dao.setCreateDate(this._createDate);
/* 197 */     dao.setCreateUserId(this._createUserId);
/* 198 */     dao.setUpdateDate(this._updateDate);
/* 199 */     dao.setUpdateUserId(this._updateUserId);
/* 200 */     dao.setOrgCode(this._orgCode);
/* 201 */     dao.setOrgValue(this._orgValue);
/* 202 */     dao.setPlanDescription(this._planDescription);
/* 203 */     dao.setEffectiveDate(this._effectiveDate);
/* 204 */     dao.setExpirationDate(this._expirationDate);
/* 205 */     dao.setDisplayOrder(this._displayOrder);
/* 206 */     argDAO.suppressStateChanges(false);
/* 207 */     return (IDataAccessObject)dao;
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDefaultDAO() {
/* 211 */     return loadDAO((IDataAccessObject)new CustomerAccountPlanDAO());
/*     */   }
/*     */   
/*     */   public void fill(IDataAccessObject argDAO) {
/* 215 */     CustomerAccountPlanDAO dao = (CustomerAccountPlanDAO)argDAO;
/* 216 */     this._organizationId = dao.getOrganizationId();
/* 217 */     this._custAccountCode = dao.getCustAccountCode();
/* 218 */     this._planId = dao.getPlanId();
/* 219 */     this._createDate = dao.getCreateDate();
/* 220 */     this._createUserId = dao.getCreateUserId();
/* 221 */     this._updateDate = dao.getUpdateDate();
/* 222 */     this._updateUserId = dao.getUpdateUserId();
/* 223 */     this._orgCode = dao.getOrgCode();
/* 224 */     this._orgValue = dao.getOrgValue();
/* 225 */     this._planDescription = dao.getPlanDescription();
/* 226 */     this._effectiveDate = dao.getEffectiveDate();
/* 227 */     this._expirationDate = dao.getExpirationDate();
/* 228 */     this._displayOrder = dao.getDisplayOrder();
/*     */   }
/*     */   
/*     */   public PreparedStatement writeObjectId(IObjectId argId, PreparedStatement argStatement) throws SQLException {
/* 232 */     CustomerAccountPlanId id = (CustomerAccountPlanId)argId;
/* 233 */     argStatement.setLong(1, id.getOrganizationId().longValue());
/* 234 */     argStatement.setString(2, id.getCustAccountCode());
/* 235 */     argStatement.setString(3, id.getPlanId());
/* 236 */     return argStatement;
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 240 */     CustomerAccountPlanId id = new CustomerAccountPlanId();
/* 241 */     id.setOrganizationId(this._organizationId);
/* 242 */     id.setCustAccountCode(this._custAccountCode);
/* 243 */     id.setPlanId(this._planId);
/* 244 */     return (IObjectId)id;
/*     */   }
/*     */ 
/*     */   
/*     */   public void fill(IJDBCTableAdapter argAdapter) {}
/*     */ 
/*     */   
/*     */   public boolean isExtensible() {
/* 252 */     return false;
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 256 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\cat\impl\CustomerAccountPlanDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */