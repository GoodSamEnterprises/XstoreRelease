/*    */ package dtv.xst.dao._test;
/*    */ import dtv.data2.access.IDataAccessObject;
/*    */ import dtv.data2.access.IDataModel;
/*    */ import dtv.event.EventEnum;
/*    */ import java.util.Date;
/*    */ import java.util.List;
/*    */ 
/*    */ public interface IXunitResultItem extends IDataModel, IHasDataProperty<IXunitResultItemProperty> {
/*  9 */   public static final EventEnum SET_ORGANIZATIONID = new EventEnum("set organizationId");
/* 10 */   public static final EventEnum SET_HOSTNAME = new EventEnum("set hostname");
/* 11 */   public static final EventEnum SET_RESULTTIMESTAMP = new EventEnum("set resultTimestamp");
/* 12 */   public static final EventEnum SET_RESULTITEMSEQUENCE = new EventEnum("set resultItemSequence");
/* 13 */   public static final EventEnum SET_CREATEDATE = new EventEnum("set createDate");
/* 14 */   public static final EventEnum SET_CREATEUSERID = new EventEnum("set createUserId");
/* 15 */   public static final EventEnum SET_UPDATEDATE = new EventEnum("set updateDate");
/* 16 */   public static final EventEnum SET_UPDATEUSERID = new EventEnum("set updateUserId");
/* 17 */   public static final EventEnum SET_TESTCASENAME = new EventEnum("set testCaseName");
/* 18 */   public static final EventEnum SET_TESTNUMBER = new EventEnum("set testNumber");
/* 19 */   public static final EventEnum SET_TESTITERATION = new EventEnum("set testIteration");
/* 20 */   public static final EventEnum SET_RESULTITEMSTATUS = new EventEnum("set resultItemStatus");
/* 21 */   public static final EventEnum SET_RESULTITEMDATETIMESTAMP = new EventEnum("set resultItemDatetimestamp");
/* 22 */   public static final EventEnum SET_FAILUREREASON = new EventEnum("set failureReason");
/* 23 */   public static final EventEnum SET_LOGDATA = new EventEnum("set logData");
/* 24 */   public static final EventEnum ADD_PROPERTIES = new EventEnum("add Properties");
/* 25 */   public static final EventEnum REMOVE_PROPERTIES = new EventEnum("remove Properties");
/* 26 */   public static final EventEnum SET_PROPERTIES = new EventEnum("set Properties");
/* 27 */   public static final EventEnum START_TRANSACTION = new EventEnum("start transaction");
/* 28 */   public static final EventEnum ROLLBACK_TRANSACTION = new EventEnum("rollback transaction");
/* 29 */   public static final EventEnum COMMIT_TRANSACTION = new EventEnum("commit transaction");
/*    */   
/*    */   void setDAO(IDataAccessObject paramIDataAccessObject);
/*    */   
/*    */   long getOrganizationId();
/*    */   
/*    */   void setOrganizationId(long paramLong);
/*    */   
/*    */   String getHostname();
/*    */   
/*    */   void setHostname(String paramString);
/*    */   
/*    */   long getResultTimestamp();
/*    */   
/*    */   void setResultTimestamp(long paramLong);
/*    */   
/*    */   long getResultItemSequence();
/*    */   
/*    */   void setResultItemSequence(long paramLong);
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
/*    */   String getTestCaseName();
/*    */   
/*    */   void setTestCaseName(String paramString);
/*    */   
/*    */   long getTestNumber();
/*    */   
/*    */   void setTestNumber(long paramLong);
/*    */   
/*    */   long getTestIteration();
/*    */   
/*    */   void setTestIteration(long paramLong);
/*    */   
/*    */   String getResultItemStatus();
/*    */   
/*    */   void setResultItemStatus(String paramString);
/*    */   
/*    */   Date getResultItemDatetimestamp();
/*    */   
/*    */   void setResultItemDatetimestamp(Date paramDate);
/*    */   
/*    */   String getFailureReason();
/*    */   
/*    */   void setFailureReason(String paramString);
/*    */   
/*    */   String getLogData();
/*    */   
/*    */   void setLogData(String paramString);
/*    */   
/*    */   IDataModel getXunitResultItemExt();
/*    */   
/*    */   void setXunitResultItemExt(IDataModel paramIDataModel);
/*    */   
/*    */   List<IXunitResultItemProperty> getProperties();
/*    */   
/*    */   void setProperties(List<IXunitResultItemProperty> paramList);
/*    */   
/*    */   void addXunitResultItemProperty(IXunitResultItemProperty paramIXunitResultItemProperty);
/*    */   
/*    */   void removeXunitResultItemProperty(IXunitResultItemProperty paramIXunitResultItemProperty);
/*    */   
/*    */   void setParentResult(IXunitResult paramIXunitResult);
/*    */   
/*    */   IXunitResult getParentResult();
/*    */   
/*    */   void startTransaction();
/*    */   
/*    */   void rollbackChanges();
/*    */   
/*    */   void commitTransaction();
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\_test\IXunitResultItem.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */