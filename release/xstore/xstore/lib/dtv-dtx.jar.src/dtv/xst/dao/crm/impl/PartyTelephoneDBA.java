/*     */ package dtv.xst.dao.crm.impl;
/*     */ 
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.impl.jdbc.IFiller;
/*     */ import dtv.data2.access.impl.jdbc.IJDBCTableAdapter;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.crm.PartyTelephoneId;
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
/*     */ public class PartyTelephoneDBA
/*     */   implements IJDBCTableAdapter
/*     */ {
/*     */   private static final long serialVersionUID = -158832674L;
/*     */   private Long _organizationId;
/*     */   private Long _partyId;
/*     */   private String _telephoneType;
/*     */   private Date _createDate;
/*     */   private String _createUserId;
/*     */   private Date _updateDate;
/*     */   private String _updateUserId;
/*     */   private String _contactType;
/*     */   private Boolean _contact;
/*     */   private Boolean _primary;
/*     */   private String _telephoneNumber;
/*     */   private static final String SELECT_OBJECT = "SELECT t.organization_id, t.party_id, t.telephone_type, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.contact_type, t.contact_flag, t.primary_flag, t.telephone_number FROM crm_party_telephone t";
/*     */   private static final String SELECT_WHERE_OBJECT = " WHERE organization_id = ?  AND party_id = ?  AND telephone_type = ?  ";
/*     */   
/*     */   public String getSelect() {
/*  40 */     return getSelectImpl();
/*     */   }
/*     */   
/*     */   private String getSelectImpl() {
/*  44 */     return "SELECT t.organization_id, t.party_id, t.telephone_type, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.contact_type, t.contact_flag, t.primary_flag, t.telephone_number FROM crm_party_telephone t";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectWhere() {
/*  50 */     return " WHERE organization_id = ?  AND party_id = ?  AND telephone_type = ?  ";
/*     */   }
/*     */   
/*  53 */   private static final String[] INSERT_OBJECT = new String[] { "INSERT INTO crm_party_telephone(organization_id, party_id, telephone_type, create_date, create_user_id, update_date, update_user_id, contact_type, contact_flag, primary_flag, telephone_number) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" };
/*     */   
/*     */   public String[] getInsert() {
/*  56 */     return INSERT_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getInsertParameters() {
/*  60 */     Object[][] insertParameterObject = { { this._organizationId, this._partyId, this._telephoneType, this._createDate, this._createUserId, this._updateDate, this._updateUserId, this._contactType, this._contact, this._primary, this._telephoneNumber } };
/*  61 */     return insertParameterObject;
/*     */   }
/*     */   
/*  64 */   private static final int[][] INSERT_PARAMETER_TYPES_OBJECT = new int[][] { { -5, -5, 12, 91, 12, 91, 12, 12, -7, -7, 12 } };
/*     */   
/*     */   public int[][] getInsertParameterTypes() {
/*  67 */     return INSERT_PARAMETER_TYPES_OBJECT;
/*     */   }
/*     */   
/*  70 */   private static final String[] UPDATE_OBJECT = new String[] { "UPDATE crm_party_telephone SET update_date = ?, update_user_id = ?, contact_type = ?, contact_flag = ?, primary_flag = ?, telephone_number = ?" };
/*     */   
/*     */   public String[] getUpdate() {
/*  73 */     return UPDATE_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getUpdateParameters() {
/*  77 */     Object[][] updateParameterObject = { { this._updateDate, this._updateUserId, this._contactType, this._contact, this._primary, this._telephoneNumber } };
/*  78 */     return updateParameterObject;
/*     */   }
/*     */   
/*  81 */   private static final int[][] UPDATE_PARAMETER_TYPE_OBJECT = new int[][] { { 91, 12, 12, -7, -7, 12 } };
/*     */   public int[][] getUpdateParameterTypes() {
/*  83 */     return UPDATE_PARAMETER_TYPE_OBJECT;
/*     */   }
/*     */   
/*  86 */   private static final String[] DELETE_OBJECT = new String[] { "DELETE FROM crm_party_telephone" }; private static final String WHERE_OBJECT = " WHERE organization_id = ?  AND party_id = ?  AND telephone_type = ?  ";
/*     */   
/*     */   public String[] getDelete() {
/*  89 */     return DELETE_OBJECT;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWhere() {
/*  95 */     return " WHERE organization_id = ?  AND party_id = ?  AND telephone_type = ?  ";
/*     */   }
/*     */   public Object[] getWhereParameters() {
/*  98 */     return new Object[] { this._organizationId, this._partyId, this._telephoneType };
/*     */   }
/*     */   
/* 101 */   private static final int[] WHERE_PARAMETER_OBJECT = new int[] { -5, -5, 12 };
/*     */   
/*     */   public int[] getWhereParameterTypes() {
/* 104 */     return WHERE_PARAMETER_OBJECT;
/*     */   }
/*     */   public String getTableName() {
/* 107 */     return "crm_party_telephone";
/*     */   }
/*     */   
/*     */   public IFiller getFiller() {
/* 111 */     return getFillerImpl();
/*     */   }
/*     */   
/*     */   private IFiller getFillerImpl() {
/* 115 */     return new PartyTelephoneFiller(this);
/*     */   }
/*     */   
/*     */   private static class PartyTelephoneFiller
/*     */     implements IFiller {
/*     */     private PartyTelephoneDBA _parent;
/*     */     
/*     */     public PartyTelephoneFiller(PartyTelephoneDBA argParent) {
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
/*     */ 
/*     */       
/* 136 */       primitiveResult = argResultSet.getLong(2);
/* 137 */       if (primitiveResult != 0L || argResultSet.getObject(2) != null) {
/* 138 */         this._parent._partyId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */       
/* 142 */       this._parent._telephoneType = argResultSet.getString(3);
/*     */       
/* 144 */       Timestamp t4 = argResultSet.getTimestamp(4);
/* 145 */       if (t4 != null) {
/* 146 */         this._parent._createDate = (Date)new DtvDate(t4.getTime());
/*     */       } else {
/*     */         
/* 149 */         this._parent._createDate = null;
/*     */       } 
/*     */       
/* 152 */       this._parent._createUserId = argResultSet.getString(5);
/*     */       
/* 154 */       Timestamp t6 = argResultSet.getTimestamp(6);
/* 155 */       if (t6 != null) {
/* 156 */         this._parent._updateDate = (Date)new DtvDate(t6.getTime());
/*     */       } else {
/*     */         
/* 159 */         this._parent._updateDate = null;
/*     */       } 
/*     */       
/* 162 */       this._parent._updateUserId = argResultSet.getString(7);
/* 163 */       this._parent._contactType = argResultSet.getString(8);
/* 164 */       this._parent._contact = Boolean.valueOf(argResultSet.getBoolean(9));
/* 165 */       this._parent._primary = Boolean.valueOf(argResultSet.getBoolean(10));
/* 166 */       this._parent._telephoneNumber = argResultSet.getString(11);
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDAO(IDataAccessObject argDAO) {
/* 171 */     argDAO.suppressStateChanges(true);
/* 172 */     PartyTelephoneDAO dao = (PartyTelephoneDAO)argDAO;
/* 173 */     dao.setOrganizationId(this._organizationId);
/* 174 */     dao.setPartyId(this._partyId);
/* 175 */     dao.setTelephoneType(this._telephoneType);
/* 176 */     dao.setCreateDate(this._createDate);
/* 177 */     dao.setCreateUserId(this._createUserId);
/* 178 */     dao.setUpdateDate(this._updateDate);
/* 179 */     dao.setUpdateUserId(this._updateUserId);
/* 180 */     dao.setContactType(this._contactType);
/* 181 */     dao.setContact(this._contact);
/* 182 */     dao.setPrimary(this._primary);
/* 183 */     dao.setTelephoneNumber(this._telephoneNumber);
/* 184 */     argDAO.suppressStateChanges(false);
/* 185 */     return (IDataAccessObject)dao;
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDefaultDAO() {
/* 189 */     return loadDAO((IDataAccessObject)new PartyTelephoneDAO());
/*     */   }
/*     */   
/*     */   public void fill(IDataAccessObject argDAO) {
/* 193 */     PartyTelephoneDAO dao = (PartyTelephoneDAO)argDAO;
/* 194 */     this._organizationId = dao.getOrganizationId();
/* 195 */     this._partyId = dao.getPartyId();
/* 196 */     this._telephoneType = dao.getTelephoneType();
/* 197 */     this._createDate = dao.getCreateDate();
/* 198 */     this._createUserId = dao.getCreateUserId();
/* 199 */     this._updateDate = dao.getUpdateDate();
/* 200 */     this._updateUserId = dao.getUpdateUserId();
/* 201 */     this._contactType = dao.getContactType();
/* 202 */     this._contact = (dao.getContact() != null) ? dao.getContact() : Boolean.valueOf(false);
/* 203 */     this._primary = (dao.getPrimary() != null) ? dao.getPrimary() : Boolean.valueOf(false);
/* 204 */     this._telephoneNumber = dao.getTelephoneNumber();
/*     */   }
/*     */   
/*     */   public PreparedStatement writeObjectId(IObjectId argId, PreparedStatement argStatement) throws SQLException {
/* 208 */     PartyTelephoneId id = (PartyTelephoneId)argId;
/* 209 */     argStatement.setLong(1, id.getOrganizationId().longValue());
/* 210 */     argStatement.setLong(2, id.getPartyId().longValue());
/* 211 */     argStatement.setString(3, id.getTelephoneType());
/* 212 */     return argStatement;
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 216 */     PartyTelephoneId id = new PartyTelephoneId();
/* 217 */     id.setOrganizationId(this._organizationId);
/* 218 */     id.setPartyId(this._partyId);
/* 219 */     id.setTelephoneType(this._telephoneType);
/* 220 */     return (IObjectId)id;
/*     */   }
/*     */ 
/*     */   
/*     */   public void fill(IJDBCTableAdapter argAdapter) {}
/*     */ 
/*     */   
/*     */   public boolean isExtensible() {
/* 228 */     return false;
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 232 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\crm\impl\PartyTelephoneDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */