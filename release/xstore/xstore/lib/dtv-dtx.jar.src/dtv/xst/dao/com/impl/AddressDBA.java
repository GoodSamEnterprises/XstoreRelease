/*     */ package dtv.xst.dao.com.impl;
/*     */ 
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.impl.jdbc.IFiller;
/*     */ import dtv.data2.access.impl.jdbc.IJDBCTableAdapter;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.util.ObjectUtils;
/*     */ import dtv.xst.dao.com.AddressId;
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
/*     */ public class AddressDBA
/*     */   implements IJDBCTableAdapter
/*     */ {
/*     */   private static final long serialVersionUID = 516961236L;
/*     */   private Long _organizationId;
/*     */   private String _addressId;
/*     */   private Date _createDate;
/*     */   private String _createUserId;
/*     */   private Date _updateDate;
/*     */   private String _updateUserId;
/*     */   private String _orgCode;
/*     */   private String _orgValue;
/*     */   private String _address1;
/*     */   private String _address2;
/*     */   private String _address3;
/*     */   private String _address4;
/*     */   private String _apartment;
/*     */   private String _city;
/*     */   private String _state;
/*     */   private String _postalCode;
/*     */   private String _country;
/*     */   private String _neighborhood;
/*     */   private String _county;
/*     */   private static final String SELECT_OBJECT = "SELECT t.organization_id, t.address_id, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.org_code, t.org_value, t.address1, t.address2, t.address3, t.address4, t.apartment, t.city, t.territory, t.postal_code, t.country, t.neighborhood, t.county FROM com_address t";
/*     */   private static final String SELECT_WHERE_OBJECT = " WHERE organization_id = ?  AND address_id = ?  ";
/*     */   
/*     */   public String getSelect() {
/*  48 */     return getSelectImpl();
/*     */   }
/*     */   
/*     */   private String getSelectImpl() {
/*  52 */     return "SELECT t.organization_id, t.address_id, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.org_code, t.org_value, t.address1, t.address2, t.address3, t.address4, t.apartment, t.city, t.territory, t.postal_code, t.country, t.neighborhood, t.county FROM com_address t";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectWhere() {
/*  58 */     return " WHERE organization_id = ?  AND address_id = ?  ";
/*     */   }
/*     */   
/*  61 */   private static final String[] INSERT_OBJECT = new String[] { "INSERT INTO com_address(organization_id, address_id, create_date, create_user_id, update_date, update_user_id, org_code, org_value, address1, address2, address3, address4, apartment, city, territory, postal_code, country, neighborhood, county) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" };
/*     */   
/*     */   public String[] getInsert() {
/*  64 */     return INSERT_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getInsertParameters() {
/*  68 */     Object[][] insertParameterObject = { { this._organizationId, this._addressId, this._createDate, this._createUserId, this._updateDate, this._updateUserId, ObjectUtils.coalesce((Object[])new String[] { this._orgCode, "*" }), ObjectUtils.coalesce((Object[])new String[] { this._orgValue, "*" }), this._address1, this._address2, this._address3, this._address4, this._apartment, this._city, this._state, this._postalCode, this._country, this._neighborhood, this._county } };
/*  69 */     return insertParameterObject;
/*     */   }
/*     */   
/*  72 */   private static final int[][] INSERT_PARAMETER_TYPES_OBJECT = new int[][] { { -5, 12, 91, 12, 91, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12 } };
/*     */   
/*     */   public int[][] getInsertParameterTypes() {
/*  75 */     return INSERT_PARAMETER_TYPES_OBJECT;
/*     */   }
/*     */   
/*  78 */   private static final String[] UPDATE_OBJECT = new String[] { "UPDATE com_address SET update_date = ?, update_user_id = ?, org_code = ?, org_value = ?, address1 = ?, address2 = ?, address3 = ?, address4 = ?, apartment = ?, city = ?, territory = ?, postal_code = ?, country = ?, neighborhood = ?, county = ?" };
/*     */   
/*     */   public String[] getUpdate() {
/*  81 */     return UPDATE_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getUpdateParameters() {
/*  85 */     Object[][] updateParameterObject = { { this._updateDate, this._updateUserId, this._orgCode, this._orgValue, this._address1, this._address2, this._address3, this._address4, this._apartment, this._city, this._state, this._postalCode, this._country, this._neighborhood, this._county } };
/*  86 */     return updateParameterObject;
/*     */   }
/*     */   
/*  89 */   private static final int[][] UPDATE_PARAMETER_TYPE_OBJECT = new int[][] { { 91, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12 } };
/*     */   public int[][] getUpdateParameterTypes() {
/*  91 */     return UPDATE_PARAMETER_TYPE_OBJECT;
/*     */   }
/*     */   
/*  94 */   private static final String[] DELETE_OBJECT = new String[] { "DELETE FROM com_address" }; private static final String WHERE_OBJECT = " WHERE organization_id = ?  AND address_id = ?  ";
/*     */   
/*     */   public String[] getDelete() {
/*  97 */     return DELETE_OBJECT;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWhere() {
/* 103 */     return " WHERE organization_id = ?  AND address_id = ?  ";
/*     */   }
/*     */   public Object[] getWhereParameters() {
/* 106 */     return new Object[] { this._organizationId, this._addressId };
/*     */   }
/*     */   
/* 109 */   private static final int[] WHERE_PARAMETER_OBJECT = new int[] { -5, 12 };
/*     */   
/*     */   public int[] getWhereParameterTypes() {
/* 112 */     return WHERE_PARAMETER_OBJECT;
/*     */   }
/*     */   public String getTableName() {
/* 115 */     return "com_address";
/*     */   }
/*     */   
/*     */   public IFiller getFiller() {
/* 119 */     return getFillerImpl();
/*     */   }
/*     */   
/*     */   private IFiller getFillerImpl() {
/* 123 */     return new AddressFiller(this);
/*     */   }
/*     */   
/*     */   private static class AddressFiller
/*     */     implements IFiller {
/*     */     private AddressDBA _parent;
/*     */     
/*     */     public AddressFiller(AddressDBA argParent) {
/* 131 */       this._parent = argParent;
/*     */     }
/*     */ 
/*     */     
/*     */     public void fill(ResultSet argResultSet) throws SQLException {
/* 136 */       long primitiveResult = argResultSet.getLong(1);
/* 137 */       if (primitiveResult != 0L || argResultSet.getObject(1) != null) {
/* 138 */         this._parent._organizationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */       
/* 142 */       this._parent._addressId = argResultSet.getString(2);
/*     */       
/* 144 */       Timestamp t3 = argResultSet.getTimestamp(3);
/* 145 */       if (t3 != null) {
/* 146 */         this._parent._createDate = (Date)new DtvDate(t3.getTime());
/*     */       } else {
/*     */         
/* 149 */         this._parent._createDate = null;
/*     */       } 
/*     */       
/* 152 */       this._parent._createUserId = argResultSet.getString(4);
/*     */       
/* 154 */       Timestamp t5 = argResultSet.getTimestamp(5);
/* 155 */       if (t5 != null) {
/* 156 */         this._parent._updateDate = (Date)new DtvDate(t5.getTime());
/*     */       } else {
/*     */         
/* 159 */         this._parent._updateDate = null;
/*     */       } 
/*     */       
/* 162 */       this._parent._updateUserId = argResultSet.getString(6);
/* 163 */       this._parent._orgCode = argResultSet.getString(7);
/* 164 */       this._parent._orgValue = argResultSet.getString(8);
/* 165 */       this._parent._address1 = argResultSet.getString(9);
/* 166 */       this._parent._address2 = argResultSet.getString(10);
/* 167 */       this._parent._address3 = argResultSet.getString(11);
/* 168 */       this._parent._address4 = argResultSet.getString(12);
/* 169 */       this._parent._apartment = argResultSet.getString(13);
/* 170 */       this._parent._city = argResultSet.getString(14);
/* 171 */       this._parent._state = argResultSet.getString(15);
/* 172 */       this._parent._postalCode = argResultSet.getString(16);
/* 173 */       this._parent._country = argResultSet.getString(17);
/* 174 */       this._parent._neighborhood = argResultSet.getString(18);
/* 175 */       this._parent._county = argResultSet.getString(19);
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDAO(IDataAccessObject argDAO) {
/* 180 */     argDAO.suppressStateChanges(true);
/* 181 */     AddressDAO dao = (AddressDAO)argDAO;
/* 182 */     dao.setOrganizationId(this._organizationId);
/* 183 */     dao.setAddressId(this._addressId);
/* 184 */     dao.setCreateDate(this._createDate);
/* 185 */     dao.setCreateUserId(this._createUserId);
/* 186 */     dao.setUpdateDate(this._updateDate);
/* 187 */     dao.setUpdateUserId(this._updateUserId);
/* 188 */     dao.setOrgCode(this._orgCode);
/* 189 */     dao.setOrgValue(this._orgValue);
/* 190 */     dao.setAddress1(this._address1);
/* 191 */     dao.setAddress2(this._address2);
/* 192 */     dao.setAddress3(this._address3);
/* 193 */     dao.setAddress4(this._address4);
/* 194 */     dao.setApartment(this._apartment);
/* 195 */     dao.setCity(this._city);
/* 196 */     dao.setState(this._state);
/* 197 */     dao.setPostalCode(this._postalCode);
/* 198 */     dao.setCountry(this._country);
/* 199 */     dao.setNeighborhood(this._neighborhood);
/* 200 */     dao.setCounty(this._county);
/* 201 */     argDAO.suppressStateChanges(false);
/* 202 */     return (IDataAccessObject)dao;
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDefaultDAO() {
/* 206 */     return loadDAO((IDataAccessObject)new AddressDAO());
/*     */   }
/*     */   
/*     */   public void fill(IDataAccessObject argDAO) {
/* 210 */     AddressDAO dao = (AddressDAO)argDAO;
/* 211 */     this._organizationId = dao.getOrganizationId();
/* 212 */     this._addressId = dao.getAddressId();
/* 213 */     this._createDate = dao.getCreateDate();
/* 214 */     this._createUserId = dao.getCreateUserId();
/* 215 */     this._updateDate = dao.getUpdateDate();
/* 216 */     this._updateUserId = dao.getUpdateUserId();
/* 217 */     this._orgCode = dao.getOrgCode();
/* 218 */     this._orgValue = dao.getOrgValue();
/* 219 */     this._address1 = dao.getAddress1();
/* 220 */     this._address2 = dao.getAddress2();
/* 221 */     this._address3 = dao.getAddress3();
/* 222 */     this._address4 = dao.getAddress4();
/* 223 */     this._apartment = dao.getApartment();
/* 224 */     this._city = dao.getCity();
/* 225 */     this._state = dao.getState();
/* 226 */     this._postalCode = dao.getPostalCode();
/* 227 */     this._country = dao.getCountry();
/* 228 */     this._neighborhood = dao.getNeighborhood();
/* 229 */     this._county = dao.getCounty();
/*     */   }
/*     */   
/*     */   public PreparedStatement writeObjectId(IObjectId argId, PreparedStatement argStatement) throws SQLException {
/* 233 */     AddressId id = (AddressId)argId;
/* 234 */     argStatement.setLong(1, id.getOrganizationId().longValue());
/* 235 */     argStatement.setString(2, id.getAddressId());
/* 236 */     return argStatement;
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 240 */     AddressId id = new AddressId();
/* 241 */     id.setOrganizationId(this._organizationId);
/* 242 */     id.setAddressId(this._addressId);
/* 243 */     return (IObjectId)id;
/*     */   }
/*     */ 
/*     */   
/*     */   public void fill(IJDBCTableAdapter argAdapter) {}
/*     */ 
/*     */   
/*     */   public boolean isExtensible() {
/* 251 */     return false;
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 255 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\com\impl\AddressDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */