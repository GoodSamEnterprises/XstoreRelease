/*    */ package dtv.xst.dao.com;
/*    */ import dtv.data2.access.IDataAccessObject;
/*    */ import dtv.data2.access.IDataModel;
/*    */ import dtv.event.EventEnum;
/*    */ import java.util.Date;
/*    */ import java.util.List;
/*    */ 
/*    */ public interface ICountryReturnMap extends IDataModel, IHasDataProperty<ICountryReturnMapProperty> {
/*  9 */   public static final EventEnum SET_ORGANIZATIONID = new EventEnum("set organizationId");
/* 10 */   public static final EventEnum SET_PURCHASEDFROM = new EventEnum("set purchasedFrom");
/* 11 */   public static final EventEnum SET_RETURNTO = new EventEnum("set returnTo");
/* 12 */   public static final EventEnum SET_CREATEDATE = new EventEnum("set createDate");
/* 13 */   public static final EventEnum SET_CREATEUSERID = new EventEnum("set createUserId");
/* 14 */   public static final EventEnum SET_UPDATEDATE = new EventEnum("set updateDate");
/* 15 */   public static final EventEnum SET_UPDATEUSERID = new EventEnum("set updateUserId");
/* 16 */   public static final EventEnum SET_DISALLOWCROSSBORDERFLAG = new EventEnum("set disallowCrossBorderFlag");
/* 17 */   public static final EventEnum ADD_PROPERTIES = new EventEnum("add Properties");
/* 18 */   public static final EventEnum REMOVE_PROPERTIES = new EventEnum("remove Properties");
/* 19 */   public static final EventEnum SET_PROPERTIES = new EventEnum("set Properties");
/* 20 */   public static final EventEnum START_TRANSACTION = new EventEnum("start transaction");
/* 21 */   public static final EventEnum ROLLBACK_TRANSACTION = new EventEnum("rollback transaction");
/* 22 */   public static final EventEnum COMMIT_TRANSACTION = new EventEnum("commit transaction");
/*    */   
/*    */   void setDAO(IDataAccessObject paramIDataAccessObject);
/*    */   
/*    */   long getOrganizationId();
/*    */   
/*    */   void setOrganizationId(long paramLong);
/*    */   
/*    */   String getPurchasedFrom();
/*    */   
/*    */   void setPurchasedFrom(String paramString);
/*    */   
/*    */   String getReturnTo();
/*    */   
/*    */   void setReturnTo(String paramString);
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
/*    */   boolean getDisallowCrossBorderFlag();
/*    */   
/*    */   void setDisallowCrossBorderFlag(boolean paramBoolean);
/*    */   
/*    */   IDataModel getCountryReturnMapExt();
/*    */   
/*    */   void setCountryReturnMapExt(IDataModel paramIDataModel);
/*    */   
/*    */   List<ICountryReturnMapProperty> getProperties();
/*    */   
/*    */   void setProperties(List<ICountryReturnMapProperty> paramList);
/*    */   
/*    */   void addCountryReturnMapProperty(ICountryReturnMapProperty paramICountryReturnMapProperty);
/*    */   
/*    */   void removeCountryReturnMapProperty(ICountryReturnMapProperty paramICountryReturnMapProperty);
/*    */   
/*    */   void startTransaction();
/*    */   
/*    */   void rollbackChanges();
/*    */   
/*    */   void commitTransaction();
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\com\ICountryReturnMap.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */