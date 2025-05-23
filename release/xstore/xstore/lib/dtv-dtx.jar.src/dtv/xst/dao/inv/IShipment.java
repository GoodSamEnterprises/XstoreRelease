/*    */ package dtv.xst.dao.inv;
/*    */ import dtv.data2.access.IDataModel;
/*    */ import dtv.event.EventEnum;
/*    */ import dtv.xst.dao.loc.IRetailLocation;
/*    */ import java.util.Date;
/*    */ import java.util.List;
/*    */ 
/*    */ public interface IShipment extends IDataModel, IShipmentModel, IHasDataProperty<IShipmentProperty> {
/*  9 */   public static final EventEnum SET_ORGANIZATIONID = new EventEnum("set organizationId");
/* 10 */   public static final EventEnum SET_RETAILLOCATIONID = new EventEnum("set retailLocationId");
/* 11 */   public static final EventEnum SET_DOCUMENTID = new EventEnum("set documentId");
/* 12 */   public static final EventEnum SET_DOCUMENTTYPECODE = new EventEnum("set documentTypeCode");
/* 13 */   public static final EventEnum SET_SHIPMENTSEQUENCE = new EventEnum("set shipmentSequence");
/* 14 */   public static final EventEnum SET_CREATEDATE = new EventEnum("set createDate");
/* 15 */   public static final EventEnum SET_CREATEUSERID = new EventEnum("set createUserId");
/* 16 */   public static final EventEnum SET_UPDATEDATE = new EventEnum("set updateDate");
/* 17 */   public static final EventEnum SET_UPDATEUSERID = new EventEnum("set updateUserId");
/* 18 */   public static final EventEnum SET_EXPECTEDDELIVERYDATE = new EventEnum("set expectedDeliveryDate");
/* 19 */   public static final EventEnum SET_ACTUALDELIVERYDATE = new EventEnum("set actualDeliveryDate");
/* 20 */   public static final EventEnum SET_EXPECTEDSHIPDATE = new EventEnum("set expectedShipDate");
/* 21 */   public static final EventEnum SET_ACTUALSHIPDATE = new EventEnum("set actualShipDate");
/* 22 */   public static final EventEnum SET_DESTINATIONNAME = new EventEnum("set destinationName");
/* 23 */   public static final EventEnum SET_SHIPPINGCARRIER = new EventEnum("set shippingCarrier");
/* 24 */   public static final EventEnum SET_TRACKINGNUMBER = new EventEnum("set trackingNumber");
/* 25 */   public static final EventEnum SET_SHIPMENTSTATUSCODE = new EventEnum("set shipmentStatusCode");
/* 26 */   public static final EventEnum SET_DESTINATIONPARTYID = new EventEnum("set destinationPartyId");
/* 27 */   public static final EventEnum SET_DESTINATIONRETAILLOCATIONID = new EventEnum("set destinationRetailLocationId");
/* 28 */   public static final EventEnum SET_RECORDCREATIONTYPE = new EventEnum("set recordCreationType");
/* 29 */   public static final EventEnum SET_SHIPPINGMETHOD = new EventEnum("set shippingMethod");
/* 30 */   public static final EventEnum SET_SHIPPINGLABEL = new EventEnum("set shippingLabel");
/* 31 */   public static final EventEnum SET_DESTINATIONTYPE = new EventEnum("set destinationType");
/* 32 */   public static final EventEnum SET_DESTINATIONSERVICELOCATIONID = new EventEnum("set destinationServiceLocationId");
/* 33 */   public static final EventEnum SET_DESTINATIONPARTY = new EventEnum("set DestinationParty");
/* 34 */   public static final EventEnum SET_DESTINATIONRETAILLOCATION = new EventEnum("set DestinationRetailLocation");
/* 35 */   public static final EventEnum SET_ADDRESS = new EventEnum("set Address");
/* 36 */   public static final EventEnum ADD_SHIPMENTLINEITEMS = new EventEnum("add ShipmentLineItems");
/* 37 */   public static final EventEnum REMOVE_SHIPMENTLINEITEMS = new EventEnum("remove ShipmentLineItems");
/* 38 */   public static final EventEnum SET_SHIPMENTLINEITEMS = new EventEnum("set ShipmentLineItems");
/* 39 */   public static final EventEnum ADD_PROPERTIES = new EventEnum("add Properties");
/* 40 */   public static final EventEnum REMOVE_PROPERTIES = new EventEnum("remove Properties");
/* 41 */   public static final EventEnum SET_PROPERTIES = new EventEnum("set Properties");
/* 42 */   public static final EventEnum START_TRANSACTION = new EventEnum("start transaction");
/* 43 */   public static final EventEnum ROLLBACK_TRANSACTION = new EventEnum("rollback transaction");
/* 44 */   public static final EventEnum COMMIT_TRANSACTION = new EventEnum("commit transaction");
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
/*    */   String getDocumentId();
/*    */   
/*    */   void setDocumentId(String paramString);
/*    */   
/*    */   String getDocumentTypeCode();
/*    */   
/*    */   void setDocumentTypeCode(String paramString);
/*    */   
/*    */   int getShipmentSequence();
/*    */   
/*    */   void setShipmentSequence(int paramInt);
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
/*    */   Date getExpectedDeliveryDate();
/*    */   
/*    */   void setExpectedDeliveryDate(Date paramDate);
/*    */   
/*    */   Date getActualDeliveryDate();
/*    */   
/*    */   void setActualDeliveryDate(Date paramDate);
/*    */   
/*    */   Date getExpectedShipDate();
/*    */   
/*    */   void setExpectedShipDate(Date paramDate);
/*    */   
/*    */   Date getActualShipDate();
/*    */   
/*    */   void setActualShipDate(Date paramDate);
/*    */   
/*    */   String getDestinationName();
/*    */   
/*    */   void setDestinationName(String paramString);
/*    */   
/*    */   String getShippingCarrier();
/*    */   
/*    */   void setShippingCarrier(String paramString);
/*    */   
/*    */   String getTrackingNumber();
/*    */   
/*    */   void setTrackingNumber(String paramString);
/*    */   
/*    */   String getShipmentStatusCode();
/*    */   
/*    */   void setShipmentStatusCode(String paramString);
/*    */   
/*    */   long getDestinationPartyId();
/*    */   
/*    */   void setDestinationPartyId(long paramLong);
/*    */   
/*    */   long getDestinationRetailLocationId();
/*    */   
/*    */   void setDestinationRetailLocationId(long paramLong);
/*    */   
/*    */   String getRecordCreationType();
/*    */   
/*    */   void setRecordCreationType(String paramString);
/*    */   
/*    */   String getShippingMethod();
/*    */   
/*    */   void setShippingMethod(String paramString);
/*    */   
/*    */   String getShippingLabel();
/*    */   
/*    */   void setShippingLabel(String paramString);
/*    */   
/*    */   String getDestinationType();
/*    */   
/*    */   void setDestinationType(String paramString);
/*    */   
/*    */   String getDestinationServiceLocationId();
/*    */   
/*    */   void setDestinationServiceLocationId(String paramString);
/*    */   
/*    */   IDataModel getShipmentExt();
/*    */   
/*    */   void setShipmentExt(IDataModel paramIDataModel);
/*    */   
/*    */   IParty getDestinationParty();
/*    */   
/*    */   void setDestinationParty(IParty paramIParty);
/*    */   
/*    */   IRetailLocation getDestinationRetailLocation();
/*    */   
/*    */   void setDestinationRetailLocation(IRetailLocation paramIRetailLocation);
/*    */   
/*    */   IShipmentAddress getAddress();
/*    */   
/*    */   void setAddress(IShipmentAddress paramIShipmentAddress);
/*    */   
/*    */   List<IShipmentLineItem> getShipmentLineItems();
/*    */   
/*    */   void setShipmentLineItems(List<IShipmentLineItem> paramList);
/*    */   
/*    */   void addLineItems(IShipmentLineItem paramIShipmentLineItem);
/*    */   
/*    */   void removeLineItems(IShipmentLineItem paramIShipmentLineItem);
/*    */   
/*    */   List<IShipmentProperty> getProperties();
/*    */   
/*    */   void setProperties(List<IShipmentProperty> paramList);
/*    */   
/*    */   void addShipmentProperty(IShipmentProperty paramIShipmentProperty);
/*    */   
/*    */   void removeShipmentProperty(IShipmentProperty paramIShipmentProperty);
/*    */   
/*    */   void setParentDocument(IInventoryDocument paramIInventoryDocument);
/*    */   
/*    */   IInventoryDocument getParentDocument();
/*    */   
/*    */   void startTransaction();
/*    */   
/*    */   void rollbackChanges();
/*    */   
/*    */   void commitTransaction();
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\inv\IShipment.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */