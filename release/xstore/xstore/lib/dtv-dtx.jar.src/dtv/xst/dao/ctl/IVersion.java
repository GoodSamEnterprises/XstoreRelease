/*    */ package dtv.xst.dao.ctl;
/*    */ import dtv.data2.access.IDataAccessObject;
/*    */ import dtv.data2.access.IDataModel;
/*    */ import dtv.event.EventEnum;
/*    */ import java.util.Date;
/*    */ import java.util.List;
/*    */ 
/*    */ public interface IVersion extends IDataModel, IHasDataProperty<IVersionProperty> {
/*  9 */   public static final EventEnum SET_ORGANIZATIONID = new EventEnum("set organizationId");
/* 10 */   public static final EventEnum SET_CREATEDATE = new EventEnum("set createDate");
/* 11 */   public static final EventEnum SET_CREATEUSERID = new EventEnum("set createUserId");
/* 12 */   public static final EventEnum SET_UPDATEDATE = new EventEnum("set updateDate");
/* 13 */   public static final EventEnum SET_UPDATEUSERID = new EventEnum("set updateUserId");
/* 14 */   public static final EventEnum SET_BASESCHEMAVERSION = new EventEnum("set baseSchemaVersion");
/* 15 */   public static final EventEnum SET_CUSTOMERSCHEMAVERSION = new EventEnum("set customerSchemaVersion");
/* 16 */   public static final EventEnum SET_CUSTOMER = new EventEnum("set customer");
/* 17 */   public static final EventEnum SET_BASESCHEMADATE = new EventEnum("set baseSchemaDate");
/* 18 */   public static final EventEnum SET_CUSTOMERSCHEMADATE = new EventEnum("set customerSchemaDate");
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
/*    */   String getBaseSchemaVersion();
/*    */   
/*    */   void setBaseSchemaVersion(String paramString);
/*    */   
/*    */   String getCustomerSchemaVersion();
/*    */   
/*    */   void setCustomerSchemaVersion(String paramString);
/*    */   
/*    */   String getCustomer();
/*    */   
/*    */   void setCustomer(String paramString);
/*    */   
/*    */   Date getBaseSchemaDate();
/*    */   
/*    */   void setBaseSchemaDate(Date paramDate);
/*    */   
/*    */   Date getCustomerSchemaDate();
/*    */   
/*    */   void setCustomerSchemaDate(Date paramDate);
/*    */   
/*    */   IDataModel getVersionExt();
/*    */   
/*    */   void setVersionExt(IDataModel paramIDataModel);
/*    */   
/*    */   List<IVersionProperty> getProperties();
/*    */   
/*    */   void setProperties(List<IVersionProperty> paramList);
/*    */   
/*    */   void addVersionProperty(IVersionProperty paramIVersionProperty);
/*    */   
/*    */   void removeVersionProperty(IVersionProperty paramIVersionProperty);
/*    */   
/*    */   void startTransaction();
/*    */   
/*    */   void rollbackChanges();
/*    */   
/*    */   void commitTransaction();
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\ctl\IVersion.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */