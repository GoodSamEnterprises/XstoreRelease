/*      */ package dtv.xst.dao.itm.impl;
/*      */ 
/*      */ import dtv.data2.access.DaoUtils;
/*      */ import dtv.data2.access.IObjectId;
/*      */ import dtv.data2.access.exception.DtxException;
/*      */ import dtv.data2.access.impl.AbstractDAOImpl;
/*      */ import dtv.util.DtvDate;
/*      */ import dtv.xst.dao.itm.ItemOptionsId;
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
/*      */ public class ItemOptionsDAO
/*      */   extends AbstractDAOImpl
/*      */ {
/*      */   private static final long serialVersionUID = -115523605L;
/*   23 */   private static final Logger _logger = Logger.getLogger(ItemOptionsDAO.class);
/*      */   
/*      */   private Long _organizationId;
/*      */   private String _itemId;
/*      */   private String _levelCode;
/*      */   private String _levelValue;
/*      */   private DtvDate _createDate;
/*      */   private String _createUserId;
/*      */   private DtvDate _updateDate;
/*      */   private String _updateUserId;
/*   33 */   private Boolean _applyRestockingFee = Boolean.FALSE;
/*   34 */   private Boolean _attachedItems = Boolean.FALSE;
/*      */   private BigDecimal _compareAtPrice;
/*   36 */   private Boolean _disallowDiscounts = Boolean.FALSE;
/*   37 */   private Boolean _disallowDeals = Boolean.FALSE;
/*   38 */   private Boolean _disallowPriceChange = Boolean.FALSE;
/*   39 */   private Boolean _disallowSendSale = Boolean.FALSE;
/*   40 */   private Boolean _disallowCommission = Boolean.FALSE;
/*   41 */   private Boolean _disallowLayaway = Boolean.FALSE;
/*   42 */   private Boolean _disallowWorkOrder = Boolean.FALSE;
/*   43 */   private Boolean _disallowSpecialOrder = Boolean.FALSE;
/*   44 */   private Boolean _disallowOrder = Boolean.FALSE;
/*   45 */   private Boolean _disallowRainCheck = Boolean.FALSE;
/*   46 */   private Boolean _forceQuantityOfOne = Boolean.FALSE;
/*      */   private BigDecimal _maximumSaleUnitCount;
/*      */   private BigDecimal _minimumSaleUnitCount;
/*   49 */   private Boolean _noGiveaways = Boolean.FALSE;
/*   50 */   private Boolean _notReturnable = Boolean.FALSE;
/*      */   private String _partNumber;
/*   52 */   private Boolean _promptForPrice = Boolean.FALSE;
/*   53 */   private Boolean _promptForQuantity = Boolean.FALSE;
/*   54 */   private Boolean _promptForDescription = Boolean.FALSE;
/*      */   private String _promptForCustomer;
/*      */   private BigDecimal _restockingFee;
/*      */   private String _seasonCode;
/*   58 */   private Boolean _substituteAvailable = Boolean.FALSE;
/*      */   private BigDecimal _unitCost;
/*      */   private String _vendorId;
/*      */   private Integer _specialOrderLeadDays;
/*      */   private Integer _qtyScale;
/*   63 */   private Boolean _messages = Boolean.FALSE;
/*      */   private String _unitOfMeasureCode;
/*      */   private String _taxGroupId;
/*   66 */   private Boolean _warranty = Boolean.FALSE;
/*   67 */   private Boolean _genericItem = Boolean.FALSE;
/*      */   private BigDecimal _currentSalePrice;
/*      */   private BigDecimal _initialSaleQuantity;
/*      */   private String _dispositionCode;
/*      */   private String _itemAvailabilityCode;
/*      */   private Integer _minAgeRequired;
/*      */   private String _stockStatus;
/*   74 */   private Boolean _foodStampEligible = Boolean.FALSE;
/*      */   private BigDecimal _shippingWeight;
/*      */   private BigDecimal _packSize;
/*      */   private String _defaultSourceType;
/*      */   private String _defaultSourceId;
/*      */   private String _sellingGroupId;
/*   80 */   private Boolean _excludeFromNetSales = Boolean.FALSE;
/*      */   private String _fiscalItemId;
/*      */   private String _fiscalItemDescription;
/*      */   private String _externalSystem;
/*      */   private BigDecimal _tareValue;
/*      */   private String _tareUnitOfMeasureCode;
/*      */   
/*      */   public Long getOrganizationId() {
/*   88 */     return this._organizationId;
/*      */   }
/*      */   
/*      */   public void setOrganizationId(Long argOrganizationId) {
/*   92 */     if (changed(argOrganizationId, this._organizationId, "organizationId")) {
/*   93 */       this._organizationId = argOrganizationId;
/*      */     }
/*      */   }
/*      */   
/*      */   public String getItemId() {
/*   98 */     return this._itemId;
/*      */   }
/*      */   
/*      */   public void setItemId(String argItemId) {
/*  102 */     if (changed(argItemId, this._itemId, "itemId")) {
/*  103 */       this._itemId = (argItemId != null && MANAGE_CASE) ? argItemId.toUpperCase() : argItemId;
/*      */     }
/*      */   }
/*      */   
/*      */   public String getLevelCode() {
/*  108 */     return this._levelCode;
/*      */   }
/*      */   
/*      */   public void setLevelCode(String argLevelCode) {
/*  112 */     if (changed(argLevelCode, this._levelCode, "levelCode")) {
/*  113 */       this._levelCode = (argLevelCode != null && MANAGE_CASE) ? argLevelCode.toUpperCase() : argLevelCode;
/*      */     }
/*      */   }
/*      */   
/*      */   public String getLevelValue() {
/*  118 */     return this._levelValue;
/*      */   }
/*      */   
/*      */   public void setLevelValue(String argLevelValue) {
/*  122 */     if (changed(argLevelValue, this._levelValue, "levelValue")) {
/*  123 */       this._levelValue = (argLevelValue != null && MANAGE_CASE) ? argLevelValue.toUpperCase() : argLevelValue;
/*      */     }
/*      */   }
/*      */   
/*      */   public Date getCreateDate() {
/*  128 */     return (Date)this._createDate;
/*      */   }
/*      */   
/*      */   public void setCreateDate(Date argCreateDate) {
/*  132 */     if (changed(argCreateDate, this._createDate, "createDate")) {
/*  133 */       this._createDate = (argCreateDate == null || argCreateDate instanceof DtvDate) ? (DtvDate)argCreateDate : new DtvDate(argCreateDate);
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   public String getCreateUserId() {
/*  139 */     return this._createUserId;
/*      */   }
/*      */   
/*      */   public void setCreateUserId(String argCreateUserId) {
/*  143 */     if (changed(argCreateUserId, this._createUserId, "createUserId")) {
/*  144 */       this._createUserId = argCreateUserId;
/*      */     }
/*      */   }
/*      */   
/*      */   public Date getUpdateDate() {
/*  149 */     return (Date)this._updateDate;
/*      */   }
/*      */   
/*      */   public void setUpdateDate(Date argUpdateDate) {
/*  153 */     if (changed(argUpdateDate, this._updateDate, "updateDate")) {
/*  154 */       this._updateDate = (argUpdateDate == null || argUpdateDate instanceof DtvDate) ? (DtvDate)argUpdateDate : new DtvDate(argUpdateDate);
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   public String getUpdateUserId() {
/*  160 */     return this._updateUserId;
/*      */   }
/*      */   
/*      */   public void setUpdateUserId(String argUpdateUserId) {
/*  164 */     if (changed(argUpdateUserId, this._updateUserId, "updateUserId")) {
/*  165 */       this._updateUserId = argUpdateUserId;
/*      */     }
/*      */   }
/*      */   
/*      */   public Boolean getApplyRestockingFee() {
/*  170 */     return this._applyRestockingFee;
/*      */   }
/*      */   
/*      */   public void setApplyRestockingFee(Boolean argApplyRestockingFee) {
/*  174 */     if (changed(argApplyRestockingFee, this._applyRestockingFee, "applyRestockingFee")) {
/*  175 */       this._applyRestockingFee = argApplyRestockingFee;
/*      */     }
/*      */   }
/*      */   
/*      */   public Boolean getAttachedItems() {
/*  180 */     return this._attachedItems;
/*      */   }
/*      */   
/*      */   public void setAttachedItems(Boolean argAttachedItems) {
/*  184 */     if (changed(argAttachedItems, this._attachedItems, "attachedItems")) {
/*  185 */       this._attachedItems = argAttachedItems;
/*      */     }
/*      */   }
/*      */   
/*      */   public BigDecimal getCompareAtPrice() {
/*  190 */     return this._compareAtPrice;
/*      */   }
/*      */   
/*      */   public void setCompareAtPrice(BigDecimal argCompareAtPrice) {
/*  194 */     if (changed(argCompareAtPrice, this._compareAtPrice, "compareAtPrice")) {
/*  195 */       this._compareAtPrice = argCompareAtPrice;
/*      */     }
/*      */   }
/*      */   
/*      */   public Boolean getDisallowDiscounts() {
/*  200 */     return this._disallowDiscounts;
/*      */   }
/*      */   
/*      */   public void setDisallowDiscounts(Boolean argDisallowDiscounts) {
/*  204 */     if (changed(argDisallowDiscounts, this._disallowDiscounts, "disallowDiscounts")) {
/*  205 */       this._disallowDiscounts = argDisallowDiscounts;
/*      */     }
/*      */   }
/*      */   
/*      */   public Boolean getDisallowDeals() {
/*  210 */     return this._disallowDeals;
/*      */   }
/*      */   
/*      */   public void setDisallowDeals(Boolean argDisallowDeals) {
/*  214 */     if (changed(argDisallowDeals, this._disallowDeals, "disallowDeals")) {
/*  215 */       this._disallowDeals = argDisallowDeals;
/*      */     }
/*      */   }
/*      */   
/*      */   public Boolean getDisallowPriceChange() {
/*  220 */     return this._disallowPriceChange;
/*      */   }
/*      */   
/*      */   public void setDisallowPriceChange(Boolean argDisallowPriceChange) {
/*  224 */     if (changed(argDisallowPriceChange, this._disallowPriceChange, "disallowPriceChange")) {
/*  225 */       this._disallowPriceChange = argDisallowPriceChange;
/*      */     }
/*      */   }
/*      */   
/*      */   public Boolean getDisallowSendSale() {
/*  230 */     return this._disallowSendSale;
/*      */   }
/*      */   
/*      */   public void setDisallowSendSale(Boolean argDisallowSendSale) {
/*  234 */     if (changed(argDisallowSendSale, this._disallowSendSale, "disallowSendSale")) {
/*  235 */       this._disallowSendSale = argDisallowSendSale;
/*      */     }
/*      */   }
/*      */   
/*      */   public Boolean getDisallowCommission() {
/*  240 */     return this._disallowCommission;
/*      */   }
/*      */   
/*      */   public void setDisallowCommission(Boolean argDisallowCommission) {
/*  244 */     if (changed(argDisallowCommission, this._disallowCommission, "disallowCommission")) {
/*  245 */       this._disallowCommission = argDisallowCommission;
/*      */     }
/*      */   }
/*      */   
/*      */   public Boolean getDisallowLayaway() {
/*  250 */     return this._disallowLayaway;
/*      */   }
/*      */   
/*      */   public void setDisallowLayaway(Boolean argDisallowLayaway) {
/*  254 */     if (changed(argDisallowLayaway, this._disallowLayaway, "disallowLayaway")) {
/*  255 */       this._disallowLayaway = argDisallowLayaway;
/*      */     }
/*      */   }
/*      */   
/*      */   public Boolean getDisallowWorkOrder() {
/*  260 */     return this._disallowWorkOrder;
/*      */   }
/*      */   
/*      */   public void setDisallowWorkOrder(Boolean argDisallowWorkOrder) {
/*  264 */     if (changed(argDisallowWorkOrder, this._disallowWorkOrder, "disallowWorkOrder")) {
/*  265 */       this._disallowWorkOrder = argDisallowWorkOrder;
/*      */     }
/*      */   }
/*      */   
/*      */   public Boolean getDisallowSpecialOrder() {
/*  270 */     return this._disallowSpecialOrder;
/*      */   }
/*      */   
/*      */   public void setDisallowSpecialOrder(Boolean argDisallowSpecialOrder) {
/*  274 */     if (changed(argDisallowSpecialOrder, this._disallowSpecialOrder, "disallowSpecialOrder")) {
/*  275 */       this._disallowSpecialOrder = argDisallowSpecialOrder;
/*      */     }
/*      */   }
/*      */   
/*      */   public Boolean getDisallowOrder() {
/*  280 */     return this._disallowOrder;
/*      */   }
/*      */   
/*      */   public void setDisallowOrder(Boolean argDisallowOrder) {
/*  284 */     if (changed(argDisallowOrder, this._disallowOrder, "disallowOrder")) {
/*  285 */       this._disallowOrder = argDisallowOrder;
/*      */     }
/*      */   }
/*      */   
/*      */   public Boolean getDisallowRainCheck() {
/*  290 */     return this._disallowRainCheck;
/*      */   }
/*      */   
/*      */   public void setDisallowRainCheck(Boolean argDisallowRainCheck) {
/*  294 */     if (changed(argDisallowRainCheck, this._disallowRainCheck, "disallowRainCheck")) {
/*  295 */       this._disallowRainCheck = argDisallowRainCheck;
/*      */     }
/*      */   }
/*      */   
/*      */   public Boolean getForceQuantityOfOne() {
/*  300 */     return this._forceQuantityOfOne;
/*      */   }
/*      */   
/*      */   public void setForceQuantityOfOne(Boolean argForceQuantityOfOne) {
/*  304 */     if (changed(argForceQuantityOfOne, this._forceQuantityOfOne, "forceQuantityOfOne")) {
/*  305 */       this._forceQuantityOfOne = argForceQuantityOfOne;
/*      */     }
/*      */   }
/*      */   
/*      */   public BigDecimal getMaximumSaleUnitCount() {
/*  310 */     return this._maximumSaleUnitCount;
/*      */   }
/*      */   
/*      */   public void setMaximumSaleUnitCount(BigDecimal argMaximumSaleUnitCount) {
/*  314 */     if (changed(argMaximumSaleUnitCount, this._maximumSaleUnitCount, "maximumSaleUnitCount")) {
/*  315 */       this._maximumSaleUnitCount = argMaximumSaleUnitCount;
/*      */     }
/*      */   }
/*      */   
/*      */   public BigDecimal getMinimumSaleUnitCount() {
/*  320 */     return this._minimumSaleUnitCount;
/*      */   }
/*      */   
/*      */   public void setMinimumSaleUnitCount(BigDecimal argMinimumSaleUnitCount) {
/*  324 */     if (changed(argMinimumSaleUnitCount, this._minimumSaleUnitCount, "minimumSaleUnitCount")) {
/*  325 */       this._minimumSaleUnitCount = argMinimumSaleUnitCount;
/*      */     }
/*      */   }
/*      */   
/*      */   public Boolean getNoGiveaways() {
/*  330 */     return this._noGiveaways;
/*      */   }
/*      */   
/*      */   public void setNoGiveaways(Boolean argNoGiveaways) {
/*  334 */     if (changed(argNoGiveaways, this._noGiveaways, "noGiveaways")) {
/*  335 */       this._noGiveaways = argNoGiveaways;
/*      */     }
/*      */   }
/*      */   
/*      */   public Boolean getNotReturnable() {
/*  340 */     return this._notReturnable;
/*      */   }
/*      */   
/*      */   public void setNotReturnable(Boolean argNotReturnable) {
/*  344 */     if (changed(argNotReturnable, this._notReturnable, "notReturnable")) {
/*  345 */       this._notReturnable = argNotReturnable;
/*      */     }
/*      */   }
/*      */   
/*      */   public String getPartNumber() {
/*  350 */     return this._partNumber;
/*      */   }
/*      */   
/*      */   public void setPartNumber(String argPartNumber) {
/*  354 */     if (changed(argPartNumber, this._partNumber, "partNumber")) {
/*  355 */       this._partNumber = argPartNumber;
/*      */     }
/*      */   }
/*      */   
/*      */   public Boolean getPromptForPrice() {
/*  360 */     return this._promptForPrice;
/*      */   }
/*      */   
/*      */   public void setPromptForPrice(Boolean argPromptForPrice) {
/*  364 */     if (changed(argPromptForPrice, this._promptForPrice, "promptForPrice")) {
/*  365 */       this._promptForPrice = argPromptForPrice;
/*      */     }
/*      */   }
/*      */   
/*      */   public Boolean getPromptForQuantity() {
/*  370 */     return this._promptForQuantity;
/*      */   }
/*      */   
/*      */   public void setPromptForQuantity(Boolean argPromptForQuantity) {
/*  374 */     if (changed(argPromptForQuantity, this._promptForQuantity, "promptForQuantity")) {
/*  375 */       this._promptForQuantity = argPromptForQuantity;
/*      */     }
/*      */   }
/*      */   
/*      */   public Boolean getPromptForDescription() {
/*  380 */     return this._promptForDescription;
/*      */   }
/*      */   
/*      */   public void setPromptForDescription(Boolean argPromptForDescription) {
/*  384 */     if (changed(argPromptForDescription, this._promptForDescription, "promptForDescription")) {
/*  385 */       this._promptForDescription = argPromptForDescription;
/*      */     }
/*      */   }
/*      */   
/*      */   public String getPromptForCustomer() {
/*  390 */     return this._promptForCustomer;
/*      */   }
/*      */   
/*      */   public void setPromptForCustomer(String argPromptForCustomer) {
/*  394 */     if (changed(argPromptForCustomer, this._promptForCustomer, "promptForCustomer")) {
/*  395 */       this._promptForCustomer = argPromptForCustomer;
/*      */     }
/*      */   }
/*      */   
/*      */   public BigDecimal getRestockingFee() {
/*  400 */     return this._restockingFee;
/*      */   }
/*      */   
/*      */   public void setRestockingFee(BigDecimal argRestockingFee) {
/*  404 */     if (changed(argRestockingFee, this._restockingFee, "restockingFee")) {
/*  405 */       this._restockingFee = argRestockingFee;
/*      */     }
/*      */   }
/*      */   
/*      */   public String getSeasonCode() {
/*  410 */     return this._seasonCode;
/*      */   }
/*      */   
/*      */   public void setSeasonCode(String argSeasonCode) {
/*  414 */     if (changed(argSeasonCode, this._seasonCode, "seasonCode")) {
/*  415 */       this._seasonCode = argSeasonCode;
/*      */     }
/*      */   }
/*      */   
/*      */   public Boolean getSubstituteAvailable() {
/*  420 */     return this._substituteAvailable;
/*      */   }
/*      */   
/*      */   public void setSubstituteAvailable(Boolean argSubstituteAvailable) {
/*  424 */     if (changed(argSubstituteAvailable, this._substituteAvailable, "substituteAvailable")) {
/*  425 */       this._substituteAvailable = argSubstituteAvailable;
/*      */     }
/*      */   }
/*      */   
/*      */   public BigDecimal getUnitCost() {
/*  430 */     return this._unitCost;
/*      */   }
/*      */   
/*      */   public void setUnitCost(BigDecimal argUnitCost) {
/*  434 */     if (changed(argUnitCost, this._unitCost, "unitCost")) {
/*  435 */       this._unitCost = argUnitCost;
/*      */     }
/*      */   }
/*      */   
/*      */   public String getVendorId() {
/*  440 */     return this._vendorId;
/*      */   }
/*      */   
/*      */   public void setVendorId(String argVendorId) {
/*  444 */     if (changed(argVendorId, this._vendorId, "vendorId")) {
/*  445 */       this._vendorId = argVendorId;
/*      */     }
/*      */   }
/*      */   
/*      */   public Integer getSpecialOrderLeadDays() {
/*  450 */     return this._specialOrderLeadDays;
/*      */   }
/*      */   
/*      */   public void setSpecialOrderLeadDays(Integer argSpecialOrderLeadDays) {
/*  454 */     if (changed(argSpecialOrderLeadDays, this._specialOrderLeadDays, "specialOrderLeadDays")) {
/*  455 */       this._specialOrderLeadDays = argSpecialOrderLeadDays;
/*      */     }
/*      */   }
/*      */   
/*      */   public Integer getQtyScale() {
/*  460 */     return this._qtyScale;
/*      */   }
/*      */   
/*      */   public void setQtyScale(Integer argQtyScale) {
/*  464 */     if (changed(argQtyScale, this._qtyScale, "qtyScale")) {
/*  465 */       this._qtyScale = argQtyScale;
/*      */     }
/*      */   }
/*      */   
/*      */   public Boolean getMessages() {
/*  470 */     return this._messages;
/*      */   }
/*      */   
/*      */   public void setMessages(Boolean argMessages) {
/*  474 */     if (changed(argMessages, this._messages, "messages")) {
/*  475 */       this._messages = argMessages;
/*      */     }
/*      */   }
/*      */   
/*      */   public String getUnitOfMeasureCode() {
/*  480 */     return this._unitOfMeasureCode;
/*      */   }
/*      */   
/*      */   public void setUnitOfMeasureCode(String argUnitOfMeasureCode) {
/*  484 */     if (changed(argUnitOfMeasureCode, this._unitOfMeasureCode, "unitOfMeasureCode")) {
/*  485 */       this._unitOfMeasureCode = argUnitOfMeasureCode;
/*      */     }
/*      */   }
/*      */   
/*      */   public String getTaxGroupId() {
/*  490 */     return this._taxGroupId;
/*      */   }
/*      */   
/*      */   public void setTaxGroupId(String argTaxGroupId) {
/*  494 */     if (changed(argTaxGroupId, this._taxGroupId, "taxGroupId")) {
/*  495 */       this._taxGroupId = argTaxGroupId;
/*      */     }
/*      */   }
/*      */   
/*      */   public Boolean getWarranty() {
/*  500 */     return this._warranty;
/*      */   }
/*      */   
/*      */   public void setWarranty(Boolean argWarranty) {
/*  504 */     if (changed(argWarranty, this._warranty, "warranty")) {
/*  505 */       this._warranty = argWarranty;
/*      */     }
/*      */   }
/*      */   
/*      */   public Boolean getGenericItem() {
/*  510 */     return this._genericItem;
/*      */   }
/*      */   
/*      */   public void setGenericItem(Boolean argGenericItem) {
/*  514 */     if (changed(argGenericItem, this._genericItem, "genericItem")) {
/*  515 */       this._genericItem = argGenericItem;
/*      */     }
/*      */   }
/*      */   
/*      */   public BigDecimal getCurrentSalePrice() {
/*  520 */     return this._currentSalePrice;
/*      */   }
/*      */   
/*      */   public void setCurrentSalePrice(BigDecimal argCurrentSalePrice) {
/*  524 */     if (changed(argCurrentSalePrice, this._currentSalePrice, "currentSalePrice")) {
/*  525 */       this._currentSalePrice = argCurrentSalePrice;
/*      */     }
/*      */   }
/*      */   
/*      */   public BigDecimal getInitialSaleQuantity() {
/*  530 */     return this._initialSaleQuantity;
/*      */   }
/*      */   
/*      */   public void setInitialSaleQuantity(BigDecimal argInitialSaleQuantity) {
/*  534 */     if (changed(argInitialSaleQuantity, this._initialSaleQuantity, "initialSaleQuantity")) {
/*  535 */       this._initialSaleQuantity = argInitialSaleQuantity;
/*      */     }
/*      */   }
/*      */   
/*      */   public String getDispositionCode() {
/*  540 */     return this._dispositionCode;
/*      */   }
/*      */   
/*      */   public void setDispositionCode(String argDispositionCode) {
/*  544 */     if (changed(argDispositionCode, this._dispositionCode, "dispositionCode")) {
/*  545 */       this._dispositionCode = argDispositionCode;
/*      */     }
/*      */   }
/*      */   
/*      */   public String getItemAvailabilityCode() {
/*  550 */     return this._itemAvailabilityCode;
/*      */   }
/*      */   
/*      */   public void setItemAvailabilityCode(String argItemAvailabilityCode) {
/*  554 */     if (changed(argItemAvailabilityCode, this._itemAvailabilityCode, "itemAvailabilityCode")) {
/*  555 */       this._itemAvailabilityCode = argItemAvailabilityCode;
/*      */     }
/*      */   }
/*      */   
/*      */   public Integer getMinAgeRequired() {
/*  560 */     return this._minAgeRequired;
/*      */   }
/*      */   
/*      */   public void setMinAgeRequired(Integer argMinAgeRequired) {
/*  564 */     if (changed(argMinAgeRequired, this._minAgeRequired, "minAgeRequired")) {
/*  565 */       this._minAgeRequired = argMinAgeRequired;
/*      */     }
/*      */   }
/*      */   
/*      */   public String getStockStatus() {
/*  570 */     return this._stockStatus;
/*      */   }
/*      */   
/*      */   public void setStockStatus(String argStockStatus) {
/*  574 */     if (changed(argStockStatus, this._stockStatus, "stockStatus")) {
/*  575 */       this._stockStatus = argStockStatus;
/*      */     }
/*      */   }
/*      */   
/*      */   public Boolean getFoodStampEligible() {
/*  580 */     return this._foodStampEligible;
/*      */   }
/*      */   
/*      */   public void setFoodStampEligible(Boolean argFoodStampEligible) {
/*  584 */     if (changed(argFoodStampEligible, this._foodStampEligible, "foodStampEligible")) {
/*  585 */       this._foodStampEligible = argFoodStampEligible;
/*      */     }
/*      */   }
/*      */   
/*      */   public BigDecimal getShippingWeight() {
/*  590 */     return this._shippingWeight;
/*      */   }
/*      */   
/*      */   public void setShippingWeight(BigDecimal argShippingWeight) {
/*  594 */     if (changed(argShippingWeight, this._shippingWeight, "shippingWeight")) {
/*  595 */       this._shippingWeight = argShippingWeight;
/*      */     }
/*      */   }
/*      */   
/*      */   public BigDecimal getPackSize() {
/*  600 */     return this._packSize;
/*      */   }
/*      */   
/*      */   public void setPackSize(BigDecimal argPackSize) {
/*  604 */     if (changed(argPackSize, this._packSize, "packSize")) {
/*  605 */       this._packSize = argPackSize;
/*      */     }
/*      */   }
/*      */   
/*      */   public String getDefaultSourceType() {
/*  610 */     return this._defaultSourceType;
/*      */   }
/*      */   
/*      */   public void setDefaultSourceType(String argDefaultSourceType) {
/*  614 */     if (changed(argDefaultSourceType, this._defaultSourceType, "defaultSourceType")) {
/*  615 */       this._defaultSourceType = argDefaultSourceType;
/*      */     }
/*      */   }
/*      */   
/*      */   public String getDefaultSourceId() {
/*  620 */     return this._defaultSourceId;
/*      */   }
/*      */   
/*      */   public void setDefaultSourceId(String argDefaultSourceId) {
/*  624 */     if (changed(argDefaultSourceId, this._defaultSourceId, "defaultSourceId")) {
/*  625 */       this._defaultSourceId = argDefaultSourceId;
/*      */     }
/*      */   }
/*      */   
/*      */   public String getSellingGroupId() {
/*  630 */     return this._sellingGroupId;
/*      */   }
/*      */   
/*      */   public void setSellingGroupId(String argSellingGroupId) {
/*  634 */     if (changed(argSellingGroupId, this._sellingGroupId, "sellingGroupId")) {
/*  635 */       this._sellingGroupId = argSellingGroupId;
/*      */     }
/*      */   }
/*      */   
/*      */   public Boolean getExcludeFromNetSales() {
/*  640 */     return this._excludeFromNetSales;
/*      */   }
/*      */   
/*      */   public void setExcludeFromNetSales(Boolean argExcludeFromNetSales) {
/*  644 */     if (changed(argExcludeFromNetSales, this._excludeFromNetSales, "excludeFromNetSales")) {
/*  645 */       this._excludeFromNetSales = argExcludeFromNetSales;
/*      */     }
/*      */   }
/*      */   
/*      */   public String getFiscalItemId() {
/*  650 */     return this._fiscalItemId;
/*      */   }
/*      */   
/*      */   public void setFiscalItemId(String argFiscalItemId) {
/*  654 */     if (changed(argFiscalItemId, this._fiscalItemId, "fiscalItemId")) {
/*  655 */       this._fiscalItemId = argFiscalItemId;
/*      */     }
/*      */   }
/*      */   
/*      */   public String getFiscalItemDescription() {
/*  660 */     return this._fiscalItemDescription;
/*      */   }
/*      */   
/*      */   public void setFiscalItemDescription(String argFiscalItemDescription) {
/*  664 */     if (changed(argFiscalItemDescription, this._fiscalItemDescription, "fiscalItemDescription")) {
/*  665 */       this._fiscalItemDescription = argFiscalItemDescription;
/*      */     }
/*      */   }
/*      */   
/*      */   public String getExternalSystem() {
/*  670 */     return this._externalSystem;
/*      */   }
/*      */   
/*      */   public void setExternalSystem(String argExternalSystem) {
/*  674 */     if (changed(argExternalSystem, this._externalSystem, "externalSystem")) {
/*  675 */       this._externalSystem = argExternalSystem;
/*      */     }
/*      */   }
/*      */   
/*      */   public BigDecimal getTareValue() {
/*  680 */     return this._tareValue;
/*      */   }
/*      */   
/*      */   public void setTareValue(BigDecimal argTareValue) {
/*  684 */     if (changed(argTareValue, this._tareValue, "tareValue")) {
/*  685 */       this._tareValue = argTareValue;
/*      */     }
/*      */   }
/*      */   
/*      */   public String getTareUnitOfMeasureCode() {
/*  690 */     return this._tareUnitOfMeasureCode;
/*      */   }
/*      */   
/*      */   public void setTareUnitOfMeasureCode(String argTareUnitOfMeasureCode) {
/*  694 */     if (changed(argTareUnitOfMeasureCode, this._tareUnitOfMeasureCode, "tareUnitOfMeasureCode")) {
/*  695 */       this._tareUnitOfMeasureCode = argTareUnitOfMeasureCode;
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public String toString() {
/*  702 */     StringBuilder buf = new StringBuilder(512);
/*  703 */     buf.append(super.toString()).append(" Id: ").append(getObjectId()).append(" Values: ");
/*  704 */     if (getOrganizationId() != null) {
/*  705 */       buf.append("organizationId").append("=").append(getOrganizationId()).append(" ");
/*      */     }
/*  707 */     if (getItemId() != null) {
/*  708 */       buf.append("itemId").append("=").append(getItemId()).append(" ");
/*      */     }
/*  710 */     if (getLevelCode() != null) {
/*  711 */       buf.append("levelCode").append("=").append(getLevelCode()).append(" ");
/*      */     }
/*  713 */     if (getLevelValue() != null) {
/*  714 */       buf.append("levelValue").append("=").append(getLevelValue()).append(" ");
/*      */     }
/*  716 */     if (getCreateDate() != null) {
/*  717 */       buf.append("createDate").append("=").append(getCreateDate()).append(" ");
/*      */     }
/*  719 */     if (getCreateUserId() != null) {
/*  720 */       buf.append("createUserId").append("=").append(getCreateUserId()).append(" ");
/*      */     }
/*  722 */     if (getUpdateDate() != null) {
/*  723 */       buf.append("updateDate").append("=").append(getUpdateDate()).append(" ");
/*      */     }
/*  725 */     if (getUpdateUserId() != null) {
/*  726 */       buf.append("updateUserId").append("=").append(getUpdateUserId()).append(" ");
/*      */     }
/*  728 */     if (getApplyRestockingFee() != null && getApplyRestockingFee().booleanValue()) {
/*  729 */       buf.append("applyRestockingFee").append("=").append(getApplyRestockingFee()).append(" ");
/*      */     }
/*  731 */     if (getAttachedItems() != null && getAttachedItems().booleanValue()) {
/*  732 */       buf.append("attachedItems").append("=").append(getAttachedItems()).append(" ");
/*      */     }
/*  734 */     if (getCompareAtPrice() != null) {
/*  735 */       buf.append("compareAtPrice").append("=").append(getCompareAtPrice()).append(" ");
/*      */     }
/*  737 */     if (getDisallowDiscounts() != null && getDisallowDiscounts().booleanValue()) {
/*  738 */       buf.append("disallowDiscounts").append("=").append(getDisallowDiscounts()).append(" ");
/*      */     }
/*  740 */     if (getDisallowDeals() != null && getDisallowDeals().booleanValue()) {
/*  741 */       buf.append("disallowDeals").append("=").append(getDisallowDeals()).append(" ");
/*      */     }
/*  743 */     if (getDisallowPriceChange() != null && getDisallowPriceChange().booleanValue()) {
/*  744 */       buf.append("disallowPriceChange").append("=").append(getDisallowPriceChange()).append(" ");
/*      */     }
/*  746 */     if (getDisallowSendSale() != null && getDisallowSendSale().booleanValue()) {
/*  747 */       buf.append("disallowSendSale").append("=").append(getDisallowSendSale()).append(" ");
/*      */     }
/*  749 */     if (getDisallowCommission() != null && getDisallowCommission().booleanValue()) {
/*  750 */       buf.append("disallowCommission").append("=").append(getDisallowCommission()).append(" ");
/*      */     }
/*  752 */     if (getDisallowLayaway() != null && getDisallowLayaway().booleanValue()) {
/*  753 */       buf.append("disallowLayaway").append("=").append(getDisallowLayaway()).append(" ");
/*      */     }
/*  755 */     if (getDisallowWorkOrder() != null && getDisallowWorkOrder().booleanValue()) {
/*  756 */       buf.append("disallowWorkOrder").append("=").append(getDisallowWorkOrder()).append(" ");
/*      */     }
/*  758 */     if (getDisallowSpecialOrder() != null && getDisallowSpecialOrder().booleanValue()) {
/*  759 */       buf.append("disallowSpecialOrder").append("=").append(getDisallowSpecialOrder()).append(" ");
/*      */     }
/*  761 */     if (getDisallowOrder() != null && getDisallowOrder().booleanValue()) {
/*  762 */       buf.append("disallowOrder").append("=").append(getDisallowOrder()).append(" ");
/*      */     }
/*  764 */     if (getDisallowRainCheck() != null && getDisallowRainCheck().booleanValue()) {
/*  765 */       buf.append("disallowRainCheck").append("=").append(getDisallowRainCheck()).append(" ");
/*      */     }
/*  767 */     if (getForceQuantityOfOne() != null && getForceQuantityOfOne().booleanValue()) {
/*  768 */       buf.append("forceQuantityOfOne").append("=").append(getForceQuantityOfOne()).append(" ");
/*      */     }
/*  770 */     if (getMaximumSaleUnitCount() != null) {
/*  771 */       buf.append("maximumSaleUnitCount").append("=").append(getMaximumSaleUnitCount()).append(" ");
/*      */     }
/*  773 */     if (getMinimumSaleUnitCount() != null) {
/*  774 */       buf.append("minimumSaleUnitCount").append("=").append(getMinimumSaleUnitCount()).append(" ");
/*      */     }
/*  776 */     if (getNoGiveaways() != null && getNoGiveaways().booleanValue()) {
/*  777 */       buf.append("noGiveaways").append("=").append(getNoGiveaways()).append(" ");
/*      */     }
/*  779 */     if (getNotReturnable() != null && getNotReturnable().booleanValue()) {
/*  780 */       buf.append("notReturnable").append("=").append(getNotReturnable()).append(" ");
/*      */     }
/*  782 */     if (getPartNumber() != null) {
/*  783 */       buf.append("partNumber").append("=").append(getPartNumber()).append(" ");
/*      */     }
/*  785 */     if (getPromptForPrice() != null && getPromptForPrice().booleanValue()) {
/*  786 */       buf.append("promptForPrice").append("=").append(getPromptForPrice()).append(" ");
/*      */     }
/*  788 */     if (getPromptForQuantity() != null && getPromptForQuantity().booleanValue()) {
/*  789 */       buf.append("promptForQuantity").append("=").append(getPromptForQuantity()).append(" ");
/*      */     }
/*  791 */     if (getPromptForDescription() != null && getPromptForDescription().booleanValue()) {
/*  792 */       buf.append("promptForDescription").append("=").append(getPromptForDescription()).append(" ");
/*      */     }
/*  794 */     if (getPromptForCustomer() != null) {
/*  795 */       buf.append("promptForCustomer").append("=").append(getPromptForCustomer()).append(" ");
/*      */     }
/*  797 */     if (getRestockingFee() != null) {
/*  798 */       buf.append("restockingFee").append("=").append(getRestockingFee()).append(" ");
/*      */     }
/*  800 */     if (getSeasonCode() != null) {
/*  801 */       buf.append("seasonCode").append("=").append(getSeasonCode()).append(" ");
/*      */     }
/*  803 */     if (getSubstituteAvailable() != null && getSubstituteAvailable().booleanValue()) {
/*  804 */       buf.append("substituteAvailable").append("=").append(getSubstituteAvailable()).append(" ");
/*      */     }
/*  806 */     if (getUnitCost() != null) {
/*  807 */       buf.append("unitCost").append("=").append(getUnitCost()).append(" ");
/*      */     }
/*  809 */     if (getVendorId() != null) {
/*  810 */       buf.append("vendorId").append("=").append(getVendorId()).append(" ");
/*      */     }
/*  812 */     if (getSpecialOrderLeadDays() != null) {
/*  813 */       buf.append("specialOrderLeadDays").append("=").append(getSpecialOrderLeadDays()).append(" ");
/*      */     }
/*  815 */     if (getQtyScale() != null) {
/*  816 */       buf.append("qtyScale").append("=").append(getQtyScale()).append(" ");
/*      */     }
/*  818 */     if (getMessages() != null && getMessages().booleanValue()) {
/*  819 */       buf.append("messages").append("=").append(getMessages()).append(" ");
/*      */     }
/*  821 */     if (getUnitOfMeasureCode() != null) {
/*  822 */       buf.append("unitOfMeasureCode").append("=").append(getUnitOfMeasureCode()).append(" ");
/*      */     }
/*  824 */     if (getTaxGroupId() != null) {
/*  825 */       buf.append("taxGroupId").append("=").append(getTaxGroupId()).append(" ");
/*      */     }
/*  827 */     if (getWarranty() != null && getWarranty().booleanValue()) {
/*  828 */       buf.append("warranty").append("=").append(getWarranty()).append(" ");
/*      */     }
/*  830 */     if (getGenericItem() != null && getGenericItem().booleanValue()) {
/*  831 */       buf.append("genericItem").append("=").append(getGenericItem()).append(" ");
/*      */     }
/*  833 */     if (getCurrentSalePrice() != null) {
/*  834 */       buf.append("currentSalePrice").append("=").append(getCurrentSalePrice()).append(" ");
/*      */     }
/*  836 */     if (getInitialSaleQuantity() != null) {
/*  837 */       buf.append("initialSaleQuantity").append("=").append(getInitialSaleQuantity()).append(" ");
/*      */     }
/*  839 */     if (getDispositionCode() != null) {
/*  840 */       buf.append("dispositionCode").append("=").append(getDispositionCode()).append(" ");
/*      */     }
/*  842 */     if (getItemAvailabilityCode() != null) {
/*  843 */       buf.append("itemAvailabilityCode").append("=").append(getItemAvailabilityCode()).append(" ");
/*      */     }
/*  845 */     if (getMinAgeRequired() != null) {
/*  846 */       buf.append("minAgeRequired").append("=").append(getMinAgeRequired()).append(" ");
/*      */     }
/*  848 */     if (getStockStatus() != null) {
/*  849 */       buf.append("stockStatus").append("=").append(getStockStatus()).append(" ");
/*      */     }
/*  851 */     if (getFoodStampEligible() != null && getFoodStampEligible().booleanValue()) {
/*  852 */       buf.append("foodStampEligible").append("=").append(getFoodStampEligible()).append(" ");
/*      */     }
/*  854 */     if (getShippingWeight() != null) {
/*  855 */       buf.append("shippingWeight").append("=").append(getShippingWeight()).append(" ");
/*      */     }
/*  857 */     if (getPackSize() != null) {
/*  858 */       buf.append("packSize").append("=").append(getPackSize()).append(" ");
/*      */     }
/*  860 */     if (getDefaultSourceType() != null) {
/*  861 */       buf.append("defaultSourceType").append("=").append(getDefaultSourceType()).append(" ");
/*      */     }
/*  863 */     if (getDefaultSourceId() != null) {
/*  864 */       buf.append("defaultSourceId").append("=").append(getDefaultSourceId()).append(" ");
/*      */     }
/*  866 */     if (getSellingGroupId() != null) {
/*  867 */       buf.append("sellingGroupId").append("=").append(getSellingGroupId()).append(" ");
/*      */     }
/*  869 */     if (getExcludeFromNetSales() != null && getExcludeFromNetSales().booleanValue()) {
/*  870 */       buf.append("excludeFromNetSales").append("=").append(getExcludeFromNetSales()).append(" ");
/*      */     }
/*  872 */     if (getFiscalItemId() != null) {
/*  873 */       buf.append("fiscalItemId").append("=").append(getFiscalItemId()).append(" ");
/*      */     }
/*  875 */     if (getFiscalItemDescription() != null) {
/*  876 */       buf.append("fiscalItemDescription").append("=").append(getFiscalItemDescription()).append(" ");
/*      */     }
/*  878 */     if (getExternalSystem() != null) {
/*  879 */       buf.append("externalSystem").append("=").append(getExternalSystem()).append(" ");
/*      */     }
/*  881 */     if (getTareValue() != null) {
/*  882 */       buf.append("tareValue").append("=").append(getTareValue()).append(" ");
/*      */     }
/*  884 */     if (getTareUnitOfMeasureCode() != null) {
/*  885 */       buf.append("tareUnitOfMeasureCode").append("=").append(getTareUnitOfMeasureCode()).append(" ");
/*      */     }
/*      */     
/*  888 */     return buf.toString();
/*      */   }
/*      */   
/*      */   public IObjectId getObjectId() {
/*  892 */     ItemOptionsId id = new ItemOptionsId();
/*  893 */     id.setOrganizationId(getOrganizationId());
/*  894 */     id.setItemId(getItemId());
/*  895 */     id.setLevelCode(getLevelCode());
/*  896 */     id.setLevelValue(getLevelValue());
/*  897 */     return (IObjectId)id;
/*      */   }
/*      */   
/*      */   public void setObjectId(IObjectId argObjectId) {
/*  901 */     setOrganizationId(((ItemOptionsId)argObjectId).getOrganizationId());
/*  902 */     setItemId(((ItemOptionsId)argObjectId).getItemId());
/*  903 */     setLevelCode(((ItemOptionsId)argObjectId).getLevelCode());
/*  904 */     setLevelValue(((ItemOptionsId)argObjectId).getLevelValue());
/*      */   }
/*      */   
/*      */   public String getImplementingClass() {
/*  908 */     return null;
/*      */   }
/*      */   
/*      */   public String toXmlString() {
/*  912 */     StringBuilder buf = new StringBuilder(3050);
/*  913 */     buf.append("<").append("dao").append(" name=\"ItemOptions\" cmd=\"" + getObjectStateString() + "\">");
/*  914 */     getFieldsAsXml(buf);
/*  915 */     buf.append("</").append("dao").append(">");
/*      */     
/*  917 */     return buf.toString();
/*      */   }
/*      */   
/*      */   public Map<String, String> getValues() {
/*  921 */     Map<String, String> values = super.getValues();
/*  922 */     if (this._organizationId != null) values.put("OrganizationId", DaoUtils.getXmlSafeFieldValue(-5, this._organizationId)); 
/*  923 */     if (this._itemId != null) values.put("ItemId", DaoUtils.getXmlSafeFieldValue(12, this._itemId)); 
/*  924 */     if (this._levelCode != null) values.put("LevelCode", DaoUtils.getXmlSafeFieldValue(12, this._levelCode)); 
/*  925 */     if (this._levelValue != null) values.put("LevelValue", DaoUtils.getXmlSafeFieldValue(12, this._levelValue)); 
/*  926 */     if (this._createDate != null) values.put("CreateDate", DaoUtils.getXmlSafeFieldValue(91, this._createDate)); 
/*  927 */     if (this._createUserId != null) values.put("CreateUserId", DaoUtils.getXmlSafeFieldValue(12, this._createUserId)); 
/*  928 */     if (this._updateDate != null) values.put("UpdateDate", DaoUtils.getXmlSafeFieldValue(91, this._updateDate)); 
/*  929 */     if (this._updateUserId != null) values.put("UpdateUserId", DaoUtils.getXmlSafeFieldValue(12, this._updateUserId)); 
/*  930 */     if (this._applyRestockingFee != null) values.put("ApplyRestockingFee", DaoUtils.getXmlSafeFieldValue(-7, this._applyRestockingFee)); 
/*  931 */     if (this._attachedItems != null) values.put("AttachedItems", DaoUtils.getXmlSafeFieldValue(-7, this._attachedItems)); 
/*  932 */     if (this._compareAtPrice != null) values.put("CompareAtPrice", DaoUtils.getXmlSafeFieldValue(3, this._compareAtPrice)); 
/*  933 */     if (this._disallowDiscounts != null) values.put("DisallowDiscounts", DaoUtils.getXmlSafeFieldValue(-7, this._disallowDiscounts)); 
/*  934 */     if (this._disallowDeals != null) values.put("DisallowDeals", DaoUtils.getXmlSafeFieldValue(-7, this._disallowDeals)); 
/*  935 */     if (this._disallowPriceChange != null) values.put("DisallowPriceChange", DaoUtils.getXmlSafeFieldValue(-7, this._disallowPriceChange)); 
/*  936 */     if (this._disallowSendSale != null) values.put("DisallowSendSale", DaoUtils.getXmlSafeFieldValue(-7, this._disallowSendSale)); 
/*  937 */     if (this._disallowCommission != null) values.put("DisallowCommission", DaoUtils.getXmlSafeFieldValue(-7, this._disallowCommission)); 
/*  938 */     if (this._disallowLayaway != null) values.put("DisallowLayaway", DaoUtils.getXmlSafeFieldValue(-7, this._disallowLayaway)); 
/*  939 */     if (this._disallowWorkOrder != null) values.put("DisallowWorkOrder", DaoUtils.getXmlSafeFieldValue(-7, this._disallowWorkOrder)); 
/*  940 */     if (this._disallowSpecialOrder != null) values.put("DisallowSpecialOrder", DaoUtils.getXmlSafeFieldValue(-7, this._disallowSpecialOrder)); 
/*  941 */     if (this._disallowOrder != null) values.put("DisallowOrder", DaoUtils.getXmlSafeFieldValue(-7, this._disallowOrder)); 
/*  942 */     if (this._disallowRainCheck != null) values.put("DisallowRainCheck", DaoUtils.getXmlSafeFieldValue(-7, this._disallowRainCheck)); 
/*  943 */     if (this._forceQuantityOfOne != null) values.put("ForceQuantityOfOne", DaoUtils.getXmlSafeFieldValue(-7, this._forceQuantityOfOne)); 
/*  944 */     if (this._maximumSaleUnitCount != null) values.put("MaximumSaleUnitCount", DaoUtils.getXmlSafeFieldValue(3, this._maximumSaleUnitCount)); 
/*  945 */     if (this._minimumSaleUnitCount != null) values.put("MinimumSaleUnitCount", DaoUtils.getXmlSafeFieldValue(3, this._minimumSaleUnitCount)); 
/*  946 */     if (this._noGiveaways != null) values.put("NoGiveaways", DaoUtils.getXmlSafeFieldValue(-7, this._noGiveaways)); 
/*  947 */     if (this._notReturnable != null) values.put("NotReturnable", DaoUtils.getXmlSafeFieldValue(-7, this._notReturnable)); 
/*  948 */     if (this._partNumber != null) values.put("PartNumber", DaoUtils.getXmlSafeFieldValue(12, this._partNumber)); 
/*  949 */     if (this._promptForPrice != null) values.put("PromptForPrice", DaoUtils.getXmlSafeFieldValue(-7, this._promptForPrice)); 
/*  950 */     if (this._promptForQuantity != null) values.put("PromptForQuantity", DaoUtils.getXmlSafeFieldValue(-7, this._promptForQuantity)); 
/*  951 */     if (this._promptForDescription != null) values.put("PromptForDescription", DaoUtils.getXmlSafeFieldValue(-7, this._promptForDescription)); 
/*  952 */     if (this._promptForCustomer != null) values.put("PromptForCustomer", DaoUtils.getXmlSafeFieldValue(12, this._promptForCustomer)); 
/*  953 */     if (this._restockingFee != null) values.put("RestockingFee", DaoUtils.getXmlSafeFieldValue(3, this._restockingFee)); 
/*  954 */     if (this._seasonCode != null) values.put("SeasonCode", DaoUtils.getXmlSafeFieldValue(12, this._seasonCode)); 
/*  955 */     if (this._substituteAvailable != null) values.put("SubstituteAvailable", DaoUtils.getXmlSafeFieldValue(-7, this._substituteAvailable)); 
/*  956 */     if (this._unitCost != null) values.put("UnitCost", DaoUtils.getXmlSafeFieldValue(3, this._unitCost)); 
/*  957 */     if (this._vendorId != null) values.put("VendorId", DaoUtils.getXmlSafeFieldValue(12, this._vendorId)); 
/*  958 */     if (this._specialOrderLeadDays != null) values.put("SpecialOrderLeadDays", DaoUtils.getXmlSafeFieldValue(4, this._specialOrderLeadDays)); 
/*  959 */     if (this._qtyScale != null) values.put("QtyScale", DaoUtils.getXmlSafeFieldValue(4, this._qtyScale)); 
/*  960 */     if (this._messages != null) values.put("Messages", DaoUtils.getXmlSafeFieldValue(-7, this._messages)); 
/*  961 */     if (this._unitOfMeasureCode != null) values.put("UnitOfMeasureCode", DaoUtils.getXmlSafeFieldValue(12, this._unitOfMeasureCode)); 
/*  962 */     if (this._taxGroupId != null) values.put("TaxGroupId", DaoUtils.getXmlSafeFieldValue(12, this._taxGroupId)); 
/*  963 */     if (this._warranty != null) values.put("Warranty", DaoUtils.getXmlSafeFieldValue(-7, this._warranty)); 
/*  964 */     if (this._genericItem != null) values.put("GenericItem", DaoUtils.getXmlSafeFieldValue(-7, this._genericItem)); 
/*  965 */     if (this._currentSalePrice != null) values.put("CurrentSalePrice", DaoUtils.getXmlSafeFieldValue(3, this._currentSalePrice)); 
/*  966 */     if (this._initialSaleQuantity != null) values.put("InitialSaleQuantity", DaoUtils.getXmlSafeFieldValue(3, this._initialSaleQuantity)); 
/*  967 */     if (this._dispositionCode != null) values.put("DispositionCode", DaoUtils.getXmlSafeFieldValue(12, this._dispositionCode)); 
/*  968 */     if (this._itemAvailabilityCode != null) values.put("ItemAvailabilityCode", DaoUtils.getXmlSafeFieldValue(12, this._itemAvailabilityCode)); 
/*  969 */     if (this._minAgeRequired != null) values.put("MinAgeRequired", DaoUtils.getXmlSafeFieldValue(4, this._minAgeRequired)); 
/*  970 */     if (this._stockStatus != null) values.put("StockStatus", DaoUtils.getXmlSafeFieldValue(12, this._stockStatus)); 
/*  971 */     if (this._foodStampEligible != null) values.put("FoodStampEligible", DaoUtils.getXmlSafeFieldValue(-7, this._foodStampEligible)); 
/*  972 */     if (this._shippingWeight != null) values.put("ShippingWeight", DaoUtils.getXmlSafeFieldValue(3, this._shippingWeight)); 
/*  973 */     if (this._packSize != null) values.put("PackSize", DaoUtils.getXmlSafeFieldValue(3, this._packSize)); 
/*  974 */     if (this._defaultSourceType != null) values.put("DefaultSourceType", DaoUtils.getXmlSafeFieldValue(12, this._defaultSourceType)); 
/*  975 */     if (this._defaultSourceId != null) values.put("DefaultSourceId", DaoUtils.getXmlSafeFieldValue(12, this._defaultSourceId)); 
/*  976 */     if (this._sellingGroupId != null) values.put("SellingGroupId", DaoUtils.getXmlSafeFieldValue(12, this._sellingGroupId)); 
/*  977 */     if (this._excludeFromNetSales != null) values.put("ExcludeFromNetSales", DaoUtils.getXmlSafeFieldValue(-7, this._excludeFromNetSales)); 
/*  978 */     if (this._fiscalItemId != null) values.put("FiscalItemId", DaoUtils.getXmlSafeFieldValue(12, this._fiscalItemId)); 
/*  979 */     if (this._fiscalItemDescription != null) values.put("FiscalItemDescription", DaoUtils.getXmlSafeFieldValue(12, this._fiscalItemDescription)); 
/*  980 */     if (this._externalSystem != null) values.put("ExternalSystem", DaoUtils.getXmlSafeFieldValue(12, this._externalSystem)); 
/*  981 */     if (this._tareValue != null) values.put("TareValue", DaoUtils.getXmlSafeFieldValue(3, this._tareValue)); 
/*  982 */     if (this._tareUnitOfMeasureCode != null) values.put("TareUnitOfMeasureCode", DaoUtils.getXmlSafeFieldValue(12, this._tareUnitOfMeasureCode)); 
/*  983 */     return values;
/*      */   }
/*      */ 
/*      */   
/*      */   public void setValues(Map<String, String> argValues) {
/*  988 */     super.setValues(argValues);
/*  989 */     for (Map.Entry<String, String> field : argValues.entrySet()) {
/*      */       
/*  991 */       String fieldName = field.getKey();
/*  992 */       String fieldValue = field.getValue();
/*  993 */       switch (fieldName) {
/*      */         
/*      */         case "OrganizationId":
/*      */           try {
/*  997 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/*  998 */             setOrganizationId((Long)value);
/*  999 */           } catch (Exception ee) {
/* 1000 */             throw new DtxException("An exception occurred while calling setOrganizationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*      */           } 
/*      */ 
/*      */         
/*      */         case "ItemId":
/*      */           try {
/* 1006 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 1007 */             setItemId((String)value);
/* 1008 */           } catch (Exception ee) {
/* 1009 */             throw new DtxException("An exception occurred while calling setItemId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*      */           } 
/*      */ 
/*      */         
/*      */         case "LevelCode":
/*      */           try {
/* 1015 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 1016 */             setLevelCode((String)value);
/* 1017 */           } catch (Exception ee) {
/* 1018 */             throw new DtxException("An exception occurred while calling setLevelCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*      */           } 
/*      */ 
/*      */         
/*      */         case "LevelValue":
/*      */           try {
/* 1024 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 1025 */             setLevelValue((String)value);
/* 1026 */           } catch (Exception ee) {
/* 1027 */             throw new DtxException("An exception occurred while calling setLevelValue() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*      */           } 
/*      */ 
/*      */         
/*      */         case "CreateDate":
/*      */           try {
/* 1033 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 1034 */             setCreateDate((Date)value);
/* 1035 */           } catch (Exception ee) {
/* 1036 */             throw new DtxException("An exception occurred while calling setCreateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*      */           } 
/*      */ 
/*      */         
/*      */         case "CreateUserId":
/*      */           try {
/* 1042 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 1043 */             setCreateUserId((String)value);
/* 1044 */           } catch (Exception ee) {
/* 1045 */             throw new DtxException("An exception occurred while calling setCreateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*      */           } 
/*      */ 
/*      */         
/*      */         case "UpdateDate":
/*      */           try {
/* 1051 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 1052 */             setUpdateDate((Date)value);
/* 1053 */           } catch (Exception ee) {
/* 1054 */             throw new DtxException("An exception occurred while calling setUpdateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*      */           } 
/*      */ 
/*      */         
/*      */         case "UpdateUserId":
/*      */           try {
/* 1060 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 1061 */             setUpdateUserId((String)value);
/* 1062 */           } catch (Exception ee) {
/* 1063 */             throw new DtxException("An exception occurred while calling setUpdateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*      */           } 
/*      */ 
/*      */         
/*      */         case "ApplyRestockingFee":
/*      */           try {
/* 1069 */             Object value = DaoUtils.getFieldValueForXmlString(-7, fieldValue);
/* 1070 */             setApplyRestockingFee((Boolean)value);
/* 1071 */           } catch (Exception ee) {
/* 1072 */             throw new DtxException("An exception occurred while calling setApplyRestockingFee() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*      */           } 
/*      */ 
/*      */         
/*      */         case "AttachedItems":
/*      */           try {
/* 1078 */             Object value = DaoUtils.getFieldValueForXmlString(-7, fieldValue);
/* 1079 */             setAttachedItems((Boolean)value);
/* 1080 */           } catch (Exception ee) {
/* 1081 */             throw new DtxException("An exception occurred while calling setAttachedItems() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*      */           } 
/*      */ 
/*      */         
/*      */         case "CompareAtPrice":
/*      */           try {
/* 1087 */             Object value = DaoUtils.getFieldValueForXmlString(3, fieldValue);
/* 1088 */             setCompareAtPrice((BigDecimal)value);
/* 1089 */           } catch (Exception ee) {
/* 1090 */             throw new DtxException("An exception occurred while calling setCompareAtPrice() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*      */           } 
/*      */ 
/*      */         
/*      */         case "DisallowDiscounts":
/*      */           try {
/* 1096 */             Object value = DaoUtils.getFieldValueForXmlString(-7, fieldValue);
/* 1097 */             setDisallowDiscounts((Boolean)value);
/* 1098 */           } catch (Exception ee) {
/* 1099 */             throw new DtxException("An exception occurred while calling setDisallowDiscounts() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*      */           } 
/*      */ 
/*      */         
/*      */         case "DisallowDeals":
/*      */           try {
/* 1105 */             Object value = DaoUtils.getFieldValueForXmlString(-7, fieldValue);
/* 1106 */             setDisallowDeals((Boolean)value);
/* 1107 */           } catch (Exception ee) {
/* 1108 */             throw new DtxException("An exception occurred while calling setDisallowDeals() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*      */           } 
/*      */ 
/*      */         
/*      */         case "DisallowPriceChange":
/*      */           try {
/* 1114 */             Object value = DaoUtils.getFieldValueForXmlString(-7, fieldValue);
/* 1115 */             setDisallowPriceChange((Boolean)value);
/* 1116 */           } catch (Exception ee) {
/* 1117 */             throw new DtxException("An exception occurred while calling setDisallowPriceChange() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*      */           } 
/*      */ 
/*      */         
/*      */         case "DisallowSendSale":
/*      */           try {
/* 1123 */             Object value = DaoUtils.getFieldValueForXmlString(-7, fieldValue);
/* 1124 */             setDisallowSendSale((Boolean)value);
/* 1125 */           } catch (Exception ee) {
/* 1126 */             throw new DtxException("An exception occurred while calling setDisallowSendSale() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*      */           } 
/*      */ 
/*      */         
/*      */         case "DisallowCommission":
/*      */           try {
/* 1132 */             Object value = DaoUtils.getFieldValueForXmlString(-7, fieldValue);
/* 1133 */             setDisallowCommission((Boolean)value);
/* 1134 */           } catch (Exception ee) {
/* 1135 */             throw new DtxException("An exception occurred while calling setDisallowCommission() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*      */           } 
/*      */ 
/*      */         
/*      */         case "DisallowLayaway":
/*      */           try {
/* 1141 */             Object value = DaoUtils.getFieldValueForXmlString(-7, fieldValue);
/* 1142 */             setDisallowLayaway((Boolean)value);
/* 1143 */           } catch (Exception ee) {
/* 1144 */             throw new DtxException("An exception occurred while calling setDisallowLayaway() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*      */           } 
/*      */ 
/*      */         
/*      */         case "DisallowWorkOrder":
/*      */           try {
/* 1150 */             Object value = DaoUtils.getFieldValueForXmlString(-7, fieldValue);
/* 1151 */             setDisallowWorkOrder((Boolean)value);
/* 1152 */           } catch (Exception ee) {
/* 1153 */             throw new DtxException("An exception occurred while calling setDisallowWorkOrder() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*      */           } 
/*      */ 
/*      */         
/*      */         case "DisallowSpecialOrder":
/*      */           try {
/* 1159 */             Object value = DaoUtils.getFieldValueForXmlString(-7, fieldValue);
/* 1160 */             setDisallowSpecialOrder((Boolean)value);
/* 1161 */           } catch (Exception ee) {
/* 1162 */             throw new DtxException("An exception occurred while calling setDisallowSpecialOrder() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*      */           } 
/*      */ 
/*      */         
/*      */         case "DisallowOrder":
/*      */           try {
/* 1168 */             Object value = DaoUtils.getFieldValueForXmlString(-7, fieldValue);
/* 1169 */             setDisallowOrder((Boolean)value);
/* 1170 */           } catch (Exception ee) {
/* 1171 */             throw new DtxException("An exception occurred while calling setDisallowOrder() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*      */           } 
/*      */ 
/*      */         
/*      */         case "DisallowRainCheck":
/*      */           try {
/* 1177 */             Object value = DaoUtils.getFieldValueForXmlString(-7, fieldValue);
/* 1178 */             setDisallowRainCheck((Boolean)value);
/* 1179 */           } catch (Exception ee) {
/* 1180 */             throw new DtxException("An exception occurred while calling setDisallowRainCheck() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*      */           } 
/*      */ 
/*      */         
/*      */         case "ForceQuantityOfOne":
/*      */           try {
/* 1186 */             Object value = DaoUtils.getFieldValueForXmlString(-7, fieldValue);
/* 1187 */             setForceQuantityOfOne((Boolean)value);
/* 1188 */           } catch (Exception ee) {
/* 1189 */             throw new DtxException("An exception occurred while calling setForceQuantityOfOne() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*      */           } 
/*      */ 
/*      */         
/*      */         case "MaximumSaleUnitCount":
/*      */           try {
/* 1195 */             Object value = DaoUtils.getFieldValueForXmlString(3, fieldValue);
/* 1196 */             setMaximumSaleUnitCount((BigDecimal)value);
/* 1197 */           } catch (Exception ee) {
/* 1198 */             throw new DtxException("An exception occurred while calling setMaximumSaleUnitCount() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*      */           } 
/*      */ 
/*      */         
/*      */         case "MinimumSaleUnitCount":
/*      */           try {
/* 1204 */             Object value = DaoUtils.getFieldValueForXmlString(3, fieldValue);
/* 1205 */             setMinimumSaleUnitCount((BigDecimal)value);
/* 1206 */           } catch (Exception ee) {
/* 1207 */             throw new DtxException("An exception occurred while calling setMinimumSaleUnitCount() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*      */           } 
/*      */ 
/*      */         
/*      */         case "NoGiveaways":
/*      */           try {
/* 1213 */             Object value = DaoUtils.getFieldValueForXmlString(-7, fieldValue);
/* 1214 */             setNoGiveaways((Boolean)value);
/* 1215 */           } catch (Exception ee) {
/* 1216 */             throw new DtxException("An exception occurred while calling setNoGiveaways() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*      */           } 
/*      */ 
/*      */         
/*      */         case "NotReturnable":
/*      */           try {
/* 1222 */             Object value = DaoUtils.getFieldValueForXmlString(-7, fieldValue);
/* 1223 */             setNotReturnable((Boolean)value);
/* 1224 */           } catch (Exception ee) {
/* 1225 */             throw new DtxException("An exception occurred while calling setNotReturnable() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*      */           } 
/*      */ 
/*      */         
/*      */         case "PartNumber":
/*      */           try {
/* 1231 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 1232 */             setPartNumber((String)value);
/* 1233 */           } catch (Exception ee) {
/* 1234 */             throw new DtxException("An exception occurred while calling setPartNumber() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*      */           } 
/*      */ 
/*      */         
/*      */         case "PromptForPrice":
/*      */           try {
/* 1240 */             Object value = DaoUtils.getFieldValueForXmlString(-7, fieldValue);
/* 1241 */             setPromptForPrice((Boolean)value);
/* 1242 */           } catch (Exception ee) {
/* 1243 */             throw new DtxException("An exception occurred while calling setPromptForPrice() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*      */           } 
/*      */ 
/*      */         
/*      */         case "PromptForQuantity":
/*      */           try {
/* 1249 */             Object value = DaoUtils.getFieldValueForXmlString(-7, fieldValue);
/* 1250 */             setPromptForQuantity((Boolean)value);
/* 1251 */           } catch (Exception ee) {
/* 1252 */             throw new DtxException("An exception occurred while calling setPromptForQuantity() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*      */           } 
/*      */ 
/*      */         
/*      */         case "PromptForDescription":
/*      */           try {
/* 1258 */             Object value = DaoUtils.getFieldValueForXmlString(-7, fieldValue);
/* 1259 */             setPromptForDescription((Boolean)value);
/* 1260 */           } catch (Exception ee) {
/* 1261 */             throw new DtxException("An exception occurred while calling setPromptForDescription() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*      */           } 
/*      */ 
/*      */         
/*      */         case "PromptForCustomer":
/*      */           try {
/* 1267 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 1268 */             setPromptForCustomer((String)value);
/* 1269 */           } catch (Exception ee) {
/* 1270 */             throw new DtxException("An exception occurred while calling setPromptForCustomer() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*      */           } 
/*      */ 
/*      */         
/*      */         case "RestockingFee":
/*      */           try {
/* 1276 */             Object value = DaoUtils.getFieldValueForXmlString(3, fieldValue);
/* 1277 */             setRestockingFee((BigDecimal)value);
/* 1278 */           } catch (Exception ee) {
/* 1279 */             throw new DtxException("An exception occurred while calling setRestockingFee() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*      */           } 
/*      */ 
/*      */         
/*      */         case "SeasonCode":
/*      */           try {
/* 1285 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 1286 */             setSeasonCode((String)value);
/* 1287 */           } catch (Exception ee) {
/* 1288 */             throw new DtxException("An exception occurred while calling setSeasonCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*      */           } 
/*      */ 
/*      */         
/*      */         case "SubstituteAvailable":
/*      */           try {
/* 1294 */             Object value = DaoUtils.getFieldValueForXmlString(-7, fieldValue);
/* 1295 */             setSubstituteAvailable((Boolean)value);
/* 1296 */           } catch (Exception ee) {
/* 1297 */             throw new DtxException("An exception occurred while calling setSubstituteAvailable() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*      */           } 
/*      */ 
/*      */         
/*      */         case "UnitCost":
/*      */           try {
/* 1303 */             Object value = DaoUtils.getFieldValueForXmlString(3, fieldValue);
/* 1304 */             setUnitCost((BigDecimal)value);
/* 1305 */           } catch (Exception ee) {
/* 1306 */             throw new DtxException("An exception occurred while calling setUnitCost() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*      */           } 
/*      */ 
/*      */         
/*      */         case "VendorId":
/*      */           try {
/* 1312 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 1313 */             setVendorId((String)value);
/* 1314 */           } catch (Exception ee) {
/* 1315 */             throw new DtxException("An exception occurred while calling setVendorId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*      */           } 
/*      */ 
/*      */         
/*      */         case "SpecialOrderLeadDays":
/*      */           try {
/* 1321 */             Object value = DaoUtils.getFieldValueForXmlString(4, fieldValue);
/* 1322 */             setSpecialOrderLeadDays((Integer)value);
/* 1323 */           } catch (Exception ee) {
/* 1324 */             throw new DtxException("An exception occurred while calling setSpecialOrderLeadDays() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*      */           } 
/*      */ 
/*      */         
/*      */         case "QtyScale":
/*      */           try {
/* 1330 */             Object value = DaoUtils.getFieldValueForXmlString(4, fieldValue);
/* 1331 */             setQtyScale((Integer)value);
/* 1332 */           } catch (Exception ee) {
/* 1333 */             throw new DtxException("An exception occurred while calling setQtyScale() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*      */           } 
/*      */ 
/*      */         
/*      */         case "Messages":
/*      */           try {
/* 1339 */             Object value = DaoUtils.getFieldValueForXmlString(-7, fieldValue);
/* 1340 */             setMessages((Boolean)value);
/* 1341 */           } catch (Exception ee) {
/* 1342 */             throw new DtxException("An exception occurred while calling setMessages() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*      */           } 
/*      */ 
/*      */         
/*      */         case "UnitOfMeasureCode":
/*      */           try {
/* 1348 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 1349 */             setUnitOfMeasureCode((String)value);
/* 1350 */           } catch (Exception ee) {
/* 1351 */             throw new DtxException("An exception occurred while calling setUnitOfMeasureCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*      */           } 
/*      */ 
/*      */         
/*      */         case "TaxGroupId":
/*      */           try {
/* 1357 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 1358 */             setTaxGroupId((String)value);
/* 1359 */           } catch (Exception ee) {
/* 1360 */             throw new DtxException("An exception occurred while calling setTaxGroupId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*      */           } 
/*      */ 
/*      */         
/*      */         case "Warranty":
/*      */           try {
/* 1366 */             Object value = DaoUtils.getFieldValueForXmlString(-7, fieldValue);
/* 1367 */             setWarranty((Boolean)value);
/* 1368 */           } catch (Exception ee) {
/* 1369 */             throw new DtxException("An exception occurred while calling setWarranty() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*      */           } 
/*      */ 
/*      */         
/*      */         case "GenericItem":
/*      */           try {
/* 1375 */             Object value = DaoUtils.getFieldValueForXmlString(-7, fieldValue);
/* 1376 */             setGenericItem((Boolean)value);
/* 1377 */           } catch (Exception ee) {
/* 1378 */             throw new DtxException("An exception occurred while calling setGenericItem() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*      */           } 
/*      */ 
/*      */         
/*      */         case "CurrentSalePrice":
/*      */           try {
/* 1384 */             Object value = DaoUtils.getFieldValueForXmlString(3, fieldValue);
/* 1385 */             setCurrentSalePrice((BigDecimal)value);
/* 1386 */           } catch (Exception ee) {
/* 1387 */             throw new DtxException("An exception occurred while calling setCurrentSalePrice() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*      */           } 
/*      */ 
/*      */         
/*      */         case "InitialSaleQuantity":
/*      */           try {
/* 1393 */             Object value = DaoUtils.getFieldValueForXmlString(3, fieldValue);
/* 1394 */             setInitialSaleQuantity((BigDecimal)value);
/* 1395 */           } catch (Exception ee) {
/* 1396 */             throw new DtxException("An exception occurred while calling setInitialSaleQuantity() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*      */           } 
/*      */ 
/*      */         
/*      */         case "DispositionCode":
/*      */           try {
/* 1402 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 1403 */             setDispositionCode((String)value);
/* 1404 */           } catch (Exception ee) {
/* 1405 */             throw new DtxException("An exception occurred while calling setDispositionCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*      */           } 
/*      */ 
/*      */         
/*      */         case "ItemAvailabilityCode":
/*      */           try {
/* 1411 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 1412 */             setItemAvailabilityCode((String)value);
/* 1413 */           } catch (Exception ee) {
/* 1414 */             throw new DtxException("An exception occurred while calling setItemAvailabilityCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*      */           } 
/*      */ 
/*      */         
/*      */         case "MinAgeRequired":
/*      */           try {
/* 1420 */             Object value = DaoUtils.getFieldValueForXmlString(4, fieldValue);
/* 1421 */             setMinAgeRequired((Integer)value);
/* 1422 */           } catch (Exception ee) {
/* 1423 */             throw new DtxException("An exception occurred while calling setMinAgeRequired() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*      */           } 
/*      */ 
/*      */         
/*      */         case "StockStatus":
/*      */           try {
/* 1429 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 1430 */             setStockStatus((String)value);
/* 1431 */           } catch (Exception ee) {
/* 1432 */             throw new DtxException("An exception occurred while calling setStockStatus() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*      */           } 
/*      */ 
/*      */         
/*      */         case "FoodStampEligible":
/*      */           try {
/* 1438 */             Object value = DaoUtils.getFieldValueForXmlString(-7, fieldValue);
/* 1439 */             setFoodStampEligible((Boolean)value);
/* 1440 */           } catch (Exception ee) {
/* 1441 */             throw new DtxException("An exception occurred while calling setFoodStampEligible() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*      */           } 
/*      */ 
/*      */         
/*      */         case "ShippingWeight":
/*      */           try {
/* 1447 */             Object value = DaoUtils.getFieldValueForXmlString(3, fieldValue);
/* 1448 */             setShippingWeight((BigDecimal)value);
/* 1449 */           } catch (Exception ee) {
/* 1450 */             throw new DtxException("An exception occurred while calling setShippingWeight() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*      */           } 
/*      */ 
/*      */         
/*      */         case "PackSize":
/*      */           try {
/* 1456 */             Object value = DaoUtils.getFieldValueForXmlString(3, fieldValue);
/* 1457 */             setPackSize((BigDecimal)value);
/* 1458 */           } catch (Exception ee) {
/* 1459 */             throw new DtxException("An exception occurred while calling setPackSize() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*      */           } 
/*      */ 
/*      */         
/*      */         case "DefaultSourceType":
/*      */           try {
/* 1465 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 1466 */             setDefaultSourceType((String)value);
/* 1467 */           } catch (Exception ee) {
/* 1468 */             throw new DtxException("An exception occurred while calling setDefaultSourceType() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*      */           } 
/*      */ 
/*      */         
/*      */         case "DefaultSourceId":
/*      */           try {
/* 1474 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 1475 */             setDefaultSourceId((String)value);
/* 1476 */           } catch (Exception ee) {
/* 1477 */             throw new DtxException("An exception occurred while calling setDefaultSourceId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*      */           } 
/*      */ 
/*      */         
/*      */         case "SellingGroupId":
/*      */           try {
/* 1483 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 1484 */             setSellingGroupId((String)value);
/* 1485 */           } catch (Exception ee) {
/* 1486 */             throw new DtxException("An exception occurred while calling setSellingGroupId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*      */           } 
/*      */ 
/*      */         
/*      */         case "ExcludeFromNetSales":
/*      */           try {
/* 1492 */             Object value = DaoUtils.getFieldValueForXmlString(-7, fieldValue);
/* 1493 */             setExcludeFromNetSales((Boolean)value);
/* 1494 */           } catch (Exception ee) {
/* 1495 */             throw new DtxException("An exception occurred while calling setExcludeFromNetSales() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*      */           } 
/*      */ 
/*      */         
/*      */         case "FiscalItemId":
/*      */           try {
/* 1501 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 1502 */             setFiscalItemId((String)value);
/* 1503 */           } catch (Exception ee) {
/* 1504 */             throw new DtxException("An exception occurred while calling setFiscalItemId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*      */           } 
/*      */ 
/*      */         
/*      */         case "FiscalItemDescription":
/*      */           try {
/* 1510 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 1511 */             setFiscalItemDescription((String)value);
/* 1512 */           } catch (Exception ee) {
/* 1513 */             throw new DtxException("An exception occurred while calling setFiscalItemDescription() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*      */           } 
/*      */ 
/*      */         
/*      */         case "ExternalSystem":
/*      */           try {
/* 1519 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 1520 */             setExternalSystem((String)value);
/* 1521 */           } catch (Exception ee) {
/* 1522 */             throw new DtxException("An exception occurred while calling setExternalSystem() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*      */           } 
/*      */ 
/*      */         
/*      */         case "TareValue":
/*      */           try {
/* 1528 */             Object value = DaoUtils.getFieldValueForXmlString(3, fieldValue);
/* 1529 */             setTareValue((BigDecimal)value);
/* 1530 */           } catch (Exception ee) {
/* 1531 */             throw new DtxException("An exception occurred while calling setTareValue() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*      */           } 
/*      */ 
/*      */         
/*      */         case "TareUnitOfMeasureCode":
/*      */           try {
/* 1537 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 1538 */             setTareUnitOfMeasureCode((String)value);
/* 1539 */           } catch (Exception ee) {
/* 1540 */             throw new DtxException("An exception occurred while calling setTareUnitOfMeasureCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*      */           } 
/*      */       } 
/*      */     } 
/*      */   }
/*      */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\itm\impl\ItemOptionsDAO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */