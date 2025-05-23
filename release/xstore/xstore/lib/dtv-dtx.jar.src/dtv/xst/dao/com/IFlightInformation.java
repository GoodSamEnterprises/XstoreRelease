/*    */ package dtv.xst.dao.com;
/*    */ import dtv.data2.access.IDataAccessObject;
/*    */ import dtv.data2.access.IDataModel;
/*    */ import dtv.event.EventEnum;
/*    */ import java.util.Date;
/*    */ import java.util.List;
/*    */ 
/*    */ public interface IFlightInformation extends IDataModel, IHasDataProperty<IFlightInformationProperty> {
/*  9 */   public static final EventEnum SET_ORGANIZATIONID = new EventEnum("set organizationId");
/* 10 */   public static final EventEnum SET_SCHEDULEDDATETIME = new EventEnum("set scheduledDateTime");
/* 11 */   public static final EventEnum SET_FLIGHTNUMBER = new EventEnum("set flightNumber");
/* 12 */   public static final EventEnum SET_ORIGINAIRPORT = new EventEnum("set originAirport");
/* 13 */   public static final EventEnum SET_CREATEDATE = new EventEnum("set createDate");
/* 14 */   public static final EventEnum SET_CREATEUSERID = new EventEnum("set createUserId");
/* 15 */   public static final EventEnum SET_UPDATEDATE = new EventEnum("set updateDate");
/* 16 */   public static final EventEnum SET_UPDATEUSERID = new EventEnum("set updateUserId");
/* 17 */   public static final EventEnum SET_DESTINATIONAIRPORT = new EventEnum("set destinationAirport");
/* 18 */   public static final EventEnum SET_VIA1AIRPORT = new EventEnum("set via1Airport");
/* 19 */   public static final EventEnum SET_VIA2AIRPORT = new EventEnum("set via2Airport");
/* 20 */   public static final EventEnum SET_VIA3AIRPORT = new EventEnum("set via3Airport");
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
/*    */   Date getScheduledDateTime();
/*    */   
/*    */   void setScheduledDateTime(Date paramDate);
/*    */   
/*    */   String getFlightNumber();
/*    */   
/*    */   void setFlightNumber(String paramString);
/*    */   
/*    */   String getOriginAirport();
/*    */   
/*    */   void setOriginAirport(String paramString);
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
/*    */   String getDestinationAirport();
/*    */   
/*    */   void setDestinationAirport(String paramString);
/*    */   
/*    */   String getVia1Airport();
/*    */   
/*    */   void setVia1Airport(String paramString);
/*    */   
/*    */   String getVia2Airport();
/*    */   
/*    */   void setVia2Airport(String paramString);
/*    */   
/*    */   String getVia3Airport();
/*    */   
/*    */   void setVia3Airport(String paramString);
/*    */   
/*    */   IDataModel getFlightInformationExt();
/*    */   
/*    */   void setFlightInformationExt(IDataModel paramIDataModel);
/*    */   
/*    */   List<IFlightInformationProperty> getProperties();
/*    */   
/*    */   void setProperties(List<IFlightInformationProperty> paramList);
/*    */   
/*    */   void addFlightInformationProperty(IFlightInformationProperty paramIFlightInformationProperty);
/*    */   
/*    */   void removeFlightInformationProperty(IFlightInformationProperty paramIFlightInformationProperty);
/*    */   
/*    */   void startTransaction();
/*    */   
/*    */   void rollbackChanges();
/*    */   
/*    */   void commitTransaction();
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\com\IFlightInformation.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */