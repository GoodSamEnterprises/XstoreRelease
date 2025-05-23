/*    */ package dtv.xst.dao.trl;
/*    */ import dtv.data2.access.IDataAccessObject;
/*    */ import dtv.data2.access.IDataModel;
/*    */ import dtv.event.EventEnum;
/*    */ import java.math.BigDecimal;
/*    */ import java.util.Date;
/*    */ 
/*    */ public interface IRetailTransactionDealLineItem extends IDataModel, IRetailTransactionDealLineItemModel, IRetailTransactionLineItem {
/*  9 */   public static final EventEnum SET_CREATEDATE = new EventEnum("set createDate");
/* 10 */   public static final EventEnum SET_CREATEUSERID = new EventEnum("set createUserId");
/* 11 */   public static final EventEnum SET_UPDATEDATE = new EventEnum("set updateDate");
/* 12 */   public static final EventEnum SET_UPDATEUSERID = new EventEnum("set updateUserId");
/* 13 */   public static final EventEnum SET_AMOUNT = new EventEnum("set amount");
/* 14 */   public static final EventEnum SET_DEALID = new EventEnum("set dealId");
/* 15 */   public static final EventEnum SET_REASONCODE = new EventEnum("set reasonCode");
/* 16 */   public static final EventEnum START_TRANSACTION = new EventEnum("start transaction");
/* 17 */   public static final EventEnum ROLLBACK_TRANSACTION = new EventEnum("rollback transaction");
/* 18 */   public static final EventEnum COMMIT_TRANSACTION = new EventEnum("commit transaction");
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
/*    */   String getDealId();
/*    */   
/*    */   void setDealId(String paramString);
/*    */   
/*    */   String getReasonCode();
/*    */   
/*    */   void setReasonCode(String paramString);
/*    */   
/*    */   IDataModel getRetailTransactionDealLineItemExt();
/*    */   
/*    */   void setRetailTransactionDealLineItemExt(IDataModel paramIDataModel);
/*    */   
/*    */   void startTransaction();
/*    */   
/*    */   void rollbackChanges();
/*    */   
/*    */   void commitTransaction();
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\trl\IRetailTransactionDealLineItem.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */