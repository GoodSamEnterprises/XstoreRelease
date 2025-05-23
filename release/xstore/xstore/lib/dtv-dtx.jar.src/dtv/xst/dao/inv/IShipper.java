/*    */ package dtv.xst.dao.inv;
/*    */ import dtv.data2.access.IDataAccessObject;
/*    */ import dtv.data2.access.IDataModel;
/*    */ import dtv.event.EventEnum;
/*    */ import java.util.Date;
/*    */ import java.util.List;
/*    */ 
/*    */ public interface IShipper extends IDataModel, IHasDataProperty<IShipperProperty> {
/*  9 */   public static final EventEnum SET_ORGANIZATIONID = new EventEnum("set organizationId");
/* 10 */   public static final EventEnum SET_SHIPPERID = new EventEnum("set shipperId");
/* 11 */   public static final EventEnum SET_ORGCODE = new EventEnum("set orgCode");
/* 12 */   public static final EventEnum SET_ORGVALUE = new EventEnum("set orgValue");
/* 13 */   public static final EventEnum SET_CREATEDATE = new EventEnum("set createDate");
/* 14 */   public static final EventEnum SET_CREATEUSERID = new EventEnum("set createUserId");
/* 15 */   public static final EventEnum SET_UPDATEDATE = new EventEnum("set updateDate");
/* 16 */   public static final EventEnum SET_UPDATEUSERID = new EventEnum("set updateUserId");
/* 17 */   public static final EventEnum SET_SHIPPERDESC = new EventEnum("set shipperDesc");
/* 18 */   public static final EventEnum SET_DISPLAYORDER = new EventEnum("set displayOrder");
/* 19 */   public static final EventEnum SET_TRACKINGNUMBERENABLED = new EventEnum("set trackingNumberEnabled");
/* 20 */   public static final EventEnum ADD_PROPERTIES = new EventEnum("add Properties");
/* 21 */   public static final EventEnum REMOVE_PROPERTIES = new EventEnum("remove Properties");
/* 22 */   public static final EventEnum SET_PROPERTIES = new EventEnum("set Properties");
/* 23 */   public static final EventEnum START_TRANSACTION = new EventEnum("start transaction");
/* 24 */   public static final EventEnum ROLLBACK_TRANSACTION = new EventEnum("rollback transaction");
/* 25 */   public static final EventEnum COMMIT_TRANSACTION = new EventEnum("commit transaction");
/*    */   
/*    */   void setDAO(IDataAccessObject paramIDataAccessObject);
/*    */   
/*    */   long getOrganizationId();
/*    */   
/*    */   void setOrganizationId(long paramLong);
/*    */   
/*    */   String getShipperId();
/*    */   
/*    */   void setShipperId(String paramString);
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
/*    */   String getShipperDesc();
/*    */   
/*    */   void setShipperDesc(String paramString);
/*    */   
/*    */   int getDisplayOrder();
/*    */   
/*    */   void setDisplayOrder(int paramInt);
/*    */   
/*    */   boolean getTrackingNumberEnabled();
/*    */   
/*    */   void setTrackingNumberEnabled(boolean paramBoolean);
/*    */   
/*    */   IDataModel getShipperExt();
/*    */   
/*    */   void setShipperExt(IDataModel paramIDataModel);
/*    */   
/*    */   List<IShipperProperty> getProperties();
/*    */   
/*    */   void setProperties(List<IShipperProperty> paramList);
/*    */   
/*    */   void addShipperProperty(IShipperProperty paramIShipperProperty);
/*    */   
/*    */   void removeShipperProperty(IShipperProperty paramIShipperProperty);
/*    */   
/*    */   void startTransaction();
/*    */   
/*    */   void rollbackChanges();
/*    */   
/*    */   void commitTransaction();
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\inv\IShipper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */