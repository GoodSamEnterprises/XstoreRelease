/*     */ package dtv.xst.dao.loc.impl;
/*     */ 
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.impl.jdbc.IFiller;
/*     */ import dtv.data2.access.impl.jdbc.IJDBCTableAdapter;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.loc.CycleQuestionAnswerId;
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
/*     */ public class CycleQuestionAnswerDBA
/*     */   implements IJDBCTableAdapter
/*     */ {
/*     */   private static final long serialVersionUID = -1404041814L;
/*     */   private String _answerId;
/*     */   private Date _answerTimestamp;
/*     */   private Long _organizationId;
/*     */   private String _questionId;
/*     */   private Date _createDate;
/*     */   private String _createUserId;
/*     */   private Date _updateDate;
/*     */   private String _updateUserId;
/*     */   private Long _retailLocationId;
/*     */   private static final String SELECT_OBJECT = "SELECT t.answer_id, t.answer_timestamp, t.organization_id, t.question_id, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.rtl_loc_id FROM loc_cycle_question_answers t";
/*     */   private static final String SELECT_WHERE_OBJECT = " WHERE answer_id = ?  AND answer_timestamp = ?  AND organization_id = ?  AND question_id = ?  ";
/*     */   
/*     */   public String getSelect() {
/*  38 */     return getSelectImpl();
/*     */   }
/*     */   
/*     */   private String getSelectImpl() {
/*  42 */     return "SELECT t.answer_id, t.answer_timestamp, t.organization_id, t.question_id, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.rtl_loc_id FROM loc_cycle_question_answers t";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectWhere() {
/*  48 */     return " WHERE answer_id = ?  AND answer_timestamp = ?  AND organization_id = ?  AND question_id = ?  ";
/*     */   }
/*     */   
/*  51 */   private static final String[] INSERT_OBJECT = new String[] { "INSERT INTO loc_cycle_question_answers(answer_id, answer_timestamp, organization_id, question_id, create_date, create_user_id, update_date, update_user_id, rtl_loc_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)" };
/*     */   
/*     */   public String[] getInsert() {
/*  54 */     return INSERT_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getInsertParameters() {
/*  58 */     Object[][] insertParameterObject = { { this._answerId, this._answerTimestamp, this._organizationId, this._questionId, this._createDate, this._createUserId, this._updateDate, this._updateUserId, this._retailLocationId } };
/*  59 */     return insertParameterObject;
/*     */   }
/*     */   
/*  62 */   private static final int[][] INSERT_PARAMETER_TYPES_OBJECT = new int[][] { { 12, 91, -5, 12, 91, 12, 91, 12, -5 } };
/*     */   
/*     */   public int[][] getInsertParameterTypes() {
/*  65 */     return INSERT_PARAMETER_TYPES_OBJECT;
/*     */   }
/*     */   
/*  68 */   private static final String[] UPDATE_OBJECT = new String[] { "UPDATE loc_cycle_question_answers SET update_date = ?, update_user_id = ?, rtl_loc_id = ?" };
/*     */   
/*     */   public String[] getUpdate() {
/*  71 */     return UPDATE_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getUpdateParameters() {
/*  75 */     Object[][] updateParameterObject = { { this._updateDate, this._updateUserId, this._retailLocationId } };
/*  76 */     return updateParameterObject;
/*     */   }
/*     */   
/*  79 */   private static final int[][] UPDATE_PARAMETER_TYPE_OBJECT = new int[][] { { 91, 12, -5 } };
/*     */   public int[][] getUpdateParameterTypes() {
/*  81 */     return UPDATE_PARAMETER_TYPE_OBJECT;
/*     */   }
/*     */   
/*  84 */   private static final String[] DELETE_OBJECT = new String[] { "DELETE FROM loc_cycle_question_answers" }; private static final String WHERE_OBJECT = " WHERE answer_id = ?  AND answer_timestamp = ?  AND organization_id = ?  AND question_id = ?  ";
/*     */   
/*     */   public String[] getDelete() {
/*  87 */     return DELETE_OBJECT;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWhere() {
/*  93 */     return " WHERE answer_id = ?  AND answer_timestamp = ?  AND organization_id = ?  AND question_id = ?  ";
/*     */   }
/*     */   public Object[] getWhereParameters() {
/*  96 */     return new Object[] { this._answerId, this._answerTimestamp, this._organizationId, this._questionId };
/*     */   }
/*     */   
/*  99 */   private static final int[] WHERE_PARAMETER_OBJECT = new int[] { 12, 91, -5, 12 };
/*     */   
/*     */   public int[] getWhereParameterTypes() {
/* 102 */     return WHERE_PARAMETER_OBJECT;
/*     */   }
/*     */   public String getTableName() {
/* 105 */     return "loc_cycle_question_answers";
/*     */   }
/*     */   
/*     */   public IFiller getFiller() {
/* 109 */     return getFillerImpl();
/*     */   }
/*     */   
/*     */   private IFiller getFillerImpl() {
/* 113 */     return new CycleQuestionAnswerFiller(this);
/*     */   }
/*     */   
/*     */   private static class CycleQuestionAnswerFiller
/*     */     implements IFiller {
/*     */     private CycleQuestionAnswerDBA _parent;
/*     */     
/*     */     public CycleQuestionAnswerFiller(CycleQuestionAnswerDBA argParent) {
/* 121 */       this._parent = argParent;
/*     */     }
/*     */     public void fill(ResultSet argResultSet) throws SQLException {
/* 124 */       this._parent._answerId = argResultSet.getString(1);
/*     */       
/* 126 */       Timestamp t2 = argResultSet.getTimestamp(2);
/* 127 */       if (t2 != null) {
/* 128 */         this._parent._answerTimestamp = (Date)new DtvDate(t2.getTime());
/*     */       } else {
/*     */         
/* 131 */         this._parent._answerTimestamp = null;
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/* 136 */       long primitiveResult = argResultSet.getLong(3);
/* 137 */       if (primitiveResult != 0L || argResultSet.getObject(3) != null) {
/* 138 */         this._parent._organizationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */       
/* 142 */       this._parent._questionId = argResultSet.getString(4);
/*     */       
/* 144 */       Timestamp t5 = argResultSet.getTimestamp(5);
/* 145 */       if (t5 != null) {
/* 146 */         this._parent._createDate = (Date)new DtvDate(t5.getTime());
/*     */       } else {
/*     */         
/* 149 */         this._parent._createDate = null;
/*     */       } 
/*     */       
/* 152 */       this._parent._createUserId = argResultSet.getString(6);
/*     */       
/* 154 */       Timestamp t7 = argResultSet.getTimestamp(7);
/* 155 */       if (t7 != null) {
/* 156 */         this._parent._updateDate = (Date)new DtvDate(t7.getTime());
/*     */       } else {
/*     */         
/* 159 */         this._parent._updateDate = null;
/*     */       } 
/*     */       
/* 162 */       this._parent._updateUserId = argResultSet.getString(8);
/*     */ 
/*     */       
/* 165 */       long l1 = argResultSet.getLong(9);
/* 166 */       if (l1 != 0L || argResultSet.getObject(9) != null) {
/* 167 */         this._parent._retailLocationId = Long.valueOf(l1);
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IDataAccessObject loadDAO(IDataAccessObject argDAO) {
/* 175 */     argDAO.suppressStateChanges(true);
/* 176 */     CycleQuestionAnswerDAO dao = (CycleQuestionAnswerDAO)argDAO;
/* 177 */     dao.setAnswerId(this._answerId);
/* 178 */     dao.setAnswerTimestamp(this._answerTimestamp);
/* 179 */     dao.setOrganizationId(this._organizationId);
/* 180 */     dao.setQuestionId(this._questionId);
/* 181 */     dao.setCreateDate(this._createDate);
/* 182 */     dao.setCreateUserId(this._createUserId);
/* 183 */     dao.setUpdateDate(this._updateDate);
/* 184 */     dao.setUpdateUserId(this._updateUserId);
/* 185 */     dao.setRetailLocationId(this._retailLocationId);
/* 186 */     argDAO.suppressStateChanges(false);
/* 187 */     return (IDataAccessObject)dao;
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDefaultDAO() {
/* 191 */     return loadDAO((IDataAccessObject)new CycleQuestionAnswerDAO());
/*     */   }
/*     */   
/*     */   public void fill(IDataAccessObject argDAO) {
/* 195 */     CycleQuestionAnswerDAO dao = (CycleQuestionAnswerDAO)argDAO;
/* 196 */     this._answerId = dao.getAnswerId();
/* 197 */     this._answerTimestamp = dao.getAnswerTimestamp();
/* 198 */     this._organizationId = dao.getOrganizationId();
/* 199 */     this._questionId = dao.getQuestionId();
/* 200 */     this._createDate = dao.getCreateDate();
/* 201 */     this._createUserId = dao.getCreateUserId();
/* 202 */     this._updateDate = dao.getUpdateDate();
/* 203 */     this._updateUserId = dao.getUpdateUserId();
/* 204 */     this._retailLocationId = dao.getRetailLocationId();
/*     */   }
/*     */   
/*     */   public PreparedStatement writeObjectId(IObjectId argId, PreparedStatement argStatement) throws SQLException {
/* 208 */     CycleQuestionAnswerId id = (CycleQuestionAnswerId)argId;
/* 209 */     argStatement.setString(1, id.getAnswerId());
/* 210 */     argStatement.setTimestamp(2, new Timestamp(id.getAnswerTimestamp().getTime()));
/* 211 */     argStatement.setLong(3, id.getOrganizationId().longValue());
/* 212 */     argStatement.setString(4, id.getQuestionId());
/* 213 */     return argStatement;
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 217 */     CycleQuestionAnswerId id = new CycleQuestionAnswerId();
/* 218 */     id.setAnswerId(this._answerId);
/* 219 */     id.setAnswerTimestamp(this._answerTimestamp);
/* 220 */     id.setOrganizationId(this._organizationId);
/* 221 */     id.setQuestionId(this._questionId);
/* 222 */     return (IObjectId)id;
/*     */   }
/*     */ 
/*     */   
/*     */   public void fill(IJDBCTableAdapter argAdapter) {}
/*     */ 
/*     */   
/*     */   public boolean isExtensible() {
/* 230 */     return false;
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 234 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\loc\impl\CycleQuestionAnswerDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */