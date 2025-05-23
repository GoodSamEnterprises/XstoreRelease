/*     */ package dtv.xst.dao.inv.impl;
/*     */ 
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.impl.jdbc.IFiller;
/*     */ import dtv.data2.access.impl.jdbc.IJDBCTableAdapter;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.inv.ShipmentAddressId;
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
/*     */ public class ShipmentAddressDBA
/*     */   implements IJDBCTableAdapter
/*     */ {
/*     */   private static final long serialVersionUID = -1035118374L;
/*     */   private Long _organizationId;
/*     */   private Long _retailLocationId;
/*     */   private String _documentId;
/*     */   private String _documentTypeCode;
/*     */   private Integer _shipmentSequence;
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
/*     */   private String _state;
/*     */   private String _postalCode;
/*     */   private String _country;
/*     */   private String _telephone1;
/*     */   private String _telephone2;
/*     */   private String _telephone3;
/*     */   private String _telephone4;
/*     */   private String _neighborhood;
/*     */   private String _county;
/*     */   private static final String SELECT_OBJECT = "SELECT t.organization_id, t.rtl_loc_id, t.invctl_document_id, t.document_typcode, t.shipment_seq, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.address1, t.address2, t.address3, t.address4, t.apartment, t.city, t.state, t.postal_code, t.country, t.telephone1, t.telephone2, t.telephone3, t.telephone4, t.neighborhood, t.county FROM inv_shipment_address t";
/*     */   private static final String SELECT_WHERE_OBJECT = " WHERE organization_id = ?  AND rtl_loc_id = ?  AND invctl_document_id = ?  AND document_typcode = ?  AND shipment_seq = ?  ";
/*     */   
/*     */   public String getSelect() {
/*  53 */     return getSelectImpl();
/*     */   }
/*     */   
/*     */   private String getSelectImpl() {
/*  57 */     return "SELECT t.organization_id, t.rtl_loc_id, t.invctl_document_id, t.document_typcode, t.shipment_seq, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.address1, t.address2, t.address3, t.address4, t.apartment, t.city, t.state, t.postal_code, t.country, t.telephone1, t.telephone2, t.telephone3, t.telephone4, t.neighborhood, t.county FROM inv_shipment_address t";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectWhere() {
/*  63 */     return " WHERE organization_id = ?  AND rtl_loc_id = ?  AND invctl_document_id = ?  AND document_typcode = ?  AND shipment_seq = ?  ";
/*     */   }
/*     */   
/*  66 */   private static final String[] INSERT_OBJECT = new String[] { "INSERT INTO inv_shipment_address(organization_id, rtl_loc_id, invctl_document_id, document_typcode, shipment_seq, create_date, create_user_id, update_date, update_user_id, address1, address2, address3, address4, apartment, city, state, postal_code, country, telephone1, telephone2, telephone3, telephone4, neighborhood, county) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" };
/*     */   
/*     */   public String[] getInsert() {
/*  69 */     return INSERT_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getInsertParameters() {
/*  73 */     Object[][] insertParameterObject = { { this._organizationId, this._retailLocationId, this._documentId, this._documentTypeCode, this._shipmentSequence, this._createDate, this._createUserId, this._updateDate, this._updateUserId, this._address1, this._address2, this._address3, this._address4, this._apartment, this._city, this._state, this._postalCode, this._country, this._telephone1, this._telephone2, this._telephone3, this._telephone4, this._neighborhood, this._county } };
/*  74 */     return insertParameterObject;
/*     */   }
/*     */   
/*  77 */   private static final int[][] INSERT_PARAMETER_TYPES_OBJECT = new int[][] { { -5, -5, 12, 12, 4, 91, 12, 91, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12 } };
/*     */   
/*     */   public int[][] getInsertParameterTypes() {
/*  80 */     return INSERT_PARAMETER_TYPES_OBJECT;
/*     */   }
/*     */   
/*  83 */   private static final String[] UPDATE_OBJECT = new String[] { "UPDATE inv_shipment_address SET update_date = ?, update_user_id = ?, address1 = ?, address2 = ?, address3 = ?, address4 = ?, apartment = ?, city = ?, state = ?, postal_code = ?, country = ?, telephone1 = ?, telephone2 = ?, telephone3 = ?, telephone4 = ?, neighborhood = ?, county = ?" };
/*     */   
/*     */   public String[] getUpdate() {
/*  86 */     return UPDATE_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getUpdateParameters() {
/*  90 */     Object[][] updateParameterObject = { { this._updateDate, this._updateUserId, this._address1, this._address2, this._address3, this._address4, this._apartment, this._city, this._state, this._postalCode, this._country, this._telephone1, this._telephone2, this._telephone3, this._telephone4, this._neighborhood, this._county } };
/*  91 */     return updateParameterObject;
/*     */   }
/*     */   
/*  94 */   private static final int[][] UPDATE_PARAMETER_TYPE_OBJECT = new int[][] { { 91, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12 } };
/*     */   public int[][] getUpdateParameterTypes() {
/*  96 */     return UPDATE_PARAMETER_TYPE_OBJECT;
/*     */   }
/*     */   
/*  99 */   private static final String[] DELETE_OBJECT = new String[] { "DELETE FROM inv_shipment_address" }; private static final String WHERE_OBJECT = " WHERE organization_id = ?  AND rtl_loc_id = ?  AND invctl_document_id = ?  AND document_typcode = ?  AND shipment_seq = ?  ";
/*     */   
/*     */   public String[] getDelete() {
/* 102 */     return DELETE_OBJECT;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWhere() {
/* 108 */     return " WHERE organization_id = ?  AND rtl_loc_id = ?  AND invctl_document_id = ?  AND document_typcode = ?  AND shipment_seq = ?  ";
/*     */   }
/*     */   public Object[] getWhereParameters() {
/* 111 */     return new Object[] { this._organizationId, this._retailLocationId, this._documentId, this._documentTypeCode, this._shipmentSequence };
/*     */   }
/*     */   
/* 114 */   private static final int[] WHERE_PARAMETER_OBJECT = new int[] { -5, -5, 12, 12, 4 };
/*     */   
/*     */   public int[] getWhereParameterTypes() {
/* 117 */     return WHERE_PARAMETER_OBJECT;
/*     */   }
/*     */   public String getTableName() {
/* 120 */     return "inv_shipment_address";
/*     */   }
/*     */   
/*     */   public IFiller getFiller() {
/* 124 */     return getFillerImpl();
/*     */   }
/*     */   
/*     */   private IFiller getFillerImpl() {
/* 128 */     return new ShipmentAddressFiller(this);
/*     */   }
/*     */   
/*     */   private static class ShipmentAddressFiller
/*     */     implements IFiller {
/*     */     private ShipmentAddressDBA _parent;
/*     */     
/*     */     public ShipmentAddressFiller(ShipmentAddressDBA argParent) {
/* 136 */       this._parent = argParent;
/*     */     }
/*     */ 
/*     */     
/*     */     public void fill(ResultSet argResultSet) throws SQLException {
/* 141 */       long l = argResultSet.getLong(1);
/* 142 */       if (l != 0L || argResultSet.getObject(1) != null) {
/* 143 */         this._parent._organizationId = Long.valueOf(l);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 149 */       l = argResultSet.getLong(2);
/* 150 */       if (l != 0L || argResultSet.getObject(2) != null) {
/* 151 */         this._parent._retailLocationId = Long.valueOf(l);
/*     */       }
/*     */ 
/*     */       
/* 155 */       this._parent._documentId = argResultSet.getString(3);
/* 156 */       this._parent._documentTypeCode = argResultSet.getString(4);
/*     */ 
/*     */       
/* 159 */       int primitiveResult = argResultSet.getInt(5);
/* 160 */       if (primitiveResult != 0 || argResultSet.getObject(5) != null) {
/* 161 */         this._parent._shipmentSequence = Integer.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 166 */       Timestamp t6 = argResultSet.getTimestamp(6);
/* 167 */       if (t6 != null) {
/* 168 */         this._parent._createDate = (Date)new DtvDate(t6.getTime());
/*     */       } else {
/*     */         
/* 171 */         this._parent._createDate = null;
/*     */       } 
/*     */       
/* 174 */       this._parent._createUserId = argResultSet.getString(7);
/*     */       
/* 176 */       Timestamp t8 = argResultSet.getTimestamp(8);
/* 177 */       if (t8 != null) {
/* 178 */         this._parent._updateDate = (Date)new DtvDate(t8.getTime());
/*     */       } else {
/*     */         
/* 181 */         this._parent._updateDate = null;
/*     */       } 
/*     */       
/* 184 */       this._parent._updateUserId = argResultSet.getString(9);
/* 185 */       this._parent._address1 = argResultSet.getString(10);
/* 186 */       this._parent._address2 = argResultSet.getString(11);
/* 187 */       this._parent._address3 = argResultSet.getString(12);
/* 188 */       this._parent._address4 = argResultSet.getString(13);
/* 189 */       this._parent._apartment = argResultSet.getString(14);
/* 190 */       this._parent._city = argResultSet.getString(15);
/* 191 */       this._parent._state = argResultSet.getString(16);
/* 192 */       this._parent._postalCode = argResultSet.getString(17);
/* 193 */       this._parent._country = argResultSet.getString(18);
/* 194 */       this._parent._telephone1 = argResultSet.getString(19);
/* 195 */       this._parent._telephone2 = argResultSet.getString(20);
/* 196 */       this._parent._telephone3 = argResultSet.getString(21);
/* 197 */       this._parent._telephone4 = argResultSet.getString(22);
/* 198 */       this._parent._neighborhood = argResultSet.getString(23);
/* 199 */       this._parent._county = argResultSet.getString(24);
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDAO(IDataAccessObject argDAO) {
/* 204 */     argDAO.suppressStateChanges(true);
/* 205 */     ShipmentAddressDAO dao = (ShipmentAddressDAO)argDAO;
/* 206 */     dao.setOrganizationId(this._organizationId);
/* 207 */     dao.setRetailLocationId(this._retailLocationId);
/* 208 */     dao.setDocumentId(this._documentId);
/* 209 */     dao.setDocumentTypeCode(this._documentTypeCode);
/* 210 */     dao.setShipmentSequence(this._shipmentSequence);
/* 211 */     dao.setCreateDate(this._createDate);
/* 212 */     dao.setCreateUserId(this._createUserId);
/* 213 */     dao.setUpdateDate(this._updateDate);
/* 214 */     dao.setUpdateUserId(this._updateUserId);
/* 215 */     dao.setAddress1(this._address1);
/* 216 */     dao.setAddress2(this._address2);
/* 217 */     dao.setAddress3(this._address3);
/* 218 */     dao.setAddress4(this._address4);
/* 219 */     dao.setApartment(this._apartment);
/* 220 */     dao.setCity(this._city);
/* 221 */     dao.setState(this._state);
/* 222 */     dao.setPostalCode(this._postalCode);
/* 223 */     dao.setCountry(this._country);
/* 224 */     dao.setTelephone1(this._telephone1);
/* 225 */     dao.setTelephone2(this._telephone2);
/* 226 */     dao.setTelephone3(this._telephone3);
/* 227 */     dao.setTelephone4(this._telephone4);
/* 228 */     dao.setNeighborhood(this._neighborhood);
/* 229 */     dao.setCounty(this._county);
/* 230 */     argDAO.suppressStateChanges(false);
/* 231 */     return (IDataAccessObject)dao;
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDefaultDAO() {
/* 235 */     return loadDAO((IDataAccessObject)new ShipmentAddressDAO());
/*     */   }
/*     */   
/*     */   public void fill(IDataAccessObject argDAO) {
/* 239 */     ShipmentAddressDAO dao = (ShipmentAddressDAO)argDAO;
/* 240 */     this._organizationId = dao.getOrganizationId();
/* 241 */     this._retailLocationId = dao.getRetailLocationId();
/* 242 */     this._documentId = dao.getDocumentId();
/* 243 */     this._documentTypeCode = dao.getDocumentTypeCode();
/* 244 */     this._shipmentSequence = dao.getShipmentSequence();
/* 245 */     this._createDate = dao.getCreateDate();
/* 246 */     this._createUserId = dao.getCreateUserId();
/* 247 */     this._updateDate = dao.getUpdateDate();
/* 248 */     this._updateUserId = dao.getUpdateUserId();
/* 249 */     this._address1 = dao.getAddress1();
/* 250 */     this._address2 = dao.getAddress2();
/* 251 */     this._address3 = dao.getAddress3();
/* 252 */     this._address4 = dao.getAddress4();
/* 253 */     this._apartment = dao.getApartment();
/* 254 */     this._city = dao.getCity();
/* 255 */     this._state = dao.getState();
/* 256 */     this._postalCode = dao.getPostalCode();
/* 257 */     this._country = dao.getCountry();
/* 258 */     this._telephone1 = dao.getTelephone1();
/* 259 */     this._telephone2 = dao.getTelephone2();
/* 260 */     this._telephone3 = dao.getTelephone3();
/* 261 */     this._telephone4 = dao.getTelephone4();
/* 262 */     this._neighborhood = dao.getNeighborhood();
/* 263 */     this._county = dao.getCounty();
/*     */   }
/*     */   
/*     */   public PreparedStatement writeObjectId(IObjectId argId, PreparedStatement argStatement) throws SQLException {
/* 267 */     ShipmentAddressId id = (ShipmentAddressId)argId;
/* 268 */     argStatement.setLong(1, id.getOrganizationId().longValue());
/* 269 */     argStatement.setLong(2, id.getRetailLocationId().longValue());
/* 270 */     argStatement.setString(3, id.getDocumentId());
/* 271 */     argStatement.setString(4, id.getDocumentTypeCode());
/* 272 */     argStatement.setInt(5, id.getShipmentSequence().intValue());
/* 273 */     return argStatement;
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 277 */     ShipmentAddressId id = new ShipmentAddressId();
/* 278 */     id.setOrganizationId(this._organizationId);
/* 279 */     id.setRetailLocationId(this._retailLocationId);
/* 280 */     id.setDocumentId(this._documentId);
/* 281 */     id.setDocumentTypeCode(this._documentTypeCode);
/* 282 */     id.setShipmentSequence(this._shipmentSequence);
/* 283 */     return (IObjectId)id;
/*     */   }
/*     */ 
/*     */   
/*     */   public void fill(IJDBCTableAdapter argAdapter) {}
/*     */ 
/*     */   
/*     */   public boolean isExtensible() {
/* 291 */     return false;
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 295 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\inv\impl\ShipmentAddressDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */