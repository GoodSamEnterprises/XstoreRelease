/*    */ package dtv.xst.dao.cwo;
/*    */ import dtv.data2.access.IDataModel;
/*    */ import dtv.event.EventEnum;
/*    */ import dtv.xst.dao.com.IAddress;
/*    */ import java.util.Date;
/*    */ import java.util.List;
/*    */ 
/*    */ public interface IServiceLocation extends IDataModel, IHasDataProperty<IServiceLocationProperty> {
/*  9 */   public static final EventEnum SET_ORGANIZATIONID = new EventEnum("set organizationId");
/* 10 */   public static final EventEnum SET_SERVICELOCATIONID = new EventEnum("set serviceLocationId");
/* 11 */   public static final EventEnum SET_CREATEDATE = new EventEnum("set createDate");
/* 12 */   public static final EventEnum SET_CREATEUSERID = new EventEnum("set createUserId");
/* 13 */   public static final EventEnum SET_UPDATEDATE = new EventEnum("set updateDate");
/* 14 */   public static final EventEnum SET_UPDATEUSERID = new EventEnum("set updateUserId");
/* 15 */   public static final EventEnum SET_ORGCODE = new EventEnum("set orgCode");
/* 16 */   public static final EventEnum SET_ORGVALUE = new EventEnum("set orgValue");
/* 17 */   public static final EventEnum SET_SERVICELOCDESCRIPTION = new EventEnum("set serviceLocDescription");
/* 18 */   public static final EventEnum SET_PARTYID = new EventEnum("set partyId");
/* 19 */   public static final EventEnum SET_ADDRESSID = new EventEnum("set addressId");
/* 20 */   public static final EventEnum SET_ADDRESS = new EventEnum("set Address");
/* 21 */   public static final EventEnum ADD_PROPERTIES = new EventEnum("add Properties");
/* 22 */   public static final EventEnum REMOVE_PROPERTIES = new EventEnum("remove Properties");
/* 23 */   public static final EventEnum SET_PROPERTIES = new EventEnum("set Properties");
/* 24 */   public static final EventEnum START_TRANSACTION = new EventEnum("start transaction");
/* 25 */   public static final EventEnum ROLLBACK_TRANSACTION = new EventEnum("rollback transaction");
/* 26 */   public static final EventEnum COMMIT_TRANSACTION = new EventEnum("commit transaction");
/*    */   
/*    */   void setDAO(IDataAccessObject paramIDataAccessObject);
/*    */   
/*    */   long getOrganizationId();
/*    */   
/*    */   void setOrganizationId(long paramLong);
/*    */   
/*    */   String getServiceLocationId();
/*    */   
/*    */   void setServiceLocationId(String paramString);
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
/*    */   String getServiceLocDescription();
/*    */   
/*    */   void setServiceLocDescription(String paramString);
/*    */   
/*    */   long getPartyId();
/*    */   
/*    */   void setPartyId(long paramLong);
/*    */   
/*    */   IDataModel getServiceLocationExt();
/*    */   
/*    */   void setServiceLocationExt(IDataModel paramIDataModel);
/*    */   
/*    */   IAddress getAddress();
/*    */   
/*    */   void setAddress(IAddress paramIAddress);
/*    */   
/*    */   List<IServiceLocationProperty> getProperties();
/*    */   
/*    */   void setProperties(List<IServiceLocationProperty> paramList);
/*    */   
/*    */   void addServiceLocationProperty(IServiceLocationProperty paramIServiceLocationProperty);
/*    */   
/*    */   void removeServiceLocationProperty(IServiceLocationProperty paramIServiceLocationProperty);
/*    */   
/*    */   void startTransaction();
/*    */   
/*    */   void rollbackChanges();
/*    */   
/*    */   void commitTransaction();
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\cwo\IServiceLocation.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */