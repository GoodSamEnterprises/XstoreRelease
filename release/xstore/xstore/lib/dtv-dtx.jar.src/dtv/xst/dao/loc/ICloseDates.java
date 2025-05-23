/*    */ package dtv.xst.dao.loc;
/*    */ import dtv.data2.access.IDataAccessObject;
/*    */ import dtv.data2.access.IDataModel;
/*    */ import dtv.event.EventEnum;
/*    */ import java.util.Date;
/*    */ import java.util.List;
/*    */ 
/*    */ public interface ICloseDates extends IDataModel, IHasDataProperty<ICloseDatesProperty> {
/*  9 */   public static final EventEnum SET_ORGANIZATIONID = new EventEnum("set organizationId");
/* 10 */   public static final EventEnum SET_RETAILLOCATIONID = new EventEnum("set retailLocationId");
/* 11 */   public static final EventEnum SET_CLOSEDATE = new EventEnum("set closeDate");
/* 12 */   public static final EventEnum SET_CREATEDATE = new EventEnum("set createDate");
/* 13 */   public static final EventEnum SET_CREATEUSERID = new EventEnum("set createUserId");
/* 14 */   public static final EventEnum SET_UPDATEDATE = new EventEnum("set updateDate");
/* 15 */   public static final EventEnum SET_UPDATEUSERID = new EventEnum("set updateUserId");
/* 16 */   public static final EventEnum SET_REASONCODE = new EventEnum("set reasonCode");
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
/*    */   long getRetailLocationId();
/*    */   
/*    */   void setRetailLocationId(long paramLong);
/*    */   
/*    */   Date getCloseDate();
/*    */   
/*    */   void setCloseDate(Date paramDate);
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
/*    */   String getReasonCode();
/*    */   
/*    */   void setReasonCode(String paramString);
/*    */   
/*    */   IDataModel getCloseDatesExt();
/*    */   
/*    */   void setCloseDatesExt(IDataModel paramIDataModel);
/*    */   
/*    */   List<ICloseDatesProperty> getProperties();
/*    */   
/*    */   void setProperties(List<ICloseDatesProperty> paramList);
/*    */   
/*    */   void addCloseDatesProperty(ICloseDatesProperty paramICloseDatesProperty);
/*    */   
/*    */   void removeCloseDatesProperty(ICloseDatesProperty paramICloseDatesProperty);
/*    */   
/*    */   void startTransaction();
/*    */   
/*    */   void rollbackChanges();
/*    */   
/*    */   void commitTransaction();
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\loc\ICloseDates.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */