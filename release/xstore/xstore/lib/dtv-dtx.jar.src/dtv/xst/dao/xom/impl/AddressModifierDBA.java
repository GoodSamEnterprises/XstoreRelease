/*     */ package dtv.xst.dao.xom.impl;
/*     */ 
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.impl.jdbc.IFiller;
/*     */ import dtv.data2.access.impl.jdbc.IJDBCTableAdapter;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.xom.AddressModifierId;
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
/*     */ public class AddressModifierDBA
/*     */   implements IJDBCTableAdapter
/*     */ {
/*     */   private static final long serialVersionUID = -1732016437L;
/*     */   private Long _organizationId;
/*     */   private String _orderId;
/*     */   private Long _sequence;
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
/*     */   private String _neighborhood;
/*     */   private String _county;
/*     */   private static final String SELECT_OBJECT = "SELECT t.organization_id, t.order_id, t.address_seq, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.address1, t.address2, t.address3, t.address4, t.apartment, t.city, t.state, t.postal_code, t.country, t.neighborhood, t.county FROM xom_address_mod t";
/*     */   private static final String SELECT_WHERE_OBJECT = " WHERE organization_id = ?  AND order_id = ?  AND address_seq = ?  ";
/*     */   
/*     */   public String getSelect() {
/*  47 */     return getSelectImpl();
/*     */   }
/*     */   
/*     */   private String getSelectImpl() {
/*  51 */     return "SELECT t.organization_id, t.order_id, t.address_seq, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.address1, t.address2, t.address3, t.address4, t.apartment, t.city, t.state, t.postal_code, t.country, t.neighborhood, t.county FROM xom_address_mod t";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectWhere() {
/*  57 */     return " WHERE organization_id = ?  AND order_id = ?  AND address_seq = ?  ";
/*     */   }
/*     */   
/*  60 */   private static final String[] INSERT_OBJECT = new String[] { "INSERT INTO xom_address_mod(organization_id, order_id, address_seq, create_date, create_user_id, update_date, update_user_id, address1, address2, address3, address4, apartment, city, state, postal_code, country, neighborhood, county) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" };
/*     */   
/*     */   public String[] getInsert() {
/*  63 */     return INSERT_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getInsertParameters() {
/*  67 */     Object[][] insertParameterObject = { { this._organizationId, this._orderId, this._sequence, this._createDate, this._createUserId, this._updateDate, this._updateUserId, this._address1, this._address2, this._address3, this._address4, this._apartment, this._city, this._state, this._postalCode, this._country, this._neighborhood, this._county } };
/*  68 */     return insertParameterObject;
/*     */   }
/*     */   
/*  71 */   private static final int[][] INSERT_PARAMETER_TYPES_OBJECT = new int[][] { { -5, 12, -5, 91, 12, 91, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12 } };
/*     */   
/*     */   public int[][] getInsertParameterTypes() {
/*  74 */     return INSERT_PARAMETER_TYPES_OBJECT;
/*     */   }
/*     */   
/*  77 */   private static final String[] UPDATE_OBJECT = new String[] { "UPDATE xom_address_mod SET update_date = ?, update_user_id = ?, address1 = ?, address2 = ?, address3 = ?, address4 = ?, apartment = ?, city = ?, state = ?, postal_code = ?, country = ?, neighborhood = ?, county = ?" };
/*     */   
/*     */   public String[] getUpdate() {
/*  80 */     return UPDATE_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getUpdateParameters() {
/*  84 */     Object[][] updateParameterObject = { { this._updateDate, this._updateUserId, this._address1, this._address2, this._address3, this._address4, this._apartment, this._city, this._state, this._postalCode, this._country, this._neighborhood, this._county } };
/*  85 */     return updateParameterObject;
/*     */   }
/*     */   
/*  88 */   private static final int[][] UPDATE_PARAMETER_TYPE_OBJECT = new int[][] { { 91, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12 } };
/*     */   public int[][] getUpdateParameterTypes() {
/*  90 */     return UPDATE_PARAMETER_TYPE_OBJECT;
/*     */   }
/*     */   
/*  93 */   private static final String[] DELETE_OBJECT = new String[] { "DELETE FROM xom_address_mod" }; private static final String WHERE_OBJECT = " WHERE organization_id = ?  AND order_id = ?  AND address_seq = ?  ";
/*     */   
/*     */   public String[] getDelete() {
/*  96 */     return DELETE_OBJECT;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWhere() {
/* 102 */     return " WHERE organization_id = ?  AND order_id = ?  AND address_seq = ?  ";
/*     */   }
/*     */   public Object[] getWhereParameters() {
/* 105 */     return new Object[] { this._organizationId, this._orderId, this._sequence };
/*     */   }
/*     */   
/* 108 */   private static final int[] WHERE_PARAMETER_OBJECT = new int[] { -5, 12, -5 };
/*     */   
/*     */   public int[] getWhereParameterTypes() {
/* 111 */     return WHERE_PARAMETER_OBJECT;
/*     */   }
/*     */   public String getTableName() {
/* 114 */     return "xom_address_mod";
/*     */   }
/*     */   
/*     */   public IFiller getFiller() {
/* 118 */     return getFillerImpl();
/*     */   }
/*     */   
/*     */   private IFiller getFillerImpl() {
/* 122 */     return new AddressModifierFiller(this);
/*     */   }
/*     */   
/*     */   private static class AddressModifierFiller
/*     */     implements IFiller {
/*     */     private AddressModifierDBA _parent;
/*     */     
/*     */     public AddressModifierFiller(AddressModifierDBA argParent) {
/* 130 */       this._parent = argParent;
/*     */     }
/*     */ 
/*     */     
/*     */     public void fill(ResultSet argResultSet) throws SQLException {
/* 135 */       long primitiveResult = argResultSet.getLong(1);
/* 136 */       if (primitiveResult != 0L || argResultSet.getObject(1) != null) {
/* 137 */         this._parent._organizationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */       
/* 141 */       this._parent._orderId = argResultSet.getString(2);
/*     */ 
/*     */       
/* 144 */       primitiveResult = argResultSet.getLong(3);
/* 145 */       if (primitiveResult != 0L || argResultSet.getObject(3) != null) {
/* 146 */         this._parent._sequence = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 151 */       Timestamp t4 = argResultSet.getTimestamp(4);
/* 152 */       if (t4 != null) {
/* 153 */         this._parent._createDate = (Date)new DtvDate(t4.getTime());
/*     */       } else {
/*     */         
/* 156 */         this._parent._createDate = null;
/*     */       } 
/*     */       
/* 159 */       this._parent._createUserId = argResultSet.getString(5);
/*     */       
/* 161 */       Timestamp t6 = argResultSet.getTimestamp(6);
/* 162 */       if (t6 != null) {
/* 163 */         this._parent._updateDate = (Date)new DtvDate(t6.getTime());
/*     */       } else {
/*     */         
/* 166 */         this._parent._updateDate = null;
/*     */       } 
/*     */       
/* 169 */       this._parent._updateUserId = argResultSet.getString(7);
/* 170 */       this._parent._address1 = argResultSet.getString(8);
/* 171 */       this._parent._address2 = argResultSet.getString(9);
/* 172 */       this._parent._address3 = argResultSet.getString(10);
/* 173 */       this._parent._address4 = argResultSet.getString(11);
/* 174 */       this._parent._apartment = argResultSet.getString(12);
/* 175 */       this._parent._city = argResultSet.getString(13);
/* 176 */       this._parent._state = argResultSet.getString(14);
/* 177 */       this._parent._postalCode = argResultSet.getString(15);
/* 178 */       this._parent._country = argResultSet.getString(16);
/* 179 */       this._parent._neighborhood = argResultSet.getString(17);
/* 180 */       this._parent._county = argResultSet.getString(18);
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDAO(IDataAccessObject argDAO) {
/* 185 */     argDAO.suppressStateChanges(true);
/* 186 */     AddressModifierDAO dao = (AddressModifierDAO)argDAO;
/* 187 */     dao.setOrganizationId(this._organizationId);
/* 188 */     dao.setOrderId(this._orderId);
/* 189 */     dao.setSequence(this._sequence);
/* 190 */     dao.setCreateDate(this._createDate);
/* 191 */     dao.setCreateUserId(this._createUserId);
/* 192 */     dao.setUpdateDate(this._updateDate);
/* 193 */     dao.setUpdateUserId(this._updateUserId);
/* 194 */     dao.setAddress1(this._address1);
/* 195 */     dao.setAddress2(this._address2);
/* 196 */     dao.setAddress3(this._address3);
/* 197 */     dao.setAddress4(this._address4);
/* 198 */     dao.setApartment(this._apartment);
/* 199 */     dao.setCity(this._city);
/* 200 */     dao.setState(this._state);
/* 201 */     dao.setPostalCode(this._postalCode);
/* 202 */     dao.setCountry(this._country);
/* 203 */     dao.setNeighborhood(this._neighborhood);
/* 204 */     dao.setCounty(this._county);
/* 205 */     argDAO.suppressStateChanges(false);
/* 206 */     return (IDataAccessObject)dao;
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDefaultDAO() {
/* 210 */     return loadDAO((IDataAccessObject)new AddressModifierDAO());
/*     */   }
/*     */   
/*     */   public void fill(IDataAccessObject argDAO) {
/* 214 */     AddressModifierDAO dao = (AddressModifierDAO)argDAO;
/* 215 */     this._organizationId = dao.getOrganizationId();
/* 216 */     this._orderId = dao.getOrderId();
/* 217 */     this._sequence = dao.getSequence();
/* 218 */     this._createDate = dao.getCreateDate();
/* 219 */     this._createUserId = dao.getCreateUserId();
/* 220 */     this._updateDate = dao.getUpdateDate();
/* 221 */     this._updateUserId = dao.getUpdateUserId();
/* 222 */     this._address1 = dao.getAddress1();
/* 223 */     this._address2 = dao.getAddress2();
/* 224 */     this._address3 = dao.getAddress3();
/* 225 */     this._address4 = dao.getAddress4();
/* 226 */     this._apartment = dao.getApartment();
/* 227 */     this._city = dao.getCity();
/* 228 */     this._state = dao.getState();
/* 229 */     this._postalCode = dao.getPostalCode();
/* 230 */     this._country = dao.getCountry();
/* 231 */     this._neighborhood = dao.getNeighborhood();
/* 232 */     this._county = dao.getCounty();
/*     */   }
/*     */   
/*     */   public PreparedStatement writeObjectId(IObjectId argId, PreparedStatement argStatement) throws SQLException {
/* 236 */     AddressModifierId id = (AddressModifierId)argId;
/* 237 */     argStatement.setLong(1, id.getOrganizationId().longValue());
/* 238 */     argStatement.setString(2, id.getOrderId());
/* 239 */     argStatement.setLong(3, id.getSequence().longValue());
/* 240 */     return argStatement;
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 244 */     AddressModifierId id = new AddressModifierId();
/* 245 */     id.setOrganizationId(this._organizationId);
/* 246 */     id.setOrderId(this._orderId);
/* 247 */     id.setSequence(this._sequence);
/* 248 */     return (IObjectId)id;
/*     */   }
/*     */ 
/*     */   
/*     */   public void fill(IJDBCTableAdapter argAdapter) {}
/*     */ 
/*     */   
/*     */   public boolean isExtensible() {
/* 256 */     return false;
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 260 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\xom\impl\AddressModifierDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */