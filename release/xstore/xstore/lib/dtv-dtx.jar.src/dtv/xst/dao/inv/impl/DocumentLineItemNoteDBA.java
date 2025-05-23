/*     */ package dtv.xst.dao.inv.impl;
/*     */ 
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.impl.jdbc.IFiller;
/*     */ import dtv.data2.access.impl.jdbc.IJDBCTableAdapter;
/*     */ import dtv.data2.access.impl.jdbc.JDBCHelper;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.inv.DocumentLineItemNoteId;
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
/*     */ public class DocumentLineItemNoteDBA
/*     */   implements IJDBCTableAdapter
/*     */ {
/*     */   private static final long serialVersionUID = 1348617876L;
/*     */   private Long _organizationId;
/*     */   private Long _retailLocationId;
/*     */   private String _documentId;
/*     */   private String _documentTypeCode;
/*     */   private Integer _inventoryDocumentLineNumber;
/*     */   private Long _noteId;
/*     */   private Date _createDate;
/*     */   private String _createUserId;
/*     */   private Date _updateDate;
/*     */   private String _updateUserId;
/*     */   private Date _noteDatetimestamp;
/*     */   private String _note;
/*     */   private Long _creatorPartyId;
/*     */   private String _noteType;
/*     */   private String _recordCreationType;
/*     */   private static final String SELECT_OBJECT = "SELECT t.organization_id, t.rtl_loc_id, t.invctl_document_id, t.document_typcode, t.invctl_document_line_nbr, t.note_id, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.note_timestamp, t.note_text, t.creator_party_id , t.note_type, t.record_creation_type FROM inv_document_lineitm_note t";
/*     */   private static final String SELECT_WHERE_OBJECT = " WHERE organization_id = ?  AND rtl_loc_id = ?  AND invctl_document_id = ?  AND document_typcode = ?  AND invctl_document_line_nbr = ?  AND note_id = ?  ";
/*     */   
/*     */   public String getSelect() {
/*  44 */     return getSelectImpl();
/*     */   }
/*     */   
/*     */   private String getSelectImpl() {
/*  48 */     return "SELECT t.organization_id, t.rtl_loc_id, t.invctl_document_id, t.document_typcode, t.invctl_document_line_nbr, t.note_id, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.note_timestamp, t.note_text, t.creator_party_id , t.note_type, t.record_creation_type FROM inv_document_lineitm_note t";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectWhere() {
/*  54 */     return " WHERE organization_id = ?  AND rtl_loc_id = ?  AND invctl_document_id = ?  AND document_typcode = ?  AND invctl_document_line_nbr = ?  AND note_id = ?  ";
/*     */   }
/*     */   
/*  57 */   private static final String[] INSERT_OBJECT = new String[] { "INSERT INTO inv_document_lineitm_note(organization_id, rtl_loc_id, invctl_document_id, document_typcode, invctl_document_line_nbr, note_id, create_date, create_user_id, update_date, update_user_id, note_timestamp, note_text, creator_party_id , note_type, record_creation_type) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" };
/*     */   
/*     */   public String[] getInsert() {
/*  60 */     return INSERT_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getInsertParameters() {
/*  64 */     Object[][] insertParameterObject = { { this._organizationId, this._retailLocationId, this._documentId, this._documentTypeCode, this._inventoryDocumentLineNumber, this._noteId, this._createDate, this._createUserId, this._updateDate, this._updateUserId, this._noteDatetimestamp, this._note, this._creatorPartyId, this._noteType, this._recordCreationType } };
/*  65 */     return insertParameterObject;
/*     */   }
/*     */   
/*  68 */   private static final int[][] INSERT_PARAMETER_TYPES_OBJECT = new int[][] { { -5, -5, 12, 12, 4, -5, 91, 12, 91, 12, 91, 2005, -5, 12, 12 } };
/*     */   
/*     */   public int[][] getInsertParameterTypes() {
/*  71 */     return INSERT_PARAMETER_TYPES_OBJECT;
/*     */   }
/*     */   
/*  74 */   private static final String[] UPDATE_OBJECT = new String[] { "UPDATE inv_document_lineitm_note SET update_date = ?, update_user_id = ?, note_timestamp = ?, note_text = ?, creator_party_id  = ?, note_type = ?, record_creation_type = ?" };
/*     */   
/*     */   public String[] getUpdate() {
/*  77 */     return UPDATE_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getUpdateParameters() {
/*  81 */     Object[][] updateParameterObject = { { this._updateDate, this._updateUserId, this._noteDatetimestamp, this._note, this._creatorPartyId, this._noteType, this._recordCreationType } };
/*  82 */     return updateParameterObject;
/*     */   }
/*     */   
/*  85 */   private static final int[][] UPDATE_PARAMETER_TYPE_OBJECT = new int[][] { { 91, 12, 91, 2005, -5, 12, 12 } };
/*     */   public int[][] getUpdateParameterTypes() {
/*  87 */     return UPDATE_PARAMETER_TYPE_OBJECT;
/*     */   }
/*     */   
/*  90 */   private static final String[] DELETE_OBJECT = new String[] { "DELETE FROM inv_document_lineitm_note" }; private static final String WHERE_OBJECT = " WHERE organization_id = ?  AND rtl_loc_id = ?  AND invctl_document_id = ?  AND document_typcode = ?  AND invctl_document_line_nbr = ?  AND note_id = ?  ";
/*     */   
/*     */   public String[] getDelete() {
/*  93 */     return DELETE_OBJECT;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWhere() {
/*  99 */     return " WHERE organization_id = ?  AND rtl_loc_id = ?  AND invctl_document_id = ?  AND document_typcode = ?  AND invctl_document_line_nbr = ?  AND note_id = ?  ";
/*     */   }
/*     */   public Object[] getWhereParameters() {
/* 102 */     return new Object[] { this._organizationId, this._retailLocationId, this._documentId, this._documentTypeCode, this._inventoryDocumentLineNumber, this._noteId };
/*     */   }
/*     */   
/* 105 */   private static final int[] WHERE_PARAMETER_OBJECT = new int[] { -5, -5, 12, 12, 4, -5 };
/*     */   
/*     */   public int[] getWhereParameterTypes() {
/* 108 */     return WHERE_PARAMETER_OBJECT;
/*     */   }
/*     */   public String getTableName() {
/* 111 */     return "inv_document_lineitm_note";
/*     */   }
/*     */   
/*     */   public IFiller getFiller() {
/* 115 */     return getFillerImpl();
/*     */   }
/*     */   
/*     */   private IFiller getFillerImpl() {
/* 119 */     return new DocumentLineItemNoteFiller(this);
/*     */   }
/*     */   
/*     */   private static class DocumentLineItemNoteFiller
/*     */     implements IFiller {
/*     */     private DocumentLineItemNoteDBA _parent;
/*     */     
/*     */     public DocumentLineItemNoteFiller(DocumentLineItemNoteDBA argParent) {
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
/*     */       
/* 165 */       Timestamp t7 = argResultSet.getTimestamp(7);
/* 166 */       if (t7 != null) {
/* 167 */         this._parent._createDate = (Date)new DtvDate(t7.getTime());
/*     */       } else {
/*     */         
/* 170 */         this._parent._createDate = null;
/*     */       } 
/*     */       
/* 173 */       this._parent._createUserId = argResultSet.getString(8);
/*     */       
/* 175 */       Timestamp t9 = argResultSet.getTimestamp(9);
/* 176 */       if (t9 != null) {
/* 177 */         this._parent._updateDate = (Date)new DtvDate(t9.getTime());
/*     */       } else {
/*     */         
/* 180 */         this._parent._updateDate = null;
/*     */       } 
/*     */       
/* 183 */       this._parent._updateUserId = argResultSet.getString(10);
/*     */       
/* 185 */       Timestamp t11 = argResultSet.getTimestamp(11);
/* 186 */       if (t11 != null) {
/* 187 */         this._parent._noteDatetimestamp = (Date)new DtvDate(t11.getTime());
/*     */       } else {
/*     */         
/* 190 */         this._parent._noteDatetimestamp = null;
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/* 195 */       this._parent._note = JDBCHelper.clobToString(argResultSet, 12);
/*     */ 
/*     */ 
/*     */       
/* 199 */       long l2 = argResultSet.getLong(13);
/* 200 */       if (l2 != 0L || argResultSet.getObject(13) != null) {
/* 201 */         this._parent._creatorPartyId = Long.valueOf(l2);
/*     */       }
/*     */ 
/*     */       
/* 205 */       this._parent._noteType = argResultSet.getString(14);
/* 206 */       this._parent._recordCreationType = argResultSet.getString(15);
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDAO(IDataAccessObject argDAO) {
/* 211 */     argDAO.suppressStateChanges(true);
/* 212 */     DocumentLineItemNoteDAO dao = (DocumentLineItemNoteDAO)argDAO;
/* 213 */     dao.setOrganizationId(this._organizationId);
/* 214 */     dao.setRetailLocationId(this._retailLocationId);
/* 215 */     dao.setDocumentId(this._documentId);
/* 216 */     dao.setDocumentTypeCode(this._documentTypeCode);
/* 217 */     dao.setInventoryDocumentLineNumber(this._inventoryDocumentLineNumber);
/* 218 */     dao.setNoteId(this._noteId);
/* 219 */     dao.setCreateDate(this._createDate);
/* 220 */     dao.setCreateUserId(this._createUserId);
/* 221 */     dao.setUpdateDate(this._updateDate);
/* 222 */     dao.setUpdateUserId(this._updateUserId);
/* 223 */     dao.setNoteDatetimestamp(this._noteDatetimestamp);
/* 224 */     dao.setNote(this._note);
/* 225 */     dao.setCreatorPartyId(this._creatorPartyId);
/* 226 */     dao.setNoteType(this._noteType);
/* 227 */     dao.setRecordCreationType(this._recordCreationType);
/* 228 */     argDAO.suppressStateChanges(false);
/* 229 */     return (IDataAccessObject)dao;
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDefaultDAO() {
/* 233 */     return loadDAO((IDataAccessObject)new DocumentLineItemNoteDAO());
/*     */   }
/*     */   
/*     */   public void fill(IDataAccessObject argDAO) {
/* 237 */     DocumentLineItemNoteDAO dao = (DocumentLineItemNoteDAO)argDAO;
/* 238 */     this._organizationId = dao.getOrganizationId();
/* 239 */     this._retailLocationId = dao.getRetailLocationId();
/* 240 */     this._documentId = dao.getDocumentId();
/* 241 */     this._documentTypeCode = dao.getDocumentTypeCode();
/* 242 */     this._inventoryDocumentLineNumber = dao.getInventoryDocumentLineNumber();
/* 243 */     this._noteId = dao.getNoteId();
/* 244 */     this._createDate = dao.getCreateDate();
/* 245 */     this._createUserId = dao.getCreateUserId();
/* 246 */     this._updateDate = dao.getUpdateDate();
/* 247 */     this._updateUserId = dao.getUpdateUserId();
/* 248 */     this._noteDatetimestamp = dao.getNoteDatetimestamp();
/* 249 */     this._note = dao.getNote();
/* 250 */     this._creatorPartyId = dao.getCreatorPartyId();
/* 251 */     this._noteType = dao.getNoteType();
/* 252 */     this._recordCreationType = dao.getRecordCreationType();
/*     */   }
/*     */   
/*     */   public PreparedStatement writeObjectId(IObjectId argId, PreparedStatement argStatement) throws SQLException {
/* 256 */     DocumentLineItemNoteId id = (DocumentLineItemNoteId)argId;
/* 257 */     argStatement.setLong(1, id.getOrganizationId().longValue());
/* 258 */     argStatement.setLong(2, id.getRetailLocationId().longValue());
/* 259 */     argStatement.setString(3, id.getDocumentId());
/* 260 */     argStatement.setString(4, id.getDocumentTypeCode());
/* 261 */     argStatement.setInt(5, id.getInventoryDocumentLineNumber().intValue());
/* 262 */     argStatement.setLong(6, id.getNoteId().longValue());
/* 263 */     return argStatement;
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 267 */     DocumentLineItemNoteId id = new DocumentLineItemNoteId();
/* 268 */     id.setOrganizationId(this._organizationId);
/* 269 */     id.setRetailLocationId(this._retailLocationId);
/* 270 */     id.setDocumentId(this._documentId);
/* 271 */     id.setDocumentTypeCode(this._documentTypeCode);
/* 272 */     id.setInventoryDocumentLineNumber(this._inventoryDocumentLineNumber);
/* 273 */     id.setNoteId(this._noteId);
/* 274 */     return (IObjectId)id;
/*     */   }
/*     */ 
/*     */   
/*     */   public void fill(IJDBCTableAdapter argAdapter) {}
/*     */ 
/*     */   
/*     */   public boolean isExtensible() {
/* 282 */     return false;
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 286 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\inv\impl\DocumentLineItemNoteDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */