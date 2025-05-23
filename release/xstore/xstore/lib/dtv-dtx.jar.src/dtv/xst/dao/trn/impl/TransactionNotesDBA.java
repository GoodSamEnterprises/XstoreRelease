/*     */ package dtv.xst.dao.trn.impl;
/*     */ 
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.impl.jdbc.IFiller;
/*     */ import dtv.data2.access.impl.jdbc.IJDBCTableAdapter;
/*     */ import dtv.data2.access.impl.jdbc.JDBCHelper;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.trn.TransactionNotesId;
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
/*     */ public class TransactionNotesDBA
/*     */   implements IJDBCTableAdapter
/*     */ {
/*     */   private static final long serialVersionUID = -349574493L;
/*     */   private Date _businessDate;
/*     */   private Integer _noteSequence;
/*     */   private Long _organizationId;
/*     */   private Long _retailLocationId;
/*     */   private Long _transactionSequence;
/*     */   private Long _workstationId;
/*     */   private Date _createDate;
/*     */   private String _createUserId;
/*     */   private Date _updateDate;
/*     */   private String _updateUserId;
/*     */   private String _note;
/*     */   private Date _noteDatetimestamp;
/*     */   private Boolean _posted;
/*     */   private static final String SELECT_OBJECT = "SELECT t.business_date, t.note_seq, t.organization_id, t.rtl_loc_id, t.trans_seq, t.wkstn_id, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.note, t.note_datetime, t.posted_flag FROM trn_trans_notes t";
/*     */   private static final String SELECT_WHERE_OBJECT = " WHERE business_date = ?  AND note_seq = ?  AND organization_id = ?  AND rtl_loc_id = ?  AND trans_seq = ?  AND wkstn_id = ?  ";
/*     */   
/*     */   public String getSelect() {
/*  42 */     return getSelectImpl();
/*     */   }
/*     */   
/*     */   private String getSelectImpl() {
/*  46 */     return "SELECT t.business_date, t.note_seq, t.organization_id, t.rtl_loc_id, t.trans_seq, t.wkstn_id, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.note, t.note_datetime, t.posted_flag FROM trn_trans_notes t";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectWhere() {
/*  52 */     return " WHERE business_date = ?  AND note_seq = ?  AND organization_id = ?  AND rtl_loc_id = ?  AND trans_seq = ?  AND wkstn_id = ?  ";
/*     */   }
/*     */   
/*  55 */   private static final String[] INSERT_OBJECT = new String[] { "INSERT INTO trn_trans_notes(business_date, note_seq, organization_id, rtl_loc_id, trans_seq, wkstn_id, create_date, create_user_id, update_date, update_user_id, note, note_datetime, posted_flag) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" };
/*     */   
/*     */   public String[] getInsert() {
/*  58 */     return INSERT_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getInsertParameters() {
/*  62 */     Object[][] insertParameterObject = { { this._businessDate, this._noteSequence, this._organizationId, this._retailLocationId, this._transactionSequence, this._workstationId, this._createDate, this._createUserId, this._updateDate, this._updateUserId, this._note, this._noteDatetimestamp, this._posted } };
/*  63 */     return insertParameterObject;
/*     */   }
/*     */   
/*  66 */   private static final int[][] INSERT_PARAMETER_TYPES_OBJECT = new int[][] { { 91, 4, -5, -5, -5, -5, 91, 12, 91, 12, 2005, 91, -7 } };
/*     */   
/*     */   public int[][] getInsertParameterTypes() {
/*  69 */     return INSERT_PARAMETER_TYPES_OBJECT;
/*     */   }
/*     */   
/*  72 */   private static final String[] UPDATE_OBJECT = new String[] { "UPDATE trn_trans_notes SET update_date = ?, update_user_id = ?, note = ?, note_datetime = ?, posted_flag = ?" };
/*     */   
/*     */   public String[] getUpdate() {
/*  75 */     return UPDATE_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getUpdateParameters() {
/*  79 */     Object[][] updateParameterObject = { { this._updateDate, this._updateUserId, this._note, this._noteDatetimestamp, this._posted } };
/*  80 */     return updateParameterObject;
/*     */   }
/*     */   
/*  83 */   private static final int[][] UPDATE_PARAMETER_TYPE_OBJECT = new int[][] { { 91, 12, 2005, 91, -7 } };
/*     */   public int[][] getUpdateParameterTypes() {
/*  85 */     return UPDATE_PARAMETER_TYPE_OBJECT;
/*     */   }
/*     */   
/*  88 */   private static final String[] DELETE_OBJECT = new String[] { "DELETE FROM trn_trans_notes" }; private static final String WHERE_OBJECT = " WHERE business_date = ?  AND note_seq = ?  AND organization_id = ?  AND rtl_loc_id = ?  AND trans_seq = ?  AND wkstn_id = ?  ";
/*     */   
/*     */   public String[] getDelete() {
/*  91 */     return DELETE_OBJECT;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWhere() {
/*  97 */     return " WHERE business_date = ?  AND note_seq = ?  AND organization_id = ?  AND rtl_loc_id = ?  AND trans_seq = ?  AND wkstn_id = ?  ";
/*     */   }
/*     */   public Object[] getWhereParameters() {
/* 100 */     return new Object[] { this._businessDate, this._noteSequence, this._organizationId, this._retailLocationId, this._transactionSequence, this._workstationId };
/*     */   }
/*     */   
/* 103 */   private static final int[] WHERE_PARAMETER_OBJECT = new int[] { 91, 4, -5, -5, -5, -5 };
/*     */   
/*     */   public int[] getWhereParameterTypes() {
/* 106 */     return WHERE_PARAMETER_OBJECT;
/*     */   }
/*     */   public String getTableName() {
/* 109 */     return "trn_trans_notes";
/*     */   }
/*     */   
/*     */   public IFiller getFiller() {
/* 113 */     return getFillerImpl();
/*     */   }
/*     */   
/*     */   private IFiller getFillerImpl() {
/* 117 */     return new TransactionNotesFiller(this);
/*     */   }
/*     */   
/*     */   private static class TransactionNotesFiller
/*     */     implements IFiller {
/*     */     private TransactionNotesDBA _parent;
/*     */     
/*     */     public TransactionNotesFiller(TransactionNotesDBA argParent) {
/* 125 */       this._parent = argParent;
/*     */     }
/*     */     
/*     */     public void fill(ResultSet argResultSet) throws SQLException {
/* 129 */       Timestamp t1 = argResultSet.getTimestamp(1);
/* 130 */       if (t1 != null) {
/* 131 */         this._parent._businessDate = (Date)new DtvDate(t1.getTime());
/*     */       } else {
/*     */         
/* 134 */         this._parent._businessDate = null;
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/* 139 */       int i = argResultSet.getInt(2);
/* 140 */       if (i != 0 || argResultSet.getObject(2) != null) {
/* 141 */         this._parent._noteSequence = Integer.valueOf(i);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 147 */       long primitiveResult = argResultSet.getLong(3);
/* 148 */       if (primitiveResult != 0L || argResultSet.getObject(3) != null) {
/* 149 */         this._parent._organizationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 155 */       primitiveResult = argResultSet.getLong(4);
/* 156 */       if (primitiveResult != 0L || argResultSet.getObject(4) != null) {
/* 157 */         this._parent._retailLocationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 163 */       primitiveResult = argResultSet.getLong(5);
/* 164 */       if (primitiveResult != 0L || argResultSet.getObject(5) != null) {
/* 165 */         this._parent._transactionSequence = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 171 */       primitiveResult = argResultSet.getLong(6);
/* 172 */       if (primitiveResult != 0L || argResultSet.getObject(6) != null) {
/* 173 */         this._parent._workstationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 178 */       Timestamp t7 = argResultSet.getTimestamp(7);
/* 179 */       if (t7 != null) {
/* 180 */         this._parent._createDate = (Date)new DtvDate(t7.getTime());
/*     */       } else {
/*     */         
/* 183 */         this._parent._createDate = null;
/*     */       } 
/*     */       
/* 186 */       this._parent._createUserId = argResultSet.getString(8);
/*     */       
/* 188 */       Timestamp t9 = argResultSet.getTimestamp(9);
/* 189 */       if (t9 != null) {
/* 190 */         this._parent._updateDate = (Date)new DtvDate(t9.getTime());
/*     */       } else {
/*     */         
/* 193 */         this._parent._updateDate = null;
/*     */       } 
/*     */       
/* 196 */       this._parent._updateUserId = argResultSet.getString(10);
/*     */ 
/*     */       
/* 199 */       this._parent._note = JDBCHelper.clobToString(argResultSet, 11);
/*     */ 
/*     */       
/* 202 */       Timestamp t12 = argResultSet.getTimestamp(12);
/* 203 */       if (t12 != null) {
/* 204 */         this._parent._noteDatetimestamp = (Date)new DtvDate(t12.getTime());
/*     */       } else {
/*     */         
/* 207 */         this._parent._noteDatetimestamp = null;
/*     */       } 
/*     */       
/* 210 */       this._parent._posted = Boolean.valueOf(argResultSet.getBoolean(13));
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDAO(IDataAccessObject argDAO) {
/* 215 */     argDAO.suppressStateChanges(true);
/* 216 */     TransactionNotesDAO dao = (TransactionNotesDAO)argDAO;
/* 217 */     dao.setBusinessDate(this._businessDate);
/* 218 */     dao.setNoteSequence(this._noteSequence);
/* 219 */     dao.setOrganizationId(this._organizationId);
/* 220 */     dao.setRetailLocationId(this._retailLocationId);
/* 221 */     dao.setTransactionSequence(this._transactionSequence);
/* 222 */     dao.setWorkstationId(this._workstationId);
/* 223 */     dao.setCreateDate(this._createDate);
/* 224 */     dao.setCreateUserId(this._createUserId);
/* 225 */     dao.setUpdateDate(this._updateDate);
/* 226 */     dao.setUpdateUserId(this._updateUserId);
/* 227 */     dao.setNote(this._note);
/* 228 */     dao.setNoteDatetimestamp(this._noteDatetimestamp);
/* 229 */     dao.setPosted(this._posted);
/* 230 */     argDAO.suppressStateChanges(false);
/* 231 */     return (IDataAccessObject)dao;
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDefaultDAO() {
/* 235 */     return loadDAO((IDataAccessObject)new TransactionNotesDAO());
/*     */   }
/*     */   
/*     */   public void fill(IDataAccessObject argDAO) {
/* 239 */     TransactionNotesDAO dao = (TransactionNotesDAO)argDAO;
/* 240 */     this._businessDate = dao.getBusinessDate();
/* 241 */     this._noteSequence = dao.getNoteSequence();
/* 242 */     this._organizationId = dao.getOrganizationId();
/* 243 */     this._retailLocationId = dao.getRetailLocationId();
/* 244 */     this._transactionSequence = dao.getTransactionSequence();
/* 245 */     this._workstationId = dao.getWorkstationId();
/* 246 */     this._createDate = dao.getCreateDate();
/* 247 */     this._createUserId = dao.getCreateUserId();
/* 248 */     this._updateDate = dao.getUpdateDate();
/* 249 */     this._updateUserId = dao.getUpdateUserId();
/* 250 */     this._note = dao.getNote();
/* 251 */     this._noteDatetimestamp = dao.getNoteDatetimestamp();
/* 252 */     this._posted = (dao.getPosted() != null) ? dao.getPosted() : Boolean.valueOf(false);
/*     */   }
/*     */   
/*     */   public PreparedStatement writeObjectId(IObjectId argId, PreparedStatement argStatement) throws SQLException {
/* 256 */     TransactionNotesId id = (TransactionNotesId)argId;
/* 257 */     argStatement.setTimestamp(1, new Timestamp(id.getBusinessDate().getTime()));
/* 258 */     argStatement.setInt(2, id.getNoteSequence().intValue());
/* 259 */     argStatement.setLong(3, id.getOrganizationId().longValue());
/* 260 */     argStatement.setLong(4, id.getRetailLocationId().longValue());
/* 261 */     argStatement.setLong(5, id.getTransactionSequence().longValue());
/* 262 */     argStatement.setLong(6, id.getWorkstationId().longValue());
/* 263 */     return argStatement;
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 267 */     TransactionNotesId id = new TransactionNotesId();
/* 268 */     id.setBusinessDate(this._businessDate);
/* 269 */     id.setNoteSequence(this._noteSequence);
/* 270 */     id.setOrganizationId(this._organizationId);
/* 271 */     id.setRetailLocationId(this._retailLocationId);
/* 272 */     id.setTransactionSequence(this._transactionSequence);
/* 273 */     id.setWorkstationId(this._workstationId);
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


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\trn\impl\TransactionNotesDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */