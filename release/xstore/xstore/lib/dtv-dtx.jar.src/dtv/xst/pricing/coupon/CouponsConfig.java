/*    */ package dtv.xst.pricing.coupon;
/*    */ 
/*    */ import dtv.util.config.AbstractParentConfig;
/*    */ import dtv.util.config.IConfigObject;
/*    */ import java.util.Collection;
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ import org.apache.log4j.Logger;
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
/*    */ public class CouponsConfig
/*    */   extends AbstractParentConfig
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/* 24 */   private static final Logger logger_ = Logger.getLogger(CouponsConfig.class);
/*    */   
/* 26 */   private final Map<String, CouponValueConfig> valueMap_ = new HashMap<>();
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public CouponValueConfig getCouponValueConfig(String argCodeKey) {
/* 35 */     CouponValueConfig config = this.valueMap_.get(argCodeKey);
/* 36 */     if (config == null) {
/* 37 */       logger_.warn("no coupon value '" + argCodeKey + "':" + getSourceDescription());
/* 38 */       return null;
/*    */     } 
/* 40 */     if (!config.isEnabled()) {
/* 41 */       return null;
/*    */     }
/* 43 */     return config;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public Collection<CouponValueConfig> getManufacturersCouponValues() {
/* 52 */     return this.valueMap_.values();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void setConfigObject(String argKey, IConfigObject argValue) {
/* 58 */     if (argValue instanceof CouponValueConfig) {
/* 59 */       CouponValueConfig value = (CouponValueConfig)argValue;
/* 60 */       if (value.getCode() == null) {
/* 61 */         logger_.warn("invalid configuration; null code ::" + value.getSourceDescription());
/*    */       } else {
/*    */         
/* 64 */         this.valueMap_.put(value.getCode(), value);
/*    */       } 
/*    */     } else {
/*    */       
/* 68 */       warnUnsupported(argKey, argValue);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\pricing\coupon\CouponsConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */