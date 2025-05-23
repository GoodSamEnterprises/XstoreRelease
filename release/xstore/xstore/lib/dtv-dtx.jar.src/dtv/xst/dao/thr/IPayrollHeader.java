/*    */ package dtv.xst.dao.thr;
/*    */ import dtv.data2.access.IDataAccessObject;
/*    */ import dtv.data2.access.IDataModel;
/*    */ import dtv.event.EventEnum;
/*    */ import java.util.Date;
/*    */ import java.util.List;
/*    */ 
/*    */ public interface IPayrollHeader extends IDataModel, IHasDataProperty<IPayrollHeaderProperty> {
/*  9 */   public static final EventEnum SET_RETAILLOCID = new EventEnum("set retailLocId");
/* 10 */   public static final EventEnum SET_PARTYID = new EventEnum("set partyId");
/* 11 */   public static final EventEnum SET_ORGANIZATIONID = new EventEnum("set organizationId");
/* 12 */   public static final EventEnum SET_WEEKENDINGDATE = new EventEnum("set weekEndingDate");
/* 13 */   public static final EventEnum SET_CREATEDATE = new EventEnum("set createDate");
/* 14 */   public static final EventEnum SET_CREATEUSERID = new EventEnum("set createUserId");
/* 15 */   public static final EventEnum SET_UPDATEDATE = new EventEnum("set updateDate");
/* 16 */   public static final EventEnum SET_UPDATEUSERID = new EventEnum("set updateUserId");
/* 17 */   public static final EventEnum SET_REVIEWEDDATE = new EventEnum("set reviewedDate");
/* 18 */   public static final EventEnum ADD_PROPERTIES = new EventEnum("add Properties");
/* 19 */   public static final EventEnum REMOVE_PROPERTIES = new EventEnum("remove Properties");
/* 20 */   public static final EventEnum SET_PROPERTIES = new EventEnum("set Properties");
/* 21 */   public static final EventEnum START_TRANSACTION = new EventEnum("start transaction");
/* 22 */   public static final EventEnum ROLLBACK_TRANSACTION = new EventEnum("rollback transaction");
/* 23 */   public static final EventEnum COMMIT_TRANSACTION = new EventEnum("commit transaction");
/*    */   
/*    */   void setDAO(IDataAccessObject paramIDataAccessObject);
/*    */   
/*    */   long getRetailLocId();
/*    */   
/*    */   void setRetailLocId(long paramLong);
/*    */   
/*    */   long getPartyId();
/*    */   
/*    */   void setPartyId(long paramLong);
/*    */   
/*    */   long getOrganizationId();
/*    */   
/*    */   void setOrganizationId(long paramLong);
/*    */   
/*    */   Date getWeekEndingDate();
/*    */   
/*    */   void setWeekEndingDate(Date paramDate);
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
/*    */   Date getReviewedDate();
/*    */   
/*    */   void setReviewedDate(Date paramDate);
/*    */   
/*    */   IDataModel getPayrollHeaderExt();
/*    */   
/*    */   void setPayrollHeaderExt(IDataModel paramIDataModel);
/*    */   
/*    */   List<IPayrollHeaderProperty> getProperties();
/*    */   
/*    */   void setProperties(List<IPayrollHeaderProperty> paramList);
/*    */   
/*    */   void addPayrollHeaderProperty(IPayrollHeaderProperty paramIPayrollHeaderProperty);
/*    */   
/*    */   void removePayrollHeaderProperty(IPayrollHeaderProperty paramIPayrollHeaderProperty);
/*    */   
/*    */   void startTransaction();
/*    */   
/*    */   void rollbackChanges();
/*    */   
/*    */   void commitTransaction();
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\thr\IPayrollHeader.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */