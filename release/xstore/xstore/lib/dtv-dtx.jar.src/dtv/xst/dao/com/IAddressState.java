/*    */ package dtv.xst.dao.com;
/*    */ import dtv.data2.access.IDataAccessObject;
/*    */ import dtv.data2.access.IDataModel;
/*    */ import dtv.event.EventEnum;
/*    */ import java.util.Date;
/*    */ import java.util.List;
/*    */ 
/*    */ public interface IAddressState extends IDataModel, IHasDataProperty<IAddressStateProperty> {
/*  9 */   public static final EventEnum SET_ORGANIZATIONID = new EventEnum("set organizationId");
/* 10 */   public static final EventEnum SET_COUNTRYID = new EventEnum("set countryId");
/* 11 */   public static final EventEnum SET_STATEID = new EventEnum("set stateId");
/* 12 */   public static final EventEnum SET_ADDRESSMODE = new EventEnum("set addressMode");
/* 13 */   public static final EventEnum SET_CREATEDATE = new EventEnum("set createDate");
/* 14 */   public static final EventEnum SET_CREATEUSERID = new EventEnum("set createUserId");
/* 15 */   public static final EventEnum SET_UPDATEDATE = new EventEnum("set updateDate");
/* 16 */   public static final EventEnum SET_UPDATEUSERID = new EventEnum("set updateUserId");
/* 17 */   public static final EventEnum SET_STATENAME = new EventEnum("set stateName");
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
/*    */   String getCountryId();
/*    */   
/*    */   void setCountryId(String paramString);
/*    */   
/*    */   String getStateId();
/*    */   
/*    */   void setStateId(String paramString);
/*    */   
/*    */   String getAddressMode();
/*    */   
/*    */   void setAddressMode(String paramString);
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
/*    */   String getStateName();
/*    */   
/*    */   void setStateName(String paramString);
/*    */   
/*    */   IDataModel getAddressStateExt();
/*    */   
/*    */   void setAddressStateExt(IDataModel paramIDataModel);
/*    */   
/*    */   List<IAddressStateProperty> getProperties();
/*    */   
/*    */   void setProperties(List<IAddressStateProperty> paramList);
/*    */   
/*    */   void addAddressStateProperty(IAddressStateProperty paramIAddressStateProperty);
/*    */   
/*    */   void removeAddressStateProperty(IAddressStateProperty paramIAddressStateProperty);
/*    */   
/*    */   void startTransaction();
/*    */   
/*    */   void rollbackChanges();
/*    */   
/*    */   void commitTransaction();
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\com\IAddressState.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */