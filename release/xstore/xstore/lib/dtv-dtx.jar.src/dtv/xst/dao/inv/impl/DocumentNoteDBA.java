/*     */ package dtv.xst.dao.inv.impl;
/*     */ 
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.impl.jdbc.IFiller;
/*     */ import dtv.data2.access.impl.jdbc.IJDBCTableAdapter;
/*     */ import dtv.data2.access.impl.jdbc.JDBCHelper;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.inv.DocumentNoteId;
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
/*     */ public class DocumentNoteDBA
/*     */   implements IJDBCTableAdapter
/*     */ {
/*     */   private static final long serialVersionUID = -1309064243L;
/*     */   private Long _organizationId;
/*     */   private Long _retailLocationId;
/*     */   private String _documentId;
/*     */   private String _documentTypeCode;
/*     */   private Long _noteId;
/*     */   private Date _createDate;
/*     */   private String _createUserId;
/*     */   private Date _updateDate;
/*     */   private String _updateUserId;
/*     */   private Date _noteDatetimestamp;
/*     */   private String _note;
/*     */   private Long _creatorPartyId;
/*     */   private String _noteType;
/*     */   private static final String SELECT_OBJECT = "SELECT t.organization_id, t.rtl_loc_id, t.invctl_document_id, t.document_typcode, t.note_id, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.note_timestamp, t.note_text, t.creator_party_id , t.note_type FROM inv_document_notes t";
/*     */   private static final String SELECT_WHERE_OBJECT = " WHERE organization_id = ?  AND rtl_loc_id = ?  AND invctl_document_id = ?  AND document_typcode = ?  AND note_id = ?  ";
/*     */   
/*     */   public String getSelect() {
/*  42 */     return getSelectImpl();
/*     */   }
/*     */   
/*     */   private String getSelectImpl() {
/*  46 */     return "SELECT t.organization_id, t.rtl_loc_id, t.invctl_document_id, t.document_typcode, t.note_id, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.note_timestamp, t.note_text, t.creator_party_id , t.note_type FROM inv_document_notes t";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectWhere() {
/*  52 */     return " WHERE organization_id = ?  AND rtl_loc_id = ?  AND invctl_document_id = ?  AND document_typcode = ?  AND note_id = ?  ";
/*     */   }
/*     */   
/*  55 */   private static final String[] INSERT_OBJECT = new String[] { "INSERT INTO inv_document_notes(organization_id, rtl_loc_id, invctl_document_id, document_typcode, note_id, create_date, create_user_id, update_date, update_user_id, note_timestamp, note_text, creator_party_id , note_type) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" };
/*     */   
/*     */   public String[] getInsert() {
/*  58 */     return INSERT_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getInsertParameters() {
/*  62 */     Object[][] insertParameterObject = { { this._organizationId, this._retailLocationId, this._documentId, this._documentTypeCode, this._noteId, this._createDate, this._createUserId, this._updateDate, this._updateUserId, this._noteDatetimestamp, this._note, this._creatorPartyId, this._noteType } };
/*  63 */     return insertParameterObject;
/*     */   }
/*     */   
/*  66 */   private static final int[][] INSERT_PARAMETER_TYPES_OBJECT = new int[][] { { -5, -5, 12, 12, -5, 91, 12, 91, 12, 91, 2005, -5, 12 } };
/*     */   
/*     */   public int[][] getInsertParameterTypes() {
/*  69 */     return INSERT_PARAMETER_TYPES_OBJECT;
/*     */   }
/*     */   
/*  72 */   private static final String[] UPDATE_OBJECT = new String[] { "UPDATE inv_document_notes SET update_date = ?, update_user_id = ?, note_timestamp = ?, note_text = ?, creator_party_id  = ?, note_type = ?" };
/*     */   
/*     */   public String[] getUpdate() {
/*  75 */     return UPDATE_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getUpdateParameters() {
/*  79 */     Object[][] updateParameterObject = { { this._updateDate, this._updateUserId, this._noteDatetimestamp, this._note, this._creatorPartyId, this._noteType } };
/*  80 */     return updateParameterObject;
/*     */   }
/*     */   
/*  83 */   private static final int[][] UPDATE_PARAMETER_TYPE_OBJECT = new int[][] { { 91, 12, 91, 2005, -5, 12 } };
/*     */   public int[][] getUpdateParameterTypes() {
/*  85 */     return UPDATE_PARAMETER_TYPE_OBJECT;
/*     */   }
/*     */   
/*  88 */   private static final String[] DELETE_OBJECT = new String[] { "DELETE FROM inv_document_notes" }; private static final String WHERE_OBJECT = " WHERE organization_id = ?  AND rtl_loc_id = ?  AND invctl_document_id = ?  AND document_typcode = ?  AND note_id = ?  ";
/*     */   
/*     */   public String[] getDelete() {
/*  91 */     return DELETE_OBJECT;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWhere() {
/*  97 */     return " WHERE organization_id = ?  AND rtl_loc_id = ?  AND invctl_document_id = ?  AND document_typcode = ?  AND note_id = ?  ";
/*     */   }
/*     */   public Object[] getWhereParameters() {
/* 100 */     return new Object[] { this._organizationId, this._retailLocationId, this._documentId, this._documentTypeCode, this._noteId };
/*     */   }
/*     */   
/* 103 */   private static final int[] WHERE_PARAMETER_OBJECT = new int[] { -5, -5, 12, 12, -5 };
/*     */   
/*     */   public int[] getWhereParameterTypes() {
/* 106 */     return WHERE_PARAMETER_OBJECT;
/*     */   }
/*     */   public String getTableName() {
/* 109 */     return "inv_document_notes";
/*     */   }
/*     */   
/*     */   public IFiller getFiller() {
/* 113 */     return getFillerImpl();
/*     */   }
/*     */   
/*     */   private IFiller getFillerImpl() {
/* 117 */     return new DocumentNoteFiller(this);
/*     */   }
/*     */   
/*     */   private static class DocumentNoteFiller
/*     */     implements IFiller {
/*     */     private DocumentNoteDBA _parent;
/*     */     
/*     */     public DocumentNoteFiller(DocumentNoteDBA argParent) {
/* 125 */       this._parent = argParent;
/*     */     }
/*     */ 
/*     */     
/*     */     public void fill(ResultSet argResultSet) throws SQLException {
/* 130 */       long primitiveResult = argResultSet.getLong(1);
/* 131 */       if (primitiveResult != 0L || argResultSet.getObject(1) != null) {
/* 132 */         this._parent._organizationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 138 */       primitiveResult = argResultSet.getLong(2);
/* 139 */       if (primitiveResult != 0L || argResultSet.getObject(2) != null) {
/* 140 */         this._parent._retailLocationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */       
/* 144 */       this._parent._documentId = argResultSet.getString(3);
/* 145 */       this._parent._documentTypeCode = argResultSet.getString(4);
/*     */ 
/*     */       
/* 148 */       primitiveResult = argResultSet.getLong(5);
/* 149 */       if (primitiveResult != 0L || argResultSet.getObject(5) != null) {
/* 150 */         this._parent._noteId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 155 */       Timestamp t6 = argResultSet.getTimestamp(6);
/* 156 */       if (t6 != null) {
/* 157 */         this._parent._createDate = (Date)new DtvDate(t6.getTime());
/*     */       } else {
/*     */         
/* 160 */         this._parent._createDate = null;
/*     */       } 
/*     */       
/* 163 */       this._parent._createUserId = argResultSet.getString(7);
/*     */       
/* 165 */       Timestamp t8 = argResultSet.getTimestamp(8);
/* 166 */       if (t8 != null) {
/* 167 */         this._parent._updateDate = (Date)new DtvDate(t8.getTime());
/*     */       } else {
/*     */         
/* 170 */         this._parent._updateDate = null;
/*     */       } 
/*     */       
/* 173 */       this._parent._updateUserId = argResultSet.getString(9);
/*     */       
/* 175 */       Timestamp t10 = argResultSet.getTimestamp(10);
/* 176 */       if (t10 != null) {
/* 177 */         this._parent._noteDatetimestamp = (Date)new DtvDate(t10.getTime());
/*     */       } else {
/*     */         
/* 180 */         this._parent._noteDatetimestamp = null;
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/* 185 */       this._parent._note = JDBCHelper.clobToString(argResultSet, 11);
/*     */ 
/*     */ 
/*     */       
/* 189 */       long l1 = argResultSet.getLong(12);
/* 190 */       if (l1 != 0L || argResultSet.getObject(12) != null) {
/* 191 */         this._parent._creatorPartyId = Long.valueOf(l1);
/*     */       }
/*     */ 
/*     */       
/* 195 */       this._parent._noteType = argResultSet.getString(13);
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDAO(IDataAccessObject argDAO) {
/* 200 */     argDAO.suppressStateChanges(true);
/* 201 */     DocumentNoteDAO dao = (DocumentNoteDAO)argDAO;
/* 202 */     dao.setOrganizationId(this._organizationId);
/* 203 */     dao.setRetailLocationId(this._retailLocationId);
/* 204 */     dao.setDocumentId(this._documentId);
/* 205 */     dao.setDocumentTypeCode(this._documentTypeCode);
/* 206 */     dao.setNoteId(this._noteId);
/* 207 */     dao.setCreateDate(this._createDate);
/* 208 */     dao.setCreateUserId(this._createUserId);
/* 209 */     dao.setUpdateDate(this._updateDate);
/* 210 */     dao.setUpdateUserId(this._updateUserId);
/* 211 */     dao.setNoteDatetimestamp(this._noteDatetimestamp);
/* 212 */     dao.setNote(this._note);
/* 213 */     dao.setCreatorPartyId(this._creatorPartyId);
/* 214 */     dao.setNoteType(this._noteType);
/* 215 */     argDAO.suppressStateChanges(false);
/* 216 */     return (IDataAccessObject)dao;
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDefaultDAO() {
/* 220 */     return loadDAO((IDataAccessObject)new DocumentNoteDAO());
/*     */   }
/*     */   
/*     */   public void fill(IDataAccessObject argDAO) {
/* 224 */     DocumentNoteDAO dao = (DocumentNoteDAO)argDAO;
/* 225 */     this._organizationId = dao.getOrganizationId();
/* 226 */     this._retailLocationId = dao.getRetailLocationId();
/* 227 */     this._documentId = dao.getDocumentId();
/* 228 */     this._documentTypeCode = dao.getDocumentTypeCode();
/* 229 */     this._noteId = dao.getNoteId();
/* 230 */     this._createDate = dao.getCreateDate();
/* 231 */     this._createUserId = dao.getCreateUserId();
/* 232 */     this._updateDate = dao.getUpdateDate();
/* 233 */     this._updateUserId = dao.getUpdateUserId();
/* 234 */     this._noteDatetimestamp = dao.getNoteDatetimestamp();
/* 235 */     this._note = dao.getNote();
/* 236 */     this._creatorPartyId = dao.getCreatorPartyId();
/* 237 */     this._noteType = dao.getNoteType();
/*     */   }
/*     */   
/*     */   public PreparedStatement writeObjectId(IObjectId argId, PreparedStatement argStatement) throws SQLException {
/* 241 */     DocumentNoteId id = (DocumentNoteId)argId;
/* 242 */     argStatement.setLong(1, id.getOrganizationId().longValue());
/* 243 */     argStatement.setLong(2, id.getRetailLocationId().longValue());
/* 244 */     argStatement.setString(3, id.getDocumentId());
/* 245 */     argStatement.setString(4, id.getDocumentTypeCode());
/* 246 */     argStatement.setLong(5, id.getNoteId().longValue());
/* 247 */     return argStatement;
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 251 */     DocumentNoteId id = new DocumentNoteId();
/* 252 */     id.setOrganizationId(this._organizationId);
/* 253 */     id.setRetailLocationId(this._retailLocationId);
/* 254 */     id.setDocumentId(this._documentId);
/* 255 */     id.setDocumentTypeCode(this._documentTypeCode);
/* 256 */     id.setNoteId(this._noteId);
/* 257 */     return (IObjectId)id;
/*     */   }
/*     */ 
/*     */   
/*     */   public void fill(IJDBCTableAdapter argAdapter) {}
/*     */ 
/*     */   
/*     */   public boolean isExtensible() {
/* 265 */     return false;
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 269 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\inv\impl\DocumentNoteDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */