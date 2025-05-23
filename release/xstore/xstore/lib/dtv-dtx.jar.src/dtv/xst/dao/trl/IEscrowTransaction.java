/*    */ package dtv.xst.dao.trl;
/*    */ import dtv.data2.access.IDataModel;
/*    */ import dtv.event.EventEnum;
/*    */ import dtv.xst.dao.cat.IEscrowAccountActivity;
/*    */ import java.math.BigDecimal;
/*    */ import java.util.Date;
/*    */ 
/*    */ public interface IEscrowTransaction extends IDataModel, IPosTransaction {
/*  9 */   public static final EventEnum SET_CREATEDATE = new EventEnum("set createDate");
/* 10 */   public static final EventEnum SET_CREATEUSERID = new EventEnum("set createUserId");
/* 11 */   public static final EventEnum SET_UPDATEDATE = new EventEnum("set updateDate");
/* 12 */   public static final EventEnum SET_UPDATEUSERID = new EventEnum("set updateUserId");
/* 13 */   public static final EventEnum SET_CUSTACCOUNTID = new EventEnum("set custAccountId");
/* 14 */   public static final EventEnum SET_ACTIVITYSEQUENCENUMBER = new EventEnum("set activitySequenceNumber");
/* 15 */   public static final EventEnum SET_ESCROWAMOUNT = new EventEnum("set escrowAmount");
/* 16 */   public static final EventEnum SET_CUSTOMERPARTYID = new EventEnum("set customerPartyId");
/* 17 */   public static final EventEnum SET_CUSTOMERPARTY = new EventEnum("set CustomerParty");
/* 18 */   public static final EventEnum SET_ESCROWACCOUNTACTIVITY = new EventEnum("set EscrowAccountActivity");
/* 19 */   public static final EventEnum START_TRANSACTION = new EventEnum("start transaction");
/* 20 */   public static final EventEnum ROLLBACK_TRANSACTION = new EventEnum("rollback transaction");
/* 21 */   public static final EventEnum COMMIT_TRANSACTION = new EventEnum("commit transaction");
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
/*    */   String getCustAccountId();
/*    */   
/*    */   void setCustAccountId(String paramString);
/*    */   
/*    */   long getActivitySequenceNumber();
/*    */   
/*    */   void setActivitySequenceNumber(long paramLong);
/*    */   
/*    */   BigDecimal getEscrowAmount();
/*    */   
/*    */   void setEscrowAmount(BigDecimal paramBigDecimal);
/*    */   
/*    */   IDataModel getEscrowTransactionExt();
/*    */   
/*    */   void setEscrowTransactionExt(IDataModel paramIDataModel);
/*    */   
/*    */   IParty getCustomerParty();
/*    */   
/*    */   void setCustomerParty(IParty paramIParty);
/*    */   
/*    */   IEscrowAccountActivity getEscrowAccountActivity();
/*    */   
/*    */   void setEscrowAccountActivity(IEscrowAccountActivity paramIEscrowAccountActivity);
/*    */   
/*    */   void startTransaction();
/*    */   
/*    */   void rollbackChanges();
/*    */   
/*    */   void commitTransaction();
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\trl\IEscrowTransaction.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */