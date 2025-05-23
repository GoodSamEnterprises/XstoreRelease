/*     */ package dtv.xst.dao.inv.impl;
/*     */ 
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.impl.jdbc.IFiller;
/*     */ import dtv.data2.access.impl.jdbc.IJDBCTableAdapter;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.inv.DocumentLineItemNotePropertyId;
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
/*     */ public class DocumentLineItemNotePropertyDBA
/*     */   implements IJDBCTableAdapter
/*     */ {
/*     */   private static final long serialVersionUID = 83145865L;
/*     */   private Long _organizationId;
/*     */   private Long _retailLocationId;
/*     */   private String _documentId;
/*     */   private String _documentTypeCode;
/*     */   private Integer _inventoryDocumentLineNumber;
/*     */   private Long _noteId;
/*     */   private String _propertyCode;
/*     */   private String _type;
/*     */   private String _stringValue;
/*     */   private Date _dateValue;
/*     */   private BigDecimal _decimalValue;
/*     */   private Date _createDate;
/*     */   private String _createUserId;
/*     */   private Date _updateDate;
/*     */   private String _updateUserId;
/*     */   private static final String SELECT_OBJECT = "SELECT t.organization_id, t.rtl_loc_id, t.invctl_document_id, t.document_typcode, t.invctl_document_line_nbr, t.note_id, t.property_code, t.type, t.string_value, t.date_value, t.decimal_value, t.create_date, t.create_user_id, t.update_date, t.update_user_id FROM inv_document_lineitm_note_p t";
/*     */   private static final String SELECT_WHERE_OBJECT = " WHERE organization_id = ?  AND rtl_loc_id = ?  AND invctl_document_id = ?  AND document_typcode = ?  AND invctl_document_line_nbr = ?  AND note_id = ?  AND property_code = ?  ";
/*     */   
/*     */   public String getSelect() {
/*  44 */     return getSelectImpl();
/*     */   }
/*     */   
/*     */   private String getSelectImpl() {
/*  48 */     return "SELECT t.organization_id, t.rtl_loc_id, t.invctl_document_id, t.document_typcode, t.invctl_document_line_nbr, t.note_id, t.property_code, t.type, t.string_value, t.date_value, t.decimal_value, t.create_date, t.create_user_id, t.update_date, t.update_user_id FROM inv_document_lineitm_note_p t";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectWhere() {
/*  54 */     return " WHERE organization_id = ?  AND rtl_loc_id = ?  AND invctl_document_id = ?  AND document_typcode = ?  AND invctl_document_line_nbr = ?  AND note_id = ?  AND property_code = ?  ";
/*     */   }
/*     */   
/*  57 */   private static final String[] INSERT_OBJECT = new String[] { "INSERT INTO inv_document_lineitm_note_p(organization_id, rtl_loc_id, invctl_document_id, document_typcode, invctl_document_line_nbr, note_id, property_code, type, string_value, date_value, decimal_value, create_date, create_user_id, update_date, update_user_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" };
/*     */   
/*     */   public String[] getInsert() {
/*  60 */     return INSERT_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getInsertParameters() {
/*  64 */     Object[][] insertParameterObject = { { this._organizationId, this._retailLocationId, this._documentId, this._documentTypeCode, this._inventoryDocumentLineNumber, this._noteId, this._propertyCode, this._type, this._stringValue, this._dateValue, this._decimalValue, this._createDate, this._createUserId, this._updateDate, this._updateUserId } };
/*  65 */     return insertParameterObject;
/*     */   }
/*     */   
/*  68 */   private static final int[][] INSERT_PARAMETER_TYPES_OBJECT = new int[][] { { -5, -5, 12, 12, 4, -5, 12, 12, 12, 91, 3, 91, 12, 91, 12 } };
/*     */   
/*     */   public int[][] getInsertParameterTypes() {
/*  71 */     return INSERT_PARAMETER_TYPES_OBJECT;
/*     */   }
/*     */   
/*  74 */   private static final String[] UPDATE_OBJECT = new String[] { "UPDATE inv_document_lineitm_note_p SET type = ?, string_value = ?, date_value = ?, decimal_value = ?, update_date = ?, update_user_id = ?" };
/*     */   
/*     */   public String[] getUpdate() {
/*  77 */     return UPDATE_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getUpdateParameters() {
/*  81 */     Object[][] updateParameterObject = { { this._type, this._stringValue, this._dateValue, this._decimalValue, this._updateDate, this._updateUserId } };
/*  82 */     return updateParameterObject;
/*     */   }
/*     */   
/*  85 */   private static final int[][] UPDATE_PARAMETER_TYPE_OBJECT = new int[][] { { 12, 12, 91, 3, 91, 12 } };
/*     */   public int[][] getUpdateParameterTypes() {
/*  87 */     return UPDATE_PARAMETER_TYPE_OBJECT;
/*     */   }
/*     */   
/*  90 */   private static final String[] DELETE_OBJECT = new String[] { "DELETE FROM inv_document_lineitm_note_p" }; private static final String WHERE_OBJECT = " WHERE organization_id = ?  AND rtl_loc_id = ?  AND invctl_document_id = ?  AND document_typcode = ?  AND invctl_document_line_nbr = ?  AND note_id = ?  AND property_code = ?  ";
/*     */   
/*     */   public String[] getDelete() {
/*  93 */     return DELETE_OBJECT;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWhere() {
/*  99 */     return " WHERE organization_id = ?  AND rtl_loc_id = ?  AND invctl_document_id = ?  AND document_typcode = ?  AND invctl_document_line_nbr = ?  AND note_id = ?  AND property_code = ?  ";
/*     */   }
/*     */   public Object[] getWhereParameters() {
/* 102 */     return new Object[] { this._organizationId, this._retailLocationId, this._documentId, this._documentTypeCode, this._inventoryDocumentLineNumber, this._noteId, this._propertyCode };
/*     */   }
/*     */   
/* 105 */   private static final int[] WHERE_PARAMETER_OBJECT = new int[] { -5, -5, 12, 12, 4, -5, 12 };
/*     */   
/*     */   public int[] getWhereParameterTypes() {
/* 108 */     return WHERE_PARAMETER_OBJECT;
/*     */   }
/*     */   public String getTableName() {
/* 111 */     return "inv_document_lineitm_note_p";
/*     */   }
/*     */   
/*     */   public IFiller getFiller() {
/* 115 */     return getFillerImpl();
/*     */   }
/*     */   
/*     */   private IFiller getFillerImpl() {
/* 119 */     return new DocumentLineItemNotePropertyFiller(this);
/*     */   }
/*     */   
/*     */   private static class DocumentLineItemNotePropertyFiller
/*     */     implements IFiller {
/*     */     private DocumentLineItemNotePropertyDBA _parent;
/*     */     
/*     */     public DocumentLineItemNotePropertyFiller(DocumentLineItemNotePropertyDBA argParent) {
/* 127 */       this._parent = argParent;
/*     */     }
/*     */ 
/*     */     
/*     */     public void fill(ResultSet argResultSet) throws SQLException {
/* 132 */       long l1 = argResultSet.getLong(1);
/* 133 */       if (l1 != 0L || argResultSet.getObject(1) != null) {
/* 134 */         this._parent._organizationId = Long.valueOf(l1);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 140 */       l1 = argResultSet.getLong(2);
/* 141 */       if (l1 != 0L || argResultSet.getObject(2) != null) {
/* 142 */         this._parent._retailLocationId = Long.valueOf(l1);
/*     */       }
/*     */ 
/*     */       
/* 146 */       this._parent._documentId = argResultSet.getString(3);
/* 147 */       this._parent._documentTypeCode = argResultSet.getString(4);
/*     */ 
/*     */       
/* 150 */       int i = argResultSet.getInt(5);
/* 151 */       if (i != 0 || argResultSet.getObject(5) != null) {
/* 152 */         this._parent._inventoryDocumentLineNumber = Integer.valueOf(i);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 158 */       long primitiveResult = argResultSet.getLong(6);
/* 159 */       if (primitiveResult != 0L || argResultSet.getObject(6) != null) {
/* 160 */         this._parent._noteId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */       
/* 164 */       this._parent._propertyCode = argResultSet.getString(7);
/* 165 */       this._parent._type = argResultSet.getString(8);
/* 166 */       this._parent._stringValue = argResultSet.getString(9);
/*     */       
/* 168 */       Timestamp t10 = argResultSet.getTimestamp(10);
/* 169 */       if (t10 != null) {
/* 170 */         this._parent._dateValue = (Date)new DtvDate(t10.getTime());
/*     */       } else {
/*     */         
/* 173 */         this._parent._dateValue = null;
/*     */       } 
/*     */       
/* 176 */       this._parent._decimalValue = argResultSet.getBigDecimal(11);
/*     */       
/* 178 */       Timestamp t12 = argResultSet.getTimestamp(12);
/* 179 */       if (t12 != null) {
/* 180 */         this._parent._createDate = (Date)new DtvDate(t12.getTime());
/*     */       } else {
/*     */         
/* 183 */         this._parent._createDate = null;
/*     */       } 
/*     */       
/* 186 */       this._parent._createUserId = argResultSet.getString(13);
/*     */       
/* 188 */       Timestamp t14 = argResultSet.getTimestamp(14);
/* 189 */       if (t14 != null) {
/* 190 */         this._parent._updateDate = (Date)new DtvDate(t14.getTime());
/*     */       } else {
/*     */         
/* 193 */         this._parent._updateDate = null;
/*     */       } 
/*     */       
/* 196 */       this._parent._updateUserId = argResultSet.getString(15);
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDAO(IDataAccessObject argDAO) {
/* 201 */     argDAO.suppressStateChanges(true);
/* 202 */     DocumentLineItemNotePropertyDAO dao = (DocumentLineItemNotePropertyDAO)argDAO;
/* 203 */     dao.setOrganizationId(this._organizationId);
/* 204 */     dao.setRetailLocationId(this._retailLocationId);
/* 205 */     dao.setDocumentId(this._documentId);
/* 206 */     dao.setDocumentTypeCode(this._documentTypeCode);
/* 207 */     dao.setInventoryDocumentLineNumber(this._inventoryDocumentLineNumber);
/* 208 */     dao.setNoteId(this._noteId);
/* 209 */     dao.setPropertyCode(this._propertyCode);
/* 210 */     dao.setType(this._type);
/* 211 */     dao.setStringValue(this._stringValue);
/* 212 */     dao.setDateValue(this._dateValue);
/* 213 */     dao.setDecimalValue(this._decimalValue);
/* 214 */     dao.setCreateDate(this._createDate);
/* 215 */     dao.setCreateUserId(this._createUserId);
/* 216 */     dao.setUpdateDate(this._updateDate);
/* 217 */     dao.setUpdateUserId(this._updateUserId);
/* 218 */     argDAO.suppressStateChanges(false);
/* 219 */     return (IDataAccessObject)dao;
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDefaultDAO() {
/* 223 */     return loadDAO((IDataAccessObject)new DocumentLineItemNotePropertyDAO());
/*     */   }
/*     */   
/*     */   public void fill(IDataAccessObject argDAO) {
/* 227 */     DocumentLineItemNotePropertyDAO dao = (DocumentLineItemNotePropertyDAO)argDAO;
/* 228 */     this._organizationId = dao.getOrganizationId();
/* 229 */     this._retailLocationId = dao.getRetailLocationId();
/* 230 */     this._documentId = dao.getDocumentId();
/* 231 */     this._documentTypeCode = dao.getDocumentTypeCode();
/* 232 */     this._inventoryDocumentLineNumber = dao.getInventoryDocumentLineNumber();
/* 233 */     this._noteId = dao.getNoteId();
/* 234 */     this._propertyCode = dao.getPropertyCode();
/* 235 */     this._type = dao.getType();
/* 236 */     this._stringValue = dao.getStringValue();
/* 237 */     this._dateValue = dao.getDateValue();
/* 238 */     this._decimalValue = dao.getDecimalValue();
/* 239 */     this._createDate = dao.getCreateDate();
/* 240 */     this._createUserId = dao.getCreateUserId();
/* 241 */     this._updateDate = dao.getUpdateDate();
/* 242 */     this._updateUserId = dao.getUpdateUserId();
/*     */   }
/*     */   
/*     */   public PreparedStatement writeObjectId(IObjectId argId, PreparedStatement argStatement) throws SQLException {
/* 246 */     DocumentLineItemNotePropertyId id = (DocumentLineItemNotePropertyId)argId;
/* 247 */     argStatement.setLong(1, id.getOrganizationId().longValue());
/* 248 */     argStatement.setLong(2, id.getRetailLocationId().longValue());
/* 249 */     argStatement.setString(3, id.getDocumentId());
/* 250 */     argStatement.setString(4, id.getDocumentTypeCode());
/* 251 */     argStatement.setInt(5, id.getInventoryDocumentLineNumber().intValue());
/* 252 */     argStatement.setLong(6, id.getNoteId().longValue());
/* 253 */     argStatement.setString(7, id.getPropertyCode());
/* 254 */     return argStatement;
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 258 */     DocumentLineItemNotePropertyId id = new DocumentLineItemNotePropertyId();
/* 259 */     id.setOrganizationId(this._organizationId);
/* 260 */     id.setRetailLocationId(this._retailLocationId);
/* 261 */     id.setDocumentId(this._documentId);
/* 262 */     id.setDocumentTypeCode(this._documentTypeCode);
/* 263 */     id.setInventoryDocumentLineNumber(this._inventoryDocumentLineNumber);
/* 264 */     id.setNoteId(this._noteId);
/* 265 */     id.setPropertyCode(this._propertyCode);
/* 266 */     return (IObjectId)id;
/*     */   }
/*     */ 
/*     */   
/*     */   public void fill(IJDBCTableAdapter argAdapter) {}
/*     */ 
/*     */   
/*     */   public boolean isExtensible() {
/* 274 */     return false;
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 278 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\inv\impl\DocumentLineItemNotePropertyDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */