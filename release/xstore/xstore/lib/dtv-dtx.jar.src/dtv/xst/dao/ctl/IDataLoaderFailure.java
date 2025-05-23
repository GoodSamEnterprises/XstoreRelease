/*    */ package dtv.xst.dao.ctl;
/*    */ import dtv.data2.access.IDataAccessObject;
/*    */ import dtv.data2.access.IDataModel;
/*    */ import dtv.event.EventEnum;
/*    */ import java.util.Date;
/*    */ import java.util.List;
/*    */ 
/*    */ public interface IDataLoaderFailure extends IDataModel, IHasDataProperty<IDataLoaderFailureProperty> {
/*  9 */   public static final EventEnum SET_ORGANIZATIONID = new EventEnum("set organizationId");
/* 10 */   public static final EventEnum SET_FILENAME = new EventEnum("set fileName");
/* 11 */   public static final EventEnum SET_RUNTIME = new EventEnum("set runTime");
/* 12 */   public static final EventEnum SET_FAILURESEQUENCE = new EventEnum("set failureSequence");
/* 13 */   public static final EventEnum SET_CREATEDATE = new EventEnum("set createDate");
/* 14 */   public static final EventEnum SET_CREATEUSERID = new EventEnum("set createUserId");
/* 15 */   public static final EventEnum SET_UPDATEDATE = new EventEnum("set updateDate");
/* 16 */   public static final EventEnum SET_UPDATEUSERID = new EventEnum("set updateUserId");
/* 17 */   public static final EventEnum SET_FAILUREMESSAGE = new EventEnum("set failureMessage");
/* 18 */   public static final EventEnum SET_FAILEDDATA = new EventEnum("set failedData");
/* 19 */   public static final EventEnum ADD_PROPERTIES = new EventEnum("add Properties");
/* 20 */   public static final EventEnum REMOVE_PROPERTIES = new EventEnum("remove Properties");
/* 21 */   public static final EventEnum SET_PROPERTIES = new EventEnum("set Properties");
/* 22 */   public static final EventEnum START_TRANSACTION = new EventEnum("start transaction");
/* 23 */   public static final EventEnum ROLLBACK_TRANSACTION = new EventEnum("rollback transaction");
/* 24 */   public static final EventEnum COMMIT_TRANSACTION = new EventEnum("commit transaction");
/*    */   
/*    */   void setDAO(IDataAccessObject paramIDataAccessObject);
/*    */   
/*    */   long getOrganizationId();
/*    */   
/*    */   void setOrganizationId(long paramLong);
/*    */   
/*    */   String getFileName();
/*    */   
/*    */   void setFileName(String paramString);
/*    */   
/*    */   long getRunTime();
/*    */   
/*    */   void setRunTime(long paramLong);
/*    */   
/*    */   int getFailureSequence();
/*    */   
/*    */   void setFailureSequence(int paramInt);
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
/*    */   String getFailureMessage();
/*    */   
/*    */   void setFailureMessage(String paramString);
/*    */   
/*    */   String getFailedData();
/*    */   
/*    */   void setFailedData(String paramString);
/*    */   
/*    */   IDataModel getDataLoaderFailureExt();
/*    */   
/*    */   void setDataLoaderFailureExt(IDataModel paramIDataModel);
/*    */   
/*    */   List<IDataLoaderFailureProperty> getProperties();
/*    */   
/*    */   void setProperties(List<IDataLoaderFailureProperty> paramList);
/*    */   
/*    */   void addDataLoaderFailureProperty(IDataLoaderFailureProperty paramIDataLoaderFailureProperty);
/*    */   
/*    */   void removeDataLoaderFailureProperty(IDataLoaderFailureProperty paramIDataLoaderFailureProperty);
/*    */   
/*    */   void startTransaction();
/*    */   
/*    */   void rollbackChanges();
/*    */   
/*    */   void commitTransaction();
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\ctl\IDataLoaderFailure.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */