/*     */ package dtv.xst.dao.cat.impl;
/*     */ 
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.impl.jdbc.IFiller;
/*     */ import dtv.data2.access.impl.jdbc.IJDBCTableAdapter;
/*     */ import dtv.data2.access.impl.jdbc.JDBCHelper;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.cat.CustomerAccountNoteId;
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
/*     */ public class CustomerAccountNoteDBA
/*     */   implements IJDBCTableAdapter
/*     */ {
/*     */   private static final long serialVersionUID = 1544669409L;
/*     */   private Long _noteSequence;
/*     */   private Long _organizationId;
/*     */   private String _custAccountId;
/*     */   private String _custAccountCode;
/*     */   private Date _createDate;
/*     */   private String _createUserId;
/*     */   private Date _updateDate;
/*     */   private String _updateUserId;
/*     */   private Date _entryTimestamp;
/*     */   private Long _entryPartyId;
/*     */   private String _note;
/*     */   private static final String SELECT_OBJECT = "SELECT t.note_seq, t.organization_id, t.cust_acct_id, t.cust_acct_code, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.entry_timestamp, t.entry_party_id, t.note FROM cat_acct_note t";
/*     */   private static final String SELECT_WHERE_OBJECT = " WHERE note_seq = ?  AND organization_id = ?  AND cust_acct_id = ?  AND cust_acct_code = ?  ";
/*     */   
/*     */   public String getSelect() {
/*  40 */     return getSelectImpl();
/*     */   }
/*     */   
/*     */   private String getSelectImpl() {
/*  44 */     return "SELECT t.note_seq, t.organization_id, t.cust_acct_id, t.cust_acct_code, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.entry_timestamp, t.entry_party_id, t.note FROM cat_acct_note t";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectWhere() {
/*  50 */     return " WHERE note_seq = ?  AND organization_id = ?  AND cust_acct_id = ?  AND cust_acct_code = ?  ";
/*     */   }
/*     */   
/*  53 */   private static final String[] INSERT_OBJECT = new String[] { "INSERT INTO cat_acct_note(note_seq, organization_id, cust_acct_id, cust_acct_code, create_date, create_user_id, update_date, update_user_id, entry_timestamp, entry_party_id, note) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" };
/*     */   
/*     */   public String[] getInsert() {
/*  56 */     return INSERT_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getInsertParameters() {
/*  60 */     Object[][] insertParameterObject = { { this._noteSequence, this._organizationId, this._custAccountId, this._custAccountCode, this._createDate, this._createUserId, this._updateDate, this._updateUserId, this._entryTimestamp, this._entryPartyId, this._note } };
/*  61 */     return insertParameterObject;
/*     */   }
/*     */   
/*  64 */   private static final int[][] INSERT_PARAMETER_TYPES_OBJECT = new int[][] { { -5, -5, 12, 12, 91, 12, 91, 12, 91, -5, 2005 } };
/*     */   
/*     */   public int[][] getInsertParameterTypes() {
/*  67 */     return INSERT_PARAMETER_TYPES_OBJECT;
/*     */   }
/*     */   
/*  70 */   private static final String[] UPDATE_OBJECT = new String[] { "UPDATE cat_acct_note SET update_date = ?, update_user_id = ?, entry_timestamp = ?, entry_party_id = ?, note = ?" };
/*     */   
/*     */   public String[] getUpdate() {
/*  73 */     return UPDATE_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getUpdateParameters() {
/*  77 */     Object[][] updateParameterObject = { { this._updateDate, this._updateUserId, this._entryTimestamp, this._entryPartyId, this._note } };
/*  78 */     return updateParameterObject;
/*     */   }
/*     */   
/*  81 */   private static final int[][] UPDATE_PARAMETER_TYPE_OBJECT = new int[][] { { 91, 12, 91, -5, 2005 } };
/*     */   public int[][] getUpdateParameterTypes() {
/*  83 */     return UPDATE_PARAMETER_TYPE_OBJECT;
/*     */   }
/*     */   
/*  86 */   private static final String[] DELETE_OBJECT = new String[] { "DELETE FROM cat_acct_note" }; private static final String WHERE_OBJECT = " WHERE note_seq = ?  AND organization_id = ?  AND cust_acct_id = ?  AND cust_acct_code = ?  ";
/*     */   
/*     */   public String[] getDelete() {
/*  89 */     return DELETE_OBJECT;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWhere() {
/*  95 */     return " WHERE note_seq = ?  AND organization_id = ?  AND cust_acct_id = ?  AND cust_acct_code = ?  ";
/*     */   }
/*     */   public Object[] getWhereParameters() {
/*  98 */     return new Object[] { this._noteSequence, this._organizationId, this._custAccountId, this._custAccountCode };
/*     */   }
/*     */   
/* 101 */   private static final int[] WHERE_PARAMETER_OBJECT = new int[] { -5, -5, 12, 12 };
/*     */   
/*     */   public int[] getWhereParameterTypes() {
/* 104 */     return WHERE_PARAMETER_OBJECT;
/*     */   }
/*     */   public String getTableName() {
/* 107 */     return "cat_acct_note";
/*     */   }
/*     */   
/*     */   public IFiller getFiller() {
/* 111 */     return getFillerImpl();
/*     */   }
/*     */   
/*     */   private IFiller getFillerImpl() {
/* 115 */     return new CustomerAccountNoteFiller(this);
/*     */   }
/*     */   
/*     */   private static class CustomerAccountNoteFiller
/*     */     implements IFiller {
/*     */     private CustomerAccountNoteDBA _parent;
/*     */     
/*     */     public CustomerAccountNoteFiller(CustomerAccountNoteDBA argParent) {
/* 123 */       this._parent = argParent;
/*     */     }
/*     */ 
/*     */     
/*     */     public void fill(ResultSet argResultSet) throws SQLException {
/* 128 */       long primitiveResult = argResultSet.getLong(1);
/* 129 */       if (primitiveResult != 0L || argResultSet.getObject(1) != null) {
/* 130 */         this._parent._noteSequence = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 136 */       primitiveResult = argResultSet.getLong(2);
/* 137 */       if (primitiveResult != 0L || argResultSet.getObject(2) != null) {
/* 138 */         this._parent._organizationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */       
/* 142 */       this._parent._custAccountId = argResultSet.getString(3);
/* 143 */       this._parent._custAccountCode = argResultSet.getString(4);
/*     */       
/* 145 */       Timestamp t5 = argResultSet.getTimestamp(5);
/* 146 */       if (t5 != null) {
/* 147 */         this._parent._createDate = (Date)new DtvDate(t5.getTime());
/*     */       } else {
/*     */         
/* 150 */         this._parent._createDate = null;
/*     */       } 
/*     */       
/* 153 */       this._parent._createUserId = argResultSet.getString(6);
/*     */       
/* 155 */       Timestamp t7 = argResultSet.getTimestamp(7);
/* 156 */       if (t7 != null) {
/* 157 */         this._parent._updateDate = (Date)new DtvDate(t7.getTime());
/*     */       } else {
/*     */         
/* 160 */         this._parent._updateDate = null;
/*     */       } 
/*     */       
/* 163 */       this._parent._updateUserId = argResultSet.getString(8);
/*     */       
/* 165 */       Timestamp t9 = argResultSet.getTimestamp(9);
/* 166 */       if (t9 != null) {
/* 167 */         this._parent._entryTimestamp = (Date)new DtvDate(t9.getTime());
/*     */       } else {
/*     */         
/* 170 */         this._parent._entryTimestamp = null;
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/* 175 */       long l1 = argResultSet.getLong(10);
/* 176 */       if (l1 != 0L || argResultSet.getObject(10) != null) {
/* 177 */         this._parent._entryPartyId = Long.valueOf(l1);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 183 */       this._parent._note = JDBCHelper.clobToString(argResultSet, 11);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public IDataAccessObject loadDAO(IDataAccessObject argDAO) {
/* 189 */     argDAO.suppressStateChanges(true);
/* 190 */     CustomerAccountNoteDAO dao = (CustomerAccountNoteDAO)argDAO;
/* 191 */     dao.setNoteSequence(this._noteSequence);
/* 192 */     dao.setOrganizationId(this._organizationId);
/* 193 */     dao.setCustAccountId(this._custAccountId);
/* 194 */     dao.setCustAccountCode(this._custAccountCode);
/* 195 */     dao.setCreateDate(this._createDate);
/* 196 */     dao.setCreateUserId(this._createUserId);
/* 197 */     dao.setUpdateDate(this._updateDate);
/* 198 */     dao.setUpdateUserId(this._updateUserId);
/* 199 */     dao.setEntryTimestamp(this._entryTimestamp);
/* 200 */     dao.setEntryPartyId(this._entryPartyId);
/* 201 */     dao.setNote(this._note);
/* 202 */     argDAO.suppressStateChanges(false);
/* 203 */     return (IDataAccessObject)dao;
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDefaultDAO() {
/* 207 */     return loadDAO((IDataAccessObject)new CustomerAccountNoteDAO());
/*     */   }
/*     */   
/*     */   public void fill(IDataAccessObject argDAO) {
/* 211 */     CustomerAccountNoteDAO dao = (CustomerAccountNoteDAO)argDAO;
/* 212 */     this._noteSequence = dao.getNoteSequence();
/* 213 */     this._organizationId = dao.getOrganizationId();
/* 214 */     this._custAccountId = dao.getCustAccountId();
/* 215 */     this._custAccountCode = dao.getCustAccountCode();
/* 216 */     this._createDate = dao.getCreateDate();
/* 217 */     this._createUserId = dao.getCreateUserId();
/* 218 */     this._updateDate = dao.getUpdateDate();
/* 219 */     this._updateUserId = dao.getUpdateUserId();
/* 220 */     this._entryTimestamp = dao.getEntryTimestamp();
/* 221 */     this._entryPartyId = dao.getEntryPartyId();
/* 222 */     this._note = dao.getNote();
/*     */   }
/*     */   
/*     */   public PreparedStatement writeObjectId(IObjectId argId, PreparedStatement argStatement) throws SQLException {
/* 226 */     CustomerAccountNoteId id = (CustomerAccountNoteId)argId;
/* 227 */     argStatement.setLong(1, id.getNoteSequence().longValue());
/* 228 */     argStatement.setLong(2, id.getOrganizationId().longValue());
/* 229 */     argStatement.setString(3, id.getCustAccountId());
/* 230 */     argStatement.setString(4, id.getCustAccountCode());
/* 231 */     return argStatement;
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 235 */     CustomerAccountNoteId id = new CustomerAccountNoteId();
/* 236 */     id.setNoteSequence(this._noteSequence);
/* 237 */     id.setOrganizationId(this._organizationId);
/* 238 */     id.setCustAccountId(this._custAccountId);
/* 239 */     id.setCustAccountCode(this._custAccountCode);
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


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\cat\impl\CustomerAccountNoteDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */