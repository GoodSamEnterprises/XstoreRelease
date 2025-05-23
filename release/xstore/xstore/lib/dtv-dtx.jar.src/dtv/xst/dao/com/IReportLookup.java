/*    */ package dtv.xst.dao.com;
/*    */ import dtv.data2.access.IDataAccessObject;
/*    */ import dtv.data2.access.IDataModel;
/*    */ import dtv.event.EventEnum;
/*    */ import java.util.Date;
/*    */ import java.util.List;
/*    */ 
/*    */ public interface IReportLookup extends IDataModel, IHasDataProperty<IReportLookupProperty> {
/*  9 */   public static final EventEnum SET_ORGANIZATIONID = new EventEnum("set organizationId");
/* 10 */   public static final EventEnum SET_OWNERID = new EventEnum("set ownerId");
/* 11 */   public static final EventEnum SET_OWNERTYPE = new EventEnum("set ownerType");
/* 12 */   public static final EventEnum SET_REPORTID = new EventEnum("set reportId");
/* 13 */   public static final EventEnum SET_CREATEDATE = new EventEnum("set createDate");
/* 14 */   public static final EventEnum SET_CREATEUSERID = new EventEnum("set createUserId");
/* 15 */   public static final EventEnum SET_UPDATEDATE = new EventEnum("set updateDate");
/* 16 */   public static final EventEnum SET_UPDATEUSERID = new EventEnum("set updateUserId");
/* 17 */   public static final EventEnum SET_ORGCODE = new EventEnum("set orgCode");
/* 18 */   public static final EventEnum SET_ORGVALUE = new EventEnum("set orgValue");
/* 19 */   public static final EventEnum SET_REPORTURL = new EventEnum("set reportUrl");
/* 20 */   public static final EventEnum SET_DESCRIPTION = new EventEnum("set description");
/* 21 */   public static final EventEnum SET_RECORDTYPE = new EventEnum("set recordType");
/* 22 */   public static final EventEnum SET_RECORDCREATIONDATE = new EventEnum("set recordCreationDate");
/* 23 */   public static final EventEnum SET_RECORDLEVEL = new EventEnum("set recordLevel");
/* 24 */   public static final EventEnum SET_PARENTREPORTID = new EventEnum("set parentReportId");
/* 25 */   public static final EventEnum SET_DELETE = new EventEnum("set delete");
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
/*    */   String getOwnerId();
/*    */   
/*    */   void setOwnerId(String paramString);
/*    */   
/*    */   String getOwnerType();
/*    */   
/*    */   void setOwnerType(String paramString);
/*    */   
/*    */   String getReportId();
/*    */   
/*    */   void setReportId(String paramString);
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
/*    */   String getOrgCode();
/*    */   
/*    */   void setOrgCode(String paramString);
/*    */   
/*    */   String getOrgValue();
/*    */   
/*    */   void setOrgValue(String paramString);
/*    */   
/*    */   String getReportUrl();
/*    */   
/*    */   void setReportUrl(String paramString);
/*    */   
/*    */   String getDescription();
/*    */   
/*    */   void setDescription(String paramString);
/*    */   
/*    */   String getRecordType();
/*    */   
/*    */   void setRecordType(String paramString);
/*    */   
/*    */   Date getRecordCreationDate();
/*    */   
/*    */   void setRecordCreationDate(Date paramDate);
/*    */   
/*    */   String getRecordLevel();
/*    */   
/*    */   void setRecordLevel(String paramString);
/*    */   
/*    */   String getParentReportId();
/*    */   
/*    */   void setParentReportId(String paramString);
/*    */   
/*    */   boolean getDelete();
/*    */   
/*    */   void setDelete(boolean paramBoolean);
/*    */   
/*    */   IDataModel getReportLookupExt();
/*    */   
/*    */   void setReportLookupExt(IDataModel paramIDataModel);
/*    */   
/*    */   List<IReportLookupProperty> getProperties();
/*    */   
/*    */   void setProperties(List<IReportLookupProperty> paramList);
/*    */   
/*    */   void addReportLookupProperty(IReportLookupProperty paramIReportLookupProperty);
/*    */   
/*    */   void removeReportLookupProperty(IReportLookupProperty paramIReportLookupProperty);
/*    */   
/*    */   void startTransaction();
/*    */   
/*    */   void rollbackChanges();
/*    */   
/*    */   void commitTransaction();
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\com\IReportLookup.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */