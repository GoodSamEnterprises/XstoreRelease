/*    */ package dtv.xst.dao.itm;
/*    */ import dtv.data2.access.IDataModel;
/*    */ import dtv.event.EventEnum;
/*    */ import java.math.BigDecimal;
/*    */ import java.util.Date;
/*    */ import java.util.List;
/*    */ 
/*    */ public interface IWarrantyItem extends IDataModel, IWarrantyItemModel, INonPhysicalItem {
/*  9 */   public static final EventEnum SET_CREATEDATE = new EventEnum("set createDate");
/* 10 */   public static final EventEnum SET_CREATEUSERID = new EventEnum("set createUserId");
/* 11 */   public static final EventEnum SET_UPDATEDATE = new EventEnum("set updateDate");
/* 12 */   public static final EventEnum SET_UPDATEUSERID = new EventEnum("set updateUserId");
/* 13 */   public static final EventEnum SET_PRICINGMETHODCODE = new EventEnum("set pricingMethodCode");
/* 14 */   public static final EventEnum SET_WARRANTYPRICEAMT = new EventEnum("set warrantyPriceAmt");
/* 15 */   public static final EventEnum SET_WARRANTYPRICEPERCENTAGE = new EventEnum("set warrantyPricePercentage");
/* 16 */   public static final EventEnum SET_WARRANTYMINPRICEAMT = new EventEnum("set warrantyMinPriceAmt");
/* 17 */   public static final EventEnum SET_EXPIRATIONDAYS = new EventEnum("set expirationDays");
/* 18 */   public static final EventEnum SET_SERVICEDAYS = new EventEnum("set serviceDays");
/* 19 */   public static final EventEnum SET_RENEWABLE = new EventEnum("set renewable");
/* 20 */   public static final EventEnum ADD_WARRANTYITEMPRICES = new EventEnum("add WarrantyItemPrices");
/* 21 */   public static final EventEnum REMOVE_WARRANTYITEMPRICES = new EventEnum("remove WarrantyItemPrices");
/* 22 */   public static final EventEnum SET_WARRANTYITEMPRICES = new EventEnum("set WarrantyItemPrices");
/* 23 */   public static final EventEnum START_TRANSACTION = new EventEnum("start transaction");
/* 24 */   public static final EventEnum ROLLBACK_TRANSACTION = new EventEnum("rollback transaction");
/* 25 */   public static final EventEnum COMMIT_TRANSACTION = new EventEnum("commit transaction");
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
/*    */   String getPricingMethodCode();
/*    */   
/*    */   void setPricingMethodCode(String paramString);
/*    */   
/*    */   BigDecimal getWarrantyPriceAmt();
/*    */   
/*    */   void setWarrantyPriceAmt(BigDecimal paramBigDecimal);
/*    */   
/*    */   BigDecimal getWarrantyPricePercentage();
/*    */   
/*    */   void setWarrantyPricePercentage(BigDecimal paramBigDecimal);
/*    */   
/*    */   BigDecimal getWarrantyMinPriceAmt();
/*    */   
/*    */   void setWarrantyMinPriceAmt(BigDecimal paramBigDecimal);
/*    */   
/*    */   long getExpirationDays();
/*    */   
/*    */   void setExpirationDays(long paramLong);
/*    */   
/*    */   long getServiceDays();
/*    */   
/*    */   void setServiceDays(long paramLong);
/*    */   
/*    */   boolean getRenewable();
/*    */   
/*    */   void setRenewable(boolean paramBoolean);
/*    */   
/*    */   IDataModel getWarrantyItemExt();
/*    */   
/*    */   void setWarrantyItemExt(IDataModel paramIDataModel);
/*    */   
/*    */   List<IWarrantyItemPrice> getWarrantyItemPrices();
/*    */   
/*    */   void setWarrantyItemPrices(List<IWarrantyItemPrice> paramList);
/*    */   
/*    */   void addWarrantyItemPrice(IWarrantyItemPrice paramIWarrantyItemPrice);
/*    */   
/*    */   void removeWarrantyItemPrice(IWarrantyItemPrice paramIWarrantyItemPrice);
/*    */   
/*    */   void startTransaction();
/*    */   
/*    */   void rollbackChanges();
/*    */   
/*    */   void commitTransaction();
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\itm\IWarrantyItem.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */