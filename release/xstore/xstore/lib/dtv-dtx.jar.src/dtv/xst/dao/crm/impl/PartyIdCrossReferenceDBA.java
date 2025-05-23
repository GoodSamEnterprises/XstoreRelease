/*     */ package dtv.xst.dao.crm.impl;
/*     */ 
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.impl.jdbc.IFiller;
/*     */ import dtv.data2.access.impl.jdbc.IJDBCTableAdapter;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.crm.PartyIdCrossReferenceId;
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
/*     */ public class PartyIdCrossReferenceDBA
/*     */   implements IJDBCTableAdapter
/*     */ {
/*     */   private static final long serialVersionUID = 1914929100L;
/*     */   private Long _organizationId;
/*     */   private Long _partyId;
/*     */   private String _alternateIdOwner;
/*     */   private Date _createDate;
/*     */   private String _createUserId;
/*     */   private Date _updateDate;
/*     */   private String _updateUserId;
/*     */   private String _alternateId;
/*     */   private static final String SELECT_OBJECT = "SELECT t.organization_id, t.party_id, t.alternate_id_owner, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.alternate_id FROM crm_party_id_xref t";
/*     */   private static final String SELECT_WHERE_OBJECT = " WHERE organization_id = ?  AND party_id = ?  AND alternate_id_owner = ?  ";
/*     */   
/*     */   public String getSelect() {
/*  37 */     return getSelectImpl();
/*     */   }
/*     */   
/*     */   private String getSelectImpl() {
/*  41 */     return "SELECT t.organization_id, t.party_id, t.alternate_id_owner, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.alternate_id FROM crm_party_id_xref t";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectWhere() {
/*  47 */     return " WHERE organization_id = ?  AND party_id = ?  AND alternate_id_owner = ?  ";
/*     */   }
/*     */   
/*  50 */   private static final String[] INSERT_OBJECT = new String[] { "INSERT INTO crm_party_id_xref(organization_id, party_id, alternate_id_owner, create_date, create_user_id, update_date, update_user_id, alternate_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?)" };
/*     */   
/*     */   public String[] getInsert() {
/*  53 */     return INSERT_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getInsertParameters() {
/*  57 */     Object[][] insertParameterObject = { { this._organizationId, this._partyId, this._alternateIdOwner, this._createDate, this._createUserId, this._updateDate, this._updateUserId, this._alternateId } };
/*  58 */     return insertParameterObject;
/*     */   }
/*     */   
/*  61 */   private static final int[][] INSERT_PARAMETER_TYPES_OBJECT = new int[][] { { -5, -5, 12, 91, 12, 91, 12, 12 } };
/*     */   
/*     */   public int[][] getInsertParameterTypes() {
/*  64 */     return INSERT_PARAMETER_TYPES_OBJECT;
/*     */   }
/*     */   
/*  67 */   private static final String[] UPDATE_OBJECT = new String[] { "UPDATE crm_party_id_xref SET update_date = ?, update_user_id = ?, alternate_id = ?" };
/*     */   
/*     */   public String[] getUpdate() {
/*  70 */     return UPDATE_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getUpdateParameters() {
/*  74 */     Object[][] updateParameterObject = { { this._updateDate, this._updateUserId, this._alternateId } };
/*  75 */     return updateParameterObject;
/*     */   }
/*     */   
/*  78 */   private static final int[][] UPDATE_PARAMETER_TYPE_OBJECT = new int[][] { { 91, 12, 12 } };
/*     */   public int[][] getUpdateParameterTypes() {
/*  80 */     return UPDATE_PARAMETER_TYPE_OBJECT;
/*     */   }
/*     */   
/*  83 */   private static final String[] DELETE_OBJECT = new String[] { "DELETE FROM crm_party_id_xref" }; private static final String WHERE_OBJECT = " WHERE organization_id = ?  AND party_id = ?  AND alternate_id_owner = ?  ";
/*     */   
/*     */   public String[] getDelete() {
/*  86 */     return DELETE_OBJECT;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWhere() {
/*  92 */     return " WHERE organization_id = ?  AND party_id = ?  AND alternate_id_owner = ?  ";
/*     */   }
/*     */   public Object[] getWhereParameters() {
/*  95 */     return new Object[] { this._organizationId, this._partyId, this._alternateIdOwner };
/*     */   }
/*     */   
/*  98 */   private static final int[] WHERE_PARAMETER_OBJECT = new int[] { -5, -5, 12 };
/*     */   
/*     */   public int[] getWhereParameterTypes() {
/* 101 */     return WHERE_PARAMETER_OBJECT;
/*     */   }
/*     */   public String getTableName() {
/* 104 */     return "crm_party_id_xref";
/*     */   }
/*     */   
/*     */   public IFiller getFiller() {
/* 108 */     return getFillerImpl();
/*     */   }
/*     */   
/*     */   private IFiller getFillerImpl() {
/* 112 */     return new PartyIdCrossReferenceFiller(this);
/*     */   }
/*     */   
/*     */   private static class PartyIdCrossReferenceFiller
/*     */     implements IFiller {
/*     */     private PartyIdCrossReferenceDBA _parent;
/*     */     
/*     */     public PartyIdCrossReferenceFiller(PartyIdCrossReferenceDBA argParent) {
/* 120 */       this._parent = argParent;
/*     */     }
/*     */ 
/*     */     
/*     */     public void fill(ResultSet argResultSet) throws SQLException {
/* 125 */       long primitiveResult = argResultSet.getLong(1);
/* 126 */       if (primitiveResult != 0L || argResultSet.getObject(1) != null) {
/* 127 */         this._parent._organizationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 133 */       primitiveResult = argResultSet.getLong(2);
/* 134 */       if (primitiveResult != 0L || argResultSet.getObject(2) != null) {
/* 135 */         this._parent._partyId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */       
/* 139 */       this._parent._alternateIdOwner = argResultSet.getString(3);
/*     */       
/* 141 */       Timestamp t4 = argResultSet.getTimestamp(4);
/* 142 */       if (t4 != null) {
/* 143 */         this._parent._createDate = (Date)new DtvDate(t4.getTime());
/*     */       } else {
/*     */         
/* 146 */         this._parent._createDate = null;
/*     */       } 
/*     */       
/* 149 */       this._parent._createUserId = argResultSet.getString(5);
/*     */       
/* 151 */       Timestamp t6 = argResultSet.getTimestamp(6);
/* 152 */       if (t6 != null) {
/* 153 */         this._parent._updateDate = (Date)new DtvDate(t6.getTime());
/*     */       } else {
/*     */         
/* 156 */         this._parent._updateDate = null;
/*     */       } 
/*     */       
/* 159 */       this._parent._updateUserId = argResultSet.getString(7);
/* 160 */       this._parent._alternateId = argResultSet.getString(8);
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDAO(IDataAccessObject argDAO) {
/* 165 */     argDAO.suppressStateChanges(true);
/* 166 */     PartyIdCrossReferenceDAO dao = (PartyIdCrossReferenceDAO)argDAO;
/* 167 */     dao.setOrganizationId(this._organizationId);
/* 168 */     dao.setPartyId(this._partyId);
/* 169 */     dao.setAlternateIdOwner(this._alternateIdOwner);
/* 170 */     dao.setCreateDate(this._createDate);
/* 171 */     dao.setCreateUserId(this._createUserId);
/* 172 */     dao.setUpdateDate(this._updateDate);
/* 173 */     dao.setUpdateUserId(this._updateUserId);
/* 174 */     dao.setAlternateId(this._alternateId);
/* 175 */     argDAO.suppressStateChanges(false);
/* 176 */     return (IDataAccessObject)dao;
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDefaultDAO() {
/* 180 */     return loadDAO((IDataAccessObject)new PartyIdCrossReferenceDAO());
/*     */   }
/*     */   
/*     */   public void fill(IDataAccessObject argDAO) {
/* 184 */     PartyIdCrossReferenceDAO dao = (PartyIdCrossReferenceDAO)argDAO;
/* 185 */     this._organizationId = dao.getOrganizationId();
/* 186 */     this._partyId = dao.getPartyId();
/* 187 */     this._alternateIdOwner = dao.getAlternateIdOwner();
/* 188 */     this._createDate = dao.getCreateDate();
/* 189 */     this._createUserId = dao.getCreateUserId();
/* 190 */     this._updateDate = dao.getUpdateDate();
/* 191 */     this._updateUserId = dao.getUpdateUserId();
/* 192 */     this._alternateId = dao.getAlternateId();
/*     */   }
/*     */   
/*     */   public PreparedStatement writeObjectId(IObjectId argId, PreparedStatement argStatement) throws SQLException {
/* 196 */     PartyIdCrossReferenceId id = (PartyIdCrossReferenceId)argId;
/* 197 */     argStatement.setLong(1, id.getOrganizationId().longValue());
/* 198 */     argStatement.setLong(2, id.getPartyId().longValue());
/* 199 */     argStatement.setString(3, id.getAlternateIdOwner());
/* 200 */     return argStatement;
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 204 */     PartyIdCrossReferenceId id = new PartyIdCrossReferenceId();
/* 205 */     id.setOrganizationId(this._organizationId);
/* 206 */     id.setPartyId(this._partyId);
/* 207 */     id.setAlternateIdOwner(this._alternateIdOwner);
/* 208 */     return (IObjectId)id;
/*     */   }
/*     */ 
/*     */   
/*     */   public void fill(IJDBCTableAdapter argAdapter) {}
/*     */ 
/*     */   
/*     */   public boolean isExtensible() {
/* 216 */     return false;
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 220 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\crm\impl\PartyIdCrossReferenceDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */