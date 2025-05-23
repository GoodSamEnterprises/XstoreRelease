/*     */ package dtv.xst.dao.crm.impl;
/*     */ 
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.impl.jdbc.IFiller;
/*     */ import dtv.data2.access.impl.jdbc.IJDBCTableAdapter;
/*     */ import dtv.data2.access.impl.jdbc.JDBCHelper;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.crm.CustomerNoteId;
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
/*     */ public class CustomerNoteDBA
/*     */   implements IJDBCTableAdapter
/*     */ {
/*     */   private static final long serialVersionUID = 1064491280L;
/*     */   private Long _organizationId;
/*     */   private Long _partyId;
/*     */   private Long _noteSequence;
/*     */   private Date _createDate;
/*     */   private String _createUserId;
/*     */   private Date _updateDate;
/*     */   private String _updateUserId;
/*     */   private String _creatorId;
/*     */   private String _note;
/*     */   private Date _noteTimeStamp;
/*     */   private static final String SELECT_OBJECT = "SELECT t.organization_id, t.party_id, t.note_seq, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.creator_id, t.note, t.note_timestamp FROM crm_customer_notes t";
/*     */   private static final String SELECT_WHERE_OBJECT = " WHERE organization_id = ?  AND party_id = ?  AND note_seq = ?  ";
/*     */   
/*     */   public String getSelect() {
/*  39 */     return getSelectImpl();
/*     */   }
/*     */   
/*     */   private String getSelectImpl() {
/*  43 */     return "SELECT t.organization_id, t.party_id, t.note_seq, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.creator_id, t.note, t.note_timestamp FROM crm_customer_notes t";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectWhere() {
/*  49 */     return " WHERE organization_id = ?  AND party_id = ?  AND note_seq = ?  ";
/*     */   }
/*     */   
/*  52 */   private static final String[] INSERT_OBJECT = new String[] { "INSERT INTO crm_customer_notes(organization_id, party_id, note_seq, create_date, create_user_id, update_date, update_user_id, creator_id, note, note_timestamp) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" };
/*     */   
/*     */   public String[] getInsert() {
/*  55 */     return INSERT_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getInsertParameters() {
/*  59 */     Object[][] insertParameterObject = { { this._organizationId, this._partyId, this._noteSequence, this._createDate, this._createUserId, this._updateDate, this._updateUserId, this._creatorId, this._note, this._noteTimeStamp } };
/*  60 */     return insertParameterObject;
/*     */   }
/*     */   
/*  63 */   private static final int[][] INSERT_PARAMETER_TYPES_OBJECT = new int[][] { { -5, -5, -5, 91, 12, 91, 12, 12, 2005, 91 } };
/*     */   
/*     */   public int[][] getInsertParameterTypes() {
/*  66 */     return INSERT_PARAMETER_TYPES_OBJECT;
/*     */   }
/*     */   
/*  69 */   private static final String[] UPDATE_OBJECT = new String[] { "UPDATE crm_customer_notes SET update_date = ?, update_user_id = ?, creator_id = ?, note = ?, note_timestamp = ?" };
/*     */   
/*     */   public String[] getUpdate() {
/*  72 */     return UPDATE_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getUpdateParameters() {
/*  76 */     Object[][] updateParameterObject = { { this._updateDate, this._updateUserId, this._creatorId, this._note, this._noteTimeStamp } };
/*  77 */     return updateParameterObject;
/*     */   }
/*     */   
/*  80 */   private static final int[][] UPDATE_PARAMETER_TYPE_OBJECT = new int[][] { { 91, 12, 12, 2005, 91 } };
/*     */   public int[][] getUpdateParameterTypes() {
/*  82 */     return UPDATE_PARAMETER_TYPE_OBJECT;
/*     */   }
/*     */   
/*  85 */   private static final String[] DELETE_OBJECT = new String[] { "DELETE FROM crm_customer_notes" }; private static final String WHERE_OBJECT = " WHERE organization_id = ?  AND party_id = ?  AND note_seq = ?  ";
/*     */   
/*     */   public String[] getDelete() {
/*  88 */     return DELETE_OBJECT;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWhere() {
/*  94 */     return " WHERE organization_id = ?  AND party_id = ?  AND note_seq = ?  ";
/*     */   }
/*     */   public Object[] getWhereParameters() {
/*  97 */     return new Object[] { this._organizationId, this._partyId, this._noteSequence };
/*     */   }
/*     */   
/* 100 */   private static final int[] WHERE_PARAMETER_OBJECT = new int[] { -5, -5, -5 };
/*     */   
/*     */   public int[] getWhereParameterTypes() {
/* 103 */     return WHERE_PARAMETER_OBJECT;
/*     */   }
/*     */   public String getTableName() {
/* 106 */     return "crm_customer_notes";
/*     */   }
/*     */   
/*     */   public IFiller getFiller() {
/* 110 */     return getFillerImpl();
/*     */   }
/*     */   
/*     */   private IFiller getFillerImpl() {
/* 114 */     return new CustomerNoteFiller(this);
/*     */   }
/*     */   
/*     */   private static class CustomerNoteFiller
/*     */     implements IFiller {
/*     */     private CustomerNoteDBA _parent;
/*     */     
/*     */     public CustomerNoteFiller(CustomerNoteDBA argParent) {
/* 122 */       this._parent = argParent;
/*     */     }
/*     */ 
/*     */     
/*     */     public void fill(ResultSet argResultSet) throws SQLException {
/* 127 */       long primitiveResult = argResultSet.getLong(1);
/* 128 */       if (primitiveResult != 0L || argResultSet.getObject(1) != null) {
/* 129 */         this._parent._organizationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 135 */       primitiveResult = argResultSet.getLong(2);
/* 136 */       if (primitiveResult != 0L || argResultSet.getObject(2) != null) {
/* 137 */         this._parent._partyId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 143 */       primitiveResult = argResultSet.getLong(3);
/* 144 */       if (primitiveResult != 0L || argResultSet.getObject(3) != null) {
/* 145 */         this._parent._noteSequence = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 150 */       Timestamp t4 = argResultSet.getTimestamp(4);
/* 151 */       if (t4 != null) {
/* 152 */         this._parent._createDate = (Date)new DtvDate(t4.getTime());
/*     */       } else {
/*     */         
/* 155 */         this._parent._createDate = null;
/*     */       } 
/*     */       
/* 158 */       this._parent._createUserId = argResultSet.getString(5);
/*     */       
/* 160 */       Timestamp t6 = argResultSet.getTimestamp(6);
/* 161 */       if (t6 != null) {
/* 162 */         this._parent._updateDate = (Date)new DtvDate(t6.getTime());
/*     */       } else {
/*     */         
/* 165 */         this._parent._updateDate = null;
/*     */       } 
/*     */       
/* 168 */       this._parent._updateUserId = argResultSet.getString(7);
/* 169 */       this._parent._creatorId = argResultSet.getString(8);
/*     */ 
/*     */       
/* 172 */       this._parent._note = JDBCHelper.clobToString(argResultSet, 9);
/*     */ 
/*     */       
/* 175 */       Timestamp t10 = argResultSet.getTimestamp(10);
/* 176 */       if (t10 != null) {
/* 177 */         this._parent._noteTimeStamp = (Date)new DtvDate(t10.getTime());
/*     */       } else {
/*     */         
/* 180 */         this._parent._noteTimeStamp = null;
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public IDataAccessObject loadDAO(IDataAccessObject argDAO) {
/* 187 */     argDAO.suppressStateChanges(true);
/* 188 */     CustomerNoteDAO dao = (CustomerNoteDAO)argDAO;
/* 189 */     dao.setOrganizationId(this._organizationId);
/* 190 */     dao.setPartyId(this._partyId);
/* 191 */     dao.setNoteSequence(this._noteSequence);
/* 192 */     dao.setCreateDate(this._createDate);
/* 193 */     dao.setCreateUserId(this._createUserId);
/* 194 */     dao.setUpdateDate(this._updateDate);
/* 195 */     dao.setUpdateUserId(this._updateUserId);
/* 196 */     dao.setCreatorId(this._creatorId);
/* 197 */     dao.setNote(this._note);
/* 198 */     dao.setNoteTimeStamp(this._noteTimeStamp);
/* 199 */     argDAO.suppressStateChanges(false);
/* 200 */     return (IDataAccessObject)dao;
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDefaultDAO() {
/* 204 */     return loadDAO((IDataAccessObject)new CustomerNoteDAO());
/*     */   }
/*     */   
/*     */   public void fill(IDataAccessObject argDAO) {
/* 208 */     CustomerNoteDAO dao = (CustomerNoteDAO)argDAO;
/* 209 */     this._organizationId = dao.getOrganizationId();
/* 210 */     this._partyId = dao.getPartyId();
/* 211 */     this._noteSequence = dao.getNoteSequence();
/* 212 */     this._createDate = dao.getCreateDate();
/* 213 */     this._createUserId = dao.getCreateUserId();
/* 214 */     this._updateDate = dao.getUpdateDate();
/* 215 */     this._updateUserId = dao.getUpdateUserId();
/* 216 */     this._creatorId = dao.getCreatorId();
/* 217 */     this._note = dao.getNote();
/* 218 */     this._noteTimeStamp = dao.getNoteTimeStamp();
/*     */   }
/*     */   
/*     */   public PreparedStatement writeObjectId(IObjectId argId, PreparedStatement argStatement) throws SQLException {
/* 222 */     CustomerNoteId id = (CustomerNoteId)argId;
/* 223 */     argStatement.setLong(1, id.getOrganizationId().longValue());
/* 224 */     argStatement.setLong(2, id.getPartyId().longValue());
/* 225 */     argStatement.setLong(3, id.getNoteSequence().longValue());
/* 226 */     return argStatement;
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 230 */     CustomerNoteId id = new CustomerNoteId();
/* 231 */     id.setOrganizationId(this._organizationId);
/* 232 */     id.setPartyId(this._partyId);
/* 233 */     id.setNoteSequence(this._noteSequence);
/* 234 */     return (IObjectId)id;
/*     */   }
/*     */ 
/*     */   
/*     */   public void fill(IJDBCTableAdapter argAdapter) {}
/*     */ 
/*     */   
/*     */   public boolean isExtensible() {
/* 242 */     return false;
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 246 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\crm\impl\CustomerNoteDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */