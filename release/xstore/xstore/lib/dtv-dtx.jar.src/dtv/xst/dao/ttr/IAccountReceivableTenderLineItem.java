/*    */ package dtv.xst.dao.ttr;
/*    */ 
/*    */ import dtv.data2.access.IDataAccessObject;
/*    */ import dtv.data2.access.IDataModel;
/*    */ import dtv.event.EventEnum;
/*    */ import java.util.Date;
/*    */ 
/*    */ public interface IAccountReceivableTenderLineItem extends IDataModel, IAccountReceivableTenderLineItemModel, ITenderLineItem {
/*  9 */   public static final EventEnum SET_CREATEDATE = new EventEnum("set createDate");
/* 10 */   public static final EventEnum SET_CREATEUSERID = new EventEnum("set createUserId");
/* 11 */   public static final EventEnum SET_UPDATEDATE = new EventEnum("set updateDate");
/* 12 */   public static final EventEnum SET_UPDATEUSERID = new EventEnum("set updateUserId");
/* 13 */   public static final EventEnum SET_ACCOUNTNUMBER = new EventEnum("set accountNumber");
/* 14 */   public static final EventEnum SET_APPROVALCODE = new EventEnum("set approvalCode");
/* 15 */   public static final EventEnum SET_PARTYID = new EventEnum("set partyId");
/* 16 */   public static final EventEnum SET_ACCOUNTUSERNAME = new EventEnum("set accountUserName");
/* 17 */   public static final EventEnum SET_PONUMBER = new EventEnum("set poNumber");
/* 18 */   public static final EventEnum SET_ADJUDICATIONCODE = new EventEnum("set adjudicationCode");
/* 19 */   public static final EventEnum SET_AUTHORIZATIONMETHODCODE = new EventEnum("set authorizationMethodCode");
/* 20 */   public static final EventEnum SET_ACTIVITYCODE = new EventEnum("set activityCode");
/* 21 */   public static final EventEnum SET_ENTRYMETHODCODE = new EventEnum("set entryMethodCode");
/* 22 */   public static final EventEnum SET_AUTHORIZATIONCODE = new EventEnum("set authorizationCode");
/* 23 */   public static final EventEnum SET_ACCOUNTUSERID = new EventEnum("set accountUserId");
/* 24 */   public static final EventEnum START_TRANSACTION = new EventEnum("start transaction");
/* 25 */   public static final EventEnum ROLLBACK_TRANSACTION = new EventEnum("rollback transaction");
/* 26 */   public static final EventEnum COMMIT_TRANSACTION = new EventEnum("commit transaction");
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
/*    */   String getAccountNumber();
/*    */   
/*    */   void setAccountNumber(String paramString);
/*    */   
/*    */   String getApprovalCode();
/*    */   
/*    */   void setApprovalCode(String paramString);
/*    */   
/*    */   long getPartyId();
/*    */   
/*    */   void setPartyId(long paramLong);
/*    */   
/*    */   String getAccountUserName();
/*    */   
/*    */   void setAccountUserName(String paramString);
/*    */   
/*    */   String getPoNumber();
/*    */   
/*    */   void setPoNumber(String paramString);
/*    */   
/*    */   String getAdjudicationCode();
/*    */   
/*    */   void setAdjudicationCode(String paramString);
/*    */   
/*    */   String getAuthorizationMethodCode();
/*    */   
/*    */   void setAuthorizationMethodCode(String paramString);
/*    */   
/*    */   String getActivityCode();
/*    */   
/*    */   void setActivityCode(String paramString);
/*    */   
/*    */   String getEntryMethodCode();
/*    */   
/*    */   void setEntryMethodCode(String paramString);
/*    */   
/*    */   String getAuthorizationCode();
/*    */   
/*    */   void setAuthorizationCode(String paramString);
/*    */   
/*    */   String getAccountUserId();
/*    */   
/*    */   void setAccountUserId(String paramString);
/*    */   
/*    */   IDataModel getAccountReceivableTenderLineItemExt();
/*    */   
/*    */   void setAccountReceivableTenderLineItemExt(IDataModel paramIDataModel);
/*    */   
/*    */   void startTransaction();
/*    */   
/*    */   void rollbackChanges();
/*    */   
/*    */   void commitTransaction();
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\ttr\IAccountReceivableTenderLineItem.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */