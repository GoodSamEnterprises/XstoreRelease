/*    */ package dtv.xst.dao.cwo;
/*    */ import dtv.data2.access.IDataAccessObject;
/*    */ import dtv.data2.access.IDataModel;
/*    */ import dtv.event.EventEnum;
/*    */ import java.math.BigDecimal;
/*    */ import java.util.Date;
/*    */ 
/*    */ public interface IWorkOrderAccountJournal extends IDataModel, IWorkOrderAccountJournalModel, ICustomerItemAccountJournal {
/*  9 */   public static final EventEnum SET_CREATEDATE = new EventEnum("set createDate");
/* 10 */   public static final EventEnum SET_CREATEUSERID = new EventEnum("set createUserId");
/* 11 */   public static final EventEnum SET_UPDATEDATE = new EventEnum("set updateDate");
/* 12 */   public static final EventEnum SET_UPDATEUSERID = new EventEnum("set updateUserId");
/* 13 */   public static final EventEnum SET_TOTALVALUE = new EventEnum("set totalValue");
/* 14 */   public static final EventEnum SET_ESTIMATEDCOMPLETIONDATE = new EventEnum("set estimatedCompletionDate");
/* 15 */   public static final EventEnum SET_APPROVEDWORKAMOUNT = new EventEnum("set approvedWorkAmount");
/* 16 */   public static final EventEnum SET_APPROVEDWORKDATE = new EventEnum("set approvedWorkDate");
/* 17 */   public static final EventEnum SET_PRIORITYCODE = new EventEnum("set priorityCode");
/* 18 */   public static final EventEnum SET_CONTACTMETHOD = new EventEnum("set contactMethod");
/* 19 */   public static final EventEnum SET_LASTCUSTOMERNOTICEDATE = new EventEnum("set lastCustomerNoticeDate");
/* 20 */   public static final EventEnum SET_CATEGORYID = new EventEnum("set categoryId");
/* 21 */   public static final EventEnum SET_SERVICELOCATIONID = new EventEnum("set serviceLocationId");
/* 22 */   public static final EventEnum SET_PRICECODESTRING = new EventEnum("set priceCodeString");
/* 23 */   public static final EventEnum SET_WORKORDERACCOUNTJOURNALPRICECODE = new EventEnum("set WorkOrderAccountJournalPriceCode");
/* 24 */   public static final EventEnum SET_WORKORDERACCOUNTJOURNALCATEGORY = new EventEnum("set WorkOrderAccountJournalCategory");
/* 25 */   public static final EventEnum SET_WORKORDERACCOUNTJOURNALSERVICELOCATION = new EventEnum("set WorkOrderAccountJournalServiceLocation");
/* 26 */   public static final EventEnum START_TRANSACTION = new EventEnum("start transaction");
/* 27 */   public static final EventEnum ROLLBACK_TRANSACTION = new EventEnum("rollback transaction");
/* 28 */   public static final EventEnum COMMIT_TRANSACTION = new EventEnum("commit transaction");
/*    */   
/*    */   void setDAO(IDataAccessObject paramIDataAccessObject);
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
/*    */   BigDecimal getTotalValue();
/*    */   
/*    */   void setTotalValue(BigDecimal paramBigDecimal);
/*    */   
/*    */   Date getEstimatedCompletionDate();
/*    */   
/*    */   void setEstimatedCompletionDate(Date paramDate);
/*    */   
/*    */   BigDecimal getApprovedWorkAmount();
/*    */   
/*    */   void setApprovedWorkAmount(BigDecimal paramBigDecimal);
/*    */   
/*    */   Date getApprovedWorkDate();
/*    */   
/*    */   void setApprovedWorkDate(Date paramDate);
/*    */   
/*    */   String getPriorityCode();
/*    */   
/*    */   void setPriorityCode(String paramString);
/*    */   
/*    */   String getContactMethod();
/*    */   
/*    */   void setContactMethod(String paramString);
/*    */   
/*    */   Date getLastCustomerNoticeDate();
/*    */   
/*    */   void setLastCustomerNoticeDate(Date paramDate);
/*    */   
/*    */   String getPriceCodeString();
/*    */   
/*    */   void setPriceCodeString(String paramString);
/*    */   
/*    */   IDataModel getWorkOrderAccountJournalExt();
/*    */   
/*    */   void setWorkOrderAccountJournalExt(IDataModel paramIDataModel);
/*    */   
/*    */   IWorkOrderPriceCode getWorkOrderAccountJournalPriceCode();
/*    */   
/*    */   void setWorkOrderAccountJournalPriceCode(IWorkOrderPriceCode paramIWorkOrderPriceCode);
/*    */   
/*    */   IWorkOrderCategory getWorkOrderAccountJournalCategory();
/*    */   
/*    */   void setWorkOrderAccountJournalCategory(IWorkOrderCategory paramIWorkOrderCategory);
/*    */   
/*    */   IServiceLocation getWorkOrderAccountJournalServiceLocation();
/*    */   
/*    */   void setWorkOrderAccountJournalServiceLocation(IServiceLocation paramIServiceLocation);
/*    */   
/*    */   void startTransaction();
/*    */   
/*    */   void rollbackChanges();
/*    */   
/*    */   void commitTransaction();
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\cwo\IWorkOrderAccountJournal.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */