/*     */ package dtv.xst.dao.com.impl;
/*     */ 
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.impl.jdbc.IFiller;
/*     */ import dtv.data2.access.impl.jdbc.IJDBCTableAdapter;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.com.AddressCountryId;
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
/*     */ public class AddressCountryDBA
/*     */   implements IJDBCTableAdapter
/*     */ {
/*     */   private static final long serialVersionUID = 367625506L;
/*     */   private Long _organizationId;
/*     */   private String _countryId;
/*     */   private String _addressMode;
/*     */   private Date _createDate;
/*     */   private String _createUserId;
/*     */   private Date _updateDate;
/*     */   private String _updateUserId;
/*     */   private String _countryName;
/*     */   private Integer _postalCodeMaxLength;
/*     */   private static final String SELECT_OBJECT = "SELECT t.organization_id, t.country_id, t.address_mode, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.country_name, t.max_postal_length FROM com_address_country t";
/*     */   private static final String SELECT_WHERE_OBJECT = " WHERE organization_id = ?  AND country_id = ?  AND address_mode = ?  ";
/*     */   
/*     */   public String getSelect() {
/*  38 */     return getSelectImpl();
/*     */   }
/*     */   
/*     */   private String getSelectImpl() {
/*  42 */     return "SELECT t.organization_id, t.country_id, t.address_mode, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.country_name, t.max_postal_length FROM com_address_country t";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectWhere() {
/*  48 */     return " WHERE organization_id = ?  AND country_id = ?  AND address_mode = ?  ";
/*     */   }
/*     */   
/*  51 */   private static final String[] INSERT_OBJECT = new String[] { "INSERT INTO com_address_country(organization_id, country_id, address_mode, create_date, create_user_id, update_date, update_user_id, country_name, max_postal_length) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)" };
/*     */   
/*     */   public String[] getInsert() {
/*  54 */     return INSERT_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getInsertParameters() {
/*  58 */     Object[][] insertParameterObject = { { this._organizationId, this._countryId, this._addressMode, this._createDate, this._createUserId, this._updateDate, this._updateUserId, this._countryName, this._postalCodeMaxLength } };
/*  59 */     return insertParameterObject;
/*     */   }
/*     */   
/*  62 */   private static final int[][] INSERT_PARAMETER_TYPES_OBJECT = new int[][] { { -5, 12, 12, 91, 12, 91, 12, 12, 4 } };
/*     */   
/*     */   public int[][] getInsertParameterTypes() {
/*  65 */     return INSERT_PARAMETER_TYPES_OBJECT;
/*     */   }
/*     */   
/*  68 */   private static final String[] UPDATE_OBJECT = new String[] { "UPDATE com_address_country SET update_date = ?, update_user_id = ?, country_name = ?, max_postal_length = ?" };
/*     */   
/*     */   public String[] getUpdate() {
/*  71 */     return UPDATE_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getUpdateParameters() {
/*  75 */     Object[][] updateParameterObject = { { this._updateDate, this._updateUserId, this._countryName, this._postalCodeMaxLength } };
/*  76 */     return updateParameterObject;
/*     */   }
/*     */   
/*  79 */   private static final int[][] UPDATE_PARAMETER_TYPE_OBJECT = new int[][] { { 91, 12, 12, 4 } };
/*     */   public int[][] getUpdateParameterTypes() {
/*  81 */     return UPDATE_PARAMETER_TYPE_OBJECT;
/*     */   }
/*     */   
/*  84 */   private static final String[] DELETE_OBJECT = new String[] { "DELETE FROM com_address_country" }; private static final String WHERE_OBJECT = " WHERE organization_id = ?  AND country_id = ?  AND address_mode = ?  ";
/*     */   
/*     */   public String[] getDelete() {
/*  87 */     return DELETE_OBJECT;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWhere() {
/*  93 */     return " WHERE organization_id = ?  AND country_id = ?  AND address_mode = ?  ";
/*     */   }
/*     */   public Object[] getWhereParameters() {
/*  96 */     return new Object[] { this._organizationId, this._countryId, this._addressMode };
/*     */   }
/*     */   
/*  99 */   private static final int[] WHERE_PARAMETER_OBJECT = new int[] { -5, 12, 12 };
/*     */   
/*     */   public int[] getWhereParameterTypes() {
/* 102 */     return WHERE_PARAMETER_OBJECT;
/*     */   }
/*     */   public String getTableName() {
/* 105 */     return "com_address_country";
/*     */   }
/*     */   
/*     */   public IFiller getFiller() {
/* 109 */     return getFillerImpl();
/*     */   }
/*     */   
/*     */   private IFiller getFillerImpl() {
/* 113 */     return new AddressCountryFiller(this);
/*     */   }
/*     */   
/*     */   private static class AddressCountryFiller
/*     */     implements IFiller {
/*     */     private AddressCountryDBA _parent;
/*     */     
/*     */     public AddressCountryFiller(AddressCountryDBA argParent) {
/* 121 */       this._parent = argParent;
/*     */     }
/*     */ 
/*     */     
/*     */     public void fill(ResultSet argResultSet) throws SQLException {
/* 126 */       long primitiveResult = argResultSet.getLong(1);
/* 127 */       if (primitiveResult != 0L || argResultSet.getObject(1) != null) {
/* 128 */         this._parent._organizationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */       
/* 132 */       this._parent._countryId = argResultSet.getString(2);
/* 133 */       this._parent._addressMode = argResultSet.getString(3);
/*     */       
/* 135 */       Timestamp t4 = argResultSet.getTimestamp(4);
/* 136 */       if (t4 != null) {
/* 137 */         this._parent._createDate = (Date)new DtvDate(t4.getTime());
/*     */       } else {
/*     */         
/* 140 */         this._parent._createDate = null;
/*     */       } 
/*     */       
/* 143 */       this._parent._createUserId = argResultSet.getString(5);
/*     */       
/* 145 */       Timestamp t6 = argResultSet.getTimestamp(6);
/* 146 */       if (t6 != null) {
/* 147 */         this._parent._updateDate = (Date)new DtvDate(t6.getTime());
/*     */       } else {
/*     */         
/* 150 */         this._parent._updateDate = null;
/*     */       } 
/*     */       
/* 153 */       this._parent._updateUserId = argResultSet.getString(7);
/* 154 */       this._parent._countryName = argResultSet.getString(8);
/*     */ 
/*     */       
/* 157 */       int i = argResultSet.getInt(9);
/* 158 */       if (i != 0 || argResultSet.getObject(9) != null) {
/* 159 */         this._parent._postalCodeMaxLength = Integer.valueOf(i);
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IDataAccessObject loadDAO(IDataAccessObject argDAO) {
/* 167 */     argDAO.suppressStateChanges(true);
/* 168 */     AddressCountryDAO dao = (AddressCountryDAO)argDAO;
/* 169 */     dao.setOrganizationId(this._organizationId);
/* 170 */     dao.setCountryId(this._countryId);
/* 171 */     dao.setAddressMode(this._addressMode);
/* 172 */     dao.setCreateDate(this._createDate);
/* 173 */     dao.setCreateUserId(this._createUserId);
/* 174 */     dao.setUpdateDate(this._updateDate);
/* 175 */     dao.setUpdateUserId(this._updateUserId);
/* 176 */     dao.setCountryName(this._countryName);
/* 177 */     dao.setPostalCodeMaxLength(this._postalCodeMaxLength);
/* 178 */     argDAO.suppressStateChanges(false);
/* 179 */     return (IDataAccessObject)dao;
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDefaultDAO() {
/* 183 */     return loadDAO((IDataAccessObject)new AddressCountryDAO());
/*     */   }
/*     */   
/*     */   public void fill(IDataAccessObject argDAO) {
/* 187 */     AddressCountryDAO dao = (AddressCountryDAO)argDAO;
/* 188 */     this._organizationId = dao.getOrganizationId();
/* 189 */     this._countryId = dao.getCountryId();
/* 190 */     this._addressMode = dao.getAddressMode();
/* 191 */     this._createDate = dao.getCreateDate();
/* 192 */     this._createUserId = dao.getCreateUserId();
/* 193 */     this._updateDate = dao.getUpdateDate();
/* 194 */     this._updateUserId = dao.getUpdateUserId();
/* 195 */     this._countryName = dao.getCountryName();
/* 196 */     this._postalCodeMaxLength = dao.getPostalCodeMaxLength();
/*     */   }
/*     */   
/*     */   public PreparedStatement writeObjectId(IObjectId argId, PreparedStatement argStatement) throws SQLException {
/* 200 */     AddressCountryId id = (AddressCountryId)argId;
/* 201 */     argStatement.setLong(1, id.getOrganizationId().longValue());
/* 202 */     argStatement.setString(2, id.getCountryId());
/* 203 */     argStatement.setString(3, id.getAddressMode());
/* 204 */     return argStatement;
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 208 */     AddressCountryId id = new AddressCountryId();
/* 209 */     id.setOrganizationId(this._organizationId);
/* 210 */     id.setCountryId(this._countryId);
/* 211 */     id.setAddressMode(this._addressMode);
/* 212 */     return (IObjectId)id;
/*     */   }
/*     */ 
/*     */   
/*     */   public void fill(IJDBCTableAdapter argAdapter) {}
/*     */ 
/*     */   
/*     */   public boolean isExtensible() {
/* 220 */     return false;
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 224 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\com\impl\AddressCountryDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */