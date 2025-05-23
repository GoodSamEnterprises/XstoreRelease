/*    */ package dtv.xst.dao.inv;
/*    */ import dtv.data2.access.IDataAccessObject;
/*    */ import dtv.data2.access.IDataModel;
/*    */ import dtv.event.EventEnum;
/*    */ import java.util.Date;
/*    */ import java.util.List;
/*    */ 
/*    */ public interface IShipperMethod extends IDataModel, IHasDataProperty<IShipperMethodProperty> {
/*  9 */   public static final EventEnum SET_ORGANIZATIONID = new EventEnum("set organizationId");
/* 10 */   public static final EventEnum SET_SHIPPERMETHODID = new EventEnum("set shipperMethodId");
/* 11 */   public static final EventEnum SET_ORGCODE = new EventEnum("set orgCode");
/* 12 */   public static final EventEnum SET_ORGVALUE = new EventEnum("set orgValue");
/* 13 */   public static final EventEnum SET_CREATEDATE = new EventEnum("set createDate");
/* 14 */   public static final EventEnum SET_CREATEUSERID = new EventEnum("set createUserId");
/* 15 */   public static final EventEnum SET_UPDATEDATE = new EventEnum("set updateDate");
/* 16 */   public static final EventEnum SET_UPDATEUSERID = new EventEnum("set updateUserId");
/* 17 */   public static final EventEnum SET_SHIPPERMETHODDESC = new EventEnum("set shipperMethodDesc");
/* 18 */   public static final EventEnum SET_SHIPPERID = new EventEnum("set shipperId");
/* 19 */   public static final EventEnum SET_DOMESTICSERVICECODE = new EventEnum("set domesticServiceCode");
/* 20 */   public static final EventEnum SET_INTLSERVICECODE = new EventEnum("set intlServiceCode");
/* 21 */   public static final EventEnum SET_DISPLAYORDER = new EventEnum("set displayOrder");
/* 22 */   public static final EventEnum SET_PRIORITY = new EventEnum("set priority");
/* 23 */   public static final EventEnum ADD_PROPERTIES = new EventEnum("add Properties");
/* 24 */   public static final EventEnum REMOVE_PROPERTIES = new EventEnum("remove Properties");
/* 25 */   public static final EventEnum SET_PROPERTIES = new EventEnum("set Properties");
/* 26 */   public static final EventEnum START_TRANSACTION = new EventEnum("start transaction");
/* 27 */   public static final EventEnum ROLLBACK_TRANSACTION = new EventEnum("rollback transaction");
/* 28 */   public static final EventEnum COMMIT_TRANSACTION = new EventEnum("commit transaction");
/*    */   
/*    */   void setDAO(IDataAccessObject paramIDataAccessObject);
/*    */   
/*    */   long getOrganizationId();
/*    */   
/*    */   void setOrganizationId(long paramLong);
/*    */   
/*    */   String getShipperMethodId();
/*    */   
/*    */   void setShipperMethodId(String paramString);
/*    */   
/*    */   String getOrgCode();
/*    */   
/*    */   void setOrgCode(String paramString);
/*    */   
/*    */   String getOrgValue();
/*    */   
/*    */   void setOrgValue(String paramString);
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
/*    */   String getShipperMethodDesc();
/*    */   
/*    */   void setShipperMethodDesc(String paramString);
/*    */   
/*    */   String getShipperId();
/*    */   
/*    */   void setShipperId(String paramString);
/*    */   
/*    */   String getDomesticServiceCode();
/*    */   
/*    */   void setDomesticServiceCode(String paramString);
/*    */   
/*    */   String getIntlServiceCode();
/*    */   
/*    */   void setIntlServiceCode(String paramString);
/*    */   
/*    */   int getDisplayOrder();
/*    */   
/*    */   void setDisplayOrder(int paramInt);
/*    */   
/*    */   int getPriority();
/*    */   
/*    */   void setPriority(int paramInt);
/*    */   
/*    */   IDataModel getShipperMethodExt();
/*    */   
/*    */   void setShipperMethodExt(IDataModel paramIDataModel);
/*    */   
/*    */   List<IShipperMethodProperty> getProperties();
/*    */   
/*    */   void setProperties(List<IShipperMethodProperty> paramList);
/*    */   
/*    */   void addShipperMethodProperty(IShipperMethodProperty paramIShipperMethodProperty);
/*    */   
/*    */   void removeShipperMethodProperty(IShipperMethodProperty paramIShipperMethodProperty);
/*    */   
/*    */   void startTransaction();
/*    */   
/*    */   void rollbackChanges();
/*    */   
/*    */   void commitTransaction();
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\inv\IShipperMethod.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */