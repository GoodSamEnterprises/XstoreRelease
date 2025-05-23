/*     */ package dtv.xst.dao.cwo.impl;
/*     */ 
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.impl.jdbc.IFiller;
/*     */ import dtv.data2.access.impl.jdbc.IJDBCTableAdapter;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.util.ObjectUtils;
/*     */ import dtv.xst.dao.cwo.ServiceLocationId;
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
/*     */ public class ServiceLocationDBA
/*     */   implements IJDBCTableAdapter
/*     */ {
/*     */   private static final long serialVersionUID = 2134703466L;
/*     */   private Long _organizationId;
/*     */   private String _serviceLocationId;
/*     */   private Date _createDate;
/*     */   private String _createUserId;
/*     */   private Date _updateDate;
/*     */   private String _updateUserId;
/*     */   private String _orgCode;
/*     */   private String _orgValue;
/*     */   private String _serviceLocDescription;
/*     */   private Long _partyId;
/*     */   private String _addressId;
/*     */   private static final String SELECT_OBJECT = "SELECT t.organization_id, t.service_loc_id, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.org_code, t.org_value, t.description, t.party_id, t.address_id FROM cwo_service_loc t";
/*     */   private static final String SELECT_WHERE_OBJECT = " WHERE organization_id = ?  AND service_loc_id = ?  ";
/*     */   
/*     */   public String getSelect() {
/*  40 */     return getSelectImpl();
/*     */   }
/*     */   
/*     */   private String getSelectImpl() {
/*  44 */     return "SELECT t.organization_id, t.service_loc_id, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.org_code, t.org_value, t.description, t.party_id, t.address_id FROM cwo_service_loc t";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectWhere() {
/*  50 */     return " WHERE organization_id = ?  AND service_loc_id = ?  ";
/*     */   }
/*     */   
/*  53 */   private static final String[] INSERT_OBJECT = new String[] { "INSERT INTO cwo_service_loc(organization_id, service_loc_id, create_date, create_user_id, update_date, update_user_id, org_code, org_value, description, party_id, address_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" };
/*     */   
/*     */   public String[] getInsert() {
/*  56 */     return INSERT_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getInsertParameters() {
/*  60 */     Object[][] insertParameterObject = { { this._organizationId, this._serviceLocationId, this._createDate, this._createUserId, this._updateDate, this._updateUserId, ObjectUtils.coalesce((Object[])new String[] { this._orgCode, "*" }), ObjectUtils.coalesce((Object[])new String[] { this._orgValue, "*" }), this._serviceLocDescription, this._partyId, this._addressId } };
/*  61 */     return insertParameterObject;
/*     */   }
/*     */   
/*  64 */   private static final int[][] INSERT_PARAMETER_TYPES_OBJECT = new int[][] { { -5, 12, 91, 12, 91, 12, 12, 12, 12, -5, 12 } };
/*     */   
/*     */   public int[][] getInsertParameterTypes() {
/*  67 */     return INSERT_PARAMETER_TYPES_OBJECT;
/*     */   }
/*     */   
/*  70 */   private static final String[] UPDATE_OBJECT = new String[] { "UPDATE cwo_service_loc SET update_date = ?, update_user_id = ?, org_code = ?, org_value = ?, description = ?, party_id = ?, address_id = ?" };
/*     */   
/*     */   public String[] getUpdate() {
/*  73 */     return UPDATE_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getUpdateParameters() {
/*  77 */     Object[][] updateParameterObject = { { this._updateDate, this._updateUserId, this._orgCode, this._orgValue, this._serviceLocDescription, this._partyId, this._addressId } };
/*  78 */     return updateParameterObject;
/*     */   }
/*     */   
/*  81 */   private static final int[][] UPDATE_PARAMETER_TYPE_OBJECT = new int[][] { { 91, 12, 12, 12, 12, -5, 12 } };
/*     */   public int[][] getUpdateParameterTypes() {
/*  83 */     return UPDATE_PARAMETER_TYPE_OBJECT;
/*     */   }
/*     */   
/*  86 */   private static final String[] DELETE_OBJECT = new String[] { "DELETE FROM cwo_service_loc" }; private static final String WHERE_OBJECT = " WHERE organization_id = ?  AND service_loc_id = ?  ";
/*     */   
/*     */   public String[] getDelete() {
/*  89 */     return DELETE_OBJECT;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWhere() {
/*  95 */     return " WHERE organization_id = ?  AND service_loc_id = ?  ";
/*     */   }
/*     */   public Object[] getWhereParameters() {
/*  98 */     return new Object[] { this._organizationId, this._serviceLocationId };
/*     */   }
/*     */   
/* 101 */   private static final int[] WHERE_PARAMETER_OBJECT = new int[] { -5, 12 };
/*     */   
/*     */   public int[] getWhereParameterTypes() {
/* 104 */     return WHERE_PARAMETER_OBJECT;
/*     */   }
/*     */   public String getTableName() {
/* 107 */     return "cwo_service_loc";
/*     */   }
/*     */   
/*     */   public IFiller getFiller() {
/* 111 */     return getFillerImpl();
/*     */   }
/*     */   
/*     */   private IFiller getFillerImpl() {
/* 115 */     return new ServiceLocationFiller(this);
/*     */   }
/*     */   
/*     */   private static class ServiceLocationFiller
/*     */     implements IFiller {
/*     */     private ServiceLocationDBA _parent;
/*     */     
/*     */     public ServiceLocationFiller(ServiceLocationDBA argParent) {
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
/* 134 */       this._parent._serviceLocationId = argResultSet.getString(2);
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
/* 157 */       this._parent._serviceLocDescription = argResultSet.getString(9);
/*     */ 
/*     */       
/* 160 */       long l1 = argResultSet.getLong(10);
/* 161 */       if (l1 != 0L || argResultSet.getObject(10) != null) {
/* 162 */         this._parent._partyId = Long.valueOf(l1);
/*     */       }
/*     */ 
/*     */       
/* 166 */       this._parent._addressId = argResultSet.getString(11);
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDAO(IDataAccessObject argDAO) {
/* 171 */     argDAO.suppressStateChanges(true);
/* 172 */     ServiceLocationDAO dao = (ServiceLocationDAO)argDAO;
/* 173 */     dao.setOrganizationId(this._organizationId);
/* 174 */     dao.setServiceLocationId(this._serviceLocationId);
/* 175 */     dao.setCreateDate(this._createDate);
/* 176 */     dao.setCreateUserId(this._createUserId);
/* 177 */     dao.setUpdateDate(this._updateDate);
/* 178 */     dao.setUpdateUserId(this._updateUserId);
/* 179 */     dao.setOrgCode(this._orgCode);
/* 180 */     dao.setOrgValue(this._orgValue);
/* 181 */     dao.setServiceLocDescription(this._serviceLocDescription);
/* 182 */     dao.setPartyId(this._partyId);
/* 183 */     dao.setAddressId(this._addressId);
/* 184 */     argDAO.suppressStateChanges(false);
/* 185 */     return (IDataAccessObject)dao;
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDefaultDAO() {
/* 189 */     return loadDAO((IDataAccessObject)new ServiceLocationDAO());
/*     */   }
/*     */   
/*     */   public void fill(IDataAccessObject argDAO) {
/* 193 */     ServiceLocationDAO dao = (ServiceLocationDAO)argDAO;
/* 194 */     this._organizationId = dao.getOrganizationId();
/* 195 */     this._serviceLocationId = dao.getServiceLocationId();
/* 196 */     this._createDate = dao.getCreateDate();
/* 197 */     this._createUserId = dao.getCreateUserId();
/* 198 */     this._updateDate = dao.getUpdateDate();
/* 199 */     this._updateUserId = dao.getUpdateUserId();
/* 200 */     this._orgCode = dao.getOrgCode();
/* 201 */     this._orgValue = dao.getOrgValue();
/* 202 */     this._serviceLocDescription = dao.getServiceLocDescription();
/* 203 */     this._partyId = dao.getPartyId();
/* 204 */     this._addressId = dao.getAddressId();
/*     */   }
/*     */   
/*     */   public PreparedStatement writeObjectId(IObjectId argId, PreparedStatement argStatement) throws SQLException {
/* 208 */     ServiceLocationId id = (ServiceLocationId)argId;
/* 209 */     argStatement.setLong(1, id.getOrganizationId().longValue());
/* 210 */     argStatement.setString(2, id.getServiceLocationId());
/* 211 */     return argStatement;
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 215 */     ServiceLocationId id = new ServiceLocationId();
/* 216 */     id.setOrganizationId(this._organizationId);
/* 217 */     id.setServiceLocationId(this._serviceLocationId);
/* 218 */     return (IObjectId)id;
/*     */   }
/*     */ 
/*     */   
/*     */   public void fill(IJDBCTableAdapter argAdapter) {}
/*     */ 
/*     */   
/*     */   public boolean isExtensible() {
/* 226 */     return false;
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 230 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\cwo\impl\ServiceLocationDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */