/*    */ package dtv.xst.dao.ttr;
/*    */ import dtv.data2.access.IDataModel;
/*    */ import dtv.event.EventEnum;
/*    */ import java.math.BigDecimal;
/*    */ import java.util.Date;
/*    */ import java.util.List;
/*    */ 
/*    */ public interface ITenderLineItem extends IDataModel, ITenderLineItemModel, IRetailTransactionLineItem {
/*  9 */   public static final EventEnum SET_CREATEDATE = new EventEnum("set createDate");
/* 10 */   public static final EventEnum SET_CREATEUSERID = new EventEnum("set createUserId");
/* 11 */   public static final EventEnum SET_UPDATEDATE = new EventEnum("set updateDate");
/* 12 */   public static final EventEnum SET_UPDATEUSERID = new EventEnum("set updateUserId");
/* 13 */   public static final EventEnum SET_AMOUNT = new EventEnum("set amount");
/* 14 */   public static final EventEnum SET_CHANGE = new EventEnum("set change");
/* 15 */   public static final EventEnum SET_HOSTVALIDATION = new EventEnum("set hostValidation");
/* 16 */   public static final EventEnum SET_SERIALNUMBER = new EventEnum("set serialNumber");
/* 17 */   public static final EventEnum SET_TENDERID = new EventEnum("set tenderId");
/* 18 */   public static final EventEnum SET_TENDERSTATUSCODE = new EventEnum("set tenderStatusCode");
/* 19 */   public static final EventEnum SET_EXCHANGERATE = new EventEnum("set exchangeRate");
/* 20 */   public static final EventEnum SET_FOREIGNAMOUNT = new EventEnum("set foreignAmount");
/* 21 */   public static final EventEnum ADD_IDENTITYVERIFICATIONS = new EventEnum("add IdentityVerifications");
/* 22 */   public static final EventEnum REMOVE_IDENTITYVERIFICATIONS = new EventEnum("remove IdentityVerifications");
/* 23 */   public static final EventEnum SET_IDENTITYVERIFICATIONS = new EventEnum("set IdentityVerifications");
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
/*    */   BigDecimal getAmount();
/*    */   
/*    */   void setAmount(BigDecimal paramBigDecimal);
/*    */   
/*    */   boolean getChange();
/*    */   
/*    */   void setChange(boolean paramBoolean);
/*    */   
/*    */   boolean getHostValidation();
/*    */   
/*    */   void setHostValidation(boolean paramBoolean);
/*    */   
/*    */   String getSerialNumber();
/*    */   
/*    */   void setSerialNumber(String paramString);
/*    */   
/*    */   String getTenderId();
/*    */   
/*    */   void setTenderId(String paramString);
/*    */   
/*    */   String getTenderStatusCode();
/*    */   
/*    */   void setTenderStatusCode(String paramString);
/*    */   
/*    */   BigDecimal getExchangeRate();
/*    */   
/*    */   void setExchangeRate(BigDecimal paramBigDecimal);
/*    */   
/*    */   BigDecimal getForeignAmount();
/*    */   
/*    */   void setForeignAmount(BigDecimal paramBigDecimal);
/*    */   
/*    */   IDataModel getTenderLineItemExt();
/*    */   
/*    */   void setTenderLineItemExt(IDataModel paramIDataModel);
/*    */   
/*    */   List<IIdentityVerification> getIdentityVerifications();
/*    */   
/*    */   void setIdentityVerifications(List<IIdentityVerification> paramList);
/*    */   
/*    */   void addIdentityVerification(IIdentityVerification paramIIdentityVerification);
/*    */   
/*    */   void removeIdentityVerification(IIdentityVerification paramIIdentityVerification);
/*    */   
/*    */   void startTransaction();
/*    */   
/*    */   void rollbackChanges();
/*    */   
/*    */   void commitTransaction();
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\ttr\ITenderLineItem.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */