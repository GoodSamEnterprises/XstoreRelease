/*      */ package dtv.xst.dao.trl.impl;
/*      */ 
/*      */ import dtv.data2.access.DaoUtils;
/*      */ import dtv.data2.access.exception.DtxException;
/*      */ import dtv.util.DtvDate;
/*      */ import java.math.BigDecimal;
/*      */ import java.util.Date;
/*      */ import java.util.Map;
/*      */ import org.apache.log4j.Logger;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public class SaleReturnLineItemDAO
/*      */   extends RetailTransactionLineItemDAO
/*      */ {
/*      */   private static final long serialVersionUID = -1387284802L;
/*   23 */   private static final Logger _logger = Logger.getLogger(SaleReturnLineItemDAO.class);
/*      */   
/*      */   private DtvDate _createDate;
/*      */   private String _createUserId;
/*      */   private DtvDate _updateDate;
/*      */   private String _updateUserId;
/*      */   private BigDecimal _baseExtendedPrice;
/*      */   private BigDecimal _baseUnitPrice;
/*      */   private String _merchLevel1Id;
/*      */   private BigDecimal _extendedAmount;
/*      */   private Integer _giftReceiptCount;
/*      */   private BigDecimal _grossAmount;
/*      */   private String _inventoryActionCode;
/*      */   private String _itemId;
/*      */   private String _itemIdEntryMethodCode;
/*      */   private BigDecimal _netAmount;
/*      */   private BigDecimal _rptBaseUnitPrice;
/*      */   private DtvDate _originalBusinessDate;
/*      */   private Integer _originalLineItemSequence;
/*      */   private Long _originalRetailLocationId;
/*      */   private Long _originalTransactionSequence;
/*      */   private Long _originalWorkstationId;
/*      */   private String _priceDerivationMethodCode;
/*      */   private String _priceEntryMethodCode;
/*      */   private BigDecimal _quantity;
/*      */   private String _returnComment;
/*   49 */   private Boolean _return = Boolean.FALSE;
/*      */   private String _returnTypeCode;
/*      */   private String _saleReturnLineItemTypeCode;
/*      */   private String _scannedItemId;
/*      */   private String _serialNumber;
/*      */   private String _enteredDescription;
/*      */   private BigDecimal _unitPrice;
/*      */   private BigDecimal _vatAmount;
/*   57 */   private Boolean _forceZeroExtendedAmt = Boolean.FALSE;
/*      */   private String _returnReasonCode;
/*      */   private String _taxGroupId;
/*      */   private BigDecimal _netQuantity;
/*      */   private BigDecimal _grossQuantity;
/*      */   private BigDecimal _foodStampsAppliedAmount;
/*      */   private String _vendorId;
/*      */   private BigDecimal _regularBasePrice;
/*      */   private String _pricePropertyCode;
/*      */   private BigDecimal _shippingWeight;
/*      */   private BigDecimal _unitCost;
/*   68 */   private Boolean _attachedItemFlag = Boolean.FALSE;
/*      */   private BigDecimal _initialQuantity;
/*   70 */   private Boolean _notReturnable = Boolean.FALSE;
/*   71 */   private Boolean _excludeFromNetSales = Boolean.FALSE;
/*   72 */   private Boolean _measurementRequired = Boolean.FALSE;
/*      */   private String _weightEntryMethodCode;
/*      */   private BigDecimal _tareValue;
/*      */   private String _tareType;
/*      */   private String _tareUnitOfMeasureCode;
/*      */   
/*      */   public Date getCreateDate() {
/*   79 */     return (Date)this._createDate;
/*      */   }
/*      */   
/*      */   public void setCreateDate(Date argCreateDate) {
/*   83 */     if (changed(argCreateDate, this._createDate, "createDate")) {
/*   84 */       this._createDate = (argCreateDate == null || argCreateDate instanceof DtvDate) ? (DtvDate)argCreateDate : new DtvDate(argCreateDate);
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   public String getCreateUserId() {
/*   90 */     return this._createUserId;
/*      */   }
/*      */   
/*      */   public void setCreateUserId(String argCreateUserId) {
/*   94 */     if (changed(argCreateUserId, this._createUserId, "createUserId")) {
/*   95 */       this._createUserId = argCreateUserId;
/*      */     }
/*      */   }
/*      */   
/*      */   public Date getUpdateDate() {
/*  100 */     return (Date)this._updateDate;
/*      */   }
/*      */   
/*      */   public void setUpdateDate(Date argUpdateDate) {
/*  104 */     if (changed(argUpdateDate, this._updateDate, "updateDate")) {
/*  105 */       this._updateDate = (argUpdateDate == null || argUpdateDate instanceof DtvDate) ? (DtvDate)argUpdateDate : new DtvDate(argUpdateDate);
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   public String getUpdateUserId() {
/*  111 */     return this._updateUserId;
/*      */   }
/*      */   
/*      */   public void setUpdateUserId(String argUpdateUserId) {
/*  115 */     if (changed(argUpdateUserId, this._updateUserId, "updateUserId")) {
/*  116 */       this._updateUserId = argUpdateUserId;
/*      */     }
/*      */   }
/*      */   
/*      */   public BigDecimal getBaseExtendedPrice() {
/*  121 */     return this._baseExtendedPrice;
/*      */   }
/*      */   
/*      */   public void setBaseExtendedPrice(BigDecimal argBaseExtendedPrice) {
/*  125 */     if (changed(argBaseExtendedPrice, this._baseExtendedPrice, "baseExtendedPrice")) {
/*  126 */       this._baseExtendedPrice = argBaseExtendedPrice;
/*      */     }
/*      */   }
/*      */   
/*      */   public BigDecimal getBaseUnitPrice() {
/*  131 */     return this._baseUnitPrice;
/*      */   }
/*      */   
/*      */   public void setBaseUnitPrice(BigDecimal argBaseUnitPrice) {
/*  135 */     if (changed(argBaseUnitPrice, this._baseUnitPrice, "baseUnitPrice")) {
/*  136 */       this._baseUnitPrice = argBaseUnitPrice;
/*      */     }
/*      */   }
/*      */   
/*      */   public String getMerchLevel1Id() {
/*  141 */     return this._merchLevel1Id;
/*      */   }
/*      */   
/*      */   public void setMerchLevel1Id(String argMerchLevel1Id) {
/*  145 */     if (changed(argMerchLevel1Id, this._merchLevel1Id, "merchLevel1Id")) {
/*  146 */       this._merchLevel1Id = argMerchLevel1Id;
/*      */     }
/*      */   }
/*      */   
/*      */   public BigDecimal getExtendedAmount() {
/*  151 */     return this._extendedAmount;
/*      */   }
/*      */   
/*      */   public void setExtendedAmount(BigDecimal argExtendedAmount) {
/*  155 */     if (changed(argExtendedAmount, this._extendedAmount, "extendedAmount")) {
/*  156 */       this._extendedAmount = argExtendedAmount;
/*      */     }
/*      */   }
/*      */   
/*      */   public Integer getGiftReceiptCount() {
/*  161 */     return this._giftReceiptCount;
/*      */   }
/*      */   
/*      */   public void setGiftReceiptCount(Integer argGiftReceiptCount) {
/*  165 */     if (changed(argGiftReceiptCount, this._giftReceiptCount, "giftReceiptCount")) {
/*  166 */       this._giftReceiptCount = argGiftReceiptCount;
/*      */     }
/*      */   }
/*      */   
/*      */   public BigDecimal getGrossAmount() {
/*  171 */     return this._grossAmount;
/*      */   }
/*      */   
/*      */   public void setGrossAmount(BigDecimal argGrossAmount) {
/*  175 */     if (changed(argGrossAmount, this._grossAmount, "grossAmount")) {
/*  176 */       this._grossAmount = argGrossAmount;
/*      */     }
/*      */   }
/*      */   
/*      */   public String getInventoryActionCode() {
/*  181 */     return this._inventoryActionCode;
/*      */   }
/*      */   
/*      */   public void setInventoryActionCode(String argInventoryActionCode) {
/*  185 */     if (changed(argInventoryActionCode, this._inventoryActionCode, "inventoryActionCode")) {
/*  186 */       this._inventoryActionCode = argInventoryActionCode;
/*      */     }
/*      */   }
/*      */   
/*      */   public String getItemId() {
/*  191 */     return this._itemId;
/*      */   }
/*      */   
/*      */   public void setItemId(String argItemId) {
/*  195 */     if (changed(argItemId, this._itemId, "itemId")) {
/*  196 */       this._itemId = argItemId;
/*      */     }
/*      */   }
/*      */   
/*      */   public String getItemIdEntryMethodCode() {
/*  201 */     return this._itemIdEntryMethodCode;
/*      */   }
/*      */   
/*      */   public void setItemIdEntryMethodCode(String argItemIdEntryMethodCode) {
/*  205 */     if (changed(argItemIdEntryMethodCode, this._itemIdEntryMethodCode, "itemIdEntryMethodCode")) {
/*  206 */       this._itemIdEntryMethodCode = argItemIdEntryMethodCode;
/*      */     }
/*      */   }
/*      */   
/*      */   public BigDecimal getNetAmount() {
/*  211 */     return this._netAmount;
/*      */   }
/*      */   
/*      */   public void setNetAmount(BigDecimal argNetAmount) {
/*  215 */     if (changed(argNetAmount, this._netAmount, "netAmount")) {
/*  216 */       this._netAmount = argNetAmount;
/*      */     }
/*      */   }
/*      */   
/*      */   public BigDecimal getRptBaseUnitPrice() {
/*  221 */     return this._rptBaseUnitPrice;
/*      */   }
/*      */   
/*      */   public void setRptBaseUnitPrice(BigDecimal argRptBaseUnitPrice) {
/*  225 */     if (changed(argRptBaseUnitPrice, this._rptBaseUnitPrice, "rptBaseUnitPrice")) {
/*  226 */       this._rptBaseUnitPrice = argRptBaseUnitPrice;
/*      */     }
/*      */   }
/*      */   
/*      */   public Date getOriginalBusinessDate() {
/*  231 */     return (Date)this._originalBusinessDate;
/*      */   }
/*      */   
/*      */   public void setOriginalBusinessDate(Date argOriginalBusinessDate) {
/*  235 */     if (changed(argOriginalBusinessDate, this._originalBusinessDate, "originalBusinessDate")) {
/*  236 */       this._originalBusinessDate = (argOriginalBusinessDate == null || argOriginalBusinessDate instanceof DtvDate) ? (DtvDate)argOriginalBusinessDate : new DtvDate(argOriginalBusinessDate);
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   public Integer getOriginalLineItemSequence() {
/*  242 */     return this._originalLineItemSequence;
/*      */   }
/*      */   
/*      */   public void setOriginalLineItemSequence(Integer argOriginalLineItemSequence) {
/*  246 */     if (changed(argOriginalLineItemSequence, this._originalLineItemSequence, "originalLineItemSequence")) {
/*  247 */       this._originalLineItemSequence = argOriginalLineItemSequence;
/*      */     }
/*      */   }
/*      */   
/*      */   public Long getOriginalRetailLocationId() {
/*  252 */     return this._originalRetailLocationId;
/*      */   }
/*      */   
/*      */   public void setOriginalRetailLocationId(Long argOriginalRetailLocationId) {
/*  256 */     if (changed(argOriginalRetailLocationId, this._originalRetailLocationId, "originalRetailLocationId")) {
/*  257 */       this._originalRetailLocationId = argOriginalRetailLocationId;
/*      */     }
/*      */   }
/*      */   
/*      */   public Long getOriginalTransactionSequence() {
/*  262 */     return this._originalTransactionSequence;
/*      */   }
/*      */   
/*      */   public void setOriginalTransactionSequence(Long argOriginalTransactionSequence) {
/*  266 */     if (changed(argOriginalTransactionSequence, this._originalTransactionSequence, "originalTransactionSequence")) {
/*  267 */       this._originalTransactionSequence = argOriginalTransactionSequence;
/*      */     }
/*      */   }
/*      */   
/*      */   public Long getOriginalWorkstationId() {
/*  272 */     return this._originalWorkstationId;
/*      */   }
/*      */   
/*      */   public void setOriginalWorkstationId(Long argOriginalWorkstationId) {
/*  276 */     if (changed(argOriginalWorkstationId, this._originalWorkstationId, "originalWorkstationId")) {
/*  277 */       this._originalWorkstationId = argOriginalWorkstationId;
/*      */     }
/*      */   }
/*      */   
/*      */   public String getPriceDerivationMethodCode() {
/*  282 */     return this._priceDerivationMethodCode;
/*      */   }
/*      */   
/*      */   public void setPriceDerivationMethodCode(String argPriceDerivationMethodCode) {
/*  286 */     if (changed(argPriceDerivationMethodCode, this._priceDerivationMethodCode, "priceDerivationMethodCode")) {
/*  287 */       this._priceDerivationMethodCode = argPriceDerivationMethodCode;
/*      */     }
/*      */   }
/*      */   
/*      */   public String getPriceEntryMethodCode() {
/*  292 */     return this._priceEntryMethodCode;
/*      */   }
/*      */   
/*      */   public void setPriceEntryMethodCode(String argPriceEntryMethodCode) {
/*  296 */     if (changed(argPriceEntryMethodCode, this._priceEntryMethodCode, "priceEntryMethodCode")) {
/*  297 */       this._priceEntryMethodCode = argPriceEntryMethodCode;
/*      */     }
/*      */   }
/*      */   
/*      */   public BigDecimal getQuantity() {
/*  302 */     return this._quantity;
/*      */   }
/*      */   
/*      */   public void setQuantity(BigDecimal argQuantity) {
/*  306 */     if (changed(argQuantity, this._quantity, "quantity")) {
/*  307 */       this._quantity = argQuantity;
/*      */     }
/*      */   }
/*      */   
/*      */   public String getReturnComment() {
/*  312 */     return this._returnComment;
/*      */   }
/*      */   
/*      */   public void setReturnComment(String argReturnComment) {
/*  316 */     if (changed(argReturnComment, this._returnComment, "returnComment")) {
/*  317 */       this._returnComment = argReturnComment;
/*      */     }
/*      */   }
/*      */   
/*      */   public Boolean getReturn() {
/*  322 */     return this._return;
/*      */   }
/*      */   
/*      */   public void setReturn(Boolean argReturn) {
/*  326 */     if (changed(argReturn, this._return, "return")) {
/*  327 */       this._return = argReturn;
/*      */     }
/*      */   }
/*      */   
/*      */   public String getReturnTypeCode() {
/*  332 */     return this._returnTypeCode;
/*      */   }
/*      */   
/*      */   public void setReturnTypeCode(String argReturnTypeCode) {
/*  336 */     if (changed(argReturnTypeCode, this._returnTypeCode, "returnTypeCode")) {
/*  337 */       this._returnTypeCode = argReturnTypeCode;
/*      */     }
/*      */   }
/*      */   
/*      */   public String getSaleReturnLineItemTypeCode() {
/*  342 */     return this._saleReturnLineItemTypeCode;
/*      */   }
/*      */   
/*      */   public void setSaleReturnLineItemTypeCode(String argSaleReturnLineItemTypeCode) {
/*  346 */     if (changed(argSaleReturnLineItemTypeCode, this._saleReturnLineItemTypeCode, "saleReturnLineItemTypeCode")) {
/*  347 */       this._saleReturnLineItemTypeCode = argSaleReturnLineItemTypeCode;
/*      */     }
/*      */   }
/*      */   
/*      */   public String getScannedItemId() {
/*  352 */     return this._scannedItemId;
/*      */   }
/*      */   
/*      */   public void setScannedItemId(String argScannedItemId) {
/*  356 */     if (changed(argScannedItemId, this._scannedItemId, "scannedItemId")) {
/*  357 */       this._scannedItemId = argScannedItemId;
/*      */     }
/*      */   }
/*      */   
/*      */   public String getSerialNumber() {
/*  362 */     return this._serialNumber;
/*      */   }
/*      */   
/*      */   public void setSerialNumber(String argSerialNumber) {
/*  366 */     if (changed(argSerialNumber, this._serialNumber, "serialNumber")) {
/*  367 */       this._serialNumber = argSerialNumber;
/*      */     }
/*      */   }
/*      */   
/*      */   public String getEnteredDescription() {
/*  372 */     return this._enteredDescription;
/*      */   }
/*      */   
/*      */   public void setEnteredDescription(String argEnteredDescription) {
/*  376 */     if (changed(argEnteredDescription, this._enteredDescription, "enteredDescription")) {
/*  377 */       this._enteredDescription = argEnteredDescription;
/*      */     }
/*      */   }
/*      */   
/*      */   public BigDecimal getUnitPrice() {
/*  382 */     return this._unitPrice;
/*      */   }
/*      */   
/*      */   public void setUnitPrice(BigDecimal argUnitPrice) {
/*  386 */     if (changed(argUnitPrice, this._unitPrice, "unitPrice")) {
/*  387 */       this._unitPrice = argUnitPrice;
/*      */     }
/*      */   }
/*      */   
/*      */   public BigDecimal getVatAmount() {
/*  392 */     return this._vatAmount;
/*      */   }
/*      */   
/*      */   public void setVatAmount(BigDecimal argVatAmount) {
/*  396 */     if (changed(argVatAmount, this._vatAmount, "vatAmount")) {
/*  397 */       this._vatAmount = argVatAmount;
/*      */     }
/*      */   }
/*      */   
/*      */   public Boolean getForceZeroExtendedAmt() {
/*  402 */     return this._forceZeroExtendedAmt;
/*      */   }
/*      */   
/*      */   public void setForceZeroExtendedAmt(Boolean argForceZeroExtendedAmt) {
/*  406 */     if (changed(argForceZeroExtendedAmt, this._forceZeroExtendedAmt, "forceZeroExtendedAmt")) {
/*  407 */       this._forceZeroExtendedAmt = argForceZeroExtendedAmt;
/*      */     }
/*      */   }
/*      */   
/*      */   public String getReturnReasonCode() {
/*  412 */     return this._returnReasonCode;
/*      */   }
/*      */   
/*      */   public void setReturnReasonCode(String argReturnReasonCode) {
/*  416 */     if (changed(argReturnReasonCode, this._returnReasonCode, "returnReasonCode")) {
/*  417 */       this._returnReasonCode = argReturnReasonCode;
/*      */     }
/*      */   }
/*      */   
/*      */   public String getTaxGroupId() {
/*  422 */     return this._taxGroupId;
/*      */   }
/*      */   
/*      */   public void setTaxGroupId(String argTaxGroupId) {
/*  426 */     if (changed(argTaxGroupId, this._taxGroupId, "taxGroupId")) {
/*  427 */       this._taxGroupId = argTaxGroupId;
/*      */     }
/*      */   }
/*      */   
/*      */   public BigDecimal getNetQuantity() {
/*  432 */     return this._netQuantity;
/*      */   }
/*      */   
/*      */   public void setNetQuantity(BigDecimal argNetQuantity) {
/*  436 */     if (changed(argNetQuantity, this._netQuantity, "netQuantity")) {
/*  437 */       this._netQuantity = argNetQuantity;
/*      */     }
/*      */   }
/*      */   
/*      */   public BigDecimal getGrossQuantity() {
/*  442 */     return this._grossQuantity;
/*      */   }
/*      */   
/*      */   public void setGrossQuantity(BigDecimal argGrossQuantity) {
/*  446 */     if (changed(argGrossQuantity, this._grossQuantity, "grossQuantity")) {
/*  447 */       this._grossQuantity = argGrossQuantity;
/*      */     }
/*      */   }
/*      */   
/*      */   public BigDecimal getFoodStampsAppliedAmount() {
/*  452 */     return this._foodStampsAppliedAmount;
/*      */   }
/*      */   
/*      */   public void setFoodStampsAppliedAmount(BigDecimal argFoodStampsAppliedAmount) {
/*  456 */     if (changed(argFoodStampsAppliedAmount, this._foodStampsAppliedAmount, "foodStampsAppliedAmount")) {
/*  457 */       this._foodStampsAppliedAmount = argFoodStampsAppliedAmount;
/*      */     }
/*      */   }
/*      */   
/*      */   public String getVendorId() {
/*  462 */     return this._vendorId;
/*      */   }
/*      */   
/*      */   public void setVendorId(String argVendorId) {
/*  466 */     if (changed(argVendorId, this._vendorId, "vendorId")) {
/*  467 */       this._vendorId = argVendorId;
/*      */     }
/*      */   }
/*      */   
/*      */   public BigDecimal getRegularBasePrice() {
/*  472 */     return this._regularBasePrice;
/*      */   }
/*      */   
/*      */   public void setRegularBasePrice(BigDecimal argRegularBasePrice) {
/*  476 */     if (changed(argRegularBasePrice, this._regularBasePrice, "regularBasePrice")) {
/*  477 */       this._regularBasePrice = argRegularBasePrice;
/*      */     }
/*      */   }
/*      */   
/*      */   public String getPricePropertyCode() {
/*  482 */     return this._pricePropertyCode;
/*      */   }
/*      */   
/*      */   public void setPricePropertyCode(String argPricePropertyCode) {
/*  486 */     if (changed(argPricePropertyCode, this._pricePropertyCode, "pricePropertyCode")) {
/*  487 */       this._pricePropertyCode = argPricePropertyCode;
/*      */     }
/*      */   }
/*      */   
/*      */   public BigDecimal getShippingWeight() {
/*  492 */     return this._shippingWeight;
/*      */   }
/*      */   
/*      */   public void setShippingWeight(BigDecimal argShippingWeight) {
/*  496 */     if (changed(argShippingWeight, this._shippingWeight, "shippingWeight")) {
/*  497 */       this._shippingWeight = argShippingWeight;
/*      */     }
/*      */   }
/*      */   
/*      */   public BigDecimal getUnitCost() {
/*  502 */     return this._unitCost;
/*      */   }
/*      */   
/*      */   public void setUnitCost(BigDecimal argUnitCost) {
/*  506 */     if (changed(argUnitCost, this._unitCost, "unitCost")) {
/*  507 */       this._unitCost = argUnitCost;
/*      */     }
/*      */   }
/*      */   
/*      */   public Boolean getAttachedItemFlag() {
/*  512 */     return this._attachedItemFlag;
/*      */   }
/*      */   
/*      */   public void setAttachedItemFlag(Boolean argAttachedItemFlag) {
/*  516 */     if (changed(argAttachedItemFlag, this._attachedItemFlag, "attachedItemFlag")) {
/*  517 */       this._attachedItemFlag = argAttachedItemFlag;
/*      */     }
/*      */   }
/*      */   
/*      */   public BigDecimal getInitialQuantity() {
/*  522 */     return this._initialQuantity;
/*      */   }
/*      */   
/*      */   public void setInitialQuantity(BigDecimal argInitialQuantity) {
/*  526 */     if (changed(argInitialQuantity, this._initialQuantity, "initialQuantity")) {
/*  527 */       this._initialQuantity = argInitialQuantity;
/*      */     }
/*      */   }
/*      */   
/*      */   public Boolean getNotReturnable() {
/*  532 */     return this._notReturnable;
/*      */   }
/*      */   
/*      */   public void setNotReturnable(Boolean argNotReturnable) {
/*  536 */     if (changed(argNotReturnable, this._notReturnable, "notReturnable")) {
/*  537 */       this._notReturnable = argNotReturnable;
/*      */     }
/*      */   }
/*      */   
/*      */   public Boolean getExcludeFromNetSales() {
/*  542 */     return this._excludeFromNetSales;
/*      */   }
/*      */   
/*      */   public void setExcludeFromNetSales(Boolean argExcludeFromNetSales) {
/*  546 */     if (changed(argExcludeFromNetSales, this._excludeFromNetSales, "excludeFromNetSales")) {
/*  547 */       this._excludeFromNetSales = argExcludeFromNetSales;
/*      */     }
/*      */   }
/*      */   
/*      */   public Boolean getMeasurementRequired() {
/*  552 */     return this._measurementRequired;
/*      */   }
/*      */   
/*      */   public void setMeasurementRequired(Boolean argMeasurementRequired) {
/*  556 */     if (changed(argMeasurementRequired, this._measurementRequired, "measurementRequired")) {
/*  557 */       this._measurementRequired = argMeasurementRequired;
/*      */     }
/*      */   }
/*      */   
/*      */   public String getWeightEntryMethodCode() {
/*  562 */     return this._weightEntryMethodCode;
/*      */   }
/*      */   
/*      */   public void setWeightEntryMethodCode(String argWeightEntryMethodCode) {
/*  566 */     if (changed(argWeightEntryMethodCode, this._weightEntryMethodCode, "weightEntryMethodCode")) {
/*  567 */       this._weightEntryMethodCode = argWeightEntryMethodCode;
/*      */     }
/*      */   }
/*      */   
/*      */   public BigDecimal getTareValue() {
/*  572 */     return this._tareValue;
/*      */   }
/*      */   
/*      */   public void setTareValue(BigDecimal argTareValue) {
/*  576 */     if (changed(argTareValue, this._tareValue, "tareValue")) {
/*  577 */       this._tareValue = argTareValue;
/*      */     }
/*      */   }
/*      */   
/*      */   public String getTareType() {
/*  582 */     return this._tareType;
/*      */   }
/*      */   
/*      */   public void setTareType(String argTareType) {
/*  586 */     if (changed(argTareType, this._tareType, "tareType")) {
/*  587 */       this._tareType = argTareType;
/*      */     }
/*      */   }
/*      */   
/*      */   public String getTareUnitOfMeasureCode() {
/*  592 */     return this._tareUnitOfMeasureCode;
/*      */   }
/*      */   
/*      */   public void setTareUnitOfMeasureCode(String argTareUnitOfMeasureCode) {
/*  596 */     if (changed(argTareUnitOfMeasureCode, this._tareUnitOfMeasureCode, "tareUnitOfMeasureCode")) {
/*  597 */       this._tareUnitOfMeasureCode = argTareUnitOfMeasureCode;
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public String toString() {
/*  604 */     StringBuilder buf = new StringBuilder(512);
/*  605 */     buf.append(super.toString());
/*  606 */     if (getCreateDate() != null) {
/*  607 */       buf.append("createDate").append("=").append(getCreateDate()).append(" ");
/*      */     }
/*  609 */     if (getCreateUserId() != null) {
/*  610 */       buf.append("createUserId").append("=").append(getCreateUserId()).append(" ");
/*      */     }
/*  612 */     if (getUpdateDate() != null) {
/*  613 */       buf.append("updateDate").append("=").append(getUpdateDate()).append(" ");
/*      */     }
/*  615 */     if (getUpdateUserId() != null) {
/*  616 */       buf.append("updateUserId").append("=").append(getUpdateUserId()).append(" ");
/*      */     }
/*  618 */     if (getBaseExtendedPrice() != null) {
/*  619 */       buf.append("baseExtendedPrice").append("=").append(getBaseExtendedPrice()).append(" ");
/*      */     }
/*  621 */     if (getBaseUnitPrice() != null) {
/*  622 */       buf.append("baseUnitPrice").append("=").append(getBaseUnitPrice()).append(" ");
/*      */     }
/*  624 */     if (getMerchLevel1Id() != null) {
/*  625 */       buf.append("merchLevel1Id").append("=").append(getMerchLevel1Id()).append(" ");
/*      */     }
/*  627 */     if (getExtendedAmount() != null) {
/*  628 */       buf.append("extendedAmount").append("=").append(getExtendedAmount()).append(" ");
/*      */     }
/*  630 */     if (getGiftReceiptCount() != null) {
/*  631 */       buf.append("giftReceiptCount").append("=").append(getGiftReceiptCount()).append(" ");
/*      */     }
/*  633 */     if (getGrossAmount() != null) {
/*  634 */       buf.append("grossAmount").append("=").append(getGrossAmount()).append(" ");
/*      */     }
/*  636 */     if (getInventoryActionCode() != null) {
/*  637 */       buf.append("inventoryActionCode").append("=").append(getInventoryActionCode()).append(" ");
/*      */     }
/*  639 */     if (getItemId() != null) {
/*  640 */       buf.append("itemId").append("=").append(getItemId()).append(" ");
/*      */     }
/*  642 */     if (getItemIdEntryMethodCode() != null) {
/*  643 */       buf.append("itemIdEntryMethodCode").append("=").append(getItemIdEntryMethodCode()).append(" ");
/*      */     }
/*  645 */     if (getNetAmount() != null) {
/*  646 */       buf.append("netAmount").append("=").append(getNetAmount()).append(" ");
/*      */     }
/*  648 */     if (getRptBaseUnitPrice() != null) {
/*  649 */       buf.append("rptBaseUnitPrice").append("=").append(getRptBaseUnitPrice()).append(" ");
/*      */     }
/*  651 */     if (getOriginalBusinessDate() != null) {
/*  652 */       buf.append("originalBusinessDate").append("=").append(getOriginalBusinessDate()).append(" ");
/*      */     }
/*  654 */     if (getOriginalLineItemSequence() != null) {
/*  655 */       buf.append("originalLineItemSequence").append("=").append(getOriginalLineItemSequence()).append(" ");
/*      */     }
/*  657 */     if (getOriginalRetailLocationId() != null) {
/*  658 */       buf.append("originalRetailLocationId").append("=").append(getOriginalRetailLocationId()).append(" ");
/*      */     }
/*  660 */     if (getOriginalTransactionSequence() != null) {
/*  661 */       buf.append("originalTransactionSequence").append("=").append(getOriginalTransactionSequence()).append(" ");
/*      */     }
/*  663 */     if (getOriginalWorkstationId() != null) {
/*  664 */       buf.append("originalWorkstationId").append("=").append(getOriginalWorkstationId()).append(" ");
/*      */     }
/*  666 */     if (getPriceDerivationMethodCode() != null) {
/*  667 */       buf.append("priceDerivationMethodCode").append("=").append(getPriceDerivationMethodCode()).append(" ");
/*      */     }
/*  669 */     if (getPriceEntryMethodCode() != null) {
/*  670 */       buf.append("priceEntryMethodCode").append("=").append(getPriceEntryMethodCode()).append(" ");
/*      */     }
/*  672 */     if (getQuantity() != null) {
/*  673 */       buf.append("quantity").append("=").append(getQuantity()).append(" ");
/*      */     }
/*  675 */     if (getReturnComment() != null) {
/*  676 */       buf.append("returnComment").append("=").append(getReturnComment()).append(" ");
/*      */     }
/*  678 */     if (getReturn() != null && getReturn().booleanValue()) {
/*  679 */       buf.append("return").append("=").append(getReturn()).append(" ");
/*      */     }
/*  681 */     if (getReturnTypeCode() != null) {
/*  682 */       buf.append("returnTypeCode").append("=").append(getReturnTypeCode()).append(" ");
/*      */     }
/*  684 */     if (getSaleReturnLineItemTypeCode() != null) {
/*  685 */       buf.append("saleReturnLineItemTypeCode").append("=").append(getSaleReturnLineItemTypeCode()).append(" ");
/*      */     }
/*  687 */     if (getScannedItemId() != null) {
/*  688 */       buf.append("scannedItemId").append("=").append(getScannedItemId()).append(" ");
/*      */     }
/*  690 */     if (getSerialNumber() != null) {
/*  691 */       buf.append("serialNumber").append("=").append(getSerialNumber()).append(" ");
/*      */     }
/*  693 */     if (getEnteredDescription() != null) {
/*  694 */       buf.append("enteredDescription").append("=").append(getEnteredDescription()).append(" ");
/*      */     }
/*  696 */     if (getUnitPrice() != null) {
/*  697 */       buf.append("unitPrice").append("=").append(getUnitPrice()).append(" ");
/*      */     }
/*  699 */     if (getVatAmount() != null) {
/*  700 */       buf.append("vatAmount").append("=").append(getVatAmount()).append(" ");
/*      */     }
/*  702 */     if (getForceZeroExtendedAmt() != null && getForceZeroExtendedAmt().booleanValue()) {
/*  703 */       buf.append("forceZeroExtendedAmt").append("=").append(getForceZeroExtendedAmt()).append(" ");
/*      */     }
/*  705 */     if (getReturnReasonCode() != null) {
/*  706 */       buf.append("returnReasonCode").append("=").append(getReturnReasonCode()).append(" ");
/*      */     }
/*  708 */     if (getTaxGroupId() != null) {
/*  709 */       buf.append("taxGroupId").append("=").append(getTaxGroupId()).append(" ");
/*      */     }
/*  711 */     if (getNetQuantity() != null) {
/*  712 */       buf.append("netQuantity").append("=").append(getNetQuantity()).append(" ");
/*      */     }
/*  714 */     if (getGrossQuantity() != null) {
/*  715 */       buf.append("grossQuantity").append("=").append(getGrossQuantity()).append(" ");
/*      */     }
/*  717 */     if (getFoodStampsAppliedAmount() != null) {
/*  718 */       buf.append("foodStampsAppliedAmount").append("=").append(getFoodStampsAppliedAmount()).append(" ");
/*      */     }
/*  720 */     if (getVendorId() != null) {
/*  721 */       buf.append("vendorId").append("=").append(getVendorId()).append(" ");
/*      */     }
/*  723 */     if (getRegularBasePrice() != null) {
/*  724 */       buf.append("regularBasePrice").append("=").append(getRegularBasePrice()).append(" ");
/*      */     }
/*  726 */     if (getPricePropertyCode() != null) {
/*  727 */       buf.append("pricePropertyCode").append("=").append(getPricePropertyCode()).append(" ");
/*      */     }
/*  729 */     if (getShippingWeight() != null) {
/*  730 */       buf.append("shippingWeight").append("=").append(getShippingWeight()).append(" ");
/*      */     }
/*  732 */     if (getUnitCost() != null) {
/*  733 */       buf.append("unitCost").append("=").append(getUnitCost()).append(" ");
/*      */     }
/*  735 */     if (getAttachedItemFlag() != null && getAttachedItemFlag().booleanValue()) {
/*  736 */       buf.append("attachedItemFlag").append("=").append(getAttachedItemFlag()).append(" ");
/*      */     }
/*  738 */     if (getInitialQuantity() != null) {
/*  739 */       buf.append("initialQuantity").append("=").append(getInitialQuantity()).append(" ");
/*      */     }
/*  741 */     if (getNotReturnable() != null && getNotReturnable().booleanValue()) {
/*  742 */       buf.append("notReturnable").append("=").append(getNotReturnable()).append(" ");
/*      */     }
/*  744 */     if (getExcludeFromNetSales() != null && getExcludeFromNetSales().booleanValue()) {
/*  745 */       buf.append("excludeFromNetSales").append("=").append(getExcludeFromNetSales()).append(" ");
/*      */     }
/*  747 */     if (getMeasurementRequired() != null && getMeasurementRequired().booleanValue()) {
/*  748 */       buf.append("measurementRequired").append("=").append(getMeasurementRequired()).append(" ");
/*      */     }
/*  750 */     if (getWeightEntryMethodCode() != null) {
/*  751 */       buf.append("weightEntryMethodCode").append("=").append(getWeightEntryMethodCode()).append(" ");
/*      */     }
/*  753 */     if (getTareValue() != null) {
/*  754 */       buf.append("tareValue").append("=").append(getTareValue()).append(" ");
/*      */     }
/*  756 */     if (getTareType() != null) {
/*  757 */       buf.append("tareType").append("=").append(getTareType()).append(" ");
/*      */     }
/*  759 */     if (getTareUnitOfMeasureCode() != null) {
/*  760 */       buf.append("tareUnitOfMeasureCode").append("=").append(getTareUnitOfMeasureCode()).append(" ");
/*      */     }
/*      */     
/*  763 */     return buf.toString();
/*      */   }
/*      */ 
/*      */   
/*      */   public String toXmlString() {
/*  768 */     StringBuilder buf = new StringBuilder(3650);
/*  769 */     buf.append("<").append("dao").append(" name=\"SaleReturnLineItem\" cmd=\"" + getObjectStateString() + "\">");
/*  770 */     getFieldsAsXml(buf);
/*  771 */     buf.append("</").append("dao").append(">");
/*      */     
/*  773 */     return buf.toString();
/*      */   }
/*      */   
/*      */   public Map<String, String> getValues() {
/*  777 */     Map<String, String> values = super.getValues();
/*  778 */     if (this._createDate != null) values.put("CreateDate", DaoUtils.getXmlSafeFieldValue(91, this._createDate)); 
/*  779 */     if (this._createUserId != null) values.put("CreateUserId", DaoUtils.getXmlSafeFieldValue(12, this._createUserId)); 
/*  780 */     if (this._updateDate != null) values.put("UpdateDate", DaoUtils.getXmlSafeFieldValue(91, this._updateDate)); 
/*  781 */     if (this._updateUserId != null) values.put("UpdateUserId", DaoUtils.getXmlSafeFieldValue(12, this._updateUserId)); 
/*  782 */     if (this._baseExtendedPrice != null) values.put("BaseExtendedPrice", DaoUtils.getXmlSafeFieldValue(3, this._baseExtendedPrice)); 
/*  783 */     if (this._baseUnitPrice != null) values.put("BaseUnitPrice", DaoUtils.getXmlSafeFieldValue(3, this._baseUnitPrice)); 
/*  784 */     if (this._merchLevel1Id != null) values.put("MerchLevel1Id", DaoUtils.getXmlSafeFieldValue(12, this._merchLevel1Id)); 
/*  785 */     if (this._extendedAmount != null) values.put("ExtendedAmount", DaoUtils.getXmlSafeFieldValue(3, this._extendedAmount)); 
/*  786 */     if (this._giftReceiptCount != null) values.put("GiftReceiptCount", DaoUtils.getXmlSafeFieldValue(4, this._giftReceiptCount)); 
/*  787 */     if (this._grossAmount != null) values.put("GrossAmount", DaoUtils.getXmlSafeFieldValue(3, this._grossAmount)); 
/*  788 */     if (this._inventoryActionCode != null) values.put("InventoryActionCode", DaoUtils.getXmlSafeFieldValue(12, this._inventoryActionCode)); 
/*  789 */     if (this._itemId != null) values.put("ItemId", DaoUtils.getXmlSafeFieldValue(12, this._itemId)); 
/*  790 */     if (this._itemIdEntryMethodCode != null) values.put("ItemIdEntryMethodCode", DaoUtils.getXmlSafeFieldValue(12, this._itemIdEntryMethodCode)); 
/*  791 */     if (this._netAmount != null) values.put("NetAmount", DaoUtils.getXmlSafeFieldValue(3, this._netAmount)); 
/*  792 */     if (this._rptBaseUnitPrice != null) values.put("RptBaseUnitPrice", DaoUtils.getXmlSafeFieldValue(3, this._rptBaseUnitPrice)); 
/*  793 */     if (this._originalBusinessDate != null) values.put("OriginalBusinessDate", DaoUtils.getXmlSafeFieldValue(91, this._originalBusinessDate)); 
/*  794 */     if (this._originalLineItemSequence != null) values.put("OriginalLineItemSequence", DaoUtils.getXmlSafeFieldValue(4, this._originalLineItemSequence)); 
/*  795 */     if (this._originalRetailLocationId != null) values.put("OriginalRetailLocationId", DaoUtils.getXmlSafeFieldValue(-5, this._originalRetailLocationId)); 
/*  796 */     if (this._originalTransactionSequence != null) values.put("OriginalTransactionSequence", DaoUtils.getXmlSafeFieldValue(-5, this._originalTransactionSequence)); 
/*  797 */     if (this._originalWorkstationId != null) values.put("OriginalWorkstationId", DaoUtils.getXmlSafeFieldValue(-5, this._originalWorkstationId)); 
/*  798 */     if (this._priceDerivationMethodCode != null) values.put("PriceDerivationMethodCode", DaoUtils.getXmlSafeFieldValue(12, this._priceDerivationMethodCode)); 
/*  799 */     if (this._priceEntryMethodCode != null) values.put("PriceEntryMethodCode", DaoUtils.getXmlSafeFieldValue(12, this._priceEntryMethodCode)); 
/*  800 */     if (this._quantity != null) values.put("Quantity", DaoUtils.getXmlSafeFieldValue(3, this._quantity)); 
/*  801 */     if (this._returnComment != null) values.put("ReturnComment", DaoUtils.getXmlSafeFieldValue(12, this._returnComment)); 
/*  802 */     if (this._return != null) values.put("Return", DaoUtils.getXmlSafeFieldValue(-7, this._return)); 
/*  803 */     if (this._returnTypeCode != null) values.put("ReturnTypeCode", DaoUtils.getXmlSafeFieldValue(12, this._returnTypeCode)); 
/*  804 */     if (this._saleReturnLineItemTypeCode != null) values.put("SaleReturnLineItemTypeCode", DaoUtils.getXmlSafeFieldValue(12, this._saleReturnLineItemTypeCode)); 
/*  805 */     if (this._scannedItemId != null) values.put("ScannedItemId", DaoUtils.getXmlSafeFieldValue(12, this._scannedItemId)); 
/*  806 */     if (this._serialNumber != null) values.put("SerialNumber", DaoUtils.getXmlSafeFieldValue(12, this._serialNumber)); 
/*  807 */     if (this._enteredDescription != null) values.put("EnteredDescription", DaoUtils.getXmlSafeFieldValue(12, this._enteredDescription)); 
/*  808 */     if (this._unitPrice != null) values.put("UnitPrice", DaoUtils.getXmlSafeFieldValue(3, this._unitPrice)); 
/*  809 */     if (this._vatAmount != null) values.put("VatAmount", DaoUtils.getXmlSafeFieldValue(3, this._vatAmount)); 
/*  810 */     if (this._forceZeroExtendedAmt != null) values.put("ForceZeroExtendedAmt", DaoUtils.getXmlSafeFieldValue(-7, this._forceZeroExtendedAmt)); 
/*  811 */     if (this._returnReasonCode != null) values.put("ReturnReasonCode", DaoUtils.getXmlSafeFieldValue(12, this._returnReasonCode)); 
/*  812 */     if (this._taxGroupId != null) values.put("TaxGroupId", DaoUtils.getXmlSafeFieldValue(12, this._taxGroupId)); 
/*  813 */     if (this._netQuantity != null) values.put("NetQuantity", DaoUtils.getXmlSafeFieldValue(3, this._netQuantity)); 
/*  814 */     if (this._grossQuantity != null) values.put("GrossQuantity", DaoUtils.getXmlSafeFieldValue(3, this._grossQuantity)); 
/*  815 */     if (this._foodStampsAppliedAmount != null) values.put("FoodStampsAppliedAmount", DaoUtils.getXmlSafeFieldValue(3, this._foodStampsAppliedAmount)); 
/*  816 */     if (this._vendorId != null) values.put("VendorId", DaoUtils.getXmlSafeFieldValue(12, this._vendorId)); 
/*  817 */     if (this._regularBasePrice != null) values.put("RegularBasePrice", DaoUtils.getXmlSafeFieldValue(3, this._regularBasePrice)); 
/*  818 */     if (this._pricePropertyCode != null) values.put("PricePropertyCode", DaoUtils.getXmlSafeFieldValue(12, this._pricePropertyCode)); 
/*  819 */     if (this._shippingWeight != null) values.put("ShippingWeight", DaoUtils.getXmlSafeFieldValue(3, this._shippingWeight)); 
/*  820 */     if (this._unitCost != null) values.put("UnitCost", DaoUtils.getXmlSafeFieldValue(3, this._unitCost)); 
/*  821 */     if (this._attachedItemFlag != null) values.put("AttachedItemFlag", DaoUtils.getXmlSafeFieldValue(-7, this._attachedItemFlag)); 
/*  822 */     if (this._initialQuantity != null) values.put("InitialQuantity", DaoUtils.getXmlSafeFieldValue(3, this._initialQuantity)); 
/*  823 */     if (this._notReturnable != null) values.put("NotReturnable", DaoUtils.getXmlSafeFieldValue(-7, this._notReturnable)); 
/*  824 */     if (this._excludeFromNetSales != null) values.put("ExcludeFromNetSales", DaoUtils.getXmlSafeFieldValue(-7, this._excludeFromNetSales)); 
/*  825 */     if (this._measurementRequired != null) values.put("MeasurementRequired", DaoUtils.getXmlSafeFieldValue(-7, this._measurementRequired)); 
/*  826 */     if (this._weightEntryMethodCode != null) values.put("WeightEntryMethodCode", DaoUtils.getXmlSafeFieldValue(12, this._weightEntryMethodCode)); 
/*  827 */     if (this._tareValue != null) values.put("TareValue", DaoUtils.getXmlSafeFieldValue(3, this._tareValue)); 
/*  828 */     if (this._tareType != null) values.put("TareType", DaoUtils.getXmlSafeFieldValue(12, this._tareType)); 
/*  829 */     if (this._tareUnitOfMeasureCode != null) values.put("TareUnitOfMeasureCode", DaoUtils.getXmlSafeFieldValue(12, this._tareUnitOfMeasureCode)); 
/*  830 */     return values;
/*      */   }
/*      */ 
/*      */   
/*      */   public void setValues(Map<String, String> argValues) {
/*  835 */     super.setValues(argValues);
/*  836 */     for (Map.Entry<String, String> field : argValues.entrySet()) {
/*      */       
/*  838 */       String fieldName = field.getKey();
/*  839 */       String fieldValue = field.getValue();
/*  840 */       switch (fieldName) {
/*      */         
/*      */         case "CreateDate":
/*      */           try {
/*  844 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/*  845 */             setCreateDate((Date)value);
/*  846 */           } catch (Exception ee) {
/*  847 */             throw new DtxException("An exception occurred while calling setCreateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*      */           } 
/*      */ 
/*      */         
/*      */         case "CreateUserId":
/*      */           try {
/*  853 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/*  854 */             setCreateUserId((String)value);
/*  855 */           } catch (Exception ee) {
/*  856 */             throw new DtxException("An exception occurred while calling setCreateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*      */           } 
/*      */ 
/*      */         
/*      */         case "UpdateDate":
/*      */           try {
/*  862 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/*  863 */             setUpdateDate((Date)value);
/*  864 */           } catch (Exception ee) {
/*  865 */             throw new DtxException("An exception occurred while calling setUpdateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*      */           } 
/*      */ 
/*      */         
/*      */         case "UpdateUserId":
/*      */           try {
/*  871 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/*  872 */             setUpdateUserId((String)value);
/*  873 */           } catch (Exception ee) {
/*  874 */             throw new DtxException("An exception occurred while calling setUpdateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*      */           } 
/*      */ 
/*      */         
/*      */         case "BaseExtendedPrice":
/*      */           try {
/*  880 */             Object value = DaoUtils.getFieldValueForXmlString(3, fieldValue);
/*  881 */             setBaseExtendedPrice((BigDecimal)value);
/*  882 */           } catch (Exception ee) {
/*  883 */             throw new DtxException("An exception occurred while calling setBaseExtendedPrice() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*      */           } 
/*      */ 
/*      */         
/*      */         case "BaseUnitPrice":
/*      */           try {
/*  889 */             Object value = DaoUtils.getFieldValueForXmlString(3, fieldValue);
/*  890 */             setBaseUnitPrice((BigDecimal)value);
/*  891 */           } catch (Exception ee) {
/*  892 */             throw new DtxException("An exception occurred while calling setBaseUnitPrice() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*      */           } 
/*      */ 
/*      */         
/*      */         case "MerchLevel1Id":
/*      */           try {
/*  898 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/*  899 */             setMerchLevel1Id((String)value);
/*  900 */           } catch (Exception ee) {
/*  901 */             throw new DtxException("An exception occurred while calling setMerchLevel1Id() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*      */           } 
/*      */ 
/*      */         
/*      */         case "ExtendedAmount":
/*      */           try {
/*  907 */             Object value = DaoUtils.getFieldValueForXmlString(3, fieldValue);
/*  908 */             setExtendedAmount((BigDecimal)value);
/*  909 */           } catch (Exception ee) {
/*  910 */             throw new DtxException("An exception occurred while calling setExtendedAmount() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*      */           } 
/*      */ 
/*      */         
/*      */         case "GiftReceiptCount":
/*      */           try {
/*  916 */             Object value = DaoUtils.getFieldValueForXmlString(4, fieldValue);
/*  917 */             setGiftReceiptCount((Integer)value);
/*  918 */           } catch (Exception ee) {
/*  919 */             throw new DtxException("An exception occurred while calling setGiftReceiptCount() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*      */           } 
/*      */ 
/*      */         
/*      */         case "GrossAmount":
/*      */           try {
/*  925 */             Object value = DaoUtils.getFieldValueForXmlString(3, fieldValue);
/*  926 */             setGrossAmount((BigDecimal)value);
/*  927 */           } catch (Exception ee) {
/*  928 */             throw new DtxException("An exception occurred while calling setGrossAmount() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*      */           } 
/*      */ 
/*      */         
/*      */         case "InventoryActionCode":
/*      */           try {
/*  934 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/*  935 */             setInventoryActionCode((String)value);
/*  936 */           } catch (Exception ee) {
/*  937 */             throw new DtxException("An exception occurred while calling setInventoryActionCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*      */           } 
/*      */ 
/*      */         
/*      */         case "ItemId":
/*      */           try {
/*  943 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/*  944 */             setItemId((String)value);
/*  945 */           } catch (Exception ee) {
/*  946 */             throw new DtxException("An exception occurred while calling setItemId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*      */           } 
/*      */ 
/*      */         
/*      */         case "ItemIdEntryMethodCode":
/*      */           try {
/*  952 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/*  953 */             setItemIdEntryMethodCode((String)value);
/*  954 */           } catch (Exception ee) {
/*  955 */             throw new DtxException("An exception occurred while calling setItemIdEntryMethodCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*      */           } 
/*      */ 
/*      */         
/*      */         case "NetAmount":
/*      */           try {
/*  961 */             Object value = DaoUtils.getFieldValueForXmlString(3, fieldValue);
/*  962 */             setNetAmount((BigDecimal)value);
/*  963 */           } catch (Exception ee) {
/*  964 */             throw new DtxException("An exception occurred while calling setNetAmount() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*      */           } 
/*      */ 
/*      */         
/*      */         case "RptBaseUnitPrice":
/*      */           try {
/*  970 */             Object value = DaoUtils.getFieldValueForXmlString(3, fieldValue);
/*  971 */             setRptBaseUnitPrice((BigDecimal)value);
/*  972 */           } catch (Exception ee) {
/*  973 */             throw new DtxException("An exception occurred while calling setRptBaseUnitPrice() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*      */           } 
/*      */ 
/*      */         
/*      */         case "OriginalBusinessDate":
/*      */           try {
/*  979 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/*  980 */             setOriginalBusinessDate((Date)value);
/*  981 */           } catch (Exception ee) {
/*  982 */             throw new DtxException("An exception occurred while calling setOriginalBusinessDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*      */           } 
/*      */ 
/*      */         
/*      */         case "OriginalLineItemSequence":
/*      */           try {
/*  988 */             Object value = DaoUtils.getFieldValueForXmlString(4, fieldValue);
/*  989 */             setOriginalLineItemSequence((Integer)value);
/*  990 */           } catch (Exception ee) {
/*  991 */             throw new DtxException("An exception occurred while calling setOriginalLineItemSequence() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*      */           } 
/*      */ 
/*      */         
/*      */         case "OriginalRetailLocationId":
/*      */           try {
/*  997 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/*  998 */             setOriginalRetailLocationId((Long)value);
/*  999 */           } catch (Exception ee) {
/* 1000 */             throw new DtxException("An exception occurred while calling setOriginalRetailLocationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*      */           } 
/*      */ 
/*      */         
/*      */         case "OriginalTransactionSequence":
/*      */           try {
/* 1006 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 1007 */             setOriginalTransactionSequence((Long)value);
/* 1008 */           } catch (Exception ee) {
/* 1009 */             throw new DtxException("An exception occurred while calling setOriginalTransactionSequence() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*      */           } 
/*      */ 
/*      */         
/*      */         case "OriginalWorkstationId":
/*      */           try {
/* 1015 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 1016 */             setOriginalWorkstationId((Long)value);
/* 1017 */           } catch (Exception ee) {
/* 1018 */             throw new DtxException("An exception occurred while calling setOriginalWorkstationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*      */           } 
/*      */ 
/*      */         
/*      */         case "PriceDerivationMethodCode":
/*      */           try {
/* 1024 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 1025 */             setPriceDerivationMethodCode((String)value);
/* 1026 */           } catch (Exception ee) {
/* 1027 */             throw new DtxException("An exception occurred while calling setPriceDerivationMethodCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*      */           } 
/*      */ 
/*      */         
/*      */         case "PriceEntryMethodCode":
/*      */           try {
/* 1033 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 1034 */             setPriceEntryMethodCode((String)value);
/* 1035 */           } catch (Exception ee) {
/* 1036 */             throw new DtxException("An exception occurred while calling setPriceEntryMethodCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*      */           } 
/*      */ 
/*      */         
/*      */         case "Quantity":
/*      */           try {
/* 1042 */             Object value = DaoUtils.getFieldValueForXmlString(3, fieldValue);
/* 1043 */             setQuantity((BigDecimal)value);
/* 1044 */           } catch (Exception ee) {
/* 1045 */             throw new DtxException("An exception occurred while calling setQuantity() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*      */           } 
/*      */ 
/*      */         
/*      */         case "ReturnComment":
/*      */           try {
/* 1051 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 1052 */             setReturnComment((String)value);
/* 1053 */           } catch (Exception ee) {
/* 1054 */             throw new DtxException("An exception occurred while calling setReturnComment() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*      */           } 
/*      */ 
/*      */         
/*      */         case "Return":
/*      */           try {
/* 1060 */             Object value = DaoUtils.getFieldValueForXmlString(-7, fieldValue);
/* 1061 */             setReturn((Boolean)value);
/* 1062 */           } catch (Exception ee) {
/* 1063 */             throw new DtxException("An exception occurred while calling setReturn() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*      */           } 
/*      */ 
/*      */         
/*      */         case "ReturnTypeCode":
/*      */           try {
/* 1069 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 1070 */             setReturnTypeCode((String)value);
/* 1071 */           } catch (Exception ee) {
/* 1072 */             throw new DtxException("An exception occurred while calling setReturnTypeCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*      */           } 
/*      */ 
/*      */         
/*      */         case "SaleReturnLineItemTypeCode":
/*      */           try {
/* 1078 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 1079 */             setSaleReturnLineItemTypeCode((String)value);
/* 1080 */           } catch (Exception ee) {
/* 1081 */             throw new DtxException("An exception occurred while calling setSaleReturnLineItemTypeCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*      */           } 
/*      */ 
/*      */         
/*      */         case "ScannedItemId":
/*      */           try {
/* 1087 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 1088 */             setScannedItemId((String)value);
/* 1089 */           } catch (Exception ee) {
/* 1090 */             throw new DtxException("An exception occurred while calling setScannedItemId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*      */           } 
/*      */ 
/*      */         
/*      */         case "SerialNumber":
/*      */           try {
/* 1096 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 1097 */             setSerialNumber((String)value);
/* 1098 */           } catch (Exception ee) {
/* 1099 */             throw new DtxException("An exception occurred while calling setSerialNumber() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*      */           } 
/*      */ 
/*      */         
/*      */         case "EnteredDescription":
/*      */           try {
/* 1105 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 1106 */             setEnteredDescription((String)value);
/* 1107 */           } catch (Exception ee) {
/* 1108 */             throw new DtxException("An exception occurred while calling setEnteredDescription() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*      */           } 
/*      */ 
/*      */         
/*      */         case "UnitPrice":
/*      */           try {
/* 1114 */             Object value = DaoUtils.getFieldValueForXmlString(3, fieldValue);
/* 1115 */             setUnitPrice((BigDecimal)value);
/* 1116 */           } catch (Exception ee) {
/* 1117 */             throw new DtxException("An exception occurred while calling setUnitPrice() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*      */           } 
/*      */ 
/*      */         
/*      */         case "VatAmount":
/*      */           try {
/* 1123 */             Object value = DaoUtils.getFieldValueForXmlString(3, fieldValue);
/* 1124 */             setVatAmount((BigDecimal)value);
/* 1125 */           } catch (Exception ee) {
/* 1126 */             throw new DtxException("An exception occurred while calling setVatAmount() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*      */           } 
/*      */ 
/*      */         
/*      */         case "ForceZeroExtendedAmt":
/*      */           try {
/* 1132 */             Object value = DaoUtils.getFieldValueForXmlString(-7, fieldValue);
/* 1133 */             setForceZeroExtendedAmt((Boolean)value);
/* 1134 */           } catch (Exception ee) {
/* 1135 */             throw new DtxException("An exception occurred while calling setForceZeroExtendedAmt() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*      */           } 
/*      */ 
/*      */         
/*      */         case "ReturnReasonCode":
/*      */           try {
/* 1141 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 1142 */             setReturnReasonCode((String)value);
/* 1143 */           } catch (Exception ee) {
/* 1144 */             throw new DtxException("An exception occurred while calling setReturnReasonCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*      */           } 
/*      */ 
/*      */         
/*      */         case "TaxGroupId":
/*      */           try {
/* 1150 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 1151 */             setTaxGroupId((String)value);
/* 1152 */           } catch (Exception ee) {
/* 1153 */             throw new DtxException("An exception occurred while calling setTaxGroupId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*      */           } 
/*      */ 
/*      */         
/*      */         case "NetQuantity":
/*      */           try {
/* 1159 */             Object value = DaoUtils.getFieldValueForXmlString(3, fieldValue);
/* 1160 */             setNetQuantity((BigDecimal)value);
/* 1161 */           } catch (Exception ee) {
/* 1162 */             throw new DtxException("An exception occurred while calling setNetQuantity() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*      */           } 
/*      */ 
/*      */         
/*      */         case "GrossQuantity":
/*      */           try {
/* 1168 */             Object value = DaoUtils.getFieldValueForXmlString(3, fieldValue);
/* 1169 */             setGrossQuantity((BigDecimal)value);
/* 1170 */           } catch (Exception ee) {
/* 1171 */             throw new DtxException("An exception occurred while calling setGrossQuantity() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*      */           } 
/*      */ 
/*      */         
/*      */         case "FoodStampsAppliedAmount":
/*      */           try {
/* 1177 */             Object value = DaoUtils.getFieldValueForXmlString(3, fieldValue);
/* 1178 */             setFoodStampsAppliedAmount((BigDecimal)value);
/* 1179 */           } catch (Exception ee) {
/* 1180 */             throw new DtxException("An exception occurred while calling setFoodStampsAppliedAmount() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*      */           } 
/*      */ 
/*      */         
/*      */         case "VendorId":
/*      */           try {
/* 1186 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 1187 */             setVendorId((String)value);
/* 1188 */           } catch (Exception ee) {
/* 1189 */             throw new DtxException("An exception occurred while calling setVendorId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*      */           } 
/*      */ 
/*      */         
/*      */         case "RegularBasePrice":
/*      */           try {
/* 1195 */             Object value = DaoUtils.getFieldValueForXmlString(3, fieldValue);
/* 1196 */             setRegularBasePrice((BigDecimal)value);
/* 1197 */           } catch (Exception ee) {
/* 1198 */             throw new DtxException("An exception occurred while calling setRegularBasePrice() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*      */           } 
/*      */ 
/*      */         
/*      */         case "PricePropertyCode":
/*      */           try {
/* 1204 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 1205 */             setPricePropertyCode((String)value);
/* 1206 */           } catch (Exception ee) {
/* 1207 */             throw new DtxException("An exception occurred while calling setPricePropertyCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*      */           } 
/*      */ 
/*      */         
/*      */         case "ShippingWeight":
/*      */           try {
/* 1213 */             Object value = DaoUtils.getFieldValueForXmlString(3, fieldValue);
/* 1214 */             setShippingWeight((BigDecimal)value);
/* 1215 */           } catch (Exception ee) {
/* 1216 */             throw new DtxException("An exception occurred while calling setShippingWeight() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*      */           } 
/*      */ 
/*      */         
/*      */         case "UnitCost":
/*      */           try {
/* 1222 */             Object value = DaoUtils.getFieldValueForXmlString(3, fieldValue);
/* 1223 */             setUnitCost((BigDecimal)value);
/* 1224 */           } catch (Exception ee) {
/* 1225 */             throw new DtxException("An exception occurred while calling setUnitCost() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*      */           } 
/*      */ 
/*      */         
/*      */         case "AttachedItemFlag":
/*      */           try {
/* 1231 */             Object value = DaoUtils.getFieldValueForXmlString(-7, fieldValue);
/* 1232 */             setAttachedItemFlag((Boolean)value);
/* 1233 */           } catch (Exception ee) {
/* 1234 */             throw new DtxException("An exception occurred while calling setAttachedItemFlag() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*      */           } 
/*      */ 
/*      */         
/*      */         case "InitialQuantity":
/*      */           try {
/* 1240 */             Object value = DaoUtils.getFieldValueForXmlString(3, fieldValue);
/* 1241 */             setInitialQuantity((BigDecimal)value);
/* 1242 */           } catch (Exception ee) {
/* 1243 */             throw new DtxException("An exception occurred while calling setInitialQuantity() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*      */           } 
/*      */ 
/*      */         
/*      */         case "NotReturnable":
/*      */           try {
/* 1249 */             Object value = DaoUtils.getFieldValueForXmlString(-7, fieldValue);
/* 1250 */             setNotReturnable((Boolean)value);
/* 1251 */           } catch (Exception ee) {
/* 1252 */             throw new DtxException("An exception occurred while calling setNotReturnable() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*      */           } 
/*      */ 
/*      */         
/*      */         case "ExcludeFromNetSales":
/*      */           try {
/* 1258 */             Object value = DaoUtils.getFieldValueForXmlString(-7, fieldValue);
/* 1259 */             setExcludeFromNetSales((Boolean)value);
/* 1260 */           } catch (Exception ee) {
/* 1261 */             throw new DtxException("An exception occurred while calling setExcludeFromNetSales() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*      */           } 
/*      */ 
/*      */         
/*      */         case "MeasurementRequired":
/*      */           try {
/* 1267 */             Object value = DaoUtils.getFieldValueForXmlString(-7, fieldValue);
/* 1268 */             setMeasurementRequired((Boolean)value);
/* 1269 */           } catch (Exception ee) {
/* 1270 */             throw new DtxException("An exception occurred while calling setMeasurementRequired() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*      */           } 
/*      */ 
/*      */         
/*      */         case "WeightEntryMethodCode":
/*      */           try {
/* 1276 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 1277 */             setWeightEntryMethodCode((String)value);
/* 1278 */           } catch (Exception ee) {
/* 1279 */             throw new DtxException("An exception occurred while calling setWeightEntryMethodCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*      */           } 
/*      */ 
/*      */         
/*      */         case "TareValue":
/*      */           try {
/* 1285 */             Object value = DaoUtils.getFieldValueForXmlString(3, fieldValue);
/* 1286 */             setTareValue((BigDecimal)value);
/* 1287 */           } catch (Exception ee) {
/* 1288 */             throw new DtxException("An exception occurred while calling setTareValue() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*      */           } 
/*      */ 
/*      */         
/*      */         case "TareType":
/*      */           try {
/* 1294 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 1295 */             setTareType((String)value);
/* 1296 */           } catch (Exception ee) {
/* 1297 */             throw new DtxException("An exception occurred while calling setTareType() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*      */           } 
/*      */ 
/*      */         
/*      */         case "TareUnitOfMeasureCode":
/*      */           try {
/* 1303 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 1304 */             setTareUnitOfMeasureCode((String)value);
/* 1305 */           } catch (Exception ee) {
/* 1306 */             throw new DtxException("An exception occurred while calling setTareUnitOfMeasureCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*      */           } 
/*      */       } 
/*      */     } 
/*      */   }
/*      */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\trl\impl\SaleReturnLineItemDAO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */