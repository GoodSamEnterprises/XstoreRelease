/*    */ package dtv.xst.dao._test;
/*    */ import dtv.data2.access.IDataAccessObject;
/*    */ import dtv.data2.access.IDataModel;
/*    */ import dtv.event.EventEnum;
/*    */ import java.util.Date;
/*    */ import java.util.List;
/*    */ 
/*    */ public interface IXunitResult extends IDataModel, IHasDataProperty<IXunitResultProperty> {
/*  9 */   public static final EventEnum SET_ORGANIZATIONID = new EventEnum("set organizationId");
/* 10 */   public static final EventEnum SET_HOSTNAME = new EventEnum("set hostname");
/* 11 */   public static final EventEnum SET_RESULTTIMESTAMP = new EventEnum("set resultTimestamp");
/* 12 */   public static final EventEnum SET_CREATEDATE = new EventEnum("set createDate");
/* 13 */   public static final EventEnum SET_CREATEUSERID = new EventEnum("set createUserId");
/* 14 */   public static final EventEnum SET_UPDATEDATE = new EventEnum("set updateDate");
/* 15 */   public static final EventEnum SET_UPDATEUSERID = new EventEnum("set updateUserId");
/* 16 */   public static final EventEnum SET_IPADDRESS = new EventEnum("set ipAddress");
/* 17 */   public static final EventEnum SET_RETAILLOCATIONID = new EventEnum("set retailLocationId");
/* 18 */   public static final EventEnum SET_BUSINESSDATE = new EventEnum("set businessDate");
/* 19 */   public static final EventEnum SET_WORKSTATIONID = new EventEnum("set workstationId");
/* 20 */   public static final EventEnum SET_XSTOREVERSION = new EventEnum("set xstoreVersion");
/* 21 */   public static final EventEnum SET_STATUS = new EventEnum("set status");
/* 22 */   public static final EventEnum SET_BEGINDATETIMESTAMP = new EventEnum("set beginDatetimestamp");
/* 23 */   public static final EventEnum SET_ENDDATETIMESTAMP = new EventEnum("set endDatetimestamp");
/* 24 */   public static final EventEnum SET_TOTALCOUNT = new EventEnum("set totalCount");
/* 25 */   public static final EventEnum SET_COMPLETEDCOUNT = new EventEnum("set completedCount");
/* 26 */   public static final EventEnum SET_FAILEDCOUNT = new EventEnum("set failedCount");
/* 27 */   public static final EventEnum ADD_RESULTITEMS = new EventEnum("add ResultItems");
/* 28 */   public static final EventEnum REMOVE_RESULTITEMS = new EventEnum("remove ResultItems");
/* 29 */   public static final EventEnum SET_RESULTITEMS = new EventEnum("set ResultItems");
/* 30 */   public static final EventEnum ADD_PROPERTIES = new EventEnum("add Properties");
/* 31 */   public static final EventEnum REMOVE_PROPERTIES = new EventEnum("remove Properties");
/* 32 */   public static final EventEnum SET_PROPERTIES = new EventEnum("set Properties");
/* 33 */   public static final EventEnum START_TRANSACTION = new EventEnum("start transaction");
/* 34 */   public static final EventEnum ROLLBACK_TRANSACTION = new EventEnum("rollback transaction");
/* 35 */   public static final EventEnum COMMIT_TRANSACTION = new EventEnum("commit transaction");
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
/*    */   String getIpAddress();
/*    */   
/*    */   void setIpAddress(String paramString);
/*    */   
/*    */   long getRetailLocationId();
/*    */   
/*    */   void setRetailLocationId(long paramLong);
/*    */   
/*    */   Date getBusinessDate();
/*    */   
/*    */   void setBusinessDate(Date paramDate);
/*    */   
/*    */   long getWorkstationId();
/*    */   
/*    */   void setWorkstationId(long paramLong);
/*    */   
/*    */   String getXstoreVersion();
/*    */   
/*    */   void setXstoreVersion(String paramString);
/*    */   
/*    */   String getStatus();
/*    */   
/*    */   void setStatus(String paramString);
/*    */   
/*    */   Date getBeginDatetimestamp();
/*    */   
/*    */   void setBeginDatetimestamp(Date paramDate);
/*    */   
/*    */   Date getEndDatetimestamp();
/*    */   
/*    */   void setEndDatetimestamp(Date paramDate);
/*    */   
/*    */   long getTotalCount();
/*    */   
/*    */   void setTotalCount(long paramLong);
/*    */   
/*    */   long getCompletedCount();
/*    */   
/*    */   void setCompletedCount(long paramLong);
/*    */   
/*    */   long getFailedCount();
/*    */   
/*    */   void setFailedCount(long paramLong);
/*    */   
/*    */   IDataModel getXunitResultExt();
/*    */   
/*    */   void setXunitResultExt(IDataModel paramIDataModel);
/*    */   
/*    */   List<IXunitResultItem> getResultItems();
/*    */   
/*    */   void setResultItems(List<IXunitResultItem> paramList);
/*    */   
/*    */   void addXunitResultItem(IXunitResultItem paramIXunitResultItem);
/*    */   
/*    */   void removeXunitResultItem(IXunitResultItem paramIXunitResultItem);
/*    */   
/*    */   List<IXunitResultProperty> getProperties();
/*    */   
/*    */   void setProperties(List<IXunitResultProperty> paramList);
/*    */   
/*    */   void addXunitResultProperty(IXunitResultProperty paramIXunitResultProperty);
/*    */   
/*    */   void removeXunitResultProperty(IXunitResultProperty paramIXunitResultProperty);
/*    */   
/*    */   void startTransaction();
/*    */   
/*    */   void rollbackChanges();
/*    */   
/*    */   void commitTransaction();
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\_test\IXunitResult.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */