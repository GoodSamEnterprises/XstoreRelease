/*     */ package dtv.xst.dao.doc.impl;
/*     */ 
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.impl.jdbc.IFiller;
/*     */ import dtv.data2.access.impl.jdbc.IJDBCTableAdapter;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.util.ObjectUtils;
/*     */ import dtv.xst.dao.doc.DocumentDefinitionPropertiesId;
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
/*     */ public class DocumentDefinitionPropertiesDBA
/*     */   implements IJDBCTableAdapter
/*     */ {
/*     */   private static final long serialVersionUID = -1633627967L;
/*     */   private String _seriesId;
/*     */   private Long _organizationId;
/*     */   private String _documentType;
/*     */   private Long _sequence;
/*     */   private Date _createDate;
/*     */   private String _createUserId;
/*     */   private Date _updateDate;
/*     */   private String _updateUserId;
/*     */   private String _orgCode;
/*     */   private String _orgValue;
/*     */   private String _propertyCode;
/*     */   private String _type;
/*     */   private String _stringValue;
/*     */   private Date _dateValue;
/*     */   private BigDecimal _decimalValue;
/*     */   private static final String SELECT_OBJECT = "SELECT t.series_id, t.organization_id, t.document_type, t.doc_seq_nbr, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.org_code, t.org_value, t.property_code, t.type, t.string_value, t.date_value, t.decimal_value FROM doc_document_def_properties t";
/*     */   private static final String SELECT_WHERE_OBJECT = " WHERE series_id = ?  AND organization_id = ?  AND document_type = ?  AND doc_seq_nbr = ?  ";
/*     */   
/*     */   public String getSelect() {
/*  44 */     return getSelectImpl();
/*     */   }
/*     */   
/*     */   private String getSelectImpl() {
/*  48 */     return "SELECT t.series_id, t.organization_id, t.document_type, t.doc_seq_nbr, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.org_code, t.org_value, t.property_code, t.type, t.string_value, t.date_value, t.decimal_value FROM doc_document_def_properties t";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectWhere() {
/*  54 */     return " WHERE series_id = ?  AND organization_id = ?  AND document_type = ?  AND doc_seq_nbr = ?  ";
/*     */   }
/*     */   
/*  57 */   private static final String[] INSERT_OBJECT = new String[] { "INSERT INTO doc_document_def_properties(series_id, organization_id, document_type, doc_seq_nbr, create_date, create_user_id, update_date, update_user_id, org_code, org_value, property_code, type, string_value, date_value, decimal_value) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" };
/*     */   
/*     */   public String[] getInsert() {
/*  60 */     return INSERT_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getInsertParameters() {
/*  64 */     Object[][] insertParameterObject = { { this._seriesId, this._organizationId, this._documentType, this._sequence, this._createDate, this._createUserId, this._updateDate, this._updateUserId, ObjectUtils.coalesce((Object[])new String[] { this._orgCode, "*" }), ObjectUtils.coalesce((Object[])new String[] { this._orgValue, "*" }), this._propertyCode, this._type, this._stringValue, this._dateValue, this._decimalValue } };
/*  65 */     return insertParameterObject;
/*     */   }
/*     */   
/*  68 */   private static final int[][] INSERT_PARAMETER_TYPES_OBJECT = new int[][] { { 12, -5, 12, -5, 91, 12, 91, 12, 12, 12, 12, 12, 12, 91, 3 } };
/*     */   
/*     */   public int[][] getInsertParameterTypes() {
/*  71 */     return INSERT_PARAMETER_TYPES_OBJECT;
/*     */   }
/*     */   
/*  74 */   private static final String[] UPDATE_OBJECT = new String[] { "UPDATE doc_document_def_properties SET update_date = ?, update_user_id = ?, org_code = ?, org_value = ?, property_code = ?, type = ?, string_value = ?, date_value = ?, decimal_value = ?" };
/*     */   
/*     */   public String[] getUpdate() {
/*  77 */     return UPDATE_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getUpdateParameters() {
/*  81 */     Object[][] updateParameterObject = { { this._updateDate, this._updateUserId, this._orgCode, this._orgValue, this._propertyCode, this._type, this._stringValue, this._dateValue, this._decimalValue } };
/*  82 */     return updateParameterObject;
/*     */   }
/*     */   
/*  85 */   private static final int[][] UPDATE_PARAMETER_TYPE_OBJECT = new int[][] { { 91, 12, 12, 12, 12, 12, 12, 91, 3 } };
/*     */   public int[][] getUpdateParameterTypes() {
/*  87 */     return UPDATE_PARAMETER_TYPE_OBJECT;
/*     */   }
/*     */   
/*  90 */   private static final String[] DELETE_OBJECT = new String[] { "DELETE FROM doc_document_def_properties" }; private static final String WHERE_OBJECT = " WHERE series_id = ?  AND organization_id = ?  AND document_type = ?  AND doc_seq_nbr = ?  ";
/*     */   
/*     */   public String[] getDelete() {
/*  93 */     return DELETE_OBJECT;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWhere() {
/*  99 */     return " WHERE series_id = ?  AND organization_id = ?  AND document_type = ?  AND doc_seq_nbr = ?  ";
/*     */   }
/*     */   public Object[] getWhereParameters() {
/* 102 */     return new Object[] { this._seriesId, this._organizationId, this._documentType, this._sequence };
/*     */   }
/*     */   
/* 105 */   private static final int[] WHERE_PARAMETER_OBJECT = new int[] { 12, -5, 12, -5 };
/*     */   
/*     */   public int[] getWhereParameterTypes() {
/* 108 */     return WHERE_PARAMETER_OBJECT;
/*     */   }
/*     */   public String getTableName() {
/* 111 */     return "doc_document_def_properties";
/*     */   }
/*     */   
/*     */   public IFiller getFiller() {
/* 115 */     return getFillerImpl();
/*     */   }
/*     */   
/*     */   private IFiller getFillerImpl() {
/* 119 */     return new DocumentDefinitionPropertiesFiller(this);
/*     */   }
/*     */   
/*     */   private static class DocumentDefinitionPropertiesFiller
/*     */     implements IFiller {
/*     */     private DocumentDefinitionPropertiesDBA _parent;
/*     */     
/*     */     public DocumentDefinitionPropertiesFiller(DocumentDefinitionPropertiesDBA argParent) {
/* 127 */       this._parent = argParent;
/*     */     }
/*     */     public void fill(ResultSet argResultSet) throws SQLException {
/* 130 */       this._parent._seriesId = argResultSet.getString(1);
/*     */ 
/*     */       
/* 133 */       long primitiveResult = argResultSet.getLong(2);
/* 134 */       if (primitiveResult != 0L || argResultSet.getObject(2) != null) {
/* 135 */         this._parent._organizationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */       
/* 139 */       this._parent._documentType = argResultSet.getString(3);
/*     */ 
/*     */       
/* 142 */       primitiveResult = argResultSet.getLong(4);
/* 143 */       if (primitiveResult != 0L || argResultSet.getObject(4) != null) {
/* 144 */         this._parent._sequence = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */ 
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
/* 168 */       this._parent._orgCode = argResultSet.getString(9);
/* 169 */       this._parent._orgValue = argResultSet.getString(10);
/* 170 */       this._parent._propertyCode = argResultSet.getString(11);
/* 171 */       this._parent._type = argResultSet.getString(12);
/* 172 */       this._parent._stringValue = argResultSet.getString(13);
/*     */       
/* 174 */       Timestamp t14 = argResultSet.getTimestamp(14);
/* 175 */       if (t14 != null) {
/* 176 */         this._parent._dateValue = (Date)new DtvDate(t14.getTime());
/*     */       } else {
/*     */         
/* 179 */         this._parent._dateValue = null;
/*     */       } 
/*     */       
/* 182 */       this._parent._decimalValue = argResultSet.getBigDecimal(15);
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDAO(IDataAccessObject argDAO) {
/* 187 */     argDAO.suppressStateChanges(true);
/* 188 */     DocumentDefinitionPropertiesDAO dao = (DocumentDefinitionPropertiesDAO)argDAO;
/* 189 */     dao.setSeriesId(this._seriesId);
/* 190 */     dao.setOrganizationId(this._organizationId);
/* 191 */     dao.setDocumentType(this._documentType);
/* 192 */     dao.setSequence(this._sequence);
/* 193 */     dao.setCreateDate(this._createDate);
/* 194 */     dao.setCreateUserId(this._createUserId);
/* 195 */     dao.setUpdateDate(this._updateDate);
/* 196 */     dao.setUpdateUserId(this._updateUserId);
/* 197 */     dao.setOrgCode(this._orgCode);
/* 198 */     dao.setOrgValue(this._orgValue);
/* 199 */     dao.setPropertyCode(this._propertyCode);
/* 200 */     dao.setType(this._type);
/* 201 */     dao.setStringValue(this._stringValue);
/* 202 */     dao.setDateValue(this._dateValue);
/* 203 */     dao.setDecimalValue(this._decimalValue);
/* 204 */     argDAO.suppressStateChanges(false);
/* 205 */     return (IDataAccessObject)dao;
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDefaultDAO() {
/* 209 */     return loadDAO((IDataAccessObject)new DocumentDefinitionPropertiesDAO());
/*     */   }
/*     */   
/*     */   public void fill(IDataAccessObject argDAO) {
/* 213 */     DocumentDefinitionPropertiesDAO dao = (DocumentDefinitionPropertiesDAO)argDAO;
/* 214 */     this._seriesId = dao.getSeriesId();
/* 215 */     this._organizationId = dao.getOrganizationId();
/* 216 */     this._documentType = dao.getDocumentType();
/* 217 */     this._sequence = dao.getSequence();
/* 218 */     this._createDate = dao.getCreateDate();
/* 219 */     this._createUserId = dao.getCreateUserId();
/* 220 */     this._updateDate = dao.getUpdateDate();
/* 221 */     this._updateUserId = dao.getUpdateUserId();
/* 222 */     this._orgCode = dao.getOrgCode();
/* 223 */     this._orgValue = dao.getOrgValue();
/* 224 */     this._propertyCode = dao.getPropertyCode();
/* 225 */     this._type = dao.getType();
/* 226 */     this._stringValue = dao.getStringValue();
/* 227 */     this._dateValue = dao.getDateValue();
/* 228 */     this._decimalValue = dao.getDecimalValue();
/*     */   }
/*     */   
/*     */   public PreparedStatement writeObjectId(IObjectId argId, PreparedStatement argStatement) throws SQLException {
/* 232 */     DocumentDefinitionPropertiesId id = (DocumentDefinitionPropertiesId)argId;
/* 233 */     argStatement.setString(1, id.getSeriesId());
/* 234 */     argStatement.setLong(2, id.getOrganizationId().longValue());
/* 235 */     argStatement.setString(3, id.getDocumentType());
/* 236 */     argStatement.setLong(4, id.getSequence().longValue());
/* 237 */     return argStatement;
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 241 */     DocumentDefinitionPropertiesId id = new DocumentDefinitionPropertiesId();
/* 242 */     id.setSeriesId(this._seriesId);
/* 243 */     id.setOrganizationId(this._organizationId);
/* 244 */     id.setDocumentType(this._documentType);
/* 245 */     id.setSequence(this._sequence);
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


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\doc\impl\DocumentDefinitionPropertiesDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */