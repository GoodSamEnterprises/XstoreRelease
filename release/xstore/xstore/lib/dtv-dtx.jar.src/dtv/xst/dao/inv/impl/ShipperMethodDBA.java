/*     */ package dtv.xst.dao.inv.impl;
/*     */ 
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.impl.jdbc.IFiller;
/*     */ import dtv.data2.access.impl.jdbc.IJDBCTableAdapter;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.util.ObjectUtils;
/*     */ import dtv.xst.dao.inv.ShipperMethodId;
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
/*     */ public class ShipperMethodDBA
/*     */   implements IJDBCTableAdapter
/*     */ {
/*     */   private static final long serialVersionUID = 1477279106L;
/*     */   private Long _organizationId;
/*     */   private String _shipperMethodId;
/*     */   private String _orgCode;
/*     */   private String _orgValue;
/*     */   private Date _createDate;
/*     */   private String _createUserId;
/*     */   private Date _updateDate;
/*     */   private String _updateUserId;
/*     */   private String _shipperMethodDesc;
/*     */   private String _shipperId;
/*     */   private String _domesticServiceCode;
/*     */   private String _intlServiceCode;
/*     */   private Integer _displayOrder;
/*     */   private Integer _priority;
/*     */   private static final String SELECT_OBJECT = "SELECT t.organization_id, t.shipper_method_id, t.org_code, t.org_value, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.shipper_method_desc, t.shipper_id, t.domestic_service_code, t.intl_service_code, t.display_order, t.priority FROM inv_shipper_method t";
/*     */   private static final String SELECT_WHERE_OBJECT = " WHERE organization_id = ?  AND shipper_method_id = ?  ";
/*     */   
/*     */   public String getSelect() {
/*  43 */     return getSelectImpl();
/*     */   }
/*     */   
/*     */   private String getSelectImpl() {
/*  47 */     return "SELECT t.organization_id, t.shipper_method_id, t.org_code, t.org_value, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.shipper_method_desc, t.shipper_id, t.domestic_service_code, t.intl_service_code, t.display_order, t.priority FROM inv_shipper_method t";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectWhere() {
/*  53 */     return " WHERE organization_id = ?  AND shipper_method_id = ?  ";
/*     */   }
/*     */   
/*  56 */   private static final String[] INSERT_OBJECT = new String[] { "INSERT INTO inv_shipper_method(organization_id, shipper_method_id, org_code, org_value, create_date, create_user_id, update_date, update_user_id, shipper_method_desc, shipper_id, domestic_service_code, intl_service_code, display_order, priority) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" };
/*     */   
/*     */   public String[] getInsert() {
/*  59 */     return INSERT_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getInsertParameters() {
/*  63 */     Object[][] insertParameterObject = { { this._organizationId, this._shipperMethodId, ObjectUtils.coalesce((Object[])new String[] { this._orgCode, "*" }), ObjectUtils.coalesce((Object[])new String[] { this._orgValue, "*" }), this._createDate, this._createUserId, this._updateDate, this._updateUserId, this._shipperMethodDesc, this._shipperId, this._domesticServiceCode, this._intlServiceCode, this._displayOrder, this._priority } };
/*  64 */     return insertParameterObject;
/*     */   }
/*     */   
/*  67 */   private static final int[][] INSERT_PARAMETER_TYPES_OBJECT = new int[][] { { -5, 12, 12, 12, 91, 12, 91, 12, 12, 12, 12, 12, 4, 4 } };
/*     */   
/*     */   public int[][] getInsertParameterTypes() {
/*  70 */     return INSERT_PARAMETER_TYPES_OBJECT;
/*     */   }
/*     */   
/*  73 */   private static final String[] UPDATE_OBJECT = new String[] { "UPDATE inv_shipper_method SET org_code = ?, org_value = ?, update_date = ?, update_user_id = ?, shipper_method_desc = ?, shipper_id = ?, domestic_service_code = ?, intl_service_code = ?, display_order = ?, priority = ?" };
/*     */   
/*     */   public String[] getUpdate() {
/*  76 */     return UPDATE_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getUpdateParameters() {
/*  80 */     Object[][] updateParameterObject = { { this._orgCode, this._orgValue, this._updateDate, this._updateUserId, this._shipperMethodDesc, this._shipperId, this._domesticServiceCode, this._intlServiceCode, this._displayOrder, this._priority } };
/*  81 */     return updateParameterObject;
/*     */   }
/*     */   
/*  84 */   private static final int[][] UPDATE_PARAMETER_TYPE_OBJECT = new int[][] { { 12, 12, 91, 12, 12, 12, 12, 12, 4, 4 } };
/*     */   public int[][] getUpdateParameterTypes() {
/*  86 */     return UPDATE_PARAMETER_TYPE_OBJECT;
/*     */   }
/*     */   
/*  89 */   private static final String[] DELETE_OBJECT = new String[] { "DELETE FROM inv_shipper_method" }; private static final String WHERE_OBJECT = " WHERE organization_id = ?  AND shipper_method_id = ?  ";
/*     */   
/*     */   public String[] getDelete() {
/*  92 */     return DELETE_OBJECT;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWhere() {
/*  98 */     return " WHERE organization_id = ?  AND shipper_method_id = ?  ";
/*     */   }
/*     */   public Object[] getWhereParameters() {
/* 101 */     return new Object[] { this._organizationId, this._shipperMethodId };
/*     */   }
/*     */   
/* 104 */   private static final int[] WHERE_PARAMETER_OBJECT = new int[] { -5, 12 };
/*     */   
/*     */   public int[] getWhereParameterTypes() {
/* 107 */     return WHERE_PARAMETER_OBJECT;
/*     */   }
/*     */   public String getTableName() {
/* 110 */     return "inv_shipper_method";
/*     */   }
/*     */   
/*     */   public IFiller getFiller() {
/* 114 */     return getFillerImpl();
/*     */   }
/*     */   
/*     */   private IFiller getFillerImpl() {
/* 118 */     return new ShipperMethodFiller(this);
/*     */   }
/*     */   
/*     */   private static class ShipperMethodFiller
/*     */     implements IFiller {
/*     */     private ShipperMethodDBA _parent;
/*     */     
/*     */     public ShipperMethodFiller(ShipperMethodDBA argParent) {
/* 126 */       this._parent = argParent;
/*     */     }
/*     */ 
/*     */     
/*     */     public void fill(ResultSet argResultSet) throws SQLException {
/* 131 */       long primitiveResult = argResultSet.getLong(1);
/* 132 */       if (primitiveResult != 0L || argResultSet.getObject(1) != null) {
/* 133 */         this._parent._organizationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */       
/* 137 */       this._parent._shipperMethodId = argResultSet.getString(2);
/* 138 */       this._parent._orgCode = argResultSet.getString(3);
/* 139 */       this._parent._orgValue = argResultSet.getString(4);
/*     */       
/* 141 */       Timestamp t5 = argResultSet.getTimestamp(5);
/* 142 */       if (t5 != null) {
/* 143 */         this._parent._createDate = (Date)new DtvDate(t5.getTime());
/*     */       } else {
/*     */         
/* 146 */         this._parent._createDate = null;
/*     */       } 
/*     */       
/* 149 */       this._parent._createUserId = argResultSet.getString(6);
/*     */       
/* 151 */       Timestamp t7 = argResultSet.getTimestamp(7);
/* 152 */       if (t7 != null) {
/* 153 */         this._parent._updateDate = (Date)new DtvDate(t7.getTime());
/*     */       } else {
/*     */         
/* 156 */         this._parent._updateDate = null;
/*     */       } 
/*     */       
/* 159 */       this._parent._updateUserId = argResultSet.getString(8);
/* 160 */       this._parent._shipperMethodDesc = argResultSet.getString(9);
/* 161 */       this._parent._shipperId = argResultSet.getString(10);
/* 162 */       this._parent._domesticServiceCode = argResultSet.getString(11);
/* 163 */       this._parent._intlServiceCode = argResultSet.getString(12);
/*     */ 
/*     */       
/* 166 */       int i = argResultSet.getInt(13);
/* 167 */       if (i != 0 || argResultSet.getObject(13) != null) {
/* 168 */         this._parent._displayOrder = Integer.valueOf(i);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 174 */       i = argResultSet.getInt(14);
/* 175 */       if (i != 0 || argResultSet.getObject(14) != null) {
/* 176 */         this._parent._priority = Integer.valueOf(i);
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IDataAccessObject loadDAO(IDataAccessObject argDAO) {
/* 184 */     argDAO.suppressStateChanges(true);
/* 185 */     ShipperMethodDAO dao = (ShipperMethodDAO)argDAO;
/* 186 */     dao.setOrganizationId(this._organizationId);
/* 187 */     dao.setShipperMethodId(this._shipperMethodId);
/* 188 */     dao.setOrgCode(this._orgCode);
/* 189 */     dao.setOrgValue(this._orgValue);
/* 190 */     dao.setCreateDate(this._createDate);
/* 191 */     dao.setCreateUserId(this._createUserId);
/* 192 */     dao.setUpdateDate(this._updateDate);
/* 193 */     dao.setUpdateUserId(this._updateUserId);
/* 194 */     dao.setShipperMethodDesc(this._shipperMethodDesc);
/* 195 */     dao.setShipperId(this._shipperId);
/* 196 */     dao.setDomesticServiceCode(this._domesticServiceCode);
/* 197 */     dao.setIntlServiceCode(this._intlServiceCode);
/* 198 */     dao.setDisplayOrder(this._displayOrder);
/* 199 */     dao.setPriority(this._priority);
/* 200 */     argDAO.suppressStateChanges(false);
/* 201 */     return (IDataAccessObject)dao;
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDefaultDAO() {
/* 205 */     return loadDAO((IDataAccessObject)new ShipperMethodDAO());
/*     */   }
/*     */   
/*     */   public void fill(IDataAccessObject argDAO) {
/* 209 */     ShipperMethodDAO dao = (ShipperMethodDAO)argDAO;
/* 210 */     this._organizationId = dao.getOrganizationId();
/* 211 */     this._shipperMethodId = dao.getShipperMethodId();
/* 212 */     this._orgCode = dao.getOrgCode();
/* 213 */     this._orgValue = dao.getOrgValue();
/* 214 */     this._createDate = dao.getCreateDate();
/* 215 */     this._createUserId = dao.getCreateUserId();
/* 216 */     this._updateDate = dao.getUpdateDate();
/* 217 */     this._updateUserId = dao.getUpdateUserId();
/* 218 */     this._shipperMethodDesc = dao.getShipperMethodDesc();
/* 219 */     this._shipperId = dao.getShipperId();
/* 220 */     this._domesticServiceCode = dao.getDomesticServiceCode();
/* 221 */     this._intlServiceCode = dao.getIntlServiceCode();
/* 222 */     this._displayOrder = dao.getDisplayOrder();
/* 223 */     this._priority = dao.getPriority();
/*     */   }
/*     */   
/*     */   public PreparedStatement writeObjectId(IObjectId argId, PreparedStatement argStatement) throws SQLException {
/* 227 */     ShipperMethodId id = (ShipperMethodId)argId;
/* 228 */     argStatement.setLong(1, id.getOrganizationId().longValue());
/* 229 */     argStatement.setString(2, id.getShipperMethodId());
/* 230 */     return argStatement;
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 234 */     ShipperMethodId id = new ShipperMethodId();
/* 235 */     id.setOrganizationId(this._organizationId);
/* 236 */     id.setShipperMethodId(this._shipperMethodId);
/* 237 */     return (IObjectId)id;
/*     */   }
/*     */ 
/*     */   
/*     */   public void fill(IJDBCTableAdapter argAdapter) {}
/*     */ 
/*     */   
/*     */   public boolean isExtensible() {
/* 245 */     return false;
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 249 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\inv\impl\ShipperMethodDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */