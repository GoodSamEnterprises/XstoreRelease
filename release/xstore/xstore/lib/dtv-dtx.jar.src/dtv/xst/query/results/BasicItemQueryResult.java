/*     */ package dtv.xst.query.results;
/*     */ 
/*     */ import dtv.data2.access.AbstractQueryResult;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.xst.dao.itm.ItemId;
/*     */ import java.math.BigDecimal;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class BasicItemQueryResult
/*     */   extends AbstractQueryResult
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   private String itemId_;
/*     */   private String description_;
/*     */   private String parentItemId_;
/*     */   private String dimension1_;
/*     */   private String dimension2_;
/*     */   private String dimension3_;
/*     */   private BigDecimal currentShelfPrice_;
/*     */   private String vendorId_;
/*     */   private String vendorName_;
/*     */   private String partNumber_;
/*     */   private String stockStatus_;
/*     */   private String defaultSourceType_;
/*     */   private String defaultSourceId_;
/*     */   private String itemMatrixColor_;
/*     */   private BigDecimal inventoryCount_;
/*     */   private String _availabilityCode;
/*     */   private String _imageUrl;
/*     */   
/*     */   public String getAvailabilityCode() {
/*  47 */     return this._availabilityCode;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BigDecimal getCurrentShelfPrice() {
/*  56 */     return this.currentShelfPrice_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getDefaultSourceId() {
/*  65 */     return this.defaultSourceId_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getDefaultSourceType() {
/*  74 */     return this.defaultSourceType_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getDescription() {
/*  83 */     return this.description_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getDimension1() {
/*  92 */     return this.dimension1_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getDimension2() {
/* 101 */     return this.dimension2_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getDimension3() {
/* 110 */     return this.dimension3_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getImageUrl() {
/* 119 */     return this._imageUrl;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BigDecimal getInventoryCount() {
/* 128 */     return this.inventoryCount_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getItemId() {
/* 137 */     return this.itemId_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getItemMatrixColor() {
/* 146 */     return this.itemMatrixColor_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getParentItemId() {
/* 155 */     return this.parentItemId_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getPartNumber() {
/* 164 */     return this.partNumber_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getStockStatus() {
/* 173 */     return this.stockStatus_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getVendorId() {
/* 182 */     return this.vendorId_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getVendorName() {
/* 191 */     return this.vendorName_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setAvailabilityCode(String argAvailabilityCode) {
/* 200 */     this._availabilityCode = argAvailabilityCode;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCurrentShelfPrice(BigDecimal argCurrentShelfPrice) {
/* 209 */     this.currentShelfPrice_ = argCurrentShelfPrice;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDefaultSourceId(String argDefaultSourceId) {
/* 218 */     this.defaultSourceId_ = argDefaultSourceId;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDefaultSourceType(String argDefaultSourceType) {
/* 227 */     this.defaultSourceType_ = argDefaultSourceType;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDescription(String argDescription) {
/* 236 */     this.description_ = argDescription;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDimension1(String argDimension1) {
/* 245 */     this.dimension1_ = argDimension1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDimension2(String argDimension2) {
/* 254 */     this.dimension2_ = argDimension2;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDimension3(String argDimension3) {
/* 263 */     this.dimension3_ = argDimension3;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setImageUrl(String argImageUrl) {
/* 272 */     this._imageUrl = argImageUrl;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setInventoryCount(BigDecimal count) {
/* 281 */     this.inventoryCount_ = count;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setItemId(String argItemId) {
/* 290 */     this.itemId_ = argItemId;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setItemMatrixColor(String argItemMatrixColor) {
/* 299 */     this.itemMatrixColor_ = argItemMatrixColor;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setParentItemId(String argParentItemId) {
/* 308 */     this.parentItemId_ = argParentItemId;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setPartNumber(String argPartNumber) {
/* 317 */     this.partNumber_ = argPartNumber;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setStockStatus(String argStockStatus) {
/* 326 */     this.stockStatus_ = argStockStatus;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setVendorId(String argVendorId) {
/* 335 */     this.vendorId_ = argVendorId;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setVendorName(String argVendorName) {
/* 344 */     this.vendorName_ = argVendorName;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected IObjectId getObjectIdImpl() {
/* 350 */     ItemId id = new ItemId();
/* 351 */     id.setItemId(getItemId());
/* 352 */     return (IObjectId)id;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\query\results\BasicItemQueryResult.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */