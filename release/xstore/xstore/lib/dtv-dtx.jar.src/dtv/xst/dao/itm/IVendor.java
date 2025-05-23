/*    */ package dtv.xst.dao.itm;
/*    */ import dtv.data2.access.IDataAccessObject;
/*    */ import dtv.data2.access.IDataModel;
/*    */ import dtv.event.EventEnum;
/*    */ import dtv.xst.dao.com.IAddress;
/*    */ import java.util.List;
/*    */ 
/*    */ public interface IVendor extends IDataModel, IHasDataProperty<IVendorProperty> {
/*  9 */   public static final EventEnum SET_ORGANIZATIONID = new EventEnum("set organizationId");
/* 10 */   public static final EventEnum SET_VENDORID = new EventEnum("set vendorId");
/* 11 */   public static final EventEnum SET_CREATEDATE = new EventEnum("set createDate");
/* 12 */   public static final EventEnum SET_CREATEUSERID = new EventEnum("set createUserId");
/* 13 */   public static final EventEnum SET_UPDATEDATE = new EventEnum("set updateDate");
/* 14 */   public static final EventEnum SET_UPDATEUSERID = new EventEnum("set updateUserId");
/* 15 */   public static final EventEnum SET_ORGCODE = new EventEnum("set orgCode");
/* 16 */   public static final EventEnum SET_ORGVALUE = new EventEnum("set orgValue");
/* 17 */   public static final EventEnum SET_NAME = new EventEnum("set name");
/* 18 */   public static final EventEnum SET_TYPECODE = new EventEnum("set typeCode");
/* 19 */   public static final EventEnum SET_TELEPHONE = new EventEnum("set telephone");
/* 20 */   public static final EventEnum SET_FAX = new EventEnum("set fax");
/* 21 */   public static final EventEnum SET_CONTACT = new EventEnum("set contact");
/* 22 */   public static final EventEnum SET_CONTACTTELEPHONE = new EventEnum("set contactTelephone");
/* 23 */   public static final EventEnum SET_BUYER = new EventEnum("set buyer");
/* 24 */   public static final EventEnum SET_STATUS = new EventEnum("set status");
/* 25 */   public static final EventEnum SET_ADDRESSID = new EventEnum("set addressId");
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
/*    */   String getVendorId();
/*    */   
/*    */   void setVendorId(String paramString);
/*    */   
/*    */   String getOrgCode();
/*    */   
/*    */   void setOrgCode(String paramString);
/*    */   
/*    */   String getOrgValue();
/*    */   
/*    */   void setOrgValue(String paramString);
/*    */   
/*    */   String getName();
/*    */   
/*    */   void setName(String paramString);
/*    */   
/*    */   String getTypeCode();
/*    */   
/*    */   void setTypeCode(String paramString);
/*    */   
/*    */   String getTelephone();
/*    */   
/*    */   void setTelephone(String paramString);
/*    */   
/*    */   String getFax();
/*    */   
/*    */   void setFax(String paramString);
/*    */   
/*    */   String getContact();
/*    */   
/*    */   void setContact(String paramString);
/*    */   
/*    */   String getContactTelephone();
/*    */   
/*    */   void setContactTelephone(String paramString);
/*    */   
/*    */   String getBuyer();
/*    */   
/*    */   void setBuyer(String paramString);
/*    */   
/*    */   String getStatus();
/*    */   
/*    */   void setStatus(String paramString);
/*    */   
/*    */   String getAddressId();
/*    */   
/*    */   void setAddressId(String paramString);
/*    */   
/*    */   IDataModel getVendorExt();
/*    */   
/*    */   void setVendorExt(IDataModel paramIDataModel);
/*    */   
/*    */   IAddress getAddress();
/*    */   
/*    */   void setAddress(IAddress paramIAddress);
/*    */   
/*    */   List<IVendorProperty> getProperties();
/*    */   
/*    */   void setProperties(List<IVendorProperty> paramList);
/*    */   
/*    */   void addVendorProperty(IVendorProperty paramIVendorProperty);
/*    */   
/*    */   void removeVendorProperty(IVendorProperty paramIVendorProperty);
/*    */   
/*    */   void startTransaction();
/*    */   
/*    */   void rollbackChanges();
/*    */   
/*    */   void commitTransaction();
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\itm\IVendor.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */