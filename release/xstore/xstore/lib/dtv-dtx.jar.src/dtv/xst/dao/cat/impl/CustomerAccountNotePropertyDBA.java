/*     */ package dtv.xst.dao.cat.impl;
/*     */ 
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.impl.jdbc.IFiller;
/*     */ import dtv.data2.access.impl.jdbc.IJDBCTableAdapter;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.cat.CustomerAccountNotePropertyId;
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
/*     */ public class CustomerAccountNotePropertyDBA
/*     */   implements IJDBCTableAdapter
/*     */ {
/*     */   private static final long serialVersionUID = 1251449302L;
/*     */   private Long _noteSequence;
/*     */   private Long _organizationId;
/*     */   private String _custAccountId;
/*     */   private String _custAccountCode;
/*     */   private String _propertyCode;
/*     */   private String _type;
/*     */   private String _stringValue;
/*     */   private Date _dateValue;
/*     */   private BigDecimal _decimalValue;
/*     */   private Date _createDate;
/*     */   private String _createUserId;
/*     */   private Date _updateDate;
/*     */   private String _updateUserId;
/*     */   private static final String SELECT_OBJECT = "SELECT t.note_seq, t.organization_id, t.cust_acct_id, t.cust_acct_code, t.property_code, t.type, t.string_value, t.date_value, t.decimal_value, t.create_date, t.create_user_id, t.update_date, t.update_user_id FROM cat_acct_note_p t";
/*     */   private static final String SELECT_WHERE_OBJECT = " WHERE note_seq = ?  AND organization_id = ?  AND cust_acct_id = ?  AND cust_acct_code = ?  AND property_code = ?  ";
/*     */   
/*     */   public String getSelect() {
/*  42 */     return getSelectImpl();
/*     */   }
/*     */   
/*     */   private String getSelectImpl() {
/*  46 */     return "SELECT t.note_seq, t.organization_id, t.cust_acct_id, t.cust_acct_code, t.property_code, t.type, t.string_value, t.date_value, t.decimal_value, t.create_date, t.create_user_id, t.update_date, t.update_user_id FROM cat_acct_note_p t";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectWhere() {
/*  52 */     return " WHERE note_seq = ?  AND organization_id = ?  AND cust_acct_id = ?  AND cust_acct_code = ?  AND property_code = ?  ";
/*     */   }
/*     */   
/*  55 */   private static final String[] INSERT_OBJECT = new String[] { "INSERT INTO cat_acct_note_p(note_seq, organization_id, cust_acct_id, cust_acct_code, property_code, type, string_value, date_value, decimal_value, create_date, create_user_id, update_date, update_user_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" };
/*     */   
/*     */   public String[] getInsert() {
/*  58 */     return INSERT_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getInsertParameters() {
/*  62 */     Object[][] insertParameterObject = { { this._noteSequence, this._organizationId, this._custAccountId, this._custAccountCode, this._propertyCode, this._type, this._stringValue, this._dateValue, this._decimalValue, this._createDate, this._createUserId, this._updateDate, this._updateUserId } };
/*  63 */     return insertParameterObject;
/*     */   }
/*     */   
/*  66 */   private static final int[][] INSERT_PARAMETER_TYPES_OBJECT = new int[][] { { -5, -5, 12, 12, 12, 12, 12, 91, 3, 91, 12, 91, 12 } };
/*     */   
/*     */   public int[][] getInsertParameterTypes() {
/*  69 */     return INSERT_PARAMETER_TYPES_OBJECT;
/*     */   }
/*     */   
/*  72 */   private static final String[] UPDATE_OBJECT = new String[] { "UPDATE cat_acct_note_p SET type = ?, string_value = ?, date_value = ?, decimal_value = ?, update_date = ?, update_user_id = ?" };
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
/*  88 */   private static final String[] DELETE_OBJECT = new String[] { "DELETE FROM cat_acct_note_p" }; private static final String WHERE_OBJECT = " WHERE note_seq = ?  AND organization_id = ?  AND cust_acct_id = ?  AND cust_acct_code = ?  AND property_code = ?  ";
/*     */   
/*     */   public String[] getDelete() {
/*  91 */     return DELETE_OBJECT;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWhere() {
/*  97 */     return " WHERE note_seq = ?  AND organization_id = ?  AND cust_acct_id = ?  AND cust_acct_code = ?  AND property_code = ?  ";
/*     */   }
/*     */   public Object[] getWhereParameters() {
/* 100 */     return new Object[] { this._noteSequence, this._organizationId, this._custAccountId, this._custAccountCode, this._propertyCode };
/*     */   }
/*     */   
/* 103 */   private static final int[] WHERE_PARAMETER_OBJECT = new int[] { -5, -5, 12, 12, 12 };
/*     */   
/*     */   public int[] getWhereParameterTypes() {
/* 106 */     return WHERE_PARAMETER_OBJECT;
/*     */   }
/*     */   public String getTableName() {
/* 109 */     return "cat_acct_note_p";
/*     */   }
/*     */   
/*     */   public IFiller getFiller() {
/* 113 */     return getFillerImpl();
/*     */   }
/*     */   
/*     */   private IFiller getFillerImpl() {
/* 117 */     return new CustomerAccountNotePropertyFiller(this);
/*     */   }
/*     */   
/*     */   private static class CustomerAccountNotePropertyFiller
/*     */     implements IFiller {
/*     */     private CustomerAccountNotePropertyDBA _parent;
/*     */     
/*     */     public CustomerAccountNotePropertyFiller(CustomerAccountNotePropertyDBA argParent) {
/* 125 */       this._parent = argParent;
/*     */     }
/*     */ 
/*     */     
/*     */     public void fill(ResultSet argResultSet) throws SQLException {
/* 130 */       long primitiveResult = argResultSet.getLong(1);
/* 131 */       if (primitiveResult != 0L || argResultSet.getObject(1) != null) {
/* 132 */         this._parent._noteSequence = Long.valueOf(primitiveResult);
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
/* 144 */       this._parent._custAccountId = argResultSet.getString(3);
/* 145 */       this._parent._custAccountCode = argResultSet.getString(4);
/* 146 */       this._parent._propertyCode = argResultSet.getString(5);
/* 147 */       this._parent._type = argResultSet.getString(6);
/* 148 */       this._parent._stringValue = argResultSet.getString(7);
/*     */       
/* 150 */       Timestamp t8 = argResultSet.getTimestamp(8);
/* 151 */       if (t8 != null) {
/* 152 */         this._parent._dateValue = (Date)new DtvDate(t8.getTime());
/*     */       } else {
/*     */         
/* 155 */         this._parent._dateValue = null;
/*     */       } 
/*     */       
/* 158 */       this._parent._decimalValue = argResultSet.getBigDecimal(9);
/*     */       
/* 160 */       Timestamp t10 = argResultSet.getTimestamp(10);
/* 161 */       if (t10 != null) {
/* 162 */         this._parent._createDate = (Date)new DtvDate(t10.getTime());
/*     */       } else {
/*     */         
/* 165 */         this._parent._createDate = null;
/*     */       } 
/*     */       
/* 168 */       this._parent._createUserId = argResultSet.getString(11);
/*     */       
/* 170 */       Timestamp t12 = argResultSet.getTimestamp(12);
/* 171 */       if (t12 != null) {
/* 172 */         this._parent._updateDate = (Date)new DtvDate(t12.getTime());
/*     */       } else {
/*     */         
/* 175 */         this._parent._updateDate = null;
/*     */       } 
/*     */       
/* 178 */       this._parent._updateUserId = argResultSet.getString(13);
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDAO(IDataAccessObject argDAO) {
/* 183 */     argDAO.suppressStateChanges(true);
/* 184 */     CustomerAccountNotePropertyDAO dao = (CustomerAccountNotePropertyDAO)argDAO;
/* 185 */     dao.setNoteSequence(this._noteSequence);
/* 186 */     dao.setOrganizationId(this._organizationId);
/* 187 */     dao.setCustAccountId(this._custAccountId);
/* 188 */     dao.setCustAccountCode(this._custAccountCode);
/* 189 */     dao.setPropertyCode(this._propertyCode);
/* 190 */     dao.setType(this._type);
/* 191 */     dao.setStringValue(this._stringValue);
/* 192 */     dao.setDateValue(this._dateValue);
/* 193 */     dao.setDecimalValue(this._decimalValue);
/* 194 */     dao.setCreateDate(this._createDate);
/* 195 */     dao.setCreateUserId(this._createUserId);
/* 196 */     dao.setUpdateDate(this._updateDate);
/* 197 */     dao.setUpdateUserId(this._updateUserId);
/* 198 */     argDAO.suppressStateChanges(false);
/* 199 */     return (IDataAccessObject)dao;
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDefaultDAO() {
/* 203 */     return loadDAO((IDataAccessObject)new CustomerAccountNotePropertyDAO());
/*     */   }
/*     */   
/*     */   public void fill(IDataAccessObject argDAO) {
/* 207 */     CustomerAccountNotePropertyDAO dao = (CustomerAccountNotePropertyDAO)argDAO;
/* 208 */     this._noteSequence = dao.getNoteSequence();
/* 209 */     this._organizationId = dao.getOrganizationId();
/* 210 */     this._custAccountId = dao.getCustAccountId();
/* 211 */     this._custAccountCode = dao.getCustAccountCode();
/* 212 */     this._propertyCode = dao.getPropertyCode();
/* 213 */     this._type = dao.getType();
/* 214 */     this._stringValue = dao.getStringValue();
/* 215 */     this._dateValue = dao.getDateValue();
/* 216 */     this._decimalValue = dao.getDecimalValue();
/* 217 */     this._createDate = dao.getCreateDate();
/* 218 */     this._createUserId = dao.getCreateUserId();
/* 219 */     this._updateDate = dao.getUpdateDate();
/* 220 */     this._updateUserId = dao.getUpdateUserId();
/*     */   }
/*     */   
/*     */   public PreparedStatement writeObjectId(IObjectId argId, PreparedStatement argStatement) throws SQLException {
/* 224 */     CustomerAccountNotePropertyId id = (CustomerAccountNotePropertyId)argId;
/* 225 */     argStatement.setLong(1, id.getNoteSequence().longValue());
/* 226 */     argStatement.setLong(2, id.getOrganizationId().longValue());
/* 227 */     argStatement.setString(3, id.getCustAccountId());
/* 228 */     argStatement.setString(4, id.getCustAccountCode());
/* 229 */     argStatement.setString(5, id.getPropertyCode());
/* 230 */     return argStatement;
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 234 */     CustomerAccountNotePropertyId id = new CustomerAccountNotePropertyId();
/* 235 */     id.setNoteSequence(this._noteSequence);
/* 236 */     id.setOrganizationId(this._organizationId);
/* 237 */     id.setCustAccountId(this._custAccountId);
/* 238 */     id.setCustAccountCode(this._custAccountCode);
/* 239 */     id.setPropertyCode(this._propertyCode);
/* 240 */     return (IObjectId)id;
/*     */   }
/*     */ 
/*     */   
/*     */   public void fill(IJDBCTableAdapter argAdapter) {}
/*     */ 
/*     */   
/*     */   public boolean isExtensible() {
/* 248 */     return false;
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 252 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\cat\impl\CustomerAccountNotePropertyDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */