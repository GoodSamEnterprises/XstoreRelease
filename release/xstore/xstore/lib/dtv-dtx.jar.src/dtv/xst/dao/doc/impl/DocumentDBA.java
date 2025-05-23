/*     */ package dtv.xst.dao.doc.impl;
/*     */ 
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.impl.jdbc.IFiller;
/*     */ import dtv.data2.access.impl.jdbc.IJDBCTableAdapter;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.util.ObjectUtils;
/*     */ import dtv.xst.dao.doc.DocumentId;
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
/*     */ public class DocumentDBA
/*     */   implements IJDBCTableAdapter
/*     */ {
/*     */   private static final long serialVersionUID = 926364987L;
/*     */   private String _documentId;
/*     */   private Long _organizationId;
/*     */   private String _documentType;
/*     */   private String _seriesId;
/*     */   private Date _createDate;
/*     */   private String _createUserId;
/*     */   private Date _updateDate;
/*     */   private String _updateUserId;
/*     */   private String _orgCode;
/*     */   private String _orgValue;
/*     */   private String _documentStatus;
/*     */   private Date _issueDate;
/*     */   private Date _effectiveDate;
/*     */   private Date _expirationDate;
/*     */   private BigDecimal _amount;
/*     */   private BigDecimal _maxAmount;
/*     */   private BigDecimal _percent;
/*     */   private static final String SELECT_OBJECT = "SELECT t.document_id, t.organization_id, t.document_type, t.series_id, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.org_code, t.org_value, t.document_status, t.issue_date, t.effective_date, t.expiration_date, t.amount, t.max_amount, t.percentage FROM doc_document t";
/*     */   private static final String SELECT_WHERE_OBJECT = " WHERE document_id = ?  AND organization_id = ?  AND document_type = ?  AND series_id = ?  ";
/*     */   
/*     */   public String getSelect() {
/*  46 */     return getSelectImpl();
/*     */   }
/*     */   
/*     */   private String getSelectImpl() {
/*  50 */     return "SELECT t.document_id, t.organization_id, t.document_type, t.series_id, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.org_code, t.org_value, t.document_status, t.issue_date, t.effective_date, t.expiration_date, t.amount, t.max_amount, t.percentage FROM doc_document t";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectWhere() {
/*  56 */     return " WHERE document_id = ?  AND organization_id = ?  AND document_type = ?  AND series_id = ?  ";
/*     */   }
/*     */   
/*  59 */   private static final String[] INSERT_OBJECT = new String[] { "INSERT INTO doc_document(document_id, organization_id, document_type, series_id, create_date, create_user_id, update_date, update_user_id, org_code, org_value, document_status, issue_date, effective_date, expiration_date, amount, max_amount, percentage) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" };
/*     */   
/*     */   public String[] getInsert() {
/*  62 */     return INSERT_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getInsertParameters() {
/*  66 */     Object[][] insertParameterObject = { { this._documentId, this._organizationId, this._documentType, this._seriesId, this._createDate, this._createUserId, this._updateDate, this._updateUserId, ObjectUtils.coalesce((Object[])new String[] { this._orgCode, "*" }), ObjectUtils.coalesce((Object[])new String[] { this._orgValue, "*" }), this._documentStatus, this._issueDate, this._effectiveDate, this._expirationDate, this._amount, this._maxAmount, this._percent } };
/*  67 */     return insertParameterObject;
/*     */   }
/*     */   
/*  70 */   private static final int[][] INSERT_PARAMETER_TYPES_OBJECT = new int[][] { { 12, -5, 12, 12, 91, 12, 91, 12, 12, 12, 12, 91, 91, 91, 3, 3, 3 } };
/*     */   
/*     */   public int[][] getInsertParameterTypes() {
/*  73 */     return INSERT_PARAMETER_TYPES_OBJECT;
/*     */   }
/*     */   
/*  76 */   private static final String[] UPDATE_OBJECT = new String[] { "UPDATE doc_document SET update_date = ?, update_user_id = ?, org_code = ?, org_value = ?, document_status = ?, issue_date = ?, effective_date = ?, expiration_date = ?, amount = ?, max_amount = ?, percentage = ?" };
/*     */   
/*     */   public String[] getUpdate() {
/*  79 */     return UPDATE_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getUpdateParameters() {
/*  83 */     Object[][] updateParameterObject = { { this._updateDate, this._updateUserId, this._orgCode, this._orgValue, this._documentStatus, this._issueDate, this._effectiveDate, this._expirationDate, this._amount, this._maxAmount, this._percent } };
/*  84 */     return updateParameterObject;
/*     */   }
/*     */   
/*  87 */   private static final int[][] UPDATE_PARAMETER_TYPE_OBJECT = new int[][] { { 91, 12, 12, 12, 12, 91, 91, 91, 3, 3, 3 } };
/*     */   public int[][] getUpdateParameterTypes() {
/*  89 */     return UPDATE_PARAMETER_TYPE_OBJECT;
/*     */   }
/*     */   
/*  92 */   private static final String[] DELETE_OBJECT = new String[] { "DELETE FROM doc_document" }; private static final String WHERE_OBJECT = " WHERE document_id = ?  AND organization_id = ?  AND document_type = ?  AND series_id = ?  ";
/*     */   
/*     */   public String[] getDelete() {
/*  95 */     return DELETE_OBJECT;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWhere() {
/* 101 */     return " WHERE document_id = ?  AND organization_id = ?  AND document_type = ?  AND series_id = ?  ";
/*     */   }
/*     */   public Object[] getWhereParameters() {
/* 104 */     return new Object[] { this._documentId, this._organizationId, this._documentType, this._seriesId };
/*     */   }
/*     */   
/* 107 */   private static final int[] WHERE_PARAMETER_OBJECT = new int[] { 12, -5, 12, 12 };
/*     */   
/*     */   public int[] getWhereParameterTypes() {
/* 110 */     return WHERE_PARAMETER_OBJECT;
/*     */   }
/*     */   public String getTableName() {
/* 113 */     return "doc_document";
/*     */   }
/*     */   
/*     */   public IFiller getFiller() {
/* 117 */     return getFillerImpl();
/*     */   }
/*     */   
/*     */   private IFiller getFillerImpl() {
/* 121 */     return new DocumentFiller(this);
/*     */   }
/*     */   
/*     */   private static class DocumentFiller
/*     */     implements IFiller {
/*     */     private DocumentDBA _parent;
/*     */     
/*     */     public DocumentFiller(DocumentDBA argParent) {
/* 129 */       this._parent = argParent;
/*     */     }
/*     */     public void fill(ResultSet argResultSet) throws SQLException {
/* 132 */       this._parent._documentId = argResultSet.getString(1);
/*     */ 
/*     */       
/* 135 */       long primitiveResult = argResultSet.getLong(2);
/* 136 */       if (primitiveResult != 0L || argResultSet.getObject(2) != null) {
/* 137 */         this._parent._organizationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */       
/* 141 */       this._parent._documentType = argResultSet.getString(3);
/* 142 */       this._parent._seriesId = argResultSet.getString(4);
/*     */       
/* 144 */       Timestamp t5 = argResultSet.getTimestamp(5);
/* 145 */       if (t5 != null) {
/* 146 */         this._parent._createDate = (Date)new DtvDate(t5.getTime());
/*     */       } else {
/*     */         
/* 149 */         this._parent._createDate = null;
/*     */       } 
/*     */       
/* 152 */       this._parent._createUserId = argResultSet.getString(6);
/*     */       
/* 154 */       Timestamp t7 = argResultSet.getTimestamp(7);
/* 155 */       if (t7 != null) {
/* 156 */         this._parent._updateDate = (Date)new DtvDate(t7.getTime());
/*     */       } else {
/*     */         
/* 159 */         this._parent._updateDate = null;
/*     */       } 
/*     */       
/* 162 */       this._parent._updateUserId = argResultSet.getString(8);
/* 163 */       this._parent._orgCode = argResultSet.getString(9);
/* 164 */       this._parent._orgValue = argResultSet.getString(10);
/* 165 */       this._parent._documentStatus = argResultSet.getString(11);
/*     */       
/* 167 */       Timestamp t12 = argResultSet.getTimestamp(12);
/* 168 */       if (t12 != null) {
/* 169 */         this._parent._issueDate = (Date)new DtvDate(t12.getTime());
/*     */       } else {
/*     */         
/* 172 */         this._parent._issueDate = null;
/*     */       } 
/*     */ 
/*     */       
/* 176 */       Timestamp t13 = argResultSet.getTimestamp(13);
/* 177 */       if (t13 != null) {
/* 178 */         this._parent._effectiveDate = (Date)new DtvDate(t13.getTime());
/*     */       } else {
/*     */         
/* 181 */         this._parent._effectiveDate = null;
/*     */       } 
/*     */ 
/*     */       
/* 185 */       Timestamp t14 = argResultSet.getTimestamp(14);
/* 186 */       if (t14 != null) {
/* 187 */         this._parent._expirationDate = (Date)new DtvDate(t14.getTime());
/*     */       } else {
/*     */         
/* 190 */         this._parent._expirationDate = null;
/*     */       } 
/*     */       
/* 193 */       this._parent._amount = argResultSet.getBigDecimal(15);
/* 194 */       this._parent._maxAmount = argResultSet.getBigDecimal(16);
/* 195 */       this._parent._percent = argResultSet.getBigDecimal(17);
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDAO(IDataAccessObject argDAO) {
/* 200 */     argDAO.suppressStateChanges(true);
/* 201 */     DocumentDAO dao = (DocumentDAO)argDAO;
/* 202 */     dao.setDocumentId(this._documentId);
/* 203 */     dao.setOrganizationId(this._organizationId);
/* 204 */     dao.setDocumentType(this._documentType);
/* 205 */     dao.setSeriesId(this._seriesId);
/* 206 */     dao.setCreateDate(this._createDate);
/* 207 */     dao.setCreateUserId(this._createUserId);
/* 208 */     dao.setUpdateDate(this._updateDate);
/* 209 */     dao.setUpdateUserId(this._updateUserId);
/* 210 */     dao.setOrgCode(this._orgCode);
/* 211 */     dao.setOrgValue(this._orgValue);
/* 212 */     dao.setDocumentStatus(this._documentStatus);
/* 213 */     dao.setIssueDate(this._issueDate);
/* 214 */     dao.setEffectiveDate(this._effectiveDate);
/* 215 */     dao.setExpirationDate(this._expirationDate);
/* 216 */     dao.setAmount(this._amount);
/* 217 */     dao.setMaxAmount(this._maxAmount);
/* 218 */     dao.setPercent(this._percent);
/* 219 */     argDAO.suppressStateChanges(false);
/* 220 */     return (IDataAccessObject)dao;
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDefaultDAO() {
/* 224 */     return loadDAO((IDataAccessObject)new DocumentDAO());
/*     */   }
/*     */   
/*     */   public void fill(IDataAccessObject argDAO) {
/* 228 */     DocumentDAO dao = (DocumentDAO)argDAO;
/* 229 */     this._documentId = dao.getDocumentId();
/* 230 */     this._organizationId = dao.getOrganizationId();
/* 231 */     this._documentType = dao.getDocumentType();
/* 232 */     this._seriesId = dao.getSeriesId();
/* 233 */     this._createDate = dao.getCreateDate();
/* 234 */     this._createUserId = dao.getCreateUserId();
/* 235 */     this._updateDate = dao.getUpdateDate();
/* 236 */     this._updateUserId = dao.getUpdateUserId();
/* 237 */     this._orgCode = dao.getOrgCode();
/* 238 */     this._orgValue = dao.getOrgValue();
/* 239 */     this._documentStatus = dao.getDocumentStatus();
/* 240 */     this._issueDate = dao.getIssueDate();
/* 241 */     this._effectiveDate = dao.getEffectiveDate();
/* 242 */     this._expirationDate = dao.getExpirationDate();
/* 243 */     this._amount = dao.getAmount();
/* 244 */     this._maxAmount = dao.getMaxAmount();
/* 245 */     this._percent = dao.getPercent();
/*     */   }
/*     */   
/*     */   public PreparedStatement writeObjectId(IObjectId argId, PreparedStatement argStatement) throws SQLException {
/* 249 */     DocumentId id = (DocumentId)argId;
/* 250 */     argStatement.setString(1, id.getDocumentId());
/* 251 */     argStatement.setLong(2, id.getOrganizationId().longValue());
/* 252 */     argStatement.setString(3, id.getDocumentType());
/* 253 */     argStatement.setString(4, id.getSeriesId());
/* 254 */     return argStatement;
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 258 */     DocumentId id = new DocumentId();
/* 259 */     id.setDocumentId(this._documentId);
/* 260 */     id.setOrganizationId(this._organizationId);
/* 261 */     id.setDocumentType(this._documentType);
/* 262 */     id.setSeriesId(this._seriesId);
/* 263 */     return (IObjectId)id;
/*     */   }
/*     */ 
/*     */   
/*     */   public void fill(IJDBCTableAdapter argAdapter) {}
/*     */ 
/*     */   
/*     */   public boolean isExtensible() {
/* 271 */     return false;
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 275 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\doc\impl\DocumentDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */