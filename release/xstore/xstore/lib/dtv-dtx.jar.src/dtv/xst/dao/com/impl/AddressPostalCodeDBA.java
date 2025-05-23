/*     */ package dtv.xst.dao.com.impl;
/*     */ 
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.impl.jdbc.IFiller;
/*     */ import dtv.data2.access.impl.jdbc.IJDBCTableAdapter;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.com.AddressPostalCodeId;
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
/*     */ public class AddressPostalCodeDBA
/*     */   implements IJDBCTableAdapter
/*     */ {
/*     */   private static final long serialVersionUID = -1501423540L;
/*     */   private Long _organizationId;
/*     */   private String _countryId;
/*     */   private String _postalCodeId;
/*     */   private String _addressMode;
/*     */   private Date _createDate;
/*     */   private String _createUserId;
/*     */   private Date _updateDate;
/*     */   private String _updateUserId;
/*     */   private String _postalCode;
/*     */   private String _stateId;
/*     */   private String _cityName;
/*     */   private static final String SELECT_OBJECT = "SELECT t.organization_id, t.country_id, t.postal_code_id, t.address_mode, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.postal_code, t.state_id, t.city_name FROM com_address_postalcode t";
/*     */   private static final String SELECT_WHERE_OBJECT = " WHERE organization_id = ?  AND country_id = ?  AND postal_code_id = ?  AND address_mode = ?  ";
/*     */   
/*     */   public String getSelect() {
/*  40 */     return getSelectImpl();
/*     */   }
/*     */   
/*     */   private String getSelectImpl() {
/*  44 */     return "SELECT t.organization_id, t.country_id, t.postal_code_id, t.address_mode, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.postal_code, t.state_id, t.city_name FROM com_address_postalcode t";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectWhere() {
/*  50 */     return " WHERE organization_id = ?  AND country_id = ?  AND postal_code_id = ?  AND address_mode = ?  ";
/*     */   }
/*     */   
/*  53 */   private static final String[] INSERT_OBJECT = new String[] { "INSERT INTO com_address_postalcode(organization_id, country_id, postal_code_id, address_mode, create_date, create_user_id, update_date, update_user_id, postal_code, state_id, city_name) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" };
/*     */   
/*     */   public String[] getInsert() {
/*  56 */     return INSERT_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getInsertParameters() {
/*  60 */     Object[][] insertParameterObject = { { this._organizationId, this._countryId, this._postalCodeId, this._addressMode, this._createDate, this._createUserId, this._updateDate, this._updateUserId, this._postalCode, this._stateId, this._cityName } };
/*  61 */     return insertParameterObject;
/*     */   }
/*     */   
/*  64 */   private static final int[][] INSERT_PARAMETER_TYPES_OBJECT = new int[][] { { -5, 12, 12, 12, 91, 12, 91, 12, 12, 12, 12 } };
/*     */   
/*     */   public int[][] getInsertParameterTypes() {
/*  67 */     return INSERT_PARAMETER_TYPES_OBJECT;
/*     */   }
/*     */   
/*  70 */   private static final String[] UPDATE_OBJECT = new String[] { "UPDATE com_address_postalcode SET update_date = ?, update_user_id = ?, postal_code = ?, state_id = ?, city_name = ?" };
/*     */   
/*     */   public String[] getUpdate() {
/*  73 */     return UPDATE_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getUpdateParameters() {
/*  77 */     Object[][] updateParameterObject = { { this._updateDate, this._updateUserId, this._postalCode, this._stateId, this._cityName } };
/*  78 */     return updateParameterObject;
/*     */   }
/*     */   
/*  81 */   private static final int[][] UPDATE_PARAMETER_TYPE_OBJECT = new int[][] { { 91, 12, 12, 12, 12 } };
/*     */   public int[][] getUpdateParameterTypes() {
/*  83 */     return UPDATE_PARAMETER_TYPE_OBJECT;
/*     */   }
/*     */   
/*  86 */   private static final String[] DELETE_OBJECT = new String[] { "DELETE FROM com_address_postalcode" }; private static final String WHERE_OBJECT = " WHERE organization_id = ?  AND country_id = ?  AND postal_code_id = ?  AND address_mode = ?  ";
/*     */   
/*     */   public String[] getDelete() {
/*  89 */     return DELETE_OBJECT;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWhere() {
/*  95 */     return " WHERE organization_id = ?  AND country_id = ?  AND postal_code_id = ?  AND address_mode = ?  ";
/*     */   }
/*     */   public Object[] getWhereParameters() {
/*  98 */     return new Object[] { this._organizationId, this._countryId, this._postalCodeId, this._addressMode };
/*     */   }
/*     */   
/* 101 */   private static final int[] WHERE_PARAMETER_OBJECT = new int[] { -5, 12, 12, 12 };
/*     */   
/*     */   public int[] getWhereParameterTypes() {
/* 104 */     return WHERE_PARAMETER_OBJECT;
/*     */   }
/*     */   public String getTableName() {
/* 107 */     return "com_address_postalcode";
/*     */   }
/*     */   
/*     */   public IFiller getFiller() {
/* 111 */     return getFillerImpl();
/*     */   }
/*     */   
/*     */   private IFiller getFillerImpl() {
/* 115 */     return new AddressPostalCodeFiller(this);
/*     */   }
/*     */   
/*     */   private static class AddressPostalCodeFiller
/*     */     implements IFiller {
/*     */     private AddressPostalCodeDBA _parent;
/*     */     
/*     */     public AddressPostalCodeFiller(AddressPostalCodeDBA argParent) {
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
/* 134 */       this._parent._countryId = argResultSet.getString(2);
/* 135 */       this._parent._postalCodeId = argResultSet.getString(3);
/* 136 */       this._parent._addressMode = argResultSet.getString(4);
/*     */       
/* 138 */       Timestamp t5 = argResultSet.getTimestamp(5);
/* 139 */       if (t5 != null) {
/* 140 */         this._parent._createDate = (Date)new DtvDate(t5.getTime());
/*     */       } else {
/*     */         
/* 143 */         this._parent._createDate = null;
/*     */       } 
/*     */       
/* 146 */       this._parent._createUserId = argResultSet.getString(6);
/*     */       
/* 148 */       Timestamp t7 = argResultSet.getTimestamp(7);
/* 149 */       if (t7 != null) {
/* 150 */         this._parent._updateDate = (Date)new DtvDate(t7.getTime());
/*     */       } else {
/*     */         
/* 153 */         this._parent._updateDate = null;
/*     */       } 
/*     */       
/* 156 */       this._parent._updateUserId = argResultSet.getString(8);
/* 157 */       this._parent._postalCode = argResultSet.getString(9);
/* 158 */       this._parent._stateId = argResultSet.getString(10);
/* 159 */       this._parent._cityName = argResultSet.getString(11);
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDAO(IDataAccessObject argDAO) {
/* 164 */     argDAO.suppressStateChanges(true);
/* 165 */     AddressPostalCodeDAO dao = (AddressPostalCodeDAO)argDAO;
/* 166 */     dao.setOrganizationId(this._organizationId);
/* 167 */     dao.setCountryId(this._countryId);
/* 168 */     dao.setPostalCodeId(this._postalCodeId);
/* 169 */     dao.setAddressMode(this._addressMode);
/* 170 */     dao.setCreateDate(this._createDate);
/* 171 */     dao.setCreateUserId(this._createUserId);
/* 172 */     dao.setUpdateDate(this._updateDate);
/* 173 */     dao.setUpdateUserId(this._updateUserId);
/* 174 */     dao.setPostalCode(this._postalCode);
/* 175 */     dao.setStateId(this._stateId);
/* 176 */     dao.setCityName(this._cityName);
/* 177 */     argDAO.suppressStateChanges(false);
/* 178 */     return (IDataAccessObject)dao;
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDefaultDAO() {
/* 182 */     return loadDAO((IDataAccessObject)new AddressPostalCodeDAO());
/*     */   }
/*     */   
/*     */   public void fill(IDataAccessObject argDAO) {
/* 186 */     AddressPostalCodeDAO dao = (AddressPostalCodeDAO)argDAO;
/* 187 */     this._organizationId = dao.getOrganizationId();
/* 188 */     this._countryId = dao.getCountryId();
/* 189 */     this._postalCodeId = dao.getPostalCodeId();
/* 190 */     this._addressMode = dao.getAddressMode();
/* 191 */     this._createDate = dao.getCreateDate();
/* 192 */     this._createUserId = dao.getCreateUserId();
/* 193 */     this._updateDate = dao.getUpdateDate();
/* 194 */     this._updateUserId = dao.getUpdateUserId();
/* 195 */     this._postalCode = dao.getPostalCode();
/* 196 */     this._stateId = dao.getStateId();
/* 197 */     this._cityName = dao.getCityName();
/*     */   }
/*     */   
/*     */   public PreparedStatement writeObjectId(IObjectId argId, PreparedStatement argStatement) throws SQLException {
/* 201 */     AddressPostalCodeId id = (AddressPostalCodeId)argId;
/* 202 */     argStatement.setLong(1, id.getOrganizationId().longValue());
/* 203 */     argStatement.setString(2, id.getCountryId());
/* 204 */     argStatement.setString(3, id.getPostalCodeId());
/* 205 */     argStatement.setString(4, id.getAddressMode());
/* 206 */     return argStatement;
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 210 */     AddressPostalCodeId id = new AddressPostalCodeId();
/* 211 */     id.setOrganizationId(this._organizationId);
/* 212 */     id.setCountryId(this._countryId);
/* 213 */     id.setPostalCodeId(this._postalCodeId);
/* 214 */     id.setAddressMode(this._addressMode);
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


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\com\impl\AddressPostalCodeDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */