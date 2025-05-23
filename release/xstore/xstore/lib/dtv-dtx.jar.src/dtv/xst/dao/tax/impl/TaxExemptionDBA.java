/*     */ package dtv.xst.dao.tax.impl;
/*     */ 
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.impl.jdbc.IFiller;
/*     */ import dtv.data2.access.impl.jdbc.IJDBCTableAdapter;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.tax.TaxExemptionId;
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
/*     */ public class TaxExemptionDBA
/*     */   implements IJDBCTableAdapter
/*     */ {
/*     */   private static final long serialVersionUID = -1164693378L;
/*     */   private Long _organizationId;
/*     */   private String _taxExemptionId;
/*     */   private Date _createDate;
/*     */   private String _createUserId;
/*     */   private Date _updateDate;
/*     */   private String _updateUserId;
/*     */   private String _certificateHolderName;
/*     */   private String _certificateNbr;
/*     */   private Long _partyId;
/*     */   private String _reasonCode;
/*     */   private Date _expirationDate;
/*     */   private String _certificateCountry;
/*     */   private String _certificateState;
/*     */   private String _notes;
/*     */   private String _phoneNumber;
/*     */   private String _region;
/*     */   private String _diplomaticTitle;
/*     */   private String _certHolderFirstName;
/*     */   private String _certHolderLastName;
/*     */   private String _addressId;
/*     */   private static final String SELECT_OBJECT = "SELECT t.organization_id, t.tax_exemption_id, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.cert_holder_name, t.cert_nbr, t.party_id, t.reascode, t.expiration_date, t.cert_country, t.cert_state, t.notes, t.phone_number, t.region, t.diplomatic_title, t.cert_holder_first_name, t.cert_holder_last_name, t.address_id FROM tax_tax_exemption t";
/*     */   private static final String SELECT_WHERE_OBJECT = " WHERE organization_id = ?  AND tax_exemption_id = ?  ";
/*     */   
/*     */   public String getSelect() {
/*  49 */     return getSelectImpl();
/*     */   }
/*     */   
/*     */   private String getSelectImpl() {
/*  53 */     return "SELECT t.organization_id, t.tax_exemption_id, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.cert_holder_name, t.cert_nbr, t.party_id, t.reascode, t.expiration_date, t.cert_country, t.cert_state, t.notes, t.phone_number, t.region, t.diplomatic_title, t.cert_holder_first_name, t.cert_holder_last_name, t.address_id FROM tax_tax_exemption t";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectWhere() {
/*  59 */     return " WHERE organization_id = ?  AND tax_exemption_id = ?  ";
/*     */   }
/*     */   
/*  62 */   private static final String[] INSERT_OBJECT = new String[] { "INSERT INTO tax_tax_exemption(organization_id, tax_exemption_id, create_date, create_user_id, update_date, update_user_id, cert_holder_name, cert_nbr, party_id, reascode, expiration_date, cert_country, cert_state, notes, phone_number, region, diplomatic_title, cert_holder_first_name, cert_holder_last_name, address_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" };
/*     */   
/*     */   public String[] getInsert() {
/*  65 */     return INSERT_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getInsertParameters() {
/*  69 */     Object[][] insertParameterObject = { { this._organizationId, this._taxExemptionId, this._createDate, this._createUserId, this._updateDate, this._updateUserId, this._certificateHolderName, this._certificateNbr, this._partyId, this._reasonCode, this._expirationDate, this._certificateCountry, this._certificateState, this._notes, this._phoneNumber, this._region, this._diplomaticTitle, this._certHolderFirstName, this._certHolderLastName, this._addressId } };
/*  70 */     return insertParameterObject;
/*     */   }
/*     */   
/*  73 */   private static final int[][] INSERT_PARAMETER_TYPES_OBJECT = new int[][] { { -5, 12, 91, 12, 91, 12, 12, 12, -5, 12, 91, 12, 12, 12, 12, 12, 12, 12, 12, 12 } };
/*     */   
/*     */   public int[][] getInsertParameterTypes() {
/*  76 */     return INSERT_PARAMETER_TYPES_OBJECT;
/*     */   }
/*     */   
/*  79 */   private static final String[] UPDATE_OBJECT = new String[] { "UPDATE tax_tax_exemption SET update_date = ?, update_user_id = ?, cert_holder_name = ?, cert_nbr = ?, party_id = ?, reascode = ?, expiration_date = ?, cert_country = ?, cert_state = ?, notes = ?, phone_number = ?, region = ?, diplomatic_title = ?, cert_holder_first_name = ?, cert_holder_last_name = ?, address_id = ?" };
/*     */   
/*     */   public String[] getUpdate() {
/*  82 */     return UPDATE_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getUpdateParameters() {
/*  86 */     Object[][] updateParameterObject = { { this._updateDate, this._updateUserId, this._certificateHolderName, this._certificateNbr, this._partyId, this._reasonCode, this._expirationDate, this._certificateCountry, this._certificateState, this._notes, this._phoneNumber, this._region, this._diplomaticTitle, this._certHolderFirstName, this._certHolderLastName, this._addressId } };
/*  87 */     return updateParameterObject;
/*     */   }
/*     */   
/*  90 */   private static final int[][] UPDATE_PARAMETER_TYPE_OBJECT = new int[][] { { 91, 12, 12, 12, -5, 12, 91, 12, 12, 12, 12, 12, 12, 12, 12, 12 } };
/*     */   public int[][] getUpdateParameterTypes() {
/*  92 */     return UPDATE_PARAMETER_TYPE_OBJECT;
/*     */   }
/*     */   
/*  95 */   private static final String[] DELETE_OBJECT = new String[] { "DELETE FROM tax_tax_exemption" }; private static final String WHERE_OBJECT = " WHERE organization_id = ?  AND tax_exemption_id = ?  ";
/*     */   
/*     */   public String[] getDelete() {
/*  98 */     return DELETE_OBJECT;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWhere() {
/* 104 */     return " WHERE organization_id = ?  AND tax_exemption_id = ?  ";
/*     */   }
/*     */   public Object[] getWhereParameters() {
/* 107 */     return new Object[] { this._organizationId, this._taxExemptionId };
/*     */   }
/*     */   
/* 110 */   private static final int[] WHERE_PARAMETER_OBJECT = new int[] { -5, 12 };
/*     */   
/*     */   public int[] getWhereParameterTypes() {
/* 113 */     return WHERE_PARAMETER_OBJECT;
/*     */   }
/*     */   public String getTableName() {
/* 116 */     return "tax_tax_exemption";
/*     */   }
/*     */   
/*     */   public IFiller getFiller() {
/* 120 */     return getFillerImpl();
/*     */   }
/*     */   
/*     */   private IFiller getFillerImpl() {
/* 124 */     return new TaxExemptionFiller(this);
/*     */   }
/*     */   
/*     */   private static class TaxExemptionFiller
/*     */     implements IFiller {
/*     */     private TaxExemptionDBA _parent;
/*     */     
/*     */     public TaxExemptionFiller(TaxExemptionDBA argParent) {
/* 132 */       this._parent = argParent;
/*     */     }
/*     */ 
/*     */     
/*     */     public void fill(ResultSet argResultSet) throws SQLException {
/* 137 */       long primitiveResult = argResultSet.getLong(1);
/* 138 */       if (primitiveResult != 0L || argResultSet.getObject(1) != null) {
/* 139 */         this._parent._organizationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */       
/* 143 */       this._parent._taxExemptionId = argResultSet.getString(2);
/*     */       
/* 145 */       Timestamp t3 = argResultSet.getTimestamp(3);
/* 146 */       if (t3 != null) {
/* 147 */         this._parent._createDate = (Date)new DtvDate(t3.getTime());
/*     */       } else {
/*     */         
/* 150 */         this._parent._createDate = null;
/*     */       } 
/*     */       
/* 153 */       this._parent._createUserId = argResultSet.getString(4);
/*     */       
/* 155 */       Timestamp t5 = argResultSet.getTimestamp(5);
/* 156 */       if (t5 != null) {
/* 157 */         this._parent._updateDate = (Date)new DtvDate(t5.getTime());
/*     */       } else {
/*     */         
/* 160 */         this._parent._updateDate = null;
/*     */       } 
/*     */       
/* 163 */       this._parent._updateUserId = argResultSet.getString(6);
/* 164 */       this._parent._certificateHolderName = argResultSet.getString(7);
/* 165 */       this._parent._certificateNbr = argResultSet.getString(8);
/*     */ 
/*     */       
/* 168 */       long l1 = argResultSet.getLong(9);
/* 169 */       if (l1 != 0L || argResultSet.getObject(9) != null) {
/* 170 */         this._parent._partyId = Long.valueOf(l1);
/*     */       }
/*     */ 
/*     */       
/* 174 */       this._parent._reasonCode = argResultSet.getString(10);
/*     */       
/* 176 */       Timestamp t11 = argResultSet.getTimestamp(11);
/* 177 */       if (t11 != null) {
/* 178 */         this._parent._expirationDate = (Date)new DtvDate(t11.getTime());
/*     */       } else {
/*     */         
/* 181 */         this._parent._expirationDate = null;
/*     */       } 
/*     */       
/* 184 */       this._parent._certificateCountry = argResultSet.getString(12);
/* 185 */       this._parent._certificateState = argResultSet.getString(13);
/* 186 */       this._parent._notes = argResultSet.getString(14);
/* 187 */       this._parent._phoneNumber = argResultSet.getString(15);
/* 188 */       this._parent._region = argResultSet.getString(16);
/* 189 */       this._parent._diplomaticTitle = argResultSet.getString(17);
/* 190 */       this._parent._certHolderFirstName = argResultSet.getString(18);
/* 191 */       this._parent._certHolderLastName = argResultSet.getString(19);
/* 192 */       this._parent._addressId = argResultSet.getString(20);
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDAO(IDataAccessObject argDAO) {
/* 197 */     argDAO.suppressStateChanges(true);
/* 198 */     TaxExemptionDAO dao = (TaxExemptionDAO)argDAO;
/* 199 */     dao.setOrganizationId(this._organizationId);
/* 200 */     dao.setTaxExemptionId(this._taxExemptionId);
/* 201 */     dao.setCreateDate(this._createDate);
/* 202 */     dao.setCreateUserId(this._createUserId);
/* 203 */     dao.setUpdateDate(this._updateDate);
/* 204 */     dao.setUpdateUserId(this._updateUserId);
/* 205 */     dao.setCertificateHolderName(this._certificateHolderName);
/* 206 */     dao.setCertificateNbr(this._certificateNbr);
/* 207 */     dao.setPartyId(this._partyId);
/* 208 */     dao.setReasonCode(this._reasonCode);
/* 209 */     dao.setExpirationDate(this._expirationDate);
/* 210 */     dao.setCertificateCountry(this._certificateCountry);
/* 211 */     dao.setCertificateState(this._certificateState);
/* 212 */     dao.setNotes(this._notes);
/* 213 */     dao.setPhoneNumber(this._phoneNumber);
/* 214 */     dao.setRegion(this._region);
/* 215 */     dao.setDiplomaticTitle(this._diplomaticTitle);
/* 216 */     dao.setCertHolderFirstName(this._certHolderFirstName);
/* 217 */     dao.setCertHolderLastName(this._certHolderLastName);
/* 218 */     dao.setAddressId(this._addressId);
/* 219 */     argDAO.suppressStateChanges(false);
/* 220 */     return (IDataAccessObject)dao;
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDefaultDAO() {
/* 224 */     return loadDAO((IDataAccessObject)new TaxExemptionDAO());
/*     */   }
/*     */   
/*     */   public void fill(IDataAccessObject argDAO) {
/* 228 */     TaxExemptionDAO dao = (TaxExemptionDAO)argDAO;
/* 229 */     this._organizationId = dao.getOrganizationId();
/* 230 */     this._taxExemptionId = dao.getTaxExemptionId();
/* 231 */     this._createDate = dao.getCreateDate();
/* 232 */     this._createUserId = dao.getCreateUserId();
/* 233 */     this._updateDate = dao.getUpdateDate();
/* 234 */     this._updateUserId = dao.getUpdateUserId();
/* 235 */     this._certificateHolderName = dao.getCertificateHolderName();
/* 236 */     this._certificateNbr = dao.getCertificateNbr();
/* 237 */     this._partyId = dao.getPartyId();
/* 238 */     this._reasonCode = dao.getReasonCode();
/* 239 */     this._expirationDate = dao.getExpirationDate();
/* 240 */     this._certificateCountry = dao.getCertificateCountry();
/* 241 */     this._certificateState = dao.getCertificateState();
/* 242 */     this._notes = dao.getNotes();
/* 243 */     this._phoneNumber = dao.getPhoneNumber();
/* 244 */     this._region = dao.getRegion();
/* 245 */     this._diplomaticTitle = dao.getDiplomaticTitle();
/* 246 */     this._certHolderFirstName = dao.getCertHolderFirstName();
/* 247 */     this._certHolderLastName = dao.getCertHolderLastName();
/* 248 */     this._addressId = dao.getAddressId();
/*     */   }
/*     */   
/*     */   public PreparedStatement writeObjectId(IObjectId argId, PreparedStatement argStatement) throws SQLException {
/* 252 */     TaxExemptionId id = (TaxExemptionId)argId;
/* 253 */     argStatement.setLong(1, id.getOrganizationId().longValue());
/* 254 */     argStatement.setString(2, id.getTaxExemptionId());
/* 255 */     return argStatement;
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 259 */     TaxExemptionId id = new TaxExemptionId();
/* 260 */     id.setOrganizationId(this._organizationId);
/* 261 */     id.setTaxExemptionId(this._taxExemptionId);
/* 262 */     return (IObjectId)id;
/*     */   }
/*     */ 
/*     */   
/*     */   public void fill(IJDBCTableAdapter argAdapter) {}
/*     */ 
/*     */   
/*     */   public boolean isExtensible() {
/* 270 */     return false;
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 274 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\tax\impl\TaxExemptionDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */