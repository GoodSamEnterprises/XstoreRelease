/*    */ package dtv.xst.dao.trn;
/*    */ import dtv.data2.access.IDataAccessObject;
/*    */ import dtv.data2.access.IDataModel;
/*    */ import dtv.event.EventEnum;
/*    */ import java.util.Date;
/*    */ import java.util.List;
/*    */ 
/*    */ public interface ITransactionVersion extends IDataModel, IHasDataProperty<ITransactionVersionProperty> {
/*  9 */   public static final EventEnum SET_ORGANIZATIONID = new EventEnum("set organizationId");
/* 10 */   public static final EventEnum SET_RETAILLOCATIONID = new EventEnum("set retailLocationId");
/* 11 */   public static final EventEnum SET_BUSINESSDATE = new EventEnum("set businessDate");
/* 12 */   public static final EventEnum SET_WORKSTATIONID = new EventEnum("set workstationId");
/* 13 */   public static final EventEnum SET_TRANSACTIONSEQUENCE = new EventEnum("set transactionSequence");
/* 14 */   public static final EventEnum SET_CREATEDATE = new EventEnum("set createDate");
/* 15 */   public static final EventEnum SET_CREATEUSERID = new EventEnum("set createUserId");
/* 16 */   public static final EventEnum SET_UPDATEDATE = new EventEnum("set updateDate");
/* 17 */   public static final EventEnum SET_UPDATEUSERID = new EventEnum("set updateUserId");
/* 18 */   public static final EventEnum SET_BASEAPPVERSION = new EventEnum("set baseAppVersion");
/* 19 */   public static final EventEnum SET_BASEAPPDATE = new EventEnum("set baseAppDate");
/* 20 */   public static final EventEnum SET_BASESCHEMAVERSION = new EventEnum("set baseSchemaVersion");
/* 21 */   public static final EventEnum SET_BASESCHEMADATE = new EventEnum("set baseSchemaDate");
/* 22 */   public static final EventEnum SET_CUSTOMERAPPVERSION = new EventEnum("set customerAppVersion");
/* 23 */   public static final EventEnum SET_CUSTOMERSCHEMAVERSION = new EventEnum("set customerSchemaVersion");
/* 24 */   public static final EventEnum SET_CUSTOMERSCHEMADATE = new EventEnum("set customerSchemaDate");
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
/*    */   long getTransactionSequence();
/*    */   
/*    */   void setTransactionSequence(long paramLong);
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
/*    */   String getBaseAppVersion();
/*    */   
/*    */   void setBaseAppVersion(String paramString);
/*    */   
/*    */   Date getBaseAppDate();
/*    */   
/*    */   void setBaseAppDate(Date paramDate);
/*    */   
/*    */   String getBaseSchemaVersion();
/*    */   
/*    */   void setBaseSchemaVersion(String paramString);
/*    */   
/*    */   Date getBaseSchemaDate();
/*    */   
/*    */   void setBaseSchemaDate(Date paramDate);
/*    */   
/*    */   String getCustomerAppVersion();
/*    */   
/*    */   void setCustomerAppVersion(String paramString);
/*    */   
/*    */   String getCustomerSchemaVersion();
/*    */   
/*    */   void setCustomerSchemaVersion(String paramString);
/*    */   
/*    */   Date getCustomerSchemaDate();
/*    */   
/*    */   void setCustomerSchemaDate(Date paramDate);
/*    */   
/*    */   IDataModel getTransactionVersionExt();
/*    */   
/*    */   void setTransactionVersionExt(IDataModel paramIDataModel);
/*    */   
/*    */   List<ITransactionVersionProperty> getProperties();
/*    */   
/*    */   void setProperties(List<ITransactionVersionProperty> paramList);
/*    */   
/*    */   void addTransactionVersionProperty(ITransactionVersionProperty paramITransactionVersionProperty);
/*    */   
/*    */   void removeTransactionVersionProperty(ITransactionVersionProperty paramITransactionVersionProperty);
/*    */   
/*    */   void startTransaction();
/*    */   
/*    */   void rollbackChanges();
/*    */   
/*    */   void commitTransaction();
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\trn\ITransactionVersion.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */