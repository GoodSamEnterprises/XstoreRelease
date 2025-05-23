/*    */ package dtv.xst.dao.hrs;
/*    */ import dtv.data2.access.IDataAccessObject;
/*    */ import dtv.data2.access.IDataModel;
/*    */ import dtv.event.EventEnum;
/*    */ import java.util.Date;
/*    */ import java.util.List;
/*    */ 
/*    */ public interface IEmployeeMessage extends IDataModel, IEmployeeMessageModel, IHasDataProperty<IEmployeeMessageProperty> {
/*  9 */   public static final EventEnum SET_ORGANIZATIONID = new EventEnum("set organizationId");
/* 10 */   public static final EventEnum SET_MESSAGEID = new EventEnum("set messageId");
/* 11 */   public static final EventEnum SET_ORGCODE = new EventEnum("set orgCode");
/* 12 */   public static final EventEnum SET_ORGVALUE = new EventEnum("set orgValue");
/* 13 */   public static final EventEnum SET_STARTDATE = new EventEnum("set startDate");
/* 14 */   public static final EventEnum SET_ENDDATE = new EventEnum("set endDate");
/* 15 */   public static final EventEnum SET_PRIORITY = new EventEnum("set priority");
/* 16 */   public static final EventEnum SET_STORECREATED = new EventEnum("set storeCreated");
/* 17 */   public static final EventEnum SET_WORKSTATIONSPECIFIC = new EventEnum("set workstationSpecific");
/* 18 */   public static final EventEnum SET_WORKSTATIONID = new EventEnum("set workstationId");
/* 19 */   public static final EventEnum SET_DESCRIPTION = new EventEnum("set description");
/* 20 */   public static final EventEnum SET_VOID = new EventEnum("set void");
/* 21 */   public static final EventEnum SET_MESSAGEURL = new EventEnum("set messageURL");
/* 22 */   public static final EventEnum SET_CREATEDATE = new EventEnum("set createDate");
/* 23 */   public static final EventEnum SET_CREATEUSERID = new EventEnum("set createUserId");
/* 24 */   public static final EventEnum SET_UPDATEDATE = new EventEnum("set updateDate");
/* 25 */   public static final EventEnum SET_UPDATEUSERID = new EventEnum("set updateUserId");
/* 26 */   public static final EventEnum ADD_PROPERTIES = new EventEnum("add Properties");
/* 27 */   public static final EventEnum REMOVE_PROPERTIES = new EventEnum("remove Properties");
/* 28 */   public static final EventEnum SET_PROPERTIES = new EventEnum("set Properties");
/* 29 */   public static final EventEnum START_TRANSACTION = new EventEnum("start transaction");
/* 30 */   public static final EventEnum ROLLBACK_TRANSACTION = new EventEnum("rollback transaction");
/* 31 */   public static final EventEnum COMMIT_TRANSACTION = new EventEnum("commit transaction");
/*    */   
/*    */   void setDAO(IDataAccessObject paramIDataAccessObject);
/*    */   
/*    */   long getOrganizationId();
/*    */   
/*    */   void setOrganizationId(long paramLong);
/*    */   
/*    */   long getMessageId();
/*    */   
/*    */   void setMessageId(long paramLong);
/*    */   
/*    */   String getOrgCode();
/*    */   
/*    */   void setOrgCode(String paramString);
/*    */   
/*    */   String getOrgValue();
/*    */   
/*    */   void setOrgValue(String paramString);
/*    */   
/*    */   Date getStartDate();
/*    */   
/*    */   void setStartDate(Date paramDate);
/*    */   
/*    */   Date getEndDate();
/*    */   
/*    */   void setEndDate(Date paramDate);
/*    */   
/*    */   String getPriority();
/*    */   
/*    */   void setPriority(String paramString);
/*    */   
/*    */   boolean getStoreCreated();
/*    */   
/*    */   void setStoreCreated(boolean paramBoolean);
/*    */   
/*    */   boolean getWorkstationSpecific();
/*    */   
/*    */   void setWorkstationSpecific(boolean paramBoolean);
/*    */   
/*    */   String getDescription();
/*    */   
/*    */   void setDescription(String paramString);
/*    */   
/*    */   boolean getVoid();
/*    */   
/*    */   void setVoid(boolean paramBoolean);
/*    */   
/*    */   String getMessageURL();
/*    */   
/*    */   void setMessageURL(String paramString);
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
/*    */   IDataModel getEmployeeMessageExt();
/*    */   
/*    */   void setEmployeeMessageExt(IDataModel paramIDataModel);
/*    */   
/*    */   List<IEmployeeMessageProperty> getProperties();
/*    */   
/*    */   void setProperties(List<IEmployeeMessageProperty> paramList);
/*    */   
/*    */   void addEmployeeMessageProperty(IEmployeeMessageProperty paramIEmployeeMessageProperty);
/*    */   
/*    */   void removeEmployeeMessageProperty(IEmployeeMessageProperty paramIEmployeeMessageProperty);
/*    */   
/*    */   void startTransaction();
/*    */   
/*    */   void rollbackChanges();
/*    */   
/*    */   void commitTransaction();
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\hrs\IEmployeeMessage.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */