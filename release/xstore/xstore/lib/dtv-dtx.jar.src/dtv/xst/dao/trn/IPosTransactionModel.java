/*    */ package dtv.xst.dao.trn;
/*    */ 
/*    */ import dtv.event.EventEnum;
/*    */ import dtv.pricing2.IResult;
/*    */ import dtv.pricing2.PricingDeal;
/*    */ import dtv.util.IDateProvider;
/*    */ import dtv.xst.dao.loc.RetailLocationId;
/*    */ import dtv.xst.dao.trl.IRetailTransactionLineItem;
/*    */ import dtv.xst.pricing.EventedPricingTransaction;
/*    */ import java.math.BigDecimal;
/*    */ import java.util.Date;
/*    */ import java.util.List;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public interface IPosTransactionModel
/*    */ {
/* 28 */   public static final EventEnum TRANSACTION_UPDATED = new EventEnum("TransactionUpdated");
/*    */   
/*    */   BigDecimal getAmountDue();
/*    */   
/*    */   BigDecimal getAmountTendered();
/*    */   
/*    */   @Deprecated
/*    */   Date getBeginDatetimestamp();
/*    */   
/*    */   List<PricingDeal> getCurrentPossibleDeals();
/*    */   
/*    */   Date getCustBirthDate();
/*    */   
/*    */   IResult getDealResults();
/*    */   
/*    */   List<IRetailTransactionLineItem> getDiscountLineItems();
/*    */   
/*    */   @Deprecated
/*    */   Date getEndDatetimestamp();
/*    */   
/*    */   BigDecimal getFoodStampsAmountDue();
/*    */   
/*    */   <T extends IRetailTransactionLineItem> List<T> getLineItems(Class<T> paramClass);
/*    */   
/*    */   List<IRetailTransactionLineItem> getLineItemsByTypeCode(String paramString);
/*    */   
/*    */   <T extends IRetailTransactionLineItem> List<T> getLineItemsByTypeCode(String paramString, Class<T> paramClass);
/*    */   
/*    */   List<? extends IRetailTransactionLineItem> getPosLogRetailLineItems();
/*    */   
/*    */   EventedPricingTransaction getPricing();
/*    */   
/*    */   RetailLocationId getRetailLocationIdObject();
/*    */   
/*    */   BigDecimal getRoundedAmount();
/*    */   
/*    */   List<IRetailTransactionLineItem> getSaleLineItems();
/*    */   
/*    */   List<IRetailTransactionLineItem> getTaxLineItems();
/*    */   
/*    */   List<IRetailTransactionLineItem> getTenderLineItems();
/*    */   
/*    */   IResult getThresholdDealResults();
/*    */   
/*    */   void setAmountTendered(BigDecimal paramBigDecimal);
/*    */   
/*    */   void setBeginDateTimestamp(Date paramDate, IDateProvider paramIDateProvider);
/*    */   
/*    */   void setCustBirthDate(Date paramDate);
/*    */   
/*    */   void setFoodStampsAmountDue(BigDecimal paramBigDecimal);
/*    */   
/*    */   void setPricing(EventedPricingTransaction paramEventedPricingTransaction);
/*    */   
/*    */   void setRoundedAmount(BigDecimal paramBigDecimal);
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\trn\IPosTransactionModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */