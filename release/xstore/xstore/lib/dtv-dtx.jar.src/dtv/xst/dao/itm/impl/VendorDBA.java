/*     */ package dtv.xst.dao.itm.impl;
/*     */ 
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.impl.jdbc.IFiller;
/*     */ import dtv.data2.access.impl.jdbc.IJDBCTableAdapter;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.util.ObjectUtils;
/*     */ import dtv.xst.dao.itm.VendorId;
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
/*     */ public class VendorDBA
/*     */   implements IJDBCTableAdapter
/*     */ {
/*     */   private static final long serialVersionUID = -1736208024L;
/*     */   private Long _organizationId;
/*     */   private String _vendorId;
/*     */   private Date _createDate;
/*     */   private String _createUserId;
/*     */   private Date _updateDate;
/*     */   private String _updateUserId;
/*     */   private String _orgCode;
/*     */   private String _orgValue;
/*     */   private String _name;
/*     */   private String _typeCode;
/*     */   private String _telephone;
/*     */   private String _fax;
/*     */   private String _contact;
/*     */   private String _contactTelephone;
/*     */   private String _buyer;
/*     */   private String _status;
/*     */   private String _addressId;
/*     */   private static final String SELECT_OBJECT = "SELECT t.organization_id, t.vendor_id, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.org_code, t.org_value, t.name, t.typcode, t.telephone, t.fax, t.contact, t.contact_telephone, t.buyer, t.status, t.address_id FROM itm_vendor t";
/*     */   private static final String SELECT_WHERE_OBJECT = " WHERE organization_id = ?  AND vendor_id = ?  ";
/*     */   
/*     */   public String getSelect() {
/*  46 */     return getSelectImpl();
/*     */   }
/*     */   
/*     */   private String getSelectImpl() {
/*  50 */     return "SELECT t.organization_id, t.vendor_id, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.org_code, t.org_value, t.name, t.typcode, t.telephone, t.fax, t.contact, t.contact_telephone, t.buyer, t.status, t.address_id FROM itm_vendor t";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectWhere() {
/*  56 */     return " WHERE organization_id = ?  AND vendor_id = ?  ";
/*     */   }
/*     */   
/*  59 */   private static final String[] INSERT_OBJECT = new String[] { "INSERT INTO itm_vendor(organization_id, vendor_id, create_date, create_user_id, update_date, update_user_id, org_code, org_value, name, typcode, telephone, fax, contact, contact_telephone, buyer, status, address_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" };
/*     */   
/*     */   public String[] getInsert() {
/*  62 */     return INSERT_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getInsertParameters() {
/*  66 */     Object[][] insertParameterObject = { { this._organizationId, this._vendorId, this._createDate, this._createUserId, this._updateDate, this._updateUserId, ObjectUtils.coalesce((Object[])new String[] { this._orgCode, "*" }), ObjectUtils.coalesce((Object[])new String[] { this._orgValue, "*" }), this._name, this._typeCode, this._telephone, this._fax, this._contact, this._contactTelephone, this._buyer, this._status, this._addressId } };
/*  67 */     return insertParameterObject;
/*     */   }
/*     */   
/*  70 */   private static final int[][] INSERT_PARAMETER_TYPES_OBJECT = new int[][] { { -5, 12, 91, 12, 91, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12 } };
/*     */   
/*     */   public int[][] getInsertParameterTypes() {
/*  73 */     return INSERT_PARAMETER_TYPES_OBJECT;
/*     */   }
/*     */   
/*  76 */   private static final String[] UPDATE_OBJECT = new String[] { "UPDATE itm_vendor SET update_date = ?, update_user_id = ?, org_code = ?, org_value = ?, name = ?, typcode = ?, telephone = ?, fax = ?, contact = ?, contact_telephone = ?, buyer = ?, status = ?, address_id = ?" };
/*     */   
/*     */   public String[] getUpdate() {
/*  79 */     return UPDATE_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getUpdateParameters() {
/*  83 */     Object[][] updateParameterObject = { { this._updateDate, this._updateUserId, this._orgCode, this._orgValue, this._name, this._typeCode, this._telephone, this._fax, this._contact, this._contactTelephone, this._buyer, this._status, this._addressId } };
/*  84 */     return updateParameterObject;
/*     */   }
/*     */   
/*  87 */   private static final int[][] UPDATE_PARAMETER_TYPE_OBJECT = new int[][] { { 91, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12 } };
/*     */   public int[][] getUpdateParameterTypes() {
/*  89 */     return UPDATE_PARAMETER_TYPE_OBJECT;
/*     */   }
/*     */   
/*  92 */   private static final String[] DELETE_OBJECT = new String[] { "DELETE FROM itm_vendor" }; private static final String WHERE_OBJECT = " WHERE organization_id = ?  AND vendor_id = ?  ";
/*     */   
/*     */   public String[] getDelete() {
/*  95 */     return DELETE_OBJECT;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWhere() {
/* 101 */     return " WHERE organization_id = ?  AND vendor_id = ?  ";
/*     */   }
/*     */   public Object[] getWhereParameters() {
/* 104 */     return new Object[] { this._organizationId, this._vendorId };
/*     */   }
/*     */   
/* 107 */   private static final int[] WHERE_PARAMETER_OBJECT = new int[] { -5, 12 };
/*     */   
/*     */   public int[] getWhereParameterTypes() {
/* 110 */     return WHERE_PARAMETER_OBJECT;
/*     */   }
/*     */   public String getTableName() {
/* 113 */     return "itm_vendor";
/*     */   }
/*     */   
/*     */   public IFiller getFiller() {
/* 117 */     return getFillerImpl();
/*     */   }
/*     */   
/*     */   private IFiller getFillerImpl() {
/* 121 */     return new VendorFiller(this);
/*     */   }
/*     */   
/*     */   private static class VendorFiller
/*     */     implements IFiller {
/*     */     private VendorDBA _parent;
/*     */     
/*     */     public VendorFiller(VendorDBA argParent) {
/* 129 */       this._parent = argParent;
/*     */     }
/*     */ 
/*     */     
/*     */     public void fill(ResultSet argResultSet) throws SQLException {
/* 134 */       long primitiveResult = argResultSet.getLong(1);
/* 135 */       if (primitiveResult != 0L || argResultSet.getObject(1) != null) {
/* 136 */         this._parent._organizationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */       
/* 140 */       this._parent._vendorId = argResultSet.getString(2);
/*     */       
/* 142 */       Timestamp t3 = argResultSet.getTimestamp(3);
/* 143 */       if (t3 != null) {
/* 144 */         this._parent._createDate = (Date)new DtvDate(t3.getTime());
/*     */       } else {
/*     */         
/* 147 */         this._parent._createDate = null;
/*     */       } 
/*     */       
/* 150 */       this._parent._createUserId = argResultSet.getString(4);
/*     */       
/* 152 */       Timestamp t5 = argResultSet.getTimestamp(5);
/* 153 */       if (t5 != null) {
/* 154 */         this._parent._updateDate = (Date)new DtvDate(t5.getTime());
/*     */       } else {
/*     */         
/* 157 */         this._parent._updateDate = null;
/*     */       } 
/*     */       
/* 160 */       this._parent._updateUserId = argResultSet.getString(6);
/* 161 */       this._parent._orgCode = argResultSet.getString(7);
/* 162 */       this._parent._orgValue = argResultSet.getString(8);
/* 163 */       this._parent._name = argResultSet.getString(9);
/* 164 */       this._parent._typeCode = argResultSet.getString(10);
/* 165 */       this._parent._telephone = argResultSet.getString(11);
/* 166 */       this._parent._fax = argResultSet.getString(12);
/* 167 */       this._parent._contact = argResultSet.getString(13);
/* 168 */       this._parent._contactTelephone = argResultSet.getString(14);
/* 169 */       this._parent._buyer = argResultSet.getString(15);
/* 170 */       this._parent._status = argResultSet.getString(16);
/* 171 */       this._parent._addressId = argResultSet.getString(17);
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDAO(IDataAccessObject argDAO) {
/* 176 */     argDAO.suppressStateChanges(true);
/* 177 */     VendorDAO dao = (VendorDAO)argDAO;
/* 178 */     dao.setOrganizationId(this._organizationId);
/* 179 */     dao.setVendorId(this._vendorId);
/* 180 */     dao.setCreateDate(this._createDate);
/* 181 */     dao.setCreateUserId(this._createUserId);
/* 182 */     dao.setUpdateDate(this._updateDate);
/* 183 */     dao.setUpdateUserId(this._updateUserId);
/* 184 */     dao.setOrgCode(this._orgCode);
/* 185 */     dao.setOrgValue(this._orgValue);
/* 186 */     dao.setName(this._name);
/* 187 */     dao.setTypeCode(this._typeCode);
/* 188 */     dao.setTelephone(this._telephone);
/* 189 */     dao.setFax(this._fax);
/* 190 */     dao.setContact(this._contact);
/* 191 */     dao.setContactTelephone(this._contactTelephone);
/* 192 */     dao.setBuyer(this._buyer);
/* 193 */     dao.setStatus(this._status);
/* 194 */     dao.setAddressId(this._addressId);
/* 195 */     argDAO.suppressStateChanges(false);
/* 196 */     return (IDataAccessObject)dao;
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDefaultDAO() {
/* 200 */     return loadDAO((IDataAccessObject)new VendorDAO());
/*     */   }
/*     */   
/*     */   public void fill(IDataAccessObject argDAO) {
/* 204 */     VendorDAO dao = (VendorDAO)argDAO;
/* 205 */     this._organizationId = dao.getOrganizationId();
/* 206 */     this._vendorId = dao.getVendorId();
/* 207 */     this._createDate = dao.getCreateDate();
/* 208 */     this._createUserId = dao.getCreateUserId();
/* 209 */     this._updateDate = dao.getUpdateDate();
/* 210 */     this._updateUserId = dao.getUpdateUserId();
/* 211 */     this._orgCode = dao.getOrgCode();
/* 212 */     this._orgValue = dao.getOrgValue();
/* 213 */     this._name = dao.getName();
/* 214 */     this._typeCode = dao.getTypeCode();
/* 215 */     this._telephone = dao.getTelephone();
/* 216 */     this._fax = dao.getFax();
/* 217 */     this._contact = dao.getContact();
/* 218 */     this._contactTelephone = dao.getContactTelephone();
/* 219 */     this._buyer = dao.getBuyer();
/* 220 */     this._status = dao.getStatus();
/* 221 */     this._addressId = dao.getAddressId();
/*     */   }
/*     */   
/*     */   public PreparedStatement writeObjectId(IObjectId argId, PreparedStatement argStatement) throws SQLException {
/* 225 */     VendorId id = (VendorId)argId;
/* 226 */     argStatement.setLong(1, id.getOrganizationId().longValue());
/* 227 */     argStatement.setString(2, id.getVendorId());
/* 228 */     return argStatement;
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 232 */     VendorId id = new VendorId();
/* 233 */     id.setOrganizationId(this._organizationId);
/* 234 */     id.setVendorId(this._vendorId);
/* 235 */     return (IObjectId)id;
/*     */   }
/*     */ 
/*     */   
/*     */   public void fill(IJDBCTableAdapter argAdapter) {}
/*     */ 
/*     */   
/*     */   public boolean isExtensible() {
/* 243 */     return false;
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 247 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\itm\impl\VendorDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */