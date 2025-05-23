/*    */ package dtv.xst.dao.trl;
/*    */ import dtv.data2.access.IDataModel;
/*    */ import dtv.event.EventEnum;
/*    */ import dtv.xst.dao.dsc.IDiscount;
/*    */ import java.math.BigDecimal;
/*    */ import java.util.Date;
/*    */ 
/*    */ public interface IDiscountLineItem extends IDataModel, IDiscountLineItemModel, IRetailTransactionLineItem {
/*  9 */   public static final EventEnum SET_CREATEDATE = new EventEnum("set createDate");
/* 10 */   public static final EventEnum SET_CREATEUSERID = new EventEnum("set createUserId");
/* 11 */   public static final EventEnum SET_UPDATEDATE = new EventEnum("set updateDate");
/* 12 */   public static final EventEnum SET_UPDATEUSERID = new EventEnum("set updateUserId");
/* 13 */   public static final EventEnum SET_AMOUNT = new EventEnum("set amount");
/* 14 */   public static final EventEnum SET_PERCENT = new EventEnum("set percent");
/* 15 */   public static final EventEnum SET_NEWPRICE = new EventEnum("set newPrice");
/* 16 */   public static final EventEnum SET_NEWPRICEQUANTITY = new EventEnum("set newPriceQuantity");
/* 17 */   public static final EventEnum SET_SERIALNUMBER = new EventEnum("set serialNumber");
/* 18 */   public static final EventEnum SET_DISCOUNTCODE = new EventEnum("set discountCode");
/* 19 */   public static final EventEnum SET_TAXABILITYCODE = new EventEnum("set taxabilityCode");
/* 20 */   public static final EventEnum SET_AWARDTRANSACTIONID = new EventEnum("set awardTransactionId");
/* 21 */   public static final EventEnum SET_LINEITEMDISCOUNT = new EventEnum("set LineItemDiscount");
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
/*    */   BigDecimal getAmount();
/*    */   
/*    */   void setAmount(BigDecimal paramBigDecimal);
/*    */   
/*    */   BigDecimal getPercent();
/*    */   
/*    */   void setPercent(BigDecimal paramBigDecimal);
/*    */   
/*    */   BigDecimal getNewPrice();
/*    */   
/*    */   void setNewPrice(BigDecimal paramBigDecimal);
/*    */   
/*    */   BigDecimal getNewPriceQuantity();
/*    */   
/*    */   void setNewPriceQuantity(BigDecimal paramBigDecimal);
/*    */   
/*    */   String getSerialNumber();
/*    */   
/*    */   void setSerialNumber(String paramString);
/*    */   
/*    */   String getDiscountCode();
/*    */   
/*    */   void setDiscountCode(String paramString);
/*    */   
/*    */   String getTaxabilityCode();
/*    */   
/*    */   void setTaxabilityCode(String paramString);
/*    */   
/*    */   String getAwardTransactionId();
/*    */   
/*    */   void setAwardTransactionId(String paramString);
/*    */   
/*    */   IDataModel getDiscountLineItemExt();
/*    */   
/*    */   void setDiscountLineItemExt(IDataModel paramIDataModel);
/*    */   
/*    */   IDiscount getLineItemDiscount();
/*    */   
/*    */   void setLineItemDiscount(IDiscount paramIDiscount);
/*    */   
/*    */   void startTransaction();
/*    */   
/*    */   void rollbackChanges();
/*    */   
/*    */   void commitTransaction();
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\trl\IDiscountLineItem.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */