/*    */ package dtv.xst.dao.itm;
/*    */ import dtv.data2.access.IDataModel;
/*    */ import dtv.event.EventEnum;
/*    */ import java.math.BigDecimal;
/*    */ import java.util.Date;
/*    */ import java.util.List;
/*    */ 
/*    */ public interface IItemOptions extends IDataModel, IItemOptionsModel, IHasDataProperty<IItemOptionsProperty> {
/*  9 */   public static final EventEnum SET_ORGANIZATIONID = new EventEnum("set organizationId");
/* 10 */   public static final EventEnum SET_ITEMID = new EventEnum("set itemId");
/* 11 */   public static final EventEnum SET_LEVELCODE = new EventEnum("set levelCode");
/* 12 */   public static final EventEnum SET_LEVELVALUE = new EventEnum("set levelValue");
/* 13 */   public static final EventEnum SET_CREATEDATE = new EventEnum("set createDate");
/* 14 */   public static final EventEnum SET_CREATEUSERID = new EventEnum("set createUserId");
/* 15 */   public static final EventEnum SET_UPDATEDATE = new EventEnum("set updateDate");
/* 16 */   public static final EventEnum SET_UPDATEUSERID = new EventEnum("set updateUserId");
/* 17 */   public static final EventEnum SET_APPLYRESTOCKINGFEE = new EventEnum("set applyRestockingFee");
/* 18 */   public static final EventEnum SET_ATTACHEDITEMS = new EventEnum("set attachedItems");
/* 19 */   public static final EventEnum SET_COMPAREATPRICE = new EventEnum("set compareAtPrice");
/* 20 */   public static final EventEnum SET_DISALLOWDISCOUNTS = new EventEnum("set disallowDiscounts");
/* 21 */   public static final EventEnum SET_DISALLOWDEALS = new EventEnum("set disallowDeals");
/* 22 */   public static final EventEnum SET_DISALLOWPRICECHANGE = new EventEnum("set disallowPriceChange");
/* 23 */   public static final EventEnum SET_DISALLOWSENDSALE = new EventEnum("set disallowSendSale");
/* 24 */   public static final EventEnum SET_DISALLOWCOMMISSION = new EventEnum("set disallowCommission");
/* 25 */   public static final EventEnum SET_DISALLOWLAYAWAY = new EventEnum("set disallowLayaway");
/* 26 */   public static final EventEnum SET_DISALLOWWORKORDER = new EventEnum("set disallowWorkOrder");
/* 27 */   public static final EventEnum SET_DISALLOWSPECIALORDER = new EventEnum("set disallowSpecialOrder");
/* 28 */   public static final EventEnum SET_DISALLOWORDER = new EventEnum("set disallowOrder");
/* 29 */   public static final EventEnum SET_DISALLOWRAINCHECK = new EventEnum("set disallowRainCheck");
/* 30 */   public static final EventEnum SET_FORCEQUANTITYOFONE = new EventEnum("set forceQuantityOfOne");
/* 31 */   public static final EventEnum SET_MAXIMUMSALEUNITCOUNT = new EventEnum("set maximumSaleUnitCount");
/* 32 */   public static final EventEnum SET_MINIMUMSALEUNITCOUNT = new EventEnum("set minimumSaleUnitCount");
/* 33 */   public static final EventEnum SET_NOGIVEAWAYS = new EventEnum("set noGiveaways");
/* 34 */   public static final EventEnum SET_NOTRETURNABLE = new EventEnum("set notReturnable");
/* 35 */   public static final EventEnum SET_PARTNUMBER = new EventEnum("set partNumber");
/* 36 */   public static final EventEnum SET_PROMPTFORPRICE = new EventEnum("set promptForPrice");
/* 37 */   public static final EventEnum SET_PROMPTFORQUANTITY = new EventEnum("set promptForQuantity");
/* 38 */   public static final EventEnum SET_PROMPTFORDESCRIPTION = new EventEnum("set promptForDescription");
/* 39 */   public static final EventEnum SET_PROMPTFORCUSTOMER = new EventEnum("set promptForCustomer");
/* 40 */   public static final EventEnum SET_RESTOCKINGFEE = new EventEnum("set restockingFee");
/* 41 */   public static final EventEnum SET_SEASONCODE = new EventEnum("set seasonCode");
/* 42 */   public static final EventEnum SET_SUBSTITUTEAVAILABLE = new EventEnum("set substituteAvailable");
/* 43 */   public static final EventEnum SET_UNITCOST = new EventEnum("set unitCost");
/* 44 */   public static final EventEnum SET_VENDORID = new EventEnum("set vendorId");
/* 45 */   public static final EventEnum SET_SPECIALORDERLEADDAYS = new EventEnum("set specialOrderLeadDays");
/* 46 */   public static final EventEnum SET_QTYSCALE = new EventEnum("set qtyScale");
/* 47 */   public static final EventEnum SET_MESSAGES = new EventEnum("set messages");
/* 48 */   public static final EventEnum SET_UNITOFMEASURECODE = new EventEnum("set unitOfMeasureCode");
/* 49 */   public static final EventEnum SET_TAXGROUPID = new EventEnum("set taxGroupId");
/* 50 */   public static final EventEnum SET_WARRANTY = new EventEnum("set warranty");
/* 51 */   public static final EventEnum SET_GENERICITEM = new EventEnum("set genericItem");
/* 52 */   public static final EventEnum SET_CURRENTSALEPRICE = new EventEnum("set currentSalePrice");
/* 53 */   public static final EventEnum SET_INITIALSALEQUANTITY = new EventEnum("set initialSaleQuantity");
/* 54 */   public static final EventEnum SET_DISPOSITIONCODE = new EventEnum("set dispositionCode");
/* 55 */   public static final EventEnum SET_ITEMAVAILABILITYCODE = new EventEnum("set itemAvailabilityCode");
/* 56 */   public static final EventEnum SET_MINAGEREQUIRED = new EventEnum("set minAgeRequired");
/* 57 */   public static final EventEnum SET_STOCKSTATUS = new EventEnum("set stockStatus");
/* 58 */   public static final EventEnum SET_FOODSTAMPELIGIBLE = new EventEnum("set foodStampEligible");
/* 59 */   public static final EventEnum SET_SHIPPINGWEIGHT = new EventEnum("set shippingWeight");
/* 60 */   public static final EventEnum SET_PACKSIZE = new EventEnum("set packSize");
/* 61 */   public static final EventEnum SET_DEFAULTSOURCETYPE = new EventEnum("set defaultSourceType");
/* 62 */   public static final EventEnum SET_DEFAULTSOURCEID = new EventEnum("set defaultSourceId");
/* 63 */   public static final EventEnum SET_SELLINGGROUPID = new EventEnum("set sellingGroupId");
/* 64 */   public static final EventEnum SET_EXCLUDEFROMNETSALES = new EventEnum("set excludeFromNetSales");
/* 65 */   public static final EventEnum SET_FISCALITEMID = new EventEnum("set fiscalItemId");
/* 66 */   public static final EventEnum SET_FISCALITEMDESCRIPTION = new EventEnum("set fiscalItemDescription");
/* 67 */   public static final EventEnum SET_EXTERNALSYSTEM = new EventEnum("set externalSystem");
/* 68 */   public static final EventEnum SET_TAREVALUE = new EventEnum("set tareValue");
/* 69 */   public static final EventEnum SET_TAREUNITOFMEASURECODE = new EventEnum("set tareUnitOfMeasureCode");
/* 70 */   public static final EventEnum SET_ITEMVENDOR = new EventEnum("set ItemVendor");
/* 71 */   public static final EventEnum ADD_PROPERTIES = new EventEnum("add Properties");
/* 72 */   public static final EventEnum REMOVE_PROPERTIES = new EventEnum("remove Properties");
/* 73 */   public static final EventEnum SET_PROPERTIES = new EventEnum("set Properties");
/* 74 */   public static final EventEnum START_TRANSACTION = new EventEnum("start transaction");
/* 75 */   public static final EventEnum ROLLBACK_TRANSACTION = new EventEnum("rollback transaction");
/* 76 */   public static final EventEnum COMMIT_TRANSACTION = new EventEnum("commit transaction");
/*    */   
/*    */   void setDAO(IDataAccessObject paramIDataAccessObject);
/*    */   
/*    */   long getOrganizationId();
/*    */   
/*    */   void setOrganizationId(long paramLong);
/*    */   
/*    */   String getItemId();
/*    */   
/*    */   void setItemId(String paramString);
/*    */   
/*    */   String getLevelCode();
/*    */   
/*    */   void setLevelCode(String paramString);
/*    */   
/*    */   String getLevelValue();
/*    */   
/*    */   void setLevelValue(String paramString);
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
/*    */   boolean getApplyRestockingFee();
/*    */   
/*    */   void setApplyRestockingFee(boolean paramBoolean);
/*    */   
/*    */   boolean getAttachedItems();
/*    */   
/*    */   void setAttachedItems(boolean paramBoolean);
/*    */   
/*    */   BigDecimal getCompareAtPrice();
/*    */   
/*    */   void setCompareAtPrice(BigDecimal paramBigDecimal);
/*    */   
/*    */   boolean getDisallowDiscounts();
/*    */   
/*    */   void setDisallowDiscounts(boolean paramBoolean);
/*    */   
/*    */   boolean getDisallowDeals();
/*    */   
/*    */   void setDisallowDeals(boolean paramBoolean);
/*    */   
/*    */   boolean getDisallowPriceChange();
/*    */   
/*    */   void setDisallowPriceChange(boolean paramBoolean);
/*    */   
/*    */   boolean getDisallowSendSale();
/*    */   
/*    */   void setDisallowSendSale(boolean paramBoolean);
/*    */   
/*    */   boolean getDisallowCommission();
/*    */   
/*    */   void setDisallowCommission(boolean paramBoolean);
/*    */   
/*    */   boolean getDisallowLayaway();
/*    */   
/*    */   void setDisallowLayaway(boolean paramBoolean);
/*    */   
/*    */   boolean getDisallowWorkOrder();
/*    */   
/*    */   void setDisallowWorkOrder(boolean paramBoolean);
/*    */   
/*    */   boolean getDisallowSpecialOrder();
/*    */   
/*    */   void setDisallowSpecialOrder(boolean paramBoolean);
/*    */   
/*    */   boolean getDisallowOrder();
/*    */   
/*    */   void setDisallowOrder(boolean paramBoolean);
/*    */   
/*    */   boolean getDisallowRainCheck();
/*    */   
/*    */   void setDisallowRainCheck(boolean paramBoolean);
/*    */   
/*    */   boolean getForceQuantityOfOne();
/*    */   
/*    */   void setForceQuantityOfOne(boolean paramBoolean);
/*    */   
/*    */   BigDecimal getMaximumSaleUnitCount();
/*    */   
/*    */   void setMaximumSaleUnitCount(BigDecimal paramBigDecimal);
/*    */   
/*    */   BigDecimal getMinimumSaleUnitCount();
/*    */   
/*    */   void setMinimumSaleUnitCount(BigDecimal paramBigDecimal);
/*    */   
/*    */   boolean getNoGiveaways();
/*    */   
/*    */   void setNoGiveaways(boolean paramBoolean);
/*    */   
/*    */   boolean getNotReturnable();
/*    */   
/*    */   void setNotReturnable(boolean paramBoolean);
/*    */   
/*    */   String getPartNumber();
/*    */   
/*    */   void setPartNumber(String paramString);
/*    */   
/*    */   boolean getPromptForPrice();
/*    */   
/*    */   void setPromptForPrice(boolean paramBoolean);
/*    */   
/*    */   boolean getPromptForQuantity();
/*    */   
/*    */   void setPromptForQuantity(boolean paramBoolean);
/*    */   
/*    */   boolean getPromptForDescription();
/*    */   
/*    */   void setPromptForDescription(boolean paramBoolean);
/*    */   
/*    */   String getPromptForCustomer();
/*    */   
/*    */   void setPromptForCustomer(String paramString);
/*    */   
/*    */   BigDecimal getRestockingFee();
/*    */   
/*    */   void setRestockingFee(BigDecimal paramBigDecimal);
/*    */   
/*    */   String getSeasonCode();
/*    */   
/*    */   void setSeasonCode(String paramString);
/*    */   
/*    */   boolean getSubstituteAvailable();
/*    */   
/*    */   void setSubstituteAvailable(boolean paramBoolean);
/*    */   
/*    */   BigDecimal getUnitCost();
/*    */   
/*    */   void setUnitCost(BigDecimal paramBigDecimal);
/*    */   
/*    */   String getVendorId();
/*    */   
/*    */   void setVendorId(String paramString);
/*    */   
/*    */   int getSpecialOrderLeadDays();
/*    */   
/*    */   void setSpecialOrderLeadDays(int paramInt);
/*    */   
/*    */   int getQtyScale();
/*    */   
/*    */   void setQtyScale(int paramInt);
/*    */   
/*    */   boolean getMessages();
/*    */   
/*    */   void setMessages(boolean paramBoolean);
/*    */   
/*    */   String getUnitOfMeasureCode();
/*    */   
/*    */   void setUnitOfMeasureCode(String paramString);
/*    */   
/*    */   String getTaxGroupId();
/*    */   
/*    */   void setTaxGroupId(String paramString);
/*    */   
/*    */   boolean getWarranty();
/*    */   
/*    */   void setWarranty(boolean paramBoolean);
/*    */   
/*    */   boolean getGenericItem();
/*    */   
/*    */   void setGenericItem(boolean paramBoolean);
/*    */   
/*    */   BigDecimal getCurrentSalePrice();
/*    */   
/*    */   void setCurrentSalePrice(BigDecimal paramBigDecimal);
/*    */   
/*    */   BigDecimal getInitialSaleQuantity();
/*    */   
/*    */   void setInitialSaleQuantity(BigDecimal paramBigDecimal);
/*    */   
/*    */   String getDispositionCode();
/*    */   
/*    */   void setDispositionCode(String paramString);
/*    */   
/*    */   String getItemAvailabilityCode();
/*    */   
/*    */   void setItemAvailabilityCode(String paramString);
/*    */   
/*    */   int getMinAgeRequired();
/*    */   
/*    */   void setMinAgeRequired(int paramInt);
/*    */   
/*    */   String getStockStatus();
/*    */   
/*    */   void setStockStatus(String paramString);
/*    */   
/*    */   boolean getFoodStampEligible();
/*    */   
/*    */   void setFoodStampEligible(boolean paramBoolean);
/*    */   
/*    */   BigDecimal getShippingWeight();
/*    */   
/*    */   void setShippingWeight(BigDecimal paramBigDecimal);
/*    */   
/*    */   BigDecimal getPackSize();
/*    */   
/*    */   void setPackSize(BigDecimal paramBigDecimal);
/*    */   
/*    */   String getDefaultSourceType();
/*    */   
/*    */   void setDefaultSourceType(String paramString);
/*    */   
/*    */   String getDefaultSourceId();
/*    */   
/*    */   void setDefaultSourceId(String paramString);
/*    */   
/*    */   String getSellingGroupId();
/*    */   
/*    */   void setSellingGroupId(String paramString);
/*    */   
/*    */   boolean getExcludeFromNetSales();
/*    */   
/*    */   void setExcludeFromNetSales(boolean paramBoolean);
/*    */   
/*    */   String getFiscalItemId();
/*    */   
/*    */   void setFiscalItemId(String paramString);
/*    */   
/*    */   String getFiscalItemDescription();
/*    */   
/*    */   void setFiscalItemDescription(String paramString);
/*    */   
/*    */   String getExternalSystem();
/*    */   
/*    */   void setExternalSystem(String paramString);
/*    */   
/*    */   BigDecimal getTareValue();
/*    */   
/*    */   void setTareValue(BigDecimal paramBigDecimal);
/*    */   
/*    */   String getTareUnitOfMeasureCode();
/*    */   
/*    */   void setTareUnitOfMeasureCode(String paramString);
/*    */   
/*    */   IDataModel getItemOptionsExt();
/*    */   
/*    */   void setItemOptionsExt(IDataModel paramIDataModel);
/*    */   
/*    */   IVendor getItemVendor();
/*    */   
/*    */   void setItemVendor(IVendor paramIVendor);
/*    */   
/*    */   List<IItemOptionsProperty> getProperties();
/*    */   
/*    */   void setProperties(List<IItemOptionsProperty> paramList);
/*    */   
/*    */   void addItemOptionsProperty(IItemOptionsProperty paramIItemOptionsProperty);
/*    */   
/*    */   void removeItemOptionsProperty(IItemOptionsProperty paramIItemOptionsProperty);
/*    */   
/*    */   void setItem(IItem paramIItem);
/*    */   
/*    */   IItem getItem();
/*    */   
/*    */   void startTransaction();
/*    */   
/*    */   void rollbackChanges();
/*    */   
/*    */   void commitTransaction();
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\itm\IItemOptions.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */