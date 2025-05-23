/*     */ package dtv.xst.query.results;
/*     */ 
/*     */ import dtv.data2.access.AbstractQueryResult;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.IOverridableOrgHierarchyResult;
/*     */ import dtv.xst.dao.itm.ItemId;
/*     */ import dtv.xst.dao.trl.SaleItemType;
/*     */ import java.math.BigDecimal;
/*     */ import java.util.Date;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class CustomerTransHistoryResult
/*     */   extends AbstractQueryResult
/*     */   implements IOverridableOrgHierarchyResult
/*     */ {
/*     */   private static final long serialVersionUID = 8675309L;
/*     */   private Long lineItemSeq_;
/*     */   private String retailLocationId_;
/*     */   private String workstationId_;
/*     */   private Boolean returnFlag_;
/*     */   private Boolean excludeFromNetSalesFlag_;
/*     */   private Date transDate_;
/*     */   private Long transSeq_;
/*     */   private String saleItemType_;
/*     */   private String itemDescription_;
/*     */   private String itemId_;
/*     */   private BigDecimal qty_;
/*     */   private BigDecimal price_;
/*     */   private String associates_;
/*     */   private String vendorId_;
/*     */   private String vendorName_;
/*     */   private String serialNumber_;
/*     */   private String locationType_;
/*     */   private String typeCode_;
/*     */   private String custAcctId_;
/*     */   private String custAcctCode_;
/*     */   private String custAcctStatCode_;
/*     */   private String orderType_;
/*     */   private String nonPhysTypCode_;
/*     */   private String _itemOptionsLevelCode;
/*     */   private String _itemOptionsLevelValue;
/*  50 */   private Boolean _warrantied = Boolean.FALSE;
/*     */ 
/*     */ 
/*     */   
/*     */   private Date _beginDateTimestamp;
/*     */ 
/*     */ 
/*     */   
/*     */   public String getAssociates() {
/*  59 */     return this.associates_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getBeginDateTimestamp() {
/*  68 */     return this._beginDateTimestamp;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public Date getBusinessDate() {
/*  78 */     return getTransactionDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getCustAcctCode() {
/*  87 */     return this.custAcctCode_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getCustAcctId() {
/*  96 */     return this.custAcctId_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getCustAcctStatCode() {
/* 105 */     return this.custAcctStatCode_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Boolean getExcludeFromNetSalesFlag() {
/* 114 */     return this.excludeFromNetSalesFlag_;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IObjectId getFilteringObjectId() {
/* 120 */     ItemId id = new ItemId();
/* 121 */     id.setItemId(getItemId());
/* 122 */     return (IObjectId)id;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getItemDescription() {
/* 131 */     return this.itemDescription_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getItemId() {
/* 140 */     return this.itemId_;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getLevelCode() {
/* 146 */     return this._itemOptionsLevelCode;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getLevelValue() {
/* 152 */     return this._itemOptionsLevelValue;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Long getLineItemSeq() {
/* 161 */     return this.lineItemSeq_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getLocationType() {
/* 170 */     return this.locationType_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getNonPhysTypeCode() {
/* 179 */     return this.nonPhysTypCode_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getOrderType() {
/* 188 */     return this.orderType_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BigDecimal getPrice() {
/* 197 */     return this.price_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BigDecimal getQty() {
/* 206 */     return this.qty_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getRetailLocationId() {
/* 215 */     return this.retailLocationId_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Boolean getReturnFlag() {
/* 224 */     return this.returnFlag_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSaleItemType() {
/* 233 */     if (this.returnFlag_.booleanValue()) {
/* 234 */       return SaleItemType.RETURN.getName();
/*     */     }
/*     */     
/* 237 */     return this.saleItemType_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSerialNumber() {
/* 247 */     return this.serialNumber_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getTransactionDate() {
/* 256 */     return this.transDate_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Long getTransSeq() {
/* 265 */     return this.transSeq_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getTypeCode() {
/* 274 */     return this.typeCode_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getVendorId() {
/* 283 */     return this.vendorId_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getVendorName() {
/* 292 */     return this.vendorName_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Boolean getWarrantied() {
/* 301 */     return this._warrantied;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWorkstationId() {
/* 310 */     return this.workstationId_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setAssociates(String associates) {
/* 319 */     this.associates_ = associates;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setBeginDateTimestamp(Date argBeginDateTimestamp) {
/* 328 */     this._beginDateTimestamp = argBeginDateTimestamp;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCustAcctCode(String custAcctCode) {
/* 337 */     this.custAcctCode_ = custAcctCode;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCustAcctId(String custAcctId) {
/* 346 */     this.custAcctId_ = custAcctId;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCustAcctStatCode(String custAcctStatCode) {
/* 355 */     this.custAcctStatCode_ = custAcctStatCode;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setExcludeFromNetSalesFlag(Boolean argExcludeFromNetSalesFlag) {
/* 364 */     this.excludeFromNetSalesFlag_ = argExcludeFromNetSalesFlag;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setItemDescription(String desc) {
/* 373 */     this.itemDescription_ = desc;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setItemId(String id) {
/* 382 */     this.itemId_ = id;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setLevelCode(String argLevelCode) {
/* 391 */     this._itemOptionsLevelCode = argLevelCode;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setLevelValue(String argLevelValue) {
/* 400 */     this._itemOptionsLevelValue = argLevelValue;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setLineItemSeq(Long seq) {
/* 409 */     this.lineItemSeq_ = seq;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setLocationType(String argLocationType) {
/* 418 */     this.locationType_ = argLocationType;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setNonPhysTypeCode(String nonPhysTypeCode) {
/* 427 */     this.nonPhysTypCode_ = nonPhysTypeCode;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setOrderType(String orderType) {
/* 436 */     this.orderType_ = orderType;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setPrice(BigDecimal price) {
/* 445 */     this.price_ = price;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setQty(BigDecimal qty) {
/* 454 */     this.qty_ = qty;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRetailLocationId(String type) {
/* 463 */     this.retailLocationId_ = type;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setReturnFlag(Boolean flag) {
/* 472 */     this.returnFlag_ = flag;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setSaleItemType(String type) {
/* 481 */     this.saleItemType_ = type;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setSerialNumber(String argSerialNumber) {
/* 490 */     this.serialNumber_ = argSerialNumber;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTransactionDate(Date date) {
/* 499 */     this.transDate_ = date;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTransSeq(Long seq) {
/* 508 */     this.transSeq_ = seq;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTypeCode(String typeCode) {
/* 517 */     this.typeCode_ = typeCode;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setVendorId(String argVendorId) {
/* 526 */     this.vendorId_ = argVendorId;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setVendorName(String argVendorName) {
/* 535 */     this.vendorName_ = argVendorName;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setWarrantied(Boolean argWarrantied) {
/* 544 */     this._warrantied = argWarrantied;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setWorkstationId(String type) {
/* 553 */     this.workstationId_ = type;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected IObjectId getObjectIdImpl() {
/* 559 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\query\results\CustomerTransHistoryResult.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */