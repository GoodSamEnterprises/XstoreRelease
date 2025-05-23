/*     */ package dtv.xst.dao.trl.impl;
/*     */ 
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.impl.jdbc.IFiller;
/*     */ import dtv.data2.access.impl.jdbc.IJDBCTableAdapter;
/*     */ import dtv.data2.access.impl.jdbc.JDBCHelper;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.trl.RetailTransactionLineItemNotesId;
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
/*     */ public class RetailTransactionLineItemNotesDBA
/*     */   implements IJDBCTableAdapter
/*     */ {
/*     */   private static final long serialVersionUID = 1536161759L;
/*     */   private Date _businessDate;
/*     */   private Long _organizationId;
/*     */   private Long _retailLocationId;
/*     */   private Integer _retailTransactionLineItemSequence;
/*     */   private Long _transactionSequence;
/*     */   private Long _workstationId;
/*     */   private Long _noteSeq;
/*     */   private Date _createDate;
/*     */   private String _createUserId;
/*     */   private Date _updateDate;
/*     */   private String _updateUserId;
/*     */   private String _note;
/*     */   private Date _noteDatetimestamp;
/*     */   private Boolean _posted;
/*     */   private static final String SELECT_OBJECT = "SELECT t.business_date, t.organization_id, t.rtl_loc_id, t.rtrans_lineitm_seq, t.trans_seq, t.wkstn_id, t.note_seq, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.note, t.note_datetime, t.posted_flag FROM trl_lineitm_notes t";
/*     */   private static final String SELECT_WHERE_OBJECT = " WHERE business_date = ?  AND organization_id = ?  AND rtl_loc_id = ?  AND rtrans_lineitm_seq = ?  AND trans_seq = ?  AND wkstn_id = ?  AND note_seq = ?  ";
/*     */   
/*     */   public String getSelect() {
/*  43 */     return getSelectImpl();
/*     */   }
/*     */   
/*     */   private String getSelectImpl() {
/*  47 */     return "SELECT t.business_date, t.organization_id, t.rtl_loc_id, t.rtrans_lineitm_seq, t.trans_seq, t.wkstn_id, t.note_seq, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.note, t.note_datetime, t.posted_flag FROM trl_lineitm_notes t";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectWhere() {
/*  53 */     return " WHERE business_date = ?  AND organization_id = ?  AND rtl_loc_id = ?  AND rtrans_lineitm_seq = ?  AND trans_seq = ?  AND wkstn_id = ?  AND note_seq = ?  ";
/*     */   }
/*     */   
/*  56 */   private static final String[] INSERT_OBJECT = new String[] { "INSERT INTO trl_lineitm_notes(business_date, organization_id, rtl_loc_id, rtrans_lineitm_seq, trans_seq, wkstn_id, note_seq, create_date, create_user_id, update_date, update_user_id, note, note_datetime, posted_flag) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" };
/*     */   
/*     */   public String[] getInsert() {
/*  59 */     return INSERT_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getInsertParameters() {
/*  63 */     Object[][] insertParameterObject = { { this._businessDate, this._organizationId, this._retailLocationId, this._retailTransactionLineItemSequence, this._transactionSequence, this._workstationId, this._noteSeq, this._createDate, this._createUserId, this._updateDate, this._updateUserId, this._note, this._noteDatetimestamp, this._posted } };
/*  64 */     return insertParameterObject;
/*     */   }
/*     */   
/*  67 */   private static final int[][] INSERT_PARAMETER_TYPES_OBJECT = new int[][] { { 91, -5, -5, 4, -5, -5, -5, 91, 12, 91, 12, 2005, 91, -7 } };
/*     */   
/*     */   public int[][] getInsertParameterTypes() {
/*  70 */     return INSERT_PARAMETER_TYPES_OBJECT;
/*     */   }
/*     */   
/*  73 */   private static final String[] UPDATE_OBJECT = new String[] { "UPDATE trl_lineitm_notes SET update_date = ?, update_user_id = ?, note = ?, note_datetime = ?, posted_flag = ?" };
/*     */   
/*     */   public String[] getUpdate() {
/*  76 */     return UPDATE_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getUpdateParameters() {
/*  80 */     Object[][] updateParameterObject = { { this._updateDate, this._updateUserId, this._note, this._noteDatetimestamp, this._posted } };
/*  81 */     return updateParameterObject;
/*     */   }
/*     */   
/*  84 */   private static final int[][] UPDATE_PARAMETER_TYPE_OBJECT = new int[][] { { 91, 12, 2005, 91, -7 } };
/*     */   public int[][] getUpdateParameterTypes() {
/*  86 */     return UPDATE_PARAMETER_TYPE_OBJECT;
/*     */   }
/*     */   
/*  89 */   private static final String[] DELETE_OBJECT = new String[] { "DELETE FROM trl_lineitm_notes" }; private static final String WHERE_OBJECT = " WHERE business_date = ?  AND organization_id = ?  AND rtl_loc_id = ?  AND rtrans_lineitm_seq = ?  AND trans_seq = ?  AND wkstn_id = ?  AND note_seq = ?  ";
/*     */   
/*     */   public String[] getDelete() {
/*  92 */     return DELETE_OBJECT;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWhere() {
/*  98 */     return " WHERE business_date = ?  AND organization_id = ?  AND rtl_loc_id = ?  AND rtrans_lineitm_seq = ?  AND trans_seq = ?  AND wkstn_id = ?  AND note_seq = ?  ";
/*     */   }
/*     */   public Object[] getWhereParameters() {
/* 101 */     return new Object[] { this._businessDate, this._organizationId, this._retailLocationId, this._retailTransactionLineItemSequence, this._transactionSequence, this._workstationId, this._noteSeq };
/*     */   }
/*     */   
/* 104 */   private static final int[] WHERE_PARAMETER_OBJECT = new int[] { 91, -5, -5, 4, -5, -5, -5 };
/*     */   
/*     */   public int[] getWhereParameterTypes() {
/* 107 */     return WHERE_PARAMETER_OBJECT;
/*     */   }
/*     */   public String getTableName() {
/* 110 */     return "trl_lineitm_notes";
/*     */   }
/*     */   
/*     */   public IFiller getFiller() {
/* 114 */     return getFillerImpl();
/*     */   }
/*     */   
/*     */   private IFiller getFillerImpl() {
/* 118 */     return new RetailTransactionLineItemNotesFiller(this);
/*     */   }
/*     */   
/*     */   private static class RetailTransactionLineItemNotesFiller
/*     */     implements IFiller {
/*     */     private RetailTransactionLineItemNotesDBA _parent;
/*     */     
/*     */     public RetailTransactionLineItemNotesFiller(RetailTransactionLineItemNotesDBA argParent) {
/* 126 */       this._parent = argParent;
/*     */     }
/*     */     
/*     */     public void fill(ResultSet argResultSet) throws SQLException {
/* 130 */       Timestamp t1 = argResultSet.getTimestamp(1);
/* 131 */       if (t1 != null) {
/* 132 */         this._parent._businessDate = (Date)new DtvDate(t1.getTime());
/*     */       } else {
/*     */         
/* 135 */         this._parent._businessDate = null;
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/* 140 */       long l1 = argResultSet.getLong(2);
/* 141 */       if (l1 != 0L || argResultSet.getObject(2) != null) {
/* 142 */         this._parent._organizationId = Long.valueOf(l1);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 148 */       l1 = argResultSet.getLong(3);
/* 149 */       if (l1 != 0L || argResultSet.getObject(3) != null) {
/* 150 */         this._parent._retailLocationId = Long.valueOf(l1);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 156 */       int i = argResultSet.getInt(4);
/* 157 */       if (i != 0 || argResultSet.getObject(4) != null) {
/* 158 */         this._parent._retailTransactionLineItemSequence = Integer.valueOf(i);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 164 */       long primitiveResult = argResultSet.getLong(5);
/* 165 */       if (primitiveResult != 0L || argResultSet.getObject(5) != null) {
/* 166 */         this._parent._transactionSequence = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 172 */       primitiveResult = argResultSet.getLong(6);
/* 173 */       if (primitiveResult != 0L || argResultSet.getObject(6) != null) {
/* 174 */         this._parent._workstationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 180 */       primitiveResult = argResultSet.getLong(7);
/* 181 */       if (primitiveResult != 0L || argResultSet.getObject(7) != null) {
/* 182 */         this._parent._noteSeq = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 187 */       Timestamp t8 = argResultSet.getTimestamp(8);
/* 188 */       if (t8 != null) {
/* 189 */         this._parent._createDate = (Date)new DtvDate(t8.getTime());
/*     */       } else {
/*     */         
/* 192 */         this._parent._createDate = null;
/*     */       } 
/*     */       
/* 195 */       this._parent._createUserId = argResultSet.getString(9);
/*     */       
/* 197 */       Timestamp t10 = argResultSet.getTimestamp(10);
/* 198 */       if (t10 != null) {
/* 199 */         this._parent._updateDate = (Date)new DtvDate(t10.getTime());
/*     */       } else {
/*     */         
/* 202 */         this._parent._updateDate = null;
/*     */       } 
/*     */       
/* 205 */       this._parent._updateUserId = argResultSet.getString(11);
/*     */ 
/*     */       
/* 208 */       this._parent._note = JDBCHelper.clobToString(argResultSet, 12);
/*     */ 
/*     */       
/* 211 */       Timestamp t13 = argResultSet.getTimestamp(13);
/* 212 */       if (t13 != null) {
/* 213 */         this._parent._noteDatetimestamp = (Date)new DtvDate(t13.getTime());
/*     */       } else {
/*     */         
/* 216 */         this._parent._noteDatetimestamp = null;
/*     */       } 
/*     */       
/* 219 */       this._parent._posted = Boolean.valueOf(argResultSet.getBoolean(14));
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDAO(IDataAccessObject argDAO) {
/* 224 */     argDAO.suppressStateChanges(true);
/* 225 */     RetailTransactionLineItemNotesDAO dao = (RetailTransactionLineItemNotesDAO)argDAO;
/* 226 */     dao.setBusinessDate(this._businessDate);
/* 227 */     dao.setOrganizationId(this._organizationId);
/* 228 */     dao.setRetailLocationId(this._retailLocationId);
/* 229 */     dao.setRetailTransactionLineItemSequence(this._retailTransactionLineItemSequence);
/* 230 */     dao.setTransactionSequence(this._transactionSequence);
/* 231 */     dao.setWorkstationId(this._workstationId);
/* 232 */     dao.setNoteSeq(this._noteSeq);
/* 233 */     dao.setCreateDate(this._createDate);
/* 234 */     dao.setCreateUserId(this._createUserId);
/* 235 */     dao.setUpdateDate(this._updateDate);
/* 236 */     dao.setUpdateUserId(this._updateUserId);
/* 237 */     dao.setNote(this._note);
/* 238 */     dao.setNoteDatetimestamp(this._noteDatetimestamp);
/* 239 */     dao.setPosted(this._posted);
/* 240 */     argDAO.suppressStateChanges(false);
/* 241 */     return (IDataAccessObject)dao;
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDefaultDAO() {
/* 245 */     return loadDAO((IDataAccessObject)new RetailTransactionLineItemNotesDAO());
/*     */   }
/*     */   
/*     */   public void fill(IDataAccessObject argDAO) {
/* 249 */     RetailTransactionLineItemNotesDAO dao = (RetailTransactionLineItemNotesDAO)argDAO;
/* 250 */     this._businessDate = dao.getBusinessDate();
/* 251 */     this._organizationId = dao.getOrganizationId();
/* 252 */     this._retailLocationId = dao.getRetailLocationId();
/* 253 */     this._retailTransactionLineItemSequence = dao.getRetailTransactionLineItemSequence();
/* 254 */     this._transactionSequence = dao.getTransactionSequence();
/* 255 */     this._workstationId = dao.getWorkstationId();
/* 256 */     this._noteSeq = dao.getNoteSeq();
/* 257 */     this._createDate = dao.getCreateDate();
/* 258 */     this._createUserId = dao.getCreateUserId();
/* 259 */     this._updateDate = dao.getUpdateDate();
/* 260 */     this._updateUserId = dao.getUpdateUserId();
/* 261 */     this._note = dao.getNote();
/* 262 */     this._noteDatetimestamp = dao.getNoteDatetimestamp();
/* 263 */     this._posted = (dao.getPosted() != null) ? dao.getPosted() : Boolean.valueOf(false);
/*     */   }
/*     */   
/*     */   public PreparedStatement writeObjectId(IObjectId argId, PreparedStatement argStatement) throws SQLException {
/* 267 */     RetailTransactionLineItemNotesId id = (RetailTransactionLineItemNotesId)argId;
/* 268 */     argStatement.setTimestamp(1, new Timestamp(id.getBusinessDate().getTime()));
/* 269 */     argStatement.setLong(2, id.getOrganizationId().longValue());
/* 270 */     argStatement.setLong(3, id.getRetailLocationId().longValue());
/* 271 */     argStatement.setInt(4, id.getRetailTransactionLineItemSequence().intValue());
/* 272 */     argStatement.setLong(5, id.getTransactionSequence().longValue());
/* 273 */     argStatement.setLong(6, id.getWorkstationId().longValue());
/* 274 */     argStatement.setLong(7, id.getNoteSeq().longValue());
/* 275 */     return argStatement;
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 279 */     RetailTransactionLineItemNotesId id = new RetailTransactionLineItemNotesId();
/* 280 */     id.setBusinessDate(this._businessDate);
/* 281 */     id.setOrganizationId(this._organizationId);
/* 282 */     id.setRetailLocationId(this._retailLocationId);
/* 283 */     id.setRetailTransactionLineItemSequence(this._retailTransactionLineItemSequence);
/* 284 */     id.setTransactionSequence(this._transactionSequence);
/* 285 */     id.setWorkstationId(this._workstationId);
/* 286 */     id.setNoteSeq(this._noteSeq);
/* 287 */     return (IObjectId)id;
/*     */   }
/*     */ 
/*     */   
/*     */   public void fill(IJDBCTableAdapter argAdapter) {}
/*     */ 
/*     */   
/*     */   public boolean isExtensible() {
/* 295 */     return false;
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 299 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\trl\impl\RetailTransactionLineItemNotesDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */