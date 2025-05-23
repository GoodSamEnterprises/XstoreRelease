/*     */ package dtv.xst.dao.crm.impl;
/*     */ 
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.impl.jdbc.IFiller;
/*     */ import dtv.data2.access.impl.jdbc.IJDBCTableAdapter;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.crm.PartyCrossReferencePropertyId;
/*     */ import java.math.BigDecimal;
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
/*     */ public class PartyCrossReferencePropertyDBA
/*     */   implements IJDBCTableAdapter
/*     */ {
/*     */   private static final long serialVersionUID = 1716982854L;
/*     */   private Long _childPartyId;
/*     */   private Long _organizationId;
/*     */   private Long _parentPartyId;
/*     */   private String _partyRelationshipTypeCode;
/*     */   private String _propertyCode;
/*     */   private String _type;
/*     */   private String _stringValue;
/*     */   private Date _dateValue;
/*     */   private BigDecimal _decimalValue;
/*     */   private Date _createDate;
/*     */   private String _createUserId;
/*     */   private Date _updateDate;
/*     */   private String _updateUserId;
/*     */   private static final String SELECT_OBJECT = "SELECT t.child_party_id, t.organization_id, t.parent_party_id, t.party_relationship_typcode, t.property_code, t.type, t.string_value, t.date_value, t.decimal_value, t.create_date, t.create_user_id, t.update_date, t.update_user_id FROM crm_party_cross_reference_p t";
/*     */   private static final String SELECT_WHERE_OBJECT = " WHERE child_party_id = ?  AND organization_id = ?  AND parent_party_id = ?  AND party_relationship_typcode = ?  AND property_code = ?  ";
/*     */   
/*     */   public String getSelect() {
/*  42 */     return getSelectImpl();
/*     */   }
/*     */   
/*     */   private String getSelectImpl() {
/*  46 */     return "SELECT t.child_party_id, t.organization_id, t.parent_party_id, t.party_relationship_typcode, t.property_code, t.type, t.string_value, t.date_value, t.decimal_value, t.create_date, t.create_user_id, t.update_date, t.update_user_id FROM crm_party_cross_reference_p t";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectWhere() {
/*  52 */     return " WHERE child_party_id = ?  AND organization_id = ?  AND parent_party_id = ?  AND party_relationship_typcode = ?  AND property_code = ?  ";
/*     */   }
/*     */   
/*  55 */   private static final String[] INSERT_OBJECT = new String[] { "INSERT INTO crm_party_cross_reference_p(child_party_id, organization_id, parent_party_id, party_relationship_typcode, property_code, type, string_value, date_value, decimal_value, create_date, create_user_id, update_date, update_user_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" };
/*     */   
/*     */   public String[] getInsert() {
/*  58 */     return INSERT_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getInsertParameters() {
/*  62 */     Object[][] insertParameterObject = { { this._childPartyId, this._organizationId, this._parentPartyId, this._partyRelationshipTypeCode, this._propertyCode, this._type, this._stringValue, this._dateValue, this._decimalValue, this._createDate, this._createUserId, this._updateDate, this._updateUserId } };
/*  63 */     return insertParameterObject;
/*     */   }
/*     */   
/*  66 */   private static final int[][] INSERT_PARAMETER_TYPES_OBJECT = new int[][] { { -5, -5, -5, 12, 12, 12, 12, 91, 3, 91, 12, 91, 12 } };
/*     */   
/*     */   public int[][] getInsertParameterTypes() {
/*  69 */     return INSERT_PARAMETER_TYPES_OBJECT;
/*     */   }
/*     */   
/*  72 */   private static final String[] UPDATE_OBJECT = new String[] { "UPDATE crm_party_cross_reference_p SET type = ?, string_value = ?, date_value = ?, decimal_value = ?, update_date = ?, update_user_id = ?" };
/*     */   
/*     */   public String[] getUpdate() {
/*  75 */     return UPDATE_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getUpdateParameters() {
/*  79 */     Object[][] updateParameterObject = { { this._type, this._stringValue, this._dateValue, this._decimalValue, this._updateDate, this._updateUserId } };
/*  80 */     return updateParameterObject;
/*     */   }
/*     */   
/*  83 */   private static final int[][] UPDATE_PARAMETER_TYPE_OBJECT = new int[][] { { 12, 12, 91, 3, 91, 12 } };
/*     */   public int[][] getUpdateParameterTypes() {
/*  85 */     return UPDATE_PARAMETER_TYPE_OBJECT;
/*     */   }
/*     */   
/*  88 */   private static final String[] DELETE_OBJECT = new String[] { "DELETE FROM crm_party_cross_reference_p" }; private static final String WHERE_OBJECT = " WHERE child_party_id = ?  AND organization_id = ?  AND parent_party_id = ?  AND party_relationship_typcode = ?  AND property_code = ?  ";
/*     */   
/*     */   public String[] getDelete() {
/*  91 */     return DELETE_OBJECT;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWhere() {
/*  97 */     return " WHERE child_party_id = ?  AND organization_id = ?  AND parent_party_id = ?  AND party_relationship_typcode = ?  AND property_code = ?  ";
/*     */   }
/*     */   public Object[] getWhereParameters() {
/* 100 */     return new Object[] { this._childPartyId, this._organizationId, this._parentPartyId, this._partyRelationshipTypeCode, this._propertyCode };
/*     */   }
/*     */   
/* 103 */   private static final int[] WHERE_PARAMETER_OBJECT = new int[] { -5, -5, -5, 12, 12 };
/*     */   
/*     */   public int[] getWhereParameterTypes() {
/* 106 */     return WHERE_PARAMETER_OBJECT;
/*     */   }
/*     */   public String getTableName() {
/* 109 */     return "crm_party_cross_reference_p";
/*     */   }
/*     */   
/*     */   public IFiller getFiller() {
/* 113 */     return getFillerImpl();
/*     */   }
/*     */   
/*     */   private IFiller getFillerImpl() {
/* 117 */     return new PartyCrossReferencePropertyFiller(this);
/*     */   }
/*     */   
/*     */   private static class PartyCrossReferencePropertyFiller
/*     */     implements IFiller {
/*     */     private PartyCrossReferencePropertyDBA _parent;
/*     */     
/*     */     public PartyCrossReferencePropertyFiller(PartyCrossReferencePropertyDBA argParent) {
/* 125 */       this._parent = argParent;
/*     */     }
/*     */ 
/*     */     
/*     */     public void fill(ResultSet argResultSet) throws SQLException {
/* 130 */       long primitiveResult = argResultSet.getLong(1);
/* 131 */       if (primitiveResult != 0L || argResultSet.getObject(1) != null) {
/* 132 */         this._parent._childPartyId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 138 */       primitiveResult = argResultSet.getLong(2);
/* 139 */       if (primitiveResult != 0L || argResultSet.getObject(2) != null) {
/* 140 */         this._parent._organizationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 146 */       primitiveResult = argResultSet.getLong(3);
/* 147 */       if (primitiveResult != 0L || argResultSet.getObject(3) != null) {
/* 148 */         this._parent._parentPartyId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */       
/* 152 */       this._parent._partyRelationshipTypeCode = argResultSet.getString(4);
/* 153 */       this._parent._propertyCode = argResultSet.getString(5);
/* 154 */       this._parent._type = argResultSet.getString(6);
/* 155 */       this._parent._stringValue = argResultSet.getString(7);
/*     */       
/* 157 */       Timestamp t8 = argResultSet.getTimestamp(8);
/* 158 */       if (t8 != null) {
/* 159 */         this._parent._dateValue = (Date)new DtvDate(t8.getTime());
/*     */       } else {
/*     */         
/* 162 */         this._parent._dateValue = null;
/*     */       } 
/*     */       
/* 165 */       this._parent._decimalValue = argResultSet.getBigDecimal(9);
/*     */       
/* 167 */       Timestamp t10 = argResultSet.getTimestamp(10);
/* 168 */       if (t10 != null) {
/* 169 */         this._parent._createDate = (Date)new DtvDate(t10.getTime());
/*     */       } else {
/*     */         
/* 172 */         this._parent._createDate = null;
/*     */       } 
/*     */       
/* 175 */       this._parent._createUserId = argResultSet.getString(11);
/*     */       
/* 177 */       Timestamp t12 = argResultSet.getTimestamp(12);
/* 178 */       if (t12 != null) {
/* 179 */         this._parent._updateDate = (Date)new DtvDate(t12.getTime());
/*     */       } else {
/*     */         
/* 182 */         this._parent._updateDate = null;
/*     */       } 
/*     */       
/* 185 */       this._parent._updateUserId = argResultSet.getString(13);
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDAO(IDataAccessObject argDAO) {
/* 190 */     argDAO.suppressStateChanges(true);
/* 191 */     PartyCrossReferencePropertyDAO dao = (PartyCrossReferencePropertyDAO)argDAO;
/* 192 */     dao.setChildPartyId(this._childPartyId);
/* 193 */     dao.setOrganizationId(this._organizationId);
/* 194 */     dao.setParentPartyId(this._parentPartyId);
/* 195 */     dao.setPartyRelationshipTypeCode(this._partyRelationshipTypeCode);
/* 196 */     dao.setPropertyCode(this._propertyCode);
/* 197 */     dao.setType(this._type);
/* 198 */     dao.setStringValue(this._stringValue);
/* 199 */     dao.setDateValue(this._dateValue);
/* 200 */     dao.setDecimalValue(this._decimalValue);
/* 201 */     dao.setCreateDate(this._createDate);
/* 202 */     dao.setCreateUserId(this._createUserId);
/* 203 */     dao.setUpdateDate(this._updateDate);
/* 204 */     dao.setUpdateUserId(this._updateUserId);
/* 205 */     argDAO.suppressStateChanges(false);
/* 206 */     return (IDataAccessObject)dao;
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDefaultDAO() {
/* 210 */     return loadDAO((IDataAccessObject)new PartyCrossReferencePropertyDAO());
/*     */   }
/*     */   
/*     */   public void fill(IDataAccessObject argDAO) {
/* 214 */     PartyCrossReferencePropertyDAO dao = (PartyCrossReferencePropertyDAO)argDAO;
/* 215 */     this._childPartyId = dao.getChildPartyId();
/* 216 */     this._organizationId = dao.getOrganizationId();
/* 217 */     this._parentPartyId = dao.getParentPartyId();
/* 218 */     this._partyRelationshipTypeCode = dao.getPartyRelationshipTypeCode();
/* 219 */     this._propertyCode = dao.getPropertyCode();
/* 220 */     this._type = dao.getType();
/* 221 */     this._stringValue = dao.getStringValue();
/* 222 */     this._dateValue = dao.getDateValue();
/* 223 */     this._decimalValue = dao.getDecimalValue();
/* 224 */     this._createDate = dao.getCreateDate();
/* 225 */     this._createUserId = dao.getCreateUserId();
/* 226 */     this._updateDate = dao.getUpdateDate();
/* 227 */     this._updateUserId = dao.getUpdateUserId();
/*     */   }
/*     */   
/*     */   public PreparedStatement writeObjectId(IObjectId argId, PreparedStatement argStatement) throws SQLException {
/* 231 */     PartyCrossReferencePropertyId id = (PartyCrossReferencePropertyId)argId;
/* 232 */     argStatement.setLong(1, id.getChildPartyId().longValue());
/* 233 */     argStatement.setLong(2, id.getOrganizationId().longValue());
/* 234 */     argStatement.setLong(3, id.getParentPartyId().longValue());
/* 235 */     argStatement.setString(4, id.getPartyRelationshipTypeCode());
/* 236 */     argStatement.setString(5, id.getPropertyCode());
/* 237 */     return argStatement;
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 241 */     PartyCrossReferencePropertyId id = new PartyCrossReferencePropertyId();
/* 242 */     id.setChildPartyId(this._childPartyId);
/* 243 */     id.setOrganizationId(this._organizationId);
/* 244 */     id.setParentPartyId(this._parentPartyId);
/* 245 */     id.setPartyRelationshipTypeCode(this._partyRelationshipTypeCode);
/* 246 */     id.setPropertyCode(this._propertyCode);
/* 247 */     return (IObjectId)id;
/*     */   }
/*     */ 
/*     */   
/*     */   public void fill(IJDBCTableAdapter argAdapter) {}
/*     */ 
/*     */   
/*     */   public boolean isExtensible() {
/* 255 */     return false;
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 259 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\crm\impl\PartyCrossReferencePropertyDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */