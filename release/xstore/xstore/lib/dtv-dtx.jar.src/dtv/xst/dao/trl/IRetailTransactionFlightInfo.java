/*    */ package dtv.xst.dao.trl;
/*    */ import dtv.data2.access.IDataModel;
/*    */ import dtv.event.EventEnum;
/*    */ import dtv.xst.dao.com.IAirportZone;
/*    */ import java.util.Date;
/*    */ import java.util.List;
/*    */ 
/*    */ public interface IRetailTransactionFlightInfo extends IDataModel, IHasDataProperty<IRetailTransactionFlightInfoProperty> {
/*  9 */   public static final EventEnum SET_ORGANIZATIONID = new EventEnum("set organizationId");
/* 10 */   public static final EventEnum SET_RETAILLOCATIONID = new EventEnum("set retailLocationId");
/* 11 */   public static final EventEnum SET_BUSINESSDATE = new EventEnum("set businessDate");
/* 12 */   public static final EventEnum SET_WORKSTATIONID = new EventEnum("set workstationId");
/* 13 */   public static final EventEnum SET_TRANSACTIONSEQUENCE = new EventEnum("set transactionSequence");
/* 14 */   public static final EventEnum SET_CREATEDATE = new EventEnum("set createDate");
/* 15 */   public static final EventEnum SET_CREATEUSERID = new EventEnum("set createUserId");
/* 16 */   public static final EventEnum SET_UPDATEDATE = new EventEnum("set updateDate");
/* 17 */   public static final EventEnum SET_UPDATEUSERID = new EventEnum("set updateUserId");
/* 18 */   public static final EventEnum SET_FLIGHTNUMBER = new EventEnum("set flightNumber");
/* 19 */   public static final EventEnum SET_DESTINATIONAIRPORT = new EventEnum("set destinationAirport");
/* 20 */   public static final EventEnum SET_DESTINATIONCOUNTRY = new EventEnum("set destinationCountry");
/* 21 */   public static final EventEnum SET_DESTINATIONZONE = new EventEnum("set destinationZone");
/* 22 */   public static final EventEnum SET_DESTINATIONAIRPORTNAME = new EventEnum("set destinationAirportName");
/* 23 */   public static final EventEnum SET_ORIGINAIRPORT = new EventEnum("set originAirport");
/* 24 */   public static final EventEnum SET_TAXCALCULATIONMODE = new EventEnum("set taxCalculationMode");
/* 25 */   public static final EventEnum SET_FIRSTFLIGHTNUMBER = new EventEnum("set firstFlightNumber");
/* 26 */   public static final EventEnum SET_FIRSTDESTINATIONAIRPORT = new EventEnum("set firstDestinationAirport");
/* 27 */   public static final EventEnum SET_FIRSTORIGINAIRPORT = new EventEnum("set firstOriginAirport");
/* 28 */   public static final EventEnum SET_FIRSTFLIGHTSEATNUMBER = new EventEnum("set firstFlightSeatNumber");
/* 29 */   public static final EventEnum SET_FIRSTFLIGHTSCHEDULEDDATE = new EventEnum("set firstFlightScheduledDate");
/* 30 */   public static final EventEnum SET_DESTINATIONZONEOBJECT = new EventEnum("set DestinationZoneObject");
/* 31 */   public static final EventEnum ADD_PROPERTIES = new EventEnum("add Properties");
/* 32 */   public static final EventEnum REMOVE_PROPERTIES = new EventEnum("remove Properties");
/* 33 */   public static final EventEnum SET_PROPERTIES = new EventEnum("set Properties");
/* 34 */   public static final EventEnum START_TRANSACTION = new EventEnum("start transaction");
/* 35 */   public static final EventEnum ROLLBACK_TRANSACTION = new EventEnum("rollback transaction");
/* 36 */   public static final EventEnum COMMIT_TRANSACTION = new EventEnum("commit transaction");
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
/*    */   String getFlightNumber();
/*    */   
/*    */   void setFlightNumber(String paramString);
/*    */   
/*    */   String getDestinationAirport();
/*    */   
/*    */   void setDestinationAirport(String paramString);
/*    */   
/*    */   String getDestinationCountry();
/*    */   
/*    */   void setDestinationCountry(String paramString);
/*    */   
/*    */   String getDestinationZone();
/*    */   
/*    */   void setDestinationZone(String paramString);
/*    */   
/*    */   String getDestinationAirportName();
/*    */   
/*    */   void setDestinationAirportName(String paramString);
/*    */   
/*    */   String getOriginAirport();
/*    */   
/*    */   void setOriginAirport(String paramString);
/*    */   
/*    */   String getTaxCalculationMode();
/*    */   
/*    */   void setTaxCalculationMode(String paramString);
/*    */   
/*    */   String getFirstFlightNumber();
/*    */   
/*    */   void setFirstFlightNumber(String paramString);
/*    */   
/*    */   String getFirstDestinationAirport();
/*    */   
/*    */   void setFirstDestinationAirport(String paramString);
/*    */   
/*    */   String getFirstOriginAirport();
/*    */   
/*    */   void setFirstOriginAirport(String paramString);
/*    */   
/*    */   String getFirstFlightSeatNumber();
/*    */   
/*    */   void setFirstFlightSeatNumber(String paramString);
/*    */   
/*    */   Date getFirstFlightScheduledDate();
/*    */   
/*    */   void setFirstFlightScheduledDate(Date paramDate);
/*    */   
/*    */   IDataModel getRetailTransactionFlightInfoExt();
/*    */   
/*    */   void setRetailTransactionFlightInfoExt(IDataModel paramIDataModel);
/*    */   
/*    */   IAirportZone getDestinationZoneObject();
/*    */   
/*    */   void setDestinationZoneObject(IAirportZone paramIAirportZone);
/*    */   
/*    */   List<IRetailTransactionFlightInfoProperty> getProperties();
/*    */   
/*    */   void setProperties(List<IRetailTransactionFlightInfoProperty> paramList);
/*    */   
/*    */   void addRetailTransactionFlightInfoProperty(IRetailTransactionFlightInfoProperty paramIRetailTransactionFlightInfoProperty);
/*    */   
/*    */   void removeRetailTransactionFlightInfoProperty(IRetailTransactionFlightInfoProperty paramIRetailTransactionFlightInfoProperty);
/*    */   
/*    */   void setParentTransaction(IRetailTransaction paramIRetailTransaction);
/*    */   
/*    */   IRetailTransaction getParentTransaction();
/*    */   
/*    */   void startTransaction();
/*    */   
/*    */   void rollbackChanges();
/*    */   
/*    */   void commitTransaction();
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\trl\IRetailTransactionFlightInfo.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */