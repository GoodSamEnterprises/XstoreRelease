/*     */ package dtv.xst.dao.doc.impl;
/*     */ 
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.impl.jdbc.IFiller;
/*     */ import dtv.data2.access.impl.jdbc.IJDBCTableAdapter;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.doc.DocumentDefinitionPropertiesPropertyId;
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
/*     */ public class DocumentDefinitionPropertiesPropertyDBA
/*     */   implements IJDBCTableAdapter
/*     */ {
/*     */   private static final long serialVersionUID = 688964022L;
/*     */   private String _seriesId;
/*     */   private Long _organizationId;
/*     */   private String _documentType;
/*     */   private Long _sequence;
/*     */   private String _propertyCode;
/*     */   private String _type;
/*     */   private String _stringValue;
/*     */   private Date _dateValue;
/*     */   private BigDecimal _decimalValue;
/*     */   private Date _createDate;
/*     */   private String _createUserId;
/*     */   private Date _updateDate;
/*     */   private String _updateUserId;
/*     */   private static final String SELECT_OBJECT = "SELECT t.series_id, t.organization_id, t.document_type, t.doc_seq_nbr, t.property_code, t.type, t.string_value, t.date_value, t.decimal_value, t.create_date, t.create_user_id, t.update_date, t.update_user_id FROM doc_document_def_properties_p t";
/*     */   private static final String SELECT_WHERE_OBJECT = " WHERE series_id = ?  AND organization_id = ?  AND document_type = ?  AND doc_seq_nbr = ?  AND property_code = ?  ";
/*     */   
/*     */   public String getSelect() {
/*  42 */     return getSelectImpl();
/*     */   }
/*     */   
/*     */   private String getSelectImpl() {
/*  46 */     return "SELECT t.series_id, t.organization_id, t.document_type, t.doc_seq_nbr, t.property_code, t.type, t.string_value, t.date_value, t.decimal_value, t.create_date, t.create_user_id, t.update_date, t.update_user_id FROM doc_document_def_properties_p t";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectWhere() {
/*  52 */     return " WHERE series_id = ?  AND organization_id = ?  AND document_type = ?  AND doc_seq_nbr = ?  AND property_code = ?  ";
/*     */   }
/*     */   
/*  55 */   private static final String[] INSERT_OBJECT = new String[] { "INSERT INTO doc_document_def_properties_p(series_id, organization_id, document_type, doc_seq_nbr, property_code, type, string_value, date_value, decimal_value, create_date, create_user_id, update_date, update_user_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" };
/*     */   
/*     */   public String[] getInsert() {
/*  58 */     return INSERT_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getInsertParameters() {
/*  62 */     Object[][] insertParameterObject = { { this._seriesId, this._organizationId, this._documentType, this._sequence, this._propertyCode, this._type, this._stringValue, this._dateValue, this._decimalValue, this._createDate, this._createUserId, this._updateDate, this._updateUserId } };
/*  63 */     return insertParameterObject;
/*     */   }
/*     */   
/*  66 */   private static final int[][] INSERT_PARAMETER_TYPES_OBJECT = new int[][] { { 12, -5, 12, -5, 12, 12, 12, 91, 3, 91, 12, 91, 12 } };
/*     */   
/*     */   public int[][] getInsertParameterTypes() {
/*  69 */     return INSERT_PARAMETER_TYPES_OBJECT;
/*     */   }
/*     */   
/*  72 */   private static final String[] UPDATE_OBJECT = new String[] { "UPDATE doc_document_def_properties_p SET type = ?, string_value = ?, date_value = ?, decimal_value = ?, update_date = ?, update_user_id = ?" };
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
/*  88 */   private static final String[] DELETE_OBJECT = new String[] { "DELETE FROM doc_document_def_properties_p" }; private static final String WHERE_OBJECT = " WHERE series_id = ?  AND organization_id = ?  AND document_type = ?  AND doc_seq_nbr = ?  AND property_code = ?  ";
/*     */   
/*     */   public String[] getDelete() {
/*  91 */     return DELETE_OBJECT;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWhere() {
/*  97 */     return " WHERE series_id = ?  AND organization_id = ?  AND document_type = ?  AND doc_seq_nbr = ?  AND property_code = ?  ";
/*     */   }
/*     */   public Object[] getWhereParameters() {
/* 100 */     return new Object[] { this._seriesId, this._organizationId, this._documentType, this._sequence, this._propertyCode };
/*     */   }
/*     */   
/* 103 */   private static final int[] WHERE_PARAMETER_OBJECT = new int[] { 12, -5, 12, -5, 12 };
/*     */   
/*     */   public int[] getWhereParameterTypes() {
/* 106 */     return WHERE_PARAMETER_OBJECT;
/*     */   }
/*     */   public String getTableName() {
/* 109 */     return "doc_document_def_properties_p";
/*     */   }
/*     */   
/*     */   public IFiller getFiller() {
/* 113 */     return getFillerImpl();
/*     */   }
/*     */   
/*     */   private IFiller getFillerImpl() {
/* 117 */     return new DocumentDefinitionPropertiesPropertyFiller(this);
/*     */   }
/*     */   
/*     */   private static class DocumentDefinitionPropertiesPropertyFiller
/*     */     implements IFiller {
/*     */     private DocumentDefinitionPropertiesPropertyDBA _parent;
/*     */     
/*     */     public DocumentDefinitionPropertiesPropertyFiller(DocumentDefinitionPropertiesPropertyDBA argParent) {
/* 125 */       this._parent = argParent;
/*     */     }
/*     */     public void fill(ResultSet argResultSet) throws SQLException {
/* 128 */       this._parent._seriesId = argResultSet.getString(1);
/*     */ 
/*     */       
/* 131 */       long primitiveResult = argResultSet.getLong(2);
/* 132 */       if (primitiveResult != 0L || argResultSet.getObject(2) != null) {
/* 133 */         this._parent._organizationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */       
/* 137 */       this._parent._documentType = argResultSet.getString(3);
/*     */ 
/*     */       
/* 140 */       primitiveResult = argResultSet.getLong(4);
/* 141 */       if (primitiveResult != 0L || argResultSet.getObject(4) != null) {
/* 142 */         this._parent._sequence = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */       
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
/* 184 */     DocumentDefinitionPropertiesPropertyDAO dao = (DocumentDefinitionPropertiesPropertyDAO)argDAO;
/* 185 */     dao.setSeriesId(this._seriesId);
/* 186 */     dao.setOrganizationId(this._organizationId);
/* 187 */     dao.setDocumentType(this._documentType);
/* 188 */     dao.setSequence(this._sequence);
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
/* 203 */     return loadDAO((IDataAccessObject)new DocumentDefinitionPropertiesPropertyDAO());
/*     */   }
/*     */   
/*     */   public void fill(IDataAccessObject argDAO) {
/* 207 */     DocumentDefinitionPropertiesPropertyDAO dao = (DocumentDefinitionPropertiesPropertyDAO)argDAO;
/* 208 */     this._seriesId = dao.getSeriesId();
/* 209 */     this._organizationId = dao.getOrganizationId();
/* 210 */     this._documentType = dao.getDocumentType();
/* 211 */     this._sequence = dao.getSequence();
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
/* 224 */     DocumentDefinitionPropertiesPropertyId id = (DocumentDefinitionPropertiesPropertyId)argId;
/* 225 */     argStatement.setString(1, id.getSeriesId());
/* 226 */     argStatement.setLong(2, id.getOrganizationId().longValue());
/* 227 */     argStatement.setString(3, id.getDocumentType());
/* 228 */     argStatement.setLong(4, id.getSequence().longValue());
/* 229 */     argStatement.setString(5, id.getPropertyCode());
/* 230 */     return argStatement;
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 234 */     DocumentDefinitionPropertiesPropertyId id = new DocumentDefinitionPropertiesPropertyId();
/* 235 */     id.setSeriesId(this._seriesId);
/* 236 */     id.setOrganizationId(this._organizationId);
/* 237 */     id.setDocumentType(this._documentType);
/* 238 */     id.setSequence(this._sequence);
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


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\doc\impl\DocumentDefinitionPropertiesPropertyDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */