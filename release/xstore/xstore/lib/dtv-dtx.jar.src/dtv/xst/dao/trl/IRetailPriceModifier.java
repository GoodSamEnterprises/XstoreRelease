/*    */ package dtv.xst.dao.trl;
/*    */ import dtv.data2.access.IDataModel;
/*    */ import dtv.event.EventEnum;
/*    */ import dtv.xst.dao.dsc.IDiscount;
/*    */ import java.math.BigDecimal;
/*    */ import java.util.Date;
/*    */ 
/*    */ public interface IRetailPriceModifier extends IDataModel, IRetailPriceModifierModel, IHasDataProperty<IRetailPriceModifierProperty> {
/*  9 */   public static final EventEnum SET_BUSINESSDATE = new EventEnum("set businessDate");
/* 10 */   public static final EventEnum SET_ORGANIZATIONID = new EventEnum("set organizationId");
/* 11 */   public static final EventEnum SET_RETAILLOCATIONID = new EventEnum("set retailLocationId");
/* 12 */   public static final EventEnum SET_RETAILPRICEMODIFIERSEQUENCENBR = new EventEnum("set retailPriceModifierSequenceNbr");
/* 13 */   public static final EventEnum SET_RETAILTRANSACTIONLINEITEMSEQUENCE = new EventEnum("set retailTransactionLineItemSequence");
/* 14 */   public static final EventEnum SET_TRANSACTIONSEQUENCE = new EventEnum("set transactionSequence");
/* 15 */   public static final EventEnum SET_WORKSTATIONID = new EventEnum("set workstationId");
/* 16 */   public static final EventEnum SET_CREATEDATE = new EventEnum("set createDate");
/* 17 */   public static final EventEnum SET_CREATEUSERID = new EventEnum("set createUserId");
/* 18 */   public static final EventEnum SET_UPDATEDATE = new EventEnum("set updateDate");
/* 19 */   public static final EventEnum SET_UPDATEUSERID = new EventEnum("set updateUserId");
/* 20 */   public static final EventEnum SET_AMOUNT = new EventEnum("set amount");
/* 21 */   public static final EventEnum SET_EXTENDEDAMOUNT = new EventEnum("set extendedAmount");
/* 22 */   public static final EventEnum SET_NOTES = new EventEnum("set notes");
/* 23 */   public static final EventEnum SET_SERIALNUMBER = new EventEnum("set serialNumber");
/* 24 */   public static final EventEnum SET_PERCENT = new EventEnum("set percent");
/* 25 */   public static final EventEnum SET_PRICECHANGEAMOUNT = new EventEnum("set priceChangeAmount");
/* 26 */   public static final EventEnum SET_PRICECHANGEREASONCODE = new EventEnum("set priceChangeReasonCode");
/* 27 */   public static final EventEnum SET_PROMOTIONID = new EventEnum("set promotionId");
/* 28 */   public static final EventEnum SET_DESCRIPTION = new EventEnum("set description");
/* 29 */   public static final EventEnum SET_RETAILPRICEMODIFIERREASONCODE = new EventEnum("set retailPriceModifierReasonCode");
/* 30 */   public static final EventEnum SET_VOID = new EventEnum("set void");
/* 31 */   public static final EventEnum SET_DISCOUNTGROUPID = new EventEnum("set discountGroupId");
/* 32 */   public static final EventEnum SET_DEALID = new EventEnum("set dealId");
/* 33 */   public static final EventEnum SET_DISCOUNTCODE = new EventEnum("set discountCode");
/* 34 */   public static final EventEnum SET_DISCBUSINESSDATE = new EventEnum("set discBusinessDate");
/* 35 */   public static final EventEnum SET_DISCRETAILLOCATIONID = new EventEnum("set discRetailLocationId");
/* 36 */   public static final EventEnum SET_DISCRETAILTRANSACTIONLINEITEMSEQUENCE = new EventEnum("set discRetailTransactionLineItemSequence");
/* 37 */   public static final EventEnum SET_DISCTRANSACTIONSEQUENCE = new EventEnum("set discTransactionSequence");
/* 38 */   public static final EventEnum SET_DISCWORKSTATIONID = new EventEnum("set discWorkstationId");
/* 39 */   public static final EventEnum SET_DISCOUNTREASONCODE = new EventEnum("set discountReasonCode");
/* 40 */   public static final EventEnum SET_TAXABILITYCODE = new EventEnum("set taxabilityCode");
/* 41 */   public static final EventEnum SET_DEALAMOUNT = new EventEnum("set dealAmount");
/* 42 */   public static final EventEnum SET_DISCOUNT = new EventEnum("set Discount");
/* 43 */   public static final EventEnum SET_REASONLINEITEM = new EventEnum("set ReasonLineItem");
/* 44 */   public static final EventEnum ADD_PROPERTIES = new EventEnum("add Properties");
/* 45 */   public static final EventEnum REMOVE_PROPERTIES = new EventEnum("remove Properties");
/* 46 */   public static final EventEnum SET_PROPERTIES = new EventEnum("set Properties");
/* 47 */   public static final EventEnum START_TRANSACTION = new EventEnum("start transaction");
/* 48 */   public static final EventEnum ROLLBACK_TRANSACTION = new EventEnum("rollback transaction");
/* 49 */   public static final EventEnum COMMIT_TRANSACTION = new EventEnum("commit transaction");
/*    */   
/*    */   void setDAO(IDataAccessObject paramIDataAccessObject);
/*    */   
/*    */   Date getBusinessDate();
/*    */   
/*    */   void setBusinessDate(Date paramDate);
/*    */   
/*    */   long getOrganizationId();
/*    */   
/*    */   void setOrganizationId(long paramLong);
/*    */   
/*    */   long getRetailLocationId();
/*    */   
/*    */   void setRetailLocationId(long paramLong);
/*    */   
/*    */   int getRetailPriceModifierSequenceNbr();
/*    */   
/*    */   void setRetailPriceModifierSequenceNbr(int paramInt);
/*    */   
/*    */   int getRetailTransactionLineItemSequence();
/*    */   
/*    */   void setRetailTransactionLineItemSequence(int paramInt);
/*    */   
/*    */   long getTransactionSequence();
/*    */   
/*    */   void setTransactionSequence(long paramLong);
/*    */   
/*    */   long getWorkstationId();
/*    */   
/*    */   void setWorkstationId(long paramLong);
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
/*    */   BigDecimal getExtendedAmount();
/*    */   
/*    */   void setExtendedAmount(BigDecimal paramBigDecimal);
/*    */   
/*    */   String getNotes();
/*    */   
/*    */   void setNotes(String paramString);
/*    */   
/*    */   String getSerialNumber();
/*    */   
/*    */   void setSerialNumber(String paramString);
/*    */   
/*    */   BigDecimal getPercent();
/*    */   
/*    */   void setPercent(BigDecimal paramBigDecimal);
/*    */   
/*    */   BigDecimal getPriceChangeAmount();
/*    */   
/*    */   void setPriceChangeAmount(BigDecimal paramBigDecimal);
/*    */   
/*    */   String getPriceChangeReasonCode();
/*    */   
/*    */   void setPriceChangeReasonCode(String paramString);
/*    */   
/*    */   String getPromotionId();
/*    */   
/*    */   void setPromotionId(String paramString);
/*    */   
/*    */   String getDescription();
/*    */   
/*    */   void setDescription(String paramString);
/*    */   
/*    */   String getRetailPriceModifierReasonCode();
/*    */   
/*    */   void setRetailPriceModifierReasonCode(String paramString);
/*    */   
/*    */   boolean getVoid();
/*    */   
/*    */   void setVoid(boolean paramBoolean);
/*    */   
/*    */   int getDiscountGroupId();
/*    */   
/*    */   void setDiscountGroupId(int paramInt);
/*    */   
/*    */   String getDealId();
/*    */   
/*    */   void setDealId(String paramString);
/*    */   
/*    */   String getDiscountCode();
/*    */   
/*    */   void setDiscountCode(String paramString);
/*    */   
/*    */   Date getDiscBusinessDate();
/*    */   
/*    */   void setDiscBusinessDate(Date paramDate);
/*    */   
/*    */   long getDiscRetailLocationId();
/*    */   
/*    */   void setDiscRetailLocationId(long paramLong);
/*    */   
/*    */   int getDiscRetailTransactionLineItemSequence();
/*    */   
/*    */   void setDiscRetailTransactionLineItemSequence(int paramInt);
/*    */   
/*    */   long getDiscTransactionSequence();
/*    */   
/*    */   void setDiscTransactionSequence(long paramLong);
/*    */   
/*    */   long getDiscWorkstationId();
/*    */   
/*    */   void setDiscWorkstationId(long paramLong);
/*    */   
/*    */   String getDiscountReasonCode();
/*    */   
/*    */   void setDiscountReasonCode(String paramString);
/*    */   
/*    */   String getTaxabilityCode();
/*    */   
/*    */   void setTaxabilityCode(String paramString);
/*    */   
/*    */   BigDecimal getDealAmount();
/*    */   
/*    */   void setDealAmount(BigDecimal paramBigDecimal);
/*    */   
/*    */   IDataModel getRetailPriceModifierExt();
/*    */   
/*    */   void setRetailPriceModifierExt(IDataModel paramIDataModel);
/*    */   
/*    */   IDiscount getDiscount();
/*    */   
/*    */   void setDiscount(IDiscount paramIDiscount);
/*    */   
/*    */   IRetailTransactionLineItem getReasonLineItem();
/*    */   
/*    */   void setReasonLineItem(IRetailTransactionLineItem paramIRetailTransactionLineItem);
/*    */   
/*    */   List<IRetailPriceModifierProperty> getProperties();
/*    */   
/*    */   void setProperties(List<IRetailPriceModifierProperty> paramList);
/*    */   
/*    */   void addRetailPriceModifierProperty(IRetailPriceModifierProperty paramIRetailPriceModifierProperty);
/*    */   
/*    */   void removeRetailPriceModifierProperty(IRetailPriceModifierProperty paramIRetailPriceModifierProperty);
/*    */   
/*    */   void setParentLine(ISaleReturnLineItem paramISaleReturnLineItem);
/*    */   
/*    */   ISaleReturnLineItem getParentLine();
/*    */   
/*    */   void startTransaction();
/*    */   
/*    */   void rollbackChanges();
/*    */   
/*    */   void commitTransaction();
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\trl\IRetailPriceModifier.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */