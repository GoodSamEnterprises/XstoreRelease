/*     */ package dtv.xst.dao.inv.impl;
/*     */ 
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.impl.jdbc.IFiller;
/*     */ import dtv.data2.access.impl.jdbc.IJDBCTableAdapter;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.inv.InventoryDocumentId;
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
/*     */ public class InventoryDocumentDBA
/*     */   implements IJDBCTableAdapter
/*     */ {
/*     */   private static final long serialVersionUID = 284848759L;
/*     */   private String _documentId;
/*     */   private String _documentTypeCode;
/*     */   private Long _organizationId;
/*     */   private Long _retailLocationId;
/*     */   private Date _createDate;
/*     */   private String _createUserId;
/*     */   private Date _updateDate;
/*     */   private String _updateUserId;
/*     */   private Date _completeDateTime;
/*     */   private Date _createDateTime;
/*     */   private String _originatorId;
/*     */   private String _statusCode;
/*     */   private String _documentSubtypeCode;
/*     */   private String _originatorName;
/*     */   private Date _lastActivityDate;
/*     */   private String _poReferenceNumber;
/*     */   private String _recordCreationType;
/*     */   private String _description;
/*     */   private String _controlNumber;
/*     */   private String _originatorAddressId;
/*     */   private Date _submitDate;
/*     */   private static final String SELECT_OBJECT = "SELECT t.invctl_document_id, t.document_typcode, t.organization_id, t.rtl_loc_id, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.complete_date_timestamp, t.create_date_timestamp, t.originator_id, t.status_code, t.document_subtypcode, t.originator_name, t.last_activity_date, t.po_ref_nbr, t.record_creation_type, t.description, t.control_number, t.originator_address_id, t.submit_date FROM inv_invctl_document t";
/*     */   private static final String SELECT_WHERE_OBJECT = " WHERE invctl_document_id = ?  AND document_typcode = ?  AND organization_id = ?  AND rtl_loc_id = ?  ";
/*     */   
/*     */   public String getSelect() {
/*  50 */     return getSelectImpl();
/*     */   }
/*     */   
/*     */   private String getSelectImpl() {
/*  54 */     return "SELECT t.invctl_document_id, t.document_typcode, t.organization_id, t.rtl_loc_id, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.complete_date_timestamp, t.create_date_timestamp, t.originator_id, t.status_code, t.document_subtypcode, t.originator_name, t.last_activity_date, t.po_ref_nbr, t.record_creation_type, t.description, t.control_number, t.originator_address_id, t.submit_date FROM inv_invctl_document t";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectWhere() {
/*  60 */     return " WHERE invctl_document_id = ?  AND document_typcode = ?  AND organization_id = ?  AND rtl_loc_id = ?  ";
/*     */   }
/*     */   
/*  63 */   private static final String[] INSERT_OBJECT = new String[] { "INSERT INTO inv_invctl_document(invctl_document_id, document_typcode, organization_id, rtl_loc_id, create_date, create_user_id, update_date, update_user_id, complete_date_timestamp, create_date_timestamp, originator_id, status_code, document_subtypcode, originator_name, last_activity_date, po_ref_nbr, record_creation_type, description, control_number, originator_address_id, submit_date) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" };
/*     */   
/*     */   public String[] getInsert() {
/*  66 */     return INSERT_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getInsertParameters() {
/*  70 */     Object[][] insertParameterObject = { { this._documentId, this._documentTypeCode, this._organizationId, this._retailLocationId, this._createDate, this._createUserId, this._updateDate, this._updateUserId, this._completeDateTime, this._createDateTime, this._originatorId, this._statusCode, this._documentSubtypeCode, this._originatorName, this._lastActivityDate, this._poReferenceNumber, this._recordCreationType, this._description, this._controlNumber, this._originatorAddressId, this._submitDate } };
/*  71 */     return insertParameterObject;
/*     */   }
/*     */   
/*  74 */   private static final int[][] INSERT_PARAMETER_TYPES_OBJECT = new int[][] { { 12, 12, -5, -5, 91, 12, 91, 12, 91, 91, 12, 12, 12, 12, 91, 12, 12, 12, 12, 12, 91 } };
/*     */   
/*     */   public int[][] getInsertParameterTypes() {
/*  77 */     return INSERT_PARAMETER_TYPES_OBJECT;
/*     */   }
/*     */   
/*  80 */   private static final String[] UPDATE_OBJECT = new String[] { "UPDATE inv_invctl_document SET update_date = ?, update_user_id = ?, complete_date_timestamp = ?, create_date_timestamp = ?, originator_id = ?, status_code = ?, document_subtypcode = ?, originator_name = ?, last_activity_date = ?, po_ref_nbr = ?, record_creation_type = ?, description = ?, control_number = ?, originator_address_id = ?, submit_date = ?" };
/*     */   
/*     */   public String[] getUpdate() {
/*  83 */     return UPDATE_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getUpdateParameters() {
/*  87 */     Object[][] updateParameterObject = { { this._updateDate, this._updateUserId, this._completeDateTime, this._createDateTime, this._originatorId, this._statusCode, this._documentSubtypeCode, this._originatorName, this._lastActivityDate, this._poReferenceNumber, this._recordCreationType, this._description, this._controlNumber, this._originatorAddressId, this._submitDate } };
/*  88 */     return updateParameterObject;
/*     */   }
/*     */   
/*  91 */   private static final int[][] UPDATE_PARAMETER_TYPE_OBJECT = new int[][] { { 91, 12, 91, 91, 12, 12, 12, 12, 91, 12, 12, 12, 12, 12, 91 } };
/*     */   public int[][] getUpdateParameterTypes() {
/*  93 */     return UPDATE_PARAMETER_TYPE_OBJECT;
/*     */   }
/*     */   
/*  96 */   private static final String[] DELETE_OBJECT = new String[] { "DELETE FROM inv_invctl_document" }; private static final String WHERE_OBJECT = " WHERE invctl_document_id = ?  AND document_typcode = ?  AND organization_id = ?  AND rtl_loc_id = ?  ";
/*     */   
/*     */   public String[] getDelete() {
/*  99 */     return DELETE_OBJECT;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWhere() {
/* 105 */     return " WHERE invctl_document_id = ?  AND document_typcode = ?  AND organization_id = ?  AND rtl_loc_id = ?  ";
/*     */   }
/*     */   public Object[] getWhereParameters() {
/* 108 */     return new Object[] { this._documentId, this._documentTypeCode, this._organizationId, this._retailLocationId };
/*     */   }
/*     */   
/* 111 */   private static final int[] WHERE_PARAMETER_OBJECT = new int[] { 12, 12, -5, -5 };
/*     */   
/*     */   public int[] getWhereParameterTypes() {
/* 114 */     return WHERE_PARAMETER_OBJECT;
/*     */   }
/*     */   public String getTableName() {
/* 117 */     return "inv_invctl_document";
/*     */   }
/*     */   
/*     */   public IFiller getFiller() {
/* 121 */     return getFillerImpl();
/*     */   }
/*     */   
/*     */   private IFiller getFillerImpl() {
/* 125 */     return new InventoryDocumentFiller(this);
/*     */   }
/*     */   
/*     */   private static class InventoryDocumentFiller
/*     */     implements IFiller {
/*     */     private InventoryDocumentDBA _parent;
/*     */     
/*     */     public InventoryDocumentFiller(InventoryDocumentDBA argParent) {
/* 133 */       this._parent = argParent;
/*     */     }
/*     */     public void fill(ResultSet argResultSet) throws SQLException {
/* 136 */       this._parent._documentId = argResultSet.getString(1);
/* 137 */       this._parent._documentTypeCode = argResultSet.getString(2);
/*     */ 
/*     */       
/* 140 */       long primitiveResult = argResultSet.getLong(3);
/* 141 */       if (primitiveResult != 0L || argResultSet.getObject(3) != null) {
/* 142 */         this._parent._organizationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 148 */       primitiveResult = argResultSet.getLong(4);
/* 149 */       if (primitiveResult != 0L || argResultSet.getObject(4) != null) {
/* 150 */         this._parent._retailLocationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 155 */       Timestamp t5 = argResultSet.getTimestamp(5);
/* 156 */       if (t5 != null) {
/* 157 */         this._parent._createDate = (Date)new DtvDate(t5.getTime());
/*     */       } else {
/*     */         
/* 160 */         this._parent._createDate = null;
/*     */       } 
/*     */       
/* 163 */       this._parent._createUserId = argResultSet.getString(6);
/*     */       
/* 165 */       Timestamp t7 = argResultSet.getTimestamp(7);
/* 166 */       if (t7 != null) {
/* 167 */         this._parent._updateDate = (Date)new DtvDate(t7.getTime());
/*     */       } else {
/*     */         
/* 170 */         this._parent._updateDate = null;
/*     */       } 
/*     */       
/* 173 */       this._parent._updateUserId = argResultSet.getString(8);
/*     */       
/* 175 */       Timestamp t9 = argResultSet.getTimestamp(9);
/* 176 */       if (t9 != null) {
/* 177 */         this._parent._completeDateTime = (Date)new DtvDate(t9.getTime());
/*     */       } else {
/*     */         
/* 180 */         this._parent._completeDateTime = null;
/*     */       } 
/*     */ 
/*     */       
/* 184 */       Timestamp t10 = argResultSet.getTimestamp(10);
/* 185 */       if (t10 != null) {
/* 186 */         this._parent._createDateTime = (Date)new DtvDate(t10.getTime());
/*     */       } else {
/*     */         
/* 189 */         this._parent._createDateTime = null;
/*     */       } 
/*     */       
/* 192 */       this._parent._originatorId = argResultSet.getString(11);
/* 193 */       this._parent._statusCode = argResultSet.getString(12);
/* 194 */       this._parent._documentSubtypeCode = argResultSet.getString(13);
/* 195 */       this._parent._originatorName = argResultSet.getString(14);
/*     */       
/* 197 */       Timestamp t15 = argResultSet.getTimestamp(15);
/* 198 */       if (t15 != null) {
/* 199 */         this._parent._lastActivityDate = (Date)new DtvDate(t15.getTime());
/*     */       } else {
/*     */         
/* 202 */         this._parent._lastActivityDate = null;
/*     */       } 
/*     */       
/* 205 */       this._parent._poReferenceNumber = argResultSet.getString(16);
/* 206 */       this._parent._recordCreationType = argResultSet.getString(17);
/* 207 */       this._parent._description = argResultSet.getString(18);
/* 208 */       this._parent._controlNumber = argResultSet.getString(19);
/* 209 */       this._parent._originatorAddressId = argResultSet.getString(20);
/*     */       
/* 211 */       Timestamp t21 = argResultSet.getTimestamp(21);
/* 212 */       if (t21 != null) {
/* 213 */         this._parent._submitDate = (Date)new DtvDate(t21.getTime());
/*     */       } else {
/*     */         
/* 216 */         this._parent._submitDate = null;
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public IDataAccessObject loadDAO(IDataAccessObject argDAO) {
/* 223 */     argDAO.suppressStateChanges(true);
/* 224 */     InventoryDocumentDAO dao = (InventoryDocumentDAO)argDAO;
/* 225 */     dao.setDocumentId(this._documentId);
/* 226 */     dao.setDocumentTypeCode(this._documentTypeCode);
/* 227 */     dao.setOrganizationId(this._organizationId);
/* 228 */     dao.setRetailLocationId(this._retailLocationId);
/* 229 */     dao.setCreateDate(this._createDate);
/* 230 */     dao.setCreateUserId(this._createUserId);
/* 231 */     dao.setUpdateDate(this._updateDate);
/* 232 */     dao.setUpdateUserId(this._updateUserId);
/* 233 */     dao.setCompleteDateTime(this._completeDateTime);
/* 234 */     dao.setCreateDateTime(this._createDateTime);
/* 235 */     dao.setOriginatorId(this._originatorId);
/* 236 */     dao.setStatusCode(this._statusCode);
/* 237 */     dao.setDocumentSubtypeCode(this._documentSubtypeCode);
/* 238 */     dao.setOriginatorName(this._originatorName);
/* 239 */     dao.setLastActivityDate(this._lastActivityDate);
/* 240 */     dao.setPoReferenceNumber(this._poReferenceNumber);
/* 241 */     dao.setRecordCreationType(this._recordCreationType);
/* 242 */     dao.setDescription(this._description);
/* 243 */     dao.setControlNumber(this._controlNumber);
/* 244 */     dao.setOriginatorAddressId(this._originatorAddressId);
/* 245 */     dao.setSubmitDate(this._submitDate);
/* 246 */     argDAO.suppressStateChanges(false);
/* 247 */     return (IDataAccessObject)dao;
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDefaultDAO() {
/* 251 */     return loadDAO((IDataAccessObject)new InventoryDocumentDAO());
/*     */   }
/*     */   
/*     */   public void fill(IDataAccessObject argDAO) {
/* 255 */     InventoryDocumentDAO dao = (InventoryDocumentDAO)argDAO;
/* 256 */     this._documentId = dao.getDocumentId();
/* 257 */     this._documentTypeCode = dao.getDocumentTypeCode();
/* 258 */     this._organizationId = dao.getOrganizationId();
/* 259 */     this._retailLocationId = dao.getRetailLocationId();
/* 260 */     this._createDate = dao.getCreateDate();
/* 261 */     this._createUserId = dao.getCreateUserId();
/* 262 */     this._updateDate = dao.getUpdateDate();
/* 263 */     this._updateUserId = dao.getUpdateUserId();
/* 264 */     this._completeDateTime = dao.getCompleteDateTime();
/* 265 */     this._createDateTime = dao.getCreateDateTime();
/* 266 */     this._originatorId = dao.getOriginatorId();
/* 267 */     this._statusCode = dao.getStatusCode();
/* 268 */     this._documentSubtypeCode = dao.getDocumentSubtypeCode();
/* 269 */     this._originatorName = dao.getOriginatorName();
/* 270 */     this._lastActivityDate = dao.getLastActivityDate();
/* 271 */     this._poReferenceNumber = dao.getPoReferenceNumber();
/* 272 */     this._recordCreationType = dao.getRecordCreationType();
/* 273 */     this._description = dao.getDescription();
/* 274 */     this._controlNumber = dao.getControlNumber();
/* 275 */     this._originatorAddressId = dao.getOriginatorAddressId();
/* 276 */     this._submitDate = dao.getSubmitDate();
/*     */   }
/*     */   
/*     */   public PreparedStatement writeObjectId(IObjectId argId, PreparedStatement argStatement) throws SQLException {
/* 280 */     InventoryDocumentId id = (InventoryDocumentId)argId;
/* 281 */     argStatement.setString(1, id.getDocumentId());
/* 282 */     argStatement.setString(2, id.getDocumentTypeCode());
/* 283 */     argStatement.setLong(3, id.getOrganizationId().longValue());
/* 284 */     argStatement.setLong(4, id.getRetailLocationId().longValue());
/* 285 */     return argStatement;
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 289 */     InventoryDocumentId id = new InventoryDocumentId();
/* 290 */     id.setDocumentId(this._documentId);
/* 291 */     id.setDocumentTypeCode(this._documentTypeCode);
/* 292 */     id.setOrganizationId(this._organizationId);
/* 293 */     id.setRetailLocationId(this._retailLocationId);
/* 294 */     return (IObjectId)id;
/*     */   }
/*     */ 
/*     */   
/*     */   public void fill(IJDBCTableAdapter argAdapter) {}
/*     */ 
/*     */   
/*     */   public boolean isExtensible() {
/* 302 */     return false;
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 306 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\inv\impl\InventoryDocumentDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */