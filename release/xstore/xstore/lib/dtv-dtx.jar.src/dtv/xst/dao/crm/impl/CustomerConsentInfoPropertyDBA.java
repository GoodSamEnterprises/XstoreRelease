/*     */ package dtv.xst.dao.crm.impl;
/*     */ 
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.impl.jdbc.IFiller;
/*     */ import dtv.data2.access.impl.jdbc.IJDBCTableAdapter;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.crm.CustomerConsentInfoPropertyId;
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
/*     */ public class CustomerConsentInfoPropertyDBA
/*     */   implements IJDBCTableAdapter
/*     */ {
/*     */   private static final long serialVersionUID = 803966207L;
/*     */   private Long _organizationId;
/*     */   private Date _effectiveDate;
/*     */   private String _propertyCode;
/*     */   private String _type;
/*     */   private String _stringValue;
/*     */   private Date _dateValue;
/*     */   private BigDecimal _decimalValue;
/*     */   private Date _createDate;
/*     */   private String _createUserId;
/*     */   private Date _updateDate;
/*     */   private String _updateUserId;
/*     */   private static final String SELECT_OBJECT = "SELECT t.organization_id, t.effective_date, t.property_code, t.type, t.string_value, t.date_value, t.decimal_value, t.create_date, t.create_user_id, t.update_date, t.update_user_id FROM crm_consent_info_p t";
/*     */   private static final String SELECT_WHERE_OBJECT = " WHERE organization_id = ?  AND effective_date = ?  AND property_code = ?  ";
/*     */   
/*     */   public String getSelect() {
/*  40 */     return getSelectImpl();
/*     */   }
/*     */   
/*     */   private String getSelectImpl() {
/*  44 */     return "SELECT t.organization_id, t.effective_date, t.property_code, t.type, t.string_value, t.date_value, t.decimal_value, t.create_date, t.create_user_id, t.update_date, t.update_user_id FROM crm_consent_info_p t";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectWhere() {
/*  50 */     return " WHERE organization_id = ?  AND effective_date = ?  AND property_code = ?  ";
/*     */   }
/*     */   
/*  53 */   private static final String[] INSERT_OBJECT = new String[] { "INSERT INTO crm_consent_info_p(organization_id, effective_date, property_code, type, string_value, date_value, decimal_value, create_date, create_user_id, update_date, update_user_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" };
/*     */   
/*     */   public String[] getInsert() {
/*  56 */     return INSERT_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getInsertParameters() {
/*  60 */     Object[][] insertParameterObject = { { this._organizationId, this._effectiveDate, this._propertyCode, this._type, this._stringValue, this._dateValue, this._decimalValue, this._createDate, this._createUserId, this._updateDate, this._updateUserId } };
/*  61 */     return insertParameterObject;
/*     */   }
/*     */   
/*  64 */   private static final int[][] INSERT_PARAMETER_TYPES_OBJECT = new int[][] { { -5, 91, 12, 12, 12, 91, 3, 91, 12, 91, 12 } };
/*     */   
/*     */   public int[][] getInsertParameterTypes() {
/*  67 */     return INSERT_PARAMETER_TYPES_OBJECT;
/*     */   }
/*     */   
/*  70 */   private static final String[] UPDATE_OBJECT = new String[] { "UPDATE crm_consent_info_p SET type = ?, string_value = ?, date_value = ?, decimal_value = ?, update_date = ?, update_user_id = ?" };
/*     */   
/*     */   public String[] getUpdate() {
/*  73 */     return UPDATE_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getUpdateParameters() {
/*  77 */     Object[][] updateParameterObject = { { this._type, this._stringValue, this._dateValue, this._decimalValue, this._updateDate, this._updateUserId } };
/*  78 */     return updateParameterObject;
/*     */   }
/*     */   
/*  81 */   private static final int[][] UPDATE_PARAMETER_TYPE_OBJECT = new int[][] { { 12, 12, 91, 3, 91, 12 } };
/*     */   public int[][] getUpdateParameterTypes() {
/*  83 */     return UPDATE_PARAMETER_TYPE_OBJECT;
/*     */   }
/*     */   
/*  86 */   private static final String[] DELETE_OBJECT = new String[] { "DELETE FROM crm_consent_info_p" }; private static final String WHERE_OBJECT = " WHERE organization_id = ?  AND effective_date = ?  AND property_code = ?  ";
/*     */   
/*     */   public String[] getDelete() {
/*  89 */     return DELETE_OBJECT;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWhere() {
/*  95 */     return " WHERE organization_id = ?  AND effective_date = ?  AND property_code = ?  ";
/*     */   }
/*     */   public Object[] getWhereParameters() {
/*  98 */     return new Object[] { this._organizationId, this._effectiveDate, this._propertyCode };
/*     */   }
/*     */   
/* 101 */   private static final int[] WHERE_PARAMETER_OBJECT = new int[] { -5, 91, 12 };
/*     */   
/*     */   public int[] getWhereParameterTypes() {
/* 104 */     return WHERE_PARAMETER_OBJECT;
/*     */   }
/*     */   public String getTableName() {
/* 107 */     return "crm_consent_info_p";
/*     */   }
/*     */   
/*     */   public IFiller getFiller() {
/* 111 */     return getFillerImpl();
/*     */   }
/*     */   
/*     */   private IFiller getFillerImpl() {
/* 115 */     return new CustomerConsentInfoPropertyFiller(this);
/*     */   }
/*     */   
/*     */   private static class CustomerConsentInfoPropertyFiller
/*     */     implements IFiller {
/*     */     private CustomerConsentInfoPropertyDBA _parent;
/*     */     
/*     */     public CustomerConsentInfoPropertyFiller(CustomerConsentInfoPropertyDBA argParent) {
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
/* 135 */       Timestamp t2 = argResultSet.getTimestamp(2);
/* 136 */       if (t2 != null) {
/* 137 */         this._parent._effectiveDate = (Date)new DtvDate(t2.getTime());
/*     */       } else {
/*     */         
/* 140 */         this._parent._effectiveDate = null;
/*     */       } 
/*     */       
/* 143 */       this._parent._propertyCode = argResultSet.getString(3);
/* 144 */       this._parent._type = argResultSet.getString(4);
/* 145 */       this._parent._stringValue = argResultSet.getString(5);
/*     */       
/* 147 */       Timestamp t6 = argResultSet.getTimestamp(6);
/* 148 */       if (t6 != null) {
/* 149 */         this._parent._dateValue = (Date)new DtvDate(t6.getTime());
/*     */       } else {
/*     */         
/* 152 */         this._parent._dateValue = null;
/*     */       } 
/*     */       
/* 155 */       this._parent._decimalValue = argResultSet.getBigDecimal(7);
/*     */       
/* 157 */       Timestamp t8 = argResultSet.getTimestamp(8);
/* 158 */       if (t8 != null) {
/* 159 */         this._parent._createDate = (Date)new DtvDate(t8.getTime());
/*     */       } else {
/*     */         
/* 162 */         this._parent._createDate = null;
/*     */       } 
/*     */       
/* 165 */       this._parent._createUserId = argResultSet.getString(9);
/*     */       
/* 167 */       Timestamp t10 = argResultSet.getTimestamp(10);
/* 168 */       if (t10 != null) {
/* 169 */         this._parent._updateDate = (Date)new DtvDate(t10.getTime());
/*     */       } else {
/*     */         
/* 172 */         this._parent._updateDate = null;
/*     */       } 
/*     */       
/* 175 */       this._parent._updateUserId = argResultSet.getString(11);
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDAO(IDataAccessObject argDAO) {
/* 180 */     argDAO.suppressStateChanges(true);
/* 181 */     CustomerConsentInfoPropertyDAO dao = (CustomerConsentInfoPropertyDAO)argDAO;
/* 182 */     dao.setOrganizationId(this._organizationId);
/* 183 */     dao.setEffectiveDate(this._effectiveDate);
/* 184 */     dao.setPropertyCode(this._propertyCode);
/* 185 */     dao.setType(this._type);
/* 186 */     dao.setStringValue(this._stringValue);
/* 187 */     dao.setDateValue(this._dateValue);
/* 188 */     dao.setDecimalValue(this._decimalValue);
/* 189 */     dao.setCreateDate(this._createDate);
/* 190 */     dao.setCreateUserId(this._createUserId);
/* 191 */     dao.setUpdateDate(this._updateDate);
/* 192 */     dao.setUpdateUserId(this._updateUserId);
/* 193 */     argDAO.suppressStateChanges(false);
/* 194 */     return (IDataAccessObject)dao;
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDefaultDAO() {
/* 198 */     return loadDAO((IDataAccessObject)new CustomerConsentInfoPropertyDAO());
/*     */   }
/*     */   
/*     */   public void fill(IDataAccessObject argDAO) {
/* 202 */     CustomerConsentInfoPropertyDAO dao = (CustomerConsentInfoPropertyDAO)argDAO;
/* 203 */     this._organizationId = dao.getOrganizationId();
/* 204 */     this._effectiveDate = dao.getEffectiveDate();
/* 205 */     this._propertyCode = dao.getPropertyCode();
/* 206 */     this._type = dao.getType();
/* 207 */     this._stringValue = dao.getStringValue();
/* 208 */     this._dateValue = dao.getDateValue();
/* 209 */     this._decimalValue = dao.getDecimalValue();
/* 210 */     this._createDate = dao.getCreateDate();
/* 211 */     this._createUserId = dao.getCreateUserId();
/* 212 */     this._updateDate = dao.getUpdateDate();
/* 213 */     this._updateUserId = dao.getUpdateUserId();
/*     */   }
/*     */   
/*     */   public PreparedStatement writeObjectId(IObjectId argId, PreparedStatement argStatement) throws SQLException {
/* 217 */     CustomerConsentInfoPropertyId id = (CustomerConsentInfoPropertyId)argId;
/* 218 */     argStatement.setLong(1, id.getOrganizationId().longValue());
/* 219 */     argStatement.setTimestamp(2, new Timestamp(id.getEffectiveDate().getTime()));
/* 220 */     argStatement.setString(3, id.getPropertyCode());
/* 221 */     return argStatement;
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 225 */     CustomerConsentInfoPropertyId id = new CustomerConsentInfoPropertyId();
/* 226 */     id.setOrganizationId(this._organizationId);
/* 227 */     id.setEffectiveDate(this._effectiveDate);
/* 228 */     id.setPropertyCode(this._propertyCode);
/* 229 */     return (IObjectId)id;
/*     */   }
/*     */ 
/*     */   
/*     */   public void fill(IJDBCTableAdapter argAdapter) {}
/*     */ 
/*     */   
/*     */   public boolean isExtensible() {
/* 237 */     return false;
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 241 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\crm\impl\CustomerConsentInfoPropertyDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */