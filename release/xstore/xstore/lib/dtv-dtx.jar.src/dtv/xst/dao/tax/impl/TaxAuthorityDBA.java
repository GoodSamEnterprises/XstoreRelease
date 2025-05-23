/*     */ package dtv.xst.dao.tax.impl;
/*     */ 
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.impl.jdbc.IFiller;
/*     */ import dtv.data2.access.impl.jdbc.IJDBCTableAdapter;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.util.ObjectUtils;
/*     */ import dtv.xst.dao.tax.TaxAuthorityId;
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
/*     */ public class TaxAuthorityDBA
/*     */   implements IJDBCTableAdapter
/*     */ {
/*     */   private static final long serialVersionUID = 1120218104L;
/*     */   private Long _organizationId;
/*     */   private String _taxAuthorityId;
/*     */   private Date _createDate;
/*     */   private String _createUserId;
/*     */   private Date _updateDate;
/*     */   private String _updateUserId;
/*     */   private String _orgCode;
/*     */   private String _orgValue;
/*     */   private String _name;
/*     */   private String _roundingCode;
/*     */   private Integer _roundingDigitsQuantity;
/*     */   private String _externalSystem;
/*     */   private static final String SELECT_OBJECT = "SELECT t.organization_id, t.tax_authority_id, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.org_code, t.org_value, t.name, t.rounding_code, t.rounding_digits_quantity, t.external_system FROM tax_tax_authority t";
/*     */   private static final String SELECT_WHERE_OBJECT = " WHERE organization_id = ?  AND tax_authority_id = ?  ";
/*     */   
/*     */   public String getSelect() {
/*  41 */     return getSelectImpl();
/*     */   }
/*     */   
/*     */   private String getSelectImpl() {
/*  45 */     return "SELECT t.organization_id, t.tax_authority_id, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.org_code, t.org_value, t.name, t.rounding_code, t.rounding_digits_quantity, t.external_system FROM tax_tax_authority t";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectWhere() {
/*  51 */     return " WHERE organization_id = ?  AND tax_authority_id = ?  ";
/*     */   }
/*     */   
/*  54 */   private static final String[] INSERT_OBJECT = new String[] { "INSERT INTO tax_tax_authority(organization_id, tax_authority_id, create_date, create_user_id, update_date, update_user_id, org_code, org_value, name, rounding_code, rounding_digits_quantity, external_system) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" };
/*     */   
/*     */   public String[] getInsert() {
/*  57 */     return INSERT_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getInsertParameters() {
/*  61 */     Object[][] insertParameterObject = { { this._organizationId, this._taxAuthorityId, this._createDate, this._createUserId, this._updateDate, this._updateUserId, ObjectUtils.coalesce((Object[])new String[] { this._orgCode, "*" }), ObjectUtils.coalesce((Object[])new String[] { this._orgValue, "*" }), this._name, this._roundingCode, this._roundingDigitsQuantity, this._externalSystem } };
/*  62 */     return insertParameterObject;
/*     */   }
/*     */   
/*  65 */   private static final int[][] INSERT_PARAMETER_TYPES_OBJECT = new int[][] { { -5, 12, 91, 12, 91, 12, 12, 12, 12, 12, 4, 12 } };
/*     */   
/*     */   public int[][] getInsertParameterTypes() {
/*  68 */     return INSERT_PARAMETER_TYPES_OBJECT;
/*     */   }
/*     */   
/*  71 */   private static final String[] UPDATE_OBJECT = new String[] { "UPDATE tax_tax_authority SET update_date = ?, update_user_id = ?, org_code = ?, org_value = ?, name = ?, rounding_code = ?, rounding_digits_quantity = ?, external_system = ?" };
/*     */   
/*     */   public String[] getUpdate() {
/*  74 */     return UPDATE_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getUpdateParameters() {
/*  78 */     Object[][] updateParameterObject = { { this._updateDate, this._updateUserId, this._orgCode, this._orgValue, this._name, this._roundingCode, this._roundingDigitsQuantity, this._externalSystem } };
/*  79 */     return updateParameterObject;
/*     */   }
/*     */   
/*  82 */   private static final int[][] UPDATE_PARAMETER_TYPE_OBJECT = new int[][] { { 91, 12, 12, 12, 12, 12, 4, 12 } };
/*     */   public int[][] getUpdateParameterTypes() {
/*  84 */     return UPDATE_PARAMETER_TYPE_OBJECT;
/*     */   }
/*     */   
/*  87 */   private static final String[] DELETE_OBJECT = new String[] { "DELETE FROM tax_tax_authority" }; private static final String WHERE_OBJECT = " WHERE organization_id = ?  AND tax_authority_id = ?  ";
/*     */   
/*     */   public String[] getDelete() {
/*  90 */     return DELETE_OBJECT;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWhere() {
/*  96 */     return " WHERE organization_id = ?  AND tax_authority_id = ?  ";
/*     */   }
/*     */   public Object[] getWhereParameters() {
/*  99 */     return new Object[] { this._organizationId, this._taxAuthorityId };
/*     */   }
/*     */   
/* 102 */   private static final int[] WHERE_PARAMETER_OBJECT = new int[] { -5, 12 };
/*     */   
/*     */   public int[] getWhereParameterTypes() {
/* 105 */     return WHERE_PARAMETER_OBJECT;
/*     */   }
/*     */   public String getTableName() {
/* 108 */     return "tax_tax_authority";
/*     */   }
/*     */   
/*     */   public IFiller getFiller() {
/* 112 */     return getFillerImpl();
/*     */   }
/*     */   
/*     */   private IFiller getFillerImpl() {
/* 116 */     return new TaxAuthorityFiller(this);
/*     */   }
/*     */   
/*     */   private static class TaxAuthorityFiller
/*     */     implements IFiller {
/*     */     private TaxAuthorityDBA _parent;
/*     */     
/*     */     public TaxAuthorityFiller(TaxAuthorityDBA argParent) {
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
/* 135 */       this._parent._taxAuthorityId = argResultSet.getString(2);
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
/* 158 */       this._parent._name = argResultSet.getString(9);
/* 159 */       this._parent._roundingCode = argResultSet.getString(10);
/*     */ 
/*     */       
/* 162 */       int i = argResultSet.getInt(11);
/* 163 */       if (i != 0 || argResultSet.getObject(11) != null) {
/* 164 */         this._parent._roundingDigitsQuantity = Integer.valueOf(i);
/*     */       }
/*     */ 
/*     */       
/* 168 */       this._parent._externalSystem = argResultSet.getString(12);
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDAO(IDataAccessObject argDAO) {
/* 173 */     argDAO.suppressStateChanges(true);
/* 174 */     TaxAuthorityDAO dao = (TaxAuthorityDAO)argDAO;
/* 175 */     dao.setOrganizationId(this._organizationId);
/* 176 */     dao.setTaxAuthorityId(this._taxAuthorityId);
/* 177 */     dao.setCreateDate(this._createDate);
/* 178 */     dao.setCreateUserId(this._createUserId);
/* 179 */     dao.setUpdateDate(this._updateDate);
/* 180 */     dao.setUpdateUserId(this._updateUserId);
/* 181 */     dao.setOrgCode(this._orgCode);
/* 182 */     dao.setOrgValue(this._orgValue);
/* 183 */     dao.setName(this._name);
/* 184 */     dao.setRoundingCode(this._roundingCode);
/* 185 */     dao.setRoundingDigitsQuantity(this._roundingDigitsQuantity);
/* 186 */     dao.setExternalSystem(this._externalSystem);
/* 187 */     argDAO.suppressStateChanges(false);
/* 188 */     return (IDataAccessObject)dao;
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDefaultDAO() {
/* 192 */     return loadDAO((IDataAccessObject)new TaxAuthorityDAO());
/*     */   }
/*     */   
/*     */   public void fill(IDataAccessObject argDAO) {
/* 196 */     TaxAuthorityDAO dao = (TaxAuthorityDAO)argDAO;
/* 197 */     this._organizationId = dao.getOrganizationId();
/* 198 */     this._taxAuthorityId = dao.getTaxAuthorityId();
/* 199 */     this._createDate = dao.getCreateDate();
/* 200 */     this._createUserId = dao.getCreateUserId();
/* 201 */     this._updateDate = dao.getUpdateDate();
/* 202 */     this._updateUserId = dao.getUpdateUserId();
/* 203 */     this._orgCode = dao.getOrgCode();
/* 204 */     this._orgValue = dao.getOrgValue();
/* 205 */     this._name = dao.getName();
/* 206 */     this._roundingCode = dao.getRoundingCode();
/* 207 */     this._roundingDigitsQuantity = dao.getRoundingDigitsQuantity();
/* 208 */     this._externalSystem = dao.getExternalSystem();
/*     */   }
/*     */   
/*     */   public PreparedStatement writeObjectId(IObjectId argId, PreparedStatement argStatement) throws SQLException {
/* 212 */     TaxAuthorityId id = (TaxAuthorityId)argId;
/* 213 */     argStatement.setLong(1, id.getOrganizationId().longValue());
/* 214 */     argStatement.setString(2, id.getTaxAuthorityId());
/* 215 */     return argStatement;
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 219 */     TaxAuthorityId id = new TaxAuthorityId();
/* 220 */     id.setOrganizationId(this._organizationId);
/* 221 */     id.setTaxAuthorityId(this._taxAuthorityId);
/* 222 */     return (IObjectId)id;
/*     */   }
/*     */ 
/*     */   
/*     */   public void fill(IJDBCTableAdapter argAdapter) {}
/*     */ 
/*     */   
/*     */   public boolean isExtensible() {
/* 230 */     return false;
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 234 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\tax\impl\TaxAuthorityDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */