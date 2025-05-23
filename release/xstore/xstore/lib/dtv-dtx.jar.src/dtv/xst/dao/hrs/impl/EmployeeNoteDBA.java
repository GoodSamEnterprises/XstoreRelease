/*     */ package dtv.xst.dao.hrs.impl;
/*     */ 
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.impl.jdbc.IFiller;
/*     */ import dtv.data2.access.impl.jdbc.IJDBCTableAdapter;
/*     */ import dtv.data2.access.impl.jdbc.JDBCHelper;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.hrs.EmployeeNoteId;
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
/*     */ public class EmployeeNoteDBA
/*     */   implements IJDBCTableAdapter
/*     */ {
/*     */   private static final long serialVersionUID = -1564190752L;
/*     */   private Long _organizationId;
/*     */   private String _employeeId;
/*     */   private Long _noteSequence;
/*     */   private Date _createDate;
/*     */   private String _createUserId;
/*     */   private Date _updateDate;
/*     */   private String _updateUserId;
/*     */   private String _note;
/*     */   private Date _noteTimeStamp;
/*     */   private Long _creatorPartyId;
/*     */   private static final String SELECT_OBJECT = "SELECT t.organization_id, t.employee_id, t.note_seq, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.note, t.note_timestamp, t.creator_party_id FROM hrs_employee_notes t";
/*     */   private static final String SELECT_WHERE_OBJECT = " WHERE organization_id = ?  AND employee_id = ?  AND note_seq = ?  ";
/*     */   
/*     */   public String getSelect() {
/*  39 */     return getSelectImpl();
/*     */   }
/*     */   
/*     */   private String getSelectImpl() {
/*  43 */     return "SELECT t.organization_id, t.employee_id, t.note_seq, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.note, t.note_timestamp, t.creator_party_id FROM hrs_employee_notes t";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectWhere() {
/*  49 */     return " WHERE organization_id = ?  AND employee_id = ?  AND note_seq = ?  ";
/*     */   }
/*     */   
/*  52 */   private static final String[] INSERT_OBJECT = new String[] { "INSERT INTO hrs_employee_notes(organization_id, employee_id, note_seq, create_date, create_user_id, update_date, update_user_id, note, note_timestamp, creator_party_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" };
/*     */   
/*     */   public String[] getInsert() {
/*  55 */     return INSERT_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getInsertParameters() {
/*  59 */     Object[][] insertParameterObject = { { this._organizationId, this._employeeId, this._noteSequence, this._createDate, this._createUserId, this._updateDate, this._updateUserId, this._note, this._noteTimeStamp, this._creatorPartyId } };
/*  60 */     return insertParameterObject;
/*     */   }
/*     */   
/*  63 */   private static final int[][] INSERT_PARAMETER_TYPES_OBJECT = new int[][] { { -5, 12, -5, 91, 12, 91, 12, 2005, 91, -5 } };
/*     */   
/*     */   public int[][] getInsertParameterTypes() {
/*  66 */     return INSERT_PARAMETER_TYPES_OBJECT;
/*     */   }
/*     */   
/*  69 */   private static final String[] UPDATE_OBJECT = new String[] { "UPDATE hrs_employee_notes SET update_date = ?, update_user_id = ?, note = ?, note_timestamp = ?, creator_party_id = ?" };
/*     */   
/*     */   public String[] getUpdate() {
/*  72 */     return UPDATE_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getUpdateParameters() {
/*  76 */     Object[][] updateParameterObject = { { this._updateDate, this._updateUserId, this._note, this._noteTimeStamp, this._creatorPartyId } };
/*  77 */     return updateParameterObject;
/*     */   }
/*     */   
/*  80 */   private static final int[][] UPDATE_PARAMETER_TYPE_OBJECT = new int[][] { { 91, 12, 2005, 91, -5 } };
/*     */   public int[][] getUpdateParameterTypes() {
/*  82 */     return UPDATE_PARAMETER_TYPE_OBJECT;
/*     */   }
/*     */   
/*  85 */   private static final String[] DELETE_OBJECT = new String[] { "DELETE FROM hrs_employee_notes" }; private static final String WHERE_OBJECT = " WHERE organization_id = ?  AND employee_id = ?  AND note_seq = ?  ";
/*     */   
/*     */   public String[] getDelete() {
/*  88 */     return DELETE_OBJECT;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWhere() {
/*  94 */     return " WHERE organization_id = ?  AND employee_id = ?  AND note_seq = ?  ";
/*     */   }
/*     */   public Object[] getWhereParameters() {
/*  97 */     return new Object[] { this._organizationId, this._employeeId, this._noteSequence };
/*     */   }
/*     */   
/* 100 */   private static final int[] WHERE_PARAMETER_OBJECT = new int[] { -5, 12, -5 };
/*     */   
/*     */   public int[] getWhereParameterTypes() {
/* 103 */     return WHERE_PARAMETER_OBJECT;
/*     */   }
/*     */   public String getTableName() {
/* 106 */     return "hrs_employee_notes";
/*     */   }
/*     */   
/*     */   public IFiller getFiller() {
/* 110 */     return getFillerImpl();
/*     */   }
/*     */   
/*     */   private IFiller getFillerImpl() {
/* 114 */     return new EmployeeNoteFiller(this);
/*     */   }
/*     */   
/*     */   private static class EmployeeNoteFiller
/*     */     implements IFiller {
/*     */     private EmployeeNoteDBA _parent;
/*     */     
/*     */     public EmployeeNoteFiller(EmployeeNoteDBA argParent) {
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
/* 133 */       this._parent._employeeId = argResultSet.getString(2);
/*     */ 
/*     */       
/* 136 */       primitiveResult = argResultSet.getLong(3);
/* 137 */       if (primitiveResult != 0L || argResultSet.getObject(3) != null) {
/* 138 */         this._parent._noteSequence = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 143 */       Timestamp t4 = argResultSet.getTimestamp(4);
/* 144 */       if (t4 != null) {
/* 145 */         this._parent._createDate = (Date)new DtvDate(t4.getTime());
/*     */       } else {
/*     */         
/* 148 */         this._parent._createDate = null;
/*     */       } 
/*     */       
/* 151 */       this._parent._createUserId = argResultSet.getString(5);
/*     */       
/* 153 */       Timestamp t6 = argResultSet.getTimestamp(6);
/* 154 */       if (t6 != null) {
/* 155 */         this._parent._updateDate = (Date)new DtvDate(t6.getTime());
/*     */       } else {
/*     */         
/* 158 */         this._parent._updateDate = null;
/*     */       } 
/*     */       
/* 161 */       this._parent._updateUserId = argResultSet.getString(7);
/*     */ 
/*     */       
/* 164 */       this._parent._note = JDBCHelper.clobToString(argResultSet, 8);
/*     */ 
/*     */       
/* 167 */       Timestamp t9 = argResultSet.getTimestamp(9);
/* 168 */       if (t9 != null) {
/* 169 */         this._parent._noteTimeStamp = (Date)new DtvDate(t9.getTime());
/*     */       } else {
/*     */         
/* 172 */         this._parent._noteTimeStamp = null;
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/* 177 */       long l1 = argResultSet.getLong(10);
/* 178 */       if (l1 != 0L || argResultSet.getObject(10) != null) {
/* 179 */         this._parent._creatorPartyId = Long.valueOf(l1);
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IDataAccessObject loadDAO(IDataAccessObject argDAO) {
/* 187 */     argDAO.suppressStateChanges(true);
/* 188 */     EmployeeNoteDAO dao = (EmployeeNoteDAO)argDAO;
/* 189 */     dao.setOrganizationId(this._organizationId);
/* 190 */     dao.setEmployeeId(this._employeeId);
/* 191 */     dao.setNoteSequence(this._noteSequence);
/* 192 */     dao.setCreateDate(this._createDate);
/* 193 */     dao.setCreateUserId(this._createUserId);
/* 194 */     dao.setUpdateDate(this._updateDate);
/* 195 */     dao.setUpdateUserId(this._updateUserId);
/* 196 */     dao.setNote(this._note);
/* 197 */     dao.setNoteTimeStamp(this._noteTimeStamp);
/* 198 */     dao.setCreatorPartyId(this._creatorPartyId);
/* 199 */     argDAO.suppressStateChanges(false);
/* 200 */     return (IDataAccessObject)dao;
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDefaultDAO() {
/* 204 */     return loadDAO((IDataAccessObject)new EmployeeNoteDAO());
/*     */   }
/*     */   
/*     */   public void fill(IDataAccessObject argDAO) {
/* 208 */     EmployeeNoteDAO dao = (EmployeeNoteDAO)argDAO;
/* 209 */     this._organizationId = dao.getOrganizationId();
/* 210 */     this._employeeId = dao.getEmployeeId();
/* 211 */     this._noteSequence = dao.getNoteSequence();
/* 212 */     this._createDate = dao.getCreateDate();
/* 213 */     this._createUserId = dao.getCreateUserId();
/* 214 */     this._updateDate = dao.getUpdateDate();
/* 215 */     this._updateUserId = dao.getUpdateUserId();
/* 216 */     this._note = dao.getNote();
/* 217 */     this._noteTimeStamp = dao.getNoteTimeStamp();
/* 218 */     this._creatorPartyId = dao.getCreatorPartyId();
/*     */   }
/*     */   
/*     */   public PreparedStatement writeObjectId(IObjectId argId, PreparedStatement argStatement) throws SQLException {
/* 222 */     EmployeeNoteId id = (EmployeeNoteId)argId;
/* 223 */     argStatement.setLong(1, id.getOrganizationId().longValue());
/* 224 */     argStatement.setString(2, id.getEmployeeId());
/* 225 */     argStatement.setLong(3, id.getNoteSequence().longValue());
/* 226 */     return argStatement;
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 230 */     EmployeeNoteId id = new EmployeeNoteId();
/* 231 */     id.setOrganizationId(this._organizationId);
/* 232 */     id.setEmployeeId(this._employeeId);
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


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\hrs\impl\EmployeeNoteDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */