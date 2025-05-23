/*     */ package dtv.xst.dao.loc.impl;
/*     */ 
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.impl.jdbc.IFiller;
/*     */ import dtv.data2.access.impl.jdbc.IJDBCTableAdapter;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.loc.CycleQuestionId;
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
/*     */ 
/*     */ public class CycleQuestionDBA
/*     */   implements IJDBCTableAdapter
/*     */ {
/*     */   private static final long serialVersionUID = -267705652L;
/*     */   private Long _organizationId;
/*     */   private String _questionId;
/*     */   private Date _createDate;
/*     */   private String _createUserId;
/*     */   private Date _updateDate;
/*     */   private String _updateUserId;
/*     */   private Date _effectiveDate;
/*     */   private Date _expirationDate;
/*     */   private String _questionTextKey;
/*     */   private String _questionTypeCode;
/*     */   private Integer _sortOrder;
/*     */   private Long _retailLocationId;
/*     */   private Boolean _corporateMessage;
/*     */   private static final String SELECT_OBJECT = "SELECT t.organization_id, t.question_id, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.effective_datetime, t.expiration_datetime, t.question_text_key, t.question_typcode, t.sort_order, t.rtl_loc_id, t.corporate_message_flag FROM loc_cycle_questions t";
/*     */   private static final String SELECT_WHERE_OBJECT = " WHERE organization_id = ?  AND question_id = ?  ";
/*     */   
/*     */   public String getSelect() {
/*  42 */     return getSelectImpl();
/*     */   }
/*     */   
/*     */   private String getSelectImpl() {
/*  46 */     return "SELECT t.organization_id, t.question_id, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.effective_datetime, t.expiration_datetime, t.question_text_key, t.question_typcode, t.sort_order, t.rtl_loc_id, t.corporate_message_flag FROM loc_cycle_questions t";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectWhere() {
/*  52 */     return " WHERE organization_id = ?  AND question_id = ?  ";
/*     */   }
/*     */   
/*  55 */   private static final String[] INSERT_OBJECT = new String[] { "INSERT INTO loc_cycle_questions(organization_id, question_id, create_date, create_user_id, update_date, update_user_id, effective_datetime, expiration_datetime, question_text_key, question_typcode, sort_order, rtl_loc_id, corporate_message_flag) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" };
/*     */   
/*     */   public String[] getInsert() {
/*  58 */     return INSERT_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getInsertParameters() {
/*  62 */     Object[][] insertParameterObject = { { this._organizationId, this._questionId, this._createDate, this._createUserId, this._updateDate, this._updateUserId, this._effectiveDate, this._expirationDate, this._questionTextKey, this._questionTypeCode, this._sortOrder, this._retailLocationId, this._corporateMessage } };
/*  63 */     return insertParameterObject;
/*     */   }
/*     */   
/*  66 */   private static final int[][] INSERT_PARAMETER_TYPES_OBJECT = new int[][] { { -5, 12, 91, 12, 91, 12, 91, 91, 12, 12, 4, -5, -7 } };
/*     */   
/*     */   public int[][] getInsertParameterTypes() {
/*  69 */     return INSERT_PARAMETER_TYPES_OBJECT;
/*     */   }
/*     */   
/*  72 */   private static final String[] UPDATE_OBJECT = new String[] { "UPDATE loc_cycle_questions SET update_date = ?, update_user_id = ?, effective_datetime = ?, expiration_datetime = ?, question_text_key = ?, question_typcode = ?, sort_order = ?, rtl_loc_id = ?, corporate_message_flag = ?" };
/*     */   
/*     */   public String[] getUpdate() {
/*  75 */     return UPDATE_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getUpdateParameters() {
/*  79 */     Object[][] updateParameterObject = { { this._updateDate, this._updateUserId, this._effectiveDate, this._expirationDate, this._questionTextKey, this._questionTypeCode, this._sortOrder, this._retailLocationId, this._corporateMessage } };
/*  80 */     return updateParameterObject;
/*     */   }
/*     */   
/*  83 */   private static final int[][] UPDATE_PARAMETER_TYPE_OBJECT = new int[][] { { 91, 12, 91, 91, 12, 12, 4, -5, -7 } };
/*     */   public int[][] getUpdateParameterTypes() {
/*  85 */     return UPDATE_PARAMETER_TYPE_OBJECT;
/*     */   }
/*     */   
/*  88 */   private static final String[] DELETE_OBJECT = new String[] { "DELETE FROM loc_cycle_questions" }; private static final String WHERE_OBJECT = " WHERE organization_id = ?  AND question_id = ?  ";
/*     */   
/*     */   public String[] getDelete() {
/*  91 */     return DELETE_OBJECT;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWhere() {
/*  97 */     return " WHERE organization_id = ?  AND question_id = ?  ";
/*     */   }
/*     */   public Object[] getWhereParameters() {
/* 100 */     return new Object[] { this._organizationId, this._questionId };
/*     */   }
/*     */   
/* 103 */   private static final int[] WHERE_PARAMETER_OBJECT = new int[] { -5, 12 };
/*     */   
/*     */   public int[] getWhereParameterTypes() {
/* 106 */     return WHERE_PARAMETER_OBJECT;
/*     */   }
/*     */   public String getTableName() {
/* 109 */     return "loc_cycle_questions";
/*     */   }
/*     */   
/*     */   public IFiller getFiller() {
/* 113 */     return getFillerImpl();
/*     */   }
/*     */   
/*     */   private IFiller getFillerImpl() {
/* 117 */     return new CycleQuestionFiller(this);
/*     */   }
/*     */   
/*     */   private static class CycleQuestionFiller
/*     */     implements IFiller {
/*     */     private CycleQuestionDBA _parent;
/*     */     
/*     */     public CycleQuestionFiller(CycleQuestionDBA argParent) {
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
/* 136 */       this._parent._questionId = argResultSet.getString(2);
/*     */       
/* 138 */       Timestamp t3 = argResultSet.getTimestamp(3);
/* 139 */       if (t3 != null) {
/* 140 */         this._parent._createDate = (Date)new DtvDate(t3.getTime());
/*     */       } else {
/*     */         
/* 143 */         this._parent._createDate = null;
/*     */       } 
/*     */       
/* 146 */       this._parent._createUserId = argResultSet.getString(4);
/*     */       
/* 148 */       Timestamp t5 = argResultSet.getTimestamp(5);
/* 149 */       if (t5 != null) {
/* 150 */         this._parent._updateDate = (Date)new DtvDate(t5.getTime());
/*     */       } else {
/*     */         
/* 153 */         this._parent._updateDate = null;
/*     */       } 
/*     */       
/* 156 */       this._parent._updateUserId = argResultSet.getString(6);
/*     */       
/* 158 */       Timestamp t7 = argResultSet.getTimestamp(7);
/* 159 */       if (t7 != null) {
/* 160 */         this._parent._effectiveDate = (Date)new DtvDate(t7.getTime());
/*     */       } else {
/*     */         
/* 163 */         this._parent._effectiveDate = null;
/*     */       } 
/*     */ 
/*     */       
/* 167 */       Timestamp t8 = argResultSet.getTimestamp(8);
/* 168 */       if (t8 != null) {
/* 169 */         this._parent._expirationDate = (Date)new DtvDate(t8.getTime());
/*     */       } else {
/*     */         
/* 172 */         this._parent._expirationDate = null;
/*     */       } 
/*     */       
/* 175 */       this._parent._questionTextKey = argResultSet.getString(9);
/* 176 */       this._parent._questionTypeCode = argResultSet.getString(10);
/*     */ 
/*     */       
/* 179 */       int i = argResultSet.getInt(11);
/* 180 */       if (i != 0 || argResultSet.getObject(11) != null) {
/* 181 */         this._parent._sortOrder = Integer.valueOf(i);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 187 */       long l1 = argResultSet.getLong(12);
/* 188 */       if (l1 != 0L || argResultSet.getObject(12) != null) {
/* 189 */         this._parent._retailLocationId = Long.valueOf(l1);
/*     */       }
/*     */ 
/*     */       
/* 193 */       this._parent._corporateMessage = Boolean.valueOf(argResultSet.getBoolean(13));
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDAO(IDataAccessObject argDAO) {
/* 198 */     argDAO.suppressStateChanges(true);
/* 199 */     CycleQuestionDAO dao = (CycleQuestionDAO)argDAO;
/* 200 */     dao.setOrganizationId(this._organizationId);
/* 201 */     dao.setQuestionId(this._questionId);
/* 202 */     dao.setCreateDate(this._createDate);
/* 203 */     dao.setCreateUserId(this._createUserId);
/* 204 */     dao.setUpdateDate(this._updateDate);
/* 205 */     dao.setUpdateUserId(this._updateUserId);
/* 206 */     dao.setEffectiveDate(this._effectiveDate);
/* 207 */     dao.setExpirationDate(this._expirationDate);
/* 208 */     dao.setQuestionTextKey(this._questionTextKey);
/* 209 */     dao.setQuestionTypeCode(this._questionTypeCode);
/* 210 */     dao.setSortOrder(this._sortOrder);
/* 211 */     dao.setRetailLocationId(this._retailLocationId);
/* 212 */     dao.setCorporateMessage(this._corporateMessage);
/* 213 */     argDAO.suppressStateChanges(false);
/* 214 */     return (IDataAccessObject)dao;
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDefaultDAO() {
/* 218 */     return loadDAO((IDataAccessObject)new CycleQuestionDAO());
/*     */   }
/*     */   
/*     */   public void fill(IDataAccessObject argDAO) {
/* 222 */     CycleQuestionDAO dao = (CycleQuestionDAO)argDAO;
/* 223 */     this._organizationId = dao.getOrganizationId();
/* 224 */     this._questionId = dao.getQuestionId();
/* 225 */     this._createDate = dao.getCreateDate();
/* 226 */     this._createUserId = dao.getCreateUserId();
/* 227 */     this._updateDate = dao.getUpdateDate();
/* 228 */     this._updateUserId = dao.getUpdateUserId();
/* 229 */     this._effectiveDate = dao.getEffectiveDate();
/* 230 */     this._expirationDate = dao.getExpirationDate();
/* 231 */     this._questionTextKey = dao.getQuestionTextKey();
/* 232 */     this._questionTypeCode = dao.getQuestionTypeCode();
/* 233 */     this._sortOrder = dao.getSortOrder();
/* 234 */     this._retailLocationId = dao.getRetailLocationId();
/* 235 */     this._corporateMessage = (dao.getCorporateMessage() != null) ? dao.getCorporateMessage() : Boolean.valueOf(false);
/*     */   }
/*     */   
/*     */   public PreparedStatement writeObjectId(IObjectId argId, PreparedStatement argStatement) throws SQLException {
/* 239 */     CycleQuestionId id = (CycleQuestionId)argId;
/* 240 */     argStatement.setLong(1, id.getOrganizationId().longValue());
/* 241 */     argStatement.setString(2, id.getQuestionId());
/* 242 */     return argStatement;
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 246 */     CycleQuestionId id = new CycleQuestionId();
/* 247 */     id.setOrganizationId(this._organizationId);
/* 248 */     id.setQuestionId(this._questionId);
/* 249 */     return (IObjectId)id;
/*     */   }
/*     */ 
/*     */   
/*     */   public void fill(IJDBCTableAdapter argAdapter) {}
/*     */ 
/*     */   
/*     */   public boolean isExtensible() {
/* 257 */     return false;
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 261 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\loc\impl\CycleQuestionDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */