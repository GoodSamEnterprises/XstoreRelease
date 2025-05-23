/*    */ package dtv.xst.dao.cwo;
/*    */ import dtv.data2.access.IDataModel;
/*    */ import dtv.event.EventEnum;
/*    */ import java.math.BigDecimal;
/*    */ import java.util.Date;
/*    */ import java.util.List;
/*    */ 
/*    */ public interface IWorkOrderAccount extends IDataModel, IWorkOrderAccountModel, ICustomerItemAccount {
/*  9 */   public static final EventEnum SET_CREATEDATE = new EventEnum("set createDate");
/* 10 */   public static final EventEnum SET_CREATEUSERID = new EventEnum("set createUserId");
/* 11 */   public static final EventEnum SET_UPDATEDATE = new EventEnum("set updateDate");
/* 12 */   public static final EventEnum SET_UPDATEUSERID = new EventEnum("set updateUserId");
/* 13 */   public static final EventEnum SET_TOTALVALUEDAO = new EventEnum("set totalValueDao");
/* 14 */   public static final EventEnum SET_ESTIMATEDCOMPLETIONDATE = new EventEnum("set estimatedCompletionDate");
/* 15 */   public static final EventEnum SET_APPROVEDWORKAMOUNT = new EventEnum("set approvedWorkAmount");
/* 16 */   public static final EventEnum SET_APPROVEDWORKDATE = new EventEnum("set approvedWorkDate");
/* 17 */   public static final EventEnum SET_LASTCUSTOMERNOTICEDATE = new EventEnum("set lastCustomerNoticeDate");
/* 18 */   public static final EventEnum SET_CONTACTMETHODCODE = new EventEnum("set contactMethodCode");
/* 19 */   public static final EventEnum SET_PRIORITYCODE = new EventEnum("set priorityCode");
/* 20 */   public static final EventEnum SET_SERVICELOCATIONID = new EventEnum("set serviceLocationId");
/* 21 */   public static final EventEnum SET_CATEGORYID = new EventEnum("set categoryId");
/* 22 */   public static final EventEnum SET_PRICECODESTRING = new EventEnum("set priceCodeString");
/* 23 */   public static final EventEnum SET_COST = new EventEnum("set cost");
/* 24 */   public static final EventEnum SET_INVOICENUMBER = new EventEnum("set invoiceNumber");
/* 25 */   public static final EventEnum ADD_WORKITEMSRELATIONSHIP = new EventEnum("add WorkItemsRelationship");
/* 26 */   public static final EventEnum REMOVE_WORKITEMSRELATIONSHIP = new EventEnum("remove WorkItemsRelationship");
/* 27 */   public static final EventEnum SET_WORKITEMSRELATIONSHIP = new EventEnum("set WorkItemsRelationship");
/* 28 */   public static final EventEnum SET_WORKORDERACCOUNTSERVICELOCATION = new EventEnum("set WorkOrderAccountServiceLocation");
/* 29 */   public static final EventEnum SET_WORKORDERACCOUNTCATEGORY = new EventEnum("set WorkOrderAccountCategory");
/* 30 */   public static final EventEnum SET_WORKORDERACCOUNTPRICECODE = new EventEnum("set WorkOrderAccountPriceCode");
/* 31 */   public static final EventEnum START_TRANSACTION = new EventEnum("start transaction");
/* 32 */   public static final EventEnum ROLLBACK_TRANSACTION = new EventEnum("rollback transaction");
/* 33 */   public static final EventEnum COMMIT_TRANSACTION = new EventEnum("commit transaction");
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
/*    */   Date getLastCustomerNoticeDate();
/*    */   
/*    */   void setLastCustomerNoticeDate(Date paramDate);
/*    */   
/*    */   String getContactMethodCode();
/*    */   
/*    */   void setContactMethodCode(String paramString);
/*    */   
/*    */   String getPriorityCode();
/*    */   
/*    */   void setPriorityCode(String paramString);
/*    */   
/*    */   String getServiceLocationId();
/*    */   
/*    */   void setServiceLocationId(String paramString);
/*    */   
/*    */   String getCategoryId();
/*    */   
/*    */   void setCategoryId(String paramString);
/*    */   
/*    */   String getPriceCodeString();
/*    */   
/*    */   void setPriceCodeString(String paramString);
/*    */   
/*    */   BigDecimal getCost();
/*    */   
/*    */   void setCost(BigDecimal paramBigDecimal);
/*    */   
/*    */   String getInvoiceNumber();
/*    */   
/*    */   void setInvoiceNumber(String paramString);
/*    */   
/*    */   IDataModel getWorkOrderAccountExt();
/*    */   
/*    */   void setWorkOrderAccountExt(IDataModel paramIDataModel);
/*    */   
/*    */   List<IWorkItem> getWorkItemsRelationship();
/*    */   
/*    */   void setWorkItemsRelationship(List<IWorkItem> paramList);
/*    */   
/*    */   void addWorkItem(IWorkItem paramIWorkItem);
/*    */   
/*    */   void removeWorkItem(IWorkItem paramIWorkItem);
/*    */   
/*    */   IServiceLocation getWorkOrderAccountServiceLocation();
/*    */   
/*    */   void setWorkOrderAccountServiceLocation(IServiceLocation paramIServiceLocation);
/*    */   
/*    */   IWorkOrderCategory getWorkOrderAccountCategory();
/*    */   
/*    */   void setWorkOrderAccountCategory(IWorkOrderCategory paramIWorkOrderCategory);
/*    */   
/*    */   IWorkOrderPriceCode getWorkOrderAccountPriceCode();
/*    */   
/*    */   void setWorkOrderAccountPriceCode(IWorkOrderPriceCode paramIWorkOrderPriceCode);
/*    */   
/*    */   void startTransaction();
/*    */   
/*    */   void rollbackChanges();
/*    */   
/*    */   void commitTransaction();
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\cwo\IWorkOrderAccount.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */