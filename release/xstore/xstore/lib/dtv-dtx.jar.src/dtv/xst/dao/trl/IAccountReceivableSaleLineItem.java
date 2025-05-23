/*    */ package dtv.xst.dao.trl;
/*    */ 
/*    */ import dtv.data2.access.IDataAccessObject;
/*    */ import dtv.data2.access.IDataModel;
/*    */ import dtv.event.EventEnum;
/*    */ import java.util.Date;
/*    */ 
/*    */ public interface IAccountReceivableSaleLineItem extends IDataModel, IAccountReceivableSaleLineItemModel, ISaleReturnLineItem {
/*  9 */   public static final EventEnum SET_CREATEDATE = new EventEnum("set createDate");
/* 10 */   public static final EventEnum SET_CREATEUSERID = new EventEnum("set createUserId");
/* 11 */   public static final EventEnum SET_UPDATEDATE = new EventEnum("set updateDate");
/* 12 */   public static final EventEnum SET_UPDATEUSERID = new EventEnum("set updateUserId");
/* 13 */   public static final EventEnum SET_ACTIVITYCODE = new EventEnum("set activityCode");
/* 14 */   public static final EventEnum SET_ADJUDICATIONCODE = new EventEnum("set adjudicationCode");
/* 15 */   public static final EventEnum SET_AUTHORIZATIONCODE = new EventEnum("set authorizationCode");
/* 16 */   public static final EventEnum SET_AUTHORIZATIONMETHODCODE = new EventEnum("set authorizationMethodCode");
/* 17 */   public static final EventEnum SET_ENTRYMETHODCODE = new EventEnum("set entryMethodCode");
/* 18 */   public static final EventEnum SET_ACCOUNTNUMBER = new EventEnum("set accountNumber");
/* 19 */   public static final EventEnum SET_BANKREFERENCENUMBER = new EventEnum("set bankReferenceNumber");
/* 20 */   public static final EventEnum SET_ACCOUNTUSERID = new EventEnum("set accountUserId");
/* 21 */   public static final EventEnum SET_ACCOUNTUSERNAME = new EventEnum("set accountUserName");
/* 22 */   public static final EventEnum START_TRANSACTION = new EventEnum("start transaction");
/* 23 */   public static final EventEnum ROLLBACK_TRANSACTION = new EventEnum("rollback transaction");
/* 24 */   public static final EventEnum COMMIT_TRANSACTION = new EventEnum("commit transaction");
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
/*    */   String getActivityCode();
/*    */   
/*    */   void setActivityCode(String paramString);
/*    */   
/*    */   String getAdjudicationCode();
/*    */   
/*    */   void setAdjudicationCode(String paramString);
/*    */   
/*    */   String getAuthorizationCode();
/*    */   
/*    */   void setAuthorizationCode(String paramString);
/*    */   
/*    */   String getAuthorizationMethodCode();
/*    */   
/*    */   void setAuthorizationMethodCode(String paramString);
/*    */   
/*    */   String getEntryMethodCode();
/*    */   
/*    */   void setEntryMethodCode(String paramString);
/*    */   
/*    */   String getAccountNumber();
/*    */   
/*    */   void setAccountNumber(String paramString);
/*    */   
/*    */   String getBankReferenceNumber();
/*    */   
/*    */   void setBankReferenceNumber(String paramString);
/*    */   
/*    */   String getAccountUserId();
/*    */   
/*    */   void setAccountUserId(String paramString);
/*    */   
/*    */   String getAccountUserName();
/*    */   
/*    */   void setAccountUserName(String paramString);
/*    */   
/*    */   IDataModel getAccountReceivableSaleLineItemExt();
/*    */   
/*    */   void setAccountReceivableSaleLineItemExt(IDataModel paramIDataModel);
/*    */   
/*    */   void startTransaction();
/*    */   
/*    */   void rollbackChanges();
/*    */   
/*    */   void commitTransaction();
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\trl\IAccountReceivableSaleLineItem.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */