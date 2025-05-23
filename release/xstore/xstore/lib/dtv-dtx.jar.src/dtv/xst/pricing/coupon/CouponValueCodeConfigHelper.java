/*    */ package dtv.xst.pricing.coupon;
/*    */ 
/*    */ import dtv.util.config.ConfigHelper;
/*    */ import dtv.util.config.IConfigObject;
/*    */ import dtv.xst.pricing.XSTPricingAdapter;
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
/*    */ public class CouponValueCodeConfigHelper
/*    */   extends ConfigHelper<CouponsConfig>
/*    */ {
/*    */   private final XSTPricingAdapter _adapter;
/*    */   
/*    */   public CouponValueCodeConfigHelper(XSTPricingAdapter argAdapter) {
/* 27 */     this._adapter = argAdapter;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected String getConfigFileName() {
/* 33 */     return "CouponValueConfig";
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected IConfigObject getConfigObject(String argTagName, String argDtype, String argSourceDescription) {
/* 39 */     if ("CouponValue".equalsIgnoreCase(argDtype)) {
/* 40 */       return (IConfigObject)new CouponValueConfig(this._adapter);
/*    */     }
/* 42 */     if ("Coupons".equalsIgnoreCase(argDtype)) {
/* 43 */       return (IConfigObject)new CouponsConfig();
/*    */     }
/* 45 */     return super.getConfigObject(argTagName, argDtype, argSourceDescription);
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\pricing\coupon\CouponValueCodeConfigHelper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */