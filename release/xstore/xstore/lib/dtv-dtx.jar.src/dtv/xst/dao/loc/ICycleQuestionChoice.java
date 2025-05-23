/*    */ package dtv.xst.dao.loc;
/*    */ import dtv.data2.access.IDataAccessObject;
/*    */ import dtv.data2.access.IDataModel;
/*    */ import dtv.event.EventEnum;
/*    */ import java.util.Date;
/*    */ import java.util.List;
/*    */ 
/*    */ public interface ICycleQuestionChoice extends IDataModel, IHasDataProperty<ICycleQuestionChoiceProperty> {
/*  9 */   public static final EventEnum SET_ANSWERID = new EventEnum("set answerId");
/* 10 */   public static final EventEnum SET_ORGANIZATIONID = new EventEnum("set organizationId");
/* 11 */   public static final EventEnum SET_QUESTIONID = new EventEnum("set questionId");
/* 12 */   public static final EventEnum SET_CREATEDATE = new EventEnum("set createDate");
/* 13 */   public static final EventEnum SET_CREATEUSERID = new EventEnum("set createUserId");
/* 14 */   public static final EventEnum SET_UPDATEDATE = new EventEnum("set updateDate");
/* 15 */   public static final EventEnum SET_UPDATEUSERID = new EventEnum("set updateUserId");
/* 16 */   public static final EventEnum SET_ANSWERTEXTKEY = new EventEnum("set answerTextKey");
/* 17 */   public static final EventEnum SET_SORTORDER = new EventEnum("set sortOrder");
/* 18 */   public static final EventEnum ADD_PROPERTIES = new EventEnum("add Properties");
/* 19 */   public static final EventEnum REMOVE_PROPERTIES = new EventEnum("remove Properties");
/* 20 */   public static final EventEnum SET_PROPERTIES = new EventEnum("set Properties");
/* 21 */   public static final EventEnum START_TRANSACTION = new EventEnum("start transaction");
/* 22 */   public static final EventEnum ROLLBACK_TRANSACTION = new EventEnum("rollback transaction");
/* 23 */   public static final EventEnum COMMIT_TRANSACTION = new EventEnum("commit transaction");
/*    */   
/*    */   void setDAO(IDataAccessObject paramIDataAccessObject);
/*    */   
/*    */   String getAnswerId();
/*    */   
/*    */   void setAnswerId(String paramString);
/*    */   
/*    */   long getOrganizationId();
/*    */   
/*    */   void setOrganizationId(long paramLong);
/*    */   
/*    */   String getQuestionId();
/*    */   
/*    */   void setQuestionId(String paramString);
/*    */   
/*    */   Date getCreateDate();
/*    */   
/*    */   void setCreateDate(Date paramDate);
/*    */   
/*    */   String getCreateUserId();
/*    */   
/*    */   void setCreateUserId(String paramString);
/*    */   
/*    */   Date getUpdateDate();
/*    */   
/*    */   void setUpdateDate(Date paramDate);
/*    */   
/*    */   String getUpdateUserId();
/*    */   
/*    */   void setUpdateUserId(String paramString);
/*    */   
/*    */   String getAnswerTextKey();
/*    */   
/*    */   void setAnswerTextKey(String paramString);
/*    */   
/*    */   int getSortOrder();
/*    */   
/*    */   void setSortOrder(int paramInt);
/*    */   
/*    */   IDataModel getCycleQuestionChoiceExt();
/*    */   
/*    */   void setCycleQuestionChoiceExt(IDataModel paramIDataModel);
/*    */   
/*    */   List<ICycleQuestionChoiceProperty> getProperties();
/*    */   
/*    */   void setProperties(List<ICycleQuestionChoiceProperty> paramList);
/*    */   
/*    */   void addCycleQuestionChoiceProperty(ICycleQuestionChoiceProperty paramICycleQuestionChoiceProperty);
/*    */   
/*    */   void removeCycleQuestionChoiceProperty(ICycleQuestionChoiceProperty paramICycleQuestionChoiceProperty);
/*    */   
/*    */   void startTransaction();
/*    */   
/*    */   void rollbackChanges();
/*    */   
/*    */   void commitTransaction();
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\loc\ICycleQuestionChoice.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */