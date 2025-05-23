/*     */ package dtv.xst.dao.hrs.impl;
/*     */ 
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.impl.jdbc.IFiller;
/*     */ import dtv.data2.access.impl.jdbc.IJDBCTableAdapter;
/*     */ import dtv.data2.access.impl.jdbc.JDBCHelper;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.hrs.EmployeeTaskNoteId;
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
/*     */ public class EmployeeTaskNoteDBA
/*     */   implements IJDBCTableAdapter
/*     */ {
/*     */   private static final long serialVersionUID = 9048069L;
/*     */   private Long _organizationId;
/*     */   private Long _retailLocationId;
/*     */   private Long _taskId;
/*     */   private Long _noteSequence;
/*     */   private Date _createDate;
/*     */   private String _createUserId;
/*     */   private Date _updateDate;
/*     */   private String _updateUserId;
/*     */   private String _note;
/*     */   private Date _noteTimeStamp;
/*     */   private Long _creatorPartyId;
/*     */   private static final String SELECT_OBJECT = "SELECT t.organization_id, t.rtl_loc_id, t.task_id, t.note_seq, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.note, t.note_timestamp, t.creator_party_id FROM hrs_employee_task_notes t";
/*     */   private static final String SELECT_WHERE_OBJECT = " WHERE organization_id = ?  AND rtl_loc_id = ?  AND task_id = ?  AND note_seq = ?  ";
/*     */   
/*     */   public String getSelect() {
/*  40 */     return getSelectImpl();
/*     */   }
/*     */   
/*     */   private String getSelectImpl() {
/*  44 */     return "SELECT t.organization_id, t.rtl_loc_id, t.task_id, t.note_seq, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.note, t.note_timestamp, t.creator_party_id FROM hrs_employee_task_notes t";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectWhere() {
/*  50 */     return " WHERE organization_id = ?  AND rtl_loc_id = ?  AND task_id = ?  AND note_seq = ?  ";
/*     */   }
/*     */   
/*  53 */   private static final String[] INSERT_OBJECT = new String[] { "INSERT INTO hrs_employee_task_notes(organization_id, rtl_loc_id, task_id, note_seq, create_date, create_user_id, update_date, update_user_id, note, note_timestamp, creator_party_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" };
/*     */   
/*     */   public String[] getInsert() {
/*  56 */     return INSERT_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getInsertParameters() {
/*  60 */     Object[][] insertParameterObject = { { this._organizationId, this._retailLocationId, this._taskId, this._noteSequence, this._createDate, this._createUserId, this._updateDate, this._updateUserId, this._note, this._noteTimeStamp, this._creatorPartyId } };
/*  61 */     return insertParameterObject;
/*     */   }
/*     */   
/*  64 */   private static final int[][] INSERT_PARAMETER_TYPES_OBJECT = new int[][] { { -5, -5, -5, -5, 91, 12, 91, 12, 2005, 91, -5 } };
/*     */   
/*     */   public int[][] getInsertParameterTypes() {
/*  67 */     return INSERT_PARAMETER_TYPES_OBJECT;
/*     */   }
/*     */   
/*  70 */   private static final String[] UPDATE_OBJECT = new String[] { "UPDATE hrs_employee_task_notes SET update_date = ?, update_user_id = ?, note = ?, note_timestamp = ?, creator_party_id = ?" };
/*     */   
/*     */   public String[] getUpdate() {
/*  73 */     return UPDATE_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getUpdateParameters() {
/*  77 */     Object[][] updateParameterObject = { { this._updateDate, this._updateUserId, this._note, this._noteTimeStamp, this._creatorPartyId } };
/*  78 */     return updateParameterObject;
/*     */   }
/*     */   
/*  81 */   private static final int[][] UPDATE_PARAMETER_TYPE_OBJECT = new int[][] { { 91, 12, 2005, 91, -5 } };
/*     */   public int[][] getUpdateParameterTypes() {
/*  83 */     return UPDATE_PARAMETER_TYPE_OBJECT;
/*     */   }
/*     */   
/*  86 */   private static final String[] DELETE_OBJECT = new String[] { "DELETE FROM hrs_employee_task_notes" }; private static final String WHERE_OBJECT = " WHERE organization_id = ?  AND rtl_loc_id = ?  AND task_id = ?  AND note_seq = ?  ";
/*     */   
/*     */   public String[] getDelete() {
/*  89 */     return DELETE_OBJECT;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWhere() {
/*  95 */     return " WHERE organization_id = ?  AND rtl_loc_id = ?  AND task_id = ?  AND note_seq = ?  ";
/*     */   }
/*     */   public Object[] getWhereParameters() {
/*  98 */     return new Object[] { this._organizationId, this._retailLocationId, this._taskId, this._noteSequence };
/*     */   }
/*     */   
/* 101 */   private static final int[] WHERE_PARAMETER_OBJECT = new int[] { -5, -5, -5, -5 };
/*     */   
/*     */   public int[] getWhereParameterTypes() {
/* 104 */     return WHERE_PARAMETER_OBJECT;
/*     */   }
/*     */   public String getTableName() {
/* 107 */     return "hrs_employee_task_notes";
/*     */   }
/*     */   
/*     */   public IFiller getFiller() {
/* 111 */     return getFillerImpl();
/*     */   }
/*     */   
/*     */   private IFiller getFillerImpl() {
/* 115 */     return new EmployeeTaskNoteFiller(this);
/*     */   }
/*     */   
/*     */   private static class EmployeeTaskNoteFiller
/*     */     implements IFiller {
/*     */     private EmployeeTaskNoteDBA _parent;
/*     */     
/*     */     public EmployeeTaskNoteFiller(EmployeeTaskNoteDBA argParent) {
/* 123 */       this._parent = argParent;
/*     */     }
/*     */ 
/*     */     
/*     */     public void fill(ResultSet argResultSet) throws SQLException {
/* 128 */       long primitiveResult = argResultSet.getLong(1);
/* 129 */       if (primitiveResult != 0L || argResultSet.getObject(1) != null) {
/* 130 */         this._parent._organizationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 136 */       primitiveResult = argResultSet.getLong(2);
/* 137 */       if (primitiveResult != 0L || argResultSet.getObject(2) != null) {
/* 138 */         this._parent._retailLocationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 144 */       primitiveResult = argResultSet.getLong(3);
/* 145 */       if (primitiveResult != 0L || argResultSet.getObject(3) != null) {
/* 146 */         this._parent._taskId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 152 */       primitiveResult = argResultSet.getLong(4);
/* 153 */       if (primitiveResult != 0L || argResultSet.getObject(4) != null) {
/* 154 */         this._parent._noteSequence = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 159 */       Timestamp t5 = argResultSet.getTimestamp(5);
/* 160 */       if (t5 != null) {
/* 161 */         this._parent._createDate = (Date)new DtvDate(t5.getTime());
/*     */       } else {
/*     */         
/* 164 */         this._parent._createDate = null;
/*     */       } 
/*     */       
/* 167 */       this._parent._createUserId = argResultSet.getString(6);
/*     */       
/* 169 */       Timestamp t7 = argResultSet.getTimestamp(7);
/* 170 */       if (t7 != null) {
/* 171 */         this._parent._updateDate = (Date)new DtvDate(t7.getTime());
/*     */       } else {
/*     */         
/* 174 */         this._parent._updateDate = null;
/*     */       } 
/*     */       
/* 177 */       this._parent._updateUserId = argResultSet.getString(8);
/*     */ 
/*     */       
/* 180 */       this._parent._note = JDBCHelper.clobToString(argResultSet, 9);
/*     */ 
/*     */       
/* 183 */       Timestamp t10 = argResultSet.getTimestamp(10);
/* 184 */       if (t10 != null) {
/* 185 */         this._parent._noteTimeStamp = (Date)new DtvDate(t10.getTime());
/*     */       } else {
/*     */         
/* 188 */         this._parent._noteTimeStamp = null;
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/* 193 */       long l1 = argResultSet.getLong(11);
/* 194 */       if (l1 != 0L || argResultSet.getObject(11) != null) {
/* 195 */         this._parent._creatorPartyId = Long.valueOf(l1);
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IDataAccessObject loadDAO(IDataAccessObject argDAO) {
/* 203 */     argDAO.suppressStateChanges(true);
/* 204 */     EmployeeTaskNoteDAO dao = (EmployeeTaskNoteDAO)argDAO;
/* 205 */     dao.setOrganizationId(this._organizationId);
/* 206 */     dao.setRetailLocationId(this._retailLocationId);
/* 207 */     dao.setTaskId(this._taskId);
/* 208 */     dao.setNoteSequence(this._noteSequence);
/* 209 */     dao.setCreateDate(this._createDate);
/* 210 */     dao.setCreateUserId(this._createUserId);
/* 211 */     dao.setUpdateDate(this._updateDate);
/* 212 */     dao.setUpdateUserId(this._updateUserId);
/* 213 */     dao.setNote(this._note);
/* 214 */     dao.setNoteTimeStamp(this._noteTimeStamp);
/* 215 */     dao.setCreatorPartyId(this._creatorPartyId);
/* 216 */     argDAO.suppressStateChanges(false);
/* 217 */     return (IDataAccessObject)dao;
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDefaultDAO() {
/* 221 */     return loadDAO((IDataAccessObject)new EmployeeTaskNoteDAO());
/*     */   }
/*     */   
/*     */   public void fill(IDataAccessObject argDAO) {
/* 225 */     EmployeeTaskNoteDAO dao = (EmployeeTaskNoteDAO)argDAO;
/* 226 */     this._organizationId = dao.getOrganizationId();
/* 227 */     this._retailLocationId = dao.getRetailLocationId();
/* 228 */     this._taskId = dao.getTaskId();
/* 229 */     this._noteSequence = dao.getNoteSequence();
/* 230 */     this._createDate = dao.getCreateDate();
/* 231 */     this._createUserId = dao.getCreateUserId();
/* 232 */     this._updateDate = dao.getUpdateDate();
/* 233 */     this._updateUserId = dao.getUpdateUserId();
/* 234 */     this._note = dao.getNote();
/* 235 */     this._noteTimeStamp = dao.getNoteTimeStamp();
/* 236 */     this._creatorPartyId = dao.getCreatorPartyId();
/*     */   }
/*     */   
/*     */   public PreparedStatement writeObjectId(IObjectId argId, PreparedStatement argStatement) throws SQLException {
/* 240 */     EmployeeTaskNoteId id = (EmployeeTaskNoteId)argId;
/* 241 */     argStatement.setLong(1, id.getOrganizationId().longValue());
/* 242 */     argStatement.setLong(2, id.getRetailLocationId().longValue());
/* 243 */     argStatement.setLong(3, id.getTaskId().longValue());
/* 244 */     argStatement.setLong(4, id.getNoteSequence().longValue());
/* 245 */     return argStatement;
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 249 */     EmployeeTaskNoteId id = new EmployeeTaskNoteId();
/* 250 */     id.setOrganizationId(this._organizationId);
/* 251 */     id.setRetailLocationId(this._retailLocationId);
/* 252 */     id.setTaskId(this._taskId);
/* 253 */     id.setNoteSequence(this._noteSequence);
/* 254 */     return (IObjectId)id;
/*     */   }
/*     */ 
/*     */   
/*     */   public void fill(IJDBCTableAdapter argAdapter) {}
/*     */ 
/*     */   
/*     */   public boolean isExtensible() {
/* 262 */     return false;
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 266 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\hrs\impl\EmployeeTaskNoteDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */