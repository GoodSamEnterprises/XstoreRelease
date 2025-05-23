/*     */ package dtv.xst.dao.thr.impl;
/*     */ 
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.impl.jdbc.IFiller;
/*     */ import dtv.data2.access.impl.jdbc.IJDBCTableAdapter;
/*     */ import dtv.data2.access.impl.jdbc.JDBCHelper;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.thr.PayrollNotesId;
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
/*     */ public class PayrollNotesDBA
/*     */   implements IJDBCTableAdapter
/*     */ {
/*     */   private static final long serialVersionUID = 1743357116L;
/*     */   private Long _organizationId;
/*     */   private Long _partyId;
/*     */   private Date _weekEndingDate;
/*     */   private Long _noteSeq;
/*     */   private Date _createDate;
/*     */   private String _createUserId;
/*     */   private Date _updateDate;
/*     */   private String _updateUserId;
/*     */   private String _noteText;
/*     */   private static final String SELECT_OBJECT = "SELECT t.organization_id, t.party_id, t.week_ending_date, t.note_seq, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.note_text FROM thr_payroll_notes t";
/*     */   private static final String SELECT_WHERE_OBJECT = " WHERE organization_id = ?  AND party_id = ?  AND week_ending_date = ?  AND note_seq = ?  ";
/*     */   
/*     */   public String getSelect() {
/*  38 */     return getSelectImpl();
/*     */   }
/*     */   
/*     */   private String getSelectImpl() {
/*  42 */     return "SELECT t.organization_id, t.party_id, t.week_ending_date, t.note_seq, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.note_text FROM thr_payroll_notes t";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectWhere() {
/*  48 */     return " WHERE organization_id = ?  AND party_id = ?  AND week_ending_date = ?  AND note_seq = ?  ";
/*     */   }
/*     */   
/*  51 */   private static final String[] INSERT_OBJECT = new String[] { "INSERT INTO thr_payroll_notes(organization_id, party_id, week_ending_date, note_seq, create_date, create_user_id, update_date, update_user_id, note_text) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)" };
/*     */   
/*     */   public String[] getInsert() {
/*  54 */     return INSERT_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getInsertParameters() {
/*  58 */     Object[][] insertParameterObject = { { this._organizationId, this._partyId, this._weekEndingDate, this._noteSeq, this._createDate, this._createUserId, this._updateDate, this._updateUserId, this._noteText } };
/*  59 */     return insertParameterObject;
/*     */   }
/*     */   
/*  62 */   private static final int[][] INSERT_PARAMETER_TYPES_OBJECT = new int[][] { { -5, -5, 91, -5, 91, 12, 91, 12, 2005 } };
/*     */   
/*     */   public int[][] getInsertParameterTypes() {
/*  65 */     return INSERT_PARAMETER_TYPES_OBJECT;
/*     */   }
/*     */   
/*  68 */   private static final String[] UPDATE_OBJECT = new String[] { "UPDATE thr_payroll_notes SET update_date = ?, update_user_id = ?, note_text = ?" };
/*     */   
/*     */   public String[] getUpdate() {
/*  71 */     return UPDATE_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getUpdateParameters() {
/*  75 */     Object[][] updateParameterObject = { { this._updateDate, this._updateUserId, this._noteText } };
/*  76 */     return updateParameterObject;
/*     */   }
/*     */   
/*  79 */   private static final int[][] UPDATE_PARAMETER_TYPE_OBJECT = new int[][] { { 91, 12, 2005 } };
/*     */   public int[][] getUpdateParameterTypes() {
/*  81 */     return UPDATE_PARAMETER_TYPE_OBJECT;
/*     */   }
/*     */   
/*  84 */   private static final String[] DELETE_OBJECT = new String[] { "DELETE FROM thr_payroll_notes" }; private static final String WHERE_OBJECT = " WHERE organization_id = ?  AND party_id = ?  AND week_ending_date = ?  AND note_seq = ?  ";
/*     */   
/*     */   public String[] getDelete() {
/*  87 */     return DELETE_OBJECT;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWhere() {
/*  93 */     return " WHERE organization_id = ?  AND party_id = ?  AND week_ending_date = ?  AND note_seq = ?  ";
/*     */   }
/*     */   public Object[] getWhereParameters() {
/*  96 */     return new Object[] { this._organizationId, this._partyId, this._weekEndingDate, this._noteSeq };
/*     */   }
/*     */   
/*  99 */   private static final int[] WHERE_PARAMETER_OBJECT = new int[] { -5, -5, 91, -5 };
/*     */   
/*     */   public int[] getWhereParameterTypes() {
/* 102 */     return WHERE_PARAMETER_OBJECT;
/*     */   }
/*     */   public String getTableName() {
/* 105 */     return "thr_payroll_notes";
/*     */   }
/*     */   
/*     */   public IFiller getFiller() {
/* 109 */     return getFillerImpl();
/*     */   }
/*     */   
/*     */   private IFiller getFillerImpl() {
/* 113 */     return new PayrollNotesFiller(this);
/*     */   }
/*     */   
/*     */   private static class PayrollNotesFiller
/*     */     implements IFiller {
/*     */     private PayrollNotesDBA _parent;
/*     */     
/*     */     public PayrollNotesFiller(PayrollNotesDBA argParent) {
/* 121 */       this._parent = argParent;
/*     */     }
/*     */ 
/*     */     
/*     */     public void fill(ResultSet argResultSet) throws SQLException {
/* 126 */       long primitiveResult = argResultSet.getLong(1);
/* 127 */       if (primitiveResult != 0L || argResultSet.getObject(1) != null) {
/* 128 */         this._parent._organizationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 134 */       primitiveResult = argResultSet.getLong(2);
/* 135 */       if (primitiveResult != 0L || argResultSet.getObject(2) != null) {
/* 136 */         this._parent._partyId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 141 */       Timestamp t3 = argResultSet.getTimestamp(3);
/* 142 */       if (t3 != null) {
/* 143 */         this._parent._weekEndingDate = (Date)new DtvDate(t3.getTime());
/*     */       } else {
/*     */         
/* 146 */         this._parent._weekEndingDate = null;
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/* 151 */       long l1 = argResultSet.getLong(4);
/* 152 */       if (l1 != 0L || argResultSet.getObject(4) != null) {
/* 153 */         this._parent._noteSeq = Long.valueOf(l1);
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 158 */       Timestamp t5 = argResultSet.getTimestamp(5);
/* 159 */       if (t5 != null) {
/* 160 */         this._parent._createDate = (Date)new DtvDate(t5.getTime());
/*     */       } else {
/*     */         
/* 163 */         this._parent._createDate = null;
/*     */       } 
/*     */       
/* 166 */       this._parent._createUserId = argResultSet.getString(6);
/*     */       
/* 168 */       Timestamp t7 = argResultSet.getTimestamp(7);
/* 169 */       if (t7 != null) {
/* 170 */         this._parent._updateDate = (Date)new DtvDate(t7.getTime());
/*     */       } else {
/*     */         
/* 173 */         this._parent._updateDate = null;
/*     */       } 
/*     */       
/* 176 */       this._parent._updateUserId = argResultSet.getString(8);
/*     */ 
/*     */       
/* 179 */       this._parent._noteText = JDBCHelper.clobToString(argResultSet, 9);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public IDataAccessObject loadDAO(IDataAccessObject argDAO) {
/* 185 */     argDAO.suppressStateChanges(true);
/* 186 */     PayrollNotesDAO dao = (PayrollNotesDAO)argDAO;
/* 187 */     dao.setOrganizationId(this._organizationId);
/* 188 */     dao.setPartyId(this._partyId);
/* 189 */     dao.setWeekEndingDate(this._weekEndingDate);
/* 190 */     dao.setNoteSeq(this._noteSeq);
/* 191 */     dao.setCreateDate(this._createDate);
/* 192 */     dao.setCreateUserId(this._createUserId);
/* 193 */     dao.setUpdateDate(this._updateDate);
/* 194 */     dao.setUpdateUserId(this._updateUserId);
/* 195 */     dao.setNoteText(this._noteText);
/* 196 */     argDAO.suppressStateChanges(false);
/* 197 */     return (IDataAccessObject)dao;
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDefaultDAO() {
/* 201 */     return loadDAO((IDataAccessObject)new PayrollNotesDAO());
/*     */   }
/*     */   
/*     */   public void fill(IDataAccessObject argDAO) {
/* 205 */     PayrollNotesDAO dao = (PayrollNotesDAO)argDAO;
/* 206 */     this._organizationId = dao.getOrganizationId();
/* 207 */     this._partyId = dao.getPartyId();
/* 208 */     this._weekEndingDate = dao.getWeekEndingDate();
/* 209 */     this._noteSeq = dao.getNoteSeq();
/* 210 */     this._createDate = dao.getCreateDate();
/* 211 */     this._createUserId = dao.getCreateUserId();
/* 212 */     this._updateDate = dao.getUpdateDate();
/* 213 */     this._updateUserId = dao.getUpdateUserId();
/* 214 */     this._noteText = dao.getNoteText();
/*     */   }
/*     */   
/*     */   public PreparedStatement writeObjectId(IObjectId argId, PreparedStatement argStatement) throws SQLException {
/* 218 */     PayrollNotesId id = (PayrollNotesId)argId;
/* 219 */     argStatement.setLong(1, id.getOrganizationId().longValue());
/* 220 */     argStatement.setLong(2, id.getPartyId().longValue());
/* 221 */     argStatement.setTimestamp(3, new Timestamp(id.getWeekEndingDate().getTime()));
/* 222 */     argStatement.setLong(4, id.getNoteSeq().longValue());
/* 223 */     return argStatement;
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 227 */     PayrollNotesId id = new PayrollNotesId();
/* 228 */     id.setOrganizationId(this._organizationId);
/* 229 */     id.setPartyId(this._partyId);
/* 230 */     id.setWeekEndingDate(this._weekEndingDate);
/* 231 */     id.setNoteSeq(this._noteSeq);
/* 232 */     return (IObjectId)id;
/*     */   }
/*     */ 
/*     */   
/*     */   public void fill(IJDBCTableAdapter argAdapter) {}
/*     */ 
/*     */   
/*     */   public boolean isExtensible() {
/* 240 */     return false;
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 244 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\thr\impl\PayrollNotesDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */