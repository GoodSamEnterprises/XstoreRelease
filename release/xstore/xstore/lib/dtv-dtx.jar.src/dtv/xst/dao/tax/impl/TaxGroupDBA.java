/*     */ package dtv.xst.dao.tax.impl;
/*     */ 
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.impl.jdbc.IFiller;
/*     */ import dtv.data2.access.impl.jdbc.IJDBCTableAdapter;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.util.ObjectUtils;
/*     */ import dtv.xst.dao.tax.TaxGroupId;
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
/*     */ public class TaxGroupDBA
/*     */   implements IJDBCTableAdapter
/*     */ {
/*     */   private static final long serialVersionUID = -234701388L;
/*     */   private Long _organizationId;
/*     */   private String _taxGroupId;
/*     */   private Date _createDate;
/*     */   private String _createUserId;
/*     */   private Date _updateDate;
/*     */   private String _updateUserId;
/*     */   private String _orgCode;
/*     */   private String _orgValue;
/*     */   private String _description;
/*     */   private String _name;
/*     */   private String _taxCodeId;
/*     */   private String _externalSystem;
/*     */   private static final String SELECT_OBJECT = "SELECT t.organization_id, t.tax_group_id, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.org_code, t.org_value, t.description, t.name, t.tax_code_id, t.external_system FROM tax_tax_group t";
/*     */   private static final String SELECT_WHERE_OBJECT = " WHERE organization_id = ?  AND tax_group_id = ?  ";
/*     */   
/*     */   public String getSelect() {
/*  41 */     return getSelectImpl();
/*     */   }
/*     */   
/*     */   private String getSelectImpl() {
/*  45 */     return "SELECT t.organization_id, t.tax_group_id, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.org_code, t.org_value, t.description, t.name, t.tax_code_id, t.external_system FROM tax_tax_group t";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectWhere() {
/*  51 */     return " WHERE organization_id = ?  AND tax_group_id = ?  ";
/*     */   }
/*     */   
/*  54 */   private static final String[] INSERT_OBJECT = new String[] { "INSERT INTO tax_tax_group(organization_id, tax_group_id, create_date, create_user_id, update_date, update_user_id, org_code, org_value, description, name, tax_code_id, external_system) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" };
/*     */   
/*     */   public String[] getInsert() {
/*  57 */     return INSERT_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getInsertParameters() {
/*  61 */     Object[][] insertParameterObject = { { this._organizationId, this._taxGroupId, this._createDate, this._createUserId, this._updateDate, this._updateUserId, ObjectUtils.coalesce((Object[])new String[] { this._orgCode, "*" }), ObjectUtils.coalesce((Object[])new String[] { this._orgValue, "*" }), this._description, this._name, this._taxCodeId, this._externalSystem } };
/*  62 */     return insertParameterObject;
/*     */   }
/*     */   
/*  65 */   private static final int[][] INSERT_PARAMETER_TYPES_OBJECT = new int[][] { { -5, 12, 91, 12, 91, 12, 12, 12, 12, 12, 12, 12 } };
/*     */   
/*     */   public int[][] getInsertParameterTypes() {
/*  68 */     return INSERT_PARAMETER_TYPES_OBJECT;
/*     */   }
/*     */   
/*  71 */   private static final String[] UPDATE_OBJECT = new String[] { "UPDATE tax_tax_group SET update_date = ?, update_user_id = ?, org_code = ?, org_value = ?, description = ?, name = ?, tax_code_id = ?, external_system = ?" };
/*     */   
/*     */   public String[] getUpdate() {
/*  74 */     return UPDATE_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getUpdateParameters() {
/*  78 */     Object[][] updateParameterObject = { { this._updateDate, this._updateUserId, this._orgCode, this._orgValue, this._description, this._name, this._taxCodeId, this._externalSystem } };
/*  79 */     return updateParameterObject;
/*     */   }
/*     */   
/*  82 */   private static final int[][] UPDATE_PARAMETER_TYPE_OBJECT = new int[][] { { 91, 12, 12, 12, 12, 12, 12, 12 } };
/*     */   public int[][] getUpdateParameterTypes() {
/*  84 */     return UPDATE_PARAMETER_TYPE_OBJECT;
/*     */   }
/*     */   
/*  87 */   private static final String[] DELETE_OBJECT = new String[] { "DELETE FROM tax_tax_group" }; private static final String WHERE_OBJECT = " WHERE organization_id = ?  AND tax_group_id = ?  ";
/*     */   
/*     */   public String[] getDelete() {
/*  90 */     return DELETE_OBJECT;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWhere() {
/*  96 */     return " WHERE organization_id = ?  AND tax_group_id = ?  ";
/*     */   }
/*     */   public Object[] getWhereParameters() {
/*  99 */     return new Object[] { this._organizationId, this._taxGroupId };
/*     */   }
/*     */   
/* 102 */   private static final int[] WHERE_PARAMETER_OBJECT = new int[] { -5, 12 };
/*     */   
/*     */   public int[] getWhereParameterTypes() {
/* 105 */     return WHERE_PARAMETER_OBJECT;
/*     */   }
/*     */   public String getTableName() {
/* 108 */     return "tax_tax_group";
/*     */   }
/*     */   
/*     */   public IFiller getFiller() {
/* 112 */     return getFillerImpl();
/*     */   }
/*     */   
/*     */   private IFiller getFillerImpl() {
/* 116 */     return new TaxGroupFiller(this);
/*     */   }
/*     */   
/*     */   private static class TaxGroupFiller
/*     */     implements IFiller {
/*     */     private TaxGroupDBA _parent;
/*     */     
/*     */     public TaxGroupFiller(TaxGroupDBA argParent) {
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
/* 135 */       this._parent._taxGroupId = argResultSet.getString(2);
/*     */       
/* 137 */       Timestamp t3 = argResultSet.getTimestamp(3);
/* 138 */       if (t3 != null) {
/* 139 */         this._parent._createDate = (Date)new DtvDate(t3.getTime());
/*     */       } else {
/*     */         
/* 142 */         this._parent._createDate = null;
/*     */       } 
/*     */       
/* 145 */       this._parent._createUserId = argResultSet.getString(4);
/*     */       
/* 147 */       Timestamp t5 = argResultSet.getTimestamp(5);
/* 148 */       if (t5 != null) {
/* 149 */         this._parent._updateDate = (Date)new DtvDate(t5.getTime());
/*     */       } else {
/*     */         
/* 152 */         this._parent._updateDate = null;
/*     */       } 
/*     */       
/* 155 */       this._parent._updateUserId = argResultSet.getString(6);
/* 156 */       this._parent._orgCode = argResultSet.getString(7);
/* 157 */       this._parent._orgValue = argResultSet.getString(8);
/* 158 */       this._parent._description = argResultSet.getString(9);
/* 159 */       this._parent._name = argResultSet.getString(10);
/* 160 */       this._parent._taxCodeId = argResultSet.getString(11);
/* 161 */       this._parent._externalSystem = argResultSet.getString(12);
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDAO(IDataAccessObject argDAO) {
/* 166 */     argDAO.suppressStateChanges(true);
/* 167 */     TaxGroupDAO dao = (TaxGroupDAO)argDAO;
/* 168 */     dao.setOrganizationId(this._organizationId);
/* 169 */     dao.setTaxGroupId(this._taxGroupId);
/* 170 */     dao.setCreateDate(this._createDate);
/* 171 */     dao.setCreateUserId(this._createUserId);
/* 172 */     dao.setUpdateDate(this._updateDate);
/* 173 */     dao.setUpdateUserId(this._updateUserId);
/* 174 */     dao.setOrgCode(this._orgCode);
/* 175 */     dao.setOrgValue(this._orgValue);
/* 176 */     dao.setDescription(this._description);
/* 177 */     dao.setName(this._name);
/* 178 */     dao.setTaxCodeId(this._taxCodeId);
/* 179 */     dao.setExternalSystem(this._externalSystem);
/* 180 */     argDAO.suppressStateChanges(false);
/* 181 */     return (IDataAccessObject)dao;
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDefaultDAO() {
/* 185 */     return loadDAO((IDataAccessObject)new TaxGroupDAO());
/*     */   }
/*     */   
/*     */   public void fill(IDataAccessObject argDAO) {
/* 189 */     TaxGroupDAO dao = (TaxGroupDAO)argDAO;
/* 190 */     this._organizationId = dao.getOrganizationId();
/* 191 */     this._taxGroupId = dao.getTaxGroupId();
/* 192 */     this._createDate = dao.getCreateDate();
/* 193 */     this._createUserId = dao.getCreateUserId();
/* 194 */     this._updateDate = dao.getUpdateDate();
/* 195 */     this._updateUserId = dao.getUpdateUserId();
/* 196 */     this._orgCode = dao.getOrgCode();
/* 197 */     this._orgValue = dao.getOrgValue();
/* 198 */     this._description = dao.getDescription();
/* 199 */     this._name = dao.getName();
/* 200 */     this._taxCodeId = dao.getTaxCodeId();
/* 201 */     this._externalSystem = dao.getExternalSystem();
/*     */   }
/*     */   
/*     */   public PreparedStatement writeObjectId(IObjectId argId, PreparedStatement argStatement) throws SQLException {
/* 205 */     TaxGroupId id = (TaxGroupId)argId;
/* 206 */     argStatement.setLong(1, id.getOrganizationId().longValue());
/* 207 */     argStatement.setString(2, id.getTaxGroupId());
/* 208 */     return argStatement;
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 212 */     TaxGroupId id = new TaxGroupId();
/* 213 */     id.setOrganizationId(this._organizationId);
/* 214 */     id.setTaxGroupId(this._taxGroupId);
/* 215 */     return (IObjectId)id;
/*     */   }
/*     */ 
/*     */   
/*     */   public void fill(IJDBCTableAdapter argAdapter) {}
/*     */ 
/*     */   
/*     */   public boolean isExtensible() {
/* 223 */     return false;
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 227 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\tax\impl\TaxGroupDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */