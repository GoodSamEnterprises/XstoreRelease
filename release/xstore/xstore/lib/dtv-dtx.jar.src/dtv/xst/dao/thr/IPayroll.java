/*    */ package dtv.xst.dao.thr;
/*    */ import dtv.data2.access.IDataModel;
/*    */ import dtv.event.EventEnum;
/*    */ import java.math.BigDecimal;
/*    */ import java.util.Date;
/*    */ import java.util.List;
/*    */ 
/*    */ public interface IPayroll extends IDataModel, IHasDataProperty<IPayrollProperty> {
/*  9 */   public static final EventEnum SET_RETAILLOCID = new EventEnum("set retailLocId");
/* 10 */   public static final EventEnum SET_PARTYID = new EventEnum("set partyId");
/* 11 */   public static final EventEnum SET_ORGANIZATIONID = new EventEnum("set organizationId");
/* 12 */   public static final EventEnum SET_BUSINESSDATE = new EventEnum("set businessDate");
/* 13 */   public static final EventEnum SET_PAYROLLCATEGORY = new EventEnum("set payrollCategory");
/* 14 */   public static final EventEnum SET_CREATEDATE = new EventEnum("set createDate");
/* 15 */   public static final EventEnum SET_CREATEUSERID = new EventEnum("set createUserId");
/* 16 */   public static final EventEnum SET_UPDATEDATE = new EventEnum("set updateDate");
/* 17 */   public static final EventEnum SET_UPDATEUSERID = new EventEnum("set updateUserId");
/* 18 */   public static final EventEnum SET_HOURSCOUNT = new EventEnum("set hoursCount");
/* 19 */   public static final EventEnum SET_POSTED = new EventEnum("set posted");
/* 20 */   public static final EventEnum SET_POSTEDDATE = new EventEnum("set postedDate");
/* 21 */   public static final EventEnum SET_PAYROLLSTATUS = new EventEnum("set payrollStatus");
/* 22 */   public static final EventEnum SET_REVIEWEDDATE = new EventEnum("set reviewedDate");
/* 23 */   public static final EventEnum SET_PAYCODE = new EventEnum("set payCode");
/* 24 */   public static final EventEnum ADD_PROPERTIES = new EventEnum("add Properties");
/* 25 */   public static final EventEnum REMOVE_PROPERTIES = new EventEnum("remove Properties");
/* 26 */   public static final EventEnum SET_PROPERTIES = new EventEnum("set Properties");
/* 27 */   public static final EventEnum START_TRANSACTION = new EventEnum("start transaction");
/* 28 */   public static final EventEnum ROLLBACK_TRANSACTION = new EventEnum("rollback transaction");
/* 29 */   public static final EventEnum COMMIT_TRANSACTION = new EventEnum("commit transaction");
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
/*    */   Date getBusinessDate();
/*    */   
/*    */   void setBusinessDate(Date paramDate);
/*    */   
/*    */   String getPayrollCategory();
/*    */   
/*    */   void setPayrollCategory(String paramString);
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
/*    */   BigDecimal getHoursCount();
/*    */   
/*    */   void setHoursCount(BigDecimal paramBigDecimal);
/*    */   
/*    */   boolean getPosted();
/*    */   
/*    */   void setPosted(boolean paramBoolean);
/*    */   
/*    */   Date getPostedDate();
/*    */   
/*    */   void setPostedDate(Date paramDate);
/*    */   
/*    */   String getPayrollStatus();
/*    */   
/*    */   void setPayrollStatus(String paramString);
/*    */   
/*    */   Date getReviewedDate();
/*    */   
/*    */   void setReviewedDate(Date paramDate);
/*    */   
/*    */   String getPayCode();
/*    */   
/*    */   void setPayCode(String paramString);
/*    */   
/*    */   IDataModel getPayrollExt();
/*    */   
/*    */   void setPayrollExt(IDataModel paramIDataModel);
/*    */   
/*    */   List<IPayrollProperty> getProperties();
/*    */   
/*    */   void setProperties(List<IPayrollProperty> paramList);
/*    */   
/*    */   void addPayrollProperty(IPayrollProperty paramIPayrollProperty);
/*    */   
/*    */   void removePayrollProperty(IPayrollProperty paramIPayrollProperty);
/*    */   
/*    */   void startTransaction();
/*    */   
/*    */   void rollbackChanges();
/*    */   
/*    */   void commitTransaction();
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\thr\IPayroll.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */