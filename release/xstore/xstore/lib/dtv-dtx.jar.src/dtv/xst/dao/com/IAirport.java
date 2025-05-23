/*    */ package dtv.xst.dao.com;
/*    */ import dtv.data2.access.IDataAccessObject;
/*    */ import dtv.data2.access.IDataModel;
/*    */ import dtv.event.EventEnum;
/*    */ import java.util.Date;
/*    */ import java.util.List;
/*    */ 
/*    */ public interface IAirport extends IDataModel, IHasDataProperty<IAirportProperty> {
/*  9 */   public static final EventEnum SET_ORGANIZATIONID = new EventEnum("set organizationId");
/* 10 */   public static final EventEnum SET_AIRPORTCODE = new EventEnum("set airportCode");
/* 11 */   public static final EventEnum SET_CREATEDATE = new EventEnum("set createDate");
/* 12 */   public static final EventEnum SET_CREATEUSERID = new EventEnum("set createUserId");
/* 13 */   public static final EventEnum SET_UPDATEDATE = new EventEnum("set updateDate");
/* 14 */   public static final EventEnum SET_UPDATEUSERID = new EventEnum("set updateUserId");
/* 15 */   public static final EventEnum SET_ZONEID = new EventEnum("set zoneId");
/* 16 */   public static final EventEnum SET_AIRPORTNAME = new EventEnum("set airportName");
/* 17 */   public static final EventEnum SET_COUNTRYCODE = new EventEnum("set countryCode");
/* 18 */   public static final EventEnum ADD_PROPERTIES = new EventEnum("add Properties");
/* 19 */   public static final EventEnum REMOVE_PROPERTIES = new EventEnum("remove Properties");
/* 20 */   public static final EventEnum SET_PROPERTIES = new EventEnum("set Properties");
/* 21 */   public static final EventEnum START_TRANSACTION = new EventEnum("start transaction");
/* 22 */   public static final EventEnum ROLLBACK_TRANSACTION = new EventEnum("rollback transaction");
/* 23 */   public static final EventEnum COMMIT_TRANSACTION = new EventEnum("commit transaction");
/*    */   
/*    */   void setDAO(IDataAccessObject paramIDataAccessObject);
/*    */   
/*    */   long getOrganizationId();
/*    */   
/*    */   void setOrganizationId(long paramLong);
/*    */   
/*    */   String getAirportCode();
/*    */   
/*    */   void setAirportCode(String paramString);
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
/*    */   String getZoneId();
/*    */   
/*    */   void setZoneId(String paramString);
/*    */   
/*    */   String getAirportName();
/*    */   
/*    */   void setAirportName(String paramString);
/*    */   
/*    */   String getCountryCode();
/*    */   
/*    */   void setCountryCode(String paramString);
/*    */   
/*    */   IDataModel getAirportExt();
/*    */   
/*    */   void setAirportExt(IDataModel paramIDataModel);
/*    */   
/*    */   List<IAirportProperty> getProperties();
/*    */   
/*    */   void setProperties(List<IAirportProperty> paramList);
/*    */   
/*    */   void addAirportProperty(IAirportProperty paramIAirportProperty);
/*    */   
/*    */   void removeAirportProperty(IAirportProperty paramIAirportProperty);
/*    */   
/*    */   void startTransaction();
/*    */   
/*    */   void rollbackChanges();
/*    */   
/*    */   void commitTransaction();
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\com\IAirport.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */