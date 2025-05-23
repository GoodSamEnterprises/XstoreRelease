/*     */ package dtv.xst.dao.crm.impl;
/*     */ 
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.impl.jdbc.IFiller;
/*     */ import dtv.data2.access.impl.jdbc.IJDBCTableAdapter;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.crm.PartyCrossReferenceId;
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
/*     */ public class PartyCrossReferenceDBA
/*     */   implements IJDBCTableAdapter
/*     */ {
/*     */   private static final long serialVersionUID = -462769327L;
/*     */   private Long _childPartyId;
/*     */   private Long _organizationId;
/*     */   private Long _parentPartyId;
/*     */   private String _partyRelationshipTypeCode;
/*     */   private Date _createDate;
/*     */   private String _createUserId;
/*     */   private Date _updateDate;
/*     */   private String _updateUserId;
/*     */   private static final String SELECT_OBJECT = "SELECT t.child_party_id, t.organization_id, t.parent_party_id, t.party_relationship_typcode, t.create_date, t.create_user_id, t.update_date, t.update_user_id FROM crm_party_cross_reference t";
/*     */   private static final String SELECT_WHERE_OBJECT = " WHERE child_party_id = ?  AND organization_id = ?  AND parent_party_id = ?  AND party_relationship_typcode = ?  ";
/*     */   
/*     */   public String getSelect() {
/*  37 */     return getSelectImpl();
/*     */   }
/*     */   
/*     */   private String getSelectImpl() {
/*  41 */     return "SELECT t.child_party_id, t.organization_id, t.parent_party_id, t.party_relationship_typcode, t.create_date, t.create_user_id, t.update_date, t.update_user_id FROM crm_party_cross_reference t";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectWhere() {
/*  47 */     return " WHERE child_party_id = ?  AND organization_id = ?  AND parent_party_id = ?  AND party_relationship_typcode = ?  ";
/*     */   }
/*     */   
/*  50 */   private static final String[] INSERT_OBJECT = new String[] { "INSERT INTO crm_party_cross_reference(child_party_id, organization_id, parent_party_id, party_relationship_typcode, create_date, create_user_id, update_date, update_user_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?)" };
/*     */   
/*     */   public String[] getInsert() {
/*  53 */     return INSERT_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getInsertParameters() {
/*  57 */     Object[][] insertParameterObject = { { this._childPartyId, this._organizationId, this._parentPartyId, this._partyRelationshipTypeCode, this._createDate, this._createUserId, this._updateDate, this._updateUserId } };
/*  58 */     return insertParameterObject;
/*     */   }
/*     */   
/*  61 */   private static final int[][] INSERT_PARAMETER_TYPES_OBJECT = new int[][] { { -5, -5, -5, 12, 91, 12, 91, 12 } };
/*     */   
/*     */   public int[][] getInsertParameterTypes() {
/*  64 */     return INSERT_PARAMETER_TYPES_OBJECT;
/*     */   }
/*     */   
/*  67 */   private static final String[] UPDATE_OBJECT = new String[] { "UPDATE crm_party_cross_reference SET update_date = ?, update_user_id = ?" };
/*     */   
/*     */   public String[] getUpdate() {
/*  70 */     return UPDATE_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getUpdateParameters() {
/*  74 */     Object[][] updateParameterObject = { { this._updateDate, this._updateUserId } };
/*  75 */     return updateParameterObject;
/*     */   }
/*     */   
/*  78 */   private static final int[][] UPDATE_PARAMETER_TYPE_OBJECT = new int[][] { { 91, 12 } };
/*     */   public int[][] getUpdateParameterTypes() {
/*  80 */     return UPDATE_PARAMETER_TYPE_OBJECT;
/*     */   }
/*     */   
/*  83 */   private static final String[] DELETE_OBJECT = new String[] { "DELETE FROM crm_party_cross_reference" }; private static final String WHERE_OBJECT = " WHERE child_party_id = ?  AND organization_id = ?  AND parent_party_id = ?  AND party_relationship_typcode = ?  ";
/*     */   
/*     */   public String[] getDelete() {
/*  86 */     return DELETE_OBJECT;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWhere() {
/*  92 */     return " WHERE child_party_id = ?  AND organization_id = ?  AND parent_party_id = ?  AND party_relationship_typcode = ?  ";
/*     */   }
/*     */   public Object[] getWhereParameters() {
/*  95 */     return new Object[] { this._childPartyId, this._organizationId, this._parentPartyId, this._partyRelationshipTypeCode };
/*     */   }
/*     */   
/*  98 */   private static final int[] WHERE_PARAMETER_OBJECT = new int[] { -5, -5, -5, 12 };
/*     */   
/*     */   public int[] getWhereParameterTypes() {
/* 101 */     return WHERE_PARAMETER_OBJECT;
/*     */   }
/*     */   public String getTableName() {
/* 104 */     return "crm_party_cross_reference";
/*     */   }
/*     */   
/*     */   public IFiller getFiller() {
/* 108 */     return getFillerImpl();
/*     */   }
/*     */   
/*     */   private IFiller getFillerImpl() {
/* 112 */     return new PartyCrossReferenceFiller(this);
/*     */   }
/*     */   
/*     */   private static class PartyCrossReferenceFiller
/*     */     implements IFiller {
/*     */     private PartyCrossReferenceDBA _parent;
/*     */     
/*     */     public PartyCrossReferenceFiller(PartyCrossReferenceDBA argParent) {
/* 120 */       this._parent = argParent;
/*     */     }
/*     */ 
/*     */     
/*     */     public void fill(ResultSet argResultSet) throws SQLException {
/* 125 */       long primitiveResult = argResultSet.getLong(1);
/* 126 */       if (primitiveResult != 0L || argResultSet.getObject(1) != null) {
/* 127 */         this._parent._childPartyId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 133 */       primitiveResult = argResultSet.getLong(2);
/* 134 */       if (primitiveResult != 0L || argResultSet.getObject(2) != null) {
/* 135 */         this._parent._organizationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 141 */       primitiveResult = argResultSet.getLong(3);
/* 142 */       if (primitiveResult != 0L || argResultSet.getObject(3) != null) {
/* 143 */         this._parent._parentPartyId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */       
/* 147 */       this._parent._partyRelationshipTypeCode = argResultSet.getString(4);
/*     */       
/* 149 */       Timestamp t5 = argResultSet.getTimestamp(5);
/* 150 */       if (t5 != null) {
/* 151 */         this._parent._createDate = (Date)new DtvDate(t5.getTime());
/*     */       } else {
/*     */         
/* 154 */         this._parent._createDate = null;
/*     */       } 
/*     */       
/* 157 */       this._parent._createUserId = argResultSet.getString(6);
/*     */       
/* 159 */       Timestamp t7 = argResultSet.getTimestamp(7);
/* 160 */       if (t7 != null) {
/* 161 */         this._parent._updateDate = (Date)new DtvDate(t7.getTime());
/*     */       } else {
/*     */         
/* 164 */         this._parent._updateDate = null;
/*     */       } 
/*     */       
/* 167 */       this._parent._updateUserId = argResultSet.getString(8);
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDAO(IDataAccessObject argDAO) {
/* 172 */     argDAO.suppressStateChanges(true);
/* 173 */     PartyCrossReferenceDAO dao = (PartyCrossReferenceDAO)argDAO;
/* 174 */     dao.setChildPartyId(this._childPartyId);
/* 175 */     dao.setOrganizationId(this._organizationId);
/* 176 */     dao.setParentPartyId(this._parentPartyId);
/* 177 */     dao.setPartyRelationshipTypeCode(this._partyRelationshipTypeCode);
/* 178 */     dao.setCreateDate(this._createDate);
/* 179 */     dao.setCreateUserId(this._createUserId);
/* 180 */     dao.setUpdateDate(this._updateDate);
/* 181 */     dao.setUpdateUserId(this._updateUserId);
/* 182 */     argDAO.suppressStateChanges(false);
/* 183 */     return (IDataAccessObject)dao;
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDefaultDAO() {
/* 187 */     return loadDAO((IDataAccessObject)new PartyCrossReferenceDAO());
/*     */   }
/*     */   
/*     */   public void fill(IDataAccessObject argDAO) {
/* 191 */     PartyCrossReferenceDAO dao = (PartyCrossReferenceDAO)argDAO;
/* 192 */     this._childPartyId = dao.getChildPartyId();
/* 193 */     this._organizationId = dao.getOrganizationId();
/* 194 */     this._parentPartyId = dao.getParentPartyId();
/* 195 */     this._partyRelationshipTypeCode = dao.getPartyRelationshipTypeCode();
/* 196 */     this._createDate = dao.getCreateDate();
/* 197 */     this._createUserId = dao.getCreateUserId();
/* 198 */     this._updateDate = dao.getUpdateDate();
/* 199 */     this._updateUserId = dao.getUpdateUserId();
/*     */   }
/*     */   
/*     */   public PreparedStatement writeObjectId(IObjectId argId, PreparedStatement argStatement) throws SQLException {
/* 203 */     PartyCrossReferenceId id = (PartyCrossReferenceId)argId;
/* 204 */     argStatement.setLong(1, id.getChildPartyId().longValue());
/* 205 */     argStatement.setLong(2, id.getOrganizationId().longValue());
/* 206 */     argStatement.setLong(3, id.getParentPartyId().longValue());
/* 207 */     argStatement.setString(4, id.getPartyRelationshipTypeCode());
/* 208 */     return argStatement;
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 212 */     PartyCrossReferenceId id = new PartyCrossReferenceId();
/* 213 */     id.setChildPartyId(this._childPartyId);
/* 214 */     id.setOrganizationId(this._organizationId);
/* 215 */     id.setParentPartyId(this._parentPartyId);
/* 216 */     id.setPartyRelationshipTypeCode(this._partyRelationshipTypeCode);
/* 217 */     return (IObjectId)id;
/*     */   }
/*     */ 
/*     */   
/*     */   public void fill(IJDBCTableAdapter argAdapter) {}
/*     */ 
/*     */   
/*     */   public boolean isExtensible() {
/* 225 */     return false;
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 229 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\crm\impl\PartyCrossReferenceDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */