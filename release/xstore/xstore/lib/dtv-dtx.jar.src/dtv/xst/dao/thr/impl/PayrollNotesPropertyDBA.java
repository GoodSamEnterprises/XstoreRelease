/*     */ package dtv.xst.dao.thr.impl;
/*     */ 
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.impl.jdbc.IFiller;
/*     */ import dtv.data2.access.impl.jdbc.IJDBCTableAdapter;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.thr.PayrollNotesPropertyId;
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
/*     */ public class PayrollNotesPropertyDBA
/*     */   implements IJDBCTableAdapter
/*     */ {
/*     */   private static final long serialVersionUID = 1661946545L;
/*     */   private Long _organizationId;
/*     */   private Long _partyId;
/*     */   private Date _weekEndingDate;
/*     */   private Long _noteSeq;
/*     */   private String _propertyCode;
/*     */   private String _type;
/*     */   private String _stringValue;
/*     */   private Date _dateValue;
/*     */   private BigDecimal _decimalValue;
/*     */   private Date _createDate;
/*     */   private String _createUserId;
/*     */   private Date _updateDate;
/*     */   private String _updateUserId;
/*     */   private static final String SELECT_OBJECT = "SELECT t.organization_id, t.party_id, t.week_ending_date, t.note_seq, t.property_code, t.type, t.string_value, t.date_value, t.decimal_value, t.create_date, t.create_user_id, t.update_date, t.update_user_id FROM thr_payroll_notes_p t";
/*     */   private static final String SELECT_WHERE_OBJECT = " WHERE organization_id = ?  AND party_id = ?  AND week_ending_date = ?  AND note_seq = ?  AND property_code = ?  ";
/*     */   
/*     */   public String getSelect() {
/*  42 */     return getSelectImpl();
/*     */   }
/*     */   
/*     */   private String getSelectImpl() {
/*  46 */     return "SELECT t.organization_id, t.party_id, t.week_ending_date, t.note_seq, t.property_code, t.type, t.string_value, t.date_value, t.decimal_value, t.create_date, t.create_user_id, t.update_date, t.update_user_id FROM thr_payroll_notes_p t";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectWhere() {
/*  52 */     return " WHERE organization_id = ?  AND party_id = ?  AND week_ending_date = ?  AND note_seq = ?  AND property_code = ?  ";
/*     */   }
/*     */   
/*  55 */   private static final String[] INSERT_OBJECT = new String[] { "INSERT INTO thr_payroll_notes_p(organization_id, party_id, week_ending_date, note_seq, property_code, type, string_value, date_value, decimal_value, create_date, create_user_id, update_date, update_user_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" };
/*     */   
/*     */   public String[] getInsert() {
/*  58 */     return INSERT_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getInsertParameters() {
/*  62 */     Object[][] insertParameterObject = { { this._organizationId, this._partyId, this._weekEndingDate, this._noteSeq, this._propertyCode, this._type, this._stringValue, this._dateValue, this._decimalValue, this._createDate, this._createUserId, this._updateDate, this._updateUserId } };
/*  63 */     return insertParameterObject;
/*     */   }
/*     */   
/*  66 */   private static final int[][] INSERT_PARAMETER_TYPES_OBJECT = new int[][] { { -5, -5, 91, -5, 12, 12, 12, 91, 3, 91, 12, 91, 12 } };
/*     */   
/*     */   public int[][] getInsertParameterTypes() {
/*  69 */     return INSERT_PARAMETER_TYPES_OBJECT;
/*     */   }
/*     */   
/*  72 */   private static final String[] UPDATE_OBJECT = new String[] { "UPDATE thr_payroll_notes_p SET type = ?, string_value = ?, date_value = ?, decimal_value = ?, update_date = ?, update_user_id = ?" };
/*     */   
/*     */   public String[] getUpdate() {
/*  75 */     return UPDATE_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getUpdateParameters() {
/*  79 */     Object[][] updateParameterObject = { { this._type, this._stringValue, this._dateValue, this._decimalValue, this._updateDate, this._updateUserId } };
/*  80 */     return updateParameterObject;
/*     */   }
/*     */   
/*  83 */   private static final int[][] UPDATE_PARAMETER_TYPE_OBJECT = new int[][] { { 12, 12, 91, 3, 91, 12 } };
/*     */   public int[][] getUpdateParameterTypes() {
/*  85 */     return UPDATE_PARAMETER_TYPE_OBJECT;
/*     */   }
/*     */   
/*  88 */   private static final String[] DELETE_OBJECT = new String[] { "DELETE FROM thr_payroll_notes_p" }; private static final String WHERE_OBJECT = " WHERE organization_id = ?  AND party_id = ?  AND week_ending_date = ?  AND note_seq = ?  AND property_code = ?  ";
/*     */   
/*     */   public String[] getDelete() {
/*  91 */     return DELETE_OBJECT;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWhere() {
/*  97 */     return " WHERE organization_id = ?  AND party_id = ?  AND week_ending_date = ?  AND note_seq = ?  AND property_code = ?  ";
/*     */   }
/*     */   public Object[] getWhereParameters() {
/* 100 */     return new Object[] { this._organizationId, this._partyId, this._weekEndingDate, this._noteSeq, this._propertyCode };
/*     */   }
/*     */   
/* 103 */   private static final int[] WHERE_PARAMETER_OBJECT = new int[] { -5, -5, 91, -5, 12 };
/*     */   
/*     */   public int[] getWhereParameterTypes() {
/* 106 */     return WHERE_PARAMETER_OBJECT;
/*     */   }
/*     */   public String getTableName() {
/* 109 */     return "thr_payroll_notes_p";
/*     */   }
/*     */   
/*     */   public IFiller getFiller() {
/* 113 */     return getFillerImpl();
/*     */   }
/*     */   
/*     */   private IFiller getFillerImpl() {
/* 117 */     return new PayrollNotesPropertyFiller(this);
/*     */   }
/*     */   
/*     */   private static class PayrollNotesPropertyFiller
/*     */     implements IFiller {
/*     */     private PayrollNotesPropertyDBA _parent;
/*     */     
/*     */     public PayrollNotesPropertyFiller(PayrollNotesPropertyDBA argParent) {
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
/* 140 */         this._parent._partyId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 145 */       Timestamp t3 = argResultSet.getTimestamp(3);
/* 146 */       if (t3 != null) {
/* 147 */         this._parent._weekEndingDate = (Date)new DtvDate(t3.getTime());
/*     */       } else {
/*     */         
/* 150 */         this._parent._weekEndingDate = null;
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/* 155 */       long l1 = argResultSet.getLong(4);
/* 156 */       if (l1 != 0L || argResultSet.getObject(4) != null) {
/* 157 */         this._parent._noteSeq = Long.valueOf(l1);
/*     */       }
/*     */ 
/*     */       
/* 161 */       this._parent._propertyCode = argResultSet.getString(5);
/* 162 */       this._parent._type = argResultSet.getString(6);
/* 163 */       this._parent._stringValue = argResultSet.getString(7);
/*     */       
/* 165 */       Timestamp t8 = argResultSet.getTimestamp(8);
/* 166 */       if (t8 != null) {
/* 167 */         this._parent._dateValue = (Date)new DtvDate(t8.getTime());
/*     */       } else {
/*     */         
/* 170 */         this._parent._dateValue = null;
/*     */       } 
/*     */       
/* 173 */       this._parent._decimalValue = argResultSet.getBigDecimal(9);
/*     */       
/* 175 */       Timestamp t10 = argResultSet.getTimestamp(10);
/* 176 */       if (t10 != null) {
/* 177 */         this._parent._createDate = (Date)new DtvDate(t10.getTime());
/*     */       } else {
/*     */         
/* 180 */         this._parent._createDate = null;
/*     */       } 
/*     */       
/* 183 */       this._parent._createUserId = argResultSet.getString(11);
/*     */       
/* 185 */       Timestamp t12 = argResultSet.getTimestamp(12);
/* 186 */       if (t12 != null) {
/* 187 */         this._parent._updateDate = (Date)new DtvDate(t12.getTime());
/*     */       } else {
/*     */         
/* 190 */         this._parent._updateDate = null;
/*     */       } 
/*     */       
/* 193 */       this._parent._updateUserId = argResultSet.getString(13);
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDAO(IDataAccessObject argDAO) {
/* 198 */     argDAO.suppressStateChanges(true);
/* 199 */     PayrollNotesPropertyDAO dao = (PayrollNotesPropertyDAO)argDAO;
/* 200 */     dao.setOrganizationId(this._organizationId);
/* 201 */     dao.setPartyId(this._partyId);
/* 202 */     dao.setWeekEndingDate(this._weekEndingDate);
/* 203 */     dao.setNoteSeq(this._noteSeq);
/* 204 */     dao.setPropertyCode(this._propertyCode);
/* 205 */     dao.setType(this._type);
/* 206 */     dao.setStringValue(this._stringValue);
/* 207 */     dao.setDateValue(this._dateValue);
/* 208 */     dao.setDecimalValue(this._decimalValue);
/* 209 */     dao.setCreateDate(this._createDate);
/* 210 */     dao.setCreateUserId(this._createUserId);
/* 211 */     dao.setUpdateDate(this._updateDate);
/* 212 */     dao.setUpdateUserId(this._updateUserId);
/* 213 */     argDAO.suppressStateChanges(false);
/* 214 */     return (IDataAccessObject)dao;
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDefaultDAO() {
/* 218 */     return loadDAO((IDataAccessObject)new PayrollNotesPropertyDAO());
/*     */   }
/*     */   
/*     */   public void fill(IDataAccessObject argDAO) {
/* 222 */     PayrollNotesPropertyDAO dao = (PayrollNotesPropertyDAO)argDAO;
/* 223 */     this._organizationId = dao.getOrganizationId();
/* 224 */     this._partyId = dao.getPartyId();
/* 225 */     this._weekEndingDate = dao.getWeekEndingDate();
/* 226 */     this._noteSeq = dao.getNoteSeq();
/* 227 */     this._propertyCode = dao.getPropertyCode();
/* 228 */     this._type = dao.getType();
/* 229 */     this._stringValue = dao.getStringValue();
/* 230 */     this._dateValue = dao.getDateValue();
/* 231 */     this._decimalValue = dao.getDecimalValue();
/* 232 */     this._createDate = dao.getCreateDate();
/* 233 */     this._createUserId = dao.getCreateUserId();
/* 234 */     this._updateDate = dao.getUpdateDate();
/* 235 */     this._updateUserId = dao.getUpdateUserId();
/*     */   }
/*     */   
/*     */   public PreparedStatement writeObjectId(IObjectId argId, PreparedStatement argStatement) throws SQLException {
/* 239 */     PayrollNotesPropertyId id = (PayrollNotesPropertyId)argId;
/* 240 */     argStatement.setLong(1, id.getOrganizationId().longValue());
/* 241 */     argStatement.setLong(2, id.getPartyId().longValue());
/* 242 */     argStatement.setTimestamp(3, new Timestamp(id.getWeekEndingDate().getTime()));
/* 243 */     argStatement.setLong(4, id.getNoteSeq().longValue());
/* 244 */     argStatement.setString(5, id.getPropertyCode());
/* 245 */     return argStatement;
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 249 */     PayrollNotesPropertyId id = new PayrollNotesPropertyId();
/* 250 */     id.setOrganizationId(this._organizationId);
/* 251 */     id.setPartyId(this._partyId);
/* 252 */     id.setWeekEndingDate(this._weekEndingDate);
/* 253 */     id.setNoteSeq(this._noteSeq);
/* 254 */     id.setPropertyCode(this._propertyCode);
/* 255 */     return (IObjectId)id;
/*     */   }
/*     */ 
/*     */   
/*     */   public void fill(IJDBCTableAdapter argAdapter) {}
/*     */ 
/*     */   
/*     */   public boolean isExtensible() {
/* 263 */     return false;
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 267 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\thr\impl\PayrollNotesPropertyDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */