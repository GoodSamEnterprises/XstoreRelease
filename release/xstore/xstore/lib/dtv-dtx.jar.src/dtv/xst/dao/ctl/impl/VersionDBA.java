/*     */ package dtv.xst.dao.ctl.impl;
/*     */ 
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.impl.jdbc.IFiller;
/*     */ import dtv.data2.access.impl.jdbc.IJDBCTableAdapter;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.ctl.VersionId;
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
/*     */ public class VersionDBA
/*     */   implements IJDBCTableAdapter
/*     */ {
/*     */   private static final long serialVersionUID = 2016261304L;
/*     */   private Long _organizationId;
/*     */   private Date _createDate;
/*     */   private String _createUserId;
/*     */   private Date _updateDate;
/*     */   private String _updateUserId;
/*     */   private String _baseSchemaVersion;
/*     */   private String _customerSchemaVersion;
/*     */   private String _customer;
/*     */   private Date _baseSchemaDate;
/*     */   private Date _customerSchemaDate;
/*     */   private static final String SELECT_OBJECT = "SELECT t.organization_id, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.base_schema_version, t.customer_schema_version, t.customer, t.base_schema_date, t.customer_schema_date FROM ctl_version_history t";
/*     */   private static final String SELECT_WHERE_OBJECT = " WHERE organization_id = ?  ";
/*     */   
/*     */   public String getSelect() {
/*  39 */     return getSelectImpl();
/*     */   }
/*     */   
/*     */   private String getSelectImpl() {
/*  43 */     return "SELECT t.organization_id, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.base_schema_version, t.customer_schema_version, t.customer, t.base_schema_date, t.customer_schema_date FROM ctl_version_history t";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectWhere() {
/*  49 */     return " WHERE organization_id = ?  ";
/*     */   }
/*     */   
/*  52 */   private static final String[] INSERT_OBJECT = new String[] { "INSERT INTO ctl_version_history(organization_id, create_date, create_user_id, update_date, update_user_id, base_schema_version, customer_schema_version, customer, base_schema_date, customer_schema_date) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" };
/*     */   
/*     */   public String[] getInsert() {
/*  55 */     return INSERT_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getInsertParameters() {
/*  59 */     Object[][] insertParameterObject = { { this._organizationId, this._createDate, this._createUserId, this._updateDate, this._updateUserId, this._baseSchemaVersion, this._customerSchemaVersion, this._customer, this._baseSchemaDate, this._customerSchemaDate } };
/*  60 */     return insertParameterObject;
/*     */   }
/*     */   
/*  63 */   private static final int[][] INSERT_PARAMETER_TYPES_OBJECT = new int[][] { { -5, 91, 12, 91, 12, 12, 12, 12, 91, 91 } };
/*     */   
/*     */   public int[][] getInsertParameterTypes() {
/*  66 */     return INSERT_PARAMETER_TYPES_OBJECT;
/*     */   }
/*     */   
/*  69 */   private static final String[] UPDATE_OBJECT = new String[] { "UPDATE ctl_version_history SET update_date = ?, update_user_id = ?, base_schema_version = ?, customer_schema_version = ?, customer = ?, base_schema_date = ?, customer_schema_date = ?" };
/*     */   
/*     */   public String[] getUpdate() {
/*  72 */     return UPDATE_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getUpdateParameters() {
/*  76 */     Object[][] updateParameterObject = { { this._updateDate, this._updateUserId, this._baseSchemaVersion, this._customerSchemaVersion, this._customer, this._baseSchemaDate, this._customerSchemaDate } };
/*  77 */     return updateParameterObject;
/*     */   }
/*     */   
/*  80 */   private static final int[][] UPDATE_PARAMETER_TYPE_OBJECT = new int[][] { { 91, 12, 12, 12, 12, 91, 91 } };
/*     */   public int[][] getUpdateParameterTypes() {
/*  82 */     return UPDATE_PARAMETER_TYPE_OBJECT;
/*     */   }
/*     */   
/*  85 */   private static final String[] DELETE_OBJECT = new String[] { "DELETE FROM ctl_version_history" }; private static final String WHERE_OBJECT = " WHERE organization_id = ?  ";
/*     */   
/*     */   public String[] getDelete() {
/*  88 */     return DELETE_OBJECT;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWhere() {
/*  94 */     return " WHERE organization_id = ?  ";
/*     */   }
/*     */   public Object[] getWhereParameters() {
/*  97 */     return new Object[] { this._organizationId };
/*     */   }
/*     */   
/* 100 */   private static final int[] WHERE_PARAMETER_OBJECT = new int[] { -5 };
/*     */   
/*     */   public int[] getWhereParameterTypes() {
/* 103 */     return WHERE_PARAMETER_OBJECT;
/*     */   }
/*     */   public String getTableName() {
/* 106 */     return "ctl_version_history";
/*     */   }
/*     */   
/*     */   public IFiller getFiller() {
/* 110 */     return getFillerImpl();
/*     */   }
/*     */   
/*     */   private IFiller getFillerImpl() {
/* 114 */     return new VersionFiller(this);
/*     */   }
/*     */   
/*     */   private static class VersionFiller
/*     */     implements IFiller {
/*     */     private VersionDBA _parent;
/*     */     
/*     */     public VersionFiller(VersionDBA argParent) {
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
/*     */       
/* 134 */       Timestamp t2 = argResultSet.getTimestamp(2);
/* 135 */       if (t2 != null) {
/* 136 */         this._parent._createDate = (Date)new DtvDate(t2.getTime());
/*     */       } else {
/*     */         
/* 139 */         this._parent._createDate = null;
/*     */       } 
/*     */       
/* 142 */       this._parent._createUserId = argResultSet.getString(3);
/*     */       
/* 144 */       Timestamp t4 = argResultSet.getTimestamp(4);
/* 145 */       if (t4 != null) {
/* 146 */         this._parent._updateDate = (Date)new DtvDate(t4.getTime());
/*     */       } else {
/*     */         
/* 149 */         this._parent._updateDate = null;
/*     */       } 
/*     */       
/* 152 */       this._parent._updateUserId = argResultSet.getString(5);
/* 153 */       this._parent._baseSchemaVersion = argResultSet.getString(6);
/* 154 */       this._parent._customerSchemaVersion = argResultSet.getString(7);
/* 155 */       this._parent._customer = argResultSet.getString(8);
/*     */       
/* 157 */       Timestamp t9 = argResultSet.getTimestamp(9);
/* 158 */       if (t9 != null) {
/* 159 */         this._parent._baseSchemaDate = (Date)new DtvDate(t9.getTime());
/*     */       } else {
/*     */         
/* 162 */         this._parent._baseSchemaDate = null;
/*     */       } 
/*     */ 
/*     */       
/* 166 */       Timestamp t10 = argResultSet.getTimestamp(10);
/* 167 */       if (t10 != null) {
/* 168 */         this._parent._customerSchemaDate = (Date)new DtvDate(t10.getTime());
/*     */       } else {
/*     */         
/* 171 */         this._parent._customerSchemaDate = null;
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public IDataAccessObject loadDAO(IDataAccessObject argDAO) {
/* 178 */     argDAO.suppressStateChanges(true);
/* 179 */     VersionDAO dao = (VersionDAO)argDAO;
/* 180 */     dao.setOrganizationId(this._organizationId);
/* 181 */     dao.setCreateDate(this._createDate);
/* 182 */     dao.setCreateUserId(this._createUserId);
/* 183 */     dao.setUpdateDate(this._updateDate);
/* 184 */     dao.setUpdateUserId(this._updateUserId);
/* 185 */     dao.setBaseSchemaVersion(this._baseSchemaVersion);
/* 186 */     dao.setCustomerSchemaVersion(this._customerSchemaVersion);
/* 187 */     dao.setCustomer(this._customer);
/* 188 */     dao.setBaseSchemaDate(this._baseSchemaDate);
/* 189 */     dao.setCustomerSchemaDate(this._customerSchemaDate);
/* 190 */     argDAO.suppressStateChanges(false);
/* 191 */     return (IDataAccessObject)dao;
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDefaultDAO() {
/* 195 */     return loadDAO((IDataAccessObject)new VersionDAO());
/*     */   }
/*     */   
/*     */   public void fill(IDataAccessObject argDAO) {
/* 199 */     VersionDAO dao = (VersionDAO)argDAO;
/* 200 */     this._organizationId = dao.getOrganizationId();
/* 201 */     this._createDate = dao.getCreateDate();
/* 202 */     this._createUserId = dao.getCreateUserId();
/* 203 */     this._updateDate = dao.getUpdateDate();
/* 204 */     this._updateUserId = dao.getUpdateUserId();
/* 205 */     this._baseSchemaVersion = dao.getBaseSchemaVersion();
/* 206 */     this._customerSchemaVersion = dao.getCustomerSchemaVersion();
/* 207 */     this._customer = dao.getCustomer();
/* 208 */     this._baseSchemaDate = dao.getBaseSchemaDate();
/* 209 */     this._customerSchemaDate = dao.getCustomerSchemaDate();
/*     */   }
/*     */   
/*     */   public PreparedStatement writeObjectId(IObjectId argId, PreparedStatement argStatement) throws SQLException {
/* 213 */     VersionId id = (VersionId)argId;
/* 214 */     argStatement.setLong(1, id.getOrganizationId().longValue());
/* 215 */     return argStatement;
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 219 */     VersionId id = new VersionId();
/* 220 */     id.setOrganizationId(this._organizationId);
/* 221 */     return (IObjectId)id;
/*     */   }
/*     */ 
/*     */   
/*     */   public void fill(IJDBCTableAdapter argAdapter) {}
/*     */ 
/*     */   
/*     */   public boolean isExtensible() {
/* 229 */     return false;
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 233 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\ctl\impl\VersionDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */