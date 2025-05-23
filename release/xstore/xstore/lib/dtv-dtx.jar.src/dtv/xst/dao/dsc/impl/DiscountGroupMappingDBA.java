/*     */ package dtv.xst.dao.dsc.impl;
/*     */ 
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.impl.jdbc.IFiller;
/*     */ import dtv.data2.access.impl.jdbc.IJDBCTableAdapter;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.util.ObjectUtils;
/*     */ import dtv.xst.dao.dsc.DiscountGroupMappingId;
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
/*     */ public class DiscountGroupMappingDBA
/*     */   implements IJDBCTableAdapter
/*     */ {
/*     */   private static final long serialVersionUID = -2010226352L;
/*     */   private String _customerGroupId;
/*     */   private String _discountCode;
/*     */   private Long _organizationId;
/*     */   private Date _createDate;
/*     */   private String _createUserId;
/*     */   private Date _updateDate;
/*     */   private String _updateUserId;
/*     */   private String _configElement;
/*     */   private static final String SELECT_OBJECT = "SELECT t.cust_group_id, t.discount_code, t.organization_id, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.config_element FROM dsc_discount_group_mapping t";
/*     */   private static final String SELECT_WHERE_OBJECT = " WHERE cust_group_id = ?  AND discount_code = ?  AND organization_id = ?  ";
/*     */   
/*     */   public String getSelect() {
/*  37 */     return getSelectImpl();
/*     */   }
/*     */   
/*     */   private String getSelectImpl() {
/*  41 */     return "SELECT t.cust_group_id, t.discount_code, t.organization_id, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.config_element FROM dsc_discount_group_mapping t";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectWhere() {
/*  47 */     return " WHERE cust_group_id = ?  AND discount_code = ?  AND organization_id = ?  ";
/*     */   }
/*     */   
/*  50 */   private static final String[] INSERT_OBJECT = new String[] { "INSERT INTO dsc_discount_group_mapping(cust_group_id, discount_code, organization_id, create_date, create_user_id, update_date, update_user_id, config_element) VALUES (?, ?, ?, ?, ?, ?, ?, ?)" };
/*     */   
/*     */   public String[] getInsert() {
/*  53 */     return INSERT_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getInsertParameters() {
/*  57 */     Object[][] insertParameterObject = { { this._customerGroupId, this._discountCode, this._organizationId, this._createDate, this._createUserId, this._updateDate, this._updateUserId, ObjectUtils.coalesce((Object[])new String[] { this._configElement, "*" }) } };
/*  58 */     return insertParameterObject;
/*     */   }
/*     */   
/*  61 */   private static final int[][] INSERT_PARAMETER_TYPES_OBJECT = new int[][] { { 12, 12, -5, 91, 12, 91, 12, 12 } };
/*     */   
/*     */   public int[][] getInsertParameterTypes() {
/*  64 */     return INSERT_PARAMETER_TYPES_OBJECT;
/*     */   }
/*     */   
/*  67 */   private static final String[] UPDATE_OBJECT = new String[] { "UPDATE dsc_discount_group_mapping SET update_date = ?, update_user_id = ?, config_element = ?" };
/*     */   
/*     */   public String[] getUpdate() {
/*  70 */     return UPDATE_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getUpdateParameters() {
/*  74 */     Object[][] updateParameterObject = { { this._updateDate, this._updateUserId, ObjectUtils.coalesce((Object[])new String[] { this._configElement, "*" }) } };
/*  75 */     return updateParameterObject;
/*     */   }
/*     */   
/*  78 */   private static final int[][] UPDATE_PARAMETER_TYPE_OBJECT = new int[][] { { 91, 12, 12 } };
/*     */   public int[][] getUpdateParameterTypes() {
/*  80 */     return UPDATE_PARAMETER_TYPE_OBJECT;
/*     */   }
/*     */   
/*  83 */   private static final String[] DELETE_OBJECT = new String[] { "DELETE FROM dsc_discount_group_mapping" }; private static final String WHERE_OBJECT = " WHERE cust_group_id = ?  AND discount_code = ?  AND organization_id = ?  ";
/*     */   
/*     */   public String[] getDelete() {
/*  86 */     return DELETE_OBJECT;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWhere() {
/*  92 */     return " WHERE cust_group_id = ?  AND discount_code = ?  AND organization_id = ?  ";
/*     */   }
/*     */   public Object[] getWhereParameters() {
/*  95 */     return new Object[] { this._customerGroupId, this._discountCode, this._organizationId };
/*     */   }
/*     */   
/*  98 */   private static final int[] WHERE_PARAMETER_OBJECT = new int[] { 12, 12, -5 };
/*     */   
/*     */   public int[] getWhereParameterTypes() {
/* 101 */     return WHERE_PARAMETER_OBJECT;
/*     */   }
/*     */   public String getTableName() {
/* 104 */     return "dsc_discount_group_mapping";
/*     */   }
/*     */   
/*     */   public IFiller getFiller() {
/* 108 */     return getFillerImpl();
/*     */   }
/*     */   
/*     */   private IFiller getFillerImpl() {
/* 112 */     return new DiscountGroupMappingFiller(this);
/*     */   }
/*     */   
/*     */   private static class DiscountGroupMappingFiller
/*     */     implements IFiller {
/*     */     private DiscountGroupMappingDBA _parent;
/*     */     
/*     */     public DiscountGroupMappingFiller(DiscountGroupMappingDBA argParent) {
/* 120 */       this._parent = argParent;
/*     */     }
/*     */     public void fill(ResultSet argResultSet) throws SQLException {
/* 123 */       this._parent._customerGroupId = argResultSet.getString(1);
/* 124 */       this._parent._discountCode = argResultSet.getString(2);
/*     */ 
/*     */       
/* 127 */       long primitiveResult = argResultSet.getLong(3);
/* 128 */       if (primitiveResult != 0L || argResultSet.getObject(3) != null) {
/* 129 */         this._parent._organizationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 134 */       Timestamp t4 = argResultSet.getTimestamp(4);
/* 135 */       if (t4 != null) {
/* 136 */         this._parent._createDate = (Date)new DtvDate(t4.getTime());
/*     */       } else {
/*     */         
/* 139 */         this._parent._createDate = null;
/*     */       } 
/*     */       
/* 142 */       this._parent._createUserId = argResultSet.getString(5);
/*     */       
/* 144 */       Timestamp t6 = argResultSet.getTimestamp(6);
/* 145 */       if (t6 != null) {
/* 146 */         this._parent._updateDate = (Date)new DtvDate(t6.getTime());
/*     */       } else {
/*     */         
/* 149 */         this._parent._updateDate = null;
/*     */       } 
/*     */       
/* 152 */       this._parent._updateUserId = argResultSet.getString(7);
/* 153 */       this._parent._configElement = argResultSet.getString(8);
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDAO(IDataAccessObject argDAO) {
/* 158 */     argDAO.suppressStateChanges(true);
/* 159 */     DiscountGroupMappingDAO dao = (DiscountGroupMappingDAO)argDAO;
/* 160 */     dao.setCustomerGroupId(this._customerGroupId);
/* 161 */     dao.setDiscountCode(this._discountCode);
/* 162 */     dao.setOrganizationId(this._organizationId);
/* 163 */     dao.setCreateDate(this._createDate);
/* 164 */     dao.setCreateUserId(this._createUserId);
/* 165 */     dao.setUpdateDate(this._updateDate);
/* 166 */     dao.setUpdateUserId(this._updateUserId);
/* 167 */     dao.setConfigElement(this._configElement);
/* 168 */     argDAO.suppressStateChanges(false);
/* 169 */     return (IDataAccessObject)dao;
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDefaultDAO() {
/* 173 */     return loadDAO((IDataAccessObject)new DiscountGroupMappingDAO());
/*     */   }
/*     */   
/*     */   public void fill(IDataAccessObject argDAO) {
/* 177 */     DiscountGroupMappingDAO dao = (DiscountGroupMappingDAO)argDAO;
/* 178 */     this._customerGroupId = dao.getCustomerGroupId();
/* 179 */     this._discountCode = dao.getDiscountCode();
/* 180 */     this._organizationId = dao.getOrganizationId();
/* 181 */     this._createDate = dao.getCreateDate();
/* 182 */     this._createUserId = dao.getCreateUserId();
/* 183 */     this._updateDate = dao.getUpdateDate();
/* 184 */     this._updateUserId = dao.getUpdateUserId();
/* 185 */     this._configElement = dao.getConfigElement();
/*     */   }
/*     */   
/*     */   public PreparedStatement writeObjectId(IObjectId argId, PreparedStatement argStatement) throws SQLException {
/* 189 */     DiscountGroupMappingId id = (DiscountGroupMappingId)argId;
/* 190 */     argStatement.setString(1, id.getCustomerGroupId());
/* 191 */     argStatement.setString(2, id.getDiscountCode());
/* 192 */     argStatement.setLong(3, id.getOrganizationId().longValue());
/* 193 */     return argStatement;
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 197 */     DiscountGroupMappingId id = new DiscountGroupMappingId();
/* 198 */     id.setCustomerGroupId(this._customerGroupId);
/* 199 */     id.setDiscountCode(this._discountCode);
/* 200 */     id.setOrganizationId(this._organizationId);
/* 201 */     return (IObjectId)id;
/*     */   }
/*     */ 
/*     */   
/*     */   public void fill(IJDBCTableAdapter argAdapter) {}
/*     */ 
/*     */   
/*     */   public boolean isExtensible() {
/* 209 */     return false;
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 213 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\dsc\impl\DiscountGroupMappingDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */