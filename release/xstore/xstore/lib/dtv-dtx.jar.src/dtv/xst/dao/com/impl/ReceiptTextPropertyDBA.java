/*     */ package dtv.xst.dao.com.impl;
/*     */ 
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.impl.jdbc.IFiller;
/*     */ import dtv.data2.access.impl.jdbc.IJDBCTableAdapter;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.util.ObjectUtils;
/*     */ import dtv.xst.dao.com.ReceiptTextPropertyId;
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
/*     */ public class ReceiptTextPropertyDBA
/*     */   implements IJDBCTableAdapter
/*     */ {
/*     */   private static final long serialVersionUID = 476120154L;
/*     */   private Long _organizationId;
/*     */   private String _textCode;
/*     */   private Integer _textSequence;
/*     */   private String _textSubcode;
/*     */   private String _configElement;
/*     */   private String _propertyCode;
/*     */   private String _type;
/*     */   private String _stringValue;
/*     */   private Date _dateValue;
/*     */   private BigDecimal _decimalValue;
/*     */   private Date _createDate;
/*     */   private String _createUserId;
/*     */   private Date _updateDate;
/*     */   private String _updateUserId;
/*     */   private static final String SELECT_OBJECT = "SELECT t.organization_id, t.text_code, t.text_seq, t.text_subcode, t.config_element, t.property_code, t.type, t.string_value, t.date_value, t.decimal_value, t.create_date, t.create_user_id, t.update_date, t.update_user_id FROM com_receipt_text_p t";
/*     */   private static final String SELECT_WHERE_OBJECT = " WHERE organization_id = ?  AND text_code = ?  AND text_seq = ?  AND text_subcode = ?  AND config_element = ?  AND property_code = ?  ";
/*     */   
/*     */   public String getSelect() {
/*  43 */     return getSelectImpl();
/*     */   }
/*     */   
/*     */   private String getSelectImpl() {
/*  47 */     return "SELECT t.organization_id, t.text_code, t.text_seq, t.text_subcode, t.config_element, t.property_code, t.type, t.string_value, t.date_value, t.decimal_value, t.create_date, t.create_user_id, t.update_date, t.update_user_id FROM com_receipt_text_p t";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectWhere() {
/*  53 */     return " WHERE organization_id = ?  AND text_code = ?  AND text_seq = ?  AND text_subcode = ?  AND config_element = ?  AND property_code = ?  ";
/*     */   }
/*     */   
/*  56 */   private static final String[] INSERT_OBJECT = new String[] { "INSERT INTO com_receipt_text_p(organization_id, text_code, text_seq, text_subcode, config_element, property_code, type, string_value, date_value, decimal_value, create_date, create_user_id, update_date, update_user_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" };
/*     */   
/*     */   public String[] getInsert() {
/*  59 */     return INSERT_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getInsertParameters() {
/*  63 */     Object[][] insertParameterObject = { { this._organizationId, this._textCode, this._textSequence, this._textSubcode, ObjectUtils.coalesce((Object[])new String[] { this._configElement, "*" }), this._propertyCode, this._type, this._stringValue, this._dateValue, this._decimalValue, this._createDate, this._createUserId, this._updateDate, this._updateUserId } };
/*  64 */     return insertParameterObject;
/*     */   }
/*     */   
/*  67 */   private static final int[][] INSERT_PARAMETER_TYPES_OBJECT = new int[][] { { -5, 12, 4, 12, 12, 12, 12, 12, 91, 3, 91, 12, 91, 12 } };
/*     */   
/*     */   public int[][] getInsertParameterTypes() {
/*  70 */     return INSERT_PARAMETER_TYPES_OBJECT;
/*     */   }
/*     */   
/*  73 */   private static final String[] UPDATE_OBJECT = new String[] { "UPDATE com_receipt_text_p SET type = ?, string_value = ?, date_value = ?, decimal_value = ?, update_date = ?, update_user_id = ?" };
/*     */   
/*     */   public String[] getUpdate() {
/*  76 */     return UPDATE_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getUpdateParameters() {
/*  80 */     Object[][] updateParameterObject = { { this._type, this._stringValue, this._dateValue, this._decimalValue, this._updateDate, this._updateUserId } };
/*  81 */     return updateParameterObject;
/*     */   }
/*     */   
/*  84 */   private static final int[][] UPDATE_PARAMETER_TYPE_OBJECT = new int[][] { { 12, 12, 91, 3, 91, 12 } };
/*     */   public int[][] getUpdateParameterTypes() {
/*  86 */     return UPDATE_PARAMETER_TYPE_OBJECT;
/*     */   }
/*     */   
/*  89 */   private static final String[] DELETE_OBJECT = new String[] { "DELETE FROM com_receipt_text_p" }; private static final String WHERE_OBJECT = " WHERE organization_id = ?  AND text_code = ?  AND text_seq = ?  AND text_subcode = ?  AND config_element = ?  AND property_code = ?  ";
/*     */   
/*     */   public String[] getDelete() {
/*  92 */     return DELETE_OBJECT;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWhere() {
/*  98 */     return " WHERE organization_id = ?  AND text_code = ?  AND text_seq = ?  AND text_subcode = ?  AND config_element = ?  AND property_code = ?  ";
/*     */   }
/*     */   public Object[] getWhereParameters() {
/* 101 */     return new Object[] { this._organizationId, this._textCode, this._textSequence, this._textSubcode, ObjectUtils.coalesce((Object[])new String[] { this._configElement, "*" }), this._propertyCode };
/*     */   }
/*     */   
/* 104 */   private static final int[] WHERE_PARAMETER_OBJECT = new int[] { -5, 12, 4, 12, 12, 12 };
/*     */   
/*     */   public int[] getWhereParameterTypes() {
/* 107 */     return WHERE_PARAMETER_OBJECT;
/*     */   }
/*     */   public String getTableName() {
/* 110 */     return "com_receipt_text_p";
/*     */   }
/*     */   
/*     */   public IFiller getFiller() {
/* 114 */     return getFillerImpl();
/*     */   }
/*     */   
/*     */   private IFiller getFillerImpl() {
/* 118 */     return new ReceiptTextPropertyFiller(this);
/*     */   }
/*     */   
/*     */   private static class ReceiptTextPropertyFiller
/*     */     implements IFiller {
/*     */     private ReceiptTextPropertyDBA _parent;
/*     */     
/*     */     public ReceiptTextPropertyFiller(ReceiptTextPropertyDBA argParent) {
/* 126 */       this._parent = argParent;
/*     */     }
/*     */ 
/*     */     
/*     */     public void fill(ResultSet argResultSet) throws SQLException {
/* 131 */       long l = argResultSet.getLong(1);
/* 132 */       if (l != 0L || argResultSet.getObject(1) != null) {
/* 133 */         this._parent._organizationId = Long.valueOf(l);
/*     */       }
/*     */ 
/*     */       
/* 137 */       this._parent._textCode = argResultSet.getString(2);
/*     */ 
/*     */       
/* 140 */       int primitiveResult = argResultSet.getInt(3);
/* 141 */       if (primitiveResult != 0 || argResultSet.getObject(3) != null) {
/* 142 */         this._parent._textSequence = Integer.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */       
/* 146 */       this._parent._textSubcode = argResultSet.getString(4);
/* 147 */       this._parent._configElement = argResultSet.getString(5);
/* 148 */       this._parent._propertyCode = argResultSet.getString(6);
/* 149 */       this._parent._type = argResultSet.getString(7);
/* 150 */       this._parent._stringValue = argResultSet.getString(8);
/*     */       
/* 152 */       Timestamp t9 = argResultSet.getTimestamp(9);
/* 153 */       if (t9 != null) {
/* 154 */         this._parent._dateValue = (Date)new DtvDate(t9.getTime());
/*     */       } else {
/*     */         
/* 157 */         this._parent._dateValue = null;
/*     */       } 
/*     */       
/* 160 */       this._parent._decimalValue = argResultSet.getBigDecimal(10);
/*     */       
/* 162 */       Timestamp t11 = argResultSet.getTimestamp(11);
/* 163 */       if (t11 != null) {
/* 164 */         this._parent._createDate = (Date)new DtvDate(t11.getTime());
/*     */       } else {
/*     */         
/* 167 */         this._parent._createDate = null;
/*     */       } 
/*     */       
/* 170 */       this._parent._createUserId = argResultSet.getString(12);
/*     */       
/* 172 */       Timestamp t13 = argResultSet.getTimestamp(13);
/* 173 */       if (t13 != null) {
/* 174 */         this._parent._updateDate = (Date)new DtvDate(t13.getTime());
/*     */       } else {
/*     */         
/* 177 */         this._parent._updateDate = null;
/*     */       } 
/*     */       
/* 180 */       this._parent._updateUserId = argResultSet.getString(14);
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDAO(IDataAccessObject argDAO) {
/* 185 */     argDAO.suppressStateChanges(true);
/* 186 */     ReceiptTextPropertyDAO dao = (ReceiptTextPropertyDAO)argDAO;
/* 187 */     dao.setOrganizationId(this._organizationId);
/* 188 */     dao.setTextCode(this._textCode);
/* 189 */     dao.setTextSequence(this._textSequence);
/* 190 */     dao.setTextSubcode(this._textSubcode);
/* 191 */     dao.setConfigElement(this._configElement);
/* 192 */     dao.setPropertyCode(this._propertyCode);
/* 193 */     dao.setType(this._type);
/* 194 */     dao.setStringValue(this._stringValue);
/* 195 */     dao.setDateValue(this._dateValue);
/* 196 */     dao.setDecimalValue(this._decimalValue);
/* 197 */     dao.setCreateDate(this._createDate);
/* 198 */     dao.setCreateUserId(this._createUserId);
/* 199 */     dao.setUpdateDate(this._updateDate);
/* 200 */     dao.setUpdateUserId(this._updateUserId);
/* 201 */     argDAO.suppressStateChanges(false);
/* 202 */     return (IDataAccessObject)dao;
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDefaultDAO() {
/* 206 */     return loadDAO((IDataAccessObject)new ReceiptTextPropertyDAO());
/*     */   }
/*     */   
/*     */   public void fill(IDataAccessObject argDAO) {
/* 210 */     ReceiptTextPropertyDAO dao = (ReceiptTextPropertyDAO)argDAO;
/* 211 */     this._organizationId = dao.getOrganizationId();
/* 212 */     this._textCode = dao.getTextCode();
/* 213 */     this._textSequence = dao.getTextSequence();
/* 214 */     this._textSubcode = dao.getTextSubcode();
/* 215 */     this._configElement = dao.getConfigElement();
/* 216 */     this._propertyCode = dao.getPropertyCode();
/* 217 */     this._type = dao.getType();
/* 218 */     this._stringValue = dao.getStringValue();
/* 219 */     this._dateValue = dao.getDateValue();
/* 220 */     this._decimalValue = dao.getDecimalValue();
/* 221 */     this._createDate = dao.getCreateDate();
/* 222 */     this._createUserId = dao.getCreateUserId();
/* 223 */     this._updateDate = dao.getUpdateDate();
/* 224 */     this._updateUserId = dao.getUpdateUserId();
/*     */   }
/*     */   
/*     */   public PreparedStatement writeObjectId(IObjectId argId, PreparedStatement argStatement) throws SQLException {
/* 228 */     ReceiptTextPropertyId id = (ReceiptTextPropertyId)argId;
/* 229 */     argStatement.setLong(1, id.getOrganizationId().longValue());
/* 230 */     argStatement.setString(2, id.getTextCode());
/* 231 */     argStatement.setInt(3, id.getTextSequence().intValue());
/* 232 */     argStatement.setString(4, id.getTextSubcode());
/* 233 */     argStatement.setString(5, id.getConfigElement());
/* 234 */     argStatement.setString(6, id.getPropertyCode());
/* 235 */     return argStatement;
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 239 */     ReceiptTextPropertyId id = new ReceiptTextPropertyId();
/* 240 */     id.setOrganizationId(this._organizationId);
/* 241 */     id.setTextCode(this._textCode);
/* 242 */     id.setTextSequence(this._textSequence);
/* 243 */     id.setTextSubcode(this._textSubcode);
/* 244 */     id.setConfigElement(this._configElement);
/* 245 */     id.setPropertyCode(this._propertyCode);
/* 246 */     return (IObjectId)id;
/*     */   }
/*     */ 
/*     */   
/*     */   public void fill(IJDBCTableAdapter argAdapter) {}
/*     */ 
/*     */   
/*     */   public boolean isExtensible() {
/* 254 */     return false;
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 258 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\com\impl\ReceiptTextPropertyDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */