/*    */ package dtv.xst.dao.xom;
/*    */ import dtv.data2.access.IDataAccessObject;
/*    */ import dtv.data2.access.IDataModel;
/*    */ import dtv.event.EventEnum;
/*    */ import java.util.Date;
/*    */ import java.util.List;
/*    */ 
/*    */ public interface IFulfillmentModifier extends IDataModel, IFulfillmentModifierModel, IHasDataProperty<IFulfillmentModifierProperty> {
/*  9 */   public static final EventEnum SET_ORGANIZATIONID = new EventEnum("set organizationId");
/* 10 */   public static final EventEnum SET_ORDERID = new EventEnum("set orderId");
/* 11 */   public static final EventEnum SET_SEQUENCE = new EventEnum("set sequence");
/* 12 */   public static final EventEnum SET_CREATEDATE = new EventEnum("set createDate");
/* 13 */   public static final EventEnum SET_CREATEUSERID = new EventEnum("set createUserId");
/* 14 */   public static final EventEnum SET_UPDATEDATE = new EventEnum("set updateDate");
/* 15 */   public static final EventEnum SET_UPDATEUSERID = new EventEnum("set updateUserId");
/* 16 */   public static final EventEnum SET_LOCATIONID = new EventEnum("set locationId");
/* 17 */   public static final EventEnum SET_ORGANIZATIONNAME = new EventEnum("set organizationName");
/* 18 */   public static final EventEnum SET_SALUTATION = new EventEnum("set salutation");
/* 19 */   public static final EventEnum SET_LOCATIONNAME1 = new EventEnum("set locationName1");
/* 20 */   public static final EventEnum SET_LOCATIONNAME2 = new EventEnum("set locationName2");
/* 21 */   public static final EventEnum SET_MIDDLENAME = new EventEnum("set middleName");
/* 22 */   public static final EventEnum SET_SUFFIX = new EventEnum("set suffix");
/* 23 */   public static final EventEnum SET_ADDRESSSEQUENCE = new EventEnum("set addressSequence");
/* 24 */   public static final EventEnum SET_TELEPHONE1 = new EventEnum("set telephone1");
/* 25 */   public static final EventEnum SET_EMAILADDRESS = new EventEnum("set emailAddress");
/* 26 */   public static final EventEnum SET_ADDRESS = new EventEnum("set Address");
/* 27 */   public static final EventEnum ADD_PROPERTIES = new EventEnum("add Properties");
/* 28 */   public static final EventEnum REMOVE_PROPERTIES = new EventEnum("remove Properties");
/* 29 */   public static final EventEnum SET_PROPERTIES = new EventEnum("set Properties");
/* 30 */   public static final EventEnum START_TRANSACTION = new EventEnum("start transaction");
/* 31 */   public static final EventEnum ROLLBACK_TRANSACTION = new EventEnum("rollback transaction");
/* 32 */   public static final EventEnum COMMIT_TRANSACTION = new EventEnum("commit transaction");
/*    */   
/*    */   void setDAO(IDataAccessObject paramIDataAccessObject);
/*    */   
/*    */   long getOrganizationId();
/*    */   
/*    */   void setOrganizationId(long paramLong);
/*    */   
/*    */   String getOrderId();
/*    */   
/*    */   void setOrderId(String paramString);
/*    */   
/*    */   int getSequence();
/*    */   
/*    */   void setSequence(int paramInt);
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
/*    */   String getLocationId();
/*    */   
/*    */   void setLocationId(String paramString);
/*    */   
/*    */   String getOrganizationName();
/*    */   
/*    */   void setOrganizationName(String paramString);
/*    */   
/*    */   String getSalutation();
/*    */   
/*    */   void setSalutation(String paramString);
/*    */   
/*    */   String getLocationName1();
/*    */   
/*    */   void setLocationName1(String paramString);
/*    */   
/*    */   String getLocationName2();
/*    */   
/*    */   void setLocationName2(String paramString);
/*    */   
/*    */   String getMiddleName();
/*    */   
/*    */   void setMiddleName(String paramString);
/*    */   
/*    */   String getSuffix();
/*    */   
/*    */   void setSuffix(String paramString);
/*    */   
/*    */   long getAddressSequence();
/*    */   
/*    */   void setAddressSequence(long paramLong);
/*    */   
/*    */   String getTelephone1();
/*    */   
/*    */   void setTelephone1(String paramString);
/*    */   
/*    */   String getEmailAddress();
/*    */   
/*    */   void setEmailAddress(String paramString);
/*    */   
/*    */   IDataModel getFulfillmentModifierExt();
/*    */   
/*    */   void setFulfillmentModifierExt(IDataModel paramIDataModel);
/*    */   
/*    */   IAddressModifier getAddress();
/*    */   
/*    */   void setAddress(IAddressModifier paramIAddressModifier);
/*    */   
/*    */   List<IFulfillmentModifierProperty> getProperties();
/*    */   
/*    */   void setProperties(List<IFulfillmentModifierProperty> paramList);
/*    */   
/*    */   void addFulfillmentModifierProperty(IFulfillmentModifierProperty paramIFulfillmentModifierProperty);
/*    */   
/*    */   void removeFulfillmentModifierProperty(IFulfillmentModifierProperty paramIFulfillmentModifierProperty);
/*    */   
/*    */   void setParentLine(IOrderLine paramIOrderLine);
/*    */   
/*    */   IOrderLine getParentLine();
/*    */   
/*    */   void startTransaction();
/*    */   
/*    */   void rollbackChanges();
/*    */   
/*    */   void commitTransaction();
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\xom\IFulfillmentModifier.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */