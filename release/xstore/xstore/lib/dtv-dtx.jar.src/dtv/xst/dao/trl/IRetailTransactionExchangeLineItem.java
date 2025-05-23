/*    */ package dtv.xst.dao.trl;
/*    */ import dtv.data2.access.IDataModel;
/*    */ import dtv.event.EventEnum;
/*    */ import dtv.xst.dao.itm.IItem;
/*    */ import java.util.Date;
/*    */ import java.util.List;
/*    */ 
/*    */ public interface IRetailTransactionExchangeLineItem extends IDataModel, IRetailTransactionExchangeLineItemModel, IRetailTransactionLineItem {
/*  9 */   public static final EventEnum SET_ITEMID = new EventEnum("set itemId");
/* 10 */   public static final EventEnum SET_CREATEDATE = new EventEnum("set createDate");
/* 11 */   public static final EventEnum SET_CREATEUSERID = new EventEnum("set createUserId");
/* 12 */   public static final EventEnum SET_UPDATEDATE = new EventEnum("set updateDate");
/* 13 */   public static final EventEnum SET_UPDATEUSERID = new EventEnum("set updateUserId");
/* 14 */   public static final EventEnum SET_ORIGINALSERIALNUMBER = new EventEnum("set originalSerialNumber");
/* 15 */   public static final EventEnum SET_NEWSERIALNUMBER = new EventEnum("set newSerialNumber");
/* 16 */   public static final EventEnum SET_ORIGINALRETAILLOCATIONID = new EventEnum("set originalRetailLocationId");
/* 17 */   public static final EventEnum SET_ORIGINALBUSINESSDATE = new EventEnum("set originalBusinessDate");
/* 18 */   public static final EventEnum SET_ORIGINALWORKSTATIONID = new EventEnum("set originalWorkstationId");
/* 19 */   public static final EventEnum SET_ORIGINALTRANSACTIONSEQUENCE = new EventEnum("set originalTransactionSequence");
/* 20 */   public static final EventEnum SET_OIGINALLINEITEMSEQUENCE = new EventEnum("set oiginalLineItemSequence");
/* 21 */   public static final EventEnum SET_EXCHANGEREASONCODE = new EventEnum("set exchangeReasonCode");
/* 22 */   public static final EventEnum SET_EXCHANGECOMMENT = new EventEnum("set exchangeComment");
/* 23 */   public static final EventEnum ADD_RETAILINVENTORYLOCATIONMODIFIERS = new EventEnum("add RetailInventoryLocationModifiers");
/* 24 */   public static final EventEnum REMOVE_RETAILINVENTORYLOCATIONMODIFIERS = new EventEnum("remove RetailInventoryLocationModifiers");
/* 25 */   public static final EventEnum SET_RETAILINVENTORYLOCATIONMODIFIERS = new EventEnum("set RetailInventoryLocationModifiers");
/* 26 */   public static final EventEnum SET_ITEM = new EventEnum("set Item");
/* 27 */   public static final EventEnum START_TRANSACTION = new EventEnum("start transaction");
/* 28 */   public static final EventEnum ROLLBACK_TRANSACTION = new EventEnum("rollback transaction");
/* 29 */   public static final EventEnum COMMIT_TRANSACTION = new EventEnum("commit transaction");
/*    */   
/*    */   void setDAO(IDataAccessObject paramIDataAccessObject);
/*    */   
/*    */   String getItemId();
/*    */   
/*    */   void setItemId(String paramString);
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
/*    */   String getOriginalSerialNumber();
/*    */   
/*    */   void setOriginalSerialNumber(String paramString);
/*    */   
/*    */   String getNewSerialNumber();
/*    */   
/*    */   void setNewSerialNumber(String paramString);
/*    */   
/*    */   long getOriginalRetailLocationId();
/*    */   
/*    */   void setOriginalRetailLocationId(long paramLong);
/*    */   
/*    */   Date getOriginalBusinessDate();
/*    */   
/*    */   void setOriginalBusinessDate(Date paramDate);
/*    */   
/*    */   long getOriginalWorkstationId();
/*    */   
/*    */   void setOriginalWorkstationId(long paramLong);
/*    */   
/*    */   long getOriginalTransactionSequence();
/*    */   
/*    */   void setOriginalTransactionSequence(long paramLong);
/*    */   
/*    */   int getOiginalLineItemSequence();
/*    */   
/*    */   void setOiginalLineItemSequence(int paramInt);
/*    */   
/*    */   String getExchangeReasonCode();
/*    */   
/*    */   void setExchangeReasonCode(String paramString);
/*    */   
/*    */   String getExchangeComment();
/*    */   
/*    */   void setExchangeComment(String paramString);
/*    */   
/*    */   IDataModel getRetailTransactionExchangeLineItemExt();
/*    */   
/*    */   void setRetailTransactionExchangeLineItemExt(IDataModel paramIDataModel);
/*    */   
/*    */   List<IRetailInventoryLocationModifier> getRetailInventoryLocationModifiers();
/*    */   
/*    */   void setRetailInventoryLocationModifiers(List<IRetailInventoryLocationModifier> paramList);
/*    */   
/*    */   void addRetailInventoryLocationModifier(IRetailInventoryLocationModifier paramIRetailInventoryLocationModifier);
/*    */   
/*    */   void removeRetailInventoryLocationModifier(IRetailInventoryLocationModifier paramIRetailInventoryLocationModifier);
/*    */   
/*    */   IItem getItem();
/*    */   
/*    */   void setItem(IItem paramIItem);
/*    */   
/*    */   void startTransaction();
/*    */   
/*    */   void rollbackChanges();
/*    */   
/*    */   void commitTransaction();
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\trl\IRetailTransactionExchangeLineItem.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */