/*    */ package dtv.xst.dao.loc;
/*    */ import dtv.data2.access.IDataAccessObject;
/*    */ import dtv.data2.access.IDataModel;
/*    */ import dtv.event.EventEnum;
/*    */ import java.util.Date;
/*    */ import java.util.List;
/*    */ 
/*    */ public interface ICycleQuestion extends IDataModel, IHasDataProperty<ICycleQuestionProperty> {
/*  9 */   public static final EventEnum SET_ORGANIZATIONID = new EventEnum("set organizationId");
/* 10 */   public static final EventEnum SET_QUESTIONID = new EventEnum("set questionId");
/* 11 */   public static final EventEnum SET_CREATEDATE = new EventEnum("set createDate");
/* 12 */   public static final EventEnum SET_CREATEUSERID = new EventEnum("set createUserId");
/* 13 */   public static final EventEnum SET_UPDATEDATE = new EventEnum("set updateDate");
/* 14 */   public static final EventEnum SET_UPDATEUSERID = new EventEnum("set updateUserId");
/* 15 */   public static final EventEnum SET_EFFECTIVEDATE = new EventEnum("set effectiveDate");
/* 16 */   public static final EventEnum SET_EXPIRATIONDATE = new EventEnum("set expirationDate");
/* 17 */   public static final EventEnum SET_QUESTIONTEXTKEY = new EventEnum("set questionTextKey");
/* 18 */   public static final EventEnum SET_QUESTIONTYPECODE = new EventEnum("set questionTypeCode");
/* 19 */   public static final EventEnum SET_SORTORDER = new EventEnum("set sortOrder");
/* 20 */   public static final EventEnum SET_RETAILLOCATIONID = new EventEnum("set retailLocationId");
/* 21 */   public static final EventEnum SET_CORPORATEMESSAGE = new EventEnum("set corporateMessage");
/* 22 */   public static final EventEnum ADD_QUESTIONCHOICES = new EventEnum("add QuestionChoices");
/* 23 */   public static final EventEnum REMOVE_QUESTIONCHOICES = new EventEnum("remove QuestionChoices");
/* 24 */   public static final EventEnum SET_QUESTIONCHOICES = new EventEnum("set QuestionChoices");
/* 25 */   public static final EventEnum ADD_PROPERTIES = new EventEnum("add Properties");
/* 26 */   public static final EventEnum REMOVE_PROPERTIES = new EventEnum("remove Properties");
/* 27 */   public static final EventEnum SET_PROPERTIES = new EventEnum("set Properties");
/* 28 */   public static final EventEnum START_TRANSACTION = new EventEnum("start transaction");
/* 29 */   public static final EventEnum ROLLBACK_TRANSACTION = new EventEnum("rollback transaction");
/* 30 */   public static final EventEnum COMMIT_TRANSACTION = new EventEnum("commit transaction");
/*    */   
/*    */   void setDAO(IDataAccessObject paramIDataAccessObject);
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
/*    */   Date getEffectiveDate();
/*    */   
/*    */   void setEffectiveDate(Date paramDate);
/*    */   
/*    */   Date getExpirationDate();
/*    */   
/*    */   void setExpirationDate(Date paramDate);
/*    */   
/*    */   String getQuestionTextKey();
/*    */   
/*    */   void setQuestionTextKey(String paramString);
/*    */   
/*    */   String getQuestionTypeCode();
/*    */   
/*    */   void setQuestionTypeCode(String paramString);
/*    */   
/*    */   int getSortOrder();
/*    */   
/*    */   void setSortOrder(int paramInt);
/*    */   
/*    */   long getRetailLocationId();
/*    */   
/*    */   void setRetailLocationId(long paramLong);
/*    */   
/*    */   boolean getCorporateMessage();
/*    */   
/*    */   void setCorporateMessage(boolean paramBoolean);
/*    */   
/*    */   IDataModel getCycleQuestionExt();
/*    */   
/*    */   void setCycleQuestionExt(IDataModel paramIDataModel);
/*    */   
/*    */   List<ICycleQuestionChoice> getQuestionChoices();
/*    */   
/*    */   void setQuestionChoices(List<ICycleQuestionChoice> paramList);
/*    */   
/*    */   void addCycleQuestionChoice(ICycleQuestionChoice paramICycleQuestionChoice);
/*    */   
/*    */   void removeCycleQuestionChoice(ICycleQuestionChoice paramICycleQuestionChoice);
/*    */   
/*    */   List<ICycleQuestionProperty> getProperties();
/*    */   
/*    */   void setProperties(List<ICycleQuestionProperty> paramList);
/*    */   
/*    */   void addCycleQuestionProperty(ICycleQuestionProperty paramICycleQuestionProperty);
/*    */   
/*    */   void removeCycleQuestionProperty(ICycleQuestionProperty paramICycleQuestionProperty);
/*    */   
/*    */   void startTransaction();
/*    */   
/*    */   void rollbackChanges();
/*    */   
/*    */   void commitTransaction();
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\loc\ICycleQuestion.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */