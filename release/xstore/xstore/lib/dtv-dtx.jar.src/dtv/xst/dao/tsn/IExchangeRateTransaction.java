/*    */ package dtv.xst.dao.tsn;
/*    */ import dtv.data2.access.IDataModel;
/*    */ import dtv.event.EventEnum;
/*    */ import dtv.xst.dao.trn.IPosTransaction;
/*    */ import java.util.Date;
/*    */ import java.util.List;
/*    */ 
/*    */ public interface IExchangeRateTransaction extends IDataModel, IExchangeRateTransactionModel, IPosTransaction {
/*  9 */   public static final EventEnum SET_CREATEDATE = new EventEnum("set createDate");
/* 10 */   public static final EventEnum SET_CREATEUSERID = new EventEnum("set createUserId");
/* 11 */   public static final EventEnum SET_UPDATEDATE = new EventEnum("set updateDate");
/* 12 */   public static final EventEnum SET_UPDATEUSERID = new EventEnum("set updateUserId");
/* 13 */   public static final EventEnum ADD_EXCHANGERATETRANSLINEITEMS = new EventEnum("add ExchangeRateTransLineItems");
/* 14 */   public static final EventEnum REMOVE_EXCHANGERATETRANSLINEITEMS = new EventEnum("remove ExchangeRateTransLineItems");
/* 15 */   public static final EventEnum SET_EXCHANGERATETRANSLINEITEMS = new EventEnum("set ExchangeRateTransLineItems");
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
/*    */   IDataModel getExchangeRateTransactionExt();
/*    */   
/*    */   void setExchangeRateTransactionExt(IDataModel paramIDataModel);
/*    */   
/*    */   List<IExchangeRateTransLineItem> getExchangeRateTransLineItems();
/*    */   
/*    */   void setExchangeRateTransLineItems(List<IExchangeRateTransLineItem> paramList);
/*    */   
/*    */   void addExchangeRateTransLineItem(IExchangeRateTransLineItem paramIExchangeRateTransLineItem);
/*    */   
/*    */   void removeExchangeRateTransLineItem(IExchangeRateTransLineItem paramIExchangeRateTransLineItem);
/*    */   
/*    */   void startTransaction();
/*    */   
/*    */   void rollbackChanges();
/*    */   
/*    */   void commitTransaction();
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\tsn\IExchangeRateTransaction.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */