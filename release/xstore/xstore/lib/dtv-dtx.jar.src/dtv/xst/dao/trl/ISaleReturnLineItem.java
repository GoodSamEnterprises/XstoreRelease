/*    */ package dtv.xst.dao.trl;
/*    */ import dtv.event.EventEnum;
/*    */ import dtv.xst.dao.inv.IInventoryDocumentLineItem;
/*    */ import java.math.BigDecimal;
/*    */ import java.util.Date;
/*    */ import java.util.List;
/*    */ 
/*    */ public interface ISaleReturnLineItem extends IDataModel, ISaleReturnLineItemModel, IRetailTransactionLineItem {
/*  9 */   public static final EventEnum SET_CREATEDATE = new EventEnum("set createDate");
/* 10 */   public static final EventEnum SET_CREATEUSERID = new EventEnum("set createUserId");
/* 11 */   public static final EventEnum SET_UPDATEDATE = new EventEnum("set updateDate");
/* 12 */   public static final EventEnum SET_UPDATEUSERID = new EventEnum("set updateUserId");
/* 13 */   public static final EventEnum SET_BASEEXTENDEDPRICE = new EventEnum("set baseExtendedPrice");
/* 14 */   public static final EventEnum SET_BASEUNITPRICE = new EventEnum("set baseUnitPrice");
/* 15 */   public static final EventEnum SET_MERCHLEVEL1ID = new EventEnum("set merchLevel1Id");
/* 16 */   public static final EventEnum SET_EXTENDEDAMOUNT = new EventEnum("set extendedAmount");
/* 17 */   public static final EventEnum SET_GIFTRECEIPTCOUNT = new EventEnum("set giftReceiptCount");
/* 18 */   public static final EventEnum SET_GROSSAMOUNT = new EventEnum("set grossAmount");
/* 19 */   public static final EventEnum SET_INVENTORYACTIONCODE = new EventEnum("set inventoryActionCode");
/* 20 */   public static final EventEnum SET_ITEMID = new EventEnum("set itemId");
/* 21 */   public static final EventEnum SET_ITEMIDENTRYMETHODCODE = new EventEnum("set itemIdEntryMethodCode");
/* 22 */   public static final EventEnum SET_NETAMOUNT = new EventEnum("set netAmount");
/* 23 */   public static final EventEnum SET_RPTBASEUNITPRICE = new EventEnum("set rptBaseUnitPrice");
/* 24 */   public static final EventEnum SET_ORIGINALBUSINESSDATE = new EventEnum("set originalBusinessDate");
/* 25 */   public static final EventEnum SET_ORIGINALLINEITEMSEQUENCE = new EventEnum("set originalLineItemSequence");
/* 26 */   public static final EventEnum SET_ORIGINALRETAILLOCATIONID = new EventEnum("set originalRetailLocationId");
/* 27 */   public static final EventEnum SET_ORIGINALTRANSACTIONSEQUENCE = new EventEnum("set originalTransactionSequence");
/* 28 */   public static final EventEnum SET_ORIGINALWORKSTATIONID = new EventEnum("set originalWorkstationId");
/* 29 */   public static final EventEnum SET_PRICEDERIVATIONMETHODCODE = new EventEnum("set priceDerivationMethodCode");
/* 30 */   public static final EventEnum SET_PRICEENTRYMETHODCODE = new EventEnum("set priceEntryMethodCode");
/* 31 */   public static final EventEnum SET_QUANTITY = new EventEnum("set quantity");
/* 32 */   public static final EventEnum SET_RETURNCOMMENT = new EventEnum("set returnComment");
/* 33 */   public static final EventEnum SET_RETURN = new EventEnum("set return");
/* 34 */   public static final EventEnum SET_RETURNTYPECODE = new EventEnum("set returnTypeCode");
/* 35 */   public static final EventEnum SET_SALERETURNLINEITEMTYPECODE = new EventEnum("set saleReturnLineItemTypeCode");
/* 36 */   public static final EventEnum SET_SCANNEDITEMID = new EventEnum("set scannedItemId");
/* 37 */   public static final EventEnum SET_SERIALNUMBER = new EventEnum("set serialNumber");
/* 38 */   public static final EventEnum SET_ENTEREDDESCRIPTION = new EventEnum("set enteredDescription");
/* 39 */   public static final EventEnum SET_UNITPRICE = new EventEnum("set unitPrice");
/* 40 */   public static final EventEnum SET_VATAMOUNT = new EventEnum("set vatAmount");
/* 41 */   public static final EventEnum SET_FORCEZEROEXTENDEDAMT = new EventEnum("set forceZeroExtendedAmt");
/* 42 */   public static final EventEnum SET_RETURNREASONCODE = new EventEnum("set returnReasonCode");
/* 43 */   public static final EventEnum SET_TAXGROUPID = new EventEnum("set taxGroupId");
/* 44 */   public static final EventEnum SET_NETQUANTITY = new EventEnum("set netQuantity");
/* 45 */   public static final EventEnum SET_GROSSQUANTITY = new EventEnum("set grossQuantity");
/* 46 */   public static final EventEnum SET_FOODSTAMPSAPPLIEDAMOUNT = new EventEnum("set foodStampsAppliedAmount");
/* 47 */   public static final EventEnum SET_VENDORID = new EventEnum("set vendorId");
/* 48 */   public static final EventEnum SET_REGULARBASEPRICE = new EventEnum("set regularBasePrice");
/* 49 */   public static final EventEnum SET_PRICEPROPERTYCODE = new EventEnum("set pricePropertyCode");
/* 50 */   public static final EventEnum SET_SHIPPINGWEIGHT = new EventEnum("set shippingWeight");
/* 51 */   public static final EventEnum SET_UNITCOST = new EventEnum("set unitCost");
/* 52 */   public static final EventEnum SET_ATTACHEDITEMFLAG = new EventEnum("set attachedItemFlag");
/* 53 */   public static final EventEnum SET_INITIALQUANTITY = new EventEnum("set initialQuantity");
/* 54 */   public static final EventEnum SET_NOTRETURNABLE = new EventEnum("set notReturnable");
/* 55 */   public static final EventEnum SET_EXCLUDEFROMNETSALES = new EventEnum("set excludeFromNetSales");
/* 56 */   public static final EventEnum SET_MEASUREMENTREQUIRED = new EventEnum("set measurementRequired");
/* 57 */   public static final EventEnum SET_WEIGHTENTRYMETHODCODE = new EventEnum("set weightEntryMethodCode");
/* 58 */   public static final EventEnum SET_TAREVALUE = new EventEnum("set tareValue");
/* 59 */   public static final EventEnum SET_TARETYPE = new EventEnum("set tareType");
/* 60 */   public static final EventEnum SET_TAREUNITOFMEASURECODE = new EventEnum("set tareUnitOfMeasureCode");
/* 61 */   public static final EventEnum SET_BASERETURNEDQUANTITY = new EventEnum("set BaseReturnedQuantity");
/* 62 */   public static final EventEnum ADD_COMMISSIONMODIFIERS = new EventEnum("add CommissionModifiers");
/* 63 */   public static final EventEnum REMOVE_COMMISSIONMODIFIERS = new EventEnum("remove CommissionModifiers");
/* 64 */   public static final EventEnum SET_COMMISSIONMODIFIERS = new EventEnum("set CommissionModifiers");
/* 65 */   public static final EventEnum ADD_DIMENSIONMODIFIERS = new EventEnum("add DimensionModifiers");
/* 66 */   public static final EventEnum REMOVE_DIMENSIONMODIFIERS = new EventEnum("remove DimensionModifiers");
/* 67 */   public static final EventEnum SET_DIMENSIONMODIFIERS = new EventEnum("set DimensionModifiers");
/* 68 */   public static final EventEnum ADD_INVENTORYDOCUMENTLINEITEMS = new EventEnum("add InventoryDocumentLineItems");
/* 69 */   public static final EventEnum REMOVE_INVENTORYDOCUMENTLINEITEMS = new EventEnum("remove InventoryDocumentLineItems");
/* 70 */   public static final EventEnum SET_INVENTORYDOCUMENTLINEITEMS = new EventEnum("set InventoryDocumentLineItems");
/* 71 */   public static final EventEnum ADD_LINEITEMASSOCIATIONMODIFIERS = new EventEnum("add LineItemAssociationModifiers");
/* 72 */   public static final EventEnum REMOVE_LINEITEMASSOCIATIONMODIFIERS = new EventEnum("remove LineItemAssociationModifiers");
/* 73 */   public static final EventEnum SET_LINEITEMASSOCIATIONMODIFIERS = new EventEnum("set LineItemAssociationModifiers");
/* 74 */   public static final EventEnum ADD_RETAILPRICEMODIFIERS = new EventEnum("add RetailPriceModifiers");
/* 75 */   public static final EventEnum REMOVE_RETAILPRICEMODIFIERS = new EventEnum("remove RetailPriceModifiers");
/* 76 */   public static final EventEnum SET_RETAILPRICEMODIFIERS = new EventEnum("set RetailPriceModifiers");
/* 77 */   public static final EventEnum SET_TAXGROUP = new EventEnum("set TaxGroup");
/* 78 */   public static final EventEnum ADD_TAXMODIFIERS = new EventEnum("add TaxModifiers");
/* 79 */   public static final EventEnum REMOVE_TAXMODIFIERS = new EventEnum("remove TaxModifiers");
/* 80 */   public static final EventEnum SET_TAXMODIFIERS = new EventEnum("set TaxModifiers");
/* 81 */   public static final EventEnum SET_CUSTOMERACCOUNTMODIFIER = new EventEnum("set CustomerAccountModifier");
/* 82 */   public static final EventEnum SET_ITEM = new EventEnum("set Item");
/* 83 */   public static final EventEnum ADD_NOTESEQ = new EventEnum("add NoteSeq");
/* 84 */   public static final EventEnum REMOVE_NOTESEQ = new EventEnum("remove NoteSeq");
/* 85 */   public static final EventEnum SET_NOTESEQ = new EventEnum("set NoteSeq");
/* 86 */   public static final EventEnum ADD_RETAILINVENTORYLOCATIONMODIFIERS = new EventEnum("add RetailInventoryLocationModifiers");
/* 87 */   public static final EventEnum REMOVE_RETAILINVENTORYLOCATIONMODIFIERS = new EventEnum("remove RetailInventoryLocationModifiers");
/* 88 */   public static final EventEnum SET_RETAILINVENTORYLOCATIONMODIFIERS = new EventEnum("set RetailInventoryLocationModifiers");
/* 89 */   public static final EventEnum SET_ORDERMODIFIER = new EventEnum("set OrderModifier");
/* 90 */   public static final EventEnum ADD_KITCOMPONENTMODIFIERS = new EventEnum("add KitComponentModifiers");
/* 91 */   public static final EventEnum REMOVE_KITCOMPONENTMODIFIERS = new EventEnum("remove KitComponentModifiers");
/* 92 */   public static final EventEnum SET_KITCOMPONENTMODIFIERS = new EventEnum("set KitComponentModifiers");
/* 93 */   public static final EventEnum START_TRANSACTION = new EventEnum("start transaction");
/* 94 */   public static final EventEnum ROLLBACK_TRANSACTION = new EventEnum("rollback transaction");
/* 95 */   public static final EventEnum COMMIT_TRANSACTION = new EventEnum("commit transaction");
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
/*    */   BigDecimal getBaseExtendedPrice();
/*    */   
/*    */   void setBaseExtendedPrice(BigDecimal paramBigDecimal);
/*    */   
/*    */   BigDecimal getBaseUnitPrice();
/*    */   
/*    */   void setBaseUnitPrice(BigDecimal paramBigDecimal);
/*    */   
/*    */   String getMerchLevel1Id();
/*    */   
/*    */   void setMerchLevel1Id(String paramString);
/*    */   
/*    */   BigDecimal getExtendedAmount();
/*    */   
/*    */   void setExtendedAmount(BigDecimal paramBigDecimal);
/*    */   
/*    */   int getGiftReceiptCount();
/*    */   
/*    */   void setGiftReceiptCount(int paramInt);
/*    */   
/*    */   BigDecimal getGrossAmount();
/*    */   
/*    */   void setGrossAmount(BigDecimal paramBigDecimal);
/*    */   
/*    */   String getInventoryActionCode();
/*    */   
/*    */   void setInventoryActionCode(String paramString);
/*    */   
/*    */   String getItemId();
/*    */   
/*    */   void setItemId(String paramString);
/*    */   
/*    */   String getItemIdEntryMethodCode();
/*    */   
/*    */   void setItemIdEntryMethodCode(String paramString);
/*    */   
/*    */   BigDecimal getNetAmount();
/*    */   
/*    */   void setNetAmount(BigDecimal paramBigDecimal);
/*    */   
/*    */   BigDecimal getRptBaseUnitPrice();
/*    */   
/*    */   void setRptBaseUnitPrice(BigDecimal paramBigDecimal);
/*    */   
/*    */   Date getOriginalBusinessDate();
/*    */   
/*    */   void setOriginalBusinessDate(Date paramDate);
/*    */   
/*    */   int getOriginalLineItemSequence();
/*    */   
/*    */   void setOriginalLineItemSequence(int paramInt);
/*    */   
/*    */   long getOriginalRetailLocationId();
/*    */   
/*    */   void setOriginalRetailLocationId(long paramLong);
/*    */   
/*    */   long getOriginalTransactionSequence();
/*    */   
/*    */   void setOriginalTransactionSequence(long paramLong);
/*    */   
/*    */   long getOriginalWorkstationId();
/*    */   
/*    */   void setOriginalWorkstationId(long paramLong);
/*    */   
/*    */   String getPriceDerivationMethodCode();
/*    */   
/*    */   void setPriceDerivationMethodCode(String paramString);
/*    */   
/*    */   String getPriceEntryMethodCode();
/*    */   
/*    */   void setPriceEntryMethodCode(String paramString);
/*    */   
/*    */   BigDecimal getQuantity();
/*    */   
/*    */   void setQuantity(BigDecimal paramBigDecimal);
/*    */   
/*    */   String getReturnComment();
/*    */   
/*    */   void setReturnComment(String paramString);
/*    */   
/*    */   boolean getReturn();
/*    */   
/*    */   void setReturn(boolean paramBoolean);
/*    */   
/*    */   String getReturnTypeCode();
/*    */   
/*    */   void setReturnTypeCode(String paramString);
/*    */   
/*    */   String getSaleReturnLineItemTypeCode();
/*    */   
/*    */   void setSaleReturnLineItemTypeCode(String paramString);
/*    */   
/*    */   String getScannedItemId();
/*    */   
/*    */   void setScannedItemId(String paramString);
/*    */   
/*    */   String getSerialNumber();
/*    */   
/*    */   void setSerialNumber(String paramString);
/*    */   
/*    */   String getEnteredDescription();
/*    */   
/*    */   void setEnteredDescription(String paramString);
/*    */   
/*    */   BigDecimal getUnitPrice();
/*    */   
/*    */   void setUnitPrice(BigDecimal paramBigDecimal);
/*    */   
/*    */   BigDecimal getVatAmount();
/*    */   
/*    */   void setVatAmount(BigDecimal paramBigDecimal);
/*    */   
/*    */   boolean getForceZeroExtendedAmt();
/*    */   
/*    */   void setForceZeroExtendedAmt(boolean paramBoolean);
/*    */   
/*    */   String getReturnReasonCode();
/*    */   
/*    */   void setReturnReasonCode(String paramString);
/*    */   
/*    */   String getTaxGroupId();
/*    */   
/*    */   void setTaxGroupId(String paramString);
/*    */   
/*    */   BigDecimal getNetQuantity();
/*    */   
/*    */   void setNetQuantity(BigDecimal paramBigDecimal);
/*    */   
/*    */   BigDecimal getGrossQuantity();
/*    */   
/*    */   void setGrossQuantity(BigDecimal paramBigDecimal);
/*    */   
/*    */   BigDecimal getFoodStampsAppliedAmount();
/*    */   
/*    */   void setFoodStampsAppliedAmount(BigDecimal paramBigDecimal);
/*    */   
/*    */   String getVendorId();
/*    */   
/*    */   void setVendorId(String paramString);
/*    */   
/*    */   BigDecimal getRegularBasePrice();
/*    */   
/*    */   void setRegularBasePrice(BigDecimal paramBigDecimal);
/*    */   
/*    */   String getPricePropertyCode();
/*    */   
/*    */   void setPricePropertyCode(String paramString);
/*    */   
/*    */   BigDecimal getShippingWeight();
/*    */   
/*    */   void setShippingWeight(BigDecimal paramBigDecimal);
/*    */   
/*    */   BigDecimal getUnitCost();
/*    */   
/*    */   void setUnitCost(BigDecimal paramBigDecimal);
/*    */   
/*    */   boolean getAttachedItemFlag();
/*    */   
/*    */   void setAttachedItemFlag(boolean paramBoolean);
/*    */   
/*    */   BigDecimal getInitialQuantity();
/*    */   
/*    */   void setInitialQuantity(BigDecimal paramBigDecimal);
/*    */   
/*    */   boolean getNotReturnable();
/*    */   
/*    */   void setNotReturnable(boolean paramBoolean);
/*    */   
/*    */   boolean getExcludeFromNetSales();
/*    */   
/*    */   void setExcludeFromNetSales(boolean paramBoolean);
/*    */   
/*    */   boolean getMeasurementRequired();
/*    */   
/*    */   void setMeasurementRequired(boolean paramBoolean);
/*    */   
/*    */   String getWeightEntryMethodCode();
/*    */   
/*    */   void setWeightEntryMethodCode(String paramString);
/*    */   
/*    */   BigDecimal getTareValue();
/*    */   
/*    */   void setTareValue(BigDecimal paramBigDecimal);
/*    */   
/*    */   String getTareType();
/*    */   
/*    */   void setTareType(String paramString);
/*    */   
/*    */   String getTareUnitOfMeasureCode();
/*    */   
/*    */   void setTareUnitOfMeasureCode(String paramString);
/*    */   
/*    */   IDataModel getSaleReturnLineItemExt();
/*    */   
/*    */   void setSaleReturnLineItemExt(IDataModel paramIDataModel);
/*    */   
/*    */   IReturnedItemCount getBaseReturnedQuantity();
/*    */   
/*    */   void setBaseReturnedQuantity(IReturnedItemCount paramIReturnedItemCount);
/*    */   
/*    */   List<ICommissionModifier> getCommissionModifiers();
/*    */   
/*    */   void setCommissionModifiers(List<ICommissionModifier> paramList);
/*    */   
/*    */   void addCommissionModifier(ICommissionModifier paramICommissionModifier);
/*    */   
/*    */   void removeCommissionModifier(ICommissionModifier paramICommissionModifier);
/*    */   
/*    */   List<IDimensionModifier> getDimensionModifiers();
/*    */   
/*    */   void setDimensionModifiers(List<IDimensionModifier> paramList);
/*    */   
/*    */   void addDimensionModifier(IDimensionModifier paramIDimensionModifier);
/*    */   
/*    */   void removeDimensionModifier(IDimensionModifier paramIDimensionModifier);
/*    */   
/*    */   List<IInventoryDocumentLineItem> getInventoryDocumentLineItems();
/*    */   
/*    */   void setInventoryDocumentLineItems(List<IInventoryDocumentLineItem> paramList);
/*    */   
/*    */   void addInventoryDocumentLineItem(IInventoryDocumentLineItem paramIInventoryDocumentLineItem);
/*    */   
/*    */   void removeInventoryDocumentLineItem(IInventoryDocumentLineItem paramIInventoryDocumentLineItem);
/*    */   
/*    */   List<ILineItemAssociationModifier> getLineItemAssociationModifiers();
/*    */   
/*    */   void setLineItemAssociationModifiers(List<ILineItemAssociationModifier> paramList);
/*    */   
/*    */   void addLineItemAssociationModifier(ILineItemAssociationModifier paramILineItemAssociationModifier);
/*    */   
/*    */   void removeLineItemAssociationModifier(ILineItemAssociationModifier paramILineItemAssociationModifier);
/*    */   
/*    */   List<IRetailPriceModifier> getRetailPriceModifiers();
/*    */   
/*    */   void setRetailPriceModifiers(List<IRetailPriceModifier> paramList);
/*    */   
/*    */   void addRetailPriceModifier(IRetailPriceModifier paramIRetailPriceModifier);
/*    */   
/*    */   void removeRetailPriceModifier(IRetailPriceModifier paramIRetailPriceModifier);
/*    */   
/*    */   ITaxGroup getTaxGroup();
/*    */   
/*    */   void setTaxGroup(ITaxGroup paramITaxGroup);
/*    */   
/*    */   List<ISaleTaxModifier> getTaxModifiers();
/*    */   
/*    */   void setTaxModifiers(List<ISaleTaxModifier> paramList);
/*    */   
/*    */   void addSaleTaxModifier(ISaleTaxModifier paramISaleTaxModifier);
/*    */   
/*    */   void removeSaleTaxModifier(ISaleTaxModifier paramISaleTaxModifier);
/*    */   
/*    */   ICustomerItemAccountModifier getCustomerAccountModifier();
/*    */   
/*    */   void setCustomerAccountModifier(ICustomerItemAccountModifier paramICustomerItemAccountModifier);
/*    */   
/*    */   IItem getItem();
/*    */   
/*    */   void setItem(IItem paramIItem);
/*    */   
/*    */   List<IRetailTransactionLineItemNotes> getNoteSeq();
/*    */   
/*    */   void setNoteSeq(List<IRetailTransactionLineItemNotes> paramList);
/*    */   
/*    */   void addRetailTransactionLineItemNotes(IRetailTransactionLineItemNotes paramIRetailTransactionLineItemNotes);
/*    */   
/*    */   void removeRetailTransactionLineItemNotes(IRetailTransactionLineItemNotes paramIRetailTransactionLineItemNotes);
/*    */   
/*    */   List<IRetailInventoryLocationModifier> getRetailInventoryLocationModifiers();
/*    */   
/*    */   void setRetailInventoryLocationModifiers(List<IRetailInventoryLocationModifier> paramList);
/*    */   
/*    */   void addRetailInventoryLocationModifier(IRetailInventoryLocationModifier paramIRetailInventoryLocationModifier);
/*    */   
/*    */   void removeRetailInventoryLocationModifier(IRetailInventoryLocationModifier paramIRetailInventoryLocationModifier);
/*    */   
/*    */   IOrderModifier getOrderModifier();
/*    */   
/*    */   void setOrderModifier(IOrderModifier paramIOrderModifier);
/*    */   
/*    */   List<IKitComponentModifier> getKitComponentModifiers();
/*    */   
/*    */   void setKitComponentModifiers(List<IKitComponentModifier> paramList);
/*    */   
/*    */   void addKitComponentModifier(IKitComponentModifier paramIKitComponentModifier);
/*    */   
/*    */   void removeKitComponentModifier(IKitComponentModifier paramIKitComponentModifier);
/*    */   
/*    */   void startTransaction();
/*    */   
/*    */   void rollbackChanges();
/*    */   
/*    */   void commitTransaction();
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\trl\ISaleReturnLineItem.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */