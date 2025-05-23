/*     */ package dtv.xst.query.results;
/*     */ 
/*     */ import dtv.data2.access.AbstractQueryResult;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.util.address.IAddress;
/*     */ import dtv.util.distance.Distance;
/*     */ import dtv.xst.dao.itm.ItemId;
/*     */ import dtv.xst.daocommon.ILocationModifier;
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
/*     */ public class InventoryLocatorResult
/*     */   extends AbstractQueryResult
/*     */   implements ILocationModifier, IAddress
/*     */ {
/*     */   private static final long serialVersionUID = 8675309L;
/*     */   private long organizationId_;
/*     */   private String itemId_;
/*     */   private String description_;
/*     */   private Long retailLocationId_;
/*     */   private Long unitCount_;
/*     */   private String storeName_;
/*     */   private String address1_;
/*     */   private String address2_;
/*     */   private String city_;
/*     */   private String state_;
/*     */   private String postalCode_;
/*     */   private String country_;
/*     */   private String telephone1_;
/*     */   private String telephone2_;
/*     */   private String telephone3_;
/*     */   private String telephone4_;
/*     */   private Distance distance_;
/*     */   private String dimension1_;
/*     */   private String dimension2_;
/*     */   private String dimension3_;
/*     */   private String dimension4_;
/*     */   private String dimension5_;
/*     */   private BigDecimal latitude_;
/*     */   private BigDecimal longitude_;
/*     */   private String storeManager_;
/*     */   
/*     */   public String getAddress1() {
/*  56 */     return this.address1_;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getAddress2() {
/*  62 */     return this.address2_;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getAddress3() {
/*  68 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getAddress4() {
/*  74 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getApartment() {
/*  80 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getCity() {
/*  86 */     return this.city_;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getCountry() {
/*  92 */     return this.country_;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getCounty() {
/*  98 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getDescription() {
/* 107 */     return this.description_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getDimension1() {
/* 116 */     return this.dimension1_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getDimension2() {
/* 125 */     return this.dimension2_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getDimension3() {
/* 134 */     return this.dimension3_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getDimension4() {
/* 143 */     return this.dimension4_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getDimension5() {
/* 152 */     return this.dimension5_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Distance getDistance() {
/* 161 */     return this.distance_;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getEmailAddress() {
/* 167 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getItemId() {
/* 176 */     return this.itemId_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BigDecimal getLatitude() {
/* 185 */     return this.latitude_;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IAddress getLocationAddress() {
/* 191 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getLocationId() {
/* 197 */     return (this.retailLocationId_ != null) ? String.valueOf(this.retailLocationId_) : null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getLocationName1() {
/* 203 */     return this.storeName_;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getLocationName2() {
/* 209 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BigDecimal getLongitude() {
/* 218 */     return this.longitude_;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getNeighborhood() {
/* 224 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getOrganizationId() {
/* 233 */     return this.organizationId_;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getPostalCode() {
/* 239 */     return this.postalCode_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Long getRetailLocationId() {
/* 248 */     return this.retailLocationId_;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getState() {
/* 254 */     if (this.state_ == null) {
/* 255 */       return " ";
/*     */     }
/* 257 */     return this.state_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getStoreManager() {
/* 266 */     return this.storeManager_;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getTelephone1() {
/* 272 */     return this.telephone1_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getTelephone2() {
/* 281 */     return this.telephone2_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getTelephone3() {
/* 290 */     return this.telephone3_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getTelephone4() {
/* 299 */     return this.telephone4_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Long getUnitCount() {
/* 308 */     return this.unitCount_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setAddress1(String argAddress1) {
/* 317 */     this.address1_ = argAddress1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setAddress2(String argAddress2) {
/* 326 */     this.address2_ = argAddress2;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCity(String argCity) {
/* 335 */     this.city_ = argCity;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCountry(String argCountry) {
/* 344 */     this.country_ = argCountry;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDescription(String argDescription) {
/* 353 */     this.description_ = argDescription;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDimension1(String argDimension1) {
/* 362 */     this.dimension1_ = argDimension1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDimension2(String argDimension2) {
/* 371 */     this.dimension2_ = argDimension2;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDimension3(String argDimension3) {
/* 380 */     this.dimension3_ = argDimension3;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDimension4(String argDimension4) {
/* 389 */     this.dimension4_ = argDimension4;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDimension5(String argDimension5) {
/* 398 */     this.dimension5_ = argDimension5;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDistance(Distance argDistance) {
/* 407 */     this.distance_ = argDistance;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setItemId(String argItemId) {
/* 416 */     this.itemId_ = argItemId;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setLatitude(BigDecimal argLatitude) {
/* 425 */     this.latitude_ = argLatitude;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setLongitude(BigDecimal argLongitude) {
/* 434 */     this.longitude_ = argLongitude;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setOrganizationId(long argOrganizationId) {
/* 443 */     this.organizationId_ = argOrganizationId;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setPostalCode(String argPostalCode) {
/* 452 */     this.postalCode_ = argPostalCode;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRetailLocationId(Long argRetailLocationId) {
/* 461 */     this.retailLocationId_ = argRetailLocationId;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setState(String argState) {
/* 470 */     this.state_ = argState;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setStoreManager(String argStoreManager) {
/* 479 */     this.storeManager_ = argStoreManager;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setStoreName(String argStoreName) {
/* 488 */     this.storeName_ = argStoreName;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTelephone1(String argTelephone1) {
/* 497 */     this.telephone1_ = argTelephone1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTelephone2(String argTelephone2) {
/* 506 */     this.telephone2_ = argTelephone2;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTelephone3(String argTelephone3) {
/* 515 */     this.telephone3_ = argTelephone3;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTelephone4(String argTelephone4) {
/* 524 */     this.telephone4_ = argTelephone4;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUnitCount(Long argUnitCount) {
/* 533 */     this.unitCount_ = argUnitCount;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected IObjectId getObjectIdImpl() {
/* 539 */     ItemId itemId = new ItemId();
/* 540 */     itemId.setOrganizationId(Long.valueOf(this.organizationId_));
/* 541 */     itemId.setItemId(this.itemId_);
/*     */     
/* 543 */     return (IObjectId)itemId;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\query\results\InventoryLocatorResult.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */