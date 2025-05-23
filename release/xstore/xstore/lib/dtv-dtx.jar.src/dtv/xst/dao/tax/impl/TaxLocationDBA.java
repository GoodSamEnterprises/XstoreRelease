/*     */ package dtv.xst.dao.tax.impl;
/*     */ 
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.impl.jdbc.IFiller;
/*     */ import dtv.data2.access.impl.jdbc.IJDBCTableAdapter;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.util.ObjectUtils;
/*     */ import dtv.xst.dao.tax.TaxLocationId;
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
/*     */ public class TaxLocationDBA
/*     */   implements IJDBCTableAdapter
/*     */ {
/*     */   private static final long serialVersionUID = 1612484704L;
/*     */   private Long _organizationId;
/*     */   private String _taxLocationId;
/*     */   private Date _createDate;
/*     */   private String _createUserId;
/*     */   private Date _updateDate;
/*     */   private String _updateUserId;
/*     */   private String _orgCode;
/*     */   private String _orgValue;
/*     */   private String _description;
/*     */   private String _name;
/*     */   private String _externalSystem;
/*     */   private static final String SELECT_OBJECT = "SELECT t.organization_id, t.tax_loc_id, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.org_code, t.org_value, t.description, t.name, t.external_system FROM tax_tax_loc t";
/*     */   private static final String SELECT_WHERE_OBJECT = " WHERE organization_id = ?  AND tax_loc_id = ?  ";
/*     */   
/*     */   public String getSelect() {
/*  40 */     return getSelectImpl();
/*     */   }
/*     */   
/*     */   private String getSelectImpl() {
/*  44 */     return "SELECT t.organization_id, t.tax_loc_id, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.org_code, t.org_value, t.description, t.name, t.external_system FROM tax_tax_loc t";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectWhere() {
/*  50 */     return " WHERE organization_id = ?  AND tax_loc_id = ?  ";
/*     */   }
/*     */   
/*  53 */   private static final String[] INSERT_OBJECT = new String[] { "INSERT INTO tax_tax_loc(organization_id, tax_loc_id, create_date, create_user_id, update_date, update_user_id, org_code, org_value, description, name, external_system) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" };
/*     */   
/*     */   public String[] getInsert() {
/*  56 */     return INSERT_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getInsertParameters() {
/*  60 */     Object[][] insertParameterObject = { { this._organizationId, this._taxLocationId, this._createDate, this._createUserId, this._updateDate, this._updateUserId, ObjectUtils.coalesce((Object[])new String[] { this._orgCode, "*" }), ObjectUtils.coalesce((Object[])new String[] { this._orgValue, "*" }), this._description, this._name, this._externalSystem } };
/*  61 */     return insertParameterObject;
/*     */   }
/*     */   
/*  64 */   private static final int[][] INSERT_PARAMETER_TYPES_OBJECT = new int[][] { { -5, 12, 91, 12, 91, 12, 12, 12, 12, 12, 12 } };
/*     */   
/*     */   public int[][] getInsertParameterTypes() {
/*  67 */     return INSERT_PARAMETER_TYPES_OBJECT;
/*     */   }
/*     */   
/*  70 */   private static final String[] UPDATE_OBJECT = new String[] { "UPDATE tax_tax_loc SET update_date = ?, update_user_id = ?, org_code = ?, org_value = ?, description = ?, name = ?, external_system = ?" };
/*     */   
/*     */   public String[] getUpdate() {
/*  73 */     return UPDATE_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getUpdateParameters() {
/*  77 */     Object[][] updateParameterObject = { { this._updateDate, this._updateUserId, this._orgCode, this._orgValue, this._description, this._name, this._externalSystem } };
/*  78 */     return updateParameterObject;
/*     */   }
/*     */   
/*  81 */   private static final int[][] UPDATE_PARAMETER_TYPE_OBJECT = new int[][] { { 91, 12, 12, 12, 12, 12, 12 } };
/*     */   public int[][] getUpdateParameterTypes() {
/*  83 */     return UPDATE_PARAMETER_TYPE_OBJECT;
/*     */   }
/*     */   
/*  86 */   private static final String[] DELETE_OBJECT = new String[] { "DELETE FROM tax_tax_loc" }; private static final String WHERE_OBJECT = " WHERE organization_id = ?  AND tax_loc_id = ?  ";
/*     */   
/*     */   public String[] getDelete() {
/*  89 */     return DELETE_OBJECT;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWhere() {
/*  95 */     return " WHERE organization_id = ?  AND tax_loc_id = ?  ";
/*     */   }
/*     */   public Object[] getWhereParameters() {
/*  98 */     return new Object[] { this._organizationId, this._taxLocationId };
/*     */   }
/*     */   
/* 101 */   private static final int[] WHERE_PARAMETER_OBJECT = new int[] { -5, 12 };
/*     */   
/*     */   public int[] getWhereParameterTypes() {
/* 104 */     return WHERE_PARAMETER_OBJECT;
/*     */   }
/*     */   public String getTableName() {
/* 107 */     return "tax_tax_loc";
/*     */   }
/*     */   
/*     */   public IFiller getFiller() {
/* 111 */     return getFillerImpl();
/*     */   }
/*     */   
/*     */   private IFiller getFillerImpl() {
/* 115 */     return new TaxLocationFiller(this);
/*     */   }
/*     */   
/*     */   private static class TaxLocationFiller
/*     */     implements IFiller {
/*     */     private TaxLocationDBA _parent;
/*     */     
/*     */     public TaxLocationFiller(TaxLocationDBA argParent) {
/* 123 */       this._parent = argParent;
/*     */     }
/*     */ 
/*     */     
/*     */     public void fill(ResultSet argResultSet) throws SQLException {
/* 128 */       long primitiveResult = argResultSet.getLong(1);
/* 129 */       if (primitiveResult != 0L || argResultSet.getObject(1) != null) {
/* 130 */         this._parent._organizationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */       
/* 134 */       this._parent._taxLocationId = argResultSet.getString(2);
/*     */       
/* 136 */       Timestamp t3 = argResultSet.getTimestamp(3);
/* 137 */       if (t3 != null) {
/* 138 */         this._parent._createDate = (Date)new DtvDate(t3.getTime());
/*     */       } else {
/*     */         
/* 141 */         this._parent._createDate = null;
/*     */       } 
/*     */       
/* 144 */       this._parent._createUserId = argResultSet.getString(4);
/*     */       
/* 146 */       Timestamp t5 = argResultSet.getTimestamp(5);
/* 147 */       if (t5 != null) {
/* 148 */         this._parent._updateDate = (Date)new DtvDate(t5.getTime());
/*     */       } else {
/*     */         
/* 151 */         this._parent._updateDate = null;
/*     */       } 
/*     */       
/* 154 */       this._parent._updateUserId = argResultSet.getString(6);
/* 155 */       this._parent._orgCode = argResultSet.getString(7);
/* 156 */       this._parent._orgValue = argResultSet.getString(8);
/* 157 */       this._parent._description = argResultSet.getString(9);
/* 158 */       this._parent._name = argResultSet.getString(10);
/* 159 */       this._parent._externalSystem = argResultSet.getString(11);
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDAO(IDataAccessObject argDAO) {
/* 164 */     argDAO.suppressStateChanges(true);
/* 165 */     TaxLocationDAO dao = (TaxLocationDAO)argDAO;
/* 166 */     dao.setOrganizationId(this._organizationId);
/* 167 */     dao.setTaxLocationId(this._taxLocationId);
/* 168 */     dao.setCreateDate(this._createDate);
/* 169 */     dao.setCreateUserId(this._createUserId);
/* 170 */     dao.setUpdateDate(this._updateDate);
/* 171 */     dao.setUpdateUserId(this._updateUserId);
/* 172 */     dao.setOrgCode(this._orgCode);
/* 173 */     dao.setOrgValue(this._orgValue);
/* 174 */     dao.setDescription(this._description);
/* 175 */     dao.setName(this._name);
/* 176 */     dao.setExternalSystem(this._externalSystem);
/* 177 */     argDAO.suppressStateChanges(false);
/* 178 */     return (IDataAccessObject)dao;
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDefaultDAO() {
/* 182 */     return loadDAO((IDataAccessObject)new TaxLocationDAO());
/*     */   }
/*     */   
/*     */   public void fill(IDataAccessObject argDAO) {
/* 186 */     TaxLocationDAO dao = (TaxLocationDAO)argDAO;
/* 187 */     this._organizationId = dao.getOrganizationId();
/* 188 */     this._taxLocationId = dao.getTaxLocationId();
/* 189 */     this._createDate = dao.getCreateDate();
/* 190 */     this._createUserId = dao.getCreateUserId();
/* 191 */     this._updateDate = dao.getUpdateDate();
/* 192 */     this._updateUserId = dao.getUpdateUserId();
/* 193 */     this._orgCode = dao.getOrgCode();
/* 194 */     this._orgValue = dao.getOrgValue();
/* 195 */     this._description = dao.getDescription();
/* 196 */     this._name = dao.getName();
/* 197 */     this._externalSystem = dao.getExternalSystem();
/*     */   }
/*     */   
/*     */   public PreparedStatement writeObjectId(IObjectId argId, PreparedStatement argStatement) throws SQLException {
/* 201 */     TaxLocationId id = (TaxLocationId)argId;
/* 202 */     argStatement.setLong(1, id.getOrganizationId().longValue());
/* 203 */     argStatement.setString(2, id.getTaxLocationId());
/* 204 */     return argStatement;
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 208 */     TaxLocationId id = new TaxLocationId();
/* 209 */     id.setOrganizationId(this._organizationId);
/* 210 */     id.setTaxLocationId(this._taxLocationId);
/* 211 */     return (IObjectId)id;
/*     */   }
/*     */ 
/*     */   
/*     */   public void fill(IJDBCTableAdapter argAdapter) {}
/*     */ 
/*     */   
/*     */   public boolean isExtensible() {
/* 219 */     return false;
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 223 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\tax\impl\TaxLocationDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */