/*     */ package dtv.xst.dao.loc.impl;
/*     */ 
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.impl.jdbc.IFiller;
/*     */ import dtv.data2.access.impl.jdbc.IJDBCTableAdapter;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.loc.CycleQuestionChoiceId;
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
/*     */ public class CycleQuestionChoiceDBA
/*     */   implements IJDBCTableAdapter
/*     */ {
/*     */   private static final long serialVersionUID = -1352457331L;
/*     */   private String _answerId;
/*     */   private Long _organizationId;
/*     */   private String _questionId;
/*     */   private Date _createDate;
/*     */   private String _createUserId;
/*     */   private Date _updateDate;
/*     */   private String _updateUserId;
/*     */   private String _answerTextKey;
/*     */   private Integer _sortOrder;
/*     */   private static final String SELECT_OBJECT = "SELECT t.answer_id, t.organization_id, t.question_id, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.answer_text_key, t.sort_order FROM loc_cycle_question_choices t";
/*     */   private static final String SELECT_WHERE_OBJECT = " WHERE answer_id = ?  AND organization_id = ?  AND question_id = ?  ";
/*     */   
/*     */   public String getSelect() {
/*  38 */     return getSelectImpl();
/*     */   }
/*     */   
/*     */   private String getSelectImpl() {
/*  42 */     return "SELECT t.answer_id, t.organization_id, t.question_id, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.answer_text_key, t.sort_order FROM loc_cycle_question_choices t";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectWhere() {
/*  48 */     return " WHERE answer_id = ?  AND organization_id = ?  AND question_id = ?  ";
/*     */   }
/*     */   
/*  51 */   private static final String[] INSERT_OBJECT = new String[] { "INSERT INTO loc_cycle_question_choices(answer_id, organization_id, question_id, create_date, create_user_id, update_date, update_user_id, answer_text_key, sort_order) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)" };
/*     */   
/*     */   public String[] getInsert() {
/*  54 */     return INSERT_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getInsertParameters() {
/*  58 */     Object[][] insertParameterObject = { { this._answerId, this._organizationId, this._questionId, this._createDate, this._createUserId, this._updateDate, this._updateUserId, this._answerTextKey, this._sortOrder } };
/*  59 */     return insertParameterObject;
/*     */   }
/*     */   
/*  62 */   private static final int[][] INSERT_PARAMETER_TYPES_OBJECT = new int[][] { { 12, -5, 12, 91, 12, 91, 12, 12, 4 } };
/*     */   
/*     */   public int[][] getInsertParameterTypes() {
/*  65 */     return INSERT_PARAMETER_TYPES_OBJECT;
/*     */   }
/*     */   
/*  68 */   private static final String[] UPDATE_OBJECT = new String[] { "UPDATE loc_cycle_question_choices SET update_date = ?, update_user_id = ?, answer_text_key = ?, sort_order = ?" };
/*     */   
/*     */   public String[] getUpdate() {
/*  71 */     return UPDATE_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getUpdateParameters() {
/*  75 */     Object[][] updateParameterObject = { { this._updateDate, this._updateUserId, this._answerTextKey, this._sortOrder } };
/*  76 */     return updateParameterObject;
/*     */   }
/*     */   
/*  79 */   private static final int[][] UPDATE_PARAMETER_TYPE_OBJECT = new int[][] { { 91, 12, 12, 4 } };
/*     */   public int[][] getUpdateParameterTypes() {
/*  81 */     return UPDATE_PARAMETER_TYPE_OBJECT;
/*     */   }
/*     */   
/*  84 */   private static final String[] DELETE_OBJECT = new String[] { "DELETE FROM loc_cycle_question_choices" }; private static final String WHERE_OBJECT = " WHERE answer_id = ?  AND organization_id = ?  AND question_id = ?  ";
/*     */   
/*     */   public String[] getDelete() {
/*  87 */     return DELETE_OBJECT;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWhere() {
/*  93 */     return " WHERE answer_id = ?  AND organization_id = ?  AND question_id = ?  ";
/*     */   }
/*     */   public Object[] getWhereParameters() {
/*  96 */     return new Object[] { this._answerId, this._organizationId, this._questionId };
/*     */   }
/*     */   
/*  99 */   private static final int[] WHERE_PARAMETER_OBJECT = new int[] { 12, -5, 12 };
/*     */   
/*     */   public int[] getWhereParameterTypes() {
/* 102 */     return WHERE_PARAMETER_OBJECT;
/*     */   }
/*     */   public String getTableName() {
/* 105 */     return "loc_cycle_question_choices";
/*     */   }
/*     */   
/*     */   public IFiller getFiller() {
/* 109 */     return getFillerImpl();
/*     */   }
/*     */   
/*     */   private IFiller getFillerImpl() {
/* 113 */     return new CycleQuestionChoiceFiller(this);
/*     */   }
/*     */   
/*     */   private static class CycleQuestionChoiceFiller
/*     */     implements IFiller {
/*     */     private CycleQuestionChoiceDBA _parent;
/*     */     
/*     */     public CycleQuestionChoiceFiller(CycleQuestionChoiceDBA argParent) {
/* 121 */       this._parent = argParent;
/*     */     }
/*     */     public void fill(ResultSet argResultSet) throws SQLException {
/* 124 */       this._parent._answerId = argResultSet.getString(1);
/*     */ 
/*     */       
/* 127 */       long primitiveResult = argResultSet.getLong(2);
/* 128 */       if (primitiveResult != 0L || argResultSet.getObject(2) != null) {
/* 129 */         this._parent._organizationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */       
/* 133 */       this._parent._questionId = argResultSet.getString(3);
/*     */       
/* 135 */       Timestamp t4 = argResultSet.getTimestamp(4);
/* 136 */       if (t4 != null) {
/* 137 */         this._parent._createDate = (Date)new DtvDate(t4.getTime());
/*     */       } else {
/*     */         
/* 140 */         this._parent._createDate = null;
/*     */       } 
/*     */       
/* 143 */       this._parent._createUserId = argResultSet.getString(5);
/*     */       
/* 145 */       Timestamp t6 = argResultSet.getTimestamp(6);
/* 146 */       if (t6 != null) {
/* 147 */         this._parent._updateDate = (Date)new DtvDate(t6.getTime());
/*     */       } else {
/*     */         
/* 150 */         this._parent._updateDate = null;
/*     */       } 
/*     */       
/* 153 */       this._parent._updateUserId = argResultSet.getString(7);
/* 154 */       this._parent._answerTextKey = argResultSet.getString(8);
/*     */ 
/*     */       
/* 157 */       int i = argResultSet.getInt(9);
/* 158 */       if (i != 0 || argResultSet.getObject(9) != null) {
/* 159 */         this._parent._sortOrder = Integer.valueOf(i);
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IDataAccessObject loadDAO(IDataAccessObject argDAO) {
/* 167 */     argDAO.suppressStateChanges(true);
/* 168 */     CycleQuestionChoiceDAO dao = (CycleQuestionChoiceDAO)argDAO;
/* 169 */     dao.setAnswerId(this._answerId);
/* 170 */     dao.setOrganizationId(this._organizationId);
/* 171 */     dao.setQuestionId(this._questionId);
/* 172 */     dao.setCreateDate(this._createDate);
/* 173 */     dao.setCreateUserId(this._createUserId);
/* 174 */     dao.setUpdateDate(this._updateDate);
/* 175 */     dao.setUpdateUserId(this._updateUserId);
/* 176 */     dao.setAnswerTextKey(this._answerTextKey);
/* 177 */     dao.setSortOrder(this._sortOrder);
/* 178 */     argDAO.suppressStateChanges(false);
/* 179 */     return (IDataAccessObject)dao;
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDefaultDAO() {
/* 183 */     return loadDAO((IDataAccessObject)new CycleQuestionChoiceDAO());
/*     */   }
/*     */   
/*     */   public void fill(IDataAccessObject argDAO) {
/* 187 */     CycleQuestionChoiceDAO dao = (CycleQuestionChoiceDAO)argDAO;
/* 188 */     this._answerId = dao.getAnswerId();
/* 189 */     this._organizationId = dao.getOrganizationId();
/* 190 */     this._questionId = dao.getQuestionId();
/* 191 */     this._createDate = dao.getCreateDate();
/* 192 */     this._createUserId = dao.getCreateUserId();
/* 193 */     this._updateDate = dao.getUpdateDate();
/* 194 */     this._updateUserId = dao.getUpdateUserId();
/* 195 */     this._answerTextKey = dao.getAnswerTextKey();
/* 196 */     this._sortOrder = dao.getSortOrder();
/*     */   }
/*     */   
/*     */   public PreparedStatement writeObjectId(IObjectId argId, PreparedStatement argStatement) throws SQLException {
/* 200 */     CycleQuestionChoiceId id = (CycleQuestionChoiceId)argId;
/* 201 */     argStatement.setString(1, id.getAnswerId());
/* 202 */     argStatement.setLong(2, id.getOrganizationId().longValue());
/* 203 */     argStatement.setString(3, id.getQuestionId());
/* 204 */     return argStatement;
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 208 */     CycleQuestionChoiceId id = new CycleQuestionChoiceId();
/* 209 */     id.setAnswerId(this._answerId);
/* 210 */     id.setOrganizationId(this._organizationId);
/* 211 */     id.setQuestionId(this._questionId);
/* 212 */     return (IObjectId)id;
/*     */   }
/*     */ 
/*     */   
/*     */   public void fill(IJDBCTableAdapter argAdapter) {}
/*     */ 
/*     */   
/*     */   public boolean isExtensible() {
/* 220 */     return false;
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 224 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\loc\impl\CycleQuestionChoiceDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */