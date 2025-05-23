/*     */ package dtv.xst.dao.cwo.impl;
/*     */ 
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.impl.jdbc.IFiller;
/*     */ import dtv.data2.access.impl.jdbc.IJDBCTableAdapter;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.util.ObjectUtils;
/*     */ import dtv.xst.dao.cwo.CategoryServiceLocationId;
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
/*     */ public class CategoryServiceLocationDBA
/*     */   implements IJDBCTableAdapter
/*     */ {
/*     */   private static final long serialVersionUID = 2138160268L;
/*     */   private Long _organizationId;
/*     */   private String _serviceLocationId;
/*     */   private String _categoryId;
/*     */   private Date _createDate;
/*     */   private String _createUserId;
/*     */   private Date _updateDate;
/*     */   private String _updateUserId;
/*     */   private String _orgCode;
/*     */   private String _orgValue;
/*     */   private BigDecimal _leadTimeQuantity;
/*     */   private String _leadTimeUnit;
/*     */   private Boolean _createShipment;
/*     */   private static final String SELECT_OBJECT = "SELECT t.organization_id, t.service_loc_id, t.category_id, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.org_code, t.org_value, t.lead_time_qty, t.lead_time_unit_enum, t.create_shipment_flag FROM cwo_category_service_loc t";
/*     */   private static final String SELECT_WHERE_OBJECT = " WHERE organization_id = ?  AND service_loc_id = ?  AND category_id = ?  ";
/*     */   
/*     */   public String getSelect() {
/*  41 */     return getSelectImpl();
/*     */   }
/*     */   
/*     */   private String getSelectImpl() {
/*  45 */     return "SELECT t.organization_id, t.service_loc_id, t.category_id, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.org_code, t.org_value, t.lead_time_qty, t.lead_time_unit_enum, t.create_shipment_flag FROM cwo_category_service_loc t";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectWhere() {
/*  51 */     return " WHERE organization_id = ?  AND service_loc_id = ?  AND category_id = ?  ";
/*     */   }
/*     */   
/*  54 */   private static final String[] INSERT_OBJECT = new String[] { "INSERT INTO cwo_category_service_loc(organization_id, service_loc_id, category_id, create_date, create_user_id, update_date, update_user_id, org_code, org_value, lead_time_qty, lead_time_unit_enum, create_shipment_flag) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" };
/*     */   
/*     */   public String[] getInsert() {
/*  57 */     return INSERT_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getInsertParameters() {
/*  61 */     Object[][] insertParameterObject = { { this._organizationId, this._serviceLocationId, this._categoryId, this._createDate, this._createUserId, this._updateDate, this._updateUserId, ObjectUtils.coalesce((Object[])new String[] { this._orgCode, "*" }), ObjectUtils.coalesce((Object[])new String[] { this._orgValue, "*" }), this._leadTimeQuantity, this._leadTimeUnit, this._createShipment } };
/*  62 */     return insertParameterObject;
/*     */   }
/*     */   
/*  65 */   private static final int[][] INSERT_PARAMETER_TYPES_OBJECT = new int[][] { { -5, 12, 12, 91, 12, 91, 12, 12, 12, 3, 12, -7 } };
/*     */   
/*     */   public int[][] getInsertParameterTypes() {
/*  68 */     return INSERT_PARAMETER_TYPES_OBJECT;
/*     */   }
/*     */   
/*  71 */   private static final String[] UPDATE_OBJECT = new String[] { "UPDATE cwo_category_service_loc SET update_date = ?, update_user_id = ?, org_code = ?, org_value = ?, lead_time_qty = ?, lead_time_unit_enum = ?, create_shipment_flag = ?" };
/*     */   
/*     */   public String[] getUpdate() {
/*  74 */     return UPDATE_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getUpdateParameters() {
/*  78 */     Object[][] updateParameterObject = { { this._updateDate, this._updateUserId, this._orgCode, this._orgValue, this._leadTimeQuantity, this._leadTimeUnit, this._createShipment } };
/*  79 */     return updateParameterObject;
/*     */   }
/*     */   
/*  82 */   private static final int[][] UPDATE_PARAMETER_TYPE_OBJECT = new int[][] { { 91, 12, 12, 12, 3, 12, -7 } };
/*     */   public int[][] getUpdateParameterTypes() {
/*  84 */     return UPDATE_PARAMETER_TYPE_OBJECT;
/*     */   }
/*     */   
/*  87 */   private static final String[] DELETE_OBJECT = new String[] { "DELETE FROM cwo_category_service_loc" }; private static final String WHERE_OBJECT = " WHERE organization_id = ?  AND service_loc_id = ?  AND category_id = ?  ";
/*     */   
/*     */   public String[] getDelete() {
/*  90 */     return DELETE_OBJECT;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWhere() {
/*  96 */     return " WHERE organization_id = ?  AND service_loc_id = ?  AND category_id = ?  ";
/*     */   }
/*     */   public Object[] getWhereParameters() {
/*  99 */     return new Object[] { this._organizationId, this._serviceLocationId, this._categoryId };
/*     */   }
/*     */   
/* 102 */   private static final int[] WHERE_PARAMETER_OBJECT = new int[] { -5, 12, 12 };
/*     */   
/*     */   public int[] getWhereParameterTypes() {
/* 105 */     return WHERE_PARAMETER_OBJECT;
/*     */   }
/*     */   public String getTableName() {
/* 108 */     return "cwo_category_service_loc";
/*     */   }
/*     */   
/*     */   public IFiller getFiller() {
/* 112 */     return getFillerImpl();
/*     */   }
/*     */   
/*     */   private IFiller getFillerImpl() {
/* 116 */     return new CategoryServiceLocationFiller(this);
/*     */   }
/*     */   
/*     */   private static class CategoryServiceLocationFiller
/*     */     implements IFiller {
/*     */     private CategoryServiceLocationDBA _parent;
/*     */     
/*     */     public CategoryServiceLocationFiller(CategoryServiceLocationDBA argParent) {
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
/* 135 */       this._parent._serviceLocationId = argResultSet.getString(2);
/* 136 */       this._parent._categoryId = argResultSet.getString(3);
/*     */       
/* 138 */       Timestamp t4 = argResultSet.getTimestamp(4);
/* 139 */       if (t4 != null) {
/* 140 */         this._parent._createDate = (Date)new DtvDate(t4.getTime());
/*     */       } else {
/*     */         
/* 143 */         this._parent._createDate = null;
/*     */       } 
/*     */       
/* 146 */       this._parent._createUserId = argResultSet.getString(5);
/*     */       
/* 148 */       Timestamp t6 = argResultSet.getTimestamp(6);
/* 149 */       if (t6 != null) {
/* 150 */         this._parent._updateDate = (Date)new DtvDate(t6.getTime());
/*     */       } else {
/*     */         
/* 153 */         this._parent._updateDate = null;
/*     */       } 
/*     */       
/* 156 */       this._parent._updateUserId = argResultSet.getString(7);
/* 157 */       this._parent._orgCode = argResultSet.getString(8);
/* 158 */       this._parent._orgValue = argResultSet.getString(9);
/* 159 */       this._parent._leadTimeQuantity = argResultSet.getBigDecimal(10);
/* 160 */       this._parent._leadTimeUnit = argResultSet.getString(11);
/* 161 */       this._parent._createShipment = Boolean.valueOf(argResultSet.getBoolean(12));
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDAO(IDataAccessObject argDAO) {
/* 166 */     argDAO.suppressStateChanges(true);
/* 167 */     CategoryServiceLocationDAO dao = (CategoryServiceLocationDAO)argDAO;
/* 168 */     dao.setOrganizationId(this._organizationId);
/* 169 */     dao.setServiceLocationId(this._serviceLocationId);
/* 170 */     dao.setCategoryId(this._categoryId);
/* 171 */     dao.setCreateDate(this._createDate);
/* 172 */     dao.setCreateUserId(this._createUserId);
/* 173 */     dao.setUpdateDate(this._updateDate);
/* 174 */     dao.setUpdateUserId(this._updateUserId);
/* 175 */     dao.setOrgCode(this._orgCode);
/* 176 */     dao.setOrgValue(this._orgValue);
/* 177 */     dao.setLeadTimeQuantity(this._leadTimeQuantity);
/* 178 */     dao.setLeadTimeUnit(this._leadTimeUnit);
/* 179 */     dao.setCreateShipment(this._createShipment);
/* 180 */     argDAO.suppressStateChanges(false);
/* 181 */     return (IDataAccessObject)dao;
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDefaultDAO() {
/* 185 */     return loadDAO((IDataAccessObject)new CategoryServiceLocationDAO());
/*     */   }
/*     */   
/*     */   public void fill(IDataAccessObject argDAO) {
/* 189 */     CategoryServiceLocationDAO dao = (CategoryServiceLocationDAO)argDAO;
/* 190 */     this._organizationId = dao.getOrganizationId();
/* 191 */     this._serviceLocationId = dao.getServiceLocationId();
/* 192 */     this._categoryId = dao.getCategoryId();
/* 193 */     this._createDate = dao.getCreateDate();
/* 194 */     this._createUserId = dao.getCreateUserId();
/* 195 */     this._updateDate = dao.getUpdateDate();
/* 196 */     this._updateUserId = dao.getUpdateUserId();
/* 197 */     this._orgCode = dao.getOrgCode();
/* 198 */     this._orgValue = dao.getOrgValue();
/* 199 */     this._leadTimeQuantity = dao.getLeadTimeQuantity();
/* 200 */     this._leadTimeUnit = dao.getLeadTimeUnit();
/* 201 */     this._createShipment = (dao.getCreateShipment() != null) ? dao.getCreateShipment() : Boolean.valueOf(false);
/*     */   }
/*     */   
/*     */   public PreparedStatement writeObjectId(IObjectId argId, PreparedStatement argStatement) throws SQLException {
/* 205 */     CategoryServiceLocationId id = (CategoryServiceLocationId)argId;
/* 206 */     argStatement.setLong(1, id.getOrganizationId().longValue());
/* 207 */     argStatement.setString(2, id.getServiceLocationId());
/* 208 */     argStatement.setString(3, id.getCategoryId());
/* 209 */     return argStatement;
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 213 */     CategoryServiceLocationId id = new CategoryServiceLocationId();
/* 214 */     id.setOrganizationId(this._organizationId);
/* 215 */     id.setServiceLocationId(this._serviceLocationId);
/* 216 */     id.setCategoryId(this._categoryId);
/* 217 */     return (IObjectId)id;
/*     */   }
/*     */ 
/*     */   
/*     */   public void fill(IJDBCTableAdapter argAdapter) {}
/*     */ 
/*     */   
/*     */   public boolean isExtensible() {
/* 225 */     return false;
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 229 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\cwo\impl\CategoryServiceLocationDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */