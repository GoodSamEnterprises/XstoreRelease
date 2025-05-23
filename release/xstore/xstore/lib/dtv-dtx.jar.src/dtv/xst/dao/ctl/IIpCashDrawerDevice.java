/*    */ package dtv.xst.dao.ctl;
/*    */ import dtv.data2.access.IDataAccessObject;
/*    */ import dtv.data2.access.IDataModel;
/*    */ import dtv.event.EventEnum;
/*    */ import java.util.Date;
/*    */ import java.util.List;
/*    */ 
/*    */ public interface IIpCashDrawerDevice extends IDataModel, IIpCashDrawerDeviceModel, IHasDataProperty<IIpCashDrawerDeviceProperty> {
/*  9 */   public static final EventEnum SET_ORGANIZATIONID = new EventEnum("set organizationId");
/* 10 */   public static final EventEnum SET_RETAILLOCATIONID = new EventEnum("set retailLocationId");
/* 11 */   public static final EventEnum SET_CASHDRAWERID = new EventEnum("set cashDrawerId");
/* 12 */   public static final EventEnum SET_DRAWERSTATUS = new EventEnum("set drawerStatus");
/* 13 */   public static final EventEnum SET_PRODUCTNAME = new EventEnum("set productName");
/* 14 */   public static final EventEnum SET_DESCRIPTION = new EventEnum("set description");
/* 15 */   public static final EventEnum SET_SERIALNUMBER = new EventEnum("set serialNumber");
/* 16 */   public static final EventEnum SET_IPADDRESS = new EventEnum("set ipAddress");
/* 17 */   public static final EventEnum SET_TCPPORT = new EventEnum("set tcpPort");
/* 18 */   public static final EventEnum SET_MACADDRESS = new EventEnum("set macAddress");
/* 19 */   public static final EventEnum SET_SUBNETMASK = new EventEnum("set subnetMask");
/* 20 */   public static final EventEnum SET_GATEWAY = new EventEnum("set gateway");
/* 21 */   public static final EventEnum SET_DNSHOSTNAME = new EventEnum("set dnsHostName");
/* 22 */   public static final EventEnum SET_DHCP = new EventEnum("set dhcp");
/* 23 */   public static final EventEnum SET_FIRMWAREVERSION = new EventEnum("set firmwareVersion");
/* 24 */   public static final EventEnum SET_KUP = new EventEnum("set kup");
/* 25 */   public static final EventEnum SET_KUPUPDATEDATE = new EventEnum("set kupUpdateDate");
/* 26 */   public static final EventEnum SET_BEEPONOPEN = new EventEnum("set beepOnOpen");
/* 27 */   public static final EventEnum SET_BEEPLONGOPEN = new EventEnum("set beepLongOpen");
/* 28 */   public static final EventEnum SET_CREATEDATE = new EventEnum("set createDate");
/* 29 */   public static final EventEnum SET_CREATEUSERID = new EventEnum("set createUserId");
/* 30 */   public static final EventEnum SET_UPDATEDATE = new EventEnum("set updateDate");
/* 31 */   public static final EventEnum SET_UPDATEUSERID = new EventEnum("set updateUserId");
/* 32 */   public static final EventEnum ADD_PROPERTIES = new EventEnum("add Properties");
/* 33 */   public static final EventEnum REMOVE_PROPERTIES = new EventEnum("remove Properties");
/* 34 */   public static final EventEnum SET_PROPERTIES = new EventEnum("set Properties");
/* 35 */   public static final EventEnum START_TRANSACTION = new EventEnum("start transaction");
/* 36 */   public static final EventEnum ROLLBACK_TRANSACTION = new EventEnum("rollback transaction");
/* 37 */   public static final EventEnum COMMIT_TRANSACTION = new EventEnum("commit transaction");
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
/*    */   String getCashDrawerId();
/*    */   
/*    */   void setCashDrawerId(String paramString);
/*    */   
/*    */   String getDrawerStatus();
/*    */   
/*    */   void setDrawerStatus(String paramString);
/*    */   
/*    */   String getProductName();
/*    */   
/*    */   void setProductName(String paramString);
/*    */   
/*    */   String getDescription();
/*    */   
/*    */   void setDescription(String paramString);
/*    */   
/*    */   String getSerialNumber();
/*    */   
/*    */   void setSerialNumber(String paramString);
/*    */   
/*    */   String getIpAddress();
/*    */   
/*    */   void setIpAddress(String paramString);
/*    */   
/*    */   long getTcpPort();
/*    */   
/*    */   void setTcpPort(long paramLong);
/*    */   
/*    */   String getMacAddress();
/*    */   
/*    */   void setMacAddress(String paramString);
/*    */   
/*    */   String getSubnetMask();
/*    */   
/*    */   void setSubnetMask(String paramString);
/*    */   
/*    */   String getGateway();
/*    */   
/*    */   void setGateway(String paramString);
/*    */   
/*    */   String getDnsHostName();
/*    */   
/*    */   void setDnsHostName(String paramString);
/*    */   
/*    */   boolean getDhcp();
/*    */   
/*    */   void setDhcp(boolean paramBoolean);
/*    */   
/*    */   String getFirmwareVersion();
/*    */   
/*    */   void setFirmwareVersion(String paramString);
/*    */   
/*    */   String getKup();
/*    */   
/*    */   void setKup(String paramString);
/*    */   
/*    */   Date getKupUpdateDate();
/*    */   
/*    */   void setKupUpdateDate(Date paramDate);
/*    */   
/*    */   boolean getBeepOnOpen();
/*    */   
/*    */   void setBeepOnOpen(boolean paramBoolean);
/*    */   
/*    */   boolean getBeepLongOpen();
/*    */   
/*    */   void setBeepLongOpen(boolean paramBoolean);
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
/*    */   IDataModel getIpCashDrawerDeviceExt();
/*    */   
/*    */   void setIpCashDrawerDeviceExt(IDataModel paramIDataModel);
/*    */   
/*    */   List<IIpCashDrawerDeviceProperty> getProperties();
/*    */   
/*    */   void setProperties(List<IIpCashDrawerDeviceProperty> paramList);
/*    */   
/*    */   void addIpCashDrawerDeviceProperty(IIpCashDrawerDeviceProperty paramIIpCashDrawerDeviceProperty);
/*    */   
/*    */   void removeIpCashDrawerDeviceProperty(IIpCashDrawerDeviceProperty paramIIpCashDrawerDeviceProperty);
/*    */   
/*    */   void startTransaction();
/*    */   
/*    */   void rollbackChanges();
/*    */   
/*    */   void commitTransaction();
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\ctl\IIpCashDrawerDevice.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */