/*    */ package dtv.xst.pricing.coupon;
/*    */ 
/*    */ import dtv.xst.dao.trl.RetailPriceModifierReasonCode;
/*    */ import dtv.xst.pricing.XSTPricingDescriptor;
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
/*    */ 
/*    */ 
/*    */ public class ManufacturerCouponPricingDescriptor
/*    */   extends XSTPricingDescriptor
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   private final CouponValueConfig config_;
/*    */   
/*    */   public ManufacturerCouponPricingDescriptor(CouponValueConfig argConfig, String argManufacturer) {
/* 27 */     super(argConfig.getDealId(argManufacturer), RetailPriceModifierReasonCode.MANUFACTURER_COUPON, argConfig
/*    */         
/* 29 */         .getDealDescription(argManufacturer), argConfig
/* 30 */         .getTaxabilityCode());
/* 31 */     this.config_ = argConfig;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public CouponValueConfig getConfig() {
/* 39 */     return this.config_;
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\pricing\coupon\ManufacturerCouponPricingDescriptor.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */