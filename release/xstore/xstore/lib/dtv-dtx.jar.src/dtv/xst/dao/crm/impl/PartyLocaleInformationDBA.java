/*     */ package dtv.xst.dao.crm.impl;
/*     */ 
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.impl.jdbc.IFiller;
/*     */ import dtv.data2.access.impl.jdbc.IJDBCTableAdapter;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.crm.PartyLocaleInformationId;
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
/*     */ public class PartyLocaleInformationDBA
/*     */   implements IJDBCTableAdapter
/*     */ {
/*     */   private static final long serialVersionUID = -1499026356L;
/*     */   private Long _organizationId;
/*     */   private Long _partyId;
/*     */   private Integer _sequence;
/*     */   private Date _createDate;
/*     */   private String _createUserId;
/*     */   private Date _updateDate;
/*     */   private String _updateUserId;
/*     */   private String _address1;
/*     */   private String _address2;
/*     */   private String _address3;
/*     */   private String _address4;
/*     */   private String _apartment;
/*     */   private String _city;
/*     */   private String _country;
/*     */   private String _postalCode;
/*     */   private String _state;
/*     */   private Boolean _contact;
/*     */   private Boolean _primary;
/*     */   private String _addressType;
/*     */   private String _neighborhood;
/*     */   private String _county;
/*     */   private static final String SELECT_OBJECT = "SELECT t.organization_id, t.party_id, t.party_locale_seq, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.address1, t.address2, t.address3, t.address4, t.apartment, t.city, t.country, t.postal_code, t.state, t.contact_flag, t.primary_flag, t.address_type, t.neighborhood, t.county FROM crm_party_locale_information t";
/*     */   private static final String SELECT_WHERE_OBJECT = " WHERE organization_id = ?  AND party_id = ?  AND party_locale_seq = ?  ";
/*     */   
/*     */   public String getSelect() {
/*  50 */     return getSelectImpl();
/*     */   }
/*     */   
/*     */   private String getSelectImpl() {
/*  54 */     return "SELECT t.organization_id, t.party_id, t.party_locale_seq, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.address1, t.address2, t.address3, t.address4, t.apartment, t.city, t.country, t.postal_code, t.state, t.contact_flag, t.primary_flag, t.address_type, t.neighborhood, t.county FROM crm_party_locale_information t";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectWhere() {
/*  60 */     return " WHERE organization_id = ?  AND party_id = ?  AND party_locale_seq = ?  ";
/*     */   }
/*     */   
/*  63 */   private static final String[] INSERT_OBJECT = new String[] { "INSERT INTO crm_party_locale_information(organization_id, party_id, party_locale_seq, create_date, create_user_id, update_date, update_user_id, address1, address2, address3, address4, apartment, city, country, postal_code, state, contact_flag, primary_flag, address_type, neighborhood, county) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" };
/*     */   
/*     */   public String[] getInsert() {
/*  66 */     return INSERT_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getInsertParameters() {
/*  70 */     Object[][] insertParameterObject = { { this._organizationId, this._partyId, this._sequence, this._createDate, this._createUserId, this._updateDate, this._updateUserId, this._address1, this._address2, this._address3, this._address4, this._apartment, this._city, this._country, this._postalCode, this._state, this._contact, this._primary, this._addressType, this._neighborhood, this._county } };
/*  71 */     return insertParameterObject;
/*     */   }
/*     */   
/*  74 */   private static final int[][] INSERT_PARAMETER_TYPES_OBJECT = new int[][] { { -5, -5, 4, 91, 12, 91, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, -7, -7, 12, 12, 12 } };
/*     */   
/*     */   public int[][] getInsertParameterTypes() {
/*  77 */     return INSERT_PARAMETER_TYPES_OBJECT;
/*     */   }
/*     */   
/*  80 */   private static final String[] UPDATE_OBJECT = new String[] { "UPDATE crm_party_locale_information SET update_date = ?, update_user_id = ?, address1 = ?, address2 = ?, address3 = ?, address4 = ?, apartment = ?, city = ?, country = ?, postal_code = ?, state = ?, contact_flag = ?, primary_flag = ?, address_type = ?, neighborhood = ?, county = ?" };
/*     */   
/*     */   public String[] getUpdate() {
/*  83 */     return UPDATE_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getUpdateParameters() {
/*  87 */     Object[][] updateParameterObject = { { this._updateDate, this._updateUserId, this._address1, this._address2, this._address3, this._address4, this._apartment, this._city, this._country, this._postalCode, this._state, this._contact, this._primary, this._addressType, this._neighborhood, this._county } };
/*  88 */     return updateParameterObject;
/*     */   }
/*     */   
/*  91 */   private static final int[][] UPDATE_PARAMETER_TYPE_OBJECT = new int[][] { { 91, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, -7, -7, 12, 12, 12 } };
/*     */   public int[][] getUpdateParameterTypes() {
/*  93 */     return UPDATE_PARAMETER_TYPE_OBJECT;
/*     */   }
/*     */   
/*  96 */   private static final String[] DELETE_OBJECT = new String[] { "DELETE FROM crm_party_locale_information" }; private static final String WHERE_OBJECT = " WHERE organization_id = ?  AND party_id = ?  AND party_locale_seq = ?  ";
/*     */   
/*     */   public String[] getDelete() {
/*  99 */     return DELETE_OBJECT;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWhere() {
/* 105 */     return " WHERE organization_id = ?  AND party_id = ?  AND party_locale_seq = ?  ";
/*     */   }
/*     */   public Object[] getWhereParameters() {
/* 108 */     return new Object[] { this._organizationId, this._partyId, this._sequence };
/*     */   }
/*     */   
/* 111 */   private static final int[] WHERE_PARAMETER_OBJECT = new int[] { -5, -5, 4 };
/*     */   
/*     */   public int[] getWhereParameterTypes() {
/* 114 */     return WHERE_PARAMETER_OBJECT;
/*     */   }
/*     */   public String getTableName() {
/* 117 */     return "crm_party_locale_information";
/*     */   }
/*     */   
/*     */   public IFiller getFiller() {
/* 121 */     return getFillerImpl();
/*     */   }
/*     */   
/*     */   private IFiller getFillerImpl() {
/* 125 */     return new PartyLocaleInformationFiller(this);
/*     */   }
/*     */   
/*     */   private static class PartyLocaleInformationFiller
/*     */     implements IFiller {
/*     */     private PartyLocaleInformationDBA _parent;
/*     */     
/*     */     public PartyLocaleInformationFiller(PartyLocaleInformationDBA argParent) {
/* 133 */       this._parent = argParent;
/*     */     }
/*     */ 
/*     */     
/*     */     public void fill(ResultSet argResultSet) throws SQLException {
/* 138 */       long l = argResultSet.getLong(1);
/* 139 */       if (l != 0L || argResultSet.getObject(1) != null) {
/* 140 */         this._parent._organizationId = Long.valueOf(l);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 146 */       l = argResultSet.getLong(2);
/* 147 */       if (l != 0L || argResultSet.getObject(2) != null) {
/* 148 */         this._parent._partyId = Long.valueOf(l);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 154 */       int primitiveResult = argResultSet.getInt(3);
/* 155 */       if (primitiveResult != 0 || argResultSet.getObject(3) != null) {
/* 156 */         this._parent._sequence = Integer.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 161 */       Timestamp t4 = argResultSet.getTimestamp(4);
/* 162 */       if (t4 != null) {
/* 163 */         this._parent._createDate = (Date)new DtvDate(t4.getTime());
/*     */       } else {
/*     */         
/* 166 */         this._parent._createDate = null;
/*     */       } 
/*     */       
/* 169 */       this._parent._createUserId = argResultSet.getString(5);
/*     */       
/* 171 */       Timestamp t6 = argResultSet.getTimestamp(6);
/* 172 */       if (t6 != null) {
/* 173 */         this._parent._updateDate = (Date)new DtvDate(t6.getTime());
/*     */       } else {
/*     */         
/* 176 */         this._parent._updateDate = null;
/*     */       } 
/*     */       
/* 179 */       this._parent._updateUserId = argResultSet.getString(7);
/* 180 */       this._parent._address1 = argResultSet.getString(8);
/* 181 */       this._parent._address2 = argResultSet.getString(9);
/* 182 */       this._parent._address3 = argResultSet.getString(10);
/* 183 */       this._parent._address4 = argResultSet.getString(11);
/* 184 */       this._parent._apartment = argResultSet.getString(12);
/* 185 */       this._parent._city = argResultSet.getString(13);
/* 186 */       this._parent._country = argResultSet.getString(14);
/* 187 */       this._parent._postalCode = argResultSet.getString(15);
/* 188 */       this._parent._state = argResultSet.getString(16);
/* 189 */       this._parent._contact = Boolean.valueOf(argResultSet.getBoolean(17));
/* 190 */       this._parent._primary = Boolean.valueOf(argResultSet.getBoolean(18));
/* 191 */       this._parent._addressType = argResultSet.getString(19);
/* 192 */       this._parent._neighborhood = argResultSet.getString(20);
/* 193 */       this._parent._county = argResultSet.getString(21);
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDAO(IDataAccessObject argDAO) {
/* 198 */     argDAO.suppressStateChanges(true);
/* 199 */     PartyLocaleInformationDAO dao = (PartyLocaleInformationDAO)argDAO;
/* 200 */     dao.setOrganizationId(this._organizationId);
/* 201 */     dao.setPartyId(this._partyId);
/* 202 */     dao.setSequence(this._sequence);
/* 203 */     dao.setCreateDate(this._createDate);
/* 204 */     dao.setCreateUserId(this._createUserId);
/* 205 */     dao.setUpdateDate(this._updateDate);
/* 206 */     dao.setUpdateUserId(this._updateUserId);
/* 207 */     dao.setAddress1(this._address1);
/* 208 */     dao.setAddress2(this._address2);
/* 209 */     dao.setAddress3(this._address3);
/* 210 */     dao.setAddress4(this._address4);
/* 211 */     dao.setApartment(this._apartment);
/* 212 */     dao.setCity(this._city);
/* 213 */     dao.setCountry(this._country);
/* 214 */     dao.setPostalCode(this._postalCode);
/* 215 */     dao.setState(this._state);
/* 216 */     dao.setContact(this._contact);
/* 217 */     dao.setPrimary(this._primary);
/* 218 */     dao.setAddressType(this._addressType);
/* 219 */     dao.setNeighborhood(this._neighborhood);
/* 220 */     dao.setCounty(this._county);
/* 221 */     argDAO.suppressStateChanges(false);
/* 222 */     return (IDataAccessObject)dao;
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDefaultDAO() {
/* 226 */     return loadDAO((IDataAccessObject)new PartyLocaleInformationDAO());
/*     */   }
/*     */   
/*     */   public void fill(IDataAccessObject argDAO) {
/* 230 */     PartyLocaleInformationDAO dao = (PartyLocaleInformationDAO)argDAO;
/* 231 */     this._organizationId = dao.getOrganizationId();
/* 232 */     this._partyId = dao.getPartyId();
/* 233 */     this._sequence = dao.getSequence();
/* 234 */     this._createDate = dao.getCreateDate();
/* 235 */     this._createUserId = dao.getCreateUserId();
/* 236 */     this._updateDate = dao.getUpdateDate();
/* 237 */     this._updateUserId = dao.getUpdateUserId();
/* 238 */     this._address1 = dao.getAddress1();
/* 239 */     this._address2 = dao.getAddress2();
/* 240 */     this._address3 = dao.getAddress3();
/* 241 */     this._address4 = dao.getAddress4();
/* 242 */     this._apartment = dao.getApartment();
/* 243 */     this._city = dao.getCity();
/* 244 */     this._country = dao.getCountry();
/* 245 */     this._postalCode = dao.getPostalCode();
/* 246 */     this._state = dao.getState();
/* 247 */     this._contact = (dao.getContact() != null) ? dao.getContact() : Boolean.valueOf(false);
/* 248 */     this._primary = (dao.getPrimary() != null) ? dao.getPrimary() : Boolean.valueOf(false);
/* 249 */     this._addressType = dao.getAddressType();
/* 250 */     this._neighborhood = dao.getNeighborhood();
/* 251 */     this._county = dao.getCounty();
/*     */   }
/*     */   
/*     */   public PreparedStatement writeObjectId(IObjectId argId, PreparedStatement argStatement) throws SQLException {
/* 255 */     PartyLocaleInformationId id = (PartyLocaleInformationId)argId;
/* 256 */     argStatement.setLong(1, id.getOrganizationId().longValue());
/* 257 */     argStatement.setLong(2, id.getPartyId().longValue());
/* 258 */     argStatement.setInt(3, id.getSequence().intValue());
/* 259 */     return argStatement;
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 263 */     PartyLocaleInformationId id = new PartyLocaleInformationId();
/* 264 */     id.setOrganizationId(this._organizationId);
/* 265 */     id.setPartyId(this._partyId);
/* 266 */     id.setSequence(this._sequence);
/* 267 */     return (IObjectId)id;
/*     */   }
/*     */ 
/*     */   
/*     */   public void fill(IJDBCTableAdapter argAdapter) {}
/*     */ 
/*     */   
/*     */   public boolean isExtensible() {
/* 275 */     return false;
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 279 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\crm\impl\PartyLocaleInformationDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */