/*     */ package dtv.xst.dao.crm.impl;
/*     */ 
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.impl.jdbc.IFiller;
/*     */ import dtv.data2.access.impl.jdbc.IJDBCTableAdapter;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.crm.PartyEmailId;
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
/*     */ public class PartyEmailDBA
/*     */   implements IJDBCTableAdapter
/*     */ {
/*     */   private static final long serialVersionUID = -1846281098L;
/*     */   private Long _organizationId;
/*     */   private Long _partyId;
/*     */   private Integer _sequence;
/*     */   private Date _createDate;
/*     */   private String _createUserId;
/*     */   private Date _updateDate;
/*     */   private String _updateUserId;
/*     */   private String _emailAddress;
/*     */   private String _emailType;
/*     */   private String _emailFormat;
/*     */   private Boolean _contact;
/*     */   private Boolean _primary;
/*     */   private static final String SELECT_OBJECT = "SELECT t.organization_id, t.party_id, t.email_sequence, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.email_address, t.email_type, t.email_format, t.contact_flag, t.primary_flag FROM crm_party_email t";
/*     */   private static final String SELECT_WHERE_OBJECT = " WHERE organization_id = ?  AND party_id = ?  AND email_sequence = ?  ";
/*     */   
/*     */   public String getSelect() {
/*  41 */     return getSelectImpl();
/*     */   }
/*     */   
/*     */   private String getSelectImpl() {
/*  45 */     return "SELECT t.organization_id, t.party_id, t.email_sequence, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.email_address, t.email_type, t.email_format, t.contact_flag, t.primary_flag FROM crm_party_email t";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectWhere() {
/*  51 */     return " WHERE organization_id = ?  AND party_id = ?  AND email_sequence = ?  ";
/*     */   }
/*     */   
/*  54 */   private static final String[] INSERT_OBJECT = new String[] { "INSERT INTO crm_party_email(organization_id, party_id, email_sequence, create_date, create_user_id, update_date, update_user_id, email_address, email_type, email_format, contact_flag, primary_flag) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" };
/*     */   
/*     */   public String[] getInsert() {
/*  57 */     return INSERT_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getInsertParameters() {
/*  61 */     Object[][] insertParameterObject = { { this._organizationId, this._partyId, this._sequence, this._createDate, this._createUserId, this._updateDate, this._updateUserId, this._emailAddress, this._emailType, this._emailFormat, this._contact, this._primary } };
/*  62 */     return insertParameterObject;
/*     */   }
/*     */   
/*  65 */   private static final int[][] INSERT_PARAMETER_TYPES_OBJECT = new int[][] { { -5, -5, 4, 91, 12, 91, 12, 12, 12, 12, -7, -7 } };
/*     */   
/*     */   public int[][] getInsertParameterTypes() {
/*  68 */     return INSERT_PARAMETER_TYPES_OBJECT;
/*     */   }
/*     */   
/*  71 */   private static final String[] UPDATE_OBJECT = new String[] { "UPDATE crm_party_email SET update_date = ?, update_user_id = ?, email_address = ?, email_type = ?, email_format = ?, contact_flag = ?, primary_flag = ?" };
/*     */   
/*     */   public String[] getUpdate() {
/*  74 */     return UPDATE_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getUpdateParameters() {
/*  78 */     Object[][] updateParameterObject = { { this._updateDate, this._updateUserId, this._emailAddress, this._emailType, this._emailFormat, this._contact, this._primary } };
/*  79 */     return updateParameterObject;
/*     */   }
/*     */   
/*  82 */   private static final int[][] UPDATE_PARAMETER_TYPE_OBJECT = new int[][] { { 91, 12, 12, 12, 12, -7, -7 } };
/*     */   public int[][] getUpdateParameterTypes() {
/*  84 */     return UPDATE_PARAMETER_TYPE_OBJECT;
/*     */   }
/*     */   
/*  87 */   private static final String[] DELETE_OBJECT = new String[] { "DELETE FROM crm_party_email" }; private static final String WHERE_OBJECT = " WHERE organization_id = ?  AND party_id = ?  AND email_sequence = ?  ";
/*     */   
/*     */   public String[] getDelete() {
/*  90 */     return DELETE_OBJECT;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWhere() {
/*  96 */     return " WHERE organization_id = ?  AND party_id = ?  AND email_sequence = ?  ";
/*     */   }
/*     */   public Object[] getWhereParameters() {
/*  99 */     return new Object[] { this._organizationId, this._partyId, this._sequence };
/*     */   }
/*     */   
/* 102 */   private static final int[] WHERE_PARAMETER_OBJECT = new int[] { -5, -5, 4 };
/*     */   
/*     */   public int[] getWhereParameterTypes() {
/* 105 */     return WHERE_PARAMETER_OBJECT;
/*     */   }
/*     */   public String getTableName() {
/* 108 */     return "crm_party_email";
/*     */   }
/*     */   
/*     */   public IFiller getFiller() {
/* 112 */     return getFillerImpl();
/*     */   }
/*     */   
/*     */   private IFiller getFillerImpl() {
/* 116 */     return new PartyEmailFiller(this);
/*     */   }
/*     */   
/*     */   private static class PartyEmailFiller
/*     */     implements IFiller {
/*     */     private PartyEmailDBA _parent;
/*     */     
/*     */     public PartyEmailFiller(PartyEmailDBA argParent) {
/* 124 */       this._parent = argParent;
/*     */     }
/*     */ 
/*     */     
/*     */     public void fill(ResultSet argResultSet) throws SQLException {
/* 129 */       long l = argResultSet.getLong(1);
/* 130 */       if (l != 0L || argResultSet.getObject(1) != null) {
/* 131 */         this._parent._organizationId = Long.valueOf(l);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 137 */       l = argResultSet.getLong(2);
/* 138 */       if (l != 0L || argResultSet.getObject(2) != null) {
/* 139 */         this._parent._partyId = Long.valueOf(l);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 145 */       int primitiveResult = argResultSet.getInt(3);
/* 146 */       if (primitiveResult != 0 || argResultSet.getObject(3) != null) {
/* 147 */         this._parent._sequence = Integer.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 152 */       Timestamp t4 = argResultSet.getTimestamp(4);
/* 153 */       if (t4 != null) {
/* 154 */         this._parent._createDate = (Date)new DtvDate(t4.getTime());
/*     */       } else {
/*     */         
/* 157 */         this._parent._createDate = null;
/*     */       } 
/*     */       
/* 160 */       this._parent._createUserId = argResultSet.getString(5);
/*     */       
/* 162 */       Timestamp t6 = argResultSet.getTimestamp(6);
/* 163 */       if (t6 != null) {
/* 164 */         this._parent._updateDate = (Date)new DtvDate(t6.getTime());
/*     */       } else {
/*     */         
/* 167 */         this._parent._updateDate = null;
/*     */       } 
/*     */       
/* 170 */       this._parent._updateUserId = argResultSet.getString(7);
/* 171 */       this._parent._emailAddress = argResultSet.getString(8);
/* 172 */       this._parent._emailType = argResultSet.getString(9);
/* 173 */       this._parent._emailFormat = argResultSet.getString(10);
/* 174 */       this._parent._contact = Boolean.valueOf(argResultSet.getBoolean(11));
/* 175 */       this._parent._primary = Boolean.valueOf(argResultSet.getBoolean(12));
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDAO(IDataAccessObject argDAO) {
/* 180 */     argDAO.suppressStateChanges(true);
/* 181 */     PartyEmailDAO dao = (PartyEmailDAO)argDAO;
/* 182 */     dao.setOrganizationId(this._organizationId);
/* 183 */     dao.setPartyId(this._partyId);
/* 184 */     dao.setSequence(this._sequence);
/* 185 */     dao.setCreateDate(this._createDate);
/* 186 */     dao.setCreateUserId(this._createUserId);
/* 187 */     dao.setUpdateDate(this._updateDate);
/* 188 */     dao.setUpdateUserId(this._updateUserId);
/* 189 */     dao.setEmailAddress(this._emailAddress);
/* 190 */     dao.setEmailType(this._emailType);
/* 191 */     dao.setEmailFormat(this._emailFormat);
/* 192 */     dao.setContact(this._contact);
/* 193 */     dao.setPrimary(this._primary);
/* 194 */     argDAO.suppressStateChanges(false);
/* 195 */     return (IDataAccessObject)dao;
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDefaultDAO() {
/* 199 */     return loadDAO((IDataAccessObject)new PartyEmailDAO());
/*     */   }
/*     */   
/*     */   public void fill(IDataAccessObject argDAO) {
/* 203 */     PartyEmailDAO dao = (PartyEmailDAO)argDAO;
/* 204 */     this._organizationId = dao.getOrganizationId();
/* 205 */     this._partyId = dao.getPartyId();
/* 206 */     this._sequence = dao.getSequence();
/* 207 */     this._createDate = dao.getCreateDate();
/* 208 */     this._createUserId = dao.getCreateUserId();
/* 209 */     this._updateDate = dao.getUpdateDate();
/* 210 */     this._updateUserId = dao.getUpdateUserId();
/* 211 */     this._emailAddress = dao.getEmailAddress();
/* 212 */     this._emailType = dao.getEmailType();
/* 213 */     this._emailFormat = dao.getEmailFormat();
/* 214 */     this._contact = (dao.getContact() != null) ? dao.getContact() : Boolean.valueOf(false);
/* 215 */     this._primary = (dao.getPrimary() != null) ? dao.getPrimary() : Boolean.valueOf(false);
/*     */   }
/*     */   
/*     */   public PreparedStatement writeObjectId(IObjectId argId, PreparedStatement argStatement) throws SQLException {
/* 219 */     PartyEmailId id = (PartyEmailId)argId;
/* 220 */     argStatement.setLong(1, id.getOrganizationId().longValue());
/* 221 */     argStatement.setLong(2, id.getPartyId().longValue());
/* 222 */     argStatement.setInt(3, id.getSequence().intValue());
/* 223 */     return argStatement;
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 227 */     PartyEmailId id = new PartyEmailId();
/* 228 */     id.setOrganizationId(this._organizationId);
/* 229 */     id.setPartyId(this._partyId);
/* 230 */     id.setSequence(this._sequence);
/* 231 */     return (IObjectId)id;
/*     */   }
/*     */ 
/*     */   
/*     */   public void fill(IJDBCTableAdapter argAdapter) {}
/*     */ 
/*     */   
/*     */   public boolean isExtensible() {
/* 239 */     return false;
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 243 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\crm\impl\PartyEmailDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */