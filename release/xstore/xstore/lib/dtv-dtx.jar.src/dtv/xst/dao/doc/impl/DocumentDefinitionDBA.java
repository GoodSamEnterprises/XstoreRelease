/*     */ package dtv.xst.dao.doc.impl;
/*     */ 
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.impl.jdbc.IFiller;
/*     */ import dtv.data2.access.impl.jdbc.IJDBCTableAdapter;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.util.ObjectUtils;
/*     */ import dtv.xst.dao.doc.DocumentDefinitionId;
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
/*     */ public class DocumentDefinitionDBA
/*     */   implements IJDBCTableAdapter
/*     */ {
/*     */   private static final long serialVersionUID = -1031194386L;
/*     */   private String _seriesId;
/*     */   private Long _organizationId;
/*     */   private String _documentType;
/*     */   private Date _createDate;
/*     */   private String _createUserId;
/*     */   private Date _updateDate;
/*     */   private String _updateUserId;
/*     */   private String _orgCode;
/*     */   private String _orgValue;
/*     */   private Date _startIssueDate;
/*     */   private Date _endIssueDate;
/*     */   private Date _startRedeemDate;
/*     */   private Date _endRedeemDate;
/*     */   private String _vendorId;
/*     */   private String _description;
/*     */   private String _receiptType;
/*     */   private String _segmentType;
/*     */   private String _textCodeValue;
/*     */   private String _fileName;
/*     */   private static final String SELECT_OBJECT = "SELECT t.series_id, t.organization_id, t.document_type, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.org_code, t.org_value, t.start_issue_date, t.end_issue_date, t.start_redeem_date, t.end_redeem_date, t.vendor_id, t.description, t.receipt_type, t.segment_type, t.text_code_value, t.file_name FROM doc_document_definition t";
/*     */   private static final String SELECT_WHERE_OBJECT = " WHERE series_id = ?  AND organization_id = ?  AND document_type = ?  ";
/*     */   
/*     */   public String getSelect() {
/*  48 */     return getSelectImpl();
/*     */   }
/*     */   
/*     */   private String getSelectImpl() {
/*  52 */     return "SELECT t.series_id, t.organization_id, t.document_type, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.org_code, t.org_value, t.start_issue_date, t.end_issue_date, t.start_redeem_date, t.end_redeem_date, t.vendor_id, t.description, t.receipt_type, t.segment_type, t.text_code_value, t.file_name FROM doc_document_definition t";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectWhere() {
/*  58 */     return " WHERE series_id = ?  AND organization_id = ?  AND document_type = ?  ";
/*     */   }
/*     */   
/*  61 */   private static final String[] INSERT_OBJECT = new String[] { "INSERT INTO doc_document_definition(series_id, organization_id, document_type, create_date, create_user_id, update_date, update_user_id, org_code, org_value, start_issue_date, end_issue_date, start_redeem_date, end_redeem_date, vendor_id, description, receipt_type, segment_type, text_code_value, file_name) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" };
/*     */   
/*     */   public String[] getInsert() {
/*  64 */     return INSERT_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getInsertParameters() {
/*  68 */     Object[][] insertParameterObject = { { this._seriesId, this._organizationId, this._documentType, this._createDate, this._createUserId, this._updateDate, this._updateUserId, ObjectUtils.coalesce((Object[])new String[] { this._orgCode, "*" }), ObjectUtils.coalesce((Object[])new String[] { this._orgValue, "*" }), this._startIssueDate, this._endIssueDate, this._startRedeemDate, this._endRedeemDate, this._vendorId, this._description, this._receiptType, this._segmentType, this._textCodeValue, this._fileName } };
/*  69 */     return insertParameterObject;
/*     */   }
/*     */   
/*  72 */   private static final int[][] INSERT_PARAMETER_TYPES_OBJECT = new int[][] { { 12, -5, 12, 91, 12, 91, 12, 12, 12, 91, 91, 91, 91, 12, 12, 12, 12, 12, 12 } };
/*     */   
/*     */   public int[][] getInsertParameterTypes() {
/*  75 */     return INSERT_PARAMETER_TYPES_OBJECT;
/*     */   }
/*     */   
/*  78 */   private static final String[] UPDATE_OBJECT = new String[] { "UPDATE doc_document_definition SET update_date = ?, update_user_id = ?, org_code = ?, org_value = ?, start_issue_date = ?, end_issue_date = ?, start_redeem_date = ?, end_redeem_date = ?, vendor_id = ?, description = ?, receipt_type = ?, segment_type = ?, text_code_value = ?, file_name = ?" };
/*     */   
/*     */   public String[] getUpdate() {
/*  81 */     return UPDATE_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getUpdateParameters() {
/*  85 */     Object[][] updateParameterObject = { { this._updateDate, this._updateUserId, this._orgCode, this._orgValue, this._startIssueDate, this._endIssueDate, this._startRedeemDate, this._endRedeemDate, this._vendorId, this._description, this._receiptType, this._segmentType, this._textCodeValue, this._fileName } };
/*  86 */     return updateParameterObject;
/*     */   }
/*     */   
/*  89 */   private static final int[][] UPDATE_PARAMETER_TYPE_OBJECT = new int[][] { { 91, 12, 12, 12, 91, 91, 91, 91, 12, 12, 12, 12, 12, 12 } };
/*     */   public int[][] getUpdateParameterTypes() {
/*  91 */     return UPDATE_PARAMETER_TYPE_OBJECT;
/*     */   }
/*     */   
/*  94 */   private static final String[] DELETE_OBJECT = new String[] { "DELETE FROM doc_document_definition" }; private static final String WHERE_OBJECT = " WHERE series_id = ?  AND organization_id = ?  AND document_type = ?  ";
/*     */   
/*     */   public String[] getDelete() {
/*  97 */     return DELETE_OBJECT;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWhere() {
/* 103 */     return " WHERE series_id = ?  AND organization_id = ?  AND document_type = ?  ";
/*     */   }
/*     */   public Object[] getWhereParameters() {
/* 106 */     return new Object[] { this._seriesId, this._organizationId, this._documentType };
/*     */   }
/*     */   
/* 109 */   private static final int[] WHERE_PARAMETER_OBJECT = new int[] { 12, -5, 12 };
/*     */   
/*     */   public int[] getWhereParameterTypes() {
/* 112 */     return WHERE_PARAMETER_OBJECT;
/*     */   }
/*     */   public String getTableName() {
/* 115 */     return "doc_document_definition";
/*     */   }
/*     */   
/*     */   public IFiller getFiller() {
/* 119 */     return getFillerImpl();
/*     */   }
/*     */   
/*     */   private IFiller getFillerImpl() {
/* 123 */     return new DocumentDefinitionFiller(this);
/*     */   }
/*     */   
/*     */   private static class DocumentDefinitionFiller
/*     */     implements IFiller {
/*     */     private DocumentDefinitionDBA _parent;
/*     */     
/*     */     public DocumentDefinitionFiller(DocumentDefinitionDBA argParent) {
/* 131 */       this._parent = argParent;
/*     */     }
/*     */     public void fill(ResultSet argResultSet) throws SQLException {
/* 134 */       this._parent._seriesId = argResultSet.getString(1);
/*     */ 
/*     */       
/* 137 */       long primitiveResult = argResultSet.getLong(2);
/* 138 */       if (primitiveResult != 0L || argResultSet.getObject(2) != null) {
/* 139 */         this._parent._organizationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */       
/* 143 */       this._parent._documentType = argResultSet.getString(3);
/*     */       
/* 145 */       Timestamp t4 = argResultSet.getTimestamp(4);
/* 146 */       if (t4 != null) {
/* 147 */         this._parent._createDate = (Date)new DtvDate(t4.getTime());
/*     */       } else {
/*     */         
/* 150 */         this._parent._createDate = null;
/*     */       } 
/*     */       
/* 153 */       this._parent._createUserId = argResultSet.getString(5);
/*     */       
/* 155 */       Timestamp t6 = argResultSet.getTimestamp(6);
/* 156 */       if (t6 != null) {
/* 157 */         this._parent._updateDate = (Date)new DtvDate(t6.getTime());
/*     */       } else {
/*     */         
/* 160 */         this._parent._updateDate = null;
/*     */       } 
/*     */       
/* 163 */       this._parent._updateUserId = argResultSet.getString(7);
/* 164 */       this._parent._orgCode = argResultSet.getString(8);
/* 165 */       this._parent._orgValue = argResultSet.getString(9);
/*     */       
/* 167 */       Timestamp t10 = argResultSet.getTimestamp(10);
/* 168 */       if (t10 != null) {
/* 169 */         this._parent._startIssueDate = (Date)new DtvDate(t10.getTime());
/*     */       } else {
/*     */         
/* 172 */         this._parent._startIssueDate = null;
/*     */       } 
/*     */ 
/*     */       
/* 176 */       Timestamp t11 = argResultSet.getTimestamp(11);
/* 177 */       if (t11 != null) {
/* 178 */         this._parent._endIssueDate = (Date)new DtvDate(t11.getTime());
/*     */       } else {
/*     */         
/* 181 */         this._parent._endIssueDate = null;
/*     */       } 
/*     */ 
/*     */       
/* 185 */       Timestamp t12 = argResultSet.getTimestamp(12);
/* 186 */       if (t12 != null) {
/* 187 */         this._parent._startRedeemDate = (Date)new DtvDate(t12.getTime());
/*     */       } else {
/*     */         
/* 190 */         this._parent._startRedeemDate = null;
/*     */       } 
/*     */ 
/*     */       
/* 194 */       Timestamp t13 = argResultSet.getTimestamp(13);
/* 195 */       if (t13 != null) {
/* 196 */         this._parent._endRedeemDate = (Date)new DtvDate(t13.getTime());
/*     */       } else {
/*     */         
/* 199 */         this._parent._endRedeemDate = null;
/*     */       } 
/*     */       
/* 202 */       this._parent._vendorId = argResultSet.getString(14);
/* 203 */       this._parent._description = argResultSet.getString(15);
/* 204 */       this._parent._receiptType = argResultSet.getString(16);
/* 205 */       this._parent._segmentType = argResultSet.getString(17);
/* 206 */       this._parent._textCodeValue = argResultSet.getString(18);
/* 207 */       this._parent._fileName = argResultSet.getString(19);
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDAO(IDataAccessObject argDAO) {
/* 212 */     argDAO.suppressStateChanges(true);
/* 213 */     DocumentDefinitionDAO dao = (DocumentDefinitionDAO)argDAO;
/* 214 */     dao.setSeriesId(this._seriesId);
/* 215 */     dao.setOrganizationId(this._organizationId);
/* 216 */     dao.setDocumentType(this._documentType);
/* 217 */     dao.setCreateDate(this._createDate);
/* 218 */     dao.setCreateUserId(this._createUserId);
/* 219 */     dao.setUpdateDate(this._updateDate);
/* 220 */     dao.setUpdateUserId(this._updateUserId);
/* 221 */     dao.setOrgCode(this._orgCode);
/* 222 */     dao.setOrgValue(this._orgValue);
/* 223 */     dao.setStartIssueDate(this._startIssueDate);
/* 224 */     dao.setEndIssueDate(this._endIssueDate);
/* 225 */     dao.setStartRedeemDate(this._startRedeemDate);
/* 226 */     dao.setEndRedeemDate(this._endRedeemDate);
/* 227 */     dao.setVendorId(this._vendorId);
/* 228 */     dao.setDescription(this._description);
/* 229 */     dao.setReceiptType(this._receiptType);
/* 230 */     dao.setSegmentType(this._segmentType);
/* 231 */     dao.setTextCodeValue(this._textCodeValue);
/* 232 */     dao.setFileName(this._fileName);
/* 233 */     argDAO.suppressStateChanges(false);
/* 234 */     return (IDataAccessObject)dao;
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDefaultDAO() {
/* 238 */     return loadDAO((IDataAccessObject)new DocumentDefinitionDAO());
/*     */   }
/*     */   
/*     */   public void fill(IDataAccessObject argDAO) {
/* 242 */     DocumentDefinitionDAO dao = (DocumentDefinitionDAO)argDAO;
/* 243 */     this._seriesId = dao.getSeriesId();
/* 244 */     this._organizationId = dao.getOrganizationId();
/* 245 */     this._documentType = dao.getDocumentType();
/* 246 */     this._createDate = dao.getCreateDate();
/* 247 */     this._createUserId = dao.getCreateUserId();
/* 248 */     this._updateDate = dao.getUpdateDate();
/* 249 */     this._updateUserId = dao.getUpdateUserId();
/* 250 */     this._orgCode = dao.getOrgCode();
/* 251 */     this._orgValue = dao.getOrgValue();
/* 252 */     this._startIssueDate = dao.getStartIssueDate();
/* 253 */     this._endIssueDate = dao.getEndIssueDate();
/* 254 */     this._startRedeemDate = dao.getStartRedeemDate();
/* 255 */     this._endRedeemDate = dao.getEndRedeemDate();
/* 256 */     this._vendorId = dao.getVendorId();
/* 257 */     this._description = dao.getDescription();
/* 258 */     this._receiptType = dao.getReceiptType();
/* 259 */     this._segmentType = dao.getSegmentType();
/* 260 */     this._textCodeValue = dao.getTextCodeValue();
/* 261 */     this._fileName = dao.getFileName();
/*     */   }
/*     */   
/*     */   public PreparedStatement writeObjectId(IObjectId argId, PreparedStatement argStatement) throws SQLException {
/* 265 */     DocumentDefinitionId id = (DocumentDefinitionId)argId;
/* 266 */     argStatement.setString(1, id.getSeriesId());
/* 267 */     argStatement.setLong(2, id.getOrganizationId().longValue());
/* 268 */     argStatement.setString(3, id.getDocumentType());
/* 269 */     return argStatement;
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 273 */     DocumentDefinitionId id = new DocumentDefinitionId();
/* 274 */     id.setSeriesId(this._seriesId);
/* 275 */     id.setOrganizationId(this._organizationId);
/* 276 */     id.setDocumentType(this._documentType);
/* 277 */     return (IObjectId)id;
/*     */   }
/*     */ 
/*     */   
/*     */   public void fill(IJDBCTableAdapter argAdapter) {}
/*     */ 
/*     */   
/*     */   public boolean isExtensible() {
/* 285 */     return false;
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 289 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\doc\impl\DocumentDefinitionDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */