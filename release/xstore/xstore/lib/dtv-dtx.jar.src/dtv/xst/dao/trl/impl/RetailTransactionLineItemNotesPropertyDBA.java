/*     */ package dtv.xst.dao.trl.impl;
/*     */ 
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.impl.jdbc.IFiller;
/*     */ import dtv.data2.access.impl.jdbc.IJDBCTableAdapter;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.trl.RetailTransactionLineItemNotesPropertyId;
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
/*     */ public class RetailTransactionLineItemNotesPropertyDBA
/*     */   implements IJDBCTableAdapter
/*     */ {
/*     */   private static final long serialVersionUID = 1408101076L;
/*     */   private Date _businessDate;
/*     */   private Long _organizationId;
/*     */   private Long _retailLocationId;
/*     */   private Integer _retailTransactionLineItemSequence;
/*     */   private Long _transactionSequence;
/*     */   private Long _workstationId;
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
/*     */   private static final String SELECT_OBJECT = "SELECT t.business_date, t.organization_id, t.rtl_loc_id, t.rtrans_lineitm_seq, t.trans_seq, t.wkstn_id, t.note_seq, t.property_code, t.type, t.string_value, t.date_value, t.decimal_value, t.create_date, t.create_user_id, t.update_date, t.update_user_id FROM trl_lineitm_notes_p t";
/*     */   private static final String SELECT_WHERE_OBJECT = " WHERE business_date = ?  AND organization_id = ?  AND rtl_loc_id = ?  AND rtrans_lineitm_seq = ?  AND trans_seq = ?  AND wkstn_id = ?  AND note_seq = ?  AND property_code = ?  ";
/*     */   
/*     */   public String getSelect() {
/*  45 */     return getSelectImpl();
/*     */   }
/*     */   
/*     */   private String getSelectImpl() {
/*  49 */     return "SELECT t.business_date, t.organization_id, t.rtl_loc_id, t.rtrans_lineitm_seq, t.trans_seq, t.wkstn_id, t.note_seq, t.property_code, t.type, t.string_value, t.date_value, t.decimal_value, t.create_date, t.create_user_id, t.update_date, t.update_user_id FROM trl_lineitm_notes_p t";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectWhere() {
/*  55 */     return " WHERE business_date = ?  AND organization_id = ?  AND rtl_loc_id = ?  AND rtrans_lineitm_seq = ?  AND trans_seq = ?  AND wkstn_id = ?  AND note_seq = ?  AND property_code = ?  ";
/*     */   }
/*     */   
/*  58 */   private static final String[] INSERT_OBJECT = new String[] { "INSERT INTO trl_lineitm_notes_p(business_date, organization_id, rtl_loc_id, rtrans_lineitm_seq, trans_seq, wkstn_id, note_seq, property_code, type, string_value, date_value, decimal_value, create_date, create_user_id, update_date, update_user_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" };
/*     */   
/*     */   public String[] getInsert() {
/*  61 */     return INSERT_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getInsertParameters() {
/*  65 */     Object[][] insertParameterObject = { { this._businessDate, this._organizationId, this._retailLocationId, this._retailTransactionLineItemSequence, this._transactionSequence, this._workstationId, this._noteSeq, this._propertyCode, this._type, this._stringValue, this._dateValue, this._decimalValue, this._createDate, this._createUserId, this._updateDate, this._updateUserId } };
/*  66 */     return insertParameterObject;
/*     */   }
/*     */   
/*  69 */   private static final int[][] INSERT_PARAMETER_TYPES_OBJECT = new int[][] { { 91, -5, -5, 4, -5, -5, -5, 12, 12, 12, 91, 3, 91, 12, 91, 12 } };
/*     */   
/*     */   public int[][] getInsertParameterTypes() {
/*  72 */     return INSERT_PARAMETER_TYPES_OBJECT;
/*     */   }
/*     */   
/*  75 */   private static final String[] UPDATE_OBJECT = new String[] { "UPDATE trl_lineitm_notes_p SET type = ?, string_value = ?, date_value = ?, decimal_value = ?, update_date = ?, update_user_id = ?" };
/*     */   
/*     */   public String[] getUpdate() {
/*  78 */     return UPDATE_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getUpdateParameters() {
/*  82 */     Object[][] updateParameterObject = { { this._type, this._stringValue, this._dateValue, this._decimalValue, this._updateDate, this._updateUserId } };
/*  83 */     return updateParameterObject;
/*     */   }
/*     */   
/*  86 */   private static final int[][] UPDATE_PARAMETER_TYPE_OBJECT = new int[][] { { 12, 12, 91, 3, 91, 12 } };
/*     */   public int[][] getUpdateParameterTypes() {
/*  88 */     return UPDATE_PARAMETER_TYPE_OBJECT;
/*     */   }
/*     */   
/*  91 */   private static final String[] DELETE_OBJECT = new String[] { "DELETE FROM trl_lineitm_notes_p" }; private static final String WHERE_OBJECT = " WHERE business_date = ?  AND organization_id = ?  AND rtl_loc_id = ?  AND rtrans_lineitm_seq = ?  AND trans_seq = ?  AND wkstn_id = ?  AND note_seq = ?  AND property_code = ?  ";
/*     */   
/*     */   public String[] getDelete() {
/*  94 */     return DELETE_OBJECT;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWhere() {
/* 100 */     return " WHERE business_date = ?  AND organization_id = ?  AND rtl_loc_id = ?  AND rtrans_lineitm_seq = ?  AND trans_seq = ?  AND wkstn_id = ?  AND note_seq = ?  AND property_code = ?  ";
/*     */   }
/*     */   public Object[] getWhereParameters() {
/* 103 */     return new Object[] { this._businessDate, this._organizationId, this._retailLocationId, this._retailTransactionLineItemSequence, this._transactionSequence, this._workstationId, this._noteSeq, this._propertyCode };
/*     */   }
/*     */   
/* 106 */   private static final int[] WHERE_PARAMETER_OBJECT = new int[] { 91, -5, -5, 4, -5, -5, -5, 12 };
/*     */   
/*     */   public int[] getWhereParameterTypes() {
/* 109 */     return WHERE_PARAMETER_OBJECT;
/*     */   }
/*     */   public String getTableName() {
/* 112 */     return "trl_lineitm_notes_p";
/*     */   }
/*     */   
/*     */   public IFiller getFiller() {
/* 116 */     return getFillerImpl();
/*     */   }
/*     */   
/*     */   private IFiller getFillerImpl() {
/* 120 */     return new RetailTransactionLineItemNotesPropertyFiller(this);
/*     */   }
/*     */   
/*     */   private static class RetailTransactionLineItemNotesPropertyFiller
/*     */     implements IFiller {
/*     */     private RetailTransactionLineItemNotesPropertyDBA _parent;
/*     */     
/*     */     public RetailTransactionLineItemNotesPropertyFiller(RetailTransactionLineItemNotesPropertyDBA argParent) {
/* 128 */       this._parent = argParent;
/*     */     }
/*     */     
/*     */     public void fill(ResultSet argResultSet) throws SQLException {
/* 132 */       Timestamp t1 = argResultSet.getTimestamp(1);
/* 133 */       if (t1 != null) {
/* 134 */         this._parent._businessDate = (Date)new DtvDate(t1.getTime());
/*     */       } else {
/*     */         
/* 137 */         this._parent._businessDate = null;
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/* 142 */       long l1 = argResultSet.getLong(2);
/* 143 */       if (l1 != 0L || argResultSet.getObject(2) != null) {
/* 144 */         this._parent._organizationId = Long.valueOf(l1);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 150 */       l1 = argResultSet.getLong(3);
/* 151 */       if (l1 != 0L || argResultSet.getObject(3) != null) {
/* 152 */         this._parent._retailLocationId = Long.valueOf(l1);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 158 */       int i = argResultSet.getInt(4);
/* 159 */       if (i != 0 || argResultSet.getObject(4) != null) {
/* 160 */         this._parent._retailTransactionLineItemSequence = Integer.valueOf(i);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 166 */       long primitiveResult = argResultSet.getLong(5);
/* 167 */       if (primitiveResult != 0L || argResultSet.getObject(5) != null) {
/* 168 */         this._parent._transactionSequence = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 174 */       primitiveResult = argResultSet.getLong(6);
/* 175 */       if (primitiveResult != 0L || argResultSet.getObject(6) != null) {
/* 176 */         this._parent._workstationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 182 */       primitiveResult = argResultSet.getLong(7);
/* 183 */       if (primitiveResult != 0L || argResultSet.getObject(7) != null) {
/* 184 */         this._parent._noteSeq = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */       
/* 188 */       this._parent._propertyCode = argResultSet.getString(8);
/* 189 */       this._parent._type = argResultSet.getString(9);
/* 190 */       this._parent._stringValue = argResultSet.getString(10);
/*     */       
/* 192 */       Timestamp t11 = argResultSet.getTimestamp(11);
/* 193 */       if (t11 != null) {
/* 194 */         this._parent._dateValue = (Date)new DtvDate(t11.getTime());
/*     */       } else {
/*     */         
/* 197 */         this._parent._dateValue = null;
/*     */       } 
/*     */       
/* 200 */       this._parent._decimalValue = argResultSet.getBigDecimal(12);
/*     */       
/* 202 */       Timestamp t13 = argResultSet.getTimestamp(13);
/* 203 */       if (t13 != null) {
/* 204 */         this._parent._createDate = (Date)new DtvDate(t13.getTime());
/*     */       } else {
/*     */         
/* 207 */         this._parent._createDate = null;
/*     */       } 
/*     */       
/* 210 */       this._parent._createUserId = argResultSet.getString(14);
/*     */       
/* 212 */       Timestamp t15 = argResultSet.getTimestamp(15);
/* 213 */       if (t15 != null) {
/* 214 */         this._parent._updateDate = (Date)new DtvDate(t15.getTime());
/*     */       } else {
/*     */         
/* 217 */         this._parent._updateDate = null;
/*     */       } 
/*     */       
/* 220 */       this._parent._updateUserId = argResultSet.getString(16);
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDAO(IDataAccessObject argDAO) {
/* 225 */     argDAO.suppressStateChanges(true);
/* 226 */     RetailTransactionLineItemNotesPropertyDAO dao = (RetailTransactionLineItemNotesPropertyDAO)argDAO;
/* 227 */     dao.setBusinessDate(this._businessDate);
/* 228 */     dao.setOrganizationId(this._organizationId);
/* 229 */     dao.setRetailLocationId(this._retailLocationId);
/* 230 */     dao.setRetailTransactionLineItemSequence(this._retailTransactionLineItemSequence);
/* 231 */     dao.setTransactionSequence(this._transactionSequence);
/* 232 */     dao.setWorkstationId(this._workstationId);
/* 233 */     dao.setNoteSeq(this._noteSeq);
/* 234 */     dao.setPropertyCode(this._propertyCode);
/* 235 */     dao.setType(this._type);
/* 236 */     dao.setStringValue(this._stringValue);
/* 237 */     dao.setDateValue(this._dateValue);
/* 238 */     dao.setDecimalValue(this._decimalValue);
/* 239 */     dao.setCreateDate(this._createDate);
/* 240 */     dao.setCreateUserId(this._createUserId);
/* 241 */     dao.setUpdateDate(this._updateDate);
/* 242 */     dao.setUpdateUserId(this._updateUserId);
/* 243 */     argDAO.suppressStateChanges(false);
/* 244 */     return (IDataAccessObject)dao;
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDefaultDAO() {
/* 248 */     return loadDAO((IDataAccessObject)new RetailTransactionLineItemNotesPropertyDAO());
/*     */   }
/*     */   
/*     */   public void fill(IDataAccessObject argDAO) {
/* 252 */     RetailTransactionLineItemNotesPropertyDAO dao = (RetailTransactionLineItemNotesPropertyDAO)argDAO;
/* 253 */     this._businessDate = dao.getBusinessDate();
/* 254 */     this._organizationId = dao.getOrganizationId();
/* 255 */     this._retailLocationId = dao.getRetailLocationId();
/* 256 */     this._retailTransactionLineItemSequence = dao.getRetailTransactionLineItemSequence();
/* 257 */     this._transactionSequence = dao.getTransactionSequence();
/* 258 */     this._workstationId = dao.getWorkstationId();
/* 259 */     this._noteSeq = dao.getNoteSeq();
/* 260 */     this._propertyCode = dao.getPropertyCode();
/* 261 */     this._type = dao.getType();
/* 262 */     this._stringValue = dao.getStringValue();
/* 263 */     this._dateValue = dao.getDateValue();
/* 264 */     this._decimalValue = dao.getDecimalValue();
/* 265 */     this._createDate = dao.getCreateDate();
/* 266 */     this._createUserId = dao.getCreateUserId();
/* 267 */     this._updateDate = dao.getUpdateDate();
/* 268 */     this._updateUserId = dao.getUpdateUserId();
/*     */   }
/*     */   
/*     */   public PreparedStatement writeObjectId(IObjectId argId, PreparedStatement argStatement) throws SQLException {
/* 272 */     RetailTransactionLineItemNotesPropertyId id = (RetailTransactionLineItemNotesPropertyId)argId;
/* 273 */     argStatement.setTimestamp(1, new Timestamp(id.getBusinessDate().getTime()));
/* 274 */     argStatement.setLong(2, id.getOrganizationId().longValue());
/* 275 */     argStatement.setLong(3, id.getRetailLocationId().longValue());
/* 276 */     argStatement.setInt(4, id.getRetailTransactionLineItemSequence().intValue());
/* 277 */     argStatement.setLong(5, id.getTransactionSequence().longValue());
/* 278 */     argStatement.setLong(6, id.getWorkstationId().longValue());
/* 279 */     argStatement.setLong(7, id.getNoteSeq().longValue());
/* 280 */     argStatement.setString(8, id.getPropertyCode());
/* 281 */     return argStatement;
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 285 */     RetailTransactionLineItemNotesPropertyId id = new RetailTransactionLineItemNotesPropertyId();
/* 286 */     id.setBusinessDate(this._businessDate);
/* 287 */     id.setOrganizationId(this._organizationId);
/* 288 */     id.setRetailLocationId(this._retailLocationId);
/* 289 */     id.setRetailTransactionLineItemSequence(this._retailTransactionLineItemSequence);
/* 290 */     id.setTransactionSequence(this._transactionSequence);
/* 291 */     id.setWorkstationId(this._workstationId);
/* 292 */     id.setNoteSeq(this._noteSeq);
/* 293 */     id.setPropertyCode(this._propertyCode);
/* 294 */     return (IObjectId)id;
/*     */   }
/*     */ 
/*     */   
/*     */   public void fill(IJDBCTableAdapter argAdapter) {}
/*     */ 
/*     */   
/*     */   public boolean isExtensible() {
/* 302 */     return false;
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 306 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\trl\impl\RetailTransactionLineItemNotesPropertyDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */